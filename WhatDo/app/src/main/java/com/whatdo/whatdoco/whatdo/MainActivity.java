package android_class.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    GetUserData user;
    RegisterUser registerUser;
    AddCategoriesToUser addCategoriesToUser;
    GetQuestionsBatch getQuestionsBatch;
    FavouriteQuestion favouriteQuestion;
    AskQuestion askQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> categories = new ArrayList<String>();
        categories.add("Technology");
//        getQuestionsBatch = new GetQuestionsBatch("5749328048029696", this);
//        getQuestionsBatch.execute();
//        addCategoriesToUser = new AddCategoriesToUser("5749328048029696", categories);
//        addCategoriesToUser.execute();
//        favouriteQuestion = new FavouriteQuestion("5749328048029696", "5654313976201216");
//        favouriteQuestion.execute();
        askQuestion = new AskQuestion("5749328048029696", "This is the newest question", "5634472569470976");
        askQuestion.execute();
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
