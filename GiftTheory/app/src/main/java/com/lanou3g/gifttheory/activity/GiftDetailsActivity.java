package com.lanou3g.gifttheory.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseActivity;
import com.lanou3g.gifttheory.base.NewBaseActivity;
import com.lanou3g.gifttheory.bean.ListItemBean;
import com.lanou3g.gifttheory.util.MyGridView;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

public class GiftDetailsActivity extends NewBaseActivity {
    private ImageView backIv;
    private ListItemBean.DataBean.ItemsBean itemsBean;
    private WebView webView;
    private TextView descriptionTv , nameTv , priceTv;
    private ConvenientBanner convenientBanner;
    private List<String> bannerImageList;
    private ScrollView scrollView;
    private RelativeLayout channelsRl,sizeDetailsRl;
    private FloatingActionButton toTopFab;
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
        scrollView = (ScrollView) findViewById(R.id.scroll_view);
        channelsRl = (RelativeLayout) findViewById(R.id.rl_channels_gift_details);
        toTopFab = (FloatingActionButton) findViewById(R.id.fab_to_top_gift_details);
        sizeDetailsRl = (RelativeLayout) findViewById(R.id.rl_size_gift_details);
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
        //webView不调用系统浏览器的方法
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);//让webview 能够执行javascript
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);//让javascript可以自动打开windows
        webSettings.setSupportZoom(true);// 支持缩放(适配到当前屏幕)
        webSettings.setDefaultFontSize(12); // 设置默认字体大小
//        webSettings.setUseWideViewPort(true); // 将图片调整到合适的大小  这个方法会和加载html内容自适应方法冲突

        webSettings.setDisplayZoomControls(true);// 设置可以被显示的屏幕控制
        // 支持内容重新布局,一共有四种方式
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setAppCacheEnabled(true);// 设置缓存
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); // 设置缓存模式
        webView.loadDataWithBaseURL(null,getNewContent(itemsBean.getDetail_html()),"text/html","utf-8",null);

    }
    //把html网址的内容变成自适应屏幕
    private String getNewContent(String detail_html) {
        Document document = Jsoup.parse(detail_html);
        Elements elements = document.getElementsByTag("img");
        for (Element element : elements) {
            element.attr("width","100%").attr("height","auto");
        }
        return document.toString();
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
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY  - oldScrollY > 100){
                    channelsRl.setVisibility(View.VISIBLE);
                }
                if (scrollY - oldScrollY < 0){
                    toTopFab.setVisibility(View.VISIBLE);
                }else {
                    toTopFab.setVisibility(View.GONE);
                }
            }
        });
        //返回按钮
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.anim_go,R.anim.anim_back);
            }
        });
        //滑动到顶部
        toTopFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollView.fullScroll(ScrollView.FOCUS_UP);
            }
        });
        sizeDetailsRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GiftDetailsActivity.this,PopupWindowActivity.class));
            }
        });
    }


    //浏览器返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    //轮播图加载网络图片
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
