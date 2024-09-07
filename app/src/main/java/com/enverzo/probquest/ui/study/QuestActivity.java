package com.enverzo.probquest.ui.study;

import static com.enverzo.probquest.DBHandler.TIME_IN_SEC;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.enverzo.probquest.DBHandler;
import com.enverzo.probquest.R;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.Map;

public class QuestActivity extends Activity {
    private CircularProgressBar progressBarT1, progressBarT2, progressBarT3, progressBarT4, progressBarT5, progressBarT6, progressBarT7, progressBarT8, progressBarT9, progressBarT10, progressBarT11, progressBarT12;
    private TextView progressTextT1, progressTextT2, progressTextT3, progressTextT4, progressTextT5, progressTextT6, progressTextT7, progressTextT8, progressTextT9, progressTextT10, progressTextT11, progressTextT12;
    private int progressT1, progressT2, progressT3, progressT4, progressT5, progressT6, progressT7, progressT8, progressT9, progressT10, progressT11, progressT12, timeInSec1, timeInSec2, timeInSec3, timeInSec4, timeInSec5, timeInSec6, timeInSec7, timeInSec8, timeInSec9, timeInSec10, timeInSec11, timeInSec12;
    private Map<String, String> studyTime1, studyTime2, studyTime3, studyTime4, studyTime5, studyTime6, studyTime7, studyTime8, studyTime9, studyTime10, studyTime11, studyTime12;
    private ImageView questBack;
    private LinearLayout topic1, topic2, topic3, topic4, topic5, topic6, topic7, topic8, topic9, topic10, topic11, topic12;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);

        dbHandler = new DBHandler(this);

        questBack = findViewById(R.id.questBack);
        topic1 = findViewById(R.id.topic1);
        topic2 = findViewById(R.id.topic2);
        topic3 = findViewById(R.id.topic3);
        topic4 = findViewById(R.id.topic4);
        topic5 = findViewById(R.id.topic5);
        topic6 = findViewById(R.id.topic6);
        topic7 = findViewById(R.id.topic7);
        topic8 = findViewById(R.id.topic8);
        topic9 = findViewById(R.id.topic9);
        topic10 = findViewById(R.id.topic10);
        topic11 = findViewById(R.id.topic11);
        topic12 = findViewById(R.id.topic12);

        progressBarT1 = findViewById(R.id.progressBarT1);
        progressBarT2 = findViewById(R.id.progressBarT2);
        progressBarT3 = findViewById(R.id.progressBarT3);
        progressBarT4 = findViewById(R.id.progressBarT4);
        progressBarT5 = findViewById(R.id.progressBarT5);
        progressBarT6 = findViewById(R.id.progressBarT6);
        progressBarT7 = findViewById(R.id.progressBarT7);
        progressBarT8 = findViewById(R.id.progressBarT8);
        progressBarT9 = findViewById(R.id.progressBarT9);
        progressBarT10 = findViewById(R.id.progressBarT10);
        progressBarT11 = findViewById(R.id.progressBarT11);
        progressBarT12 = findViewById(R.id.progressBarT12);

        progressTextT1 = findViewById(R.id.progressTextT1);
        progressTextT2 = findViewById(R.id.progressTextT2);
        progressTextT3 = findViewById(R.id.progressTextT3);
        progressTextT4 = findViewById(R.id.progressTextT4);
        progressTextT5 = findViewById(R.id.progressTextT5);
        progressTextT6 = findViewById(R.id.progressTextT6);
        progressTextT7 = findViewById(R.id.progressTextT7);
        progressTextT8 = findViewById(R.id.progressTextT8);
        progressTextT9 = findViewById(R.id.progressTextT9);
        progressTextT10 = findViewById(R.id.progressTextT10);
        progressTextT11 = findViewById(R.id.progressTextT11);
        progressTextT12 = findViewById(R.id.progressTextT12);

        int time = 7200;

        studyTime1 = dbHandler.getTopicsId(470);
        studyTime2 = dbHandler.getTopicsId(901);
        studyTime3 = dbHandler.getTopicsId(590);
        studyTime4 = dbHandler.getTopicsId(613);
        studyTime5 = dbHandler.getTopicsId(176);
        studyTime6 = dbHandler.getTopicsId(607);
        studyTime7 = dbHandler.getTopicsId(724);
        studyTime8 = dbHandler.getTopicsId(313);
        studyTime9 = dbHandler.getTopicsId(196);
        studyTime10 = dbHandler.getTopicsId(826);
        studyTime11 = dbHandler.getTopicsId(285);
        studyTime12 = dbHandler.getTopicsId(789);

        Map<String, String> studyTime[] = new Map[]{studyTime1, studyTime2, studyTime3, studyTime4, studyTime5, studyTime6, studyTime7, studyTime8, studyTime9, studyTime10, studyTime11, studyTime12};
        int timeInSec[] = {timeInSec1, timeInSec2, timeInSec3, timeInSec4, timeInSec5, timeInSec6, timeInSec7, timeInSec8, timeInSec9, timeInSec10, timeInSec11, timeInSec12};
        int progress[] = {progressT1, progressT2, progressT3, progressT4, progressT5, progressT6, progressT7, progressT8, progressT9, progressT10, progressT11, progressT12};

        for (int i = 0; i < studyTime.length; i++) {
            if (!studyTime[i].isEmpty()) {
                timeInSec[i] = Integer.parseInt(studyTime[i].get(TIME_IN_SEC));
                progress[i] = (int) (((float) timeInSec[i]/time)*100);
            } else {
                progress[i] = 0;
            }
            if (timeInSec[i] == 7200) {
                timeInSec[i] = 7200;
                progress[i] = (int) (((float) timeInSec[i]/time)*100);
            }
        }

        CircularProgressBar progressBar[] ={progressBarT1, progressBarT2, progressBarT3, progressBarT4, progressBarT5, progressBarT6, progressBarT7, progressBarT8, progressBarT9, progressBarT10, progressBarT11, progressBarT12};

        for (int i = 0; i < progressBar.length; i++) {
            progressBar[i].setProgressMax(100f);
            progressBar[i].setProgress(progress[i]);
        }

        TextView progressText[] = {progressTextT1, progressTextT2, progressTextT3, progressTextT4, progressTextT5, progressTextT6, progressTextT7, progressTextT8, progressTextT9, progressTextT10, progressTextT11, progressTextT12};

        for (int i = 0; i < progressText.length; i++) {
            if (progress[i] >= 100) {
                progress[i] = 100;
                progressText[i].setText(String.valueOf(progress[i]) + "%");
            } else {
                progressText[i].setText(String.valueOf(progress[i]) + "%");
            }
        }

