package com.lanou3g.gifttheory.util;/**
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

import com.lanou3g.gifttheory.util.nettool.CallBack;
import com.lanou3g.gifttheory.util.nettool.NetInterface;
import com.lanou3g.gifttheory.util.nettool.OkTool;

/**
 * Created by 司帅 on 17/2/11.
 */
//封装的网络工具类
    //单例模式
public class NetTool implements NetInterface{

    private static NetTool ourInstance;
    private NetInterface mNetInterface;
    public static NetTool getInstance() {
        //双重校验锁
        if (ourInstance == null){
            synchronized (NetTool.class){
                if (ourInstance == null){
                    ourInstance = new NetTool();
                }
            }
        }
        return ourInstance;
    }

    private NetTool() {
        mNetInterface = new OkTool();
    }

    @Override
    public <T> void startRequest(String url, Class<T> tClass, CallBack<T> callBack) {
        mNetInterface.startRequest(url,tClass,callBack);
    }

    @Override
    public void startRequest(String url, CallBack<String> callBack) {
        mNetInterface.startRequest(url,callBack);
    }
}
