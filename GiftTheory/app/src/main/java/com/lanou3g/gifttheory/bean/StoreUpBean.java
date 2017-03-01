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

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by 司帅 on 17/2/18.
 */

public class StoreUpBean {


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
        private List<ItemsBeanX> items;

        public List<ItemsBeanX> getItems() {
            return items;
        }

        public void setItems(List<ItemsBeanX> items) {
            this.items = items;
        }

        public static class ItemsBeanX implements Parcelable{


            private String cover_image;
            private String cover_image_url;
            private String cover_webp_url;
            private int created_at;
            private int editor_id;
            private Object head_image;
            private String head_link;
            private int id;
            private String introduction;
            private int order;
            private int published_at;
            private int status;
            private String title;
            private String type;
            private List<ItemsBean> items;

            protected ItemsBeanX(Parcel in) {
                cover_image = in.readString();
                cover_image_url = in.readString();
                cover_webp_url = in.readString();
                created_at = in.readInt();
                editor_id = in.readInt();
                head_link = in.readString();
                id = in.readInt();
                introduction = in.readString();
                order = in.readInt();
                published_at = in.readInt();
                status = in.readInt();
                title = in.readString();
                type = in.readString();
                items = in.createTypedArrayList(ItemsBean.CREATOR);
            }

            public static final Creator<ItemsBeanX> CREATOR = new Creator<ItemsBeanX>() {
                @Override
                public ItemsBeanX createFromParcel(Parcel in) {
                    return new ItemsBeanX(in);
                }

                @Override
                public ItemsBeanX[] newArray(int size) {
                    return new ItemsBeanX[size];
                }
            };

            public String getCover_image() {
                return cover_image;
            }

