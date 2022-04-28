package com.example.project;

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

        prefs = getPreferences(MODE_PRIVATE);

        prefText = findViewById(R.id.prefText);
        prefText.setText(prefs.getString("MyAppPreferenceString", "No pref found"));

        navigateToSecondActivity = findViewById(R.id.navigateToSecondActivity);
        navigateToSecondActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onButtonClick();
            }
        });


    }

    private void onButtonClick() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

}
