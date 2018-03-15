package com.itsm.xkitsm.piwen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Desc
 * Created by xupeng on 2018/1/11.
 */

public class MessageWebview extends Activity {
    WebView webWebview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_webview);
        webWebview = (WebView) findViewById(R.id.web_webview);
        initPage(getIntent().getStringExtra("url"));
    }

    private void initPage(String filePath) {

        webWebview.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        webWebview.loadUrl(filePath);
        WebSettings webSettings = webWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    public static void start(Context context, String url) {
        Intent intent = new Intent(context, MessageWebview.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }
}
