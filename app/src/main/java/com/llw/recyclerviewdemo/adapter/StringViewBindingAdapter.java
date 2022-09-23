package com.llw.recyclerviewdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.llw.recyclerviewdemo.R;
import com.llw.recyclerviewdemo.databinding.ItemTextRvBinding;
import com.llw.recyclerviewdemo.listener.OnItemChildClickListener;
import com.llw.recyclerviewdemo.listener.OnItemChildLongClickListener;
import com.llw.recyclerviewdemo.listener.OnItemClickListener;
import com.llw.recyclerviewdemo.listener.OnItemLongClickListener;

import java.util.List;

/**
 * 使用ViewBinding
 */
public class StringViewBindingAdapter extends RecyclerView.Adapter<StringViewBindingAdapter.ViewHolder> {

    private final List<String> lists;

    private OnItemClickListener listener;//视图点击

    private OnItemChildClickListener childClickListener;//视图子控件点击

    private OnItemLongClickListener longClickListener;//视图长按

    private OnItemChildLongClickListener childLongClickListener;//视图子控件长按

    public void setOnItemLongClickListener(OnItemLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }

    public void setOnItemChildLongClickListener(OnItemChildLongClickListener childLongClickListener) {
        this.childLongClickListener = childLongClickListener;
    }

    public void setOnItemChildClickListener(OnItemChildClickListener childClickListener) {
        this.childClickListener = childClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public StringViewBindingAdapter(List<String> lists) {
        this.lists = lists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTextRvBinding binding = ItemTextRvBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
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
        //添加多个子控件点击事件
        addChildClicks(new int[]{R.id.btn_test, R.id.btn_test_2}, view, viewHolder);
        //添加视图长按事件
        view.setOnLongClickListener(v -> {
            if (longClickListener != null) {
                return longClickListener.onItemLongClick(v, viewHolder.getAdapterPosition());
            }
            return false;
        });
        //添加视图子控件长按事件
        view.findViewById(R.id.btn_test).setOnLongClickListener(v -> {
            if (childLongClickListener != null) {
                return childLongClickListener.onItemChildLongClick(v, viewHolder.getAdapterPosition());
            }
            return false;
        });
    }

    /**
     * 添加子控件点击事件
     * @param ids 控件id数组
     */
    private void addChildClicks(int[] ids, View view, ViewHolder viewHolder) {
        for (int id : ids) {
            view.findViewById(id).setOnClickListener(v -> {
                if (childClickListener != null) {
                    childClickListener.onItemChildClick(v, viewHolder.getAdapterPosition());
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvText.setText(lists.get(position));
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ItemTextRvBinding binding;

        public ViewHolder(@NonNull ItemTextRvBinding itemTextRvBinding) {
            super(itemTextRvBinding.getRoot());
            binding = itemTextRvBinding;
        }
    }
}
