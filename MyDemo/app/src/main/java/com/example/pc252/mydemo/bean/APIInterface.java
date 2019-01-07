package com.example.pc252.mydemo.bean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by pc252 on 2019/1/4.
 */
//http://japi.juhe.cn/qqevaluate/qq?key=96efc220a4196fafdfade0c9d1e897ac&qq=295424589
public interface APIInterface {
    @GET("/qqevaluate/qq")
    Call<TestModel> repo(@Query("key") String apikey,@Query("qq") String qqString);

    @POST("/qqevaluate/qq")
    Call<TestModel> repoPost(@Query("key") String apikey, @Query("qq") String qqString);
}
