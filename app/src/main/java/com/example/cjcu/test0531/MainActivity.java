package com.example.cjcu.test0531;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private MyDBHelper helper;
    private RecyclerView recyclerView;

    @Override
    protected void onRestart() {
        super.onRestart();
        list = findViewById(R.id.list);
        helper = new MyDBHelper(this,"my.db",null,1);
        @SuppressLint("Recycle") Cursor c = helper.getReadableDatabase()
                .query("exp",null,null,null,null,null,null);
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_expandable_list_item_2,
                c,
                new String[] {"info","amount"},
                new int[] {android.R.id.text1,android.R.id.text2},
                1);
        list.setAdapter(simpleCursorAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //mylist();
        myview();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
    }

    private void mylist() {
        list = findViewById(R.id.list);
        helper = new MyDBHelper(this,"my.db",null,1);
        Cursor c = helper.getReadableDatabase()
                .query("exp",null,null,null,null,null,null);
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_expandable_list_item_2,
                c,
                new String[] {"info","amount"},
                new int[] {android.R.id.text1,android.R.id.text2},
                1);
        list.setAdapter(simpleCursorAdapter);
    }
private  void  myview(){
    recyclerView = findViewById(R.id.recycleview);
    helper = new MyDBHelper(this,"my.db",null,1);
    Cursor c = helper.getReadableDatabase()
            .query("exp",null,null,null,null,null,null);

    List<person>  trans = new ArrayList <>();
if (c.moveToFirst()){
    do{
        person p=new person();
        p.setCdate(c.getString(c.getColumnIndex("cdate")));
        p.setInfo(c.getString(c.getColumnIndex("info")));
        p.setAmount(c.getString(c.getColumnIndex("amount")));
    }while (c.moveToNext());
}

     TransctionAdapter adapter = new TransctionAdapter(trans)   ;

    recyclerView.setAdapter(adapter);

    recyclerView.setLayoutManager(new LinearLayoutManager(this));

}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
