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
import android.widget.TextView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseViewHolder;
import com.lanou3g.gifttheory.bean.StoreUpBean;

import java.util.List;

/**
 * Created by 司帅 on 17/2/18.
 */

public class StoreUpRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder>{
    private Context context;
    private List<StoreUpBean.DataBean.ItemsBeanX.ItemsBean> itemsBeanXItemsList;

    public void setItemsBeanXItemsList(List<StoreUpBean.DataBean.ItemsBeanX.ItemsBean> itemsBeanXItemsList) {
        this.itemsBeanXItemsList = itemsBeanXItemsList;
        notifyDataSetChanged();
    }

    public StoreUpRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseViewHolder.creatViewHolder(context,parent, R.layout.item_store_up_bean_recyclerview_bean);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (position == 6){
            TextView shortTv = holder.getView(R.id.tv_store_up_recyclerView_short_description);
            shortTv.setVisibility(View.GONE);
            TextView priceTv = holder.getView(R.id.tv_store_up_recyclerView_price_skus_first);
            priceTv.setVisibility(View.GONE);
            holder.setImage(R.id.iv_store_up_recyclerView_cover_image,R.mipmap.icon_commodity_more);
        }else {
            StoreUpBean.DataBean.ItemsBeanX.ItemsBean itemsBean = itemsBeanXItemsList.get(position);
            holder.setText(R.id.tv_store_up_recyclerView_short_description,itemsBean.getShort_description());
            String price = "¥ "+itemsBean.getSkus().get(0).getPrice();
            holder.setText(R.id.tv_store_up_recyclerView_price_skus_first,price);
            holder.setImage(R.id.iv_store_up_recyclerView_cover_image,itemsBean.getCover_image_url());
        }

    }

    @Override
    public int getItemCount() {
        return itemsBeanXItemsList == null ? 0 : 7 ;
    }
}
