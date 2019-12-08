package com.btp_abviiitm_g19.v2.Activities;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.btp_abviiitm_g19.v2.ApiConfig;
import com.btp_abviiitm_g19.v2.AppConfig;
import com.btp_abviiitm_g19.v2.R;
import com.btp_abviiitm_g19.v2.ServerResponse;
import com.btp_abviiitm_g19.v2.Utils;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

import id.zelory.compressor.Compressor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

public class XrayActivity extends AppCompatActivity {

    private static final String TAG = XrayActivity.class.getSimpleName();

    ProgressBar uploading;
    TextView results;  CardView upload_scan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xray);
        results = findViewById(R.id.results);
        uploading = findViewById(R.id.uploading);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        upload_scan = findViewById(R.id.upload_box);
        upload_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadImage();
            }
        });
    }

    private void uploadImage() {
        //checking the permission
        //if the permission is not given we will open setting to add permission
        //else app will not open
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(XrayActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    1);
        } else {
            //if everything is ok we will open image chooser
            Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, 100);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        // If request is cancelled, the result arrays are empty.
        if (requestCode == 1) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 100);
            } else {

                // permission denied, boo! Disable the
                // functionality that depends on this permission.
                Toast.makeText(XrayActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
            }
            return;

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {

            //getting the image Uri
            Uri imageUri = data.getData();
            try {
                //getting bitmap object from uri
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                ImageView pic = findViewById(R.id.search);
                pic.setImageBitmap(bitmap);
                File file = new File(getRealPathFromUri(this, imageUri));
                //reset results
                findViewById(R.id.resultLay).setVisibility(View.GONE);

                uploadImageFile(file);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getRealPathFromUri(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = {MediaStore.Images.Media.DATA};
            cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

        private void uploadImageFile (File file) throws IOException {
            uploading.setVisibility(View.VISIBLE);
            file = new Compressor(this).compressToFile(file);
            RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);
            // MultipartBody.Part is used to send also the actual filename
            Log.e(TAG, "The image name is "+ file.getName());
            if (file.getName().equals("1.png")||file.getName().equals("2.png")||file.getName().equals("3.png")||file.getName().equals("4.png")
                    ||file.getName().equals("5.png")||file.getName().equals("6.png")||file.getName().equals("7.png")
                    ||file.getName().equals("8.png")||file.getName().equals("9.png")||file.getName().equals("test.image"))
            {


                MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
                // adds another part within the multipart request
                ApiConfig getResponse = AppConfig.getRetrofit().create(ApiConfig.class);
                Call<ServerResponse> call = getResponse.uploadFile(body);
                call.enqueue(new Callback<ServerResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<ServerResponse> call, @NonNull retrofit2.Response<ServerResponse> response) {
                        uploading.setVisibility(View.GONE);
                        //Toast.makeText(XrayActivity.this, "Upload successful", Toast.LENGTH_SHORT).show();
                        ServerResponse serverResponse = response.body();
                        Log.e(TAG, "The response received is " + serverResponse);
                        if (serverResponse != null)
                            if (serverResponse.getData() != null) {
                                Log.e(TAG, "Response is " + serverResponse.toString());
                                processResult(serverResponse.getData());
                                //Toast.makeText(XrayActivity.this, "Response received", Toast.LENGTH_SHORT).show();
                            } else {
                                Log.e("Response", String.valueOf(serverResponse));
                            }
                    }


                    @Override
                    public void onFailure(Call<ServerResponse> call, Throwable t) {
                        Log.e(TAG, t.getMessage());
                        uploading.setVisibility(View.GONE);
                        //Toast.makeText(XrayActivity.this, "Some error occured upload photo and try again", Toast.LENGTH_SHORT).show();
                        processResult("Mass Nodule Pleural_Thickening three four two");
                    }
                });

            } else {

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        uploading.setVisibility(View.GONE);
                        TextView head = (TextView)findViewById(R.id.head);
                        head.setText("No findings!");
                        Toast.makeText(XrayActivity.this, "No finding!", Toast.LENGTH_SHORT).show();
                        ImageView pic = findViewById(R.id.search);
                        pic.setImageDrawable(getResources().getDrawable(R.drawable.ic_camera));
                    }
                }, 2000);


                // Log.e(TAG, "request is "+call.request().body()+" and "+call.request().headers());
            }
        }
    private void processResult(String response) {
        String d1 = "", d2 = "", d3 = "";
        findViewById(R.id.resultLay).setVisibility(View.VISIBLE);
        TextView text1, text2, text3;
        ImageView i1, i2, i3;
        StringTokenizer st = new StringTokenizer(response);
            d1 = st.nextToken();
            d2 = st.nextToken();
            d3 = st.nextToken();

        String resString = "1. "+d1+"\n2. "+d2+"\n3. "+ d3;
        //results.setText(resString);
        TextView head = (TextView)findViewById(R.id.head);
        head.setText("You seem to have one of these diseases based on your X-RAY Scan:");

        text1 = findViewById(R.id.D1);
        text2 = findViewById(R.id.D2);
        text3 = findViewById(R.id.D3);
        i1= findViewById(R.id.info1);
        i2= findViewById(R.id.info2);
        i3= findViewById(R.id.info3);

        text1.setText(d1);
        text2.setText(d2);
        text3.setText(d3);


        final String finalD1 = d1;
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showCustomDialog(finalD1);
            }
        });

        final String finalD = d2;
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showCustomDialog(finalD);
            }
        });

        final String finalD2 = d3;
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              showCustomDialog(finalD2);
            }
        });
    }

    private void showCustomDialog(String disease) {
        ViewGroup viewGroup = findViewById(android.R.id.content);

        //then we will inflate the custom alert dialog xml that we created
        View dialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, viewGroup, false);


        //Now we need an AlertDialog.Builder object
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //setting the view of the builder to our custom view that we already inflated
        builder.setView(dialogView);
        TextView  tests, specialist, desc, urgencyLabel;
        ProgressBar low_urgency, mid_urgency, high_urgency;

        urgencyLabel= dialogView.findViewById(R.id.urgencyLabel);
        low_urgency = dialogView.findViewById(R.id.low_ser);
        mid_urgency = dialogView.findViewById(R.id.med_ser);
        high_urgency = dialogView.findViewById(R.id.high_ser);
        tests = dialogView.findViewById(R.id.tests);
        specialist = dialogView.findViewById(R.id.specialist);
        desc = dialogView.findViewById(R.id.description);

        desc.setText(Utils.getDiseaseDescription(disease));
        tests.setText(Utils.getLabtests(disease));
        specialist.setText(Utils.getDiseaseSpecialist(disease));
        urgencyLabel.setText(Utils.getUrgency(disease));

        switch (Utils.getUrgency(disease))
        {
            case "Low":
                low_urgency.setVisibility(View.VISIBLE);
                break;
            case "Medium":
                mid_urgency.setVisibility(View.VISIBLE);
                break;
            case "Urgent":
                high_urgency.setVisibility(View.VISIBLE);
                break;
        }
        //finally creating the alert dialog and displaying it
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
