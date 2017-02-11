package com.lanou3g.gifttheory.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.adapter.MainFragmentPagerAdapter;
import com.lanou3g.gifttheory.base.BaseActivity;
import com.lanou3g.gifttheory.fragment.ClassifyFragment;
import com.lanou3g.gifttheory.fragment.HomeFragment;
import com.lanou3g.gifttheory.fragment.MineFragment;
import com.lanou3g.gifttheory.fragment.SaleFragment;
import com.lanou3g.gifttheory.fragment.StoreFragment;

import java.util.ArrayList;
import java.util.List;

//我是司帅
//2月11日
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup mRadioGroup;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction,mFragmentTransaction;
    private HomeFragment mHomeFragment;
    private SaleFragment mSaleFragment;
    private StoreFragment mStoreFragment;
    private ClassifyFragment mClassifyFragment;
    private MineFragment mMineFragment;
    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.rp_main);
       fragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void initData() {
        mHomeFragment = new HomeFragment();
        mSaleFragment = new SaleFragment();
        mStoreFragment = new StoreFragment();
        mClassifyFragment = new ClassifyFragment();
        mMineFragment = new MineFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout_main,mHomeFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void bindEvent() {
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        mFragmentTransaction = fragmentManager.beginTransaction();
        switch (checkedId){
            case R.id.rb_home:
               mFragmentTransaction.replace(R.id.frameLayout_main,mHomeFragment);
                break;
            case R.id.rb_sale:
                mFragmentTransaction.replace(R.id.frameLayout_main,mSaleFragment);
                break;
            case R.id.rb_store:
                mFragmentTransaction.replace(R.id.frameLayout_main,mStoreFragment);
                break;
            case R.id.rb_classify:
                mFragmentTransaction.replace(R.id.frameLayout_main,mClassifyFragment);
                break;
            case R.id.rb_mine:
                mFragmentTransaction.replace(R.id.frameLayout_main,mMineFragment);
                break;
        }
        mFragmentTransaction.commit();
    }
}
