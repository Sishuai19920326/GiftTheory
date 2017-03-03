package com.lanou3g.gifttheory.fragment;
/**
 * ██████齐天大圣 - 司帅████████
 * <p>
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
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseFragment;
import com.lanou3g.gifttheory.bean.PersonBean;
import com.lanou3g.gifttheory.util.SPUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;

/**
 * Created by 司帅 on 17/2/11.
 */

public class MineFragment extends BaseFragment {
    private RelativeLayout smsCodeLayout, passWordLayout;
    private EditText passWordEt;
    private TextView switchCodePassWordTv;
    private ImageView switchCloseOpenPassWordIv;
    private boolean isCode;
    private boolean isOpenPassWord;
    private ImageView qqIv;
    private Platform qq;

    @Override
    protected int setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        smsCodeLayout = bindView(getView(), R.id.rl_sms_code);
        passWordLayout = bindView(getView(), R.id.rl_password);
        switchCodePassWordTv = bindView(getView(), R.id.tv_login_code_password);
        switchCloseOpenPassWordIv = bindView(getView(), R.id.iv_visible_close_mine);
        passWordEt = bindView(getView(), R.id.et_password_mine);
        qqIv = bindView(getView(), R.id.iv_icon_qq);
    }

    @Override
    protected void initData() {
        ShareSDK.initSDK(getContext());
    }

    @Override
    protected void bindEvent() {
        switchCodePassWordTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCode = !isCode;
                if (isCode) {
                    switchCodePassWordTv.setText("使用密码登录");
                    passWordLayout.setVisibility(View.GONE);
                    smsCodeLayout.setVisibility(View.VISIBLE);
                } else {
                    switchCodePassWordTv.setText("使用验证码登录");
                    passWordLayout.setVisibility(View.VISIBLE);
                    smsCodeLayout.setVisibility(View.GONE);
                }

            }
        });
        switchCloseOpenPassWordIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOpenPassWord = !isOpenPassWord;
                if (isOpenPassWord) {
                    switchCloseOpenPassWordIv.setImageResource(R.mipmap.ic_visible_open);
                    passWordEt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    switchCloseOpenPassWordIv.setImageResource(R.mipmap.ic_visible_close);
                    passWordEt.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        qqIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qq = ShareSDK.getPlatform(QQ.NAME);
                //isValid和removeAccount不开启线程，会直接返回。

                //回调信息，可以在这里获取基本的授权返回的信息，但是注意如果做提示和UI操作要传到主线程handler里去执行
                qq.setPlatformActionListener(new PlatformActionListener() {

                    @Override
                    public void onError(Platform arg0, int arg1, Throwable arg2) {
                        // TODO Auto-generated method stub
                        arg2.printStackTrace();
                    }

                    @Override
                    public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
                        // TODO Auto-generated method stub
                        //输出所有授权信息
                        //遍历Map
//                        Iterator ite = arg2.entrySet().iterator();
//                        while (ite.hasNext()) {
//                            Map.Entry entry = (Map.Entry) ite.next();
//                            Object key = entry.getKey();
//                            Object value = entry.getValue();
//                            Log.e("MineFragment", " key " + key + " value:" + value);
//                        }
//                        if (arg1 == Platform.ACTION_USER_INFOR) {
//                            PlatformDb platDB = arg0.getDb();//获取数平台数据DB
//                            //通过DB获取各种数据
//                            Log.d("getToken", platDB.getToken());
//                            Log.d("getUserGender", platDB.getUserGender());
//                            Log.d("getUserIcon", platDB.getUserIcon());
//                            Log.d("getUserId", platDB.getUserId());
//                            Log.d("getUserName", platDB.getUserName());
                        PlatformDb platDB = arg0.getDb();
                        SPUtils.put("isLogin", true);
                        PersonBean personBean = new PersonBean();
                        personBean.setCity(arg2.get("city").toString());
                        personBean.setSex(arg2.get("gender").toString());
                        personBean.setName(platDB.getUserName().toString());
                        personBean.setIcon(platDB.getUserIcon().toString());


                        Intent intent = new Intent("Login");
                        intent.putExtra("personBean",personBean);
                        intent.putExtra("isLogin", true);
                        getActivity().sendBroadcast(intent);

//                        }

                    }

                    @Override
                    public void onCancel(Platform arg0, int arg1) {
                        // TODO Auto-generated method stub

                    }
                });
                //authorize与showUser单独调用一个即可
                //weibo.authorize();//单独授权,OnComplete返回的hashmap是空的
                qq.showUser(null);//授权并获取用户信息


            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
