package com.salonikathuria.happytummyapp.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.salonikathuria.happytummyapp.R;

public class LoginActivity extends AppCompatActivity {

    Button mLoginButton;
    EditText mUsername;
    EditText mPassword;
    TextView mSignUp;


    //private static final String TAG = "LoginActivity";
    public static final String MyPREFERENCES = "MyPrefs" ;

    public static final String USERNAME ="username";
    public static final String PASSWORD ="password";


    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginButton=(Button)findViewById(R.id.loginButton);
        mUsername=(EditText)findViewById(R.id.usernameEditText);
        mPassword=(EditText)findViewById(R.id.passwordEditText);

        final Animation animAlpha= AnimationUtils.loadAnimation(this, R.anim.button_anim);

        sharedpreferences =getApplicationContext().getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);


        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final ProgressDialog progressDialog= new ProgressDialog(LoginActivity.this );
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Authenticating...");
                progressDialog.show();
                //login();
                String username= mUsername.getText()+"";
                String password=mPassword.getText()+"";

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(USERNAME , username);
                editor.putString(PASSWORD , password);
                editor.commit();

                Toast.makeText(LoginActivity.this,"Thanks, " + username +"", Toast.LENGTH_LONG).show();

                Thread delay= new Thread(){
                    @Override
                    public void run() {
                        try {
                            sleep(3000);
                            progressDialog.dismiss();
                            Intent intent= new Intent();
                            intent.setClass(LoginActivity.this , HomeScreenActivity.class);
                            intent.putExtra(USERNAME , sharedpreferences.getString(USERNAME , null));
                            startActivityForResult(intent , 1);



                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };

                delay.start();
            }
        });

        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this , SignUpActivity.class);
                startActivity(intent);
            }
        });

    }



}
