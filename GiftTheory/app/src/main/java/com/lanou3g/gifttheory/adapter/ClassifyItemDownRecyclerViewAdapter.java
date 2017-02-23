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
import com.lanou3g.gifttheory.bean.ClassifyStrategyBean;

import java.util.List;

/**
 * Created by 司帅 on 17/2/17.
 */

public class ClassifyItemDownRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder>{
    private List<ClassifyStrategyBean.DataBean.ChannelGroupsBean.ChannelsBean> channelsBeanList;
    private Context context;

    public ClassifyItemDownRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setChannelsBeanList(List<ClassifyStrategyBean.DataBean.ChannelGroupsBean.ChannelsBean> channelsBeanList) {
        this.channelsBeanList = channelsBeanList;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseViewHolder.creatViewHolder(context,parent,R.layout.item_classify_gridview_bean);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setImage(R.id.iv_gridView_item,channelsBeanList.get(position).getCover_image_url());
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
