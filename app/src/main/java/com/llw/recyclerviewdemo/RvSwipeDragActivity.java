package com.llw.recyclerviewdemo;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.llw.recyclerviewdemo.adapter.BasicAdapter;
import com.llw.recyclerviewdemo.databinding.ActivityRvSwipeDragBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 左右滑动和上下拖动
 */
public class RvSwipeDragActivity extends BasicActivity {

    private ActivityRvSwipeDragBinding binding;
    private final List<String> lists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRvSwipeDragBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        back(binding.materialToolbar);

        lists.addAll(getStrings());
        //获取适配器实例
        BasicAdapter basicAdapter = new BasicAdapter(lists);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //配置布局管理器
        binding.rvSimple.setLayoutManager(linearLayoutManager);
        //配置适配器
        binding.rvSimple.setAdapter(basicAdapter);

        //Item触控帮助类
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.Callback() {

            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                //控制拖拽的方向
                int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.START | ItemTouchHelper.END;
                //控制快速滑动的方向
                int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
                return makeMovementFlags(dragFlags, swipeFlags);
            }

            //拖拽
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                if (lists.size() > 0) {
                    //获取被拖拽的Item的Position
                    int from = viewHolder.getAdapterPosition();
                    //获取目标Item的Position
                    int endPosition = target.getAdapterPosition();
                    //交换List集合中两个元素的位置
                    Collections.swap(lists, from, endPosition);
                    //交换界面上两个Item的位置
                    basicAdapter.notifyItemMoved(from, endPosition);
                }
                return true;
            }

            //滑动
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int adapterPosition = viewHolder.getAdapterPosition();
                lists.remove(adapterPosition);
                basicAdapter.notifyItemRemoved(adapterPosition);
            }

        });
        //关联recyclerView
        helper.attachToRecyclerView(binding.rvSimple);
    }
}