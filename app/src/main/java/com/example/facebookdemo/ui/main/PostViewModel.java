package com.example.facebookdemo.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.facebookdemo.data.PostsClient;
import com.example.facebookdemo.pojo.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    private MutableLiveData<List<PostsModel>> postModelLiveData;

    public MutableLiveData<List<PostsModel>> getPostsOut(){
        if(postModelLiveData == null)
        {
            postModelLiveData = new MutableLiveData<>();
            getPosts();
        }
        return postModelLiveData;
    }

    private void getPosts(){
        PostsClient.getInstance().getPosts().enqueue(new Callback<List<PostsModel>>() {
            @Override
            public void onResponse(Call<List<PostsModel>> call, Response<List<PostsModel>> response) {
                postModelLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostsModel>> call, Throwable t) {
                Log.e("ERROR" , "can not get data");
            }
        });
    }
}
