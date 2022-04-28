package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private EditText editPrefsEditText;
    private SharedPreferences.Editor editPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editPrefsEditText = findViewById(R.id.editPrefs);

        prefs = getSharedPreferences("com.example.project", Context.MODE_PRIVATE);
        editPrefs =  prefs.edit();
    }

    public void storePrefs(View view) {
        String prefs = editPrefsEditText.getText().toString();
        Log.d("", "onCreate: " + prefs);

        editPrefs.putString("text", prefs);
        editPrefs.commit();
        editPrefs.apply();

        this.finish();
    }
}