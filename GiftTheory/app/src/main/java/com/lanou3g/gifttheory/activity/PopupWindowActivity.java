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
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
    private ImageView iconIv, closeIv, addIv, minusIv;
    private EditText numEt;
    private TextView priceTv, stockTv, seletedTv;
    private int stock;
    private int position;
    public static final String GET_SELETED = "getSeleted";

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
        seletedTv = (TextView) findViewById(R.id.tv_selected_popupWindow);
        closeIv = (ImageView) findViewById(R.id.iv_close_popupWindow);
        numEt = (EditText) findViewById(R.id.et_numb_popupWindow);
        addIv = (ImageView) findViewById(R.id.iv_add_popupWindow);
        minusIv = (ImageView) findViewById(R.id.iv_minus_popupWindow);

        itemsBean = getIntent().getParcelableExtra("itemsBean");
        Glide.with(PopupWindowActivity.this).load(itemsBean.getCover_image_url()).into(iconIv);

        if (itemsBean != null) {
            skusBeanList = itemsBean.getSkus();
            stock = 0;
            for (int i = 0; i < skusBeanList.size(); i++) {
                int j = skusBeanList.get(i).getStock();
                stock += j;
            }
            stockTv.setText("库存" + stock + "" + " 件");
            initRadioGroup();
        }
        bindEvent();

    }

    private void bindEvent() {
        //结束按钮的监听
        closeIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBro();
                finish();
            }
        });
        //数量框的监听事件
        numEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                Log.d("beforeTextChanged", "s:" + s + " start" + start + " count " + count + " after " + after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.e("onTextChanged", "s:" + s + " start" + start + " before " + before + " count " + count);
                if (s.length() == 0) {
                    s = "1";//修改s的值 让他不为空 不能直接设置numEt里的值
                    numEt.setText(s);
                } else {
                    if (radioGroup.getCheckedRadioButtonId() != -1 && Integer.parseInt(s.toString()) > skusBeanList.get(position).getStock()) {
                        numEt.setText(skusBeanList.get(position).getStock() + "");
                    } else if (radioGroup.getCheckedRadioButtonId() == -1 && Integer.parseInt(s.toString()) > stock) {
                        numEt.setText(stock + "");
                    }
                }
                //根据数量设置图片
                if (Integer.parseInt(s.toString()) < 2 && Integer.parseInt(s.toString()) >0) {
                    minusIv.setImageResource(R.mipmap.btn_reduce_disabled);
                } else {
                    minusIv.setImageResource(R.mipmap.btn_reduce_normal);
                }
                if (radioGroup.getCheckedRadioButtonId() != -1 && Integer.parseInt(s.toString()) >= skusBeanList.get(position).getStock()) {
                    addIv.setImageResource(R.mipmap.btn_increase_disabled);
                } else if (radioGroup.getCheckedRadioButtonId() == -1 && Integer.parseInt(s.toString()) >= stock) {
                    addIv.setImageResource(R.mipmap.btn_increase_disabled);
                } else {
                    addIv.setImageResource(R.mipmap.btn_increase_normal);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
//                Log.d("afterTextChanged", "s:" + s);
            }
        });
        //+号
        addIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(numEt.getText().toString()) + 1;
                numEt.setText(num + "");
            }
        });
        //-号
        minusIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(numEt.getText().toString()) - 1;
                if (Integer.parseInt(numEt.getText().toString()) > 1) {
                    numEt.setText(num + "");
                }
            }
        });
    }

    //规格选择框
    private void initRadioGroup() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_popupWindow);

        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(15, 6, 15, 6);
        //根据数据动态添加radioButton
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
                Log.d("PopupWindowActivity", "radioGroup.getCheckedRadioButtonId():" + radioGroup.getCheckedRadioButtonId());
                //判断选择状态 设定显示数据
                if (radioGroup.getCheckedRadioButtonId() != -1) {
                    position = (int) radioButtonCheck.getTag();
                    Log.d("PopupWindowActivity", "position:" + position);
                    Glide.with(PopupWindowActivity.this).load(skusBeanList.get(position).getCover_image_url()).into(iconIv);
                    stockTv.setText("库存" + skusBeanList.get(position).getStock() + "" + " 件");
                    priceTv.setText("¥" + skusBeanList.get(position).getPrice() + "");
                    String seleted = (char) 34 + radioButtonCheck.getText().toString() + (char) 34;
                    seletedTv.setText("已选 " + seleted);
                } else {
                    Glide.with(PopupWindowActivity.this).load(itemsBean.getCover_image_url()).into(iconIv);
                    stockTv.setText("库存" + stock + "" + " 件");
                }
            }
        });
        for (int i = 0; i < skusBeanList.size(); i++) {
            RadioButton radioButton = (RadioButton) findViewById(i + 1);
            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //如果id相等 清空radioGroup选项
                    if (lastId == v.getId()) {
                        radioGroup.clearCheck();
                        lastId = 0;
                        //如果id 赋值给上一个lastId
                    } else {
                        lastId = v.getId();
                    }
                }
            });
        }
    }

    //触击屏幕外部销毁activity
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        sendBro();
        finish();
        return true;
    }

    private void sendBro() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Intent intent = new Intent(GET_SELETED);
            intent.putExtra("NoSeleted", true);
            sendBroadcast(intent);
        } else {
            Intent intent = new Intent(GET_SELETED);
            intent.putExtra("HasSeleted", position);
            intent.putExtra("num", numEt.getText().toString());
            sendBroadcast(intent);
        }
    }
}
