package com.lanou3g.gifttheory.adapter;
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

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.fragment.HomeBeanFragment;
import com.lanou3g.gifttheory.bean.HomeChannelBean;
import com.lanou3g.gifttheory.fragment.HomeCarefullyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 司帅 on 17/2/13.
 */

public class HomeChannelStateViewPagerAdapter extends FragmentStatePagerAdapter{
    private Context context;
    private static List<HomeChannelBean.DataBean.ChannelsBean> channelsBeanArrayList;

    public HomeChannelStateViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    public  void setChannelsBeanArrayList(List<HomeChannelBean.DataBean.ChannelsBean> channelsBeanArrayList) {
        this.channelsBeanArrayList = channelsBeanArrayList;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new HomeCarefullyFragment();
        }
        return HomeBeanFragment.newInstance(position);
    }
    @Override
    public int getCount() {
        return channelsBeanArrayList == null ? 0 : channelsBeanArrayList.size();
    }
    //fragment的复用 2017年02月13日
    public static HomeChannelBean.DataBean.ChannelsBean getChanneslBean(int position){
        return channelsBeanArrayList.get(position);
    }
    public View getPageView(int position){
        View v = LayoutInflater.from(context).inflate(R.layout.tablayout_home_channels_name,null);
        TextView nameTv = (TextView) v.findViewById(R.id.tv_home_channels_name);
        nameTv.setText(channelsBeanArrayList.get(position).getName());
        return v;
    }
}
