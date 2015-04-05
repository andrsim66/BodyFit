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
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import rootviii.bodyfit.app.R;
import rootviii.bodyfit.app.adapters.DayScheduleAdapter;
import rootviii.bodyfit.app.pojo.BTask;
import rootviii.bodyfit.app.utils.Logger;

import java.util.ArrayList;
import java.util.List;


public class DayScheduleActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private ListView mLvBTasks;
    private List<BTask> mBTasks;
    private DayScheduleAdapter adapter;
    private Toolbar mToolbar;

    private double category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_schedule);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

        mBTasks = new ArrayList<>();

        initViews();
        setupViews();

        loadTasks();
    }

    private void initViews() {
        mLvBTasks = (ListView) findViewById(R.id.listView);
    }

    private void setupViews() {
        mLvBTasks.setOnItemClickListener(this);
    }

    private void loadTasks() {
        Intent intent = getIntent();
        category = intent.getIntExtra("category", 0);
        ParseQuery<BTask> query = new ParseQuery<>("BTask");
        query.whereGreaterThan("category", category);
        query.orderByAscending("startTime");
        query.findInBackground(new FindCallback<BTask>() {
            @Override
            public void done(List<BTask> list, ParseException e) {
                if (e == null) {
                    mBTasks = new ArrayList<>(list);
                    adapter = new DayScheduleAdapter(DayScheduleActivity.this,
                            R.layout.item_btask, mBTasks);
                    mLvBTasks.setAdapter(adapter);
                }
            }
        });
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
