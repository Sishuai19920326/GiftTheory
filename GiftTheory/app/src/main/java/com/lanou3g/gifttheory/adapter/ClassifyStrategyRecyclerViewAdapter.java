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
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.activity.ClassifySecondActivity;
import com.lanou3g.gifttheory.activity.ColumnActivity;
import com.lanou3g.gifttheory.base.BaseViewHolder;
import com.lanou3g.gifttheory.bean.ClassifyColumnBean;
import com.lanou3g.gifttheory.bean.ClassifyStrategyBean;
import com.lanou3g.gifttheory.util.MyGridView;
import com.lanou3g.gifttheory.util.MyNotMoveRecyclerView;

import java.util.List;

/**
 * Created by 司帅 on 17/2/16.
 */

public class ClassifyStrategyRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder>{
    private Context context;
    private List<ClassifyStrategyBean.DataBean.ChannelGroupsBean> channelGroupsBeanList;
    private List<ClassifyColumnBean.DataBean.ColumnsBean> columnsBeanList;

    public void setColumnsBeanList(List<ClassifyColumnBean.DataBean.ColumnsBean> columnsBeanList) {
        this.columnsBeanList = columnsBeanList;
        notifyDataSetChanged();
    }

    public ClassifyStrategyRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setChannelGroupsBeanList(List<ClassifyStrategyBean.DataBean.ChannelGroupsBean> channelGroupsBeanList) {
        this.channelGroupsBeanList = channelGroupsBeanList;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0){
            return BaseViewHolder.creatViewHolder(context,parent, R.layout.item_classify_strategy_header);
        }
        return BaseViewHolder.creatViewHolder(context,parent,R.layout.item_classify_strategy_bean);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (position == 0){
             holder.getView(R.id.tv_column_strategy_header);
            RecyclerView recyclerView = holder.getView(R.id.recyclerView_strategy_header);
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context,3, LinearLayoutManager.HORIZONTAL,false);
            recyclerView .setLayoutManager(layoutManager);
            ClassifyItemUpRecyclerViewAdapter classifyItemUpRecyclerViewAdapter = new ClassifyItemUpRecyclerViewAdapter(context);
            classifyItemUpRecyclerViewAdapter.setColumnsBeanList(columnsBeanList);
            recyclerView.setAdapter(classifyItemUpRecyclerViewAdapter);
            TextView lookAllTv = holder.getView(R.id.tv_look_all_strategy_header);
            lookAllTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentActivity fragmentActivity = (FragmentActivity) context;
                    Intent intent = new Intent(fragmentActivity, ColumnActivity.class);
                    fragmentActivity.startActivity(intent);
                }
            });
        }else{
            final ClassifyStrategyBean.DataBean.ChannelGroupsBean channelGroupsBean = channelGroupsBeanList.get(position-1);
            List<ClassifyStrategyBean.DataBean.ChannelGroupsBean.ChannelsBean> channelsBeanList = channelGroupsBean.getChannels();
            holder.setText(R.id.tv_name_strategy_bean,channelGroupsBean.getName());
            TextView lookAllTv = holder.getView(R.id.tv_look_all_strategy_bean);
            if (channelsBeanList.size()<=6){
                lookAllTv.setVisibility(View.GONE);
            }
            lookAllTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentActivity fragmentActivity = (FragmentActivity) context;
                    Intent intent = new Intent(fragmentActivity, ClassifySecondActivity.class);
                    intent.putExtra("channelGroupsBean",channelGroupsBean);
                    fragmentActivity.startActivity(intent);
                }
            });
            MyNotMoveRecyclerView myNotMoveRecyclerView = holder.getView(R.id.recyclerView_strategy_bean);
            ClassifyItemDownRecyclerViewAdapter mAdapter = new ClassifyItemDownRecyclerViewAdapter(context);
            mAdapter.setChannelsBeanList(channelsBeanList);
            myNotMoveRecyclerView.setLayoutManager(new GridLayoutManager(context,2));
            myNotMoveRecyclerView.setAdapter(mAdapter);

        }
    }

    @Override
    public int getItemCount() {
        return channelGroupsBeanList == null ? 1 : channelGroupsBeanList.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


}
