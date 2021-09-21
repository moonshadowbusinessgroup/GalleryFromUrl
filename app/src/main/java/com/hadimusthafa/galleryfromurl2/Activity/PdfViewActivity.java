package com.hadimusthafa.galleryfromurl2.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.hadimusthafa.galleryfromurl2.R;

public class PdfViewActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);
        webView = findViewById(R.id.webView);
        String pdf;
        pdf = (getIntent().getExtras().getString("pdf"));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().supportZoom();
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setWebChromeClient(new WebChromeClient());

        webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + pdf);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
