package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {
    String arr[] = {"IPAD","SAMSUNG","OPPO","NOKIA","HTC","G PHONE","FPT","SONY","MOTOROLA"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView selection = (TextView)findViewById(R.id.selection);
        final GridView gv = (GridView) findViewById(R.id.gridView);
        ArrayAdapter<String> data = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);
        gv.setAdapter(data);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selection.setText(arr[i]);
            }
        });

    }
}
