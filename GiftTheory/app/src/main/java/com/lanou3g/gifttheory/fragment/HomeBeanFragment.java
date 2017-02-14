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

import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.adapter.HomeBeanRecyclerViewAdapter;
import com.lanou3g.gifttheory.adapter.HomeChannelStateViewPagerAdapter;
import com.lanou3g.gifttheory.base.BaseFragment;
import com.lanou3g.gifttheory.bean.ChannelBean;
import com.lanou3g.gifttheory.bean.HomeItemBean;
import com.lanou3g.gifttheory.util.NetTool;
import com.lanou3g.gifttheory.util.constant.Constant;
import com.lanou3g.gifttheory.util.nettool.CallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 司帅 on 17/2/11.
 */
//fragment复用(之前用的ActivityGroup)
public class HomeBeanFragment extends BaseFragment{
    private RecyclerView recyclerView;
    private HomeBeanRecyclerViewAdapter mAdapter;
    private static final String TAG = "HomeBeanFragment";
    @Override
    protected int setLayout() {
        return R.layout.fragment_home_bean;
    }

    @Override
    protected void initView() {
        recyclerView = bindView(getView(),R.id.recyclerView_home_bean);
    }

    @Override
    protected void initData() {
        //fragment的复用 2017年02月13日
        Bundle args = getArguments();
        ChannelBean.DataBean.ChannelsBean channelsBean = args.getParcelable("channelsBean");
        String id = channelsBean.getId()+"";

        mAdapter = new HomeBeanRecyclerViewAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);
        NetTool.getInstance().startRequest(Constant.HOMELO + id + Constant.HOMEVE, HomeItemBean.class, new CallBack<HomeItemBean>() {
            @Override
            public void onSuccess(HomeItemBean response) {
                List<HomeItemBean.DataBean.ItemsBean> itemsBeanList = new ArrayList<HomeItemBean.DataBean.ItemsBean>();
                itemsBeanList = response.getData().getItems();
                mAdapter.setItemsBeanList(itemsBeanList);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }

    @Override
    protected void bindEvent() {

    }
    //fragment的复用 2017年02月13日
    public static HomeBeanFragment newInstance(int position) {
        Bundle args = new Bundle();
        ChannelBean.DataBean.ChannelsBean channelsBean = HomeChannelStateViewPagerAdapter.getChanneslBean(position);
        args.putParcelable("channelsBean",channelsBean);
        HomeBeanFragment fragment = new HomeBeanFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
