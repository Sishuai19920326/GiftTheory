package com.lanou3g.gifttheory.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseActivity;
import com.lanou3g.gifttheory.bean.PersonBean;
import com.lanou3g.gifttheory.fragment.ClassifyFragment;
import com.lanou3g.gifttheory.fragment.HomeFragment;
import com.lanou3g.gifttheory.fragment.MineFragment;
import com.lanou3g.gifttheory.fragment.ListFragment;
import com.lanou3g.gifttheory.fragment.MineLoginFragment;
import com.lanou3g.gifttheory.fragment.StoreFragment;
import com.lanou3g.gifttheory.util.SPUtils;

//我是司帅
//2月11日
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup mRadioGroup;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction,mFragmentTransaction,fmt;
    private boolean isLogin;
    private MainBroadcastReceiver mainBroadcastReceiver;

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

        mainBroadcastReceiver = new MainBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("Login");
        registerReceiver(mainBroadcastReceiver,intentFilter);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout_main,new HomeFragment());
        fragmentTransaction.commit();
        isLogin = (boolean) SPUtils.get("isLogin",false);
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
               mFragmentTransaction.replace(R.id.frameLayout_main,new HomeFragment());
                break;
            case R.id.rb_sale:
                mFragmentTransaction.replace(R.id.frameLayout_main,new ListFragment());
                break;
            case R.id.rb_store:
                mFragmentTransaction.replace(R.id.frameLayout_main,new StoreFragment());
                break;
            case R.id.rb_classify:
                mFragmentTransaction.replace(R.id.frameLayout_main,new ClassifyFragment());
                break;
            case R.id.rb_mine:
                if (isLogin){
                    mFragmentTransaction.replace(R.id.frameLayout_main,new MineLoginFragment());
                }else {
                    mFragmentTransaction.replace(R.id.frameLayout_main,new MineFragment());
                }
                break;
        }
        mFragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mainBroadcastReceiver);
    }

    public class MainBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            isLogin = intent.getBooleanExtra("isLogin",false);
            fmt = fragmentManager.beginTransaction();
            if (isLogin){
                MineLoginFragment mineLoginFragment = new MineLoginFragment();
                PersonBean personBean = intent.getParcelableExtra("personBean");
                Bundle bundle = new Bundle();
                bundle.putParcelable("personBean",personBean);
                mineLoginFragment.setArguments(bundle);
                //TODO
                fmt.replace(R.id.frameLayout_main,mineLoginFragment);
            }else {
                fmt.replace(R.id.frameLayout_main,new MineFragment());
            }
            fmt.commit();
        }
    }
}