//        if (!studyTime1.isEmpty()) {
//            int timeInSec1 = Integer.parseInt(studyTime1.get(TIME_IN_SEC));
//            progressT1 = (int) (((float) timeInSec1/time)*100);
//        }
//        if (!studyTime2.isEmpty()) {
//            int timeInSec2 = Integer.parseInt(studyTime2.get(TIME_IN_SEC));
//            progressT2 = (int) (((float) timeInSec2/time)*100);
//        }
//        if (!studyTime3.isEmpty()) {
//            int timeInSec3 = Integer.parseInt(studyTime3.get(TIME_IN_SEC));
//            progressT3 = (int) (((float) timeInSec3/time)*100);//10800
//        }
//        if (!studyTime4.isEmpty()) {
//            int timeInSec4 = Integer.parseInt(studyTime4.get(TIME_IN_SEC));
//            progressT4 = (int) (((float) timeInSec4/time)*100);//10800
//        }
//        if (!studyTime5.isEmpty()) {
//            int timeInSec5 = Integer.parseInt(studyTime5.get(TIME_IN_SEC));
//            progressT5 = (int) (((float) timeInSec5/time)*100);
//        }
//        if (!studyTime6.isEmpty()) {
//            int timeInSec6 = Integer.parseInt(studyTime6.get(TIME_IN_SEC));
//            progressT6 = (int) (((float) timeInSec6/time)*100);
//        }
//        if (!studyTime7.isEmpty()) {
//            int timeInSec7 = Integer.parseInt(studyTime7.get(TIME_IN_SEC));
//            progressT7 = (int) (((float) timeInSec7/time)*100);
//        }
//        if (!studyTime8.isEmpty()) {
//            int timeInSec8 = Integer.parseInt(studyTime8.get(TIME_IN_SEC));
//            progressT8 = (int) (((float) timeInSec8/time)*100);
//        }
//        if (!studyTime9.isEmpty()) {
//            int timeInSec9 = Integer.parseInt(studyTime9.get(TIME_IN_SEC));
//            progressT9 = (int) (((float) timeInSec9/time)*100);
//        }
//        if (!studyTime1.isEmpty()) {
//            int timeInSec10 = Integer.parseInt(studyTime10.get(TIME_IN_SEC));
//            progressT10 = (int) (((float) timeInSec10/time)*100);
//        }
//        if (!studyTime11.isEmpty()) {
//            int timeInSec11 = Integer.parseInt(studyTime11.get(TIME_IN_SEC));
//            progressT11 = (int) (((float) timeInSec11/time)*100);
//        }
//        if (!studyTime12.isEmpty()) {
//            int timeInSec12 = Integer.parseInt(studyTime12.get(TIME_IN_SEC));
//            progressT12 = (int) (((float) timeInSec12/time)*100);
//        }

