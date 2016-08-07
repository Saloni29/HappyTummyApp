package com.salonikathuria.happytummyapp.Activity;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.salonikathuria.happytummyapp.R;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent intent=getIntent();
        if(intent.ACTION_SEARCH.equals(intent.getAction()))
        {
            String query=intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }
    }

    private void doMySearch(String query) {

        Toast.makeText(this , query, Toast.LENGTH_LONG).show();
    }

}
