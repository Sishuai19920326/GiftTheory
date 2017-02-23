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

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseFragment;

/**
 * Created by 司帅 on 17/2/11.
 */

public class MineFragment extends BaseFragment{
    private RelativeLayout smsCodeLayout,passWordLayout;
    private EditText passWordEt;
    private TextView switchCodePassWordTv;
    private ImageView switchCloseOpenPassWordIv;
    private boolean isCode;
    private boolean isOpenPassWord;
    @Override
    protected int setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        smsCodeLayout = bindView(getView(),R.id.rl_sms_code);
        passWordLayout = bindView(getView(),R.id.rl_password);
        switchCodePassWordTv = bindView(getView(),R.id.tv_login_code_password);
        switchCloseOpenPassWordIv = bindView(getView(),R.id.iv_visible_close_mine);
        passWordEt = bindView(getView(),R.id.et_password_mine);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {
        switchCodePassWordTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCode=!isCode;
                if (isCode){
                    switchCodePassWordTv.setText("使用密码登录");
                    passWordLayout.setVisibility(View.GONE);
                    smsCodeLayout.setVisibility(View.VISIBLE);
                }else {
                    switchCodePassWordTv.setText("使用验证码登录");
                    passWordLayout.setVisibility(View.VISIBLE);
                    smsCodeLayout.setVisibility(View.GONE);
                }

            }
        });
        switchCloseOpenPassWordIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOpenPassWord=!isOpenPassWord;
                if (isOpenPassWord){
                    switchCloseOpenPassWordIv.setImageResource(R.mipmap.ic_visible_open);
                    passWordEt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    switchCloseOpenPassWordIv.setImageResource(R.mipmap.ic_visible_close);
                    passWordEt.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }
}
