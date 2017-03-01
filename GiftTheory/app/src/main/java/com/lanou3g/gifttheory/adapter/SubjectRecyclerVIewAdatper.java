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
import com.lanou3g.gifttheory.bean.StoreUpBean;

import java.util.List;

/**
 * Created by 司帅 on 17/3/1.
 */

public class SubjectRecyclerVIewAdatper extends RecyclerView.Adapter<BaseViewHolder>{
    private StoreUpBean.DataBean.ItemsBeanX itemsBeanX;

    private List<StoreUpBean.DataBean.ItemsBeanX.ItemsBean> itemsBeanList;

    private Context context;

    public SubjectRecyclerVIewAdatper(Context context) {
        this.context = context;
    }

    public void setItemsBeanList(List<StoreUpBean.DataBean.ItemsBeanX.ItemsBean> itemsBeanList) {
        this.itemsBeanList = itemsBeanList;
        notifyDataSetChanged();
    }

    public void setItemsBeanX(StoreUpBean.DataBean.ItemsBeanX itemsBeanX) {
        this.itemsBeanX = itemsBeanX;
        notifyDataSetChanged();
    }
    private static final int HEAD = 100;
    private static final int BODY = 200;
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEAD){
            return BaseViewHolder.creatViewHolder(context,parent, R.layout.item_head_subject);
        }else {
            return BaseViewHolder.creatViewHolder(context,parent,R.layout.item_gift_bean);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (getItemViewType(position) == HEAD){
            holder.setImage(R.id.iv_cover_image_head_subject,itemsBeanX.getCover_image_url());
            holder.setText(R.id.tv_title_subject,itemsBeanX.getTitle());
            holder.setText(R.id.tv_introduction_subject,itemsBeanX.getIntroduction());
        }else {
            StoreUpBean.DataBean.ItemsBeanX.ItemsBean itemsBean = itemsBeanList.get(position-1);
            holder.setImage(R.id.iv_gift_cover_image,itemsBean.getCover_image_url());
            holder.setText(R.id.tv_gift_short_description,itemsBean.getShort_description());
            holder.setText(R.id.tv_gift_title,itemsBean.getTitle());
            String price = "¥ "+itemsBean.getSkus().get(0).getPrice();
            holder.setText(R.id.tv_gift_price_skus_first,price);
        }
    }

    @Override
    public int getItemCount() {
        return itemsBeanList == null ? 0 : itemsBeanList.size()+1;
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
