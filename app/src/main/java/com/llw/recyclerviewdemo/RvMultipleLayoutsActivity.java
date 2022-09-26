package com.llw.recyclerviewdemo;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.llw.recyclerviewdemo.adapter.MessageAdapter;
import com.llw.recyclerviewdemo.databinding.ActivityRvMultipleLayoutsBinding;

/**
 * 适配器多布局使用
 */
public class RvMultipleLayoutsActivity extends BasicActivity {

    private ActivityRvMultipleLayoutsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRvMultipleLayoutsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    private void initView() {
        back(binding.materialToolbar);
        binding.rvText.setLayoutManager(new LinearLayoutManager(this));
        binding.rvText.setAdapter(new MessageAdapter(getMessages()));
    }
}