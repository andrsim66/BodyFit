package rootviii.bodyfit.app.utils;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by Daryna on 27.05.2015.
 */
public class DBHelper extends SQLiteOpenHelper {


    public static final String TABLE_FOOD = "food";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PROTEIN = "protein";
    public static final String COLUMN_LIPID = "lipid";
    public static final String COLUMN_CARBOHYDRATE = "carbohydrate";
    public static final String COLUMN_CAL = "cal";

    private static final String DATABASE_NAME = "myDB.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        // конструктор суперкласса
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // создаем таблицу с полями
        db.execSQL("create table"+TABLE_FOOD+ "("
                +COLUMN_ID+ "integer primary key autoincrement,"
                +COLUMN_NAME+ "text not null,"
                +COLUMN_PROTEIN+ "integer,"
                +COLUMN_LIPID+ "integer,"
                +COLUMN_CARBOHYDRATE+ "integer,"
                +COLUMN_CAL+ "integer" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

