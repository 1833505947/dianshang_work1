package com.example.lihuanhuan20190102.entity;

import java.util.List;

public class UserBean {
    public int code;
    public String msg;
    public UserData data;
    public class UserData{
        /*public List<BannerData> banner;
        public List<FenleiData> fenlei;
        public MiaoshaData miaosha;*/
        public TuijianData tuijian;
        /*public class BannerData{
            public String aid;
            public String createtime;
            public String icon;
            public String title;
            public String type;
            public String url;
        }
        public class FenleiData{
            public String cid;
            public String createtime;
            public String icon;
            public String ishome;
            public String name;
        }
        public class MiaoshaData{
            public List<ListData> list;
            public String name;
            public String time;
            public class ListData{
                public String bargainPrice;
                public String createtime;
                public String detailUrl;
                public String images;
                public String itemtype;
                public String pid;
                public String price;
                public String pscid;
                public String salenum;
                public String sellerid;
                public String subhead;
                public String title;
            }
        }*/
        public class TuijianData{
            public List<ListTuijianData> list;
            public String name;

            public class ListTuijianData{
                public String bargainPrice;
                public String createtime;
                public String detailUrl;
                public String images;
                public String itemtype;
                public String pid;
                public String price;
                public String pscid;
                public String salenum;
                public String sellerid;
                public String subhead;
                public String title;
            }
        }
    }
}
