package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {


    private SharedPreferences prefs;
    private TextView prefText;
    private Button navigateToSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        prefText = findViewById(R.id.prefText);
        prefs = getSharedPreferences("com.example.project", Context.MODE_PRIVATE);

        navigateToSecondActivity = findViewById(R.id.navigateToSecondActivity);
        navigateToSecondActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onButtonClick();
            }
        });

    }

    protected void onResume() {
        super.onResume();
        prefText.setText(prefs.getString("text", "No pref found"));
    }

    private void onButtonClick() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

}
