package com.hong.pet.api;

import com.hong.pet.base.BaseRespon;
import com.hong.pet.model.Request.QueryUser;
import com.hong.pet.model.User;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIServer {
    @POST("/api/userlogin")
    Observable<BaseRespon<User>> login(@Body QueryUser queryUser);
}
