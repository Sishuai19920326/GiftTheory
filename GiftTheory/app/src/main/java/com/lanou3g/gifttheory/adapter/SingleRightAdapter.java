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

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseViewHolder;
import com.lanou3g.gifttheory.bean.SingleBean;
import com.lanou3g.gifttheory.util.MyGridView;

import java.util.List;

/**
 * Created by 司帅 on 17/2/18.
 */

public class SingleRightAdapter extends BaseAdapter{
    private List<SingleBean.DataBean.CategoriesBean> categoriesBeanList;

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
        SingleBean.DataBean.CategoriesBean categoriesBean = categoriesBeanList.get(position);
        BaseViewHolder baseViewHolder = BaseViewHolder.creatListViewHolder(convertView,parent, R.layout.item_classify_single_right_bean);
        baseViewHolder.setText(R.id.tv_single_right_name,categoriesBean.getName());

        MyGridView gridView = baseViewHolder.getView(R.id.gridView_not_move);
        List<SingleBean.DataBean.CategoriesBean.SubcategoriesBean> subcategoriesBeanList = categoriesBean.getSubcategories();
        MyClassifyGridViewAdapter myClassifyGridViewAdapter = new MyClassifyGridViewAdapter();
        myClassifyGridViewAdapter.setSubcategoriesBeanList(subcategoriesBeanList);
        gridView.setAdapter(myClassifyGridViewAdapter);
        return baseViewHolder.getmView();
    }
}
