package com.example.bmicalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    int intWeight;
    int intHeight;
    int calculatedBmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText weight = (EditText) findViewById(R.id.txtWeight);
        final EditText height = (EditText)findViewById(R.id.txtHeight);
        final EditText bmi = (EditText)findViewById(R.id.txtBmi);
        Button button = (Button)findViewById(R.id.btnBMI);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        button.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view){
                intWeight = Integer.parseInt(weight.getText().toString());
                intHeight = Integer.parseInt(height.getText().toString());
                calculatedBmi = Float.parseFloat(bmi.getText().toString());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("key1", intWeight);
                editor.putInt("key2", intHeight);
                editor.putFloat("key3", calculatedBmi);
                editor.commit();
                startActivity(new Intent(MainActivity.this, Bmi.class));

            }
        });
    }
}