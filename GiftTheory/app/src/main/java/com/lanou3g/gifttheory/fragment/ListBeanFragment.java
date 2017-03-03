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
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.lanou3g.gifttheory.app.MyApp;
import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.activity.GiftDetailsActivity;
import com.lanou3g.gifttheory.adapter.ListChannelStateViewPagerAdapter;
import com.lanou3g.gifttheory.adapter.ListRecyclerViewAdapter;
import com.lanou3g.gifttheory.base.BaseFragment;
import com.lanou3g.gifttheory.bean.ListChannelBean;
import com.lanou3g.gifttheory.bean.ListItemBean;
import com.lanou3g.gifttheory.myinterface.MyItemOnClickListenr;
import com.lanou3g.gifttheory.util.NetTool;
import com.lanou3g.gifttheory.util.constant.Constant;
import com.lanou3g.gifttheory.util.loadui.DurianLoading;
import com.lanou3g.gifttheory.util.nettool.CallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 司帅 on 17/2/15.
 */

public class ListBeanFragment extends BaseFragment implements MyItemOnClickListenr {

    private LRecyclerView lRecyclerView;
    private static final String TAG = "ListBeanFragment";
    private ListRecyclerViewAdapter listRecyclerViewAdapter;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private String id;
    private List<ListItemBean.DataBean.ItemsBean> itemsBeanList;
    private DurianLoading durianLoading;

    private String nextUrl;
    private View v;
    private ImageView imageView;

    @Override
    protected int setLayout() {
        return R.layout.fragment_list_bean;
    }

    @Override
    protected void initView() {

        lRecyclerView = (LRecyclerView) getView().findViewById(R.id.l_recyclerView_list_bean);
        durianLoading = bindView(getView(),R.id.tel_login_loading_img);
        durianLoading.showLoadUi(false,0);
    }

    @Override
    protected void initData() {
        Bundle args = getArguments();
        ListChannelBean.DataBean.RanksBean ranksBean = args.getParcelable("ranksBean");
        id = ranksBean.getId()+"";

        itemsBeanList = new ArrayList<>();

        listRecyclerViewAdapter = new ListRecyclerViewAdapter(getActivity(),ranksBean.getId());
        lRecyclerViewAdapter = new LRecyclerViewAdapter(listRecyclerViewAdapter);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        lRecyclerView.setLayoutManager(layoutManager);
        listRecyclerViewAdapter.setMyItemOnClickListenr(this);
        lRecyclerView.setAdapter(lRecyclerViewAdapter);



        v = LayoutInflater.from(getActivity()).inflate(R.layout.item_list_bean_image, lRecyclerView, false);
        imageView = (ImageView) v.findViewById(R.id.iv_cover_image_header_list);
        lRecyclerViewAdapter.addHeaderView(v);
        requestData();


    }

    @Override
    protected void bindEvent() {
        lRecyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
        lRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                onLoadMoreUrlData();
            }
        });
    }
    //复用fragment方法
    public static ListBeanFragment newInstance(int position) {

        Bundle args = new Bundle();
        ListChannelBean.DataBean.RanksBean ranksBean = ListChannelStateViewPagerAdapter.getRanksBean(position);
        args.putParcelable("ranksBean",ranksBean);
        ListBeanFragment fragment = new ListBeanFragment();
        fragment.setArguments(args);
        return fragment;
    }
    //加载更多数据的方法
    private void onLoadMoreUrlData() {
        if (TextUtils.isEmpty(ListBeanFragment.this.nextUrl)){
            //当没有下一个url 需要给他设置成true
            lRecyclerView.setNoMore(true);
        }else {

            NetTool.getInstance().startRequest(nextUrl , ListItemBean.class, new CallBack<ListItemBean>() {
                @Override
                public void onSuccess(ListItemBean response) {
                    //不知道他还有没有nexturl 给他设置成false
                    lRecyclerView.setNoMore(false);

                    itemsBeanList.addAll(response.getData().getItems());
                    listRecyclerViewAdapter.notifyDataSetChanged();
                    //用全局变量继承这个url
                    ListBeanFragment.this.nextUrl = response.getData().getPaging().getNext_url();
                }

                @Override
                public void onError(Throwable e) {

                }
            });
        }
    }
    //请求数据
    private void requestData() {


        NetTool.getInstance().startRequest(Constant.LIST + id + Constant.LIST_OTHER, ListItemBean.class, new CallBack<ListItemBean>() {
            @Override
            public void onSuccess(ListItemBean response) {

                itemsBeanList = response.getData().getItems();
                listRecyclerViewAdapter.setItemsBeanList(itemsBeanList);

                //头布局图片
                if (imageView!=null){
                    Glide.with(MyApp.getContext()).load(response.getData().getCover_image()).into(imageView);
                }


                ListBeanFragment.this.nextUrl = response.getData().getPaging().getNext_url();
                durianLoading.showLoadUi(true,0);

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
    //行布局的点击事件
    @Override
    public void onItemClick(int position) {
        ListItemBean.DataBean.ItemsBean itemsBean = itemsBeanList.get(position);
        Intent toGiftDeatilsIntent = new Intent(getActivity(), GiftDetailsActivity.class);
        toGiftDeatilsIntent.putExtra("itemsBean",itemsBean);
        startActivity(toGiftDeatilsIntent);
        String price;
        if (itemsBean.getPrice() == null) {
            price = "¥ " + itemsBean.getSkus().get(0).getPrice() + "";
        } else {
            price = "¥ " + itemsBean.getPrice() + "";
        }
        Log.e(TAG, price);
        getActivity().overridePendingTransition(R.anim.anim_start,R.anim.anim_finish);
    }
}
