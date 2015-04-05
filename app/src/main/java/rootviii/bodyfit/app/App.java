package rootviii.bodyfit.app;

import android.app.Application;
import android.content.Context;
import com.parse.Parse;
import com.parse.ParseObject;
import rootviii.bodyfit.app.pojo.BTask;
import rootviii.bodyfit.app.pojo.Person;

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
        ParseObject.registerSubclass(Person.class);
        ParseObject.registerSubclass(BTask.class);
        Parse.initialize(this, "H9mWYRjwu8K5XDLUM3JvbxSq1TUq7V7IXgWeDAoE", "Nvctka9k8YaURG5V64RAbrd085wGbZYjzUCo7qF1");
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
