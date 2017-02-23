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

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseViewHolder;

import java.util.List;

/**
 * Created by 司帅 on 17/2/21.
 */

public class SearchGridViewAdapter extends BaseAdapter{
    private List<String> hotWordsList;

    public void setHotWordsList(List<String> hotWordsList) {
        this.hotWordsList = hotWordsList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return hotWordsList == null ? 0 : hotWordsList.size();
    }

    @Override
    public Object getItem(int position) {
        return hotWordsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseViewHolder baseViewHolder = BaseViewHolder.creatListViewHolder(convertView,parent, R.layout.item_search_recyclerview_head_bean);
        baseViewHolder.setText(R.id.tv_search_head_bean_words,hotWordsList.get(position));
        TextView hotTv = baseViewHolder.getView(R.id.tv_search_head_bean_words);
        if (position<3){
            hotTv.setTextColor(Color.RED);
            hotTv.setBackgroundResource(R.color.backf);
//            hotTv.setBackgroundColor(Color.alpha(R.color.backf));

        }
        return baseViewHolder.getmView();
    }
}
