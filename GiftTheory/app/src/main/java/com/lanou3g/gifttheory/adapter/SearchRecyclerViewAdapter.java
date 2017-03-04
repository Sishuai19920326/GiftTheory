package com.lanou3g.gifttheory.adapter;
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

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.GridView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseViewHolder;
import com.lanou3g.gifttheory.myinterface.DeleteListener;
import com.lanou3g.gifttheory.util.MyNotMoveRecyclerView;
import com.lanou3g.gifttheory.util.SearchDBTool;
import com.lanou3g.gifttheory.util.dbtool.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 司帅 on 17/2/21.
 */

public class SearchRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> implements DeleteListener {
    private Context context;
    private List<Search> searchList;
    private List<String> hotWordsList;
    private DeleteListener deleteListener;
    private static final int HEAD = 1000;

    private static final int BODY = 2000;
    private SearchBodyRecyclerViewAdapter adapter;

    public void setHotWordsList(List<String> hotWordsList) {
        this.hotWordsList = hotWordsList;
        notifyDataSetChanged();
    }

    public void setDeleteListener(DeleteListener deleteListener) {
        this.deleteListener = deleteListener;
    }

    public void setSearchList(List<Search> searchList) {
        this.searchList = searchList;
        notifyDataSetChanged();
    }

    public SearchRecyclerViewAdapter(Context context) {
        this.context = context;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEAD) {
            return BaseViewHolder.creatViewHolder(context, parent, R.layout.item_search_recyclerview_head);
        } else {
            return BaseViewHolder.creatViewHolder(context, parent, R.layout.item_search_recyclerview_body);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (HEAD == getItemViewType(position) && hotWordsList != null) {
            GridView gridView = holder.getView(R.id.gridView_search_head);
            SearchGridViewAdapter adapter = new SearchGridViewAdapter();
            adapter.setHotWordsList(hotWordsList);
            gridView.setAdapter(adapter);
        } else if (BODY == getItemViewType(position)) {
            MyNotMoveRecyclerView myNotMoveRecyclerView = holder.getView(R.id.m_rl_body);
            adapter = new SearchBodyRecyclerViewAdapter(context);
            adapter.setSearchList(searchList);
            adapter.setDeleteListener(this);
            myNotMoveRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            myNotMoveRecyclerView.setAdapter(adapter);
        }
    }

    @Override
    public int getItemCount() {
        return searchList == null ? 1 : 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEAD;
        } else {
            return BODY;
        }
    }



    @Override
    public void deleteALL() {
        SearchDBTool.getInstance().deleteAll();
        searchList.clear();
        adapter.notifyDataSetChanged();
        notifyDataSetChanged();
        Log.e("deleteALL", "1:" + searchList.size());
    }
}
