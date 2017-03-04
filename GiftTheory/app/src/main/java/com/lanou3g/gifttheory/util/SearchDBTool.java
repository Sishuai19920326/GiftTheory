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
import com.lanou3g.gifttheory.util.dbtool.Search;
import com.lanou3g.gifttheory.util.dbtool.SearchDao;

import org.greenrobot.greendao.query.DeleteQuery;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by 司帅 on 17/3/4.
 */
public class SearchDBTool {
    private static SearchDBTool ourInstance;
    private SearchDao searchDao;

    public static SearchDBTool getInstance() {
        if (ourInstance == null){
            synchronized (SearchDBTool.class){
                if (ourInstance == null){
                    ourInstance = new SearchDBTool();
                }
            }
        }
        return ourInstance;
    }

    private SearchDBTool() {
        searchDao = MyApp.getDaoSession().getSearchDao();
    }
    //增加一条搜索
    public void insertSearch(Search search){
        searchDao.insert(search);
    }
    //增加多条搜索
    public void insertAllSearch(List<Search> searchList){
        searchDao.insertInTx(searchList);
    }
    //删除全部
    public void deleteAll(){
        searchDao.deleteAll();
    }
    //删除搜索
    public void deleteSearch(Search search){
        searchDao.delete(search);
    }
    //根据某条内容删除搜索
    public void deleteByContent(String content){
        //找到对应的content删除搜索
        DeleteQuery<Search> searchDeleteQuery = searchDao.queryBuilder().where(SearchDao.Properties.Content.eq(content)).buildDelete();
        searchDeleteQuery.executeDeleteWithoutDetachingEntities();
    }
    //查询所有
    public List<Search> queryAll(){
        List<Search> searchList = searchDao.loadAll();
        return searchList;
    }
    //查重方法
    public boolean isSave(Search search){
        QueryBuilder<Search> searchQueryBuilder = searchDao.queryBuilder().where(SearchDao.Properties.Content.eq(search.getContent()));
        Long count = searchQueryBuilder.buildCount().count();
        return count > 0;
    }
}
