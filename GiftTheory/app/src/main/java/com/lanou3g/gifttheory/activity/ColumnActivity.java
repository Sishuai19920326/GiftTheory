package com.lanou3g.gifttheory.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.adapter.ColumnRecyclerViewAdapter;
import com.lanou3g.gifttheory.base.BaseActivity;
import com.lanou3g.gifttheory.bean.ClassifyColumnBean;
import com.lanou3g.gifttheory.bean.ClassifyStrategyBean;
import com.lanou3g.gifttheory.util.NetTool;
import com.lanou3g.gifttheory.util.constant.Constant;
import com.lanou3g.gifttheory.util.nettool.CallBack;

import java.util.List;

public class ColumnActivity extends BaseActivity {
    private ImageView backIv;
    private LRecyclerView lRecyclerView;
    private ColumnRecyclerViewAdapter adapter;
    private String nextUrl;
    private List<ClassifyColumnBean.DataBean.ColumnsBean> columnsBeanList;

    @Override
    protected int bindLayout() {
        return R.layout.activity_column;
    }

    @Override
    protected void initView() {
        backIv = (ImageView) findViewById(R.id.iv_back_column);
        lRecyclerView = (LRecyclerView) findViewById(R.id.l_recyclerView_column);
    }

    @Override
    protected void initData() {
        adapter = new ColumnRecyclerViewAdapter(this);
        LRecyclerViewAdapter lRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
        lRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        lRecyclerView.setAdapter(lRecyclerViewAdapter);
        NetTool.getInstance().startRequest(Constant.STRATEGY_UP_TITLE, ClassifyColumnBean.class, new CallBack<ClassifyColumnBean>() {
            @Override
            public void onSuccess(ClassifyColumnBean response) {
                columnsBeanList = response.getData().getColumns();
                adapter.setColumnsBeanList(columnsBeanList);

                nextUrl = response.getData().getPaging().getNext_url();
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    protected void bindEvent() {
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                if(TextUtils.isEmpty(nextUrl)){
                    lRecyclerView.setNoMore(true);
                }else {
                    NetTool.getInstance().startRequest(nextUrl, ClassifyColumnBean.class, new CallBack<ClassifyColumnBean>() {
                        @Override
                        public void onSuccess(ClassifyColumnBean response) {
                            lRecyclerView.setNoMore(false);
                            columnsBeanList.addAll(response.getData().getColumns());
                            adapter.notifyDataSetChanged();
                            nextUrl = response.getData().getPaging().getNext_url();
                        }

                        @Override
                        public void onError(Throwable e) {

                        }
                    });
                }
            }
        });
    }
}
