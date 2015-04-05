package rootviii.bodyfit.app.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import rootviii.bodyfit.app.StatisticsFragment;

/**
 * Created by andrii on 05.04.15.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
    private final String[] TITLES = {"CALORIES", "WEIGHT", "WATER"};

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public Fragment getItem(int position) {
        return StatisticsFragment.newInstance(position);
    }
}
