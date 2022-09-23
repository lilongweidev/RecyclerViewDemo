package com.llw.recyclerviewdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.llw.recyclerviewdemo.databinding.ItemBasicRvBinding;

import java.util.List;

public class BasicAdapter extends RecyclerView.Adapter<BasicAdapter.ViewHolder> {

    private List<String> lists;

    public BasicAdapter(List<String> lists) {
        this.lists = lists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemBasicRvBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvContent.setText(lists.get(position));
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ItemBasicRvBinding binding;

        public ViewHolder(@NonNull ItemBasicRvBinding itemBasicRvBinding) {
            super(itemBasicRvBinding.getRoot());
            binding = itemBasicRvBinding;
        }
    }
}
