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
import android.widget.TextView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseViewHolder;

/**
 * Created by 司帅 on 17/2/16.
 */

public class ClassifyStrategyRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder>{
    private Context context;

    public ClassifyStrategyRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0){
            return BaseViewHolder.creatViewHolder(context,parent, R.layout.item_classify_strategy_header);
        }
        return BaseViewHolder.creatViewHolder(context,parent,R.layout.item_classify_strategy_bean);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (position == 0){
            TextView textView = holder.getView(R.id.tv_column_strategy_header);
            textView.setText("你好");
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
