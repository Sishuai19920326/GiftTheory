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
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lanou3g.gifttheory.bean.ListChannelBean;
import com.lanou3g.gifttheory.fragment.ListBeanFragment;

import java.util.List;

/**
 * Created by 司帅 on 17/2/15.
 */

public class ListChannelStateViewPagerAdapter extends FragmentStatePagerAdapter{
    private Context context;
    private static List<ListChannelBean.DataBean.RanksBean> ranksBeanList;

    public ListChannelStateViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    public void setRanksBeanList(List<ListChannelBean.DataBean.RanksBean> ranksBeanList) {
        this.ranksBeanList = ranksBeanList;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return ListBeanFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return ranksBeanList == null ? 0 : ranksBeanList.size();
    }
    public static ListChannelBean.DataBean.RanksBean getRanksBean(int position){
        return ranksBeanList.get(position);
    }
}
