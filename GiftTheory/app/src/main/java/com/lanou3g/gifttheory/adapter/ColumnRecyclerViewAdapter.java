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

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseViewHolder;
import com.lanou3g.gifttheory.bean.ClassifyColumnBean;
import com.lanou3g.gifttheory.bean.ClassifyStrategyBean;

import java.util.List;

/**
 * Created by 司帅 on 17/3/1.
 */

public class ColumnRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder>{
    private Context context;
    private List<ClassifyColumnBean.DataBean.ColumnsBean> columnsBeanList;

    public ColumnRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setColumnsBeanList(List<ClassifyColumnBean.DataBean.ColumnsBean> columnsBeanList) {
        this.columnsBeanList = columnsBeanList;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseViewHolder.creatViewHolder(context,parent, R.layout.item_column_bean);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        ClassifyColumnBean.DataBean.ColumnsBean columnsBean = columnsBeanList.get(position);
        holder.setImage(R.id.iv_banner_image_column_bean,columnsBean.getBanner_image_url());
        holder.setText(R.id.iv_title_column_bean,columnsBean.getTitle());
        holder.setText(R.id.iv_author_column_bean,columnsBean.getAuthor());
    }

    @Override
    public int getItemCount() {
        return columnsBeanList == null? 0 : columnsBeanList.size();
    }
}
