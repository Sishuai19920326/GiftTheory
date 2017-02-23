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
import android.view.ViewGroup;
import android.widget.GridView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseViewHolder;

import java.util.List;

/**
 * Created by 司帅 on 17/2/21.
 */

public class SearchRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder>{
    private Context context;
    private List<String> oldWordList;
    private List<String> hotWordsList;

    private static final int HEAD = 1000;

    private static final int BODY = 2000;

    public void setHotWordsList(List<String> hotWordsList) {
        this.hotWordsList = hotWordsList;
        notifyDataSetChanged();
    }
    public void setOldWordList(List<String> oldWordList) {
        this.oldWordList = oldWordList;
        notifyDataSetChanged();
    }

    public SearchRecyclerViewAdapter(Context context) {
        this.context = context;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEAD){
            return BaseViewHolder.creatViewHolder(context,parent,R.layout.item_search_recyclerview_head);
        }else {
            return BaseViewHolder.creatViewHolder(context,parent,R.layout.item_search_recyclerview_body);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (HEAD == getItemViewType(position) && hotWordsList != null){
            GridView gridView = holder.getView(R.id.gridView_search_head);
            SearchGridViewAdapter adapter = new SearchGridViewAdapter();
            adapter.setHotWordsList(hotWordsList);
            gridView.setAdapter(adapter);
        }
    }

    @Override
    public int getItemCount() {
        return oldWordList == null ? 1 :oldWordList.size()+1;
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
