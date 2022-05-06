package com.example.fragmentjavaintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.FirstListener, SecondFragment.SecondListener {
    FirstFragment firstFragment;
    SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    @Override
    public void onFirstSend(User user) {
        secondFragment.updateSecondText(String.valueOf(user));
    }

    @Override
    public void onSecondSend(User user) {
        firstFragment.updateFirstText(String.valueOf(user));
    }

    void initViews(){
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameFirst,firstFragment)
                .replace(R.id.frameSecond,secondFragment)
                .commit();
    }
}