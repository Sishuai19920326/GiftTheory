package com.lanou3g.gifttheory.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseActivity;
import com.lanou3g.gifttheory.bean.ListItemBean;

public class GiftDetailsActivity extends BaseActivity {
    private ImageView backIv;
    private ListItemBean.DataBean.ItemsBean itemsBean;

    @Override
    protected int bindLayout() {
        return R.layout.activity_gift_details;
    }

    @Override
    protected void initView() {
        backIv = (ImageView)findViewById(R.id.iv_back_gift_details);
    }

    @Override
    protected void initData() {
        itemsBean = getIntent().getParcelableExtra("itemsBean");
        Log.e("GiftDetailsActivity", itemsBean.getName());
    }

    @Override
    protected void bindEvent() {
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.anim_go,R.anim.anim_back);
            }
        });
    }
}
