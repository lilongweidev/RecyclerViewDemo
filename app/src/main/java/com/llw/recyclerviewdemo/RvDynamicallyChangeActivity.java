package com.llw.recyclerviewdemo;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.llw.recyclerviewdemo.adapter.SelectAdapter;
import com.llw.recyclerviewdemo.bean.SelectBean;
import com.llw.recyclerviewdemo.databinding.ActivityRvDynamicallyChangeBinding;
import com.llw.recyclerviewdemo.listener.OnItemCheckedChangeListener;
import com.llw.recyclerviewdemo.listener.OnItemClickListener;

import java.util.List;
import java.util.Locale;

/**
 * 动态更改数据
 */
public class RvDynamicallyChangeActivity extends BasicActivity {

    private ActivityRvDynamicallyChangeBinding binding;

    //记录选中个数
    private int selectNum = 0;
    //是否编辑
    private boolean show = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRvDynamicallyChangeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        back(binding.materialToolbar);

        List<SelectBean> selects = getSelects();
        SelectAdapter selectAdapter = new SelectAdapter(selects);
        selectAdapter.setOnItemClickListener((view, position) -> {
            if (!show) {
                boolean select = selects.get(position).isSelect();
                //更改数据
                selects.get(position).setSelect(!select);
                //刷新适配器
                selectAdapter.notifyItemChanged(position);
                if (!select) selectNum++;
                else selectNum--;
                binding.tvSelectNum.setText(String.format(Locale.getDefault(), "选中%d个", selectNum));
            }
        });
        binding.rvText.setLayoutManager(new LinearLayoutManager(this));
        binding.rvText.setAdapter(selectAdapter);

        binding.tvEdit.setOnClickListener(v -> {
            show = selectAdapter.isShow();
            selectAdapter.setShow(!show);
            binding.tvSelectNum.setVisibility(show ? View.GONE : View.VISIBLE);
            binding.tvEdit.setText(show ? "编辑" : "取消");
            boolean cancel = !show;
            if (!cancel) {
                for (SelectBean select : selects) {
                    select.setSelect(false);
                }
                selectAdapter.notifyDataSetChanged();
                selectNum = 0;
                binding.tvSelectNum.setText(String.format(Locale.getDefault(), "选中%d个", selectNum));
            }
        });
    }
}