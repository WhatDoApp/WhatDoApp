package com.whatdo.whatdoco.whatdo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginClick(View view) {
        Intent mainIntent = new Intent(this, QuestionsActivity.class);
        startActivity(mainIntent);
    }

    public void registerClick(View view){
        Intent mainIntent = new Intent(this, RegistrationActivity.class);
        startActivity(mainIntent);
    }
}
