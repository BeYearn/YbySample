package com.beyearn.sample.bean;

import java.util.List;

/**
 * Created by beyearn on 2017/7/20.
 */

public class SystemInfo {


    /**
     * appVersionInfo : null
     * maintainInfo : null
     * menuBarInfo : {"details":[{"icon":"ema_floating_account","id":1,"name":"账户","type":1,"url":"https://testing-platform.lemonade-game.com:8443/wap/userinfo.html"},{"icon":"ema_floating_account","id":2,"name":"账户","type":2,"url":"https://testing-platform.lemonade-game.com:8443/wap/iosuserinfo.html"},{"icon":"ema_floating_promotion","id":3,"name":"推广","type":0,"url":"https://testing-platform.lemonade-game.com:8443/wap/spread_V2/htm/bespread.html"},{"icon":"ema_floating_charge","id":4,"name":"充值","type":1,"url":"https://testing-platform.lemonade-game.com:8443/wap/charge.html"}],"hide_channel_id":"70|20070|888|999","identify_lv":0,"ios_max_version":"2.13","login_type":2,"needSecondCheck":1,"show_float":1,"support_qq_login":1,"support_qq_pay":1,"support_weibo_login":0,"support_weixin_login":1,"support_weixin_pay":1,"tmp_login_version":"1.216","useOldIAP":0}
     */

    private Object appVersionInfo;
    private Object maintainInfo;
    private MenuBarInfo menuBarInfo;

    public Object getAppVersionInfo() {
        return appVersionInfo;
    }

    public void setAppVersionInfo(Object appVersionInfo) {
        this.appVersionInfo = appVersionInfo;
    }

    public Object getMaintainInfo() {
        return maintainInfo;
    }

    public void setMaintainInfo(Object maintainInfo) {
        this.maintainInfo = maintainInfo;
    }

    public MenuBarInfo getMenuBarInfo() {
        return menuBarInfo;
    }

    public void setMenuBarInfo(MenuBarInfo menuBarInfo) {
        this.menuBarInfo = menuBarInfo;
    }

    @Override
    public String toString() {
        return "SystemInfo{" +
                "appVersionInfo=" + appVersionInfo +
                ", maintainInfo=" + maintainInfo +
                ", menuBarInfo=" + menuBarInfo +
                '}';
    }

    public static class MenuBarInfo {
        /**
         * details : [{"icon":"ema_floating_account","id":1,"name":"账户","type":1,"url":"https://testing-platform.lemonade-game.com:8443/wap/userinfo.html"},{"icon":"ema_floating_account","id":2,"name":"账户","type":2,"url":"https://testing-platform.lemonade-game.com:8443/wap/iosuserinfo.html"},{"icon":"ema_floating_promotion","id":3,"name":"推广","type":0,"url":"https://testing-platform.lemonade-game.com:8443/wap/spread_V2/htm/bespread.html"},{"icon":"ema_floating_charge","id":4,"name":"充值","type":1,"url":"https://testing-platform.lemonade-game.com:8443/wap/charge.html"}]
         * hide_channel_id : 70|20070|888|999
         * identify_lv : 0
         * ios_max_version : 2.13
         * login_type : 2
         * needSecondCheck : 1
         * show_float : 1
         * support_qq_login : 1
         * support_qq_pay : 1
         * support_weibo_login : 0
         * support_weixin_login : 1
         * support_weixin_pay : 1
         * tmp_login_version : 1.216
         * useOldIAP : 0
         */

        private String hide_channel_id;
        private int identify_lv;
        private String ios_max_version;
        private int login_type;
        private int needSecondCheck;
        private int show_float;
        private int support_qq_login;
        private int support_qq_pay;
        private int support_weibo_login;
        private int support_weixin_login;
        private int support_weixin_pay;
        private String tmp_login_version;
        private int useOldIAP;
        private List<Details> details;

        public String getHide_channel_id() {
            return hide_channel_id;
        }

        public void setHide_channel_id(String hide_channel_id) {
            this.hide_channel_id = hide_channel_id;
        }

        public int getIdentify_lv() {
            return identify_lv;
        }

        public void setIdentify_lv(int identify_lv) {
            this.identify_lv = identify_lv;
        }

        public String getIos_max_version() {
            return ios_max_version;
        }

        public void setIos_max_version(String ios_max_version) {
            this.ios_max_version = ios_max_version;
        }

        public int getLogin_type() {
            return login_type;
        }

        public void setLogin_type(int login_type) {
            this.login_type = login_type;
        }

        public int getNeedSecondCheck() {
            return needSecondCheck;
        }

        public void setNeedSecondCheck(int needSecondCheck) {
            this.needSecondCheck = needSecondCheck;
        }

        public int getShow_float() {
            return show_float;
        }

        public void setShow_float(int show_float) {
            this.show_float = show_float;
        }

        public int getSupport_qq_login() {
            return support_qq_login;
        }

        public void setSupport_qq_login(int support_qq_login) {
            this.support_qq_login = support_qq_login;
        }

        public int getSupport_qq_pay() {
            return support_qq_pay;
        }

        public void setSupport_qq_pay(int support_qq_pay) {
            this.support_qq_pay = support_qq_pay;
        }

        public int getSupport_weibo_login() {
            return support_weibo_login;
        }

        public void setSupport_weibo_login(int support_weibo_login) {
            this.support_weibo_login = support_weibo_login;
        }

        public int getSupport_weixin_login() {
            return support_weixin_login;
        }

        public void setSupport_weixin_login(int support_weixin_login) {
            this.support_weixin_login = support_weixin_login;
        }

        public int getSupport_weixin_pay() {
            return support_weixin_pay;
        }

        public void setSupport_weixin_pay(int support_weixin_pay) {
            this.support_weixin_pay = support_weixin_pay;
        }

        public String getTmp_login_version() {
            return tmp_login_version;
        }

        public void setTmp_login_version(String tmp_login_version) {
            this.tmp_login_version = tmp_login_version;
        }

        public int getUseOldIAP() {
            return useOldIAP;
        }

        public void setUseOldIAP(int useOldIAP) {
            this.useOldIAP = useOldIAP;
        }

        public List<Details> getDetails() {
            return details;
        }

        public void setDetails(List<Details> details) {
            this.details = details;
        }

        public static class Details {
            /**
             * icon : ema_floating_account
             * id : 1
             * name : 账户
             * type : 1
             * url : https://testing-platform.lemonade-game.com:8443/wap/userinfo.html
             */

            private String icon;
            private int id;
            private String name;
            private int type;
            private String url;

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
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

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
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