            public void setCover_image(String cover_image) {
                this.cover_image = cover_image;
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

            public int getEditor_id() {
                return editor_id;
            }

            public void setEditor_id(int editor_id) {
                this.editor_id = editor_id;
            }

            public Object getHead_image() {
                return head_image;
            }

            public void setHead_image(Object head_image) {
                this.head_image = head_image;
            }

            public String getHead_link() {
                return head_link;
            }

            public void setHead_link(String head_link) {
                this.head_link = head_link;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getPublished_at() {
                return published_at;
            }

            public void setPublished_at(int published_at) {
                this.published_at = published_at;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ItemsBean> getItems() {
                return items;
            }

            public void setItems(List<ItemsBean> items) {
                this.items = items;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(cover_image);
                dest.writeString(cover_image_url);
                dest.writeString(cover_webp_url);
                dest.writeInt(created_at);
                dest.writeInt(editor_id);
                dest.writeString(head_link);
                dest.writeInt(id);
                dest.writeString(introduction);
                dest.writeInt(order);
                dest.writeInt(published_at);
                dest.writeInt(status);
                dest.writeString(title);
                dest.writeString(type);
                dest.writeTypedList(items);
            }

            public static class ItemsBean implements Parcelable{

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
                private String postage;
                private int quota;
                private boolean recommendable;
                private int scarcity_threshold;
                private String short_description;
                private int show_stock;
                private int start_sold_at;
                private int status;
                private boolean support_generic_coupons;
                private int take_down_at;
                private String title;
                private int total_sold;
                private int updated_at;
                private List<String> image_urls;
                private List<SkusBean> skus;
                private List<SpecsDomainsBean> specs_domains;

                protected ItemsBean(Parcel in) {
                    activity_ended_at = in.readInt();
                    activity_started_at = in.readInt();
                    cover_image_key = in.readString();
                    cover_image_url = in.readString();
                    cover_webp_url = in.readString();
                    created_at = in.readInt();
                    description = in.readString();
                    detail_html = in.readString();
                    feature = in.readString();
                    hot_sale_threshold = in.readInt();
                    id = in.readString();
                    is_haitao = in.readInt();
                    is_puyin = in.readByte() != 0;
                    merchant_id = in.readInt();
                    merchant_type = in.readInt();
                    postage = in.readString();
                    quota = in.readInt();
                    recommendable = in.readByte() != 0;
                    scarcity_threshold = in.readInt();
                    short_description = in.readString();
                    show_stock = in.readInt();
                    start_sold_at = in.readInt();
                    status = in.readInt();
                    support_generic_coupons = in.readByte() != 0;
                    take_down_at = in.readInt();
                    title = in.readString();
                    total_sold = in.readInt();
                    updated_at = in.readInt();
                    image_urls = in.createStringArrayList();
                    skus = in.createTypedArrayList(SkusBean.CREATOR);
                    specs_domains = in.createTypedArrayList(SpecsDomainsBean.CREATOR);
                }

                public static final Creator<ItemsBean> CREATOR = new Creator<ItemsBean>() {
                    @Override
                    public ItemsBean createFromParcel(Parcel in) {
                        return new ItemsBean(in);
                    }

                    @Override
                    public ItemsBean[] newArray(int size) {
                        return new ItemsBean[size];
                    }
                };

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

                public boolean isRecommendable() {
                    return recommendable;
                }

                public void setRecommendable(boolean recommendable) {
                    this.recommendable = recommendable;
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

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(activity_ended_at);
                    dest.writeInt(activity_started_at);
                    dest.writeString(cover_image_key);
                    dest.writeString(cover_image_url);
                    dest.writeString(cover_webp_url);
                    dest.writeInt(created_at);
                    dest.writeString(description);
                    dest.writeString(detail_html);
                    dest.writeString(feature);
                    dest.writeInt(hot_sale_threshold);
                    dest.writeString(id);
                    dest.writeInt(is_haitao);
                    dest.writeByte((byte) (is_puyin ? 1 : 0));
                    dest.writeInt(merchant_id);
                    dest.writeInt(merchant_type);
                    dest.writeString(postage);
                    dest.writeInt(quota);
                    dest.writeByte((byte) (recommendable ? 1 : 0));
                    dest.writeInt(scarcity_threshold);
                    dest.writeString(short_description);
                    dest.writeInt(show_stock);
                    dest.writeInt(start_sold_at);
                    dest.writeInt(status);
                    dest.writeByte((byte) (support_generic_coupons ? 1 : 0));
                    dest.writeInt(take_down_at);
                    dest.writeString(title);
                    dest.writeInt(total_sold);
                    dest.writeInt(updated_at);
                    dest.writeStringList(image_urls);
                    dest.writeTypedList(skus);
                    dest.writeTypedList(specs_domains);
                }

                public static class SkusBean implements Parcelable{

                    private Object cover_image_url;
                    private String fixed_price;
                    private int id;
                    private int item_id;
                    private String price;
                    private int sold;
                    private int stock;
                    private String supply_price;
                    private List<SpecsBean> specs;

                    protected SkusBean(Parcel in) {
                        fixed_price = in.readString();
                        id = in.readInt();
                        item_id = in.readInt();
                        price = in.readString();
                        sold = in.readInt();
                        stock = in.readInt();
                        supply_price = in.readString();
                        specs = in.createTypedArrayList(SpecsBean.CREATOR);
                    }

                    public static final Creator<SkusBean> CREATOR = new Creator<SkusBean>() {
                        @Override
                        public SkusBean createFromParcel(Parcel in) {
                            return new SkusBean(in);
                        }

                        @Override
                        public SkusBean[] newArray(int size) {
                            return new SkusBean[size];
                        }
                    };

                    public Object getCover_image_url() {
                        return cover_image_url;
                    }

                    public void setCover_image_url(Object cover_image_url) {
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

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeString(fixed_price);
                        dest.writeInt(id);
                        dest.writeInt(item_id);
                        dest.writeString(price);
                        dest.writeInt(sold);
                        dest.writeInt(stock);
                        dest.writeString(supply_price);
                        dest.writeTypedList(specs);
                    }

                    public static class SpecsBean implements Parcelable{
                        /**
                         * property : 均码
                         * title : 规格
                         */

                        private String property;
                        private String title;

                        protected SpecsBean(Parcel in) {
                            property = in.readString();
                            title = in.readString();
                        }

                        public static final Creator<SpecsBean> CREATOR = new Creator<SpecsBean>() {
                            @Override
                            public SpecsBean createFromParcel(Parcel in) {
                                return new SpecsBean(in);
                            }

                            @Override
                            public SpecsBean[] newArray(int size) {
                                return new SpecsBean[size];
                            }
                        };

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

                        @Override
                        public int describeContents() {
                            return 0;
                        }

                        @Override
                        public void writeToParcel(Parcel dest, int flags) {
                            dest.writeString(property);
                            dest.writeString(title);
                        }
                    }
                }

                public static class SpecsDomainsBean implements Parcelable{
                    /**
                     * domains : ["均码"]
                     * title : 规格
                     */

                    private String title;
                    private List<String> domains;

                    protected SpecsDomainsBean(Parcel in) {
                        title = in.readString();
                        domains = in.createStringArrayList();
                    }

                    public static final Creator<SpecsDomainsBean> CREATOR = new Creator<SpecsDomainsBean>() {
                        @Override
                        public SpecsDomainsBean createFromParcel(Parcel in) {
                            return new SpecsDomainsBean(in);
                        }

                        @Override
                        public SpecsDomainsBean[] newArray(int size) {
                            return new SpecsDomainsBean[size];
                        }
                    };

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

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeString(title);
                        dest.writeStringList(domains);
                    }
                }
            }
        }
    }
}
