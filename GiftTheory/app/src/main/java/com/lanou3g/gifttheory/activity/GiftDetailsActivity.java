package com.lanou3g.gifttheory.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
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

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class GiftDetailsActivity extends NewBaseActivity {
    private ImageView backIv;
    private ListItemBean.DataBean.ItemsBean itemsBean;
    private WebView webView;
    private TextView descriptionTv , nameTv , priceTv,skusTv,buyTv,shareTv,favTv;
    private ConvenientBanner convenientBanner;
    private List<String> bannerImageList;
    private ScrollView scrollView;
    private RelativeLayout channelsRl,sizeDetailsRl;
    private FloatingActionButton toTopFab;
    private MyBroadcastReceiver myBroadcastReceiver;
    private List<ListItemBean.DataBean.ItemsBean.SkusBean> skusBeanList;

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
        skusTv = (TextView) findViewById(R.id.tv_skus_gift_details);
        buyTv = (TextView) findViewById(R.id.tv_buy_gift_details);
        shareTv = (TextView) findViewById(R.id.tv_share_gift_details);
        favTv = (TextView) findViewById(R.id.tv_favourite_gift_details);
    }

    @Override
    protected void initData() {
        //一件分享
        ShareSDK.initSDK(this);

        itemsBean = getIntent().getParcelableExtra("itemsBean");
        if (itemsBean != null){
            descriptionTv.setText(itemsBean.getShort_description());
            nameTv.setText(itemsBean.getName());
            String price;
            if (itemsBean.getPrice() == null) {
                price = "¥ " + itemsBean.getSkus().get(0).getPrice() + "";
            } else {
                price = "¥ " + itemsBean.getPrice() + "";
            }
            priceTv.setText(price);
            skusBeanList = itemsBean.getSkus();
            if (skusBeanList.size() == 1){
                skusTv.setText("规格,1个");
            }else {
                skusTv.setText("请选择规格");
            }
            initBanner();
            initWebView();
            //动态注册广播接收器
            registerReceiver();
        }
    }
    private void registerReceiver() {
        myBroadcastReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(PopupWindowActivity.GET_SELETED);
        registerReceiver(myBroadcastReceiver,intentFilter);
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
                toPWActivity();
            }
        });
        buyTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toPWActivity();
            }
        });
        shareTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare();
            }
        });
        favTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void toPWActivity() {
        Intent toPWActivity = new Intent(GiftDetailsActivity.this,PopupWindowActivity.class);
        if (itemsBean != null){
            toPWActivity.putExtra("itemsBean",itemsBean);
            startActivity(toPWActivity);
        }
    }

    //注销广播接收器
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadcastReceiver);
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
    //动态广播接收器
    class MyBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getBooleanExtra("NoSeleted",false)){
                skusTv.setText("请选择规格");
            }else {
                String skus = skusBeanList.get(intent.getIntExtra("HasSeleted",-1)).getSpecs().get(0).getProperty()+","+intent.getStringExtra("num")+"个";
                skusTv.setText(skus);
            }
        }
    }
    private void showShare() {

        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle(itemsBean.getName());
        // titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText(itemsBean.getShort_description());
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment(itemsBean.getShort_description());
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        // 启动分享GUI
        oks.show(this);
    }
}
