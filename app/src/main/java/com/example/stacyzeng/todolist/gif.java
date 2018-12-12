package com.example.stacyzeng.todolist;
import org.json.*;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.giphy.sdk.core.network.api.GPHApi;
import com.giphy.sdk.core.network.api.GPHApiClient;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.enums.MediaType;
import com.giphy.sdk.core.network.api.CompletionHandler;
import com.giphy.sdk.core.network.api.GPHApi;
import com.giphy.sdk.core.network.api.GPHApiClient;
import com.giphy.sdk.core.network.response.ListMediaResponse;
import com.giphy.sdk.core.network.response.MediaResponse;

import java.net.URLEncoder;

public class gif extends AppCompatActivity {
    GPHApi client = new GPHApiClient("iaQ0fXLK5VFR0xeLZ7EqpYs6AwphzvUj");
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);
        final WebView gif = (WebView) findViewById(R.id.gif);
        final ProgressDialog progressDialog = ProgressDialog.show(gif.this, "", "Loading...",true);

        gif.getSettings().setJavaScriptEnabled(true);
        gif.getSettings().setPluginState(WebSettings.PluginState.ON);
        gif.getSettings().setAllowFileAccess(true);

        client.random("Good job", MediaType.gif, null, new CompletionHandler<MediaResponse>() {
            @Override
            public void onComplete(MediaResponse result, Throwable e) {
                if (result == null) {
                    // Do what you want to do with the error
                } else {
                    if (result.getData() != null) {
                        Log.v("giphy", result.getData().getUrl());
                        gif.loadUrl(result.getData().getUrl()); // Here You can put your Url
                        gif.setWebChromeClient(new WebChromeClient() {
                        });

                    } else {
                        Log.e("giphy error", "No results found");
                    }
                }
            }
        });


        gif.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
            public void onPageFinished(WebView view, String url) {
                progressDialog.dismiss();
                //Toast.makeText(context, "Page Load Finished", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
