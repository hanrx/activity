package com.iafoot.activity.entity;

/**
 * @Copyright: iAfoot.
 * @Description:
 * @author: RX.HAN
 * @since: 2020/11/11 11:07 AM
 */
public class User {

    private String userName;

    private String password;

    private String groupId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
