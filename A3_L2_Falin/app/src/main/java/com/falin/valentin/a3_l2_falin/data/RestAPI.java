package com.falin.valentin.a3_l2_falin.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestAPI {
    @GET("users")
    Call<List<UserPojo>> loadUsers();
}
