package com.falin.valentin.a3_l2_falin.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserPojo {
    @SerializedName("id")
    @Expose
    String id;
    @SerializedName("login")
    @Expose
    String login;
    @SerializedName("avatar_url")
    @Expose
    String avatar_url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
