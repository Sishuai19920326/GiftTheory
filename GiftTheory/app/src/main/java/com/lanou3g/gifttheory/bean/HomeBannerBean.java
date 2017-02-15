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
 * Created by 司帅 on 17/2/13.
 */

public class HomeBannerBean {

    /**
     * code : 200
     * data : {"banners":[{"ad_monitors":[],"channel":"all","id":900,"image_url":"http://img01.liwushuo.com/image/170210/s1ve680sw.jpg-w720","order":700,"status":0,"target_id":1047432,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=post&post_id=1047432","type":"post","webp_url":"http://img01.liwushuo.com/image/170210/s1ve680sw.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":899,"image_url":"http://img01.liwushuo.com/image/170210/7si71t2jp.jpg-w720","order":600,"status":0,"target_id":null,"target_type":"url","target_url":"liwushuo:///page?url=https%3A%2F%2Fevent.liwushuo.com%2Fadmin%2Fevent%2F80&page_action=navigation&login=false&type=url","type":"url","webp_url":"http://img01.liwushuo.com/image/170210/7si71t2jp.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":898,"image_url":"http://img02.liwushuo.com/image/170210/n17b07omz.jpg-w720","order":500,"status":0,"target_id":null,"target_url":"liwushuo:///page?type=shop_collection&id=41","type":"url","webp_url":"http://img02.liwushuo.com/image/170210/n17b07omz.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":892,"image_url":"http://img03.liwushuo.com/image/170208/r6qv9ib9y.jpg-w720","order":380,"status":0,"target_id":null,"target_type":"url","target_url":"liwushuo:///page?url=https%3A%2F%2Fevent.liwushuo.com%2Fadmin%2Fevent%2F78&page_action=navigation&login=false&type=url","type":"url","webp_url":"http://img03.liwushuo.com/image/170208/r6qv9ib9y.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":901,"image_url":"http://img01.liwushuo.com/image/170213/p4o1ouwmz.jpg-w720","order":0,"status":0,"target":{"banner_image_url":"http://img02.liwushuo.com/image/170213/8logaq9mk.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/170213/8logaq9mk.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/170213/38z71mq40.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/170213/38z71mq40.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1486956247,"id":433,"posts_count":5,"status":1,"subtitle":"不娘的姑娘该如何脱单","title":"桃花运","updated_at":1486956443},"target_id":433,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=topic&topic_id=433","type":"collection","webp_url":"http://img01.liwushuo.com/image/170213/p4o1ouwmz.jpg?imageView2/2/w/720/q/85/format/webp"}]}
     * message : OK
     */

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
        private List<BannersBean> banners;

        public List<BannersBean> getBanners() {
            return banners;
        }

        public void setBanners(List<BannersBean> banners) {
            this.banners = banners;
        }

        public static class BannersBean {
            /**
             * ad_monitors : []
             * channel : all
             * id : 900
             * image_url : http://img01.liwushuo.com/image/170210/s1ve680sw.jpg-w720
             * order : 700
             * status : 0
             * target_id : 1047432
             * target_type : url
             * target_url : liwushuo:///page?page_action=navigation&login=false&type=post&post_id=1047432
             * type : post
             * webp_url : http://img01.liwushuo.com/image/170210/s1ve680sw.jpg?imageView2/2/w/720/q/85/format/webp
             * target : {"banner_image_url":"http://img02.liwushuo.com/image/170213/8logaq9mk.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/170213/8logaq9mk.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/170213/38z71mq40.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/170213/38z71mq40.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1486956247,"id":433,"posts_count":5,"status":1,"subtitle":"不娘的姑娘该如何脱单","title":"桃花运","updated_at":1486956443}
             */

            private String channel;
            private int id;
            private String image_url;
            private int order;
            private int status;
            private int target_id;
            private String target_type;
            private String target_url;
            private String type;
            private String webp_url;
            private TargetBean target;
            private List<?> ad_monitors;

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
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

            public int getTarget_id() {
                return target_id;
            }

            public void setTarget_id(int target_id) {
                this.target_id = target_id;
            }

            public String getTarget_type() {
                return target_type;
            }

            public void setTarget_type(String target_type) {
                this.target_type = target_type;
            }

            public String getTarget_url() {
                return target_url;
            }

            public void setTarget_url(String target_url) {
                this.target_url = target_url;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getWebp_url() {
                return webp_url;
            }

            public void setWebp_url(String webp_url) {
                this.webp_url = webp_url;
            }

            public TargetBean getTarget() {
                return target;
            }

            public void setTarget(TargetBean target) {
                this.target = target;
            }

            public List<?> getAd_monitors() {
                return ad_monitors;
            }

            public void setAd_monitors(List<?> ad_monitors) {
                this.ad_monitors = ad_monitors;
            }

            public static class TargetBean {
                /**
                 * banner_image_url : http://img02.liwushuo.com/image/170213/8logaq9mk.jpg-w300
                 * banner_webp_url : http://img02.liwushuo.com/image/170213/8logaq9mk.jpg?imageView2/2/w/300/q/85/format/webp
                 * cover_image_url : http://img03.liwushuo.com/image/170213/38z71mq40.jpg-w720
                 * cover_webp_url : http://img03.liwushuo.com/image/170213/38z71mq40.jpg?imageView2/2/w/720/q/85/format/webp
                 * created_at : 1486956247
                 * id : 433
                 * posts_count : 5
                 * status : 1
                 * subtitle : 不娘的姑娘该如何脱单
                 * title : 桃花运
                 * updated_at : 1486956443
                 */

                private String banner_image_url;
                private String banner_webp_url;
                private String cover_image_url;
                private String cover_webp_url;
                private int created_at;
                private int id;
                private int posts_count;
                private int status;
                private String subtitle;
                private String title;
                private int updated_at;

                public String getBanner_image_url() {
                    return banner_image_url;
                }

                public void setBanner_image_url(String banner_image_url) {
                    this.banner_image_url = banner_image_url;
                }

                public String getBanner_webp_url() {
                    return banner_webp_url;
                }

                public void setBanner_webp_url(String banner_webp_url) {
                    this.banner_webp_url = banner_webp_url;
                }

                public String getCover_image_url() {
                    return cover_image_url;
                }

                public void setCover_image_url(String cover_image_url) {
                    this.cover_image_url = cover_image_url;
                }

                public String getCover_webp_url() {
                    return cover_webp_url;
                }

                public void setCover_webp_url(String cover_webp_url) {
                    this.cover_webp_url = cover_webp_url;
                }

                public int getCreated_at() {
                    return created_at;
                }

                public void setCreated_at(int created_at) {
                    this.created_at = created_at;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getPosts_count() {
                    return posts_count;
                }

                public void setPosts_count(int posts_count) {
                    this.posts_count = posts_count;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getSubtitle() {
                    return subtitle;
                }

                public void setSubtitle(String subtitle) {
                    this.subtitle = subtitle;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getUpdated_at() {
                    return updated_at;
                }

                public void setUpdated_at(int updated_at) {
                    this.updated_at = updated_at;
                }
            }
        }
    }
}
