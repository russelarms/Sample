package com.russelarms.sample.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Ruslan on 09.01.2016
 */
public class Image implements Serializable {

    @SerializedName("id")
    public int serverId;

    @SerializedName("url")
    public String url;

}
