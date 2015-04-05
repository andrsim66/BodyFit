package rootviii.bodyfit.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import com.google.gson.Gson;
import rootviii.bodyfit.app.R;
import rootviii.bodyfit.app.pojo.Person;


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
    private Toolbar mToolbar;

    private boolean isFemaleChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_activity);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

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
                if (validate()) {
                    Person person = makePerson();
                    Gson gsonPerson = new Gson();
                    String jsonPerson = gsonPerson.toJson(person);
                    Intent intent = new Intent(PersonActivity.this, StatusActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("person", jsonPerson);
                    startActivity(intent);
                }
                break;
        }
    }

    private Person makePerson() {
        Person person = new Person();
        person.setHeight(Double.parseDouble(etHeight.getText().toString()));
        person.setWeight(Double.parseDouble(etWeight.getText().toString()));
        person.setdWeight(Double.parseDouble(etDWeight.getText().toString()));
        person.setAge(Integer.parseInt(etAge.getText().toString()));
        person.setNeckCF(Double.parseDouble(etNeckCF.getText().toString()));
        person.setWaistLine(Double.parseDouble(etWaistLine.getText().toString()));
        person.setGender(isFemaleChecked ? 1 : 0);
        if (isFemaleChecked)
            person.setLoinsCF(Double.parseDouble(etLoinsCF.getText().toString()));
        return person;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radioMale:
                rlLoisContainer.setVisibility(View.GONE);
                isFemaleChecked = false;
                break;
            case R.id.radioFemale:
                rlLoisContainer.setVisibility(View.VISIBLE);
                isFemaleChecked = true;
                break;
        }
    }

    private boolean validate() {
        if (etHeight.getText().toString().length() == 0) {
            etHeight.setHintTextColor(getResources().getColor(R.color.colorPrimaryDark));
            return false;
        }

        if (etWeight.getText().toString().length() == 0) {
            etWeight.setHintTextColor(getResources().getColor(R.color.colorPrimaryDark));
            return false;
        }

        if (etDWeight.getText().toString().length() == 0) {
            etDWeight.setHintTextColor(getResources().getColor(R.color.colorPrimaryDark));
            return false;
        }

        if (etAge.getText().toString().length() == 0) {
            etAge.setHintTextColor(getResources().getColor(R.color.colorPrimaryDark));
            return false;
        }

        if (etNeckCF.getText().toString().length() == 0) {
            etNeckCF.setHintTextColor(getResources().getColor(R.color.colorPrimaryDark));
            return false;
        }

        if (etWaistLine.getText().toString().length() == 0) {
            etWaistLine.setHintTextColor(getResources().getColor(R.color.colorPrimaryDark));
            return false;
        }

        if (isFemaleChecked)
            if (etLoinsCF.getText().toString().length() == 0) {
                etLoinsCF.setHintTextColor(getResources().getColor(R.color.colorPrimaryDark));
                return false;
            }

        return true;
    }
}
