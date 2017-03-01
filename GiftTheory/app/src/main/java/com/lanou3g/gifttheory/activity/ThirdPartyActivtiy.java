package com.lanou3g.gifttheory.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.adapter.ThridPartyViewPagerAdapter;
import com.lanou3g.gifttheory.base.BaseActivity;
import com.lanou3g.gifttheory.fragment.ThridPartyCommentFragment;
import com.lanou3g.gifttheory.fragment.ThridPartyDetailsFragment;
import com.lanou3g.gifttheory.fragment.ThridPartySingleFragment;

import java.util.ArrayList;
import java.util.List;

public class ThirdPartyActivtiy extends BaseActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private ThridPartyViewPagerAdapter adapter;
    private String[] title = {"单品","详情","评论"};
    @Override
    protected int bindLayout() {
        return R.layout.activity_third_party;
    }

    @Override
    protected void initView() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout_thrid_party);
        viewPager = (ViewPager) findViewById(R.id.viewPager_thrid_party);
    }

    @Override
    protected void initData() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new ThridPartySingleFragment());
        fragmentList.add(new ThridPartyDetailsFragment());
        fragmentList.add(new ThridPartyCommentFragment());
        adapter = new ThridPartyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setText(title[i]);
        }
    }

    @Override
    protected void bindEvent() {

    }
}
