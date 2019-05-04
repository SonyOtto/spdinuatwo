package com.spdinua.two;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class SearchActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.spdinua.two.MESSAGE";
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    /**
     * Called when the user taps the next_button on SearchActivily layout
     */
    public void OpenResultsView(View view) {
        Intent intent = new Intent(this, ResultsActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText3);
        String message = editText.getText().toString();

        //Check for null string
        Integer int2 = 1;
                try {
                    int2 = Integer.parseInt(editText.getText().toString());
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
       //Check for numbers only, message length from 4 to 5, input in range from 655 to 1143 (DB limits)
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
