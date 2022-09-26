package com.llw.recyclerviewdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.llw.recyclerviewdemo.R;
import com.llw.recyclerviewdemo.bean.Group;
import com.llw.recyclerviewdemo.databinding.ItemGroupRvBinding;

import java.util.List;

/**
 * 分组适配器
 */
public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {

    private final List<Group> groups;

    public GroupAdapter(List<Group> groups) {
        this.groups = groups;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(ItemGroupRvBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
        viewHolder.binding.group.setOnClickListener(v -> {
            //是否显示
            boolean isShow = viewHolder.binding.rvContacts.getVisibility() == View.VISIBLE;
            //修改图标
            viewHolder.binding.ivFlag.setImageDrawable(isShow ?
                    ContextCompat.getDrawable(parent.getContext(), R.drawable.ic_right) : ContextCompat.getDrawable(parent.getContext(), R.drawable.ic_down));
            //显示或隐藏联系人列表
            viewHolder.binding.rvContacts.setVisibility(isShow ? View.GONE : View.VISIBLE);
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Group group = groups.get(position);
        holder.binding.tvGroupName.setText(group.getName());
        holder.binding.rvContacts.setAdapter(new ContactsAdapter(group.getContacts()));
        holder.binding.rvContacts.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ItemGroupRvBinding binding;

        public ViewHolder(@NonNull ItemGroupRvBinding itemGroupRvBinding) {
            super(itemGroupRvBinding.getRoot());
            binding = itemGroupRvBinding;
        }
    }
}
