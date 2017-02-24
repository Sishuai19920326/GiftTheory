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
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.base.BaseViewHolder;
import com.lanou3g.gifttheory.bean.HomeBannerBean;
import com.lanou3g.gifttheory.bean.HomeItemBean;
import com.lanou3g.gifttheory.bean.HomeModuleBean;
import com.lanou3g.gifttheory.myinterface.MyItemOnClickListenr;

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

    private MyItemOnClickListenr myItemOnClickListenr;

    public void setMyItemOnClickListenr(MyItemOnClickListenr myItemOnClickListenr) {
        this.myItemOnClickListenr = myItemOnClickListenr;
    }

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
            ConvenientBanner convenientBanner = holder.getView(R.id.banner_home_ad);
            convenientBanner.startTurning(4000);
            convenientBanner.setPointViewVisible(true);
            convenientBanner.setPageIndicator(new int[]{R.mipmap.ic_wu_dian,R.mipmap.ic_red_dian});
            //轮播图设置图片集合 和 图片加载类(在适配器写了个内部类 继承convenientBanner带的Holder类 并实现方法)
            convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
                @Override
                public NetworkImageHolderView createHolder() {
                    return new NetworkImageHolderView();
                }
            }, imageUrlList);
            //轮播图的点击事件 写了个接口回调到对应的fragment里进行处理
            convenientBanner.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    myItemOnClickListenr.onItemClick(position);
                }
            });
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

    //轮播图加载类和处理图片
    public class NetworkImageHolderView implements Holder<String>{
        private ImageView imageView;
        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            Glide.with(context).load(data).into(imageView);
        }
    }
}
