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
 * Created by 司帅 on 17/2/15.
 */

public class ListItemBean {



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


        private String cover_image;
        private String cover_url;
        private String cover_webp;
        private PagingBean paging;
        private String share_url;
        private List<ItemsBean> items;

        public String getCover_image() {
            return cover_image;
        }

        public void setCover_image(String cover_image) {
            this.cover_image = cover_image;
        }

        public String getCover_url() {
            return cover_url;
        }

        public void setCover_url(String cover_url) {
            this.cover_url = cover_url;
        }

        public String getCover_webp() {
            return cover_webp;
        }

        public void setCover_webp(String cover_webp) {
            this.cover_webp = cover_webp;
        }

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class PagingBean {


            private String next_url;

            public String getNext_url() {
                return next_url;
            }

            public void setNext_url(String next_url) {
                this.next_url = next_url;
            }
        }

        public static class ItemsBean {


            private int activity_ended_at;
            private int activity_started_at;
            private String cover_image_key;
            private String cover_image_url;
            private String cover_webp_url;
            private int created_at;
            private String description;
            private String detail_html;
            private String feature;
            private int hot_sale_threshold;
            private String id;
            private Object in_merchant_order;
            private int is_haitao;
            private boolean is_puyin;
            private int merchant_id;
            private int merchant_type;
            private String name;
            private String postage;
            private int quota;
            private int scarcity_threshold;
            private String short_description;
            private int show_stock;
            private int start_sold_at;
            private int status;
            private boolean support_generic_coupons;
            private int take_down_at;
            private String target_type;
            private String target_url;
            private int total_sold;
            private int updated_at;
            private Object ad_monitors;
            private Object brand_id;
            private Object brand_order;
            private int category_id;
            private int editor_id;
            private int favorites_count;
            private String keywords;
            private String price;
            private String purchase_id;
            private String purchase_shop_id;
            private int purchase_status;
            private int purchase_type;
            private String purchase_url;
            private int subcategory_id;
            private String url;
            private List<String> image_urls;
            private List<SkusBean> skus;
            private List<SpecsDomainsBean> specs_domains;
            private List<?> post_ids;

            public int getActivity_ended_at() {
                return activity_ended_at;
            }

            public void setActivity_ended_at(int activity_ended_at) {
                this.activity_ended_at = activity_ended_at;
            }

            public int getActivity_started_at() {
                return activity_started_at;
            }

            public void setActivity_started_at(int activity_started_at) {
                this.activity_started_at = activity_started_at;
            }

            public String getCover_image_key() {
                return cover_image_key;
            }

