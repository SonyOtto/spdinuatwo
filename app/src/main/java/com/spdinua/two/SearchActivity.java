package com.spdinua.two;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    /** Called when the user taps the next_button on SearchActivily layout */
    public void OpenResultsView(View view) {
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }
}
