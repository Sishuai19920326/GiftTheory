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
 * Created by 司帅 on 17/2/17.
 */

public class SingleBean {




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
        private List<CategoriesBean> categories;

        public List<CategoriesBean> getCategories() {
            return categories;
        }

        public void setCategories(List<CategoriesBean> categories) {
            this.categories = categories;
        }

        public static class CategoriesBean {


            private String icon_url;
            private int id;
            private String name;
            private int order;
            private int status;
            private List<SubcategoriesBean> subcategories;

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

            public List<SubcategoriesBean> getSubcategories() {
                return subcategories;
            }

            public void setSubcategories(List<SubcategoriesBean> subcategories) {
                this.subcategories = subcategories;
            }

            public static class SubcategoriesBean implements Parcelable{
                /**
                 * icon_url : http://img02.liwushuo.com/image/150615/urgs9vy8a.png-pw144
                 * id : 7
                 * items_count : 23
                 * name : 智能设备
                 * order : 7
                 * parent_id : 1
                 * status : 0
                 */

                private String icon_url;
                private int id;
                private int items_count;
                private String name;
                private int order;
                private int parent_id;
                private int status;

                protected SubcategoriesBean(Parcel in) {
                    icon_url = in.readString();
                    id = in.readInt();
                    items_count = in.readInt();
                    name = in.readString();
                    order = in.readInt();
                    parent_id = in.readInt();
                    status = in.readInt();
                }

                public static final Creator<SubcategoriesBean> CREATOR = new Creator<SubcategoriesBean>() {
                    @Override
                    public SubcategoriesBean createFromParcel(Parcel in) {
                        return new SubcategoriesBean(in);
                    }

                    @Override
                    public SubcategoriesBean[] newArray(int size) {
                        return new SubcategoriesBean[size];
                    }
                };

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

                public int getParent_id() {
                    return parent_id;
                }

                public void setParent_id(int parent_id) {
                    this.parent_id = parent_id;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(icon_url);
                    dest.writeInt(id);
                    dest.writeInt(items_count);
                    dest.writeString(name);
                    dest.writeInt(order);
                    dest.writeInt(parent_id);
                    dest.writeInt(status);
                }
            }
        }
    }
}
