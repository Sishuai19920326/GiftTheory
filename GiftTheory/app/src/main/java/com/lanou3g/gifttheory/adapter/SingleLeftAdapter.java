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
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lanou3g.gifttheory.MyApp;
import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseViewHolder;
import com.lanou3g.gifttheory.bean.SingleBean;

import java.util.List;

/**
 * Created by 司帅 on 17/2/18.
 */

public class SingleLeftAdapter extends BaseAdapter{
    private List<SingleBean.DataBean.CategoriesBean> categoriesBeanList;
    private int selectPos;

    public void setSelectPos(int selectPos) {
        this.selectPos = selectPos;
        notifyDataSetChanged();
    }

    public void setCategoriesBeanList(List<SingleBean.DataBean.CategoriesBean> categoriesBeanList) {
        this.categoriesBeanList = categoriesBeanList;
        notifyDataSetChanged();
    }

    @Override

    public int getCount() {
        return categoriesBeanList == null ? 0 : categoriesBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return categoriesBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseViewHolder baseViewHolder = BaseViewHolder.creatListViewHolder(convertView,parent, R.layout.item_classify_single_left_bean);
        TextView nameTv = baseViewHolder.getView(R.id.tv_single_left_name);
        nameTv.setText(categoriesBeanList.get(position).getName());

        if (position == selectPos) {
            nameTv.setTextColor(Color.RED);
        } else{
            nameTv.setTextColor(Color.BLACK);
        }
        return baseViewHolder.getmView();
    }
}
