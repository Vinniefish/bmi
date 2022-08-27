package com.example.electriccarfinancing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Bmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        TextView computedBmi =
                (TextView)findViewById(R.id.txtcomputedBmi);
        ImageView image = (ImageView)findViewById(R.id.imgYears);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int intWeight = sharedPref.getInt ("key1", 0);
        int intHeight = sharedPref.getInt("key2", 0);
        float calculatedBmi = sharedPref.getFloat("key3", 0);
        float calculatedBmi;

        calculatedBmi = (intWeight * 703) / intHeight * intHeight;


        DecimalFormat currency = new DecimalFormat("$###,###.##");
        computedBmi.setText("Monthly Payment " + currency. format(calculatedBmi));


    }

}

