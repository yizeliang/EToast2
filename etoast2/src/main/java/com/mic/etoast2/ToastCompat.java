package com.mic.etoast2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v4.app.NotificationManagerCompat;
import android.view.Gravity;

/**
 * Author: Blincheng.
 * Date: 2017/6/30.
 * Description:
 */

public class ToastCompat {
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    private static int checkNotification = 0;
    private Object mToast;

    private ToastCompat(Context context, String message, int duration) {
        if (context instanceof Application) {
            checkNotification = 0;
        } else {
            checkNotification = isNotificationEnabled(context) ? 0 : 1;
        }
        if (checkNotification == 1) {
            mToast = EToast2.makeText(context, message, duration);
        } else {
            android.widget.Toast toast = android.widget.Toast.makeText(context, message, duration);
            toast.setView(ToastUtil.getToastView(context, message));
            toast.setGravity(Gravity.CENTER, 0, 0);
            mToast = toast;
        }
    }

    private ToastCompat(Context context, int resId, int duration) {
        if (context instanceof Application)
            checkNotification = 0;
        else
            checkNotification = isNotificationEnabled(context) ? 0 : 1;
        if (checkNotification == 1 && context instanceof Activity) {
            mToast = EToast2.makeText(context, resId, duration);
        } else {
            android.widget.Toast toast = android.widget.Toast.makeText(context, resId, duration);
            toast.setView(ToastUtil.getToastView(context, resId));
            toast.setGravity(Gravity.CENTER, 0, 0);
            mToast = toast;

        }
    }

    public static ToastCompat makeText(Context context, String message, int duration) {
        return new ToastCompat(context, message, duration);
    }

    public static ToastCompat makeText(Context context, int resId, int duration) {
        return new ToastCompat(context, resId, duration);
    }

    public void show() {
        if (mToast instanceof EToast2) {
            ((EToast2) mToast).show();
        } else if (mToast instanceof android.widget.Toast) {
            ((android.widget.Toast) mToast).show();
        }
    }

    public void cancel() {
        if (mToast instanceof EToast2) {
            ((EToast2) mToast).cancel();
        } else if (mToast instanceof android.widget.Toast) {
            ((android.widget.Toast) mToast).cancel();
        }
    }

    public void setText(CharSequence s) {
        if (mToast instanceof EToast2) {
            ((EToast2) mToast).setText(s);
        } else if (mToast instanceof android.widget.Toast) {
            ((android.widget.Toast) mToast).setText(s);
        }
    }

    /**
     * 用来判断是否开启通知权限
     */
    private static boolean isNotificationEnabled(Context context) {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
//            AppOpsManager mAppOps = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
//            ApplicationInfo appInfo = context.getApplicationInfo();
//
//            String pkg = context.getApplicationContext().getPackageName();
//
//            int uid = appInfo.uid;
//
//            Class appOpsClass = null; /* Context.APP_OPS_MANAGER */
//
//            try {
//                appOpsClass = Class.forName(AppOpsManager.class.getName());
//                Method checkOpNoThrowMethod = appOpsClass.getMethod(CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE, String.class);
//                Field opPostNotificationValue = appOpsClass.getDeclaredField(OP_POST_NOTIFICATION);
//                int value = (int) opPostNotificationValue.get(Integer.class);
//                return ((int) checkOpNoThrowMethod.invoke(mAppOps, value, uid, pkg) == AppOpsManager.MODE_ALLOWED);
//            } catch (Exception e) {
//                e.printStackTrace();
//                return false;
//            }
//        } else{
//            return false;
//        }
    }
}