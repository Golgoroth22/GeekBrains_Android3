package com.falin.valentin.a3_l2_falin.data.realm;

import io.realm.RealmObject;

public class UserRealmPojo extends RealmObject {
    private String login;
    private String userId;
    private String avatarUrl;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
