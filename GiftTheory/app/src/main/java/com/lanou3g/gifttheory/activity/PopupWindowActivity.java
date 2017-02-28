package com.lanou3g.gifttheory.activity;
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

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.bean.ListItemBean;

import java.util.List;


/**
 * Created by 司帅 on 17/2/25.
 */

public class PopupWindowActivity extends Activity {
    private LinearLayout layout;
    private ListItemBean.DataBean.ItemsBean itemsBean;
    private RadioGroup radioGroup;
    private List<ListItemBean.DataBean.ItemsBean.SkusBean> skusBeanList;
    private int lastId;
    private ImageView iconIv;
    private TextView priceTv,stockTv;
    private int stock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift_details_popupwindow);
        //绘制窗口宽高
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        layout = (LinearLayout) findViewById(R.id.pop_layout);
        //抢先onTouchEvent
        layout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

            }
        });

        iconIv = (ImageView) findViewById(R.id.iv_image_popupWindow);
        priceTv = (TextView) findViewById(R.id.tv_price_popupWindow);
        stockTv = (TextView) findViewById(R.id.tv_stock_popupwindow);

        itemsBean = getIntent().getParcelableExtra("itemsBean");
        Glide.with(PopupWindowActivity.this).load(itemsBean.getCover_image_url()).into(iconIv);

        if (itemsBean != null) {
            skusBeanList = itemsBean.getSkus();
            stock = 0;
            for (int i = 0; i < skusBeanList.size(); i++) {
                int j = skusBeanList.get(i).getStock();
                stock += j;

            }
            stockTv.setText(stock+""+" 件");
            initRadioGroup();
        }

    }

    private void initRadioGroup() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_popupWindow);

        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(15, 6, 15, 6);

        for (int i = 0; i < skusBeanList.size(); i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(skusBeanList.get(i).getSpecs().get(0).getProperty());
            radioButton.setTextColor(getResources().getColorStateList(R.drawable.radiobutton_text_color_popupwindow));
            radioButton.setId(i + 1);
            radioButton.setTag(i);
            radioButton.setTextSize(12);
            radioButton.setBackground(getResources().getDrawable(R.drawable.radiobutton_popupwindow_bg));
            radioButton.setButtonDrawable(android.R.color.transparent);//隐藏单选圆形按钮
            radioButton.setGravity(Gravity.CENTER);
            radioButton.setPadding(20, 6, 20, 6);
            radioGroup.addView(radioButton, layoutParams);
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButtonCheck = (RadioButton) findViewById(checkedId);

                if (radioGroup.getCheckedRadioButtonId() != -1){
                    int position = (int) radioButtonCheck.getTag();
                    Log.d("PopupWindowActivity", "position:" + position);
                    Log.d("PopupWindowActivity", "skusBeanList.size():" + skusBeanList.size());
                    Log.e("PopupWindowActivity", "skusBeanList.get(position).getCover_image_url():" + skusBeanList.get(position).getCover_image_url());

                    Glide.with(PopupWindowActivity.this).load(skusBeanList.get(position).getCover_image_url()).into(iconIv);
                    stockTv.setText(skusBeanList.get(position).getStock()+""+" 件");
                    priceTv.setText("¥"+skusBeanList.get(position).getPrice()+"");
                }else{
                    Glide.with(PopupWindowActivity.this).load(itemsBean.getCover_image_url()).into(iconIv);
                    stockTv.setText(stock+""+" 件");
                }
            }
        });
        for (int i = 0; i < skusBeanList.size(); i++) {
            RadioButton radioButton = (RadioButton) findViewById(i + 1);
            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //如果id相等 清空radioGroup选项
                    if (lastId == v.getId()){
                        radioGroup.clearCheck();
                        lastId = 0;
                        //如果id 赋值给上一个lastId
                    }else {
                        lastId = v.getId();
                    }
                }
            });
        }
    }

    //触击屏幕外部销毁activity
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }
}
