package com.hong.pet.model;

/**
 * 用户信息
 */
public class User {

    /**
     * userInfo : {"uid":1,"username":"admin","password":"admin","sex":1,"age":12,"tel":"113222221","address":"北京天安门"}
     */

    private UserInfoBean userInfo;

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "userInfo=" + userInfo +
                '}';
    }

    public static class UserInfoBean {
        /**
         * uid : 1
         * username : admin
         * password : admin
         * sex : 1
         * age : 12
         * tel : 113222221
         * address : 北京天安门
         */

        private int uid;
        private String username;
        private String password;
        private int sex;
        private int age;
        private String tel;
        private String address;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "UserInfoBean{" +
                    "uid=" + uid +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", sex=" + sex +
                    ", age=" + age +
                    ", tel='" + tel + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }
}
