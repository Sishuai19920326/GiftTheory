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
import com.lanou3g.gifttheory.bean.SingleSecondBean;

import java.util.List;

/**
 * Created by 司帅 on 17/2/23.
 */

public class SingleSecondRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder>{
    private List<SingleSecondBean.DataBean.ItemsBean> itemsBeanList;
    private Context context;

    public SingleSecondRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setItemsBeanList(List<SingleSecondBean.DataBean.ItemsBean> itemsBeanList) {
        this.itemsBeanList = itemsBeanList;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseViewHolder.creatViewHolder(context,parent, R.layout.item_gift_bean);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        SingleSecondBean.DataBean.ItemsBean itemsBean = itemsBeanList.get(position);
        holder.setImage(R.id.iv_gift_cover_image,itemsBean.getCover_image_url());
        holder.setText(R.id.tv_gift_short_description,itemsBean.getDescription());
        holder.setText(R.id.tv_gift_title,itemsBean.getName());
        String price = "¥ "+itemsBean.getPrice();
        holder.setText(R.id.tv_gift_price_skus_first,price);
    }

    @Override
    public int getItemCount() {
        return itemsBeanList == null ? 0 : itemsBeanList.size();
    }
}
