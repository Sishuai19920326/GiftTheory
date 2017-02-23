package com.lanou3g.gifttheory.activity;

import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.adapter.SingleRightAdapter;
import com.lanou3g.gifttheory.adapter.SingleSecondRecyclerViewAdapter;
import com.lanou3g.gifttheory.base.BaseActivity;
import com.lanou3g.gifttheory.bean.SingleBean;
import com.lanou3g.gifttheory.bean.SingleSecondBean;
import com.lanou3g.gifttheory.util.NetTool;
import com.lanou3g.gifttheory.util.constant.Constant;
import com.lanou3g.gifttheory.util.nettool.CallBack;

import java.util.List;

public class SingleSencondActivity extends BaseActivity {
    private SingleBean.DataBean.CategoriesBean.SubcategoriesBean subcategoriesBean;
    private TextView nameTv;
    private ImageView backIv,menuIv;
    private LRecyclerView lRecyclerView;
    private SingleSecondRecyclerViewAdapter adapter;
    private String nextUrl;
    private static final String TAG = "SingleSencondActivity";
    private List<SingleSecondBean.DataBean.ItemsBean> itemsBeanList;

    @Override
    protected int bindLayout() {
        subcategoriesBean = getIntent().getParcelableExtra(SingleRightAdapter.TO_SECOND);
        return R.layout.activity_single_sencond;
    }

    @Override
    protected void initView() {
        nameTv = (TextView) findViewById(R.id.tv_name_single_second);
        backIv = (ImageView) findViewById(R.id.iv_back_single_second);
        menuIv = (ImageView) findViewById(R.id.iv_menu_single_second);
        lRecyclerView = (LRecyclerView) findViewById(R.id.l_recyclerView_single_second);
    }

    @Override
    protected void initData() {
        lRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new SingleSecondRecyclerViewAdapter(this);
        LRecyclerViewAdapter lRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
        lRecyclerView.setAdapter(lRecyclerViewAdapter);
        nameTv.setText(subcategoriesBean.getName());

        String id = subcategoriesBean.getId()+"";
        Log.e(TAG, "initData: "+Constant.SINGE_SECOND_UP + id + Constant.SINGE_SECOND_DOWN);
        NetTool.getInstance().startRequest(Constant.SINGE_SECOND_UP + id + Constant.SINGE_SECOND_DOWN, SingleSecondBean.class, new CallBack<SingleSecondBean>() {
            @Override
            public void onSuccess(SingleSecondBean response) {
                itemsBeanList = response.getData().getItems();
                adapter.setItemsBeanList(itemsBeanList);
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
                overridePendingTransition(R.anim.anim_go,R.anim.anim_back);
            }
        });
        lRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                if (nextUrl.isEmpty()){
                    lRecyclerView.setNoMore(true);
                }else {
                    lRecyclerView.setNoMore(false);
                    NetTool.getInstance().startRequest(nextUrl, SingleSecondBean.class, new CallBack<SingleSecondBean>() {
                        @Override
                        public void onSuccess(SingleSecondBean response) {
                            itemsBeanList.addAll(response.getData().getItems());
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
