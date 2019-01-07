package com.spdinua.two;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent intent = getIntent();
        String nameDB = "nameDB";
        String basisDB = "basisDB";
        String termDB = "termDB";
        String noteDB = "noteDB";

        // Displaying NAME parameter from DataBase
        TextView textView = findViewById(R.id.textView4);
        String text1 = getString(R.string.NamePart1, nameDB);
        textView.setText(text1);
        TextView textView2 = findViewById(R.id.textView6);
        String text2 = getString(R.string.BasisTermsNote, basisDB, termDB, noteDB);
        textView2.setText(text2);

    }
}