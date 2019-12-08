package com.btp_abviiitm_g19.v2.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.btp_abviiitm_g19.v2.Activities.Constants;
import com.btp_abviiitm_g19.v2.R;

import java.util.ArrayList;
import java.util.Set;

public class SymptomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> symptoms;
    private Set<String> selectedSymptoms;

    public SymptomAdapter(Context context, ArrayList<String> symptoms, Set<String> selectedSymptoms) {
        this.context = context;
        this.symptoms = symptoms;
        this.selectedSymptoms = selectedSymptoms;
    }

    public Set<String> getSelectedSymptoms() {
        return selectedSymptoms;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
         View v = convertView;
        if(v==null)
            v = LayoutInflater.from(context).inflate(R.layout.sample_symptom, null, false);

        TextView text = v.findViewById(R.id.symptom_name);
        final CardView cardView = v.findViewById(R.id.card);
        String symptom = getItem(position).replace("_", " ");
        symptom = symptom.substring(0,1).toUpperCase() + symptom.substring(1);
        text.setText(symptom);
        final ImageView add = v.findViewById(R.id.add);
        // change icon
        if(selectedSymptoms!=null&&selectedSymptoms.contains(getItem(position))) {
            add.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_added));
            cardView.setCardBackgroundColor(Color.parseColor("#e6e6fa"));
        } else {
            add.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_add));
            cardView.setCardBackgroundColor(Color.parseColor("#ffffff"));
        }

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add the symptom to list
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if(selectedSymptoms!=null&&selectedSymptoms.contains(getItem(position)))
                {
                    //remove symptom and change icon
                    selectedSymptoms.remove(getItem(position));
                    add.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_add));
                    cardView.setCardBackgroundColor(Color.parseColor("#ffffff"));
                }
                else
                {   if(selectedSymptoms!=null)
                    selectedSymptoms.add(getItem(position));
                    add.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_added));
                    cardView.setCardBackgroundColor(Color.parseColor("#e6e6fa"));

                }
                editor.putStringSet(Constants.symptoms, selectedSymptoms).apply();
            }
        });
        return v;
    }
}
