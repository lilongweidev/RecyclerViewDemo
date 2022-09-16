package com.llw.recyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.llw.recyclerviewdemo.bean.BasicBean;

import java.util.ArrayList;
import java.util.List;

public class BasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    protected void back(MaterialToolbar toolbar) {
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    protected void jumpActivity(final Class<?> clazz) {
        startActivity(new Intent(this, clazz));
    }

    protected void showMsg(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取字符串列表
     */
    protected List<String> getStrings() {
        List<String> lists = new ArrayList<>();
        int num = (int) (1 + Math.random() * (50 - 10 + 1));
        for (int i = 0; i < num; i++) {
            lists.add("第 " + i + " 条数据");
        }
        return lists;
    }

    protected List<BasicBean> getBasicBeans() {
        List<BasicBean> lists = new ArrayList<>();
        int num = (int) (1 + Math.random() * (50 - 10 + 1));
        for (int i = 0; i < num; i++) {
            lists.add(new BasicBean("第 " + i + " 条标题", "第 " + i + " 条内容"));
        }
        return lists;
    }
}
