package com.lanou3g.gifttheory.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseActivity;
import com.lanou3g.gifttheory.bean.HomeItemBean;

public class StrategyActivity extends BaseActivity {
    private TextView likeTv,shareTv,commentsTv;
    private ImageView backIv;
    private HomeItemBean.DataBean.ItemsBean itemsBean;
    private WebView webView;
    @Override
    protected int bindLayout() {
        return R.layout.activity_strategy;
    }

    @Override
    protected void initView() {
        backIv = (ImageView) findViewById(R.id.iv_back_strategy);
        likeTv = (TextView) findViewById(R.id.tv_favourite_strategy);
        shareTv = (TextView) findViewById(R.id.tv_share_strategy);
        commentsTv = (TextView) findViewById(R.id.tv_comments_strategy);
        webView = (WebView) findViewById(R.id.webView_strategy);
        itemsBean = getIntent().getParcelableExtra("itemsBean");
        initWebView();
    }

    private void initWebView() {
        //不调用
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        WebSettings webSettings = webView.getSettings();
        //让webview 能够执行javascript
        webSettings.setJavaScriptEnabled(true);

        //让javascript可以自动打开windows
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        // 设置缓存
        webSettings.setAppCacheEnabled(true);

        // 设置缓存模式

        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        // 支持缩放(适配到当前屏幕)
        webSettings.setSupportZoom(true);

        // 将图片调整到合适的大小
        webSettings.setUseWideViewPort(true);

        // 支持内容重新布局,一共有四种方式
        // 默认的是NARROW_COLUMNS
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        // 设置可以被显示的屏幕控制
        webSettings.setDisplayZoomControls(true);


        // 设置默认字体大小
        webSettings.setDefaultFontSize(12);
        webView.loadUrl(itemsBean.getUrl());
    }

    @Override
    protected void initData() {
        likeTv.setText(itemsBean.getLikes_count()+"");
    }

    @Override
    protected void bindEvent() {
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
