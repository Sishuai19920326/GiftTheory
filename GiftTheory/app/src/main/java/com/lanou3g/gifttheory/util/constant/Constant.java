package com.lanou3g.gifttheory.util.constant;
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

public class Constant {
    //接口网址的公共部分
    public static final String BASE_URL = "http://api.liwushuo.com/v2/";

    //首页
    //频道列表的接口
    public static final String CHANNELS_TITLES = BASE_URL + "channels/preset?gender=2&generation=1";
    //频道具体模块内容接口    110为id
    public static final String HOMELO = "http://api.liwushuo.com/v2/channels/";
    public static final String HOMEVE = "/items_v2?gender=2&generation=1&limit=20&offset=0";

    //  精选页轮播图接口
    public static final String BANNER = BASE_URL + "banners?channel=IOS";
    //  精选页图片模块接口
    public static final String MODULE = BASE_URL + "secondary_banners?gender=2&generation=1";

    //榜单页
    //榜单页title接口
    public static final String LIST_TITLE = BASE_URL + "ranks_v2/ranks?";

    //榜单页拼接接口 中间接title对应里面的id
    public static final String LIST = BASE_URL + "ranks_v3/ranks/";
    public static final String LIST_OTHER = "?limit=20&offset=";

    //  商店页接口
    public static final String MallUP = "http://api.liwushuo.com/v2/shopitem_collections";
    public static final String Malldown = "http://api.liwushuo.com/v2/shop/items?limit=20&offset=0";

    // 分类页
    // 攻略接口
    public static final String STRATEGY_UP_TITLE = BASE_URL + "columns?limit=20&offset=0";
    public static final String STRATEGY = BASE_URL + "channel_groups/all?";
    //单品页接口
    public static final String SINGLE = "http://api.liwushuo.com/v2/item_categories/tree";

    //二级页面
    //热门搜索
    public static final String SEARCH = "http://api.liwushuo.com/v2/search/hot_words";

}
