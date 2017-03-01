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
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.activity.ColumnActivity;
import com.lanou3g.gifttheory.base.BaseViewHolder;
import com.lanou3g.gifttheory.bean.ClassifyColumnBean;

import java.util.List;

/**
 * Created by 司帅 on 17/2/17.
 */

public class ClassifyItemUpRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder>{
    private List<ClassifyColumnBean.DataBean.ColumnsBean> columnsBeanList;
    private static final String TAG = "ClassifyItemUpRecyclerV";
    private Context context;
    private static final int THE_LAST = 0;
    private static final int NOT_LAST = 1;
    public ClassifyItemUpRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setColumnsBeanList(List<ClassifyColumnBean.DataBean.ColumnsBean> columnsBeanList) {
        this.columnsBeanList = columnsBeanList;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == THE_LAST){
            return BaseViewHolder.creatViewHolder(context,parent, R.layout.item_classify_strategy_up_last_bean);
        }else {
            return BaseViewHolder.creatViewHolder(context,parent, R.layout.item_classify_strategy_up_bean);
        }

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (getItemViewType(position) == NOT_LAST){
            ClassifyColumnBean.DataBean.ColumnsBean columnsBean = columnsBeanList.get(position);
            holder.setText(R.id.tv_title_strategy_up,columnsBean.getTitle());
            holder.setImage(R.id.iv_image_strategy_up,columnsBean.getBanner_image_url());
            holder.setText(R.id.tv_author_strategy_up,columnsBean.getAuthor());
        }else {
            TextView lookAllTv = holder.getView(R.id.tv_look_all_strategy_last);
            lookAllTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentActivity fragmentActivity = (FragmentActivity) context;
                    Intent intent = new Intent(fragmentActivity, ColumnActivity.class);
                    fragmentActivity.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return columnsBeanList == null ? 0 : 12;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 11){
            return THE_LAST;
        }
        return NOT_LAST;
    }
}
