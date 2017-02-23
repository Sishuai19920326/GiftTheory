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

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.adapter.StoreRecyclerViewAdapter;
import com.lanou3g.gifttheory.base.BaseFragment;
import com.lanou3g.gifttheory.bean.StoreDownBean;
import com.lanou3g.gifttheory.bean.StoreUpBean;
import com.lanou3g.gifttheory.util.NetTool;
import com.lanou3g.gifttheory.util.constant.Constant;
import com.lanou3g.gifttheory.util.nettool.CallBack;

import java.util.List;

/**
 * Created by 司帅 on 17/2/11.
 */

public class StoreFragment extends BaseFragment{
    private RecyclerView recyclerView;
    private StoreRecyclerViewAdapter mAdapter;
    private static final String TAG = "StoreFragment";
    @Override
    protected int setLayout() {
        return R.layout.fragment_store;
    }

    @Override
    protected void initView() {
        recyclerView = bindView(getView(),R.id.recyclerView_store);
    }

    @Override
    protected void initData() {
        mAdapter = new StoreRecyclerViewAdapter(getActivity());


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position < 5)
                return 2;
                else {
                    return 1;
                }
            }
        });

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(mAdapter);

        NetTool.getInstance().startRequest(Constant.MallUP, StoreUpBean.class, new CallBack<StoreUpBean>() {
            @Override
            public void onSuccess(StoreUpBean response) {
                List<StoreUpBean.DataBean.ItemsBeanX> itemsBeanXList = response.getData().getItems();
                mAdapter.setItemsBeanXList(itemsBeanXList);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
        NetTool.getInstance().startRequest(Constant.Malldown, StoreDownBean.class, new CallBack<StoreDownBean>() {
            @Override
            public void onSuccess(StoreDownBean response) {
                List<StoreDownBean.DataBean.ItemsBean> itemsBeanList = response.getData().getItems();
                mAdapter.setItemsBeanList(itemsBeanList);
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
