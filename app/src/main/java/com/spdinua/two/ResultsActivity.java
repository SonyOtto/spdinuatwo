package com.spdinua.two;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ResultsActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent intent = getIntent();
        String nameDB = "nameDB";
        String basisDB = "basisDB";
        String termDB = "termDB";
        String noteDB = "noteDB";
        String message = intent.getStringExtra(SearchActivity.EXTRA_MESSAGE);

        mTextViewResult = findViewById(R.id.textView4);
        OkHttpClient client = new OkHttpClient();
        String DBlink = "http://www.strokypozovnoidavnosti.in.ua/api/product/read_one.php?article=";
        String url = DBlink + message;

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();

                    ResultsActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextViewResult.setText(myResponse);
                        }
                    });
                }
            }
        });


        // Displaying NAME, BASIS, TERM AND NOTE parameters from DataBase
        //TextView textView = findViewById(R.id.textView4);
        //String text1 = getString(R.string.NamePart1, nameDB);
        //textView.setText(text1);
        TextView textView2 = findViewById(R.id.textView6);
        String text2 = getString(R.string.BasisTermsNote, basisDB, termDB, noteDB);
        textView2.setText(text2);
    }
}