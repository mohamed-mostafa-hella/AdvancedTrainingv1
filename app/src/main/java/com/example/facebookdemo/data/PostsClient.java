package com.example.facebookdemo.data;

import com.example.facebookdemo.pojo.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private static final String BASE_URL= "https://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static PostsClient instance;

    private PostsClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }

    public static PostsClient getInstance() {
        if(instance == null){
            instance=new PostsClient();
        }
        return instance;
    }

    public Call<List<PostsModel>> getPosts(){
        return postInterface.getPosts();
    }

}
