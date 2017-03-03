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

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseFragment;
import com.lanou3g.gifttheory.bean.PersonBean;
import com.lanou3g.gifttheory.util.SPUtils;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

/**
 * Created by 司帅 on 17/3/2.
 */

public class MineLoginFragment extends BaseFragment{
    private Button logoutBtn;
    private Platform qq;
    private PersonBean personBean;
    private TextView nameTv;
    private ImageView iconIv;
    @Override
    protected int setLayout() {
        return R.layout.fragment_mine_login;
    }

    @Override
    protected void initView() {
        logoutBtn = bindView(getView(),R.id.btn_logout);
        nameTv = bindView(getView(),R.id.tv_id_mine_login);
        iconIv = bindView(getView(),R.id.iv_icon_mine_login);
    }

    @Override
    protected void initData() {
        ShareSDK.initSDK(getContext());
        qq = ShareSDK.getPlatform(QQ.NAME);

        personBean = getArguments().getParcelable("personBean");
        nameTv.setText(personBean.getName());
        Glide.with(getActivity()).load(personBean.getIcon()).into(iconIv);
    }

    @Override
    protected void bindEvent() {
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (qq.isAuthValid()) {
                    qq.removeAccount(true);
                    Intent intent = new Intent("Login");
                    intent.putExtra("isLogin",false);

                    SPUtils.put("isLogin",false);

                    getActivity().sendBroadcast(intent);
                }
            }
        });
    }
}
