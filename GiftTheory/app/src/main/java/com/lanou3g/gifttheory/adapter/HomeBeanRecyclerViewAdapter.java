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

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseViewHolder;
import com.lanou3g.gifttheory.bean.HomeItemBean;

import java.util.List;

/**
 * Created by 司帅 on 17/2/14.
 */

public class HomeBeanRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder>{
    private List<HomeItemBean.DataBean.ItemsBean> itemsBeanList;
    private Context context;

    public void setItemsBeanList(List<HomeItemBean.DataBean.ItemsBean> itemsBeanList) {
        this.itemsBeanList = itemsBeanList;
        notifyDataSetChanged();
    }

    public HomeBeanRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseViewHolder.creatViewHolder(context,parent, R.layout.item_home_all);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        HomeItemBean.DataBean.ItemsBean itemsBean = itemsBeanList.get(position);

        holder.setText(R.id.tv_introduction_home_all, itemsBean.getIntroduction());
        holder.setText(R.id.tv_author_nickname_home_all,itemsBean.getAuthor().getNickname());
        holder.setText(R.id.tv_author_introduction_home_all,itemsBean.getAuthor().getIntroduction());
        holder.setText(R.id.tv_title_home_all,itemsBean.getTitle());
        holder.setText(R.id.tv_likes_count_home_all,itemsBean.getLikes_count()+"");

        holder.setImageCircle(R.id.iv_author_avatar_url_home_all,itemsBean.getAuthor().getAvatar_url());

        holder.setImage(R.id.iv_cover_image_home_all,itemsBean.getCover_image_url());
        if (itemsBean.getColumn() != null){
            holder.setText(R.id.tv_column_title_home_all,itemsBean.getColumn().getTitle());
        }else {
            holder.getView(R.id.tv_column_title_home_all).setVisibility(View.INVISIBLE);
            holder.getView(R.id.tv_column_home_all).setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return itemsBeanList == null? 0 : itemsBeanList.size();
    }
}
