package rootviii.bodyfit.app.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;
import rootviii.bodyfit.app.pojo.BTask;

import java.util.ArrayList;

/**
 * Created by andrii on 04.04.15.
 */
public class DayScheduleAdapter extends ArrayAdapter<BTask> {
    public DayScheduleAdapter(Context context, int resource) {
        super(context, resource);
    }
}
