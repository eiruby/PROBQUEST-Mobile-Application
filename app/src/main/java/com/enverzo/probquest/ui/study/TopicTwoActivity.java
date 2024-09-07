package com.enverzo.probquest.ui.study;

import static com.enverzo.probquest.DBHandler.TIME_IN_SEC;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomControls;

import com.enverzo.probquest.DBHandler;
import com.enverzo.probquest.R;

import java.util.Map;

import ru.noties.jlatexmath.JLatexMathDrawable;
import ru.noties.jlatexmath.JLatexMathView;

public class TopicTwoActivity extends AppCompatActivity {
    private ImageView t2Back, t2ActFeedback, t2Menu;
    private TextView t2TextViewTitle1, t2TextViewTitle2, t2TextViewTitle3, t2TextViewTitle4, t2TextView1, t2TextView2, t2TextView3, t2TextView4, t2TextView5, t2TextView6, t2ActScore, t2ActDirection, t2ActQuestion, t2ActSolText;
    private JLatexMathView t2ActAns;
    private EditText t2ActAnswer;
    private ActivityQuestions activityQuestions = new ActivityQuestions();
    private int t2ActQuesLength = activityQuestions.t2ActQuestions.length;
    private String ansCaps, ansLow, ans1, ans2, ans3, ans4, ans5, ans6, ans7, ans8, ans9;
    private ZoomControls t2ZoomControls;
    private ScrollView t2ScrollView;
    private Button t2ActStart, t2ActSubmit, saveAns;
    private LinearLayout t2ActLayout, t2ActAnsLayout;
    private int textSize = 16, score, currentIndex, scoreValue;
    private long startTime2, endTime2;
    private boolean nextQuestion = false;
    private static final String PREFS_FILE_NAME = "ActivityScore";
    private static final String KEY_SCORE = "score";
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_two);

        dbHandler = new DBHandler(this);

        t2Back = findViewById(R.id.t2Back);
        t2TextViewTitle1 = findViewById(R.id.t2TextViewTitle1);
        t2TextViewTitle2 = findViewById(R.id.t2TextViewTitle2);
        t2TextViewTitle3 = findViewById(R.id.t2TextViewTitle3);
        t2TextViewTitle4 = findViewById(R.id.t2TextViewTitle4);
        t2TextView1 = findViewById(R.id.t2TextView1);
        t2TextView2 = findViewById(R.id.t2TextView2);
        t2TextView3 = findViewById(R.id.t2TextView3);
        t2TextView4 = findViewById(R.id.t2TextView4);
        t2TextView5 = findViewById(R.id.t2TextView5);
        t2TextView6 = findViewById(R.id.t2TextView6);
        t2ZoomControls = findViewById(R.id.t2ZoomControls);
        t2Menu = findViewById(R.id.t2Menu);
        t2ScrollView = findViewById(R.id.t2ScrollView);
        t2ActStart = findViewById(R.id.t2ActStart);
        t2ActScore = findViewById(R.id.t2ActScore);
        t2ActDirection = findViewById(R.id.t2ActDirection);
        t2ActLayout = findViewById(R.id.t2ActLayout);
        t2ActAnswer = findViewById(R.id.t2ActAnswer);
        t2ActFeedback = findViewById(R.id.t2ActFeedback);
        t2ActQuestion = findViewById(R.id.t2ActQuestion);
        t2ActSubmit = findViewById(R.id.t2ActSubmit);
        t2ActAns = findViewById(R.id.t2ActAns);
        t2ActAnsLayout = findViewById(R.id.t2ActAnsLayout);
        t2ActSolText = findViewById(R.id.t2ActSolText);

        startTime2 = System.currentTimeMillis();

        String t2TextViewFormat2 = "One of the basic concepts to understand in the study of probability is the event. An <b><i>event</i></b> is a subset of a <b><i>sample space</i></b> while a sample space is the set of all possible outcomes of an experiment. An event may contain some, all, or none of the possible outcomes comprising the sample space.<br><br>For example, in an experiment of tossing a coin, the event (E) of getting a head is E = {H} and the sample space (S) is S = {H, T}<br><br>In an experiment of rolling a fair die, the event of getting an even number is E = {2, 4, 6} and the sample space (S) is S = {1, 2, 3, 4, 5, 6}<br><br>In an experiment of rolling a die and tossing a coin,<br><br>an event of getting an odd number and a tail is E = {1T, 3T, 5T}<br>and the sample space (S) is E = {1T, 2T, 3T, 4T, 5T, 6T 1H, 2H, 3H, 4H, 5H, 6H}<br><br>An event may be a simple event or compound event. A <b><i>simple event</i></b> refers to an event with a single outcome while a <b><i>compound event</i></b> is any event combining two or more simple events. When a single coin is tossed, the event where a tail appears is a simple event. If the same coin is tossed twice, the event that at least one head appears is a compound event. Let us consider the following examples on how these two events, the simple and compound, differ from each other.<br><br><b>DIFFERENCE OF SIMPLE AND COMPOUND EVENTS</b><br><br><b>Simple Events</b>";
        String t2TextViewFormat3 = "1. The probability of rolling a “3” on a die.<br><br><i><u>One event:</u></i> rolling a “3” on a die<br><br>" +
                "2. The probability of rolling an even number less than 4 on a die.<br><br><i><u>One event:</u></i> rolling an even number less than 4 on a die<br><br>" +
                "3. The probability of getting a head in tossing the coin once.<br><br><i><u>One event:</u></i> getting a head in tossing the coin<br><br>" +
                "4. The probability of drawing a heart from a standard deck of cards.<br><br><i><u>One event:</u></i> drawing a  heart from a standard deck of cards<br><br>" +
                "5. The probability of flipping a tail on a coin<br><br><i><u>One event:</u></i> flipping a tail on a coin";
        String t2TextViewFormat5 = "1. The probability of rolling a “5” on a die, then tossing a head in a coin.<br><br><i><u>One event:</u></i> rolling a “5” on a die<br><i><u>Another event:</u></i> tossing a head in a coin<br><br>" +
                "2. The probability of rolling an even number on a die or a prime number greater than 2.<br><br><i><u>One event:</u></i> rolling an even number on a die<br><i><u>Another event:</u></i> rolling a prime number greater than two on a die<br><br>" +
                "3. The probability that at least one head is obtained when a coin is thrown three times.<br><br><i><u>One event:</u></i> getting a head when a coin tossed for the 1st time<br><i><u>Second event:</u></i> getting another head when a coin tossed for the 2nd time<br><i><u>Third event:</u></i> getting another head when a coin tossed for the 3rd time<br><br>" +
                "4. The probability of drawing a heart from a standard deck of cards, replacing the card, then drawing a spade.<br><br><i><u>One event:</u></i> drawing a heart from a standard deck of cards<br><i><u>Another event:</u></i> drawing a spade from a standard deck of cards<br><br>" +
                "5. The probability of flipping a tail on a coin and pulling a queen from a standard deck of cards.<br><br><i><u>One event:</u></i> flipping a tail on a coin<br><i><u>Another event:</u></i> pulling a queen from a standard deck of cards";
        String t2TextViewFormat6 = "Furthermore, an event that can be described in terms of the union, intersection, or complement of events is called a <b>compound event</b>.";

        TextView[] textViewHtml = {t2TextView2, t2TextView3, t2TextView5, t2TextView6};
        String[] textViewFormat = {t2TextViewFormat2, t2TextViewFormat3, t2TextViewFormat5, t2TextViewFormat6};

        for (int i = 0; i < textViewHtml.length; i++) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i], Html.FROM_HTML_MODE_COMPACT));
            } else {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i]));
            }
        }

        loadScore();
        t2ActScore.setText("Score: " + scoreValue + "/" + t2ActQuesLength);

        t2Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t2Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuDialog();
            }
        });

        TextView[] textViewTitle = new TextView[]{t2TextViewTitle1, t2TextViewTitle2, t2TextViewTitle3, t2TextViewTitle4};
        TextView[] textView = new TextView[]{t2TextView1, t2TextView2, t2TextView3, t2TextView4, t2TextView5, t2TextView6};

        t2ZoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textSize == 16) {
                    textSize = textSize + 2;
                    for (int i = 0; i < textView.length; i++) {
                        textView[i].setTextSize(textSize);
                    }
                    for (int i = 0; i < textViewTitle.length; i++) {
                        textViewTitle[i].setTextSize(20);
                    }
                } else if (textSize == 18) {
                    textSize = textSize + 2;
                    for (int i = 0; i < textView.length; i++) {
                        textView[i].setTextSize(textSize);
                    }
                    for (int i = 0; i < textViewTitle.length; i++) {
                        textViewTitle[i].setTextSize(22);
                    }
                }
            }
        });

        t2ZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textSize == 20) {
                    textSize = textSize - 2;
                    for (int i = 0; i < textView.length; i++) {
                        textView[i].setTextSize(textSize);
                    }
                    for (int i = 0; i < textViewTitle.length; i++) {
                        textViewTitle[i].setTextSize(20);
                    }
                } else if (textSize == 18) {
                    textSize = textSize - 2;
                    for (int i = 0; i < textView.length; i++) {
                        textView[i].setTextSize(textSize);
                    }
                    for (int i = 0; i < textViewTitle.length; i++) {
                        textViewTitle[i].setTextSize(18);
                    }
                }
            }
        });

        t2ActStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2ActLayout.setVisibility(View.VISIBLE);
                t2ActStart.setVisibility(View.GONE);
                t2ActAnsLayout.setVisibility(View.VISIBLE);
                t2ActSolText.setVisibility(View.GONE);
                t2ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(10).build());
                String actDirectionFormat = "Tell whether each event is a simple or a compound event. Write <b>S</b> if it is a simple event and <b>C</b> if it is a compound event.";
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    t2ActDirection.setText(Html.fromHtml(actDirectionFormat, Html.FROM_HTML_MODE_COMPACT));
                } else {
                    t2ActDirection.setText(Html.fromHtml(actDirectionFormat));
                }
                t2ActFeedback.setImageDrawable(null);
                t2ActAnswer.setEnabled(true);
                t2ActAnswer.setText("");
                t2ActSubmit.setText("Submit");
                t2ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));

                currentIndex = 0;
                score = 0;
                nextQuestion = false;

                generateQuestions();
            }
        });

        t2ActSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nextQuestion == false) {
                    String enteredAnswer = t2ActAnswer.getText().toString();
                    if (enteredAnswer.isEmpty()) {
                        Toast.makeText(TopicTwoActivity.this, "Please answer the question", Toast.LENGTH_SHORT).show();
                    } else {
                        nextQuestion = true;
                        t2ActSubmit.setText("Next");
                        t2ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.black));
                        t2ActAnswer.setEnabled(false);
                        t2ActSolText.setVisibility(View.VISIBLE);
                        t2ActAns.setLatexDrawable(JLatexMathDrawable.builder(ansCaps).textSize(50).background(0xFFb0d6f5).padding(10).build());
                        if (enteredAnswer.equals(ansCaps) || enteredAnswer.equals(ansLow)) {
                            t2ActFeedback.setImageResource(R.drawable.round_check_24);
                            score++;
                        } else {
                            t2ActFeedback.setImageResource(R.drawable.round_clear_24);
                        }
                    }
                } else {
                    currentIndex++;
                    if (currentIndex < t2ActQuesLength) {
                        generateQuestions();
                        nextQuestion = false;
                        t2ActSolText.setVisibility(View.GONE);
                        t2ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(10).build());
                        t2ActSubmit.setText("Submit");
                        t2ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                        t2ActAnswer.setEnabled(true);
                        t2ActFeedback.setImageDrawable(null);
                        t2ActAnswer.setText("");
                    } else {
                        showScore();
                    }
                }
            }
        });

    }

    private void generateQuestions() {
        t2ActQuestion.setText(activityQuestions.getT2ActQuestion(currentIndex));
        ansCaps = activityQuestions.getT2CorrectAnsCaps(currentIndex);
        ansLow = activityQuestions.getT2CorrectAnsLow(currentIndex);
    }

    private void showScore() {
        t2ActLayout.setVisibility(View.GONE);
        t2ActSubmit.setVisibility(View.GONE);
        t2ActAnsLayout.setVisibility(View.GONE);
        t2ActStart.setVisibility(View.VISIBLE);
        t2ActStart.setText("Try Again");

        String actDirectionFormat = "Activity Complete!<br>Your score is <b>" + score + "</b> out of 10.";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            t2ActDirection.setText(Html.fromHtml(actDirectionFormat, Html.FROM_HTML_MODE_COMPACT));
        } else {
            t2ActDirection.setText(Html.fromHtml(actDirectionFormat));
        }

        t2ActScore.setText("Score: " + score + "/10");
        storeScore(score);
    }

    private void storeScore(int activityScore) {
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_SCORE, activityScore);
        editor.apply();
    }

    private void loadScore() {
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        scoreValue = prefs.getInt(KEY_SCORE, 0);
    }

    private void menuDialog() {
        LayoutInflater inflater = LayoutInflater.from(TopicTwoActivity.this);
        View view =  inflater.inflate(R.layout.custom_menu, null);

        TextView objectives = view.findViewById(R.id.objectives);
        TextView introduction = view.findViewById(R.id.introduction);
        TextView examples = view.findViewById(R.id.examples);
        TextView activities =view.findViewById(R.id.activities);
        TextView assessment = view.findViewById(R.id.assessment);

        examples.setVisibility(View.GONE);
        assessment.setVisibility(View.GONE);

        TextView menu[] = {objectives, introduction, activities};
        TextView title[] = {t2TextViewTitle1, t2TextViewTitle2, t2TextViewTitle3};
        String format[] = {"<u>Objectives</u>", "<u>Introduction to lesson</u>", "<u>Activities</u>"};

        AlertDialog.Builder builder = new AlertDialog.Builder(TopicTwoActivity.this);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();

        for (int i = 0; i < menu.length; i++) {
            int finalI = i;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                menu[finalI].setText(Html.fromHtml(format[finalI], Html.FROM_HTML_MODE_COMPACT));
            } else {
                menu[finalI].setText(Html.fromHtml(format[finalI]));
            }
            menu[finalI].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    t2ScrollView.smoothScrollTo(0, title[finalI].getTop());
                    dialog.dismiss();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        endTime2 = System.currentTimeMillis();
        long timeDiff = endTime2 - startTime2;
        int newTime = (int) (timeDiff / 1000);

        Boolean checkId = dbHandler.checkTopicsId(901);
        if (checkId == true) {
            Map<String, String> studyTime = dbHandler.getTopicsId(901);
            if (!studyTime.isEmpty()) {
                int prevTime = Integer.parseInt(studyTime.get(TIME_IN_SEC));
                int totalTime = newTime + prevTime;
                dbHandler.updateTime(new StudyModelClass(901, totalTime));
            }
        } else {
            dbHandler.storeStudyTime(new StudyModelClass(901, newTime));
        }

        super.onBackPressed();
    }
}