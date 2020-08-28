package com.neo.retrofitpluralsight.services;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * recievs news text from our landing page
 */
public interface MessageService {

//    @GET("messages")                        // "messages" is the endpoint
//    Call<String> getMessage();

    @GET
    Call<String> getMessage(@Url String altUrl);                        // overrides the base url in our service builder
}
