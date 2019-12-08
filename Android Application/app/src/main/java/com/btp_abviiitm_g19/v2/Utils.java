package com.btp_abviiitm_g19.v2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Utils {


    public static String getSymptomString(Set<String> selectedSymptoms) {

        String symptomString="";
        int array[] = new int[133];
        for (int i =0; i<133; i++)
            array[i] = 0;

        for (String symptom: selectedSymptoms)
            array[getSymptomIndex(symptom)] = 1;

        for (int i =0; i<133; i++)
            symptomString+=array[i];
        return symptomString;
    }

    public static ArrayList<String> getAllSymptoms()
    {
        ArrayList<String > symptomsMap = new ArrayList<>();
        symptomsMap.add("abdominal_pain"   );
        symptomsMap.add("abnormal_menstruation"    );
        symptomsMap.add("acidity"  );

        symptomsMap.add("acute_liver_failure"   );
        symptomsMap.add("altered_sensorium"   );
        symptomsMap.add("anxiety"   );

        symptomsMap.add("back_pain"   );
        symptomsMap.add("belly_pain"    );
        symptomsMap.add("blackheads"    );

        symptomsMap.add("bladder_discomfort"   );
        symptomsMap.add("blister"    );
        symptomsMap.add("blood_in_saddum"    );

        symptomsMap.add("bloody_stool"   );
        symptomsMap.add("blurred_and_distorted_vision"   );
        symptomsMap.add("breathlessness"   );

        symptomsMap.add("brittle_nails"   );
        symptomsMap.add("bruising"   );
        symptomsMap.add("burning_micturition"   );

        symptomsMap.add("chest_pain"   );
        symptomsMap.add("chills"  );
        symptomsMap.add("cold_hands_and_feets"   );

        symptomsMap.add("coma"    );
        symptomsMap.add("congestion"   );
        symptomsMap.add("constipation"   );

        symptomsMap.add("continuous_feel_of_urine"   );
        symptomsMap.add("continuous_sneezing"  );
        symptomsMap.add("cough"   );

        symptomsMap.add("cramps"   );
        symptomsMap.add("dark_urine"   );
        symptomsMap.add("dehydration"   );

        symptomsMap.add("depression"   );
        symptomsMap.add("diarrhoea"   );
        symptomsMap.add("dischromic_patches"    );

        symptomsMap.add("distention_of_abdomen"    );
        symptomsMap.add("dizziness"   );
        symptomsMap.add("drying_and_tingling_lips"   );

        symptomsMap.add("enlarged_thyroid"   );
        symptomsMap.add("excessive_hunger"   );
        symptomsMap.add("extra_marital_contacts"   );

        symptomsMap.add( "family_history"    );

        symptomsMap.add("fast_heart_rate"    );
        symptomsMap.add("fatigue"    );
        symptomsMap.add("fluid_overload"    );

        symptomsMap.add("fluid_overload. "     );
        symptomsMap.add("foul_smell_of_urine"    );
        symptomsMap.add("headache"    );

        symptomsMap.add("high_fever"    );
        symptomsMap.add("hip_joint_pain"    );
        symptomsMap.add("history_of_alcohol_consumption"     );

        symptomsMap.add("increased_appetite"     );
        symptomsMap.add("indigestion"    );
        symptomsMap.add("inflammatory_nails"     );

        symptomsMap.add("internal_itching"    );
        symptomsMap.add("irregular_sugar_level"    );
        symptomsMap.add("irritability"    );

        symptomsMap.add("irritation_in_anus"    );
        symptomsMap.add("itching"   );
        symptomsMap.add("joint_pain"   );

        symptomsMap.add("knee_pain"    );
        symptomsMap.add("lack_of_concentration"     );
        symptomsMap.add("lethargy"    );

        symptomsMap.add("loss_of_appetite"    );
        symptomsMap.add("loss_of_balance"    );
        symptomsMap.add("loss_of_smell"    );

        symptomsMap.add("malaise"    );
        symptomsMap.add("mild_fever"    );
        symptomsMap.add("mood_swings"    );

        symptomsMap.add("movement_stiffness"    );
        symptomsMap.add("mucoid_saddum"     );
        symptomsMap.add("muscle_pain"    );

        symptomsMap.add("muscle_wasting"    );
        symptomsMap.add("muscle_weakness"    );
        symptomsMap.add("nausea"    );

        symptomsMap.add("neck_pain"    );
        symptomsMap.add("nodal_skin_eruptions"   );
        symptomsMap.add("obesity"    );

        symptomsMap.add("pain_behind_the_eyes"    );
        symptomsMap.add("pain_during_bowel_movements"    );
        symptomsMap.add("pain_in_anal_region"    );
        symptomsMap.add("painful_walking"     );

        symptomsMap.add("palpitations"     );
        symptomsMap.add("passage_of_gases"    );
        symptomsMap.add("patches_in_throat"    );

        symptomsMap.add("phlegm"    );
        symptomsMap.add("polyuria"     );
        symptomsMap.add("prominent_veins_on_calf"     );

        symptomsMap.add("puffy_face_and_eyes"    );
        symptomsMap.add("pus_filled_pimples"     );
        symptomsMap.add("receiving_blood_transfusion"     );

        symptomsMap.add("receiving_unsterile_injections"     );
        symptomsMap.add("red_sore_around_nose"     );
        symptomsMap.add("red_spots_over_body"    );

        symptomsMap.add("redness_of_eyes"    );
        symptomsMap.add("restlessness"    );
        symptomsMap.add("runny_nose"    );

        symptomsMap.add("rusty_saddum"     );
        symptomsMap.add("scurring"     );
        symptomsMap.add("shivering"   );

        symptomsMap.add("silver_like_dusting"     );
        symptomsMap.add("sinus_pressure"    );
        symptomsMap.add("skin_peeling"     );

        symptomsMap.add("skin_rash"   );
        symptomsMap.add("slurred_speech"    );
        symptomsMap.add("small_dents_in_nails"     );

        symptomsMap.add("spinning_movements"    );
        symptomsMap.add("spotting_urination"    );
        symptomsMap.add("stiff_neck"    );

        symptomsMap.add("stomach_bleeding"     );
        symptomsMap.add("stomach_pain"   );
        symptomsMap.add("sunken_eyes"    );

        symptomsMap.add("sweating"    );
        symptomsMap.add("swelled_lymph_nodes"    );
        symptomsMap.add("swelling_joints"    );

        symptomsMap.add("swelling_of_stomach"    );
        symptomsMap.add("swollen_blood_vessels"    );
        symptomsMap.add("swollen_extremeties"    );

        symptomsMap.add("swollen_legs"    );
        symptomsMap.add("throat_irritation"    );
        symptomsMap.add("toxic_look_(typhos)"    );

        symptomsMap.add("ulcers_on_tongue"   );
        symptomsMap.add("unsteadiness"    );
        symptomsMap.add("visual_disturbances"     );

        symptomsMap.add("vomiting"    );
        symptomsMap.add("watering_from_eyes"     );
        symptomsMap.add("weakness_in_limbs"    );

        symptomsMap.add("weakness_of_one_body_side"    );
        symptomsMap.add("weight_gain"    );
        symptomsMap.add("weight_loss"    );

        symptomsMap.add("yellow_crust_ooze"     );
        symptomsMap.add("yellow_urine"    );
        symptomsMap.add("yellowing_of_eyes"    );

        symptomsMap.add("yellowish_skin"    );
        return symptomsMap;
    }

    public static int getSymptomIndex(String s)
    {
        Map<String, Integer> symptomsMap = new HashMap<>();

        symptomsMap.put("abdominal_pain",39);
        symptomsMap.put("abnormal_menstruation",101);
        symptomsMap.put("acidity",8);

        symptomsMap.put("acute_liver_failure",44);
        symptomsMap.put("altered_sensorium",98);
        symptomsMap.put("anxiety",16);

        symptomsMap.put("back_pain",37);
        symptomsMap.put("belly_pain",100);
        symptomsMap.put("blackheads",123);

        symptomsMap.put("bladder_discomfort",89);
        symptomsMap.put("blister",129);
        symptomsMap.put("blood_in_sputum",118);

        symptomsMap.put("bloody_stool",61);
        symptomsMap.put("blurred_and_distorted_vision",49);
        symptomsMap.put("breathlessness",27);

        symptomsMap.put("brittle_nails",72);
        symptomsMap.put("bruising",66);
        symptomsMap.put("burning_micturition",12);

        symptomsMap.put("chest_pain",56);
        symptomsMap.put("chills",5);
        symptomsMap.put("cold_hands_and_feets",17);

        symptomsMap.put("coma",113);
        symptomsMap.put("congestion",55);
        symptomsMap.put("constipation",38);

        symptomsMap.put("continuous_feel_of_urine",91);
        symptomsMap.put("continuous_sneezing",3);
        symptomsMap.put("cough",24);

        symptomsMap.put("cramps",65);
        symptomsMap.put("dark_urine",33);
        symptomsMap.put("dehydration",29);

        symptomsMap.put("depression",95);
        symptomsMap.put("diarrhoea",40);
        symptomsMap.put("dischromic_patches",102);

        symptomsMap.put("distention_of_abdomen",115);
        symptomsMap.put("dizziness",64);
        symptomsMap.put("drying_and_tingling_lips",76);

        symptomsMap.put("enlarged_thyroid",71);
        symptomsMap.put("excessive_hunger",74);
        symptomsMap.put("extra_marital_contacts",75);

        symptomsMap.put( "family_history",106);

        symptomsMap.put("fast_heart_rate", 58);
        symptomsMap.put("fatigue", 14);
        symptomsMap.put("fluid_overload", 45);

        symptomsMap.put("fluid_overload.1", 117);
        symptomsMap.put("foul_smell_of_urine", 90);
        symptomsMap.put("headache", 31);

        symptomsMap.put("high_fever", 25);
        symptomsMap.put("hip_joint_pain", 79);
        symptomsMap.put("history_of_alcohol_consumption", 116);

        symptomsMap.put("increased_appetite", 104);
        symptomsMap.put("indigestion", 30);
        symptomsMap.put("inflammatory_nails", 128);

        symptomsMap.put("internal_itching", 93);
        symptomsMap.put("irregular_sugar_level", 23);
        symptomsMap.put("irritability", 96);

        symptomsMap.put("irritation_in_anus", 62);
        symptomsMap.put("itching", 0);
        symptomsMap.put("joint_pain", 6);

        symptomsMap.put("knee_pain", 78);
        symptomsMap.put("lack_of_concentration", 109);
        symptomsMap.put("lethargy", 21);

        symptomsMap.put("loss_of_appetite", 35);
        symptomsMap.put("loss_of_balance", 85);
        symptomsMap.put("loss_of_smell", 88);

        symptomsMap.put("malaise", 48);
        symptomsMap.put("mild_fever", 41);
        symptomsMap.put("mood_swings", 18);

        symptomsMap.put("movement_stiffness", 83);
        symptomsMap.put("mucoid_sputum", 107);
        symptomsMap.put("muscle_pain", 97);

        symptomsMap.put("muscle_wasting", 10);
        symptomsMap.put("muscle_weakness", 80);
        symptomsMap.put("nausea", 34);

        symptomsMap.put("neck_pain", 63);
        symptomsMap.put("nodal_skin_eruptions", 2);
        symptomsMap.put("obesity", 67);

        symptomsMap.put("pain_behind_the_eyes", 36);
        symptomsMap.put("pain_during_bowel_movements", 59);
        symptomsMap.put("pain_in_anal_region", 60);
        symptomsMap.put("painful_walking", 121);

        symptomsMap.put("palpitations", 120);
        symptomsMap.put("passage_of_gases", 92);
        symptomsMap.put("patches_in_throat", 22);

        symptomsMap.put("phlegm", 50);
        symptomsMap.put("polyuria", 105);
        symptomsMap.put("prominent_veins_on_calf", 119);

        symptomsMap.put("puffy_face_and_eyes", 70);
        symptomsMap.put("pus_filled_pimples", 122);
        symptomsMap.put("receiving_blood_transfusion", 111);

        symptomsMap.put("receiving_unsterile_injections", 112);
        symptomsMap.put("red_sore_around_nose", 130);
        symptomsMap.put("red_spots_over_body", 99);

        symptomsMap.put("redness_of_eyes", 52);
        symptomsMap.put("restlessness", 20);
        symptomsMap.put("runny_nose", 54);

        symptomsMap.put("rusty_sputum", 108);
        symptomsMap.put("scurring", 124);
        symptomsMap.put("shivering", 4);

        symptomsMap.put("silver_like_dusting", 126);
        symptomsMap.put("sinus_pressure", 53);
        symptomsMap.put("skin_peeling", 125);

        symptomsMap.put("skin_rash", 1);
        symptomsMap.put("slurred_speech", 77);
        symptomsMap.put("small_dents_in_nails", 127);

        symptomsMap.put("spinning_movements", 84);
        symptomsMap.put("spotting_urination", 13);
        symptomsMap.put("stiff_neck", 81);

        symptomsMap.put("stomach_bleeding", 114);
        symptomsMap.put("stomach_pain", 7);
        symptomsMap.put("sunken_eyes", 26);

        symptomsMap.put("sweating", 28);
        symptomsMap.put("swelled_lymph_nodes", 47);
        symptomsMap.put("swelling_joints", 82);

        symptomsMap.put("swelling_of_stomach", 46);
        symptomsMap.put("swollen_blood_vessels", 69);
        symptomsMap.put("swollen_extremeties", 73);

        symptomsMap.put("swollen_legs", 68);
        symptomsMap.put("throat_irritation", 51);
        symptomsMap.put("toxic_look_(typhos)", 94);

        symptomsMap.put("ulcers_on_tongue", 9);
        symptomsMap.put("unsteadiness", 86);
        symptomsMap.put("visual_disturbances", 110);

        symptomsMap.put("vomiting", 11);
        symptomsMap.put("watering_from_eyes", 103);
        symptomsMap.put("weakness_in_limbs", 57);

        symptomsMap.put("weakness_of_one_body_side", 87);
        symptomsMap.put("weight_gain", 15);
        symptomsMap.put("weight_loss", 19);

        symptomsMap.put("yellow_crust_ooze", 131);
        symptomsMap.put("yellow_urine", 42);
        symptomsMap.put("yellowing_of_eyes", 43);

        symptomsMap.put("yellowish_skin", 32);

        if(!symptomsMap.containsKey(s))
            return 0;
        return symptomsMap.get(s);
    }

    public static String getUrgency(String data)
    {
        Map<String, String> dict = new HashMap<>();
        dict.put("Dimorphic hemmorhoids(piles)","Medium");
        dict.put("Heart attack","Urgent");
        dict.put("Varicose veins","Low");
        dict.put("Hypothyroidism","Urgent");
        dict.put("Hyperthyroidism","Urgent");
        dict.put("Hypoglycemia","Urgent");
        dict.put("Osteoarthristis","Urgent");
        dict.put("Arthritis","Medium");
        dict.put("(vertigo) Paroymsal  Positional Vertigo","Medium");
        dict.put("Acne","Low");
        dict.put("Urinary tract infection","Urgent");
        dict.put("Psoriasis","Medium");
        dict.put("Impetigo","Medium");
        dict.put("Hepatitis C","Urgent");
        dict.put("Hepatitis D","Urgent");
        dict.put("Hepatitis E","Urgent");
        dict.put("Alcoholic hepatitis","Urgent");
        dict.put("Tuberculosis","Urgent");
        dict.put("Common Cold","Low");
        dict.put("Pneumonia","Urgent");

        dict.put("Fungal infection", "Low");
        dict.put("Allergy", "Low");
        dict.put("GERD", "Low");
        dict.put("Chronic cholestasis", "Medium");
        dict.put("Drug Reaction", "Medium");
        dict.put("Peptic ulcer diseae", "Medium");
        dict.put("AIDS", "Urgent");
        dict.put("Diabetes", "Urgent");
        dict.put("Gastroenteritis", "Medium");
        dict.put("Bronchial Asthma", "Urgent");
        dict.put("Hypertension ", "Urgent");
        dict.put("Migraine", "Urgent");
        dict.put("Cervical spondylosis", "Urgent");
        dict.put("Paralysis (brain hemorrhage)", "Urgent");

        dict.put("Jaundice", "Urgent");
        dict.put("Malaria",  "Urgent");
        dict.put("Chicken pox", "Urgent");
        dict.put("Dengue", "Urgent");
        dict.put("Typhoid", "Urgent");
        dict.put("hepatitis A", "Urgent");
        dict.put("Hepatitis B", "Urgent");

        dict.put("Mass", "Urgent");
        dict.put("Nodule","Urgent");
        dict.put("Pleural_Thickening", "Urgent");
        dict.put("Pneumothorax","Urgent");
        dict.put("Atelectasis","Urgent");
        dict.put("Cardiomegaly","Urgent");
        dict.put("Consolidation","Urgent");
        dict.put("Edema","Urgent");
        dict.put("Effusion","Urgent");
        dict.put("Emphysema","Urgent");
        dict.put("Fibrosis","Urgent");
        dict.put("Infiltration","Urgent");

        dict.put("Viral Fever", "Low");
        dict.put("Acid Reflux", "Low");
        dict.put("Bulimia", "Low");
        dict.put("Stress", "Low");
        dict.put("Stomach Flu", "Low");


        if(dict.containsKey(data))
            return dict.get(data);
        else
            return "Not Available";
    }

    public static String getLabtests(String data)
    {
        Map<String, String> dict = new HashMap<>();

        dict.put("Viral Fever", "NA");
        dict.put("Acid Reflux", "NA");
        dict.put("Bulimia", "NA");
        dict.put("Stress", "NA");
        dict.put("Stomach Flu", "NA");

        dict.put("Mass", "NA");
        dict.put("Nodule","NA");
        dict.put("Pleural_Thickening", "NA");
        dict.put("Pneumothorax","NA");
        dict.put("Atelectasis","NA");
        dict.put("Cardiomegaly","NA");
        dict.put("Consolidation","NA");
        dict.put("Edema","NA");
        dict.put("Effusion","NA");
        dict.put("Emphysema","NA");
        dict.put("Fibrosis","NA");
        dict.put("Infiltration","NA");

        dict.put("Jaundice", "Liver panel,Prothrombin time (PT), Urine bilirubin");
        dict.put("Malaria",  "Thick and thin blood smears, Antigen testing, Polymerase chain reaction, Serology");
        dict.put("Chicken pox", "Blood Test(Test for Varicella Zoster Virus)");
        dict.put("Dengue", "Molecular tests(PCR), Antibody tests(IgM and IgG), Complete blood count (CBC)");
        dict.put("Typhoid", "Widal Test");
        dict.put("hepatitis A", "Blood Test(Antibody and antigen tests)");
        dict.put("Hepatitis B", "Blood Test(Antibody and antigen tests)");

        dict.put("Dimorphic hemmorhoids(piles)","Sigmoidoscopy, Digital rectal exam");
        dict.put("Heart attack","Electrocardiogram, Echocardiography, Cardiac catheterization");
        dict.put("Varicose veins","Ultrasound test");
        dict.put("Hypothyroidism","TSH test, other blood test that measure TSH");
        dict.put("Hyperthyroidism","TSH test, Radioiodine uptake test");
        dict.put("Hypoglycemia","Blood glucose test, Mixed-meal tolerance test (MMTT)");
        dict.put("Osteoarthristis","X-Ray of affected joints, Magnetic resonance imaging (MRI)");
        dict.put("Arthritis","Anti-cyclic citrullinated peptide (anti-CCP),Antinuclear antibody (ANA)");
        dict.put("(vertigo) Paroymsal  Positional Vertigo","Dix-Hallpike test");
        dict.put("Acne","N/A");
        dict.put("Urinary tract infection","Urinalysis, Urine culture, Susceptibility testing");
        dict.put("Psoriasis","Skin biopsy");
        dict.put("Impetigo","N/A");
        dict.put("Hepatitis C","HCV antibody blood test");
        dict.put("Hepatitis D","Anti-hepatitis D antibodies detecting blood test");
        dict.put("Hepatitis E","Anti-hepatitis E antibodies detecting blood test");
        dict.put("Alcoholic hepatitis","Ultrasound, CT or MRI scan of the liver,liver biopsy");
        dict.put("Tuberculosis","TB skin test (TST), TB blood tests");
        dict.put("Common Cold","N/A");
        dict.put("Pneumonia","CBC (complete blood count), BMP (basic metabolic panel)");

        dict.put("Fungal infection", "Fungal culture,Susceptibility testing, Antigen and Antibody testing");
        dict.put("Allergy", "Allergen-specific IgE blood testing, Total IgE testing,Complete blood count (CBC), WBC differential");
        dict.put("GERD", "Esophagram, Upper Endoscopy");
        dict.put("Chronic cholestasis", "N/A");
        dict.put("Drug Reaction", "N/A");
        dict.put("Peptic ulcer diseae", "Helicobacter pylori tests, Hemoglobin testing,Fecal occult blood test, Gastrin test");
        dict.put("AIDS", "Combination HIV antibody and antigen test, p24 antigen testing");
        dict.put("Diabetes ", "Fasting glucose,Hemoglobin A1c or Glycohemoglobin Test, 2-hour glucose tolerance test");
        dict.put("Gastroenteritis", "A stool culture");
        dict.put("Bronchial Asthma", "Blood testing for allergic sensitivity, Chest X-Ray,Blood gases, CBC (complete blood count), CMP (comprehensive metabolic panel)");
        dict.put("Hypertension ", "Blood pressure measurement");
        dict.put("Migraine", "N/A");
        dict.put("Cervical spondylosis", "X-Rays, Myelogram, Electromyography");
        dict.put("Paralysis (brain hemorrhage)", "CT scan, MRI scan");


        if(dict.containsKey(data))
            return dict.get(data);
        else
            return "Not Available";
    }

    public static String getDiseaseSpecialist(String data){

        Map<String, String> dict = new HashMap<>();

        dict.put("Viral Fever", "Doctor of medicine(MD)");
        dict.put("Acid Reflux", "Gastroenterologist");
        dict.put("Bulimia", "Doctor of medicine(MD), Nutritionist");
        dict.put("Stress", "Psychiatrists");
        dict.put("Stomach Flu", "Gastroenterologist or Doctor of medicine(MD)");

        dict.put("Mass", "Pulmonologist");
        dict.put("Nodule","Pulmonologist");
        dict.put("Pleural_Thickening", "Pulmonologist");
        dict.put("Pneumothorax","Pulmonologist");
        dict.put("Atelectasis","Pulmonologist");
        dict.put("Cardiomegaly","Pulmonologist");
        dict.put("Consolidation","Pulmonologist");
        dict.put("Edema","Pulmonologist");
        dict.put("Effusion","Pulmonologist");
        dict.put("Emphysema","Pulmonologist");
        dict.put("Fibrosis","Pulmonologist");
        dict.put("Infiltration","Pulmonologist");


        dict.put("Fungal infection", "Dermatologist");
        dict.put("Allergy", "Allergist or Dermatologist");
        dict.put("GERD", "Gastroenterologist");
        dict.put("Chronic cholestasis", "Gastroenterologist or Hepatologist");
        dict.put("Drug Reaction", "Allergist or Dermatologist");
        dict.put("Peptic ulcer diseae", "Gastroenterologist");
        dict.put("AIDS", "Doctor of medicine(MD)");
        dict.put("Diabetes ", "Endocrinologist");
        dict.put("Gastroenteritis", "Gastroenterologist or Doctor of medicine(MD)");
        dict.put("Bronchial Asthma", "Pulmonologist or Allergist/Immunologist");
        dict.put("Hypertension ", "Doctor of medicine(MD) or Cardiologist or Nephrologist");
        dict.put("Migraine", "Doctor of medicine(MD) or Neurologists");
        dict.put("Cervical spondylosis", "Orthopedic Surgeon or Neurosurgeon");
        dict.put("Paralysis (brain hemorrhage)", "Neurosurgeon");

        dict.put("Jaundice", "Doctor of medicine(MD); or Gastroenterologist or Hematologist");
        dict.put("Malaria",  "Doctor of medicine(MD); or Pediatrician");
        dict.put("Chicken pox", "Doctor of medicine(MD);");
        dict.put("Dengue", "Doctor of medicine(MD);");
        dict.put("Typhoid", "Doctor of medicine(MD);");
        dict.put("hepatitis A", "Doctor of medicine(MD); or Gastroenterologist or Hematologist");
        dict.put("Hepatitis B", "Doctor of medicine(MD); or Gastroenterologist or Hematologist");

        dict.put("Dimorphic hemmorhoids(piles)","Proctologist");
        dict.put("Heart attack","Cardiologist");
        dict.put("Varicose veins","Vascular medicine specialist");
        dict.put("Hypothyroidism","Endocrinologist");
        dict.put("Hyperthyroidism","Endocrinologist");
        dict.put("Hypoglycemia","Endocrinologist");
        dict.put("Osteoarthristis","Orthopedic doctor");
        dict.put("Arthritis","Orthopedic doctor");
        dict.put("(vertigo) Paroymsal  Positional Vertigo","ENT Specialist");
        dict.put("Acne","Dermatologist");
        dict.put("Urinary tract infection","Urologist");
        dict.put("Psoriasis","Dermatologist");
        dict.put("Impetigo","Dermatologist");
        dict.put("Hepatitis C","Gastroenterologist/Hepatologist");
        dict.put("Hepatitis D","Gastroenterologist/Hepatologist");
        dict.put("Hepatitis E","Gastroenterologist/Hepatologist");
        dict.put("Alcoholic hepatitis","Gastroenterologist/Hepatologist");
        dict.put("Tuberculosis","Pulmonologist");
        dict.put("Common Cold","Physician");
        dict.put("Pneumonia","Pulmonologist");


        if(dict.containsKey(data))
            return dict.get(data);
        else
            return "Not Available";
    }

    public static String getDiseaseDescription(String data) {
        Map<String, String> dict = new HashMap<>();
        dict.put("Mass", "A lung mass is defined as an abnormal spot or area in the lungs that is more than 3 centimeters (cm), about 1 1/2 inches, in size.");
        dict.put("Nodule","A lung nodule is a small growth on the lung. To be considered a lung nodule, the growth usually has to be smaller than 3 centimeters.");
        dict.put("Pleural_Thickening", "Pleural thickening, also known as diffuse pleural thickening, is a lung disease in which extensive scarring thickens the pleura, which is the lining of the lungs. The condition may cause chest pain and breathing difficulty, and it is one of the most commonly diagnosed signs of asbestos exposure.\n");
        //dict.put("Pneumonia",);
        dict.put("Pneumothorax","A collapsed lung or pneumothorax refers to a condition in which the space between the wall of the chest cavity and the lung itself fills with air, causing all or a portion of the lung to collapse. Air usually enters this space, called the pleural space, through an injury to the chest wall or a hole in the lung.");

        dict.put("Atelectasis","Atelectasis is the collapse or closure of a lung resulting in reduced or absent gas exchange. It may affect part or all of a lung. It is usually unilateral. It is a condition where the alveoli are deflated down to little or no volume, as distinct from pulmonary consolidation, in which they are filled with liquid.");
        dict.put("Cardiomegaly","Cardiomegaly is a medical condition in which the heart is enlarged. It is more commonly referred to as an enlarged heart. The causes of cardiomegaly may vary. Many times this condition results from high blood pressure (hypertension) or coronary artery disease.\n");
        dict.put("Consolidation","A consolidation is a region of normally compressible lung tissue that has filled with liquid instead of air. The condition is marked by induration (swelling or hardening of normally soft tissue) of a normally aerated lung. It is considered a radiologic sign.\n");
        dict.put("Edema","Edema is a condition caused by excess fluid in the lungs. This fluid collects in the numerous air sacs in the lungs, making it difficult to breathe. In most cases, heart problems cause edema.\n");
        dict.put("Effusion","A effusion is an unusual amount of fluid around the lungs.The pleura is a thin membrane that lines the surface of your lungs and the inside of your chest wall. When you have a pleural effusion, fluid builds up in the space between the layers of your pleura.\n");
        dict.put("Emphysema","Emphysema is a type of COPD involving damage to the air sacs (alveoli) in the lungs. As a result, your body does not get the oxygen it needs. Emphysema makes it hard to catch your breath. You may also have a chronic cough and have trouble breathing during exercise. The most common cause is cigarette smoking.\n");
        dict.put("Fibrosis","Fibrosis is a lung disease that occurs when lung tissue becomes damaged and scarred. This thickened, stiff tissue makes it more difficult for your lungs to work properly. As pulmonary fibrosis worsens, you become progressively more short of breath.\n");
        dict.put("Infiltration","Infiltration is a condition which results in production of pulmonary infiltrate. It is a substance denser than air, such as pus, blood, or protein, which lingers within the parenchyma of the lungs. Pulmonary infiltrates are associated with pneumonia, tuberculosis, and nocardiosis. Pulmonary infiltrates can be observed on a chest radiograph.");


        dict.put("Dimorphic hemmorhoids(piles)","Piles are inflamed and swollen collections of tissue in the anal area. They can have a range of sizes, and they may be internal or external");
        dict.put("Heart attack","A heart attack is a medical emergency. A heart attack usually occurs when a blood clot blocks blood flow to the heart. Without blood, tissue loses oxygen and dies.");
        dict.put("Varicose veins","Varicose veins are generally benign. The cause of this condition is not known. For many people, there are no symptoms and varicose veins are simply a cosmetic concern. In some cases, they cause aching pain and discomfort or signal an underlying circulatory problem.");
        dict.put("Hypothyroidism","Hypothyroidism's deficiency of thyroid hormones can disrupt such things as heart rate, body temperature and all aspects of metabolism. Hypothyroidism is most prevalent in older women.");
        dict.put("Hyperthyroidism","Hyperthyroidism is the production of too much thyroxine hormone. It can increase metabolism. Symptoms include unexpected weight loss, rapid or irregular heartbeat, sweating and irritability, although the elderly often experience no symptoms.");
        dict.put("Hypoglycemia","Diabetes treatment and other conditions can cause hypoglycaemia. Consuming high-sugar foods or drinks, such as orange juice or regular fizzy drinks, can treat this condition. Alternatively, medication can be used to raise blood sugar levels. It's also important that a doctor identifies and treats the underlying cause.");
        dict.put("Osteoarthristis","The wearing down of the protective tissue at the ends of bones (cartilage) occurs gradually and worsens over time. Medication, physiotherapy and sometimes surgery can help reduce pain and maintain joint movement.");
        dict.put("Arthritis","Different types of arthritis exist, each with different causes including wear and tear, infections and underlying diseases. Medication, physiotherapy or sometimes surgery helps reduce symptoms and improve quality of life.");
        dict.put("(vertigo) Paroymsal  Positional Vertigo","Benign paroxysmal positional vertigo (BPPV) is triggered by certain changes in head position, such as tipping the head up or down. It's rarely serious unless it increases the risk of falling. Treatment includes a series of head movements that shift particles in the ears.");
        dict.put("Acne","Acne is most common in teenagers and young adults. Treatments include over-the-counter creams and cleanser, as well as prescription antibiotics.");
        dict.put("Urinary tract infection","Urinary tract infections are more common in women. They usually occur in the bladder or urethra, but more serious infections involve the kidney. A bladder infection may cause pelvic pain, increased urge to urinate, pain with urination and blood in the urine. A kidney infection may cause back pain, nausea, vomiting and fever.");
        dict.put("Psoriasis","Psoriasis is thought to be an immune system problem. Triggers include infections, stress and cold. The most common symptom is a rash on the skin, but sometimes the rash involves the nails or joints. Treatment aims to remove scales and stop skin cells from growing so quickly. Topical ointments, light therapy and medication can offer relief.");
        dict.put("Impetigo","Impetigo mainly affects infants and children.The main symptom is red sores that form around the nose and mouth. The sores rupture, ooze for a few days, then form a yellow-brown crust. Antibiotics shorten the infection and can help prevent spread to others.(It spreads by skin-to-skin contact i.e, handshakes or hugs)");

        dict.put("Fungal infection", "Fungal infections (also called mycoses) represent the invasion of tissues by one or more species of fungi. They range from superficial, localized skin conditions to deeper tissue infections.Mostly affect skin, hair, nails or mucous membranes.");
        dict.put("Allergy", "Allergies, also known as allergic diseases, are a number of conditions caused by hypersensitivity of the immune system to typically harmless substances in the environment.These diseases include hay fever, food allergies, atopic dermatitis, allergic asthma, and anaphylaxis.Common allergens include pollen and certain food.");
        dict.put("GERD", "This is a chronic disease that occurs when stomach acid or bile flows into the food pipe and irritates the lining.It is a digestive disorder that affects the lower esophageal sphincter (LES).");
        dict.put("Chronic cholestasis", "Cholestasis is defined as a decrease in bile flow due to impaired secretion by hepatocytes or to obstruction of bile flow through intra-or extrahepatic bile ducts. Therefore, the clinical definition of cholestasis is any condition in which substances normally excreted into bile are retained.");
        dict.put("Drug Reaction", "It is the abnormal reaction of your immune system to a medication.Any medication — over-the-counter, prescription or herbal — is capable of inducing a drug allergy.Dose-related adverse drug reactions represent an exaggeration of the drug's therapeutic effects.");
        dict.put("Peptic ulcer disease", "Peptic ulcer disease is a condition in which there are painful sores or ulcers in the lining of the stomach or the first part of the small intestine (the duodenum). Normally, a thick layer of mucus protects the stomach lining from the effect of its digestive juices. But many things can reduce this protective layer, allowing for ulcers to occur.");
        dict.put("AIDS", "Acquired immunodeficiency syndrome (AIDS) is a chronic, potentially life-threatening condition caused by the human immunodeficiency virus (HIV). By damaging your immune system, HIV interferes with your body's ability to fight the organisms that cause disease. HIV is a sexually transmitted infection (STI). It can also be spread by contact with infected blood or from mother to child during pregnancy, childbirth or breast-feeding.");
        dict.put("Diabetes", "Diabetes is a disease in which your blood glucose, or blood sugar, levels are too high. Glucose comes from the foods you eat. Insulin is a hormone that helps the glucose get into your cells to give them energy. With type 1 diabetes, your body does not make insulin. With type 2 diabetes, the more common type, your body does not make or use insulin well.");
        dict.put("Gastroenteritis", "With gastroenteritis, your stomach and intestines are irritated and inflamed. The cause is typically a viral or bacterial infection.Sometimes, also known as stomach flu.");
        dict.put("Bronchial Asthma", "Bronchial asthma is a medical condition which causes the airway path of the lungs to swell and narrow. Due to this swelling, the air path produces excess mucus making it hard to breathe, which results in coughing, short breath, and wheezing. The disease is chronic and interferes with daily working.");
        dict.put("Hypertension", "Hypertension (HTN or HT), also known as high blood pressure (HBP), is a long-term medical condition in which the blood pressure in the arteries is persistently elevated.Usually it is defined as blood pressure above 140/90, and is considered severe if the pressure is above 180/120.");
        dict.put("Migraine", "A migraine is a primary headache disorder characterized by recurrent headaches that are moderate to severe. Typically, the headaches affect one half of the head, are pulsating in nature, and last from two to 72 hours. Migraine headaches are sometimes preceded by warning symptoms. Triggers include hormonal changes, certain food and drink, stress and exercise.");
        dict.put("Cervical spondylosis", "Cervical spondylosis is a general term for age-related wear and tear affecting the spinal disks in your neck. As the disks dehydrate and shrink, signs of osteoarthritis develop, including bony projections along the edges of bones (bone spurs). Cervical spondylosis is very common and worsens with age.");
        dict.put("Paralysis (brain hemorrhage)", "A brain hemorrhage is bleeding in the brain.Also known as Intracerebral hemorrhage (ICH).It is when blood suddenly bursts into brain tissue, causing damage to your brain.This can quickly cause brain and nerve damage.Paralysis is the loss of muscle function in part of your body.It is one of the conditions resulting from brain hemorrhage.");

        dict.put("Jaundice", "Jaundice is a yellow discoloration of the skin, mucous membranes, and the whites of the eyes caused by increased amounts of bilirubin in the blood. Jaundice is a sign of an underlying disease process. Bilirubin is a by-product of the daily natural breakdown and destruction of red blood cells in the body.");
        dict.put("Malaria", "Malaria is a disease caused by a parasite. The parasite is transmitted to humans through the bites of infected mosquitoes. People who have malaria usually feel very sick, with a high fever and shaking chills." );
        dict.put("Chicken pox",  "A highly contagious viral infection which causes an itchy, blister-like rash on the skin.");
        dict.put("Dengue",  "Dengue is a mosquito-borne viral infection causing a severe flu-like illness and, sometimes causing a potentially lethal complication called severe dengue. The incidence of dengue has increased 30-fold over the last 50 years.");
        dict.put("Typhoid", "Typhoid is a bacterial infection that can lead to a high fever, diarrhea, and vomiting. It can be fatal. It is caused by the bacteria Salmonella typhi. The infection is often passed on through contaminated food and drinking water, and it is more prevalent in places where handwashing is less frequent." );
        dict.put("hepatitis A", "Hepatitis A is preventable by vaccine. It spreads from contaminated food or water or contact with someone who is infected.\n" +
                "Symptoms include fatigue, nausea, abdominal pain, loss of appetite and low-grade fever.\n" +
                "The condition clears up on its own in one or two months. Rest and adequate hydration can help.");
        dict.put("hepatitis B", "Hepatitis B is a viral infection that attacks the liver and can cause both acute and chronic disease. The virus is most commonly transmitted from mother to child during birth and delivery, as well as through contact with blood or other body fluids.");
        dict.put("hepatitis C", "Hepatitis C is a liver disease caused by the hepatitis C virus (HCV): the virus can cause both acute and chronic hepatitis, ranging in severity from a mild illness lasting a few weeks to a serious, lifelong illness. Hepatitis C is a major cause of liver cancer.");
        dict.put("hepatitis D","Hepatitis D, also known as the hepatitis delta virus, is an infection that causes the liver to become inflamed. This swelling can impair liver function and cause long-term liver problems, including liver scarring and cancer. The condition is caused by the hepatitis D virus (HDV).");
        dict.put("hepatitis E", "Hepatitis E is a viral infection that causes liver inflammation and damage. Inflammation is swelling that occurs when tissues of the body become injured or infected. Inflammation can damage organs. Viruses invade normal cells in your body. The hepatitis E virus has different types that spread in different ways.");
        dict.put("Alcoholic hepatitis","Alcoholic hepatitis is inflammation of the liver caused by drinking alcohol. Alcoholic hepatitis is most likely to occur in people who drink heavily over many years. However, the relationship between drinking and alcoholic hepatitis is complex.");
        dict.put("Tuberculosis","Tuberculosis (TB) is a potentially serious infectious disease that mainly affects your lungs. The bacteria that cause tuberculosis are spread from one person to another through tiny droplets released into the air via coughs and sneezes.");
        dict.put("Common Cold", "The common cold is a viral infection of your nose and throat (upper respiratory tract). It's usually harmless, although it might not feel that way. Many types of viruses can cause a common cold.t");
        dict.put("Pneumonia", "Pneumonia is an infection that inflames the air sacs in one or both lungs. The air sacs may fill with fluid or pus (purulent material), causing cough with phlegm or pus, fever, chills, and difficulty breathing. A variety of organisms, including bacteria, viruses and fungi, can cause pneumonia.");


        dict.put("Viral Fever", "A viral fever is any fever that's caused by an underlying viral illness. A variety of viral infections can affect humans, from the common cold to the flu. A low-grade fever is a symptom of many viral infections. But some viral infections, such as dengue fever, can cause a higher fever");
        dict.put("Acid Reflux", "Acid reflux is a common condition that features a burning pain, known as heartburn, in the lower chest area. It happens when stomach acid flows back up into the food pipe. Gastroesophageal reflux disease (GERD) is diagnosed when acid reflux occurs more than twice a week.");
        dict.put("Bulimia", "Bulimia is a potentially life-threatening eating disorder.\n" +
                "People with this condition binge eat. They then take steps to avoid weight gain. Most commonly, this means vomiting (purging). But it can also mean excessive exercising or fasting.\n" +
                "Treatments include counselling, medication and nutrition education");
        dict.put("Stress", "Stress is a feeling of emotional or physical tension. It can come from any event or thought that makes you feel frustrated, angry, or nervous. Stress is your body's reaction to a challenge or demand. In short bursts, stress can be positive, such as when it helps you avoid danger or meet a deadline.");
        dict.put("Stomach Flu", "Stomach flu is typically spread by contact with an infected person or through contaminated food or water.\n" +
                "Diarrhoea, cramps, nausea, vomiting and low-grade fever are common symptoms.\n" +
                "Avoiding contaminated food and water and washing hands can often help prevent infection. Rest and rehydration are the mainstays of treatment.");

        if(dict.containsKey(data))
        return dict.get(data);
        else
            return "Not Available";
    }

    public static String remove_(String s)
    {
        String symptom = s.replace("_", " ");
        symptom = symptom.substring(0,1).toUpperCase() + symptom.substring(1);
        return symptom;
    }
    public static String add_(String s)
    {
        String symptom = s.replace(" ", "_");
        symptom = symptom.substring(0,1).toLowerCase() + symptom.substring(1);
        return symptom;
    }

}
