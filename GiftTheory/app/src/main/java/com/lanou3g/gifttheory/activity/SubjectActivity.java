package com.lanou3g.gifttheory.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.adapter.SubjectRecyclerVIewAdatper;
import com.lanou3g.gifttheory.base.BaseActivity;
import com.lanou3g.gifttheory.bean.StoreUpBean;

import java.util.List;

public class SubjectActivity extends BaseActivity {
    private StoreUpBean.DataBean.ItemsBeanX itemsBeanX;
    private List<StoreUpBean.DataBean.ItemsBeanX.ItemsBean> itemsBeanList;
    private RecyclerView recyclerView;
    private SubjectRecyclerVIewAdatper adatper;
    private ImageView backIv;
    @Override
    protected int bindLayout() {
        return R.layout.activity_subject;
    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_subject);
        backIv = (ImageView) findViewById(R.id.iv_back_subject);
    }

    @Override
    protected void initData() {
        itemsBeanX = getIntent().getParcelableExtra("itemsBeanX");
        itemsBeanList = itemsBeanX.getItems();
        adatper = new SubjectRecyclerVIewAdatper(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0){
                    return 2;
                }else {
                    return 1;
                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        adatper.setItemsBeanX(itemsBeanX);
        adatper.setItemsBeanList(itemsBeanX.getItems());
        recyclerView.setAdapter(adatper);
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
