package rootviii.bodyfit.app.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by andrii on 04.04.15.
 */
public class Utils {

    public static void saveLoginState(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("loginStatePrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstLogin", true);
        editor.commit();
    }

    public static boolean restoreLoginState(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("loginStatePrefs", Context.MODE_PRIVATE);
        return prefs.getBoolean("firstLogin", false);
    }

    public static String getTaskName(int type) {
        switch (type) {
            case 0:
                return "Wake up";
            case 1:
                return "Meal";
            case 2:
                return "Water";
            case 3:
                return "Training";
            case 4:
                return "Go to bed";
            default:
                return "";
        }
    }

    public static String formatTime(Date date) {
        DateFormat df = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
        return df.format(date);
    }
}
