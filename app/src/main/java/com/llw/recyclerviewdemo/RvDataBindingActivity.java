package com.llw.recyclerviewdemo;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.llw.recyclerviewdemo.adapter.StringDataBindingAdapter;
import com.llw.recyclerviewdemo.bean.BasicBean;
import com.llw.recyclerviewdemo.databinding.ActivityRvDataBindingBinding;
import com.llw.recyclerviewdemo.listener.OnItemClickListener;
import com.llw.recyclerviewdemo.listener.OnItemLongClickListener;

import java.util.List;

public class RvDataBindingActivity extends BasicActivity {

    private ActivityRvDataBindingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rv_data_binding);
        initView();
    }

    private void initView() {
        back(binding.materialToolbar);

        List<BasicBean> basicBeans = getBasicBeans();
        //获取适配器实例
        StringDataBindingAdapter stringAdapter = new StringDataBindingAdapter(basicBeans);

        stringAdapter.setOnItemClickListener((view, position) -> {
            showMsg("点击了" + basicBeans.get(position).getTitle());
        });
        stringAdapter.setOnItemLongClickListener((view, position) -> {
            showMsg("长按了" + basicBeans.get(position).getTitle());
            return true;
        });
        //配置适配器
        binding.rvText.setAdapter(stringAdapter);
        //配置布局管理器
        binding.rvText.setLayoutManager(new LinearLayoutManager(this));
    }
}