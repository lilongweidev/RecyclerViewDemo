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

        binding.btnRvBasicUse.setOnClickListener(v ->
                jumpActivity(RvBasicUseActivity.class));
        findViewById(R.id.btn_rv_view_binding).setOnClickListener(v ->
                jumpActivity(RvViewBindingActivity.class));
        findViewById(R.id.btn_rv_data_binding).setOnClickListener(v ->
                jumpActivity(RvDataBindingActivity.class));
    }
}