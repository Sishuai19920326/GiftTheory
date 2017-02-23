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

import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.adapter.SingleLeftAdapter;
import com.lanou3g.gifttheory.adapter.SingleRightAdapter;
import com.lanou3g.gifttheory.base.BaseFragment;
import com.lanou3g.gifttheory.bean.SingleBean;
import com.lanou3g.gifttheory.util.NetTool;
import com.lanou3g.gifttheory.util.constant.Constant;
import com.lanou3g.gifttheory.util.nettool.CallBack;

import java.util.List;

/**
 * Created by 司帅 on 17/2/16.
 */

public class ClassifySingleFragment extends BaseFragment{
    private ListView listViewLeft,listViewRight;
    private static final String TAG = "ClassifySingleFragment";
    private SingleLeftAdapter singleLeftAdapter;
    private SingleRightAdapter singleRightAdapter;

    private int lastPos;
    @Override
    protected int setLayout() {
        return R.layout.fragment_classify_single;
    }

    @Override
    protected void initView() {
        listViewLeft = bindView(getView(),R.id.listView_single_left);
        listViewRight = bindView(getView(),R.id.listView_single_right);
    }

    @Override
    protected void initData() {
        singleLeftAdapter = new SingleLeftAdapter();
        singleRightAdapter = new SingleRightAdapter();
        listViewLeft.setAdapter(singleLeftAdapter);
        listViewRight.setAdapter(singleRightAdapter);
        NetTool.getInstance().startRequest(Constant.SINGLE, SingleBean.class, new CallBack<SingleBean>() {
            @Override
            public void onSuccess(SingleBean response) {
                List<SingleBean.DataBean.CategoriesBean> categoriesBeanList = response.getData().getCategories();
                singleLeftAdapter.setCategoriesBeanList(categoriesBeanList);
                singleRightAdapter.setCategoriesBeanList(categoriesBeanList);
            }
            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    protected void bindEvent() {
        listViewLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listViewRight.setSelection(position);
            }
        });
        listViewRight.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int nowPos = view.getFirstVisiblePosition();

                if (nowPos != lastPos){
                    listViewLeft.setSelection(nowPos);
                    singleLeftAdapter.setSelectPos(nowPos);
                    //距离顶部滑动偏移2个单位
                    listViewLeft.smoothScrollToPositionFromTop(nowPos,100);
                }
                lastPos = nowPos;
            }
        });
    }
}
