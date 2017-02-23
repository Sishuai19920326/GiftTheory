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
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseViewHolder;
import com.lanou3g.gifttheory.bean.ListItemBean;
import com.lanou3g.gifttheory.myinterface.MyItemOnClickListenr;

import java.util.List;

/**
 * Created by 司帅 on 17/2/15.
 */

public class ListRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<ListItemBean.DataBean.ItemsBean> itemsBeanList;
    private Context context;
    private MyItemOnClickListenr myItemOnClickListenr;
    private int myId;

    public void setMyItemOnClickListenr(MyItemOnClickListenr myItemOnClickListenr) {
        this.myItemOnClickListenr = myItemOnClickListenr;
    }

    public void setItemsBeanList(List<ListItemBean.DataBean.ItemsBean> itemsBeanList) {
        this.itemsBeanList = itemsBeanList;
        notifyDataSetChanged();
    }

    public ListRecyclerViewAdapter(Context context, int id) {
        this.context = context;
        myId = id;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseViewHolder.creatViewHolder(context, parent, R.layout.item_list_bean);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, final int position) {
        ListItemBean.DataBean.ItemsBean itemsBean = itemsBeanList.get(position);
        holder.setImage(R.id.iv_cover_image_list_bean, itemsBean.getCover_image_url());
        holder.setText(R.id.tv_short_description_list_bean, itemsBean.getShort_description());
        holder.setText(R.id.tv_name_list_bean, itemsBean.getName());

        int id = position == 0 ? 1 : position + 1;
        String num = "TOP" + id + "";
        holder.setText(R.id.tv_num_list_bean, num);
        TextView numTv = holder.getView(R.id.tv_num_list_bean);

        if (id < 4) {
            numTv.setBackgroundResource(R.color.backred);
            numTv.setTextColor(Color.WHITE);
        } else {
            numTv.setBackgroundResource(R.color.backnum);
            numTv.setTextColor(Color.RED);
        }

        if (myId == 1) {
            holder.getView(R.id.tv_num_list_bean).setVisibility(View.GONE);
        }

        String price;
        if (itemsBean.getPrice() == null) {
            price = "¥ " + itemsBean.getSkus().get(0).getPrice() + "";
        } else {
            price = "¥ " + itemsBean.getPrice() + "";
        }
        holder.setText(R.id.tv_price_list_bean, price);
        //行布局的点击事件 回调给fragment
        RecyclerView.ViewHolder viewHolder = holder;
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myItemOnClickListenr.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemsBeanList == null ? 0 : itemsBeanList.size();
    }
}
