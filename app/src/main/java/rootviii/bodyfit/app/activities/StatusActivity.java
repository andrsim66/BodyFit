package rootviii.bodyfit.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.parse.ParseException;
import com.parse.SaveCallback;
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
    private ImageView ivOutline;

    private Person person;

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
        person = new Person();
        person.setHeight(intent.getDoubleExtra("height", 0));
        person.setWeight(intent.getDoubleExtra("weight", 0));
        person.setdWeight(intent.getDoubleExtra("dweight", 0));
        person.setAge(intent.getIntExtra("age", 0));
        person.setGender(intent.getIntExtra("gender", 0));
        person.setNeckCF(intent.getDoubleExtra("neck", 0));
        person.setWaistLine(intent.getDoubleExtra("waist", 0));
        person.setLoinsCF(intent.getDoubleExtra("loins", 0));
        calcPercentage(person);
    }

    private void initViews() {
        bStart = (Button) findViewById(R.id.b_start);
        tvFatP = (TextView) findViewById(R.id.tv_fat_percentage);
        tvMuscleP = (TextView) findViewById(R.id.tv_muscle_percentage);
        tvWaterP = (TextView) findViewById(R.id.tv_water_percentage);
        ivOutline = (ImageView) findViewById(R.id.iv_outline);
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
        if (person.getGender() == 0) {
            ivOutline.setImageDrawable(getResources().getDrawable(R.drawable.ic_male_outline));
        } else {
            ivOutline.setImageDrawable(getResources().getDrawable(R.drawable.ic_female_outline));
        }
        tvFatP.setText(Utils.formatPercent(fatPercent));
        double musclePercent = Utils.calcMuscle(person.getWeight(), fatPercent);
        tvMuscleP.setText(Utils.formatPercent(musclePercent));
        double waterPercent = Utils.calcWater(person.getWeight(),
                person.getHeight(), person.getGender());
        tvWaterP.setText(Utils.formatPercent(waterPercent));

        person.setFatPercent(fatPercent);
        person.setMusclePercent(musclePercent);
        person.setWaterPercent(waterPercent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_start:

                person.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Utils.saveLoginState(StatusActivity.this);
                        }
                    }
                });
//
//                Date dt = new Date();
//                Calendar c = Calendar.getInstance();
//                c.setTime(dt);
//                c.add(Calendar.DATE, 1);
//                dt = c.getTime();
//                Logger.d("dt="+dt);
//
                Intent intent = new Intent(StatusActivity.this, DayScheduleActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("category", Utils.getProgramCategory(person.getFatPercent(), person.getGender()));
                Utils.saveCategory(StatusActivity.this,
                        Utils.getProgramCategory(person.getFatPercent(), person.getGender()));
                startActivity(intent);
                break;
        }
    }
}
