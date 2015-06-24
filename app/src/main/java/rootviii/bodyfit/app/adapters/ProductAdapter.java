package rootviii.bodyfit.app.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rootviii.bodyfit.app.R;


/**
 * Created by Daryna on 28.05.2015.
 */
public class ProductAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> names;
    private ArrayList<Integer> counts;

    public ProductAdapter(Context context, ArrayList<String> names, ArrayList<Integer> counts) {
        this.context=context;
this.names=names;
        this.counts=counts;
    }


    public static class ViewHolder {
        public TextView tvName;
        public TextView tvAmount;

        public ViewHolder(View view) {
            tvName = (TextView) view.findViewById(android.R.id.text1);
            tvAmount = (TextView) view.findViewById(android.R.id.text2);
        }
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public String getItem(int i) {
        return names.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if (view == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            view = inflater.inflate(android.R.layout.two_line_list_item, null, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }


        holder.tvName.setText(names.get(i));
        holder.tvAmount.setText(counts.get(i));


        return view;
    }
}

