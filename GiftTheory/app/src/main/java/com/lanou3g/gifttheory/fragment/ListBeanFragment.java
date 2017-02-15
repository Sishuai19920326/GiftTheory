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

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.adapter.ListChannelStateViewPagerAdapter;
import com.lanou3g.gifttheory.base.BaseFragment;
import com.lanou3g.gifttheory.bean.ListChannelBean;
import com.lanou3g.gifttheory.bean.ListItemBean;
import com.lanou3g.gifttheory.util.NetTool;
import com.lanou3g.gifttheory.util.constant.Constant;
import com.lanou3g.gifttheory.util.nettool.CallBack;

/**
 * Created by 司帅 on 17/2/15.
 */

public class ListBeanFragment extends BaseFragment{
    private TextView showTv;
    private LRecyclerView lRecyclerView;
    private static final String TAG = "ListBeanFragment";
    @Override
    protected int setLayout() {
        return R.layout.fragment_list_bean;
    }

    @Override
    protected void initView() {
        showTv = (TextView) getView().findViewById(R.id.tv_show_list_bean);
        lRecyclerView = (LRecyclerView) getView().findViewById(R.id.l_recyclerView_list_bean);
    }

    @Override
    protected void initData() {
        Bundle args = getArguments();
        ListChannelBean.DataBean.RanksBean ranksBean = args.getParcelable("ranksBean");
        showTv.setText(ranksBean.getId()+"");
        String id = ranksBean.getId()+"";
        NetTool.getInstance().startRequest(Constant.LIST + id + Constant.LIST_OTHER, ListItemBean.class, new CallBack<ListItemBean>() {
            @Override
            public void onSuccess(ListItemBean response) {
                Log.e(TAG, "onSuccess: "+response.getData().getItems().size() );
            }

            @Override
            public void onError(Throwable e) {

            }
        });



    }

    @Override
    protected void bindEvent() {

    }

    public static ListBeanFragment newInstance(int position) {
        
        Bundle args = new Bundle();
        ListChannelBean.DataBean.RanksBean ranksBean = ListChannelStateViewPagerAdapter.getRanksBean(position);
        args.putParcelable("ranksBean",ranksBean);
        ListBeanFragment fragment = new ListBeanFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
