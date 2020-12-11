package com.example.level3;

import androidx.appcompat.app.AppCompatActivity;

import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity extends AppCompatActivity {
    String in;
    String title;
    String shareUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);
        in=getIntent().getStringExtra("in");
        title=getIntent().getStringExtra("title");
        shareUser=getIntent().getStringExtra("shareUser");

        WebView webView=findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(in);


    }
}