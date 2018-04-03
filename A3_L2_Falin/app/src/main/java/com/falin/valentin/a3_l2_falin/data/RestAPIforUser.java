package com.falin.valentin.a3_l2_falin.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestAPIforUser {
    @GET("users/{user}")
    Call<UserPojo> loadUserData(@Path("user") String user);
}
