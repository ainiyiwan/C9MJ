package com.c9mj.platform.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.c9mj.platform.R;

/**
 * author: LMJ
 * date: 2016/9/7
 * 用于维护唯一SnackBar的工具类
 */
public class SnackbarUtil {

    private static View  view;

    public static void init(View decorView) {
        view = decorView;
    }

    public static void show(CharSequence content, int duration){

        if (view == null){
            return;
        }
        Snackbar snackbar = Snackbar
                .make(view, content, duration)
                .setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
        snackbar.show();
    }

    public static void show(CharSequence content){
        show(content, Snackbar.LENGTH_SHORT);
    }

}
