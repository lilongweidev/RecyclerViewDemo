package com.llw.recyclerviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;

import com.llw.recyclerviewdemo.adapter.BasicAdapter;
import com.llw.recyclerviewdemo.adapter.StringViewBindingAdapter;
import com.llw.recyclerviewdemo.databinding.ActivityRvRefreshLoadBinding;

import java.util.ArrayList;
import java.util.List;

public class RvRefreshLoadActivity extends BasicActivity {

    private ActivityRvRefreshLoadBinding binding;

    private final List<String> strings = new ArrayList<>();
    private int lastVisibleItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRvRefreshLoadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    private void initView() {
        back(binding.materialToolbar);

        strings.addAll(getStrings());
        //获取适配器实例
        BasicAdapter stringAdapter = new BasicAdapter(strings);
        //配置适配器
        binding.rvText.setAdapter(stringAdapter);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //配置布局管理器
        binding.rvText.setLayoutManager(linearLayoutManager);

        binding.refresh.setOnRefreshListener(() -> {
            strings.clear();
            strings.addAll(getStrings());
            new Handler().postDelayed(() -> {
                stringAdapter.notifyDataSetChanged();
                binding.refresh.setRefreshing(false);
            }, 1000);

        });
        //添加滑动监听
        binding.rvText.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == stringAdapter.getItemCount()) {
                    if (stringAdapter.getItemCount() > 50) {
                        showMsg("已加载全部");
                    } else {
                        showMsg("加载更多");
                        new Handler().postDelayed(() -> {
                            strings.addAll(getStrings());
                            stringAdapter.notifyDataSetChanged();
                        }, 1000);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //获取最后一个可见Item的下标
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });

    }
}