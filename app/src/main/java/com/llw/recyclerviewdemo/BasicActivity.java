package com.llw.recyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.llw.recyclerviewdemo.bean.BasicBean;
import com.llw.recyclerviewdemo.bean.Group;
import com.llw.recyclerviewdemo.bean.Message;

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

    /**
     * 获取Beans
     */
    protected List<BasicBean> getBasicBeans() {
        List<BasicBean> lists = new ArrayList<>();
        int num = (int) (1 + Math.random() * (50 - 10 + 1));
        for (int i = 0; i < num; i++) {
            lists.add(new BasicBean("第 " + i + " 条标题", "第 " + i + " 条内容"));
        }
        return lists;
    }

    /**
     * 获取消息数据列表
     */
    protected List<Message> getMessages() {
        List<Message> messages = new ArrayList<>();
        int num = (int) (1 + Math.random() * (20 - 10 + 1));
        for (int i = 0; i < num; i++) {
            int type = i % 2 == 0 ? 0 : 1;
            String content = type == 0 ? "今天你搞钱了吗？" : "摸鱼的时候就专心摸鱼！";
            messages.add(new Message(type, content));
        }
        return messages;
    }

    /**
     * 获取分组数据列表
     */
    protected List<Group> getGroups() {
        List<Group> groups = new ArrayList<>();
        int groupNum = (int) (1 + Math.random() * (20 - 10 + 1));
        for (int i = 0; i < groupNum; i++) {
            List<Group.Contacts> contacts = new ArrayList<>();
            int contactsNum = (int) (1 + Math.random() * (20 - 10 + 1));
            for (int j = 0; j < contactsNum; j++) {
                contacts.add(new Group.Contacts("搞钱" + (j + 1) + "号"));
            }
            groups.add(new Group("搞钱" + (i + 1) + "组", contacts));
        }
        return groups;
    }
}
