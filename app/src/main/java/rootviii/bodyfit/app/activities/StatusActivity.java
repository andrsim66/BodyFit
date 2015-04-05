package rootviii.bodyfit.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.Gson;
import rootviii.bodyfit.app.R;
import rootviii.bodyfit.app.pojo.Person;
import rootviii.bodyfit.app.utils.Utils;

/**
 * Created by andrii on 04.04.15.
 */
public class StatusActivity extends ActionBarActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private Button bStart;
    private TextView tvFatP;
    private TextView tvMuscleP;
    private TextView tvWaterP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

        initViews();
        setupViews();

        Intent intent = getIntent();
        String jsonObject = intent.getStringExtra("person");
        Gson gson = new Gson();
        Person person = gson.fromJson(jsonObject, Person.class);
        calcPercentage(person);
    }

    private void initViews() {
        bStart = (Button) findViewById(R.id.b_start);
        tvFatP = (TextView) findViewById(R.id.tv_fat_percentage);
        tvMuscleP = (TextView) findViewById(R.id.tv_muscle_percentage);
        tvWaterP = (TextView) findViewById(R.id.tv_water_percentage);
    }

    private void setupViews() {
        bStart.setOnClickListener(this);
    }


    private void calcPercentage(Person person) {
        double fatPercent = Utils.calcFat(
                person.getWeight(),
                person.getHeight(),
                person.getNeckCF(),
                person.getWaistLine(),
                person.getLoinsCF(),
                person.getGender());
        tvFatP.setText(Utils.formatPercent(fatPercent));
        double musclePercent = Utils.calcMuscle(person.getWeight(), fatPercent);
        tvMuscleP.setText(Utils.formatPercent(musclePercent));
        double waterPercent = Utils.calcWater(person.getWeight(),
                person.getHeight(), person.getGender());
        tvWaterP.setText(Utils.formatPercent(waterPercent));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_start:
                Intent intent = new Intent(StatusActivity.this, DayScheduleActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }
    }
}
