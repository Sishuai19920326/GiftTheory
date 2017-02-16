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
import com.lanou3g.gifttheory.adapter.ClassifyFragmentViewPagerAdapter;
import com.lanou3g.gifttheory.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 司帅 on 17/2/11.
 */

public class ClassifyFragment extends BaseFragment{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ClassifyFragmentViewPagerAdapter mAdapter;
    private List<Fragment> fragmentList;
    private String[] title;
    @Override
    protected int setLayout() {
        return R.layout.fragment_classify;
    }

    @Override
    protected void initView() {
        tabLayout = bindView(getView(),R.id.tabLayout_channels_classify);
        viewPager = bindView(getView(),R.id.viewPager_classify);
    }

    @Override
    protected void initData() {
        mAdapter = new ClassifyFragmentViewPagerAdapter(getChildFragmentManager(),getContext());
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);

        fragmentList = new ArrayList<>();
        fragmentList.add(new ClassifyStrategyFragment());
        fragmentList.add(new ClassifySingleFragment());
        mAdapter.setFragmentList(fragmentList);
        title = new String[]{"攻略","单品"};
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setText(title[i]);
        }
    }

    @Override
    protected void bindEvent() {

    }
}
