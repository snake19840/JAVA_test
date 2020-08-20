package com.sq.entity;

public class User {
    /**
     * hibernate 要求实体类有一个属性是唯一的
     */
    private String uid;
    private String username;
    private String password;
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
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
    @Override
    public String toString() {
        return "User [uid=" + uid + ", username=" + username + ", password="
                + password + "]";
    }
}
