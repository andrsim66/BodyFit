package rootviii.bodyfit.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import rootviii.bodyfit.app.pojo.BTask;

import java.util.Date;


public class DayScheduleActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_schedule);
        final ListView listview = (ListView) findViewById(R.id.listView);
        //int type, Date startTime, Date finishTime, double amount, boolean isComplete
        BTask bTask0 = new BTask(0, new Date(), new Date(), 0, false);
        BTask bTask1 = new BTask(1, new Date(), new Date(), 250, false);
        BTask bTask2 = new BTask(2, new Date(), new Date(), 0, false);
        BTask bTask3 = new BTask(3, new Date(), new Date(), 0, false);
        BTask bTask4 = new BTask(4, new Date(), new Date(), 250, false);
        BTask bTask5 = new BTask(5, new Date(), new Date(), 0, false);
        BTask bTask6 = new BTask(6, new Date(), new Date(), 250, false);
        BTask bTask7 = new BTask(7, new Date(), new Date(), 0, false);
        BTask bTask8 = new BTask(8, new Date(), new Date(), 0, false);
        BTask bTask9 = new BTask(9, new Date(), new Date(), 250, false);
        BTask bTask10 = new BTask(10, new Date(), new Date(), 0, false);
        BTask bTask11 = new BTask(11, new Date(), new Date(), 0, false);
        String[] values = new String[]{"Wake up", "Water", "Morning Exercises", "Meal", "Water",
                "Meal", "Water", "Meal", "Sport", "Water", "Meal", "Go to bed!"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString();
                if (strText.equalsIgnoreCase("Meal")) {
                    startActivity(new Intent(DayScheduleActivity.this, FoodActivity.class));
                }
            }

        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_day_schedule, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
