package com.btp_abviiitm_g19.v2.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.btp_abviiitm_g19.v2.R;
import com.btp_abviiitm_g19.v2.Utils;
import com.btp_abviiitm_g19.v2.adapters.CategoryAdapter;
import com.hootsuite.nachos.NachoTextView;
import com.hootsuite.nachos.chip.Chip;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    SharedPreferences sharedPreferences;
    Button predict, reset;
    NachoTextView nachoTextView;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reset = findViewById(R.id.reset);
        predict = findViewById(R.id.predict);
        nachoTextView = findViewById(R.id.nacho);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        populateListViewForCategories();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        setupNacho();
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nachoTextView.setText("");
                editor.putStringSet(Constants.symptoms, null).apply();
                Toast.makeText(MainActivity.this, "Symptoms cleared", Toast.LENGTH_SHORT).show();
                checkButtonStatus();
            }
        });
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void setupNacho() {
        ArrayList<String > list = Utils.getAllSymptoms();
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            iterator.set(Utils.remove_(s));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,list);
        nachoTextView.setAdapter(adapter);
        nachoTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                 {
                    // Do something with the text of each chip

                    // Do something with the data of each chip (this data will be set if the chip was created by tapping a suggestion)
                    if (s.toString().length()>2) {
                        predict.setEnabled(true);
                        predict.setBackground(getResources().getDrawable(R.drawable.gradient));
                    }
                    else
                    {
                        predict.setEnabled(false);
                        predict.setBackgroundColor(Color.parseColor("#a6a6a6"));
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                Set<String> selectedSymptoms = sharedPreferences.getStringSet(Constants.symptoms, null);
                if(selectedSymptoms==null)
                    selectedSymptoms = new HashSet<>();

                for (Chip chip : nachoTextView.getAllChips()) {
                    // Do something with the text of each chip
                    String text = chip.getText().toString();
                    // Do something with the data of each chip (this data will be set if the chip was created by tapping a suggestion)
                    if(text.length()>1) {
                        text = Utils.add_(text);
                        selectedSymptoms.add(String.valueOf(text));
                    }
                }

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putStringSet(Constants.symptoms,selectedSymptoms ).apply();

            }
        });
    }

    private void populateListViewForCategories() {

        //fill category array
        ArrayList<String> categoriesList = new ArrayList<>();
        categoriesList.add("Fever");
        categoriesList.add("Pain");
        categoriesList.add("Skin and Nails");
        categoriesList.add("Cold and cough");
        categoriesList.add("Urination related");
        categoriesList.add("Test results/Patient history");
        categoriesList.add("Stomach and Anal");
        categoriesList.add("Swelling, muscle, stiffness");
        categoriesList.add("Digestion and food");
        categoriesList.add("ENT and eyes");
        categoriesList.add("Others");
        ListView listView = findViewById(R.id.listView);
        CategoryAdapter adapter = new CategoryAdapter(this, categoriesList);
        listView.setAdapter(adapter);
        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Set<String> selectedSymptoms = sharedPreferences.getStringSet("new", null);
                if(selectedSymptoms==null)
                    selectedSymptoms = new HashSet<>();
                for (Chip chip : nachoTextView.getAllChips()) {
                    // Do something with the text of each chip
                    String text = chip.getText().toString();

                    // Do something with the data of each chip (this data will be set if the chip was created by tapping a suggestion)
                    if(text.length()>1) {
                        text = Utils.add_(text.toString());
                        selectedSymptoms.add(String.valueOf(text));
                    }
                }
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putStringSet(Constants.symptoms,selectedSymptoms ).apply();
                checkButtonStatus();
                if(sharedPreferences.getStringSet(Constants.symptoms, null)!=null&&sharedPreferences.getStringSet(Constants.symptoms, null).size()>0) {
                    nachoTextView.setText("");
                    startActivity(new Intent(MainActivity.this, ReportActivity.class));
                } else {

                    Toast.makeText(MainActivity.this, "Select symptoms first", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

       checkButtonStatus();
    }

    private void checkButtonStatus() {
        Log.e(TAG, "The string set is "+sharedPreferences.getStringSet(Constants.symptoms, null));
        if(sharedPreferences.getStringSet(Constants.symptoms, null)!=null&&sharedPreferences.getStringSet(Constants.symptoms, null).size()>0)
        {
            reset.setEnabled(true);
            reset.setBackground(getResources().getDrawable(R.drawable.gradient));
            predict.setEnabled(true);
            predict.setBackground(getResources().getDrawable(R.drawable.gradient));
            Set<String> selectedSymptoms = sharedPreferences.getStringSet(Constants.symptoms, null);
            if(selectedSymptoms!=null) {
                List<String> list = new ArrayList<>(selectedSymptoms);
                ListIterator<String> iterator = list.listIterator();
                while (iterator.hasNext()){
                    String s = iterator.next();
                    iterator.set(Utils.remove_(s));
                }
                nachoTextView.setText(list);
            }
            }
        else
        {
            reset.setEnabled(false);
            reset.setBackgroundColor(Color.parseColor("#a6a6a6"));
            predict.setEnabled(false);
            predict.setBackgroundColor(Color.parseColor("#a6a6a6"));
        }
    }



}
