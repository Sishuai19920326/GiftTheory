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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.activity.StrategyActivity;
import com.lanou3g.gifttheory.activity.SubjectActivity;
import com.lanou3g.gifttheory.app.MyApp;
import com.lanou3g.gifttheory.base.BaseViewHolder;
import com.lanou3g.gifttheory.bean.StoreDownBean;
import com.lanou3g.gifttheory.bean.StoreUpBean;

import java.util.List;

/**
 * Created by 司帅 on 17/2/18.
 */

public class StoreRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder>{
    private static final int UP = 100;
    private static final int DOWN = 200;
    private static final int DOWN_HEADER = 300;
    private Context context;
    private List<StoreUpBean.DataBean.ItemsBeanX> itemsBeanXList;
    private List<StoreDownBean.DataBean.ItemsBean> itemsBeanList;

    public void setItemsBeanXList(List<StoreUpBean.DataBean.ItemsBeanX> itemsBeanXList) {
        this.itemsBeanXList = itemsBeanXList;
        notifyDataSetChanged();
    }

    public StoreRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setItemsBeanList(List<StoreDownBean.DataBean.ItemsBean> itemsBeanList) {
        this.itemsBeanList = itemsBeanList;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == UP){
            return BaseViewHolder.creatViewHolder(context,parent, R.layout.item_store_up_bean);
        }else if (viewType == DOWN_HEADER){
            return BaseViewHolder.creatViewHolder(context,parent,R.layout.item_store_header_down);
        }else {
            return BaseViewHolder.creatViewHolder(context,parent, R.layout.item_gift_bean);

        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (itemsBeanXList != null && itemsBeanList != null){
            switch (getItemViewType(position)){
                case UP:
                    final StoreUpBean.DataBean.ItemsBeanX itemsBeanX = itemsBeanXList.get(position);
                    List<StoreUpBean.DataBean.ItemsBeanX.ItemsBean> itemsBeanXItemsList = itemsBeanX.getItems();
                    holder.setImage(R.id.iv_store_up_bean_cover_image,itemsBeanX.getCover_image_url());
                    holder.setText(R.id.tv_store_up_title,itemsBeanX.getTitle());
                    RecyclerView recyclerView = holder.getView(R.id.recyclerView_store_up);
                    StoreUpRecyclerViewAdapter adapter = new StoreUpRecyclerViewAdapter(context);
                    recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                    adapter.setItemsBeanXItemsList(itemsBeanXItemsList);
                    recyclerView.setAdapter(adapter);
                    ImageView imageView = holder.getView(R.id.iv_store_up_bean_cover_image);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MyApp.getContext(), SubjectActivity.class);
                            intent.putExtra("itemsBeanX",itemsBeanX);
                            context.startActivity(intent);
                        }
                    });
                    break;
                case DOWN_HEADER:
                    break;
                case DOWN:
                    StoreDownBean.DataBean.ItemsBean itemsBean = itemsBeanList.get(position-itemsBeanXList.size()-1);

                    holder.setImage(R.id.iv_gift_cover_image,itemsBean.getCover_image_url());
                    holder.setText(R.id.tv_gift_short_description,itemsBean.getShort_description());
                    holder.setText(R.id.tv_gift_title,itemsBean.getTitle());
                    String price = "¥ "+itemsBean.getSkus().get(0).getPrice();
                    holder.setText(R.id.tv_gift_price_skus_first,price);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return itemsBeanXList == null || itemsBeanList == null ? 6 :itemsBeanXList.size()+itemsBeanList.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < 4){
            return UP;
        }else if ( position == 4){
                return DOWN_HEADER;
        }else {
            return DOWN;
        }
    }
}
