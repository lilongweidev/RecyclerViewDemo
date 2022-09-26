package com.llw.recyclerviewdemo;

import android.os.Bundle;

import com.llw.recyclerviewdemo.databinding.ActivityMainBinding;

public class MainActivity extends BasicActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //基本使用
        binding.btnRvBasicUse.setOnClickListener(v -> jumpActivity(RvBasicUseActivity.class));
        //结合ViewBinding使用
        binding.btnRvViewBinding.setOnClickListener(v -> jumpActivity(RvViewBindingActivity.class));
        //结合DataBinding使用
        binding.btnRvDataBinding.setOnClickListener(v -> jumpActivity(RvDataBindingActivity.class));
        //结合SwipeRefreshLayout使用
        binding.btnRvRefreshLoad.setOnClickListener(v -> jumpActivity(RvRefreshLoadActivity.class));
        //适配器多布局使用
        binding.btnRvMultipleLayouts.setOnClickListener(v -> jumpActivity(RvMultipleLayoutsActivity.class));
        //多级列表使用
        binding.btnRvMultilevelList.setOnClickListener(v -> jumpActivity(RvMultilevelListActivity.class));
    }
}