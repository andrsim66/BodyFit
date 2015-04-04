package rootviii.bodyfit.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import rootviii.bodyfit.app.R;


/**
 * Created by voronsky on 4/4/2015.
 */
public class PersonActivity extends ActionBarActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private EditText etHeight;
    private EditText etWeight;
    private EditText etDWeight;
    private EditText etAge;
    private EditText etNeckCF;
    private EditText etWaistLine;
    private EditText etLoinsCF;
    private RadioGroup radioGroup;
    private RelativeLayout rlLoisContainer;
    private Button bSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_activity);

        initViews();
        setupViews();
    }

    private void initViews() {
        etHeight = (EditText) findViewById(R.id.heightET);
        etWeight = (EditText) findViewById(R.id.weightET);
        etDWeight = (EditText) findViewById(R.id.dWeightET);
        etAge = (EditText) findViewById(R.id.ageET);
        etNeckCF = (EditText) findViewById(R.id.neckCF_ET);
        etWaistLine = (EditText) findViewById(R.id.waistLineET);
        etLoinsCF = (EditText) findViewById(R.id.loinsCF_ET);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        rlLoisContainer = (RelativeLayout) findViewById(R.id.rl_loins_container);

        bSave = (Button) findViewById(R.id.startButton);
    }

    private void setupViews() {
        radioGroup.setOnCheckedChangeListener(this);
        bSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startButton:
                Intent intent = new Intent(PersonActivity.this, StatusActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radioMale:
                rlLoisContainer.setVisibility(View.GONE);
                break;
            case R.id.radioFemale:
                rlLoisContainer.setVisibility(View.VISIBLE);
                break;
        }
    }
}
