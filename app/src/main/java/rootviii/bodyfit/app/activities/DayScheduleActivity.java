package rootviii.bodyfit.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import rootviii.bodyfit.app.R;
import rootviii.bodyfit.app.adapters.DayScheduleAdapter;
import rootviii.bodyfit.app.pojo.BTask;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DayScheduleActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private ListView mLvBTasks;
    private List<BTask> mBTasks;
    private DayScheduleAdapter adapter;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_schedule);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

        mBTasks = new ArrayList<>();

        BTask bTask0 = new BTask(0, new Date(), new Date(), 0, false);
        BTask bTask1 = new BTask(2, new Date(), new Date(), 250, false);
        BTask bTask2 = new BTask(3, new Date(), new Date(), 0, false);
        BTask bTask3 = new BTask(1, new Date(), new Date(), 0, false);
        BTask bTask4 = new BTask(2, new Date(), new Date(), 250, false);
        BTask bTask5 = new BTask(1, new Date(), new Date(), 0, false);
        BTask bTask6 = new BTask(2, new Date(), new Date(), 250, false);
        BTask bTask7 = new BTask(1, new Date(), new Date(), 0, false);
        BTask bTask8 = new BTask(3, new Date(), new Date(), 0, false);
        BTask bTask9 = new BTask(2, new Date(), new Date(), 250, false);
        BTask bTask10 = new BTask(1, new Date(), new Date(), 0, false);
        BTask bTask11 = new BTask(4, new Date(), new Date(), 0, false);

        mBTasks.add(bTask0);
        mBTasks.add(bTask1);
        mBTasks.add(bTask2);
        mBTasks.add(bTask3);
        mBTasks.add(bTask4);
        mBTasks.add(bTask5);
        mBTasks.add(bTask6);
        mBTasks.add(bTask7);
        mBTasks.add(bTask8);
        mBTasks.add(bTask9);
        mBTasks.add(bTask10);
        mBTasks.add(bTask11);

        initViews();
        setupViews();
    }

    private void initViews() {
        mLvBTasks = (ListView) findViewById(R.id.listView);
    }

    private void setupViews() {
        adapter = new DayScheduleAdapter(DayScheduleActivity.this, R.layout.item_btask, mBTasks);
        mLvBTasks.setAdapter(adapter);
        mLvBTasks.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_day_schedule, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_statistics) {
            startActivity(new Intent(DayScheduleActivity.this, StatisticsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (mBTasks.get(position).getType() == 1) {
            startActivity(new Intent(DayScheduleActivity.this, FoodActivity.class));
        }
    }
}
