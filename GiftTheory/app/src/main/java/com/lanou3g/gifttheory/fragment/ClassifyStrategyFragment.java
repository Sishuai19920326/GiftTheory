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

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.adapter.ClassifyStrategyRecyclerViewAdapter;
import com.lanou3g.gifttheory.base.BaseFragment;

/**
 * Created by 司帅 on 17/2/16.
 */

public class ClassifyStrategyFragment extends BaseFragment{
    private RecyclerView recyclerView;
    private ClassifyStrategyRecyclerViewAdapter mAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_classify_strategy;
    }

    @Override
    protected void initView() {
        recyclerView = bindView(getView(),R.id.recyclerView_strategy);
        mAdapter = new ClassifyStrategyRecyclerViewAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {

    }
}
