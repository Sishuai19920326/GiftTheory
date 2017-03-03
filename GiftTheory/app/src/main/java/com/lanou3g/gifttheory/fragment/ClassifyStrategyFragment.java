package com.lanou3g.gifttheory.fragment;
/**
 * ██████齐天大圣 - 司帅████████
 *
 * 　　 ◢████████████████◣
 * 　　██　　　 ◥██◤　　　 ██
 * 　◢███　　　　◥◤　　　  ██◣
 * 　▊▎██◣　　　　　　　　 ◢█▊▊
 * 　▊▎██◤　　●　 　●　   ◥█▊ ▊
 * 　▊ ██　　　　　　　　　 █▊▊
 * 　◥▇██　▊　　　　　　▊　 █▇◤
 * 　　◥█　   ◥▆▄▄▆◤　    █◤　　　    ◢▇▇◣
 * ◢████◥◥▆▅▄▂▂▂▂▂▂▂▄▅▅▆▆█████◣　   ▊◢　█
 * █╳　　　　　　　　　　　　　　╳█　   ◥◤◢◤
 * ◥█◣　　　˙　　　　　˙　　　◢█◤　　   ◢◤
 * 　　▊　　　　　　　　　　　　▊　　　　█
 * 　　▊　　　　　　　　　　　　▊　　　◢◤
 * 　　▊　　　　　⊕　 　　　 　█▇▇▇◤
 * ◢█▇▆▆▆▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▆▆▆▇█◣
 * 　 ▊　▂　▊　　　　　　▊　▂　▊
 **/

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.adapter.ClassifyStrategyRecyclerViewAdapter;
import com.lanou3g.gifttheory.base.BaseFragment;
import com.lanou3g.gifttheory.bean.ClassifyColumnBean;
import com.lanou3g.gifttheory.bean.ClassifyStrategyBean;
import com.lanou3g.gifttheory.util.NetTool;
import com.lanou3g.gifttheory.util.constant.Constant;
import com.lanou3g.gifttheory.util.loadui.DurianLoading;
import com.lanou3g.gifttheory.util.nettool.CallBack;

import java.util.List;

/**
 * Created by 司帅 on 17/2/16.
 */

public class ClassifyStrategyFragment extends BaseFragment{
    private RecyclerView recyclerView;
    private ClassifyStrategyRecyclerViewAdapter mAdapter;
    private DurianLoading durianLoading;

    @Override
    protected int setLayout() {
        return R.layout.fragment_classify_strategy;
    }

    @Override
    protected void initView() {
        recyclerView = bindView(getView(),R.id.recyclerView_strategy);
        durianLoading = bindView(getView(),R.id.tel_login_loading_img);
        durianLoading.showLoadUi(false,0);
    }

    @Override
    protected void initData() {
        mAdapter = new ClassifyStrategyRecyclerViewAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);

        NetTool.getInstance().startRequest(Constant.STRATEGY, ClassifyStrategyBean.class, new CallBack<ClassifyStrategyBean>() {
            @Override
            public void onSuccess(ClassifyStrategyBean response) {
                List<ClassifyStrategyBean.DataBean.ChannelGroupsBean> channelGroupsBeanList = response.getData().getChannel_groups();
                mAdapter.setChannelGroupsBeanList(channelGroupsBeanList);
                durianLoading.showLoadUi(true,0);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

        NetTool.getInstance().startRequest(Constant.STRATEGY_UP_TITLE, ClassifyColumnBean.class, new CallBack<ClassifyColumnBean>() {
            @Override
            public void onSuccess(ClassifyColumnBean response) {
                List<ClassifyColumnBean.DataBean.ColumnsBean> columnsBeanList = response.getData().getColumns();
                mAdapter.setColumnsBeanList(columnsBeanList);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    protected void bindEvent() {

    }
}
