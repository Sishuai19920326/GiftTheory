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
import android.text.TextUtils;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.adapter.HomeBeanRecyclerViewAdapter;
import com.lanou3g.gifttheory.adapter.HomeChannelStateViewPagerAdapter;
import com.lanou3g.gifttheory.base.BaseFragment;
import com.lanou3g.gifttheory.bean.HomeChannelBean;
import com.lanou3g.gifttheory.bean.HomeItemBean;
import com.lanou3g.gifttheory.util.NetTool;
import com.lanou3g.gifttheory.util.constant.Constant;
import com.lanou3g.gifttheory.util.nettool.CallBack;

import java.util.List;

/**
 * Created by 司帅 on 17/2/11.
 */
//fragment复用(之前用的ActivityGroup)
public class HomeBeanFragment extends BaseFragment{
    private LRecyclerView lRecyclerView;
    private HomeBeanRecyclerViewAdapter mAdapter;
    private static final String TAG = "HomeBeanFragment";
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private String id;
    private String nextUrl;
    private List<HomeItemBean.DataBean.ItemsBean> itemsBeanList;

    @Override
    protected int setLayout() {
        return R.layout.fragment_home_bean;
    }

    @Override
    protected void initView() {
        lRecyclerView = bindView(getView(),R.id.l_recyclerView_home_bean);

    }

    @Override
    protected void initData() {
        //fragment的复用 2017年02月13日
        Bundle args = getArguments();
        HomeChannelBean.DataBean.ChannelsBean channelsBean = args.getParcelable("channelsBean");
        id = channelsBean.getId()+"";

        mAdapter = new HomeBeanRecyclerViewAdapter(getActivity());
        lRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
        lRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        lRecyclerView.setAdapter(lRecyclerViewAdapter);

        requestData();

    }

    private void requestData() {
        NetTool.getInstance().startRequest(Constant.HOMELO + id + Constant.HOMEVE, HomeItemBean.class, new CallBack<HomeItemBean>() {
            @Override
            public void onSuccess(HomeItemBean response) {
                itemsBeanList = response.getData().getItems();
                mAdapter.setItemsBeanList(itemsBeanList);
                nextUrl = response.getData().getPaging().getNext_url();
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    protected void bindEvent() {
        lRecyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
//                lRecyclerView.refreshComplete(0);
            }
        });
        lRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                if (TextUtils.isEmpty(HomeBeanFragment.this.nextUrl)){
                    lRecyclerView.setNoMore(true);
                }else {
                    //请求新的url
                    NetTool.getInstance().startRequest(nextUrl, HomeItemBean.class, new CallBack<HomeItemBean>() {
                        @Override
                        public void onSuccess(HomeItemBean response) {
                            lRecyclerView.setNoMore(false);
                            //加进集合
                            itemsBeanList.addAll(response.getData().getItems());
                            mAdapter.notifyDataSetChanged();

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
    //fragment的复用 2017年02月13日
    public static HomeBeanFragment newInstance(int position) {
        Bundle args = new Bundle();
        HomeChannelBean.DataBean.ChannelsBean channelsBean = HomeChannelStateViewPagerAdapter.getChanneslBean(position);
        args.putParcelable("channelsBean",channelsBean);
        HomeBeanFragment fragment = new HomeBeanFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
