package com.llw.recyclerviewdemo;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import com.llw.recyclerviewdemo.adapter.StringViewBindingAdapter;
import com.llw.recyclerviewdemo.databinding.ActivityRvViewBindingBinding;

public class RvViewBindingActivity extends BasicActivity {

    private ActivityRvViewBindingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRvViewBindingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        back(binding.materialToolbar);

        //获取适配器实例
        StringViewBindingAdapter stringAdapter = new StringViewBindingAdapter(getStrings());
        //配置适配器
        binding.rvText.setAdapter(stringAdapter);
        //配置布局管理器
        binding.rvText.setLayoutManager(new LinearLayoutManager(this));
    }
}