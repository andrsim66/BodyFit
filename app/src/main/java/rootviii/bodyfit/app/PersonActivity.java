package rootviii.bodyfit.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * Created by voronsky on 4/4/2015.
 */
public class PersonActivity extends ActionBarActivity implements View.OnClickListener {

//    String id;
//    double height, weight, dWeight;
//    int age, gender;
//    double neckCF, waistLine, loinsCF, fatPers, musclesPers, waterPers;

    EditText heightET, weightET, dWeightET, ageET, neckCF_ET;
    EditText waistLineET, loinsCF_ET;

    RadioGroup radioGroup;

    LinearLayout loinsCF_ID;

    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_activity);

        heightET = (EditText) findViewById(R.id.heightET);
        weightET = (EditText) findViewById(R.id.weightET);
        dWeightET = (EditText) findViewById(R.id.dWeightET);
        ageET = (EditText) findViewById(R.id.ageET);
        neckCF_ET = (EditText) findViewById(R.id.neckCF_ET);
        waistLineET = (EditText) findViewById(R.id.waistLineET);
        loinsCF_ET = (EditText) findViewById(R.id.loinsCF_ET);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.startButton:
                // OnClick Start button action

                //RadioGroup
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioMale:
                        break;
                    case R.id.radioFemale:
                        loinsCF_ID.setVisibility(View.VISIBLE);
                        break;
                }
                break;
        }
    }
}
