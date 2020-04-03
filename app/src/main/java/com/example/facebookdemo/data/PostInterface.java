package com.example.facebookdemo.data;

import com.example.facebookdemo.pojo.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    public Call<List<PostsModel>> getPosts();
}
