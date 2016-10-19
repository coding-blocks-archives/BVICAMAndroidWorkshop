package com.codingblocks.workshopapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etKm, etMin;
    TextView tvFare;
    Button btnCalcFare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etKm = (EditText) findViewById(R.id.etKm);
        etMin = (EditText) findViewById(R.id.etMin);
        btnCalcFare = (Button) findViewById(R.id.btnCalcFare);
        tvFare = (TextView) findViewById(R.id.tvFare);

        btnCalcFare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float km = Float.valueOf(etKm.getText().toString());
                int min = Integer.valueOf(etMin.getText().toString());

                final float fare = calcFare(km, min);

                //tvFare.setText("Rs. " + fare);

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Fare")
                        .setMessage("Your total fare is Rs. " + fare)
                        .setPositiveButton("Pay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tvFare.setText("Paid Rs. " + fare);
                                tvFare.setTextColor(Color.GREEN);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tvFare.setText("Canceled");
                                tvFare.setTextColor(Color.RED);
                            }
                        })
                        .show();
            }
        });



    }

    float calcFare(float km, int min) {
        float fare = 25;

        if (km > 2) {
            fare += (km-2) * 9;
        }

        if (min > 15) {
            fare += (min - 15);
        }

        return fare;
    }
}
