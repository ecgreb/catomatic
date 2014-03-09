package com.example.catomatic;

import com.example.catomatic.entity.Cat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CatListAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<Cat> cats;

    public CatListAdapter(Context context, ArrayList<Cat> cats) {
        this.context = context;
        this.cats = cats;
    }

    @Override
    public int getCount() {
        return cats.size();
    }

    @Override
    public Object getItem(int position) {
        return cats.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view = LayoutInflater.from(context)
                .inflate(R.layout.list_item_cat, parent, false);

        final TextView name = (TextView) view.findViewById(R.id.name);
        final TextView age = (TextView) view.findViewById(R.id.age);
        final TextView shortDescription = (TextView) view.findViewById(R.id.short_description);

        name.setText(cats.get(position).name);
        age.setText(Integer.toString(cats.get(position).ageInMonths));
        shortDescription.setText(cats.get(position).shortDescription);

        return view;
    }
}
