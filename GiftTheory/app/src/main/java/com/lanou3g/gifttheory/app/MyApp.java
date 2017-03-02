package com.lanou3g.gifttheory.app;
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

import android.app.Application;
import android.content.Context;

import com.lanou3g.gifttheory.util.dbtool.DaoMaster;
import com.lanou3g.gifttheory.util.dbtool.DaoSession;

/**
 * Created by 司帅 on 17/2/21.
 */
//application应用层中 生命周期最长的一个类
public class MyApp extends Application {
    public static Context context;
    public static DaoMaster daoMaster;
    public static DaoSession daoSession;

    //app应用启动最先走的方法 初始化一个全局context对象
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
    public static DaoMaster getDaoMaster(){
        //文件名 游标工厂
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getContext(),"Collect.db",null);
        //获得可读写的master对象
        daoMaster = new DaoMaster(helper.getWritableDb());
        return daoMaster;
    }
    public static DaoSession getDaoSession(){
        if (daoSession == null){
            if (daoMaster == null){
                daoMaster = getDaoMaster();
            }
        }
        daoSession = getDaoMaster().newSession();
        return daoSession;
    }
}
