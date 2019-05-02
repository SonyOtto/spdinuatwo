package com.spdinua.two;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ResultsActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private TextView mTextViewResult2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent intent = getIntent();
        String message = intent.getStringExtra(SearchActivity.EXTRA_MESSAGE);

        mTextViewResult = findViewById(R.id.textView4);
        mTextViewResult2 = findViewById(R.id.textView6);
        OkHttpClient client = new OkHttpClient();
        String DBlink = "http://www.strokypozovnoidavnosti.in.ua/api/product/read_one.php?article=";
        String url = DBlink + message;

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String myResponse = response.body().string();

                ResultsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject json = new JSONObject(myResponse);
                            mTextViewResult.setText(getString(R.string.NamePart1,json.getString("name")));
                            mTextViewResult2.setText(getString(R.string.BasisTermsNote,json.getString("basis"),json.getString("term"),json.getString("note")));
                        } catch (JSONException e) {
                            e.printStackTrace();
                                                    }
                    }
                });
            }
        });
    }
    public void OpenMainView(View view) {
        Intent intent = new Intent(this, MainLayoutActivity.class);
        startActivity(intent);
    }
}