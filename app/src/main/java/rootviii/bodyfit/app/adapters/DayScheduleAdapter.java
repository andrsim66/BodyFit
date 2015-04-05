package rootviii.bodyfit.app.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import rootviii.bodyfit.app.R;
import rootviii.bodyfit.app.pojo.BTask;
import rootviii.bodyfit.app.utils.Utils;

import java.util.List;

/**
 * Created by andrii on 04.04.15.
 */
public class DayScheduleAdapter extends ArrayAdapter<BTask> {

    private Context mContext;
    private int mLayoutResourceId;
    private List<BTask> mBTasks;

    public DayScheduleAdapter(Context context, int layoutResourceId, List<BTask> bTasks) {
        super(context, layoutResourceId, bTasks);
        this.mContext = context;
        this.mBTasks = bTasks;
        this.mLayoutResourceId = layoutResourceId;
    }

    public static class ViewHolder {
        public ImageView ivIcon;
        public TextView tvName;
        public TextView tvAmount;
        public TextView tvStart;
        public TextView tvFinish;

        public ViewHolder(View view) {
            ivIcon = (ImageView) view.findViewById(R.id.iv_btask_item_icon);
            tvName = (TextView) view.findViewById(R.id.tv_btask_item_name);
            tvAmount = (TextView) view.findViewById(R.id.tv_btask_item_amount);
            tvStart = (TextView) view.findViewById(R.id.tv_btask_item_start);
            tvFinish = (TextView) view.findViewById(R.id.tv_btask_item_finish);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(mLayoutResourceId, null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        BTask bTask = getItem(position);

        holder.ivIcon.setImageDrawable(mContext.getResources().getDrawable(
                Utils.getItemResourseId(bTask.getType())));

        holder.tvName.setText(Utils.getTaskName(bTask.getType()));
        if (bTask.getType() == 1 || bTask.getType() == 2) {
            holder.tvAmount.setVisibility(View.VISIBLE);
            holder.tvAmount.setText("" + bTask.getAmount());
        } else {
            holder.tvAmount.setVisibility(View.GONE);
        }
        holder.tvStart.setText(Utils.formatTime(bTask.getStartTime()));
        holder.tvFinish.setText(Utils.formatTime(bTask.getFinishTime()));

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public BTask getItem(int position) {
        return mBTasks.get(position);
    }
}
