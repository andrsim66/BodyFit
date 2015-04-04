package rootviii.bodyfit.app;

import android.content.Context;
import android.content.SharedPreferences;

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
}
