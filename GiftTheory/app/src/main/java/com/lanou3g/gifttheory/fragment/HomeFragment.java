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

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.adapter.HomeChannelStateViewPagerAdapter;
import com.lanou3g.gifttheory.base.BaseFragment;
import com.lanou3g.gifttheory.bean.HomeChannelBean;
import com.lanou3g.gifttheory.util.NetTool;
import com.lanou3g.gifttheory.util.constant.Constant;
import com.lanou3g.gifttheory.util.nettool.CallBack;

import java.util.ArrayList;

/**
 * Created by 司帅 on 17/2/11.
 */

public class HomeFragment extends BaseFragment{
    private TabLayout homeTabLayout;
    private ViewPager homeViewPager;

    private ArrayList<HomeChannelBean.DataBean.ChannelsBean> channelsBeanArrayList;
    private HomeChannelStateViewPagerAdapter homeChannelStateViewPagerAdapter;
    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        homeTabLayout = (TabLayout) getView().findViewById(R.id.tabLayout_channels_home);
        homeViewPager = (ViewPager) getView().findViewById(R.id.viewPager_home);
    }

    @Override
    protected void initData() {

        homeChannelStateViewPagerAdapter = new HomeChannelStateViewPagerAdapter(getChildFragmentManager(),getActivity());

        homeViewPager.setAdapter(homeChannelStateViewPagerAdapter);
        homeTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        homeTabLayout.setupWithViewPager(homeViewPager);


        channelsBeanArrayList = new ArrayList<>();

        NetTool.getInstance().startRequest(Constant.CHANNELS_TITLES, HomeChannelBean.class, new CallBack<HomeChannelBean>() {
            @Override
            public void onSuccess(HomeChannelBean response) {

                channelsBeanArrayList = (ArrayList<HomeChannelBean.DataBean.ChannelsBean>) response.getData().getChannels();
                homeChannelStateViewPagerAdapter.setChannelsBeanArrayList(channelsBeanArrayList);

                for (int i = 0; i < homeTabLayout.getTabCount(); i++) {
                    homeTabLayout.getTabAt(i).setText(channelsBeanArrayList.get(i).getName());
                }
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
