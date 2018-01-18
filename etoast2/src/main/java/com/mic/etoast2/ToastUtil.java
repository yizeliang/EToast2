package com.mic.etoast2;

import android.content.Context;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.TextView;

/**
 * Created by YZL on 2018/1/18.
 */

class ToastUtil {
    public static final View getToastView(Context context, CharSequence msg) {
        View view = View.inflate(context, R.layout.common_toast_layout, null);
        TextView textView = view.findViewById(R.id.tv_toast);
        textView.setText(msg);
        view.setEnabled(false);
        view.setFocusable(false);
        view.setFocusableInTouchMode(false);
        textView.setEnabled(false);
        textView.setFocusable(false);
        textView.setFocusableInTouchMode(false);
        return view;
    }
    public static final View getToastView(Context context,@StringRes int resId) {
        View view = View.inflate(context, R.layout.common_toast_layout, null);
        TextView textView = view.findViewById(R.id.tv_toast);
        textView.setText(resId);
        view.setEnabled(false);
        view.setFocusable(false);
        view.setFocusableInTouchMode(false);
        textView.setEnabled(false);
        textView.setFocusable(false);
        textView.setFocusableInTouchMode(false);
        return view;
    }
}
