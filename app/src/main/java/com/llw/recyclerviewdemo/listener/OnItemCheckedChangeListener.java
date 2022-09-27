package com.llw.recyclerviewdemo.listener;

import android.view.View;

/**
 * Item点击监听
 */
public interface OnItemCheckedChangeListener {

    void onItemCheckedChange(View view, int position, boolean isChecked);
}
