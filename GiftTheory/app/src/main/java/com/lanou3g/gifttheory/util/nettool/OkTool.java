package com.lanou3g.gifttheory.util.nettool;
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

/**
 * Created by 司帅 on 17/2/11.
 */
//先导入三个依赖
//  第一个okhttp网络框架
//  第二个解析数据gson
//  第三个加载图片glide

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * compile 'com.squareup.okhttp3:okhttp:3.6.0'
 * compile 'com.google.code.gson:gson:2.8.0'
 * compile 'com.github.bumptech.glide:glide:3.7.0'
 */
public class OkTool implements NetInterface{
    private OkHttpClient mOkHttpClient;
    private Gson mGson;
    private Handler mHandler = new Handler(Looper.getMainLooper());////无论在哪里使用的handler 它都在主线程中

    public OkTool() {
        //初始化mGson对象
        mGson = new Gson();
        //构造者模式 初始化对象
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)//超时多少时间后为失败,参数数量和单位
                .retryOnConnectionFailure(true)//连接失败是否再次连接 填true表示可以
                .cache(new Cache(Environment.getExternalStorageDirectory(),10*1024*1024))//把网络缓存到sdk中,当在无网情况下,可以读取缓存信息
                .build();

    }

    @Override
    public <T> void startRequest(String url, final Class<T> tClass, final CallBack<T> callBack) {
        //根据不同的url构建出不同的请求对象
        Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            //请求失败的时候调用该方法
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e);
                    }
                });
            }
            //请求成功的时候调用该方法
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();

                Log.e("999999999", "onResponse: "+str);

                //调用解析对象 解析数据 给他一个类型声明得到这个实体类对象
                final T result = mGson.fromJson(str,tClass);
                //更新ui不能在子线程中 要调用handler让它使用在主线程中
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(result);
                    }
                });
            }
        });
    }

    @Override
    public void startRequest(String url, final CallBack<String> callBack) {
        //根据不同的url构建出不同的请求对象
        Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            //请求失败的时候调用该方法
            @Override
            public void onFailure(Call call, final IOException e) {
                //更新ui不能在子线程中 要调用handler让它使用在主线程中
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e);
                    }
                });
            }
            //请求成功的时候调用该方法
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                //请求成功后 获得请求出来的字符串
                final String result = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //将其结果字符串作为泛型 回调给主线程进行处理
                        callBack.onSuccess(result);
                    }
                });
            }
        });
    }
}
