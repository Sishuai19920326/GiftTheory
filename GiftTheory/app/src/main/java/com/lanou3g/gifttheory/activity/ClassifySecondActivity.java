package com.lanou3g.gifttheory.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.adapter.ClassifySecondRecyclerViewAdapter;
import com.lanou3g.gifttheory.base.BaseActivity;
import com.lanou3g.gifttheory.bean.ClassifyStrategyBean;

import java.util.List;

public class ClassifySecondActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private ClassifySecondRecyclerViewAdapter adapter;
    private TextView titleTv;
    private ImageView backIv;
    private ClassifyStrategyBean.DataBean.ChannelGroupsBean channelGroupsBean;

    @Override
    protected int bindLayout() {
        return R.layout.activity_classify_second;
    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_classify_second);
        titleTv = (TextView) findViewById(R.id.tv_title_classify_second);
        backIv = (ImageView) findViewById(R.id.iv_back_classify_second);
    }

    @Override
    protected void initData() {
        adapter = new ClassifySecondRecyclerViewAdapter(this);
        channelGroupsBean = getIntent().getParcelableExtra("channelGroupsBean");
        List<ClassifyStrategyBean.DataBean.ChannelGroupsBean.ChannelsBean> channelsBeanList = channelGroupsBean.getChannels();
        titleTv.setText(channelGroupsBean.getName());
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        adapter.setChannelsBeanList(channelsBeanList);
        recyclerView.setAdapter(adapter);
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
