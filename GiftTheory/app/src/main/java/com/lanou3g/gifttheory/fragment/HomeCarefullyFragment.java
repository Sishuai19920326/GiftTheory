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
import com.lanou3g.gifttheory.adapter.HomeRecyclerViewAdapter;
import com.lanou3g.gifttheory.base.BaseFragment;
import com.lanou3g.gifttheory.bean.BannerBean;
import com.lanou3g.gifttheory.bean.HomeItemBean;
import com.lanou3g.gifttheory.bean.ModuleBean;
import com.lanou3g.gifttheory.util.NetTool;
import com.lanou3g.gifttheory.util.constant.Constant;
import com.lanou3g.gifttheory.util.nettool.CallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 司帅 on 17/2/13.
 */

public class HomeCarefullyFragment extends BaseFragment{


    private static final String TAG = "HomeCarefullyFragment";
    private List<HomeItemBean.DataBean.ItemsBean> itemsBeanList;
    private List<BannerBean.DataBean.BannersBean> bannersBeanList;

    private RecyclerView recyclerView;
    private HomeRecyclerViewAdapter mAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_home_carefully;
    }

    @Override
    protected void initView() {
        recyclerView = bindView(getView(),R.id.recyclerView_home_carefully);
    }

    @Override
    protected void initData() {

        mAdapter = new HomeRecyclerViewAdapter(getActivity());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        bannersBeanList = new ArrayList<>();
        NetTool.getInstance().startRequest(Constant.BANNER, BannerBean.class, new CallBack<BannerBean>() {
            @Override
            public void onSuccess(final BannerBean response) {
                bannersBeanList = response.getData().getBanners();
                mAdapter.setBannersBeanList(bannersBeanList);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, e.getMessage());

            }
        });

        itemsBeanList = new ArrayList<>();
        NetTool.getInstance().startRequest(Constant.HOMELO + "103" + Constant.HOMEVE, HomeItemBean.class, new CallBack<HomeItemBean>() {
            @Override
            public void onSuccess(final HomeItemBean response) {
                itemsBeanList = response.getData().getItems();
                mAdapter.setItemsBeanList(itemsBeanList);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
        NetTool.getInstance().startRequest(Constant.MODULE, ModuleBean.class, new CallBack<ModuleBean>() {
            @Override
            public void onSuccess(ModuleBean response) {
                List<ModuleBean.DataBean.SecondaryBannersBean> secondaryBannersBeanList = response.getData().getSecondary_banners();
                mAdapter.setSecondaryBannersBeanList(secondaryBannersBeanList);
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
