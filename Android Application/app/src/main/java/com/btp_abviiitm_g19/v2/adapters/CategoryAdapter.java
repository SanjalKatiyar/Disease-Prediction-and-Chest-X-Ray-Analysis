package com.btp_abviiitm_g19.v2.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.btp_abviiitm_g19.v2.Activities.Constants;
import com.btp_abviiitm_g19.v2.Activities.SymptomsActivity;
import com.btp_abviiitm_g19.v2.R;

import java.util.ArrayList;

public class CategoryAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> categories;

    public CategoryAdapter(Context context, ArrayList<String> categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public String getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
       View v = convertView;
       if(v==null)
           v = LayoutInflater.from(context).inflate(R.layout.sample_category, null, false);

        TextView categoryText = v.findViewById(R.id.category_text);
        categoryText.setText(getItem(position));
        LinearLayout ll = v.findViewById(R.id.ll);

        categoryText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, SymptomsActivity.class);
                i.putExtra(Constants.sympIndex, position);
                context.startActivity(i);
            }
        });
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, SymptomsActivity.class);
                i.putExtra(Constants.sympIndex, position);
                context.startActivity(i);
            }
        });
       return v;
    }
}
