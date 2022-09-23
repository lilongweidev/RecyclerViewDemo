package com.llw.recyclerviewdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.llw.recyclerviewdemo.bean.BasicBean;
import com.llw.recyclerviewdemo.databinding.ItemTextDataRvBinding;
import com.llw.recyclerviewdemo.listener.OnItemClickListener;
import com.llw.recyclerviewdemo.listener.OnItemLongClickListener;

import java.util.List;

public class StringDataBindingAdapter extends RecyclerView.Adapter<StringDataBindingAdapter.ViewHolder> {

    private final List<BasicBean> lists;

    private OnItemClickListener listener;//视图点击

    private OnItemLongClickListener longClickListener;//视图长按

    public void setOnItemLongClickListener(OnItemLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public StringDataBindingAdapter(List<BasicBean> lists) {
        this.lists = lists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTextDataRvBinding binding = ItemTextDataRvBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        ViewHolder viewHolder = new ViewHolder(binding);
        handlerEvents(binding.getRoot(), viewHolder);
        return viewHolder;
    }

    /**
     * 处理事件
     */
    private void handlerEvents(View view, ViewHolder viewHolder) {
        //添加视图点击事件
        view.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(v, viewHolder.getAdapterPosition());
            }
        });

        //添加视图长按事件
        view.setOnLongClickListener(v -> {
            if (longClickListener != null) {
                return longClickListener.onItemLongClick(v, viewHolder.getAdapterPosition());
            }
            return false;
        });
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
