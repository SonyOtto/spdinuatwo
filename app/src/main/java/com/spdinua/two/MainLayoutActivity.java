package com.spdinua.two;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
    }

        /** Called when the user taps the next_button */
        public void OpenNewView(View view) {
            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);
        }
}
