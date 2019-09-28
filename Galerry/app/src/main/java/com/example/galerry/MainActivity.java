package com.example.galerry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add(R.drawable.a);
        list.add(R.drawable.da);
        list.add(R.drawable.dit22222);
        list.add(R.drawable.edit);
        list.add(R.drawable.edit2);
        list.add(R.drawable.sang);
        list.add(R.drawable.xoaphong2);
        final ImageView imageView = (ImageView) findViewById(R.id.image_mt);
        Gallery gallery = (Gallery)findViewById(R.id.gallery_mt);
        MyAdapter myAdapter = new MyAdapter(list,MainActivity.this);
        gallery.setAdapter(myAdapter);
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                imageView.setImageResource(list.get(i));
            }
        });
    }
}
