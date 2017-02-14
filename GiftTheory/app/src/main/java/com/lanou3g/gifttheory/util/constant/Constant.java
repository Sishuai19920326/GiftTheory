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
    //频道列表的接口
    public static final String CHANNELS_TITLES = BASE_URL + "channels/preset?gender=2&generation=1";
    //频道具体模块内容接口    110为id
    public static final String HOMELO = "http://api.liwushuo.com/v2/channels/";
    public static final String HOMEVE = "/items_v2?gender=2&generation=1&limit=20&offset=0";

    //  轮播图接口
    public static final String BANNER = BASE_URL + "banners?channel=IOS";
    //  精选页图片模块接口
    public static final String MODULE = BASE_URL + "secondary_banners?gender=2&generation=1";

}
