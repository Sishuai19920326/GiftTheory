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

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.activity.MainActivity;
import com.lanou3g.gifttheory.activity.SearchActivity;
import com.lanou3g.gifttheory.adapter.HomeChannelStateViewPagerAdapter;
import com.lanou3g.gifttheory.adapter.HomeGridViewAdapter;
import com.lanou3g.gifttheory.base.BaseFragment;
import com.lanou3g.gifttheory.bean.HomeChannelBean;
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
    private ImageView showChannelsIv;
    private RelativeLayout channelsRl;

    private List<HomeChannelBean.DataBean.ChannelsBean> channelsBeanArrayList;
    private HomeChannelStateViewPagerAdapter homeChannelStateViewPagerAdapter;

    private static final String TAG = "HomeFragment";
    private HomeGridViewAdapter gridViewAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        homeTabLayout = (TabLayout) getView().findViewById(R.id.tabLayout_channels_home);
        homeViewPager = (ViewPager) getView().findViewById(R.id.viewPager_home);
        showChannelsIv = (ImageView) getView().findViewById(R.id.iv_show_channels_home);
        channelsRl = bindView(getView(),R.id.rl_search_home);
    }

    @Override
    protected void initData() {

        homeChannelStateViewPagerAdapter = new HomeChannelStateViewPagerAdapter(getChildFragmentManager(),getActivity());

        homeViewPager.setAdapter(homeChannelStateViewPagerAdapter);
        homeTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        homeTabLayout.setupWithViewPager(homeViewPager);


        gridViewAdapter = new HomeGridViewAdapter(getActivity());

        //从网上拉取的数据方法
        getDataChannelsBeanList();
    }
    //从网上拉取的数据方法
    private void getDataChannelsBeanList() {
        channelsBeanArrayList = new ArrayList<>();

        NetTool.getInstance().startRequest(Constant.CHANNELS_TITLES, HomeChannelBean.class, new CallBack<HomeChannelBean>() {
            @Override
            public void onSuccess(HomeChannelBean response) {

                channelsBeanArrayList =response.getData().getChannels();
                homeChannelStateViewPagerAdapter.setChannelsBeanArrayList(channelsBeanArrayList);

                for (int i = 0; i < homeTabLayout.getTabCount(); i++) {
//                      homeTabLayout.getTabAt(i).setText(channelsBeanArrayList.get(i).getName());
                    homeTabLayout.getTabAt(i).setCustomView(homeChannelStateViewPagerAdapter.getPageView(i));
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    protected void bindEvent() {
        showChannelsIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow();
            }
        });
        homeViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.e(TAG, "onPageScrolled: "+ position);
            }

            @Override
            public void onPageSelected(int position) {
                gridViewAdapter.setSelectorPos(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
//                Log.e(TAG, "onPageScrollStateChanged: "+state);
            }
        });
        channelsRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), SearchActivity.class));
                //切换动画
                getActivity().overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
            }
        });
    }

    private void showPopupWindow() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.popupwindow_home,null);
        final GridView gridView = (GridView) view.findViewById(R.id.gridView_popupWindow);
        ImageView closeIv = (ImageView) view.findViewById(R.id.iv_close_channels);


        gridViewAdapter.setChannelsBeanArrayList(channelsBeanArrayList);
        gridView.setAdapter(gridViewAdapter);

        final PopupWindow popupWindow = new PopupWindow(getContext());
        popupWindow.setContentView(view);

        popupWindow.setFocusable(true);//焦点不对popupWindow是 触发点击事件可以取消popupWindow
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);


        popupWindow.showAsDropDown(channelsRl,0,50);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                homeViewPager.setCurrentItem(position);
                gridViewAdapter.setSelectorPos(position);
                popupWindow.dismiss();
            }
        });
        closeIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
}
