package com.example.testgui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView ketqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AlertDialog.Builder mydialog = new AlertDialog.Builder(this);
        mydialog.setTitle("Message");
        mydialog.setIcon(R.drawable.images);
        ketqua = (TextView)findViewById(R.id.ketqua);
//        final  CharSequence[] item = {"Đỏ","Vàng","Cam"};
        //Yes message
//        mydialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                ketqua.setText(item[i].toString());
//            }
//        });

            //cleck items
//        mydialog.setItems(item, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                ketqua.setText(item[i].toString());
//            }
//        });
//

        final CharSequence[] items = {"Đỏ","Vàng","Cam"};
        final boolean[] arraycheck = {false,false,false};
        mydialog.setMultiChoiceItems(items, arraycheck, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                arraycheck[i] = b;
            }
        });
        mydialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String st = "";
                for(int j = 0; j<items.length;j++){
                    if(arraycheck[j])
                        st += items[j].toString() + "\n";
                    ketqua.setText(st);
                }
            }
        });
        AlertDialog alertDialog = mydialog.create();
        alertDialog.show();

    }
}
