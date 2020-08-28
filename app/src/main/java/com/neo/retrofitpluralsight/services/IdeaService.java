package com.neo.retrofitpluralsight.services;


import com.neo.retrofitpluralsight.models.Idea;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * maps all operations to the web service for the idea objects
 */
public interface IdeaService {

    //    @Headers("x-device-type: Android")
    @GET("ideas")
    Call<List<Idea>> getIdeas();
//    Call<List<Idea>> getIdeas(@Header("Accept-Language") String language);
//    Call<List<Idea>> getIdeas(@QueryMap HashMap<String, String> filters);


    @GET("ideas/{id}")
        // {id} is a place holder
    Call<Idea> getIdea(@Path("id") int id);             // gets a single idea obj

    @POST("ideas")
    Call<Idea> createIdea(@Body Idea newIdea);          // serialize the newIdea as json and submit to server

    @FormUrlEncoded
    @PUT("ideas/{id}")
    Call<Idea> updateIdea(
            @Path("id") int id,
            @Field("name") String name,
            @Field("description") String description,
            @Field("status") String status,
            @Field("owner") String owner
    );

    @DELETE("ideas/{id}")
    Call<Void> deleteIdea(@Path("id") int id);
}
