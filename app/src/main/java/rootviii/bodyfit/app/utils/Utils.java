package rootviii.bodyfit.app.utils;

import android.content.Context;
import android.content.SharedPreferences;
import rootviii.bodyfit.app.R;

import java.text.DateFormat;
import java.text.DecimalFormat;
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

    public static void saveCategory(Context context, int category) {
        SharedPreferences prefs = context.getSharedPreferences("categoryPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("category", category);
        editor.commit();
    }

    public static int restoreCategory(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("categoryPrefs", Context.MODE_PRIVATE);
        return prefs.getInt("category", 0);
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

    public static double calcFat(double weightKg, double heightSm, double neckSm,
                                 double waistSm, double hipsSm, int gender) {
        double fatPercent;
//        heightSm/=100;
        double logcon = 2.302585093;
        if (gender == 0) {
            fatPercent = 495 / (1.0324 - 0.19077 * (Math.log(waistSm - neckSm) / logcon) +
                    0.15456 * (Math.log(heightSm) / logcon)) - 450;
        } else {
            fatPercent = 495 / (1.29579 - 0.35004 * (Math.log(waistSm + hipsSm - neckSm) / logcon) +
                    0.22100 * (Math.log(heightSm) / logcon)) - 450;
        }
        return fatPercent;
    }

    public static double calcFat2(double weightKg, double heightSm, double neckSm,
                                  double waistSm, double hipsSm, int gender) {
        double fatPercent;
        heightSm /= 100;
        if (gender == 0) {
            fatPercent = 0.31457 * (waistSm) - 0.10969 * (weightKg) + 10.834;
        } else {
            fatPercent = 100 - (0.11077 * (waistSm) - 0.17666 * (heightSm * 100) +
                    0.14354 * (weightKg) + 51.033);
        }
        return fatPercent;
    }

    public static double calcMuscle(double weight, double fatPercent) {

        return weight - (weight * fatPercent / 100);
    }

    public static double calcWater(double weightKg, double heightSm, int gender) {
        heightSm /= 100;
        if (gender == 0) {
            if (heightSm > 132.7) {
                return 21.993 + 0.406 * (weightKg) + 0.209 * (heightSm);
            } else {
                return 1.927 + 0.465 * (weightKg) + 0.045 * (heightSm);
            }
        } else {
            if (heightSm > 110.8) {
                return 10.313 + 0.252 * (weightKg) + 0.154 * (heightSm);
            } else {
                return 0.076 + 0.507 * (weightKg) + 0.013 * (heightSm);
            }
        }
    }

    public static String formatPercent(double sum) {
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(sum) + " %";
    }

    public static int getItemResourseId(int type) {
        switch (type) {
            case 0:
                return R.drawable.ic_wake_up;
            case 1:
                return R.drawable.ic_meal;
            case 2:
                return R.drawable.ic_drink;
            case 3:
                return R.drawable.ic_sport;
            case 4:
                return R.drawable.ic_go_to_bed;
            default:
                return -1;
        }
    }

    public static int getProgramCategory(double fatPercent, int gender) {
        if (gender == 0) {
            if (fatPercent < 22 && fatPercent > 12) {
                return 0;
            } else if (fatPercent >= 22) {
                return 2;
            }
        } else {
            if (fatPercent < 26 && fatPercent > 16) {
                return 1;
            } else if (fatPercent >= 26) {
                return 3;
            }
        }
        return -1;
    }


}
