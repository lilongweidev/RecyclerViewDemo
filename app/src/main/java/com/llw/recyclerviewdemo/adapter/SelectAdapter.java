package com.llw.recyclerviewdemo.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.llw.recyclerviewdemo.bean.SelectBean;
import com.llw.recyclerviewdemo.databinding.ItemSelectRvBinding;
import com.llw.recyclerviewdemo.listener.OnItemCheckedChangeListener;
import com.llw.recyclerviewdemo.listener.OnItemClickListener;

import java.util.List;

/**
 * 选中适配器
 */
public class SelectAdapter extends RecyclerView.Adapter<SelectAdapter.ViewHolder> {

    private final List<SelectBean> selectBeans;

    private boolean show;

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public boolean isShow() {
        return show;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setShow(boolean show) {
        this.show = show;
        notifyDataSetChanged();
    }

    public SelectAdapter(List<SelectBean> selectBeans) {
        this.selectBeans = selectBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(ItemSelectRvBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
        viewHolder.binding.itemSelect.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(v, viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SelectBean selectBean = selectBeans.get(position);
        holder.binding.tvContent.setText(selectBean.getContent());
        holder.binding.cbSelect.setChecked(selectBean.isSelect());
        holder.binding.cbSelect.setVisibility(isShow() ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return selectBeans.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ItemSelectRvBinding binding;

        public ViewHolder(@NonNull ItemSelectRvBinding itemSelectRvBinding) {
            super(itemSelectRvBinding.getRoot());
            binding = itemSelectRvBinding;
        }
    }
}
