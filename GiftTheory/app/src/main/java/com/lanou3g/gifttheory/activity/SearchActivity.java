package com.lanou3g.gifttheory.activity;

import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou3g.gifttheory.R;
import com.lanou3g.gifttheory.adapter.SearchRecyclerViewAdapter;
import com.lanou3g.gifttheory.base.BaseActivity;
import com.lanou3g.gifttheory.bean.HotsWordBean;
import com.lanou3g.gifttheory.util.NetTool;
import com.lanou3g.gifttheory.util.constant.Constant;
import com.lanou3g.gifttheory.util.nettool.CallBack;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends BaseActivity {
    private TextView closeTv;
    private EditText searchEt;
    private ImageView clearIv;
    private RecyclerView searchRecyclerView;
    private SearchRecyclerViewAdapter adapter;
    private List<String> oldWordList;
    private SharedPreferences searchSp;
    private SharedPreferences.Editor searchEditor;
    @Override
    protected int bindLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        closeTv = (TextView) findViewById(R.id.tv_close_search);
        clearIv = (ImageView) findViewById(R.id.iv_search_clear);
        searchEt = (EditText) findViewById(R.id.et_search_content);
        searchRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_search);
    }

    @Override
    protected void initData() {
        oldWordList = new ArrayList<>();
        adapter = new SearchRecyclerViewAdapter(this);
        searchRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchRecyclerView.setAdapter(adapter);

        adapter.setOldWordList(oldWordList);
        getHotWordsList();


    }

    private void getHotWordsList() {
        NetTool.getInstance().startRequest(Constant.SEARCH, HotsWordBean.class, new CallBack<HotsWordBean>() {
            @Override
            public void onSuccess(HotsWordBean response) {
                List<String> hotWordsList = response.getData().getHot_words();
                adapter.setHotWordsList(hotWordsList);
            }
            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    protected void bindEvent() {
        //取消按钮的点击事件
        closeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.anim_start,R.anim.anim_finish);
            }
        });
        //搜索框的文本改变事件
        searchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    clearIv.setVisibility(View.GONE);
                }else {
                    clearIv.setVisibility(View.VISIBLE);
                }
            }
        });
        //删除键的监听事件
        clearIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchEt.setText("");
            }
        });
        searchEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (searchEt.getText().length()==0){
                    searchEt.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
                    Toast.makeText(SearchActivity.this, "你好", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //动画效果侧滑退出
        overridePendingTransition(R.anim.anim_start,R.anim.anim_finish);
    }
}
