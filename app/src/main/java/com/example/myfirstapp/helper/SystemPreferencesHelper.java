package com.example.myfirstapp.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;

import com.example.myfirstapp.ControlGymApplication;

/**
 * Created by M.Franco on 3/5/2017.
 */

public class SystemPreferencesHelper {

    private static final String SESSION_TOKEN = "SESSIONTOKEN";
    private static final String KEY_NOTIFICATIONS = "notifications";

    public static void savePreference(final Context context, final String id, final String value) {
        SharedPreferences settings = context.getSharedPreferences(SESSION_TOKEN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(id, value);
        editor.commit();
    }

    public static void savePreference(final Context context, final String id, final boolean value) {
        SharedPreferences settings = context.getSharedPreferences(SESSION_TOKEN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(id, value);
        editor.commit();
    }

    public static void savePreference(final Context context, final String id, final int value) {
        SharedPreferences settings = context.getSharedPreferences(SESSION_TOKEN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(id, value);
        editor.commit();
    }

    public static void savePreference(final Context context, final String id, final long value) {
        SharedPreferences settings = context.getSharedPreferences(SESSION_TOKEN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(id, value);
        editor.commit();
    }

    public static void saveEncryptPreference(final Context context, final String id, final String value) {
        try {
            String token = Base64.encodeToString(value.getBytes(), Base64.DEFAULT);
            SharedPreferences settings = context.getSharedPreferences(SESSION_TOKEN, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();

            editor.putString(id, token);
            editor.commit();

        } catch (Exception e) {
            return;
        }
    }

    public static void saveDefaultPreference(final Context context, final String id, final boolean value) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(id, value);
        editor.commit();
    }

    public static void removePreference(final Context context, final String id) {
        SharedPreferences settings = context.getSharedPreferences(SESSION_TOKEN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove(id);
        editor.commit();
    }

    public static boolean getDefaultPreferenceBool(final Context context, final String id) {
        return getDefaultPreferenceBool(context, id, false);
    }

    public static boolean getDefaultPreferenceBool(final Context context, final String id, final boolean defaultValue) {
        try {
            SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
            boolean value = settings.getBoolean(id, defaultValue);
            return value;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static String getPreference(final Context context, final String id) {
        return getPreference(context, id, "");
    }

    public static String getPreferenceDefault(final Context context, final String id, final String defaultValue) {
        return getPreference(context, id, defaultValue);
    }

    public static String getPreference(final Context context, final String id, final String defaultValue) {
        try {
            SharedPreferences settings = context.getSharedPreferences(SESSION_TOKEN, Context.MODE_PRIVATE);
            String value = settings.getString(id, defaultValue);
            return value;
        } catch (Exception e) {
            Log.e("ERROR PREFERENCE GET", e.toString());
            return defaultValue;
        }
    }

    public static boolean getPreferenceBool(final Context context, final String id) {
        return getPreferenceBool(context, id, false);
    }

    public static boolean getPreferenceBool(final Context context, final String id, final boolean defaultValue) {
        try {
            SharedPreferences settings = context.getSharedPreferences(SESSION_TOKEN, Context.MODE_PRIVATE);
            boolean value = settings.getBoolean(id, defaultValue);
            return value;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static long getPreferenceLong(final Context context, final String id) {
        return getPreferenceLong(context, id, 0);
    }

    public static long getPreferenceLong(final Context context, final String id, final long defaultValue) {
        try {
            SharedPreferences settings = context.getSharedPreferences(SESSION_TOKEN, Context.MODE_PRIVATE);
            long value = settings.getLong(id, defaultValue);
            return value;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static int getPreferenceInt(final Context context, final String id) {
        return getPreferenceInt(context, id, -1);
    }

    public static int getPreferenceInt(final Context context, final String id, final int defaultValue) {
        try {
            SharedPreferences settings = context.getSharedPreferences(SESSION_TOKEN, Context.MODE_PRIVATE);
            int value = settings.getInt(id, defaultValue);
            return value;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static String getEncryptPreference(final Context context, final String id) {
        try {
            SharedPreferences settings = context.getSharedPreferences(SESSION_TOKEN, Context.MODE_PRIVATE);
            String token = settings.getString(id, "");
            byte[] decode = Base64.decode(token, Base64.DEFAULT);

            return new String(decode);
        } catch (Exception e) {
            return null;
        }
    }

    public static void clearPreference(final Context context) {
        SharedPreferences settings = context.getSharedPreferences(SESSION_TOKEN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.commit();
    }

    // GCM NOTIFICATIONS

    public static void addNotification(final Context context, String notification) {
        SharedPreferences settings = context.getSharedPreferences(SESSION_TOKEN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        // get old notifications
        String oldNotifications = getNotifications(context);

        if (oldNotifications != null) {
            oldNotifications += "|" + notification;
        } else {
            oldNotifications = notification;
        }

        editor.putString(KEY_NOTIFICATIONS, oldNotifications);
        editor.commit();
    }

    public static String getNotifications(Context context) {
        SharedPreferences pref = context.getSharedPreferences(SESSION_TOKEN, Context.MODE_PRIVATE);
        return  pref.getString(KEY_NOTIFICATIONS, null);
    }

}
