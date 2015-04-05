package rootviii.bodyfit.app.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import com.astuetz.PagerSlidingTabStrip;
import rootviii.bodyfit.app.R;
import rootviii.bodyfit.app.adapters.MyPagerAdapter;

public class StatisticsActivity extends ActionBarActivity {

    private Toolbar mToolbar;
    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new MyPagerAdapter(getSupportFragmentManager());

        pager.setAdapter(adapter);

        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        pager.setPageMargin(pageMargin);
        tabs.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        tabs.setTextColor(getResources().getColor(R.color.white));
        tabs.setTextSize(20);
        tabs.setIndicatorColor(getResources().getColor(R.color.white));
        tabs.setDividerColor(getResources().getColor(android.R.color.transparent));
        tabs.setIndicatorHeight(5);
        tabs.setViewPager(pager);
    }

}
