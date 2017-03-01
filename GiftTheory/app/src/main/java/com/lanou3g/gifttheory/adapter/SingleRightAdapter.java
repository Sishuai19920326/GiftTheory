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
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.activity.SingleSencondActivity;
import com.lanou3g.gifttheory.base.BaseViewHolder;
import com.lanou3g.gifttheory.bean.SingleBean;
import com.lanou3g.gifttheory.util.MyGridView;

import java.util.List;

/**
 * Created by 司帅 on 17/2/18.
 */

public class SingleRightAdapter extends BaseAdapter{
    private List<SingleBean.DataBean.CategoriesBean> categoriesBeanList;
    private Context context;
    public static final String TO_SECOND =  "subcategoriesBean";

    public SingleRightAdapter(Context context) {
        this.context = context;
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
        SingleBean.DataBean.CategoriesBean categoriesBean = categoriesBeanList.get(position);

        BaseViewHolder baseViewHolder = BaseViewHolder.creatListViewHolder(convertView,parent, R.layout.item_classify_single_right_bean);
        baseViewHolder.setText(R.id.tv_single_right_name,categoriesBean.getName());

        MyGridView gridView = baseViewHolder.getView(R.id.gridView_not_move);

        final List<SingleBean.DataBean.CategoriesBean.SubcategoriesBean> subcategoriesBeanList = categoriesBean.getSubcategories();

        MyClassifyGridViewAdapter myClassifyGridViewAdapter = new MyClassifyGridViewAdapter();
        myClassifyGridViewAdapter.setSubcategoriesBeanList(subcategoriesBeanList);
        gridView.setAdapter(myClassifyGridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent toSecondIntent = new Intent(context, SingleSencondActivity.class);
                    toSecondIntent.putExtra(TO_SECOND,subcategoriesBeanList.get(position));
                context.startActivity(toSecondIntent);
                FragmentActivity activity = (FragmentActivity)context;
                activity.overridePendingTransition(R.anim.anim_start,R.anim.anim_finish);
            }
        });
        return baseViewHolder.getmView();
    }
}
