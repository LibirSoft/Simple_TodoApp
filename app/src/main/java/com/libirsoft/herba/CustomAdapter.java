package com.libirsoft.herba;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    ArrayList<To_DO> toDo;
    Context context;


    public CustomAdapter(@NonNull Context context, ArrayList<To_DO> toDo) {
        super(context, R.layout.list_item_layout, toDo);

        this.toDo = toDo;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.list_item_layout, null);
        TextView dateviewv = v.findViewById(R.id.date_text);
        TextView toDOview = v.findViewById(R.id.todo_text);
        CheckBox checkBox = v.findViewById(R.id.is_done_box);
        dateviewv.setTextColor(Color.RED);

        dateviewv.setText(toDo.get(position).DATE);
        toDOview.setText(toDo.get(position).TODO);


        return v;
    }
}

