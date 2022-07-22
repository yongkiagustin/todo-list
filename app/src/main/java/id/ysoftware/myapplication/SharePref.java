package id.ysoftware.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharePref {
    public static final String TOKEN = "id.ysoftware.myapplication.TOKEN";

    private static SharedPreferences getSharedPreference(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setToken(Context context, String labelItem) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(TOKEN, labelItem);
        editor.apply();
    }
    public static String getToken(Context context) {
        return getSharedPreference(context).getString(TOKEN, "");
    }
}
