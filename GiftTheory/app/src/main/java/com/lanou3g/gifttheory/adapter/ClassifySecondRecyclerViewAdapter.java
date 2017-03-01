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
 * Created by 司帅 on 17/3/1.
 */

public class ClassifySecondRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder>{
    private List<ClassifyStrategyBean.DataBean.ChannelGroupsBean.ChannelsBean> channelsBeanList;
    private Context context;

    public ClassifySecondRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setChannelsBeanList(List<ClassifyStrategyBean.DataBean.ChannelGroupsBean.ChannelsBean> channelsBeanList) {
        this.channelsBeanList = channelsBeanList;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseViewHolder.creatViewHolder(context,parent, R.layout.item_classify_gridview_bean);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        ClassifyStrategyBean.DataBean.ChannelGroupsBean.ChannelsBean channelsBean = channelsBeanList.get(position);
        holder.setImage(R.id.iv_gridView_item,channelsBean.getCover_image_url());
    }

    @Override
    public int getItemCount() {
        return channelsBeanList == null ? 0 : channelsBeanList.size();
    }
}
