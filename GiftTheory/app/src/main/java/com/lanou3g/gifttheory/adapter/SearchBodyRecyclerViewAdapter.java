package com.lanou3g.gifttheory.adapter;
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

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseViewHolder;
import com.lanou3g.gifttheory.myinterface.DeleteListener;
import com.lanou3g.gifttheory.util.SearchDBTool;
import com.lanou3g.gifttheory.util.dbtool.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 司帅 on 17/3/4.
 */

public class SearchBodyRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder>{
    private List<Search> searchList;
    public static final int HEAD = -1;
    public static final int BODY = -2;
    private Context context;
    private DeleteListener deleteListener;

    public void setDeleteListener(DeleteListener deleteListener) {
        this.deleteListener = deleteListener;
    }

    public SearchBodyRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setSearchList(List<Search> searchList) {
        this.searchList = searchList;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEAD){
            return BaseViewHolder.creatViewHolder(context,parent,R.layout.item_search_body_head);
        }else {
            return BaseViewHolder.creatViewHolder(context,parent,R.layout.item_search_body_bean);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, final int position) {
        if (position != 0 ){
            final Search search = searchList.get(position-1);
            holder.setText(R.id.tv_search_content,search.getContent());
            ImageView deleteIv = holder.getView(R.id.iv_search_delete);
            deleteIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    searchList.remove(position-1);
                    SearchDBTool.getInstance().deleteByContent(search.getContent());
                    notifyDataSetChanged();
                }
            });
        }else if (position == 0){
            if (searchList.size() == 0){
                holder.getmView().setVisibility(View.GONE);
            }
            ImageView deleteAll = holder.getView(R.id.iv_search_delete_all);
            deleteAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    SearchDBTool.getInstance().deleteAll();
//                    searchList = new ArrayList<>();
//                    notifyDataSetChanged();
                    deleteListener.deleteALL();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return searchList == null ? 0 :searchList.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return HEAD;
        }else {
            return BODY;
        }
    }
}
