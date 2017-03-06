package com.lanou3g.gifttheory.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseActivity;

public class WelcomeActivity extends BaseActivity {

    @Override
    protected int bindLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
            }
        }).start();
    }

    @Override
    protected void bindEvent() {

    }
}
