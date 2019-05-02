package com.spdinua.two;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class SearchActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.spdinua.two.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    /**
     * Called when the user taps the next_button on SearchActivily layout
     */
    public void OpenResultsView(View view) {
        Intent intent = new Intent(this, ResultsActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText3);
        String message = editText.getText().toString();

        Integer int2 = Integer.parseInt(editText.getText().toString());

       if (message.matches("[^0-9]+") || message.length() <3 || message.length() >5) {
            editText.setError("Введіть тільки цифри. Мінімум 3.");
            } else {
           if (int2 < 655 || int2 > 1143) {
               editText.setError("У проміжку статтей 655 - 1143");
           } else {
               intent.putExtra(EXTRA_MESSAGE, message);
               startActivity(intent);
           }
        }
    }
}
