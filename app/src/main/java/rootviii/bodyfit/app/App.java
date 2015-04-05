package rootviii.bodyfit.app;

import android.app.Application;
import android.content.Context;
import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by andrii on 05.04.15.
 */
public class App extends Application {
    public static final String TAG = App.class.getSimpleName();

    private static App app;
    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        this.setAppContext(getApplicationContext());
//        ParseObject.registerSubclass(ChequeDebt.class);
        Parse.initialize(this, "2pmagJ0Wq1qGCzRB6ISL9bG6ph2t2yisE7L92i2e", "EfFtWHNKwaPKMFPq56hiwZYElxcaCjxuuo6jfC67");
    }

    public static App getInstance() {
        return app;
    }

    public static Context getAppContext() {
        return appContext;
    }

    public void setAppContext(Context mAppContext) {
        this.appContext = mAppContext;
    }
}
