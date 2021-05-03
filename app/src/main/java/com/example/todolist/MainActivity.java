package com.example.todolist;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> bsaList;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bsaList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, R.layout.list_view_layout, bsaList);
        listView = findViewById(R.id.id_list_view);

        listView.setAdapter(arrayAdapter);


        // Hvad sker der når du Clicker på Item på Listen
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            }
        });
        editText = findViewById(R.id.id_edit_text);
    }


    // Gør det muligt at add nye Items på listen.
    public void addItemToList(View view) {

        bsaList.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();
        editText.setText("");


    }
}