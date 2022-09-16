package com.llw.recyclerviewdemo;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.llw.recyclerviewdemo.adapter.StringAdapter;
import com.llw.recyclerviewdemo.listener.OnItemChildLongClickListener;
import com.llw.recyclerviewdemo.listener.OnItemLongClickListener;

import java.util.List;

public class RvBasicUseActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_basic_use);

        initView();
    }

    private void initView() {
        MaterialToolbar toolbar = findViewById(R.id.materialToolbar);
        RecyclerView rvText = findViewById(R.id.rv_text);
        back(toolbar);

        List<String> strings = getStrings();
        //获取适配器实例
        StringAdapter stringAdapter = new StringAdapter(strings);
        //设置适配器Item点击事件
        stringAdapter.setOnItemClickListener((view, position) -> showMsg(strings.get(position)));
        //设置适配器Item子控件点击事件
        stringAdapter.setOnItemChildClickListener((view, position) -> {
            switch (view.getId()) {
                case R.id.btn_test:
                    showMsg(strings.get(position) + "的按钮 1");
                    break;
                case R.id.btn_test_2:
                    showMsg(strings.get(position) + "的按钮 2");
                    break;
            }
        });
        //设置适配器Item长按事件
        stringAdapter.setOnItemLongClickListener((view, position) -> {
            showMsg("长按了");
            return true;
        });
        //设置适配器Item子控件长按事件
        stringAdapter.setOnItemChildLongClickListener((view, position) -> {
            showMsg("长按了按钮");
            return true;
        });
        //配置适配器
        rvText.setAdapter(stringAdapter);
        //配置布局管理器
        rvText.setLayoutManager(new LinearLayoutManager(this));
    }
}