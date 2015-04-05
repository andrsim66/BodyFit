package rootviii.bodyfit.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import rootviii.bodyfit.app.utils.Utils;

/**
 * Created by andrii on 04.04.15.
 */
public class DispatchActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Utils.restoreLoginState(DispatchActivity.this)) {
            Intent intent = new Intent(DispatchActivity.this, DayScheduleActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            Intent intent = new Intent(DispatchActivity.this, PersonActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("category", Utils.restoreCategory(DispatchActivity.this));
            startActivity(intent);
        }
    }
}
