package com.llw.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.llw.recyclerviewdemo.adapter.StringDataBindingAdapter;
import com.llw.recyclerviewdemo.adapter.StringViewBindingAdapter;
import com.llw.recyclerviewdemo.databinding.ActivityRvDataBindingBinding;

public class RvDataBindingActivity extends BasicActivity {

    private ActivityRvDataBindingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_rv_data_binding);
        initView();
    }

    private void initView() {
        back(binding.materialToolbar);

        //获取适配器实例
        StringDataBindingAdapter stringAdapter = new StringDataBindingAdapter(getBasicBeans());
        //配置适配器
        binding.rvText.setAdapter(stringAdapter);
        //配置布局管理器
        binding.rvText.setLayoutManager(new LinearLayoutManager(this));
    }
}