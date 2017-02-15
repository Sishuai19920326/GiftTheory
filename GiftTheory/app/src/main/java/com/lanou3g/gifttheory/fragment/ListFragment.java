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
import android.util.Log;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.adapter.ListChannelStateViewPagerAdapter;
import com.lanou3g.gifttheory.base.BaseFragment;
import com.lanou3g.gifttheory.bean.ListChannelBean;
import com.lanou3g.gifttheory.util.NetTool;
import com.lanou3g.gifttheory.util.constant.Constant;
import com.lanou3g.gifttheory.util.nettool.CallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 司帅 on 17/2/11.
 */

public class ListFragment extends BaseFragment{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ListChannelStateViewPagerAdapter adapter;
    private static final String TAG = "ListFragment";
    @Override
    protected int setLayout() {
        return R.layout.fragment_list;
    }

    @Override
    protected void initView() {
        tabLayout = (TabLayout) getView().findViewById(R.id.tabLayout_list);
        viewPager = (ViewPager) getView().findViewById(R.id.viewPager_list);
    }

    @Override
    protected void initData() {
        adapter = new ListChannelStateViewPagerAdapter(getActivity().getSupportFragmentManager(),getActivity());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        NetTool.getInstance().startRequest(Constant.LIST_TITLE, ListChannelBean.class, new CallBack<ListChannelBean>() {
            @Override
            public void onSuccess(ListChannelBean response) {
                List<ListChannelBean.DataBean.RanksBean> ranksBeanList = response.getData().getRanks();
                adapter.setRanksBeanList(ranksBeanList);

                for (int i = 0; i < tabLayout.getTabCount(); i++) {
                    tabLayout.getTabAt(i).setText(ranksBeanList.get(i).getName());
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
