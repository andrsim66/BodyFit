package rootviii.bodyfit.app.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
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
    private ProgressBar progressBar;

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
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    private void setupViews() {
        mLvBTasks.setOnItemClickListener(this);
    }

    private void loadTasks() {
        progressBar.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
//        category = intent.getIntExtra("category", 0);
        // todo count subcategory
        category = 1;
        ParseQuery<BTask> query = new ParseQuery<>("BTask");
        query.whereGreaterThan("category", category);
        query.orderByAscending("startTime");
        query.findInBackground(new FindCallback<BTask>() {
            @Override
            public void done(List<BTask> list, ParseException e) {
                if (e == null) {
                    progressBar.setVisibility(View.GONE);
                    mBTasks = new ArrayList<>(list.subList(0,12));
                    for (int i = 0; i < mBTasks.size(); i++) {
                        Logger.d("bt="+mBTasks.get(i).getType());
                    }
                    mBTasks.get(0).setType(0);
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
        if (id== R.id.action_question){
            startActivity(new Intent(DayScheduleActivity.this, QuestionActivity.class));
            return true;
        }
        if(id == R.id.action_weight){
            startActivity(new Intent(DayScheduleActivity.this, WeightActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mLvBTasks.getChildAt(position).setBackgroundColor(Color.parseColor("#4CAF50"));
        adapter.notifyDataSetChanged();
        if (mBTasks.get(position).getType() == 1) {
            startActivity(new Intent(DayScheduleActivity.this, FoodActivity.class));
        }
    }
}
