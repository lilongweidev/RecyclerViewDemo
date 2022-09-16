package com.llw.recyclerviewdemo.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.llw.recyclerviewdemo.bean.BasicBean;
import com.llw.recyclerviewdemo.databinding.ItemTextDataRvBinding;
import com.llw.recyclerviewdemo.databinding.ItemTextRvBinding;

import java.util.List;

public class StringDataBindingAdapter extends RecyclerView.Adapter<StringDataBindingAdapter.ViewHolder> {

    private final List<BasicBean> lists;

    public StringDataBindingAdapter(List<BasicBean> lists) {
        this.lists = lists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTextDataRvBinding binding = ItemTextDataRvBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemTextDataRvBinding binding = DataBindingUtil.getBinding(holder.binding.getRoot());
        if (binding != null) {
            binding.setBasicBean(lists.get(position));
            binding.executePendingBindings();
        }
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ItemTextDataRvBinding binding;

        public ViewHolder(@NonNull ItemTextDataRvBinding itemTextDataRvBinding) {
            super(itemTextDataRvBinding.getRoot());
            binding = itemTextDataRvBinding;
        }
    }
}
