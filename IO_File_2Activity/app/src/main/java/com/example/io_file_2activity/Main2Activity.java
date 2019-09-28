package com.example.io_file_2activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final EditText et_content = (EditText)findViewById(R.id.edit_content);
        final ArrayList<String> filenamelist = new ArrayList<>();
        final SharedPreferences sharedPreferences = getSharedPreferences("File_Text",MODE_PRIVATE);
        Map<String,?> list = sharedPreferences.getAll();
        for(Map.Entry<String,?> entry:list.entrySet()){
            filenamelist.add(entry.getKey());
        }
        final Spinner sp_filename = (Spinner)findViewById(R.id.spiner_files);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,filenamelist);
        sp_filename.setAdapter(adapter);
        sp_filename.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences sharedPreferences1 = getSharedPreferences("File_Text",MODE_PRIVATE);
                String conttent = sharedPreferences.getString(filenamelist.get(i),"");
                et_content.setText(conttent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
