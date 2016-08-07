package com.salonikathuria.happytummyapp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.salonikathuria.happytummyapp.R;

public class SplashScreenActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread splashScreen= new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);

                    String name= prefs.getString("username" , null);
                    String password=prefs.getString("password" , null);

                    if(name != null && password!=null){

                        Intent intent= new Intent(getApplicationContext() , HomeScreenActivity.class);
                        startActivity(intent);
                        finish();

                    }
                    else{
                    Intent intent= new Intent(getApplicationContext() , LoginActivity.class);
                    startActivity(intent);
                    finish();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        splashScreen.start();
    }
}
