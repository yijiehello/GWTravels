package com.gwtravel.view.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.gwtravel.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebActivity extends BaseActivity {

    @BindView(R.id.btn_back)
    ImageView btn_back;

    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.webview)
    WebView webview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        init();
    }

    private void init() {


        tv_title.setText(getIntent().getStringExtra("title").toString());
        webview.loadUrl(getIntent().getStringExtra("url").toString());

        webview.setWebViewClient(new WebViewClient(){

        });
    }


    @OnClick({R.id.btn_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
        }
    }

}
