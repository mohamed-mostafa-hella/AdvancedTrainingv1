package com.example.facebookdemo.ui.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebookdemo.R;
import com.example.facebookdemo.databinding.PostItemBinding;
import com.example.facebookdemo.pojo.PostsModel;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    List<PostsModel> dataList = new ArrayList<>();


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        PostItemBinding binding = DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext())
                        ,R.layout.post_item, parent, false
                );
        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostsModel item = dataList.get(position);
        holder.bind.setModel(item);
    }

    public void setDataList(List<PostsModel> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        PostItemBinding bind;
        public PostViewHolder(@NonNull PostItemBinding bind) {
            super(bind.getRoot());
            this.bind=bind;

        }
    }
}
