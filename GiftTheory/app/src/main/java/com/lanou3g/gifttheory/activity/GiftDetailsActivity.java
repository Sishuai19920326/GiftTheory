package com.lanou3g.gifttheory.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.adapter.HomeRecyclerViewAdapter;
import com.lanou3g.gifttheory.base.BaseActivity;
import com.lanou3g.gifttheory.bean.ListItemBean;

import java.util.List;

public class GiftDetailsActivity extends BaseActivity {
    private ImageView backIv;
    private ListItemBean.DataBean.ItemsBean itemsBean;
    private WebView webView;
    private TextView descriptionTv , nameTv , priceTv;
    private ConvenientBanner convenientBanner;
    private List<String> bannerImageList;
    @Override
    protected int bindLayout() {
        return R.layout.activity_gift_details;
    }

    @Override
    protected void initView() {
        backIv = (ImageView)findViewById(R.id.iv_back_gift_details);
        descriptionTv = (TextView) findViewById(R.id.tv_short_description_gift_details);
        nameTv = (TextView) findViewById(R.id.tv_name_gift_details);
        priceTv = (TextView) findViewById(R.id.tv_price_gift_details);
        convenientBanner = (ConvenientBanner)findViewById(R.id.banner_gift_details);
        webView = (WebView) findViewById(R.id.webView_gift_details);
    }

    @Override
    protected void initData() {
        itemsBean = getIntent().getParcelableExtra("itemsBean");
        descriptionTv.setText(itemsBean.getShort_description());
        nameTv.setText(itemsBean.getName());
        String price;
        if (itemsBean.getPrice() == null) {
            price = "¥ " + itemsBean.getSkus().get(0).getPrice() + "";
        } else {
            price = "¥ " + itemsBean.getPrice() + "";
        }
        priceTv.setText(price);

        initBanner();
        initWebView();
    }
    //初始化webView
    private void initWebView() {
        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);//让webview 能够执行javascript
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);//让javascript可以自动打开windows
        webSettings.setSupportZoom(true);// 支持缩放(适配到当前屏幕)
        webSettings.setDefaultFontSize(12); // 设置默认字体大小
        webSettings.setUseWideViewPort(true); // 将图片调整到合适的大小
        webSettings.setDisplayZoomControls(true);// 设置可以被显示的屏幕控制
        // 支持内容重新布局,一共有四种方式
        // 默认的是NARROW_COLUMNS
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setAppCacheEnabled(true);// 设置缓存
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); // 设置缓存模式
        webView.loadDataWithBaseURL(null,getNewContent(itemsBean.getDetail_html()),"text/html","utf-8",null);

    }

    private String getNewContent(String detail_html) {
        StringBuilder sb = new StringBuilder();
        sb.append(itemsBean.getDetail_html());
        return sb.toString();
    }

    //初始化列表
    private void initBanner() {
        bannerImageList = itemsBean.getImage_urls();
        convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, bannerImageList);
        if (bannerImageList.size()>1){
            convenientBanner.setPointViewVisible(true);
            convenientBanner.setPageIndicator(new int[]{R.mipmap.ic_wu_dian,R.mipmap.ic_red_dian});
        }else {
            convenientBanner.setPointViewVisible(false);
        }
    }

    @Override
    protected void bindEvent() {
        //不调用系统浏览器
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.anim_go,R.anim.anim_back);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public class NetworkImageHolderView implements Holder<String> {
        private ImageView imageView;
        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            Glide.with(context).load(data).into(imageView);
        }
    }
}
