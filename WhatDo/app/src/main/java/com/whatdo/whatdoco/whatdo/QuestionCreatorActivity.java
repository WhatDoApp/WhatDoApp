package com.whatdo.whatdoco.whatdo;

import android.app.Activity;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 7d1fdb6ec3e25aa378b795298ce492bbf5e6a0d2
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
=======
>>>>>>> parent of 9e9d7ac... NavigationDrawer Added to Questions and Question Creator page
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 7d1fdb6ec3e25aa378b795298ce492bbf5e6a0d2
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
=======
>>>>>>> parent of 9e9d7ac... NavigationDrawer Added to Questions and Question Creator page

public class QuestionCreatorActivity extends Activity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_creator);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(getResources()));

        mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new CardAdapter();
        mRecyclerView.setAdapter(mAdapter);
<<<<<<< HEAD
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        List<String> rows = new ArrayList<>();
        rows.add("Option 1");
        rows.add("Option 2: A longer option");
        rows.add("Option 3: The longest option of all");

        com.whatdo.whatdoco.whatdo.DrawerAdapter drawerAdapter = new com.whatdo.whatdoco.whatdo.DrawerAdapter(rows);
        drawerRecyclerView.setAdapter(drawerAdapter);
        drawerRecyclerView.setHasFixedSize(true);
        drawerRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        drawerAdapter.setClickListener(new com.whatdo.whatdoco.whatdo.DrawerAdapter.ClickListener() {
            @Override
            public void onClick(View v, int pos) {
                switch (pos)
                {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), QuestionsActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), MyQuestionsActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), CategoriesActivity.class));
                        break;
                }
            }
        });
<<<<<<< HEAD
=======
>>>>>>> parent of 9e9d7ac... NavigationDrawer Added to Questions and Question Creator page
=======
>>>>>>> 7d1fdb6ec3e25aa378b795298ce492bbf5e6a0d2
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question_creator, menu);
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
