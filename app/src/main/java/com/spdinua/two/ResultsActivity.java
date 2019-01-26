package com.spdinua.two;

import android.content.Intent;
import android.provider.Settings;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ResultsActivity extends AppCompatActivity {


    ConstraintLayout mparent;
    LayoutInflater layoutInflater;
    TextView name4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent intent = getIntent();
        String message = intent.getStringExtra(SearchActivity.EXTRA_MESSAGE);
//INFLATER
        name4 = findViewById(R.id.textView4);
        layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View myView = layoutInflater.inflate(R.layout.activity_results, null, false);
        mparent.addView(myView);

    }
    public static void main(String [] args) {
        String nameDB = "nameDB";
        String basisDB = "basisDB";
        String termDB = "termDB";
        String noteDB = "noteDB";
        String DBlink = "http://www.strokypozovnoidavnosti.in.ua/api/product/read_one.php?article=666";


        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(DBlink).openConnection();

            connection.connect();

            StringBuilder sb = new StringBuilder();

        if (
                HttpURLConnection.HTTP_OK == connection.getResponseCode()){
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "cp1251"));
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            System.out.println(sb.toString());
        } else {
            System.out.println( "fail:" + connection.getResponseCode() + " , " + connection.getResponseMessage());
        }

        } catch (Throwable cause) {
            cause.printStackTrace();
        }
        finally {
            if (connection !=null) {
                connection.disconnect ();
            }

        //works well with lib
        /*mTextViewResult = findViewById(R.id.textView4);
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

                    String json = myResponse;

                   ResultsActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextViewResult.setText(myResponse);

                    };
                });
            }
        };
    });*/
        //Displaying NAME, BASIS, TERM AND NOTE parameters from DataBase
        //TextView textView = findViewById(R.id.textView4);
        //String text1 = getString(R.string.NamePart1, nameDB);
        //textView.setText(text1);
        //TextView textView2 = findViewById(R.id.textView6);
        //String text2 = getString(R.string.BasisTermsNote, basisDB, termDB, noteDB);
        //textView2.setText(text2);
}


}
    public void run (String[] args) throws Exception
    {
        String nameDB = "nameDB";
        //Displaying NAME, BASIS, TERM AND NOTE parameters from DataBase
        TextView textView = findViewById(R.id.textView4);
        String text1 = getString(R.string.NamePart1, nameDB);
        textView.setText(text1);
    }
}