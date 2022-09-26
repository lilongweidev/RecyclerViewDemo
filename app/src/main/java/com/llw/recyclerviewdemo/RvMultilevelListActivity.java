package com.llw.recyclerviewdemo;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.llw.recyclerviewdemo.adapter.GroupAdapter;
import com.llw.recyclerviewdemo.databinding.ActivityRvMultilevelListBinding;

/**
 * 多级列表使用
 */
public class RvMultilevelListActivity extends BasicActivity {

    private ActivityRvMultilevelListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRvMultilevelListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        back(binding.materialToolbar);
        binding.rvGroup.setAdapter(new GroupAdapter(getGroups()));
        binding.rvGroup.setLayoutManager(new LinearLayoutManager(this));
    }
}