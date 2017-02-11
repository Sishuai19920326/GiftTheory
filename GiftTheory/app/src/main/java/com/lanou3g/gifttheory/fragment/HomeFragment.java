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
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.adapter.HomeChannelViewPagerAdapter;
import com.lanou3g.gifttheory.base.BaseFragment;
import com.lanou3g.gifttheory.bean.BeanFragment;
import com.lanou3g.gifttheory.bean.ChannelBean;
import com.lanou3g.gifttheory.util.NetTool;
import com.lanou3g.gifttheory.util.constant.Constant;
import com.lanou3g.gifttheory.util.nettool.CallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 司帅 on 17/2/11.
 */

public class HomeFragment extends BaseFragment{
    private TabLayout homeTabLayout;
    private ViewPager homeViewPager;
    private HomeChannelViewPagerAdapter homeChannelViewPagerAdapter;
    private List<Fragment> fragmentList;
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
        homeChannelViewPagerAdapter = new HomeChannelViewPagerAdapter(getActivity().getSupportFragmentManager(),getActivity());
        homeViewPager.setAdapter(homeChannelViewPagerAdapter);
        homeTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        homeTabLayout.setupWithViewPager(homeViewPager);
        fragmentList = new ArrayList<>();
        NetTool.getInstance().startRequest(Constant.CHANNELS, ChannelBean.class, new CallBack<ChannelBean>() {
            @Override
            public void onSuccess(ChannelBean response) {
                for (int i = 0; i < response.getData().getChannels().size(); i++) {
                    BeanFragment bean = new BeanFragment();
                    fragmentList.add(bean);
                }
                homeChannelViewPagerAdapter.setFragmentList(fragmentList);
                for (int i = 0; i < homeTabLayout.getTabCount(); i++) {
                    homeTabLayout.getTabAt(i).setText(response.getData().getChannels().get(i).getName());
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
