package com.russelarms.sample.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ruslan on 09.01.2016.
 */
public class PxResponse {

    @SerializedName("current_page")
    public int currentPage;

    @SerializedName("total_pages")
    public int totalPages;

    @SerializedName("total_items")
    public int totalItems;

    public List<Photo> photos;

    @Override
    public String toString() {
        return "PhotosResponse{" +
                "currentPage=" + currentPage +
                ", totalPages=" + totalPages +
                ", totalItems=" + totalItems +
                ", photos=" + photos +
                '}';
    }

}
