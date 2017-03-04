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

import com.lanou3g.gifttheory.app.MyApp;
import com.lanou3g.gifttheory.util.dbtool.Collect;
import com.lanou3g.gifttheory.util.dbtool.CollectDao;

import org.greenrobot.greendao.query.DeleteQuery;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by 司帅 on 17/3/2.
 */
public class CollectDBTool {
    private static CollectDBTool ourInstance;
    private CollectDao collectDao;

    //双重校验锁
    public static CollectDBTool getInstance() {
        if (ourInstance == null){
            synchronized (CollectDBTool.class){
                if (ourInstance == null){
                    ourInstance = new CollectDBTool();
                }
            }
        }
        return ourInstance;
    }

    private CollectDBTool() {
        collectDao = MyApp.getDaoSession().getCollectDao();
    }
    //增加收藏
    public void insertCollect(Collect collect){
        collectDao.insert(collect);
    }
    //增加多个收藏
    public void insertAllCollect(List<Collect> collectList){
        collectDao.insertInTx(collectList);
    }
    //删除全部收藏
    public void deleteAll(Collect collect){
        collectDao.deleteAll();
    }
    //删除某条收藏(不能直接删除得通过属性删除)
    public void deleteCollect(Collect collect){
        collectDao.delete(collect);
    }
    //根据标题删除收藏
    public void deleteByName(String title){
        //找到对应的title删除收藏
        DeleteQuery<Collect> collectDeleteQuery = collectDao.queryBuilder().where(CollectDao.Properties.Title.eq(title)).buildDelete();
        collectDeleteQuery.executeDeleteWithoutDetachingEntities();
    }

    //查询所有
    public List<Collect> queryAll(){
        List<Collect> collectList = collectDao.loadAll();
        return collectList;
    }
    //查重方法
    public boolean isSave(Collect collect){
        //取出所有和collect 标题相同的集合
        QueryBuilder<Collect> collectQueryBuilder = collectDao.queryBuilder().where(CollectDao.Properties.Title.eq(collect.getTitle()));
        Long count = collectQueryBuilder.buildCount().count();
        return count > 0;
    }
}
