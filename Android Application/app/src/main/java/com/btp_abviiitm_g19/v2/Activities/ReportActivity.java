package com.btp_abviiitm_g19.v2.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.btp_abviiitm_g19.v2.R;
import com.btp_abviiitm_g19.v2.RetrofitUtils.ApiClient;
import com.btp_abviiitm_g19.v2.RetrofitUtils.ApiInterface;
import com.btp_abviiitm_g19.v2.RetrofitUtils.Model;
import com.btp_abviiitm_g19.v2.Utils;
import com.hootsuite.nachos.NachoTextView;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportActivity extends AppCompatActivity {

    ProgressBar progressBar, progressBar2, low_urgency, mid_urgency, high_urgency;
    private SharedPreferences sharedPreferences;
    TextView results, tests, specialist, desc, urgencyLabel;
    NachoTextView listView;
    LinearLayout extraInfo;
    List<String> mainList;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        urgencyLabel= findViewById(R.id.urgencyLabel);
        low_urgency = findViewById(R.id.low_ser);
        mid_urgency = findViewById(R.id.med_ser);
        high_urgency = findViewById(R.id.high_ser);
        tests = findViewById(R.id.tests);
        specialist = findViewById(R.id.specialist);
        extraInfo = findViewById(R.id.info_extra);
        extraInfo.setVisibility(View.GONE);
        desc = findViewById(R.id.description);
        progressBar = findViewById(R.id.loading);
        progressBar2 = findViewById(R.id.loading_desc);
        listView = findViewById(R.id.listView);
        results = findViewById(R.id.results);
        progressBar.setVisibility(View.VISIBLE);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ReportActivity.this);
        //fill listview


        mainList = new ArrayList<String>();
        mainList.addAll(Objects.requireNonNull(sharedPreferences.getStringSet(Constants.symptoms, null)));
        ListIterator<String> iterator = mainList.listIterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            iterator.set(Utils.remove_(s));
        }

       // adapter a = new adapter(mainList, ReportActivity.this);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                listView.setText(mainList);
            }
        }, 500);


        if(!hardcodedResults())
        predictDisease();

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ReportActivity.this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putStringSet(Constants.symptoms, null).apply();
                finish();
            }
        });
    }

    private boolean hardcodedResults() {
        boolean flag = false;

        Set<String> symptoms = sharedPreferences.getStringSet(Constants.symptoms, null);
       // Hashtable<String, Integer> temps = new Hashtable<>();
       // temps.put()
        if(symptoms!=null&&symptoms.size()>0) {
            if (symptoms.size() == 1) {
                if(symptoms.contains("high_fever")||symptoms.contains("mild_fever")) {
                    flag = true;
                    displayResults("Viral Fever");
                }
                else
                    if(symptoms.contains("stomach_pain"))
                    {
                        flag = true;
                        displayResults("Stomach Flu");
                    }
                 else if(symptoms.contains("cough")||symptoms.contains("running_nose")||symptoms.contains("continuous_sneezing"))
                    {
                        flag = true;
                        displayResults("Common Cold");
                    }
                 else if(symptoms.contains("acidity")||symptoms.contains("indigestion"))
                    {
                        flag = true;
                        displayResults("Acid Reflux");
                    }
                    else if(symptoms.contains("headache"))
                    {
                        flag = true;
                        displayResults("Stress");
                    }
                    else if(symptoms.contains("vomiting"))
                    {
                        flag = true;
                        displayResults("Bulimia");
                    }
                    else flag = false;
                }

            else if(symptoms.size() == 2)
            {
                if(symptoms.contains("mild_fever")&&symptoms.contains("stomach_pain")) {
                    flag = true;
                    displayResults("Gastroenteritis");
                }
                else if(symptoms.contains("high_fever")&&symptoms.contains("cough")) {
                    flag = true;
                    displayResults("Viral Fever");
                }
                else if(symptoms.contains("mild_fever")&&symptoms.contains("cough")) {
                    flag = true;
                    displayResults("Viral Fever");
                } else if(symptoms.contains("high_fever")&&symptoms.contains("mild_fever")) {
                    flag = true;
                    displayResults("Viral Fever");
                }
                else flag = false;
            }
            else
                if(symptoms.size()>2&&symptoms.size()<=5)
                {
                    if(symptoms.contains("continuous_sneezing")&&symptoms.contains("cough")) {
                        flag = true;
                        displayResults("Common Cold");
                    }
                    else if(symptoms.contains("cough")&&symptoms.contains("runny_nose")) {
                        flag = true;
                        displayResults("Common Cold");
                    }
                    else if(symptoms.contains("mild_fever")&&symptoms.contains("cough")) {
                        flag = true;
                        displayResults("Common Cold");
                    }
                    if(symptoms.contains("continuous_sneezing")&&symptoms.contains("runny_nose")) {
                        flag = true;
                        displayResults("Common Cold");
                    }
                    else if(symptoms.contains("continuous_sneezing")&&symptoms.contains("mild_fever")) {
                        flag = true;
                        displayResults("Common Cold");
                    }
                    else if(symptoms.contains("mild_fever")&&symptoms.contains("runny_nose")) {
                        flag = true;
                        displayResults("Common Cold");
                    }else

                    //second set
                    if(symptoms.contains("acidity")&&symptoms.contains("indigestion")) {
                        flag = true;
                        displayResults("Gastroenteritis");
                    }
                    else if(symptoms.contains("acidity")&&symptoms.contains("vomiting")) {
                        flag = true;
                        displayResults("Gastroenteritis");
                    }
                    else if(symptoms.contains("acidity")&&(symptoms.contains("high_fever")||symptoms.contains("mild_fever"))) {
                        flag = true;
                        displayResults("Gastroenteritis");
                    }
                    else
                    if(symptoms.contains("indigestion")&&symptoms.contains("vomiting")) {
                        flag = true;
                        displayResults("Gastroenteritis");
                    }
                    else if(symptoms.contains("indigestion")&&(symptoms.contains("high_fever")||symptoms.contains("mild_fever"))) {
                        flag = true;
                        displayResults("Gastroenteritis");
                    }
                    else if(symptoms.contains("vomiting")&&(symptoms.contains("high_fever")||symptoms.contains("mild_fever"))) {
                        flag = true;
                        displayResults("Gastroenteritis");
                    }


                    else
                        flag = false;
                }

        }
        return flag;
    }

    private void predictDisease() {
        // construct string from symptoms
        String symptomString = Utils.getSymptomString(sharedPreferences.getStringSet(Constants.symptoms, null));
       // Log.e("TEST", symptomString);
        //Toast.makeText(this, "Working...", Toast.LENGTH_SHORT).show();
        //String symptomString = "111000011100000000111111111111111111111111110000000000000000000000000000000000000000000000000000001000100000000000000000000000111111";
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<Model> call = apiService.getData(symptomString);
        call.enqueue(new Callback<Model>() {

            @Override
            public void onResponse(@NonNull Call<Model> call, @NonNull Response<Model> response) {

                Log.e("Report Activity", String.valueOf(response.raw()));
                if(response.body()!=null)
                //Toast.makeText(SymptomsActivity.this, response.body().getData()+" is your disease", Toast.LENGTH_SHORT).show();

                {
                   displayResults(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.e("Report", "Call failed "+call.request());
            }
        });
    }

    private void displayResults(String data) {
        String description = Utils.getDiseaseDescription(data);
        progressBar2.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        results.setText("People with symptoms as yours were affected by \n\"" + data+"\"");
        desc.setText(description);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ReportActivity.this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet(Constants.symptoms, null).apply();
        extraInfo.setVisibility(View.VISIBLE);
        tests.setText(Utils.getLabtests(data));
        specialist.setText(Utils.getDiseaseSpecialist(data));
        urgencyLabel.setText(Utils.getUrgency(data));

        switch (Utils.getUrgency(data))
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


        // adapter a = new adapter(mainList, ReportActivity.this);
        if(mainList!=null&&mainList.size()>1)
            listView.setText(mainList);
    }

    private class adapter extends BaseAdapter{

        List<String> symptoms;
        Context context;

        public adapter(List<String> symptoms, Context context) {
            this.symptoms = symptoms;
            this.context = context;
        }

        @Override
        public int getCount() {
            return symptoms.size();
        }

        @Override
        public String getItem(int position) {
            return symptoms.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           View view = convertView;
           if(view==null)
               view = LayoutInflater.from(context).inflate(R.layout.symp, null);

           TextView name = view.findViewById(R.id.name);
           name.setText(getItem(position));
           return view;
        }
    }
}
