package com.lanou3g.gifttheory.adapter;
/**
 * ██████齐天大圣 - 司帅████████
 * <p>
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
import android.view.View;
import android.view.ViewGroup;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseViewHolder;
import com.lanou3g.gifttheory.bean.HomeBannerBean;
import com.lanou3g.gifttheory.bean.HomeItemBean;
import com.lanou3g.gifttheory.bean.HomeModuleBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 司帅 on 17/2/14.
 */

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private List<HomeItemBean.DataBean.ItemsBean> itemsBeanList;

    private List<HomeBannerBean.DataBean.BannersBean> bannersBeanList;

    private List<HomeModuleBean.DataBean.SecondaryBannersBean> secondaryBannersBeanList;

    public HomeRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setSecondaryBannersBeanList(List<HomeModuleBean.DataBean.SecondaryBannersBean> secondaryBannersBeanList) {
        this.secondaryBannersBeanList = secondaryBannersBeanList;
        notifyDataSetChanged();
    }

    public void setItemsBeanList(List<HomeItemBean.DataBean.ItemsBean> itemsBeanList) {
        this.itemsBeanList = itemsBeanList;
        notifyDataSetChanged();
    }

    public void setBannersBeanList(List<HomeBannerBean.DataBean.BannersBean> bannersBeanList) {
        this.bannersBeanList = bannersBeanList;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return BaseViewHolder.creatViewHolder(context, parent, R.layout.item_home_banner);
        } else if (viewType == 1) {
            return BaseViewHolder.creatViewHolder(context, parent, R.layout.item_home_second_banner);
        } else {
            return BaseViewHolder.creatViewHolder(context, parent, R.layout.item_home_all);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (position == 0 && bannersBeanList != null) {
            List<String> imageUrlList = new ArrayList<>();
            for (int i = 0; i < bannersBeanList.size(); i++) {
                String imageUrl = bannersBeanList.get(i).getImage_url();
                imageUrlList.add(imageUrl);
            }
            holder.setHeaderBanner(R.id.banner_ad, 4000, imageUrlList);
        } else if (position == 1 && secondaryBannersBeanList != null) {
            holder.setImage(R.id.iv_carefully_one, secondaryBannersBeanList.get(0).getImage_url());
            holder.setImage(R.id.iv_carefully_two, secondaryBannersBeanList.get(1).getImage_url());
            holder.setImage(R.id.iv_carefully_three, secondaryBannersBeanList.get(2).getImage_url());
            holder.setImage(R.id.iv_carefully_four, secondaryBannersBeanList.get(3).getImage_url());
            holder.setImage(R.id.iv_carefully_five, secondaryBannersBeanList.get(4).getImage_url());
            holder.setImage(R.id.iv_carefully_six, secondaryBannersBeanList.get(5).getImage_url());

        } else if (position > 1) {
            HomeItemBean.DataBean.ItemsBean itemsBean = itemsBeanList.get(position-2);
            holder.setText(R.id.tv_introduction_home_all, itemsBean.getIntroduction());
            holder.setText(R.id.tv_author_nickname_home_all,itemsBean.getAuthor().getNickname());
            holder.setText(R.id.tv_author_introduction_home_all,itemsBean.getAuthor().getIntroduction());
            holder.setText(R.id.tv_title_home_all,itemsBean.getTitle());
            holder.setText(R.id.tv_likes_count_home_all,itemsBean.getLikes_count()+"");

            holder.setImageCircle(R.id.iv_author_avatar_url_home_all,itemsBean.getAuthor().getAvatar_url());

            holder.setImage(R.id.iv_cover_image_home_all,itemsBean.getCover_image_url());
            if (itemsBean.getColumn() != null){
                holder.setText(R.id.tv_column_title_home_all,itemsBean.getColumn().getTitle());
            }else {
                holder.getView(R.id.tv_column_title_home_all).setVisibility(View.INVISIBLE);
                holder.getView(R.id.tv_column_home_all).setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return itemsBeanList == null ? 0 : itemsBeanList.size() + 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
