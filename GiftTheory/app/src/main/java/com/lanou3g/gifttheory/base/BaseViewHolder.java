package com.lanou3g.gifttheory.base;
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
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
//import com.youth.banner.Banner;
//import com.youth.banner.BannerConfig;
//import com.youth.banner.loader.ImageLoader;
//
//import java.util.ArrayList;
//import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;


/**
 * Created by 司帅 on 17/2/14.
 */
//万能缓存类 2017年2月14日
public class BaseViewHolder extends RecyclerView.ViewHolder{
    //行布局的view
    private View mView;

    //SparseArray这个类的作用是存放View的 他很类似map的使用
    private SparseArray<View> mSparseArray;

    private Context context;

    //得到他的行布局
    public View getmView() {
        return mView;
    }

    public BaseViewHolder(View itemView, Context context) {
        super(itemView);
        mView = itemView;
        mSparseArray = new SparseArray<>();
        this.context = context;
    }
    //针对RecyclerView的初始化话操作
    public  static BaseViewHolder creatViewHolder(Context context, ViewGroup viewGroup,int layoutId){
        View itemView = LayoutInflater.from(context).inflate(layoutId,viewGroup,false);
        BaseViewHolder holder = new BaseViewHolder(itemView,context);
        return holder;
    }
    //针对ListView的初始化操作
    public static BaseViewHolder creatListViewHolder(View view,ViewGroup viewGroup,int layoutId){
        BaseViewHolder holder = null;
        if (view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutId,viewGroup,false);
            holder = new BaseViewHolder(view, viewGroup.getContext());
            view.setTag(holder);
        }else {
            holder = (BaseViewHolder) view.getTag();
        }
        return holder;
    }
    //根据id获取我们想要的组件
    public <T extends View> T getView(int id){
        //创建一个View 根据id从集合取出
        View view = mSparseArray.get(id);
        //如果没有渠道 那么久通过findviewbyid的方式绑定组件 然后将组件存放在集合里
        if (view == null){
            view = mView.findViewById(id);
            mSparseArray.put(id,view);
        }
        //最后返回的就是我们想要的组件
        return (T)view;
    }

    //自己随意的定义方法

    //设置文本内容
    public BaseViewHolder setText(int id,String text){
        TextView textView = getView(id);
        if (text != null){
            textView.setText(text);
        }
        return this;
    }

    //设置网络图片
    public BaseViewHolder setImage(int id,String url){
        ImageView imageView = getView(id);
        if (url != null){
            Glide.with(context).load(url)
                    .override(600,200)
                    .into(imageView);
        }
        return this;
    }
    //设置圆形网络图片
    public BaseViewHolder setImageCircle(int id,String url){
        ImageView imageView = getView(id);
        if (url != null){
            Glide.with(context).load(url)
                    .bitmapTransform(new CropCircleTransformation(context))
                    .into(imageView);
        }
        return this;
    }
    //设置本地图片
    public BaseViewHolder setImage(int id,int resId){
        ImageView imageView = getView(id);
        if (resId != 0){
            imageView.setImageResource(resId);
        }
        return this;
    }

}
