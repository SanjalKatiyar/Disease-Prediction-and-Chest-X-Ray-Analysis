package com.btp_abviiitm_g19.v2.Activities;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.btp_abviiitm_g19.v2.R;
import com.btp_abviiitm_g19.v2.adapters.SymptomAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SymptomsActivity extends AppCompatActivity {

    int sympIndex = -1;
    SymptomAdapter adapter;
    Button addMore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        sympIndex = getIntent().getIntExtra(Constants.sympIndex, -1);
        populateListView();
        addMore = findViewById(R.id.more);
        addMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    finish();
            }
        });
    }

    private void populateListView() {

        ArrayList<String> symptoms = new ArrayList<>();
        switch (sympIndex)
        {
            //Fever
            case 0 :
                symptoms.add("high_fever");
                symptoms.add("mild_fever");

            break;

            //Pain
            case 1:
                symptoms.add("joint_pain");
                symptoms.add("stomach_pain");
                symptoms.add("headache");
                symptoms.add("pain_behind_the_eyes");
                symptoms.add("back_pain");

                symptoms.add("abdominal_pain");
                symptoms.add("chest_pain");

                symptoms.add("hip_joint_pain");
                symptoms.add("knee_pain");
                symptoms.add("neck_pain");
                symptoms.add("muscle_pain");
                symptoms.add("belly_pain");
                symptoms.add("painful_walking");

            break;

            //Skin and nails
            case 2 :
                symptoms.add("bruising");
                symptoms.add("skin_peeling");
                symptoms.add("blister");
                symptoms.add("sweating");
                symptoms.add("brittle_nails");
                symptoms.add("red_spots_over_body");
                symptoms.add("dischromic_patches");
                symptoms.add("pus_filled_pimples");
                symptoms.add("blackheads");
                symptoms.add("inflammatory_nails");
                symptoms.add("small_dents_in_nails");
                symptoms.add("nodal_skin_eruptions");
                symptoms.add("skin_rash");
                symptoms.add("yellowish_skin");
                symptoms.add("itching");
                break;

                //cold and cough

            case 3:
                symptoms.add("mucoid_sputum");
                symptoms.add("rusty_sputum");
                symptoms.add("continuous_sneezing");
                symptoms.add("shivering");
                symptoms.add("chills");
                symptoms.add("cold_hands_and_feets");
                symptoms.add("cough");
                symptoms.add("phlegm");
                symptoms.add("runny_nose");
                symptoms.add("congestion");
                break;

            case 4:
                symptoms.add("bladder_discomfort");
                symptoms.add("foul_smell_of_urine");
                symptoms.add("continuous_feel_of_urine");
                symptoms.add("polyuria");
                symptoms.add("burning_micturition");
                symptoms.add("spotting_urination");
                symptoms.add("dark_urine");
                symptoms.add("yellow_urine");
                break;

            case 5:
                symptoms.add("swollen_blood_vessels");
                symptoms.add("enlarged_thyroid");
                symptoms.add("stomach_bleeding");
                symptoms.add("family_history");
                symptoms.add("receiving_blood_transfusion");
                symptoms.add("receiving_unsterile_injections");
                symptoms.add("history_of_alcohol_consumption");
                symptoms.add("irregular_sugar_level");
                symptoms.add("acute_liver_failure");
                symptoms.add("swelled_lymph_nodes");

                break;

            case 6:
                symptoms.add("pain_during_bowel_movements");
                symptoms.add("stomach_pain");
                symptoms.add("pain_in_anal_region");
                symptoms.add("bloody_stool");
                symptoms.add("irritation_in_anus");
                symptoms.add("passage_of_gases");
                symptoms.add("stomach_bleeding");
                symptoms.add("swelling_of_stomach");
                symptoms.add("diarrhoea");
                break;

            case 7:
                symptoms.add("muscle_pain");
                symptoms.add("muscle_weakness");
                symptoms.add("stiff_neck");
                symptoms.add("swelling_joints");
                symptoms.add("movement_stiffness");
                symptoms.add("muscle_wasting");
                symptoms.add("swelling_of_stomach");

                break;

            case 8:
                symptoms.add("acidity");
                symptoms.add("indigestion");
                symptoms.add("stomach_pain");
                symptoms.add("vomiting");
                symptoms.add("loss_of_appetite");
                symptoms.add("constipation");
                symptoms.add("obesity");
                symptoms.add("weight_gain");
                symptoms.add("weight_loss");
                symptoms.add("excessive_hunger");
                symptoms.add("increased_appetite");
                break;


            case 9:
                symptoms.add("pain_behind_the_eyes");
                symptoms.add("patches_in_throat");
                symptoms.add("sunken_eyes");
                symptoms.add("yellowing_of_eyes");
                symptoms.add("blurred_and_distorted_vision");
                symptoms.add("throat_irritation");
                symptoms.add("redness_of_eyes");
                symptoms.add("sinus_pressure");
                symptoms.add("puffy_face_and_eyes");
                symptoms.add("loss_of_smell");
                symptoms.add("watering_from_eyes");
                symptoms.add("visual_disturbances");
                symptoms.add("red_sore_around_nose");
                break;
                // and so on

            case 10:

                symptoms.add("ulcers_on_tongue");
                symptoms.add("fatigue");
                symptoms.add("weight_gain");
                symptoms.add("anxiety");
                symptoms.add("mood_swings");
                symptoms.add("weight_loss");
                symptoms.add("restlessness");
                symptoms.add("lethargy");

                symptoms.add("breathlessness");
                symptoms.add("dehydration");
                symptoms.add("nausea");
                symptoms.add("diarrhoea");
                symptoms.add("fluid_overload");
                symptoms.add("weakness_in_limbs");
                symptoms.add("fast_heart_rate");
                symptoms.add("dizziness");
                symptoms.add("malaise");

                symptoms.add("cramps");
                symptoms.add("obesity");
                symptoms.add("swollen_legs");
                symptoms.add("swollen_extremeties");
                symptoms.add("extra_marital_contacts");
                symptoms.add("drying_and_tingling_lips");
                symptoms.add("slurred_speech");
                symptoms.add("spinning_movements");

                symptoms.add("loss_of_balance");
                symptoms.add("unsteadiness");
                symptoms.add("weakness_of_one_body_side");
                symptoms.add("internal_itching");
                symptoms.add("toxic_look_(typhos)");
                symptoms.add("depression");
                symptoms.add("irritability");
                symptoms.add("altered_sensorium");

                symptoms.add("abnormal_menstruation");
                symptoms.add("lack_of_concentration");
                symptoms.add("coma");
                symptoms.add("distention_of_abdomen");
                symptoms.add("blood_in_sputum");
                symptoms.add("prominent_veins_on_calf");
                symptoms.add("palpitations");
                symptoms.add("scurring");

                symptoms.add("silver_like_dusting");
                symptoms.add("yellow_crust_ooze");

                break;
        }

        ListView listView = findViewById(R.id.listView);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Set<String> selectedSymptoms = sharedPreferences.getStringSet(Constants.symptoms, null);
        if(selectedSymptoms==null)
            selectedSymptoms = new HashSet<>();
        adapter = new SymptomAdapter(this, symptoms, selectedSymptoms);
        listView.setAdapter(adapter);
    }

    private void checkButtons()
    {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if(sharedPreferences.getStringSet(Constants.symptoms, null)!=null)
        {
            addMore.setEnabled(true);
            addMore.setBackground(getResources().getDrawable(R.drawable.gradient));

        }
        else
        {
            addMore.setEnabled(false);
            addMore.setBackgroundColor(Color.parseColor("#a6a6a6"));

        }
    }
    }


