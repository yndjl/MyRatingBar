package com.mgl.myratingbar.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mgl.myratingbar.library.CustomRatingBar;

public class MainActivity extends AppCompatActivity {
    CustomRatingBar customRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customRatingBar = (CustomRatingBar) findViewById(R.id.crb_activity_base_sercive_record_evaluationRatingBar);
        customRatingBar.new Builder(this).starImageSize(35).clickable(true).dragable(false).initSelectValue(1.5f).starCount(6).starMargin(10).valueOfEveryStar(3).stepWay(CustomRatingBar.STEP_HALF).build();
    }
}
