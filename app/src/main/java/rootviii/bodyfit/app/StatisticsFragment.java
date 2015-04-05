package rootviii.bodyfit.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by andrii on 05.04.15.
 */
public class StatisticsFragment extends Fragment {

    public static StatisticsFragment newInstance(int tabPos) {
        StatisticsFragment fragment = new StatisticsFragment();
        Bundle args = new Bundle();
//        args.putInt(ARG_PARAM_TAB_POS, tabPos);
//        fragment.setArguments(args);
        return fragment;
    }

    public StatisticsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (getArguments() != null) {
//            mTabPos = getArguments().getInt(ARG_PARAM_TAB_POS);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_statistics, container, false);


        return view;
    }
}
