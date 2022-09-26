package com.llw.recyclerviewdemo.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.llw.recyclerviewdemo.bean.Group;
import com.llw.recyclerviewdemo.databinding.ItemContactsRvBinding;

import java.util.List;

/**
 * 联系人列表适配器
 */
public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private final List<Group.Contacts> contacts;

    public ContactsAdapter(List<Group.Contacts> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemContactsRvBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvContactsName.setText(contacts.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ItemContactsRvBinding binding;

        public ViewHolder(@NonNull ItemContactsRvBinding itemContactsRvBinding) {
            super(itemContactsRvBinding.getRoot());
            binding = itemContactsRvBinding;
        }
    }
}
