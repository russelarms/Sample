package com.russelarms.sample.data.network;

import com.russelarms.sample.data.model.PxResponse;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Ruslan on 09.01.2016
 */
public interface PxAPI {

    @GET("/photos")
    PxResponse getPhotos(@Query("consumer_key") String key,
                         @Query("feature")      String feature,
                         @Query("page") Integer page,
                         @Query("image_size") Integer imageSize);

}
