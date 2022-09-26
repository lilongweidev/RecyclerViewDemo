package com.llw.recyclerviewdemo.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.llw.recyclerviewdemo.bean.Message;
import com.llw.recyclerviewdemo.databinding.ItemMyselfRvBinding;
import com.llw.recyclerviewdemo.databinding.ItemOtherRvBinding;

import java.util.List;

/**
 * 消息适配器
 */
public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Message> messages;

    private static final int OTHER = 0;
    private static final int MYSELF = 1;

    public MessageAdapter(List<Message> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if (viewType == OTHER) {
            viewHolder = new OtherViewHolder(ItemOtherRvBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
        } else {
            viewHolder = new MyselfViewHolder(ItemMyselfRvBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OtherViewHolder) {
            ((OtherViewHolder) holder).otherBinding.tvContent.setText(messages.get(position).getContent());
        } else if (holder instanceof MyselfViewHolder) {
            ((MyselfViewHolder) holder).myselfBinding.tvContent.setText(messages.get(position).getContent());
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (messages.get(position).getType() == 0) {
            return OTHER;
        } else {
            return MYSELF;
        }
    }

    public static class OtherViewHolder extends RecyclerView.ViewHolder {

        public ItemOtherRvBinding otherBinding;

        public OtherViewHolder(@NonNull ItemOtherRvBinding itemOtherRvBinding) {
            super(itemOtherRvBinding.getRoot());
            otherBinding = itemOtherRvBinding;
        }

    }

    public static class MyselfViewHolder extends RecyclerView.ViewHolder {

        public ItemMyselfRvBinding myselfBinding;

        public MyselfViewHolder(@NonNull ItemMyselfRvBinding itemMyselfRvBinding) {
            super(itemMyselfRvBinding.getRoot());
            myselfBinding = itemMyselfRvBinding;
        }

    }
}
