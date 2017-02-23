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
import android.text.TextUtils;
import android.util.Log;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.adapter.HomeRecyclerViewAdapter;
import com.lanou3g.gifttheory.base.BaseFragment;
import com.lanou3g.gifttheory.bean.HomeBannerBean;
import com.lanou3g.gifttheory.bean.HomeItemBean;
import com.lanou3g.gifttheory.bean.HomeModuleBean;
import com.lanou3g.gifttheory.myinterface.MyItemOnClickListenr;
import com.lanou3g.gifttheory.util.NetTool;
import com.lanou3g.gifttheory.util.constant.Constant;
import com.lanou3g.gifttheory.util.nettool.CallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 司帅 on 17/2/13.
 */

public class HomeCarefullyFragment extends BaseFragment implements MyItemOnClickListenr {


    private static final String TAG = "HomeCarefullyFragment";
    private List<HomeItemBean.DataBean.ItemsBean> itemsBeanList;
    private List<HomeBannerBean.DataBean.BannersBean> bannersBeanList;
    private HomeRecyclerViewAdapter mAdapter;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private LRecyclerView lRecyclerView;
    private String nextUrl;
    @Override
    protected int setLayout() {
        return R.layout.fragment_home_carefully;
    }

    @Override
    protected void initView() {
        lRecyclerView = bindView(getView(),R.id.l_recyclerView_home_carefully);
    }

    @Override
    protected void initData() {

        mAdapter = new HomeRecyclerViewAdapter(getActivity());
        mAdapter.setMyItemOnClickListenr(this);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        lRecyclerView.setLayoutManager(layoutManager);
        lRecyclerView.setAdapter(lRecyclerViewAdapter);



        bannersBeanList = new ArrayList<>();
        itemsBeanList = new ArrayList<>();

        requestBanner();
        requestData();
        requestModule();

    }
    //请求模块数据
    private void requestModule() {
        NetTool.getInstance().startRequest(Constant.MODULE, HomeModuleBean.class, new CallBack<HomeModuleBean>() {
            @Override
            public void onSuccess(HomeModuleBean response) {
                List<HomeModuleBean.DataBean.SecondaryBannersBean> secondaryBannersBeanList = response.getData().getSecondary_banners();
                mAdapter.setSecondaryBannersBeanList(secondaryBannersBeanList);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
    //请求下面列表数据
    private void requestData() {
        NetTool.getInstance().startRequest(Constant.HOMELO + "103" + Constant.HOMEVE, HomeItemBean.class, new CallBack<HomeItemBean>() {
            @Override
            public void onSuccess(final HomeItemBean response) {
                itemsBeanList = response.getData().getItems();
                mAdapter.setItemsBeanList(itemsBeanList);

                HomeCarefullyFragment.this.nextUrl = response.getData().getPaging().getNext_url();
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
    //请求轮播图数据
    private void requestBanner() {
        NetTool.getInstance().startRequest(Constant.BANNER, HomeBannerBean.class, new CallBack<HomeBannerBean>() {
            @Override
            public void onSuccess(final HomeBannerBean response) {
                bannersBeanList = response.getData().getBanners();
                mAdapter.setBannersBeanList(bannersBeanList);
            }

            @Override
            public void onError(Throwable e) {


            }
        });
    }

    @Override
    protected void bindEvent() {
        //上来加载更多
        lRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                if (TextUtils.isEmpty(HomeCarefullyFragment.this.nextUrl)){
                    lRecyclerView.setNoMore(true);
                }else {
                    NetTool.getInstance().startRequest(nextUrl, HomeItemBean.class, new CallBack<HomeItemBean>() {
                        @Override
                        public void onSuccess(HomeItemBean response) {
                            lRecyclerView.setNoMore(false);
                            itemsBeanList.addAll(response.getData().getItems());
                            mAdapter.notifyDataSetChanged();

                            HomeCarefullyFragment.this.nextUrl = response.getData().getPaging().getNext_url();
                        }

                        @Override
                        public void onError(Throwable e) {

                        }
                    });
                }
            }
        });
    }
    //轮播图的点击事件
    @Override
    public void onItemClick(int position) {
        Log.d(TAG, "position:" + position);
    }
}
