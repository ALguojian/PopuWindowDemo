package com.alguojian.mylibrary;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * ${Descript}
 *
 * @author alguojian
 * @date 2018/12/21
 */
public class BasePopu<T extends ViewDataBinding> extends PopupWindow {

    public ViewDataBinding T;
    public Context mContext;
    private Window window;

    public BasePopu(Context context, View view, int width, int height) {
        super(view, width, height, true);
        window = ((Activity) mContext).getWindow();
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setOutsideTouchable(true);
        setTouchable(true);

        setOnDismissListener(() -> {
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.alpha = 1.0f;
            window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            window.setAttributes(lp);
        });
    }


    //在popuwindow的父view中确定位置
    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        super.showAtLocation(parent, gravity, x, y);
    }

    //直接显示在某个view的下面，紧贴着，没有偏移量
    @Override
    public void showAsDropDown(View anchor) {
        super.showAsDropDown(anchor);
    }


    @Override
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        super.showAsDropDown(anchor, xoff, yoff);

        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = 0.3f;
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.setAttributes(lp);
    }

    //显示在某个view的某个方向，可以添加偏移量
    @Override
    public void showAsDropDown(View anchor, int xoff, int yoff, int gravity) {
        super.showAsDropDown(anchor, xoff, yoff, gravity);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    private View getView(int layout) {
        T = DataBindingUtil.inflate(LayoutInflater.from(mContext), layout, null, false);
        return T.getRoot();
    }
}
