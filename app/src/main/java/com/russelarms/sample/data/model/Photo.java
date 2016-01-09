package com.russelarms.sample.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Ruslan on 09.01.2016
 */
public class Photo {

    @SerializedName("liked")
    public boolean liked;

    @SerializedName("_id")
    public Long _id;

    @SerializedName("id")
    public int serverId;

    @SerializedName("name")
    public String name;

    @SerializedName("rating")
    public float rating;

    @SerializedName("images")
    public ArrayList<Image> images;

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + _id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
