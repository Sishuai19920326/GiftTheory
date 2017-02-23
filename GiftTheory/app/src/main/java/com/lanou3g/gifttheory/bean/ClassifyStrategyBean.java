package com.lanou3g.gifttheory.bean;
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

import java.util.List;

/**
 * Created by 司帅 on 17/2/17.
 */

public class ClassifyStrategyBean {



    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        private List<ChannelGroupsBean> channel_groups;

        public List<ChannelGroupsBean> getChannel_groups() {
            return channel_groups;
        }

        public void setChannel_groups(List<ChannelGroupsBean> channel_groups) {
            this.channel_groups = channel_groups;
        }

        public static class ChannelGroupsBean {
            /**
             * channels : [{"cover_image_url":"http://img02.liwushuo.com/image/161108/a9lk7ujyu.png","group_id":5,"icon_url":"http://img03.liwushuo.com/image/160414/kwzqtscoa.png-pw144","id":111,"items_count":1206,"name":"礼物","order":10,"status":0,"url":""},{"cover_image_url":"http://img03.liwushuo.com/image/161108/2ztto37zo.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160401/58kdnthsn.png-pw144","id":112,"items_count":639,"name":"家居","order":9,"status":0,"url":""},{"cover_image_url":"http://img01.liwushuo.com/image/161108/mk735a2vf.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160414/6eutomjeo.png-pw144","id":110,"items_count":870,"name":"穿搭","order":8,"status":0,"url":""},{"cover_image_url":"http://img02.liwushuo.com/image/161108/mepx3mnc5.png","group_id":5,"icon_url":"http://img03.liwushuo.com/image/160414/abuv6vssc.png-pw144","id":2,"items_count":674,"name":"美物","order":7,"status":0,"url":""},{"cover_image_url":"http://img01.liwushuo.com/image/161108/fxjtol3fq.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160401/5al9xhwg1.png-pw144","id":116,"items_count":228,"name":"饰品","order":6,"status":0,"url":""},{"cover_image_url":"http://img03.liwushuo.com/image/161108/3d2et987l.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160401/5dgflkj6g.png-pw144","id":117,"items_count":256,"name":"鞋包","order":5,"status":0,"url":""},{"cover_image_url":"http://img02.liwushuo.com/image/161108/e4kh08dt7.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160401/58vv7n29y.png-pw144","id":118,"items_count":554,"name":"美食","order":5,"status":0,"url":""},{"cover_image_url":"http://img03.liwushuo.com/image/161108/tzmec6sqh.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/fb7e1012t.png-pw144","id":113,"items_count":621,"name":"美护","order":4,"status":0,"url":""},{"cover_image_url":"http://img02.liwushuo.com/image/161108/pqd3pqaun.png","group_id":5,"icon_url":"http://img03.liwushuo.com/image/160401/59hgqd1x8.png-pw144","id":121,"items_count":282,"name":"数码","order":4,"status":0,"url":""},{"cover_image_url":"http://img02.liwushuo.com/image/161108/qm793ot3w.png","group_id":5,"icon_url":"http://img01.liwushuo.com/image/160401/u4r2a9q72.png-pw144","id":3,"items_count":97,"name":"手工","order":3,"status":0,"url":""},{"cover_image_url":"http://img03.liwushuo.com/image/161108/cdi8xf9nb.png","group_id":5,"icon_url":"http://img03.liwushuo.com/image/160401/i69bjp6bm.png-pw144","id":119,"items_count":53,"name":"母婴","order":0,"status":0,"url":""},{"cover_image_url":"http://img03.liwushuo.com/image/161108/m4v85h6rg.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160401/t9t9hzntc.png-pw144","id":122,"items_count":82,"name":"爱动漫","order":0,"status":0,"url":""},{"cover_image_url":"http://img03.liwushuo.com/image/161108/x8b344f8h.png","group_id":5,"icon_url":"http://img02.liwushuo.com/image/160401/3ziqypz1f.png-pw144","id":123,"items_count":48,"name":"爱运动","order":0,"status":0,"url":""},{"cover_image_url":"http://img02.liwushuo.com/image/161108/ft4tihja1.png","group_id":5,"icon_url":"http://img03.liwushuo.com/image/160401/6pdxbaqz2.png-pw144","id":124,"items_count":64,"name":"爱读书","order":0,"status":0,"url":""},{"cover_image_url":"http://img03.liwushuo.com/image/161108/vz95ebvwy.png","group_id":5,"icon_url":"http://img03.liwushuo.com/image/160401/voku467wc.png-pw144","id":129,"items_count":174,"name":"海淘","order":0,"status":0,"url":""}]
             * id : 5
             * name : 品类
             * order : 6
             * status : 0
             */

            private int id;
            private String name;
            private int order;
            private int status;
            private List<ChannelsBean> channels;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public List<ChannelsBean> getChannels() {
                return channels;
            }

            public void setChannels(List<ChannelsBean> channels) {
                this.channels = channels;
            }

            public static class ChannelsBean {
                /**
                 * cover_image_url : http://img02.liwushuo.com/image/161108/a9lk7ujyu.png
                 * group_id : 5
                 * icon_url : http://img03.liwushuo.com/image/160414/kwzqtscoa.png-pw144
                 * id : 111
                 * items_count : 1206
                 * name : 礼物
                 * order : 10
                 * status : 0
                 * url :
                 */

                private String cover_image_url;
                private int group_id;
                private String icon_url;
                private int id;
                private int items_count;
                private String name;
                private int order;
                private int status;
                private String url;

                public String getCover_image_url() {
                    return cover_image_url;
                }

                public void setCover_image_url(String cover_image_url) {
                    this.cover_image_url = cover_image_url;
                }

                public int getGroup_id() {
                    return group_id;
                }

                public void setGroup_id(int group_id) {
                    this.group_id = group_id;
                }

                public String getIcon_url() {
                    return icon_url;
                }

                public void setIcon_url(String icon_url) {
                    this.icon_url = icon_url;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getItems_count() {
                    return items_count;
                }

                public void setItems_count(int items_count) {
                    this.items_count = items_count;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getOrder() {
                    return order;
                }

                public void setOrder(int order) {
                    this.order = order;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
