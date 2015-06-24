package rootviii.bodyfit.app.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import rootviii.bodyfit.app.R;

public class WeightActivity extends ActionBarActivity {
private  Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_weight, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_statistics) {
            startActivity(new Intent(WeightActivity.this, StatisticsActivity.class));
            return true;
        }
        if (id== R.id.action_question){
            startActivity(new Intent(WeightActivity.this, QuestionActivity.class));
            return true;
        }
        if(id == R.id.action_weight){
            startActivity(new Intent(WeightActivity.this, WeightActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
