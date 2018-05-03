package com.mgl.myratingbar.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mgl.myratingbar.library.CustomRatingBar;

public class MainActivity extends AppCompatActivity {
    CustomRatingBar customRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customRatingBar = (CustomRatingBar) findViewById(R.id.crb_activity_base_sercive_record_evaluationRatingBar);
        customRatingBar.new Builder(this).starImageSize(35).clickable(false).dragable(true).initSelectValue(1.5f).starCount(5).starMargin(10).valueOfEveryStar(1).stepWay(CustomRatingBar.STEP_HALF).build();
        customRatingBar.setOnRealTimeEvaluationScoreChangeListener(new CustomRatingBar.OnRealTimeEvaluationScoreChangeListener() {
            @Override
            public void getRealTimeEvaluationScore(float score,float starNum) {
                Toast.makeText(MainActivity.this, "分数:  " + score, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
