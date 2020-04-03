package com.example.facebookdemo.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.facebookdemo.R;
import com.example.facebookdemo.databinding.ActivityMainBinding;
import com.example.facebookdemo.pojo.PostsModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PostViewModel postViewModel;
    private ActivityMainBinding binding;
    private PostsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new PostsAdapter();
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setAdapter(adapter);



        postViewModel.getPostsOut().observe(this, new Observer<List<PostsModel>>() {
            @Override
            public void onChanged(List<PostsModel> postsModels) {
                adapter.setDataList(postsModels);
            }
        });



    }
}
