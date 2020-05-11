package com.example.feame3.login.bean;

public class AffirmRegisterBean {

    @Override
    public String toString() {
        return "AffirmRegisterBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * code : 1
     * message : 登录成功
     * data : {"token":{"value":"b1ac55a0ef4ef27fb5056934548899ea","expire_time":1590369199},"user_info":{"head_url":"https://www.seetao.com/Public/static/default_head.jpeg","nickname":"大胆的手机","mobile":"17611739206","email":"","qq_bind":0,"qq_openid":"","qq_unionid":"","sina_bind":0,"sina_openid":"","sina_unionid":"","wechat_bind":0,"wechat_openid":"","wechat_unionid":"","notice_count":"1","my_integral":"100","check_in_status":0}}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "token=" + token +
                    ", user_info=" + user_info +
                    '}';
        }

        /**
         * token : {"value":"b1ac55a0ef4ef27fb5056934548899ea","expire_time":1590369199}
         * user_info : {"head_url":"https://www.seetao.com/Public/static/default_head.jpeg","nickname":"大胆的手机","mobile":"17611739206","email":"","qq_bind":0,"qq_openid":"","qq_unionid":"","sina_bind":0,"sina_openid":"","sina_unionid":"","wechat_bind":0,"wechat_openid":"","wechat_unionid":"","notice_count":"1","my_integral":"100","check_in_status":0}
         */

        private TokenBean token;
        private UserInfoBean user_info;

        public TokenBean getToken() {
            return token;
        }

        public void setToken(TokenBean token) {
            this.token = token;
        }

        public UserInfoBean getUser_info() {
            return user_info;
        }

        public void setUser_info(UserInfoBean user_info) {
            this.user_info = user_info;
        }

        public static class TokenBean {
            @Override
            public String toString() {
                return "TokenBean{" +
                        "value='" + value + '\'' +
                        ", expire_time=" + expire_time +
                        '}';
            }

            /**
             * value : b1ac55a0ef4ef27fb5056934548899ea
             * expire_time : 1590369199
             */


            private String value;
            private String expire_time;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getExpire_time() {
                return expire_time;
            }

            public void setExpire_time(String expire_time) {
                this.expire_time = expire_time;
            }
        }

        public static class UserInfoBean {
            @Override
            public String toString() {
                return "UserInfoBean{" +
                        "head_url='" + head_url + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", mobile='" + mobile + '\'' +
                        ", email='" + email + '\'' +
                        ", qq_bind=" + qq_bind +
                        ", qq_openid='" + qq_openid + '\'' +
                        ", qq_unionid='" + qq_unionid + '\'' +
                        ", sina_bind=" + sina_bind +
                        ", sina_openid='" + sina_openid + '\'' +
                        ", sina_unionid='" + sina_unionid + '\'' +
                        ", wechat_bind=" + wechat_bind +
                        ", wechat_openid='" + wechat_openid + '\'' +
                        ", wechat_unionid='" + wechat_unionid + '\'' +
                        ", notice_count='" + notice_count + '\'' +
                        ", my_integral='" + my_integral + '\'' +
                        ", check_in_status=" + check_in_status +
                        '}';
            }

            /**
             * head_url : https://www.seetao.com/Public/static/default_head.jpeg
             * nickname : 大胆的手机
             * mobile : 17611739206
             * email :
             * qq_bind : 0
             * qq_openid :
             * qq_unionid :
             * sina_bind : 0
             * sina_openid :
             * sina_unionid :
             * wechat_bind : 0
             * wechat_openid :
             * wechat_unionid :
             * notice_count : 1
             * my_integral : 100
             * check_in_status : 0
             */

            private String head_url;
            private String nickname;
            private String mobile;
            private String email;
            private int qq_bind;
            private String qq_openid;
            private String qq_unionid;
            private int sina_bind;
            private String sina_openid;
            private String sina_unionid;
            private int wechat_bind;
            private String wechat_openid;
            private String wechat_unionid;
            private String notice_count;
            private String my_integral;
            private int check_in_status;

            public String getHead_url() {
                return head_url;
            }

            public void setHead_url(String head_url) {
                this.head_url = head_url;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public int getQq_bind() {
                return qq_bind;
            }

            public void setQq_bind(int qq_bind) {
                this.qq_bind = qq_bind;
            }

            public String getQq_openid() {
                return qq_openid;
            }

            public void setQq_openid(String qq_openid) {
                this.qq_openid = qq_openid;
            }

            public String getQq_unionid() {
                return qq_unionid;
            }

            public void setQq_unionid(String qq_unionid) {
                this.qq_unionid = qq_unionid;
            }

            public int getSina_bind() {
                return sina_bind;
            }

            public void setSina_bind(int sina_bind) {
                this.sina_bind = sina_bind;
            }

            public String getSina_openid() {
                return sina_openid;
            }

            public void setSina_openid(String sina_openid) {
                this.sina_openid = sina_openid;
            }

            public String getSina_unionid() {
                return sina_unionid;
            }

            public void setSina_unionid(String sina_unionid) {
                this.sina_unionid = sina_unionid;
            }

            public int getWechat_bind() {
                return wechat_bind;
            }

            public void setWechat_bind(int wechat_bind) {
                this.wechat_bind = wechat_bind;
            }

            public String getWechat_openid() {
                return wechat_openid;
            }

            public void setWechat_openid(String wechat_openid) {
                this.wechat_openid = wechat_openid;
            }

            public String getWechat_unionid() {
                return wechat_unionid;
            }

            public void setWechat_unionid(String wechat_unionid) {
                this.wechat_unionid = wechat_unionid;
            }

            public String getNotice_count() {
                return notice_count;
            }

            public void setNotice_count(String notice_count) {
                this.notice_count = notice_count;
            }

            public String getMy_integral() {
                return my_integral;
            }

            public void setMy_integral(String my_integral) {
                this.my_integral = my_integral;
            }

            public int getCheck_in_status() {
                return check_in_status;
            }

            public void setCheck_in_status(int check_in_status) {
                this.check_in_status = check_in_status;
            }
        }
    }
}
