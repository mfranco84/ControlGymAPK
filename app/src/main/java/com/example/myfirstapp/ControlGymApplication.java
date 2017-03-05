package com.example.myfirstapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by M.Franco on 3/5/2017.
 */

public class ControlGymApplication extends Application {
    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    public static void setContext(Context mContext) {
        ControlGymApplication.mContext = mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setContext(getApplicationContext());
    }


}
