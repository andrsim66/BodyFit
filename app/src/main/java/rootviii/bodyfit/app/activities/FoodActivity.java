package rootviii.bodyfit.app.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import rootviii.bodyfit.app.R;
import rootviii.bodyfit.app.adapters.ProductAdapter;
import rootviii.bodyfit.app.utils.DBHelper;



public class FoodActivity extends ActionBarActivity implements OnClickListener  {

    private Toolbar mToolbar;
    Button btnSave, btnAdd;
    EditText etCount;
    AutoCompleteTextView etKind;
    DBHelper dbHelper;
    ListView listProduct;
    ArrayList<String> kindlist, product_in_list;
    ArrayList<Integer> countlist;
    String kind, count;
    ArrayAdapter adapter1, adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
        btnSave = (Button)findViewById(R.id.saveButton);
        btnAdd = (Button)findViewById(R.id.addButton);
        etKind = (AutoCompleteTextView)findViewById(R.id.kind);
        etCount = (EditText)findViewById(R.id.count);
        listProduct = (ListView) findViewById(R.id.list_of_product);

        btnAdd.setOnClickListener(this);
        btnSave.setOnClickListener(this);

        kindlist = new ArrayList<String>();
        countlist = new ArrayList<Integer>();
        product_in_list = new ArrayList<String>();
        kindlist.add("banana");
        kindlist.add("bread");
        kindlist.add("chicken");
        kindlist.add("tomato");


        adapter1 = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, kindlist );

        adapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, product_in_list);
        etKind.setAdapter(adapter1);
        listProduct.setAdapter(adapter2);

        /*dbHelper = new DBHelper(this);
        SQLiteDatabase sqldb = dbHelper.getWritableDatabase();*/

        // присваиваем адаптер списку
        //DBHelper dbHelper = new DBHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_food, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.addButton:
                kind = etKind.getText().toString();
                //count = etCount.getText().toString();
                product_in_list.add(kind);
                //countlist.add(Integer.parseInt(count));
                etKind.setText("");
                etCount.setText("");
                //countlist.add(Integer.parseInt(count));
                listProduct.setAdapter(adapter2);
                adapter2.notifyDataSetChanged();
                break;
            case R.id.saveButton:
                //startActivity(new Intent(FoodActivity.this, DayScheduleActivity.class));
                break;
        }
       /*
        // создаем объект для данных
        ContentValues cv = new ContentValues();

        // получаем данные из полей ввода
        String kind = etKind.getText().toString();
        String count = etCount.getText().toString();
        // подключаемся к БД
        SQLiteDatabase db = dbHelper.getWritableDatabase();
               /* // подготовим данные для вставки в виде пар: наименование столбца - значение
                cv.put("name", name);
                cv.put("email", email);
                // вставляем запись и получаем ее ID
                long rowID = db.insert("mytable", null, cv);*/

        }
        // закрываем подключение к БД
       // dbHelper.close();*/
    }
