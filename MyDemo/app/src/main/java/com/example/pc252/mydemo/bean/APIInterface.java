package com.example.pc252.mydemo.bean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by pc252 on 2019/1/4.
 */
//http://japi.juhe.cn/qqevaluate/qq?key=96efc220a4196fafdfade0c9d1e897ac&qq=295424589
public interface APIInterface {
    @GET("/qqevaluate/qq")
    Call<TestModel> repo(@Query("key") String apikey,@Query("qq") String qqString);

    @POST("/qqevaluate/qq")
    Call<TestModel> repoPost(@Query("key") String apikey, @Query("qq") String qqString);

    @FormUrlEncoded
    @POST
    Call<TestModel> repoPostMap(@Url String baseurl, @FieldMap Map<String,String> map);
}