            public void setCover_image_key(String cover_image_key) {
                this.cover_image_key = cover_image_key;
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

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getDetail_html() {
                return detail_html;
            }

            public void setDetail_html(String detail_html) {
                this.detail_html = detail_html;
            }

            public String getFeature() {
                return feature;
            }

            public void setFeature(String feature) {
                this.feature = feature;
            }

            public int getHot_sale_threshold() {
                return hot_sale_threshold;
            }

            public void setHot_sale_threshold(int hot_sale_threshold) {
                this.hot_sale_threshold = hot_sale_threshold;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Object getIn_merchant_order() {
                return in_merchant_order;
            }

            public void setIn_merchant_order(Object in_merchant_order) {
                this.in_merchant_order = in_merchant_order;
            }

            public int getIs_haitao() {
                return is_haitao;
            }

            public void setIs_haitao(int is_haitao) {
                this.is_haitao = is_haitao;
            }

            public boolean isIs_puyin() {
                return is_puyin;
            }

            public void setIs_puyin(boolean is_puyin) {
                this.is_puyin = is_puyin;
            }

            public int getMerchant_id() {
                return merchant_id;
            }

            public void setMerchant_id(int merchant_id) {
                this.merchant_id = merchant_id;
            }

            public int getMerchant_type() {
                return merchant_type;
            }

            public void setMerchant_type(int merchant_type) {
                this.merchant_type = merchant_type;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPostage() {
                return postage;
            }

            public void setPostage(String postage) {
                this.postage = postage;
            }

            public int getQuota() {
                return quota;
            }

            public void setQuota(int quota) {
                this.quota = quota;
            }

            public int getScarcity_threshold() {
                return scarcity_threshold;
            }

            public void setScarcity_threshold(int scarcity_threshold) {
                this.scarcity_threshold = scarcity_threshold;
            }

            public String getShort_description() {
                return short_description;
            }

            public void setShort_description(String short_description) {
                this.short_description = short_description;
            }

            public int getShow_stock() {
                return show_stock;
            }

            public void setShow_stock(int show_stock) {
                this.show_stock = show_stock;
            }

            public int getStart_sold_at() {
                return start_sold_at;
            }

            public void setStart_sold_at(int start_sold_at) {
                this.start_sold_at = start_sold_at;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public boolean isSupport_generic_coupons() {
                return support_generic_coupons;
            }

            public void setSupport_generic_coupons(boolean support_generic_coupons) {
                this.support_generic_coupons = support_generic_coupons;
            }

            public int getTake_down_at() {
                return take_down_at;
            }

            public void setTake_down_at(int take_down_at) {
                this.take_down_at = take_down_at;
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

            public int getTotal_sold() {
                return total_sold;
            }

            public void setTotal_sold(int total_sold) {
                this.total_sold = total_sold;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public Object getAd_monitors() {
                return ad_monitors;
            }

            public void setAd_monitors(Object ad_monitors) {
                this.ad_monitors = ad_monitors;
            }

            public Object getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(Object brand_id) {
                this.brand_id = brand_id;
            }

            public Object getBrand_order() {
                return brand_order;
            }

            public void setBrand_order(Object brand_order) {
                this.brand_order = brand_order;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public int getEditor_id() {
                return editor_id;
            }

            public void setEditor_id(int editor_id) {
                this.editor_id = editor_id;
            }

            public int getFavorites_count() {
                return favorites_count;
            }

            public void setFavorites_count(int favorites_count) {
                this.favorites_count = favorites_count;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getPurchase_id() {
                return purchase_id;
            }

            public void setPurchase_id(String purchase_id) {
                this.purchase_id = purchase_id;
            }

            public String getPurchase_shop_id() {
                return purchase_shop_id;
            }

            public void setPurchase_shop_id(String purchase_shop_id) {
                this.purchase_shop_id = purchase_shop_id;
            }

            public int getPurchase_status() {
                return purchase_status;
            }

            public void setPurchase_status(int purchase_status) {
                this.purchase_status = purchase_status;
            }

            public int getPurchase_type() {
                return purchase_type;
            }

            public void setPurchase_type(int purchase_type) {
                this.purchase_type = purchase_type;
            }

            public String getPurchase_url() {
                return purchase_url;
            }

            public void setPurchase_url(String purchase_url) {
                this.purchase_url = purchase_url;
            }

            public int getSubcategory_id() {
                return subcategory_id;
            }

            public void setSubcategory_id(int subcategory_id) {
                this.subcategory_id = subcategory_id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public List<String> getImage_urls() {
                return image_urls;
            }

            public void setImage_urls(List<String> image_urls) {
                this.image_urls = image_urls;
            }

            public List<SkusBean> getSkus() {
                return skus;
            }

            public void setSkus(List<SkusBean> skus) {
                this.skus = skus;
            }

            public List<SpecsDomainsBean> getSpecs_domains() {
                return specs_domains;
            }

            public void setSpecs_domains(List<SpecsDomainsBean> specs_domains) {
                this.specs_domains = specs_domains;
            }

            public List<?> getPost_ids() {
                return post_ids;
            }

            public void setPost_ids(List<?> post_ids) {
                this.post_ids = post_ids;
            }

            public static class SkusBean {
                /**
                 * cover_image_url : http://img02.liwushuo.com/image/170214/tcbnt4bd3_w.jpg-w720
                 * fixed_price : 209.00
                 * id : 2087
                 * item_id : 101457
                 * price : 209.00
                 * sold : 0
                 * specs : [{"property":"纯白","title":"颜色"}]
                 * stock : 100
                 * supply_price : 146.30
                 */

                private String cover_image_url;
                private String fixed_price;
                private int id;
                private int item_id;
                private String price;
                private int sold;
                private int stock;
                private String supply_price;
                private List<SpecsBean> specs;

                public String getCover_image_url() {
                    return cover_image_url;
                }

                public void setCover_image_url(String cover_image_url) {
                    this.cover_image_url = cover_image_url;
                }

                public String getFixed_price() {
                    return fixed_price;
                }

                public void setFixed_price(String fixed_price) {
                    this.fixed_price = fixed_price;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getItem_id() {
                    return item_id;
                }

                public void setItem_id(int item_id) {
                    this.item_id = item_id;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public int getSold() {
                    return sold;
                }

                public void setSold(int sold) {
                    this.sold = sold;
                }

                public int getStock() {
                    return stock;
                }

                public void setStock(int stock) {
                    this.stock = stock;
                }

                public String getSupply_price() {
                    return supply_price;
                }

                public void setSupply_price(String supply_price) {
                    this.supply_price = supply_price;
                }

                public List<SpecsBean> getSpecs() {
                    return specs;
                }

                public void setSpecs(List<SpecsBean> specs) {
                    this.specs = specs;
                }

                public static class SpecsBean {
                    /**
                     * property : 纯白
                     * title : 颜色
                     */

                    private String property;
                    private String title;

                    public String getProperty() {
                        return property;
                    }

                    public void setProperty(String property) {
                        this.property = property;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }
                }
            }

            public static class SpecsDomainsBean {
                /**
                 * domains : ["纯白","耀黄"]
                 * title : 颜色
                 */

                private String title;
                private List<String> domains;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public List<String> getDomains() {
                    return domains;
                }

                public void setDomains(List<String> domains) {
                    this.domains = domains;
                }
            }
        }
    }
}
