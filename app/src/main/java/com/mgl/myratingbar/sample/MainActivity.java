package com.mgl.myratingbar.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mgl.myratingbar.library.CustomRatingBarBuilder;

public class MainActivity extends AppCompatActivity {
    CustomRatingBarBuilder customRatingBarBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
