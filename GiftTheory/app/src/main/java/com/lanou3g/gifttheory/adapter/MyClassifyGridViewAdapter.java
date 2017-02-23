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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseViewHolder;
import com.lanou3g.gifttheory.bean.ClassifyStrategyBean;
import com.lanou3g.gifttheory.bean.SingleBean;

import java.util.List;

/**
 * Created by 司帅 on 17/2/17.
 */

public class MyClassifyGridViewAdapter extends BaseAdapter{
    private List<SingleBean.DataBean.CategoriesBean.SubcategoriesBean> subcategoriesBeanList;

    private static final String TAG = "MyClassifyGridViewAdapt";

    public void setSubcategoriesBeanList(List<SingleBean.DataBean.CategoriesBean.SubcategoriesBean> subcategoriesBeanList) {
        this.subcategoriesBeanList = subcategoriesBeanList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return subcategoriesBeanList == null ? 0 :subcategoriesBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return subcategoriesBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseViewHolder baseViewHolder = BaseViewHolder.creatListViewHolder(convertView,parent,R.layout.item_gridview_bean);
        if (subcategoriesBeanList != null){
            SingleBean.DataBean.CategoriesBean.SubcategoriesBean subcategoriesBean = subcategoriesBeanList.get(position);
            baseViewHolder.setImage(R.id.iv_gridView_icon,subcategoriesBean.getIcon_url());
            baseViewHolder.setText(R.id.tv_gridView_name,subcategoriesBean.getName());
        }

        return baseViewHolder.getmView();
    }


}