//        progressBarT1.setProgressMax(100f);
//        progressBarT1.setProgress(58);
//        progressBarT2.setProgressMax(100f);
//        progressBarT2.setProgress(31);
//        progressBarT3.setProgressMax(100f);
//        progressBarT3.setProgress(20);
//        progressBarT4.setProgressMax(100f);
//        progressBarT4.setProgress(67);
//        progressBarT5.setProgressMax(100f);
//        progressBarT5.setProgress(95);
//        progressBarT6.setProgressMax(100f);
//        progressBarT6.setProgress(progressT6);
//        progressBarT7.setProgressMax(100f);
//        progressBarT7.setProgress(progressT7);
//        progressBarT8.setProgressMax(100f);
//        progressBarT8.setProgress(progressT8);
//        progressBarT9.setProgressMax(100f);
//        progressBarT9.setProgress(progressT9);
//        progressBarT10.setProgressMax(100f);
//        progressBarT10.setProgress(progressT10);
//        progressBarT11.setProgressMax(100f);
//        progressBarT11.setProgress(progressT11);
//        progressBarT12.setProgressMax(100f);
//        progressBarT12.setProgress(progressT12);
//
//        progressTextT1.setText(String.valueOf(58) + "%");
//        progressTextT2.setText(String.valueOf(31) + "%");
//        progressTextT3.setText(String.valueOf(20) + "%");
//        progressTextT4.setText(String.valueOf(67) + "%");
//        progressTextT5.setText(String.valueOf(95) + "%");
//        progressTextT6.setText(String.valueOf(progressT6) + "%");
//        progressTextT7.setText(String.valueOf(progressT7) + "%");
//        progressTextT8.setText(String.valueOf(progressT8) + "%");
//        progressTextT9.setText(String.valueOf(progressT9) + "%");
//        progressTextT10.setText(String.valueOf(progressT10) + "%");
//        progressTextT11.setText(String.valueOf(progressT11) + "%");
//        progressTextT12.setText(String.valueOf(progressT12) + "%");

        questBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        LinearLayout[] linearLayouts = {topic1, topic2, topic3, topic4, topic5, topic6, topic7, topic8, topic9, topic10, topic11, topic12};

        for (int i = 0; i < linearLayouts.length; i++) {
            int finalI = i;
            linearLayouts[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (finalI == 0) {
                        Intent intent = new Intent(QuestActivity.this, TopicOneActivity.class);
                        startActivity(intent);
                    } else if (finalI == 1) {
                        Intent intent = new Intent(QuestActivity.this, TopicTwoActivity.class);
                        startActivity(intent);
                    } else if (finalI == 2) {
                        Intent intent = new Intent(QuestActivity.this, TopicThreeActivity.class);
                        startActivity(intent);
                    } else if (finalI == 3) {
                        Intent intent = new Intent(QuestActivity.this, TopicFourActivity.class);
                        startActivity(intent);
                    } else if (finalI == 4) {
                        Intent intent = new Intent(QuestActivity.this, TopicFiveActivity.class);
                        startActivity(intent);
                    } else if (finalI == 5) {
                        Intent intent = new Intent(QuestActivity.this, TopicSixActivity.class);
                        startActivity(intent);
                    } else if (finalI == 6) {
                        Intent intent = new Intent(QuestActivity.this, TopicSevenActivity.class);
                        startActivity(intent);
                    } else if (finalI == 7) {
                        Intent intent = new Intent(QuestActivity.this, TopicEightActivity.class);
                        startActivity(intent);
                    } else if (finalI == 8) {
                        Intent intent = new Intent(QuestActivity.this, TopicNineActivity.class);
                        startActivity(intent);
                    } else if (finalI == 9) {
                        Intent intent = new Intent(QuestActivity.this, TopicTenActivity.class);
                        startActivity(intent);
                    } else if (finalI == 10) {
                        Intent intent = new Intent(QuestActivity.this, TopicElevenActivity.class);
                        startActivity(intent);
                    } else if (finalI == 11) {
                        Intent intent = new Intent(QuestActivity.this, TopicTwelveActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }
}
