package com.codingblocks.workshopapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etKm,

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.textView2);
        b1 = (Button) findViewById(R.id.button2);

        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("Welcome");
            }
        };
        b1.setOnClickListener(ocl);

    }
}
