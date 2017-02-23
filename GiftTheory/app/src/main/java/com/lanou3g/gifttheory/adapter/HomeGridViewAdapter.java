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
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseViewHolder;
import com.lanou3g.gifttheory.bean.HomeChannelBean;

import java.util.List;

/**
 * Created by 司帅 on 17/2/20.
 */

public class HomeGridViewAdapter extends BaseAdapter{
    private List<HomeChannelBean.DataBean.ChannelsBean> channelsBeanArrayList;
    private Context context;

    private int selectorPos;

    public void setSelectorPos(int selectorPos) {
        this.selectorPos = selectorPos;
        notifyDataSetChanged();
    }
    public HomeGridViewAdapter(Context context) {
        this.context = context;
    }

    public void setChannelsBeanArrayList(List<HomeChannelBean.DataBean.ChannelsBean> channelsBeanArrayList) {
        this.channelsBeanArrayList = channelsBeanArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return channelsBeanArrayList == null ?0 : channelsBeanArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return channelsBeanArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseViewHolder baseViewHolder = BaseViewHolder.creatListViewHolder(convertView,parent, R.layout.popupwindow_home_bean);
        baseViewHolder.setText(R.id.tv_name_channels_grid_view,channelsBeanArrayList.get(position).getName());
        TextView nameTv = baseViewHolder.getView(R.id.tv_name_channels_grid_view);
        if (selectorPos == position){
            nameTv.setTextColor(Color.RED);
        }else {
            nameTv.setTextColor(Color.BLACK);
        }
        //获得行布局
        return baseViewHolder.getmView();
    }
}
