package com.example.timeselection;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doWork();
    }
    public void doWork(){
        Button b1 = (Button)findViewById(R.id.bt1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnalogClock analog = new AnalogClock(MainActivity.this);
                ((LinearLayout)findViewById(R.id.mylayout)).addView(analog);
            }
        });

        Button b2 = (Button)findViewById(R.id.bt2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                TimePickerDialog.OnTimeSetListener callback = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        ((TextView)findViewById(R.id.txtdate)).setText(hourOfDay+"-"+minute+"@@@"+view.getCurrentHour()+""+view.getCurrentMinute());
                    }
                };
                TimePickerDialog time = new TimePickerDialog(MainActivity.this,callback,11,30,true);
                time.show();
            }

        });

    }
}
