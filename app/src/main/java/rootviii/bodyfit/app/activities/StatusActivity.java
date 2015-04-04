package rootviii.bodyfit.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import rootviii.bodyfit.app.R;

/**
 * Created by andrii on 04.04.15.
 */
public class StatusActivity extends ActionBarActivity implements View.OnClickListener {

    private Button bStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        initViews();
        setupViews();
    }

    private void initViews() {
        bStart = (Button) findViewById(R.id.b_start);
    }

    private void setupViews() {
        bStart.setOnClickListener(this);
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
