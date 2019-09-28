package com.example.io_file_2activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et_filename  = (EditText)findViewById(R.id.edit_filename);
        final EditText et_content  = (EditText)findViewById(R.id.edit_content);
        final ArrayList<String> filenamelist = new ArrayList<>();
        filenamelist.add("Hello");
        Button btn_clear = (Button)findViewById(R.id.btn_nhapmoi);
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_filename.setText("");
                et_content.setText("");
            }
        });
        Button btn_save = (Button)findViewById(R.id.btn_luu);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = et_filename.getText().toString();
                filenamelist.add(filename);
                //docfile
                SharedPreferences.Editor editor = getSharedPreferences("File_Text",MODE_PRIVATE).edit();
                editor.putString(filename,et_content.getText().toString());
                editor.apply();
            }
        });
        Button btn_view = (Button)findViewById(R.id.btn_xem);
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
