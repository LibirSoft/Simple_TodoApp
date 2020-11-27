package com.libirsoft.herba;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText todo_text;
    Button post_btn;
    ListView to_do_list;
    ArrayList<To_DO> toDo;
    DbHelper dbHelper;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        todo_text = findViewById(R.id.to_do_editttext);
        post_btn = findViewById(R.id.add_btn);
        to_do_list = findViewById(R.id.toDo_list);
        dbHelper = new DbHelper(getApplicationContext());
        dbHelper.openDB();
        toDo = dbHelper.getValue_list();


        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), toDo);
        //-----------------------------------------------------
        post_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                String cuurentdate = DateFormat.getDateInstance().format(calendar.getTime());
                dbHelper.insertData(todo_text.getText().toString(),cuurentdate );
                todo_text.setText("");


            }
        });


        to_do_list.setAdapter(adapter);


    }
}