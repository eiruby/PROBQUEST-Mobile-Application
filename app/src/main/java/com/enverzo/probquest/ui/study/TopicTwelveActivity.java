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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ZoomControls;

import com.enverzo.probquest.DBHandler;
import com.enverzo.probquest.R;

import java.util.Map;

import ru.noties.jlatexmath.JLatexMathDrawable;
import ru.noties.jlatexmath.JLatexMathView;

public class TopicTwelveActivity extends AppCompatActivity {
    private TextView t12TextViewTitle1, t12TextViewTitle2, t12TextViewTitle3, t12TextViewTitle4, t12TextViewTitle5, t12TextView1, t12TextView2, t12TextView3, t12TextView4, t12TextView5, t12TextView6, t12TextView7, t12TextView8, t12TextView9, t12TextView10, t12TextView12, t12TextView13, t12TextView14, t12TextView15, t12TextView16, t12TextView17, t12TextView18, t12TextView19, t12TextView20, t12TextView21, t12TextView22, t12TextView23, t12TextView24, t12TextView25, t12TextView26, t12TextView27, t12TextView28, t12TextView29, t12TextView30, t12TextView31, t12TextView32, t12TextView33, t12TextView34, t12TextView35, t12TextView36, t12TextView37, t12TextView38, t12TextView39, t12TextView40, t12TextView41, t12TextView42, t12TextView43, t12TextView44, t12ActScore, t12ActSolText, t12ActDirection, t12ActQuestion, t12Act1Direction, t12Act1Problems, t12Act2Direction, t12Act2Problems, t12Act3Direction, t12Act3Problems, t12Act4Direction, t12Act4Problems, t12Act5Direction, t12Act5Problems, t12SolutionExample1, t12SolutionExample2, t12SolutionExample3, t12SolutionExample4, t12SolutionExample5;
    private JLatexMathView t12Latex_1, t12Latex_2, t12Latex_3, t12Latex_4, t12Latex_5, t12Latex_6, t12Latex_7, t12Latex_8, t12Latex_9, t12Latex_10, t12Latex_11, t12Latex_12, t12Latex_13, t12Latex_14, t12Latex_15, t12Latex_16, t12Latex_17, t12Latex_18, t12Latex_19, t12Latex_20, t12Latex_21, t12Latex_22, t12Latex_23, t12Latex_24, t12Latex_25, t12Latex_26, t12Latex_27, t12Latex_28, t12Latex_29, t12Latex_30, t12Latex_31, t12Latex_32, t12Latex_33, t12ActAns;
    private Button t12ActStart, t12ActOpt1, t12ActOpt2, t12ActOpt3, t12ActOpt4, t12ActSubmit;
    private ImageView t12ActFeedback, t12Back, t12Menu;
    private LinearLayout t12ActLayout, t12ActOpts, t12ActAnsLayout, t12Solution1, t12Solution2, t12Solution3, t12Solution4, t12Solution5;
    private ZoomControls t12ZoomControls;
    private ScrollView t12ScrollView;
    private int textSize = 16, currentIndex, score, actLevel;
    private String selectedAnswer, answer, solution;
    private ActivityQuestions activityQuestions = new ActivityQuestions();
    private int t12ActQuesLength = activityQuestions.t12ActQuestions.length;
    private boolean nextQuestion = false, hideSolution = true;
    private static final String PREFS_FILE_NAME = "ActivityScore12";
    private static final String KEY_SCORE = "score";
    private long startTime12, endTime12, scoreValue;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_twelve);

        t12TextViewTitle1 = findViewById(R.id.t12TextViewTitle1);
        t12TextViewTitle2 = findViewById(R.id.t12TextViewTitle2);
        t12TextViewTitle3 = findViewById(R.id.t12TextViewTitle3);
        t12TextViewTitle4 = findViewById(R.id.t12TextViewTitle4);
        t12TextViewTitle5 = findViewById(R.id.t12TextViewTitle5);
        t12TextView1 = findViewById(R.id.t12TextView1);
        t12TextView2 = findViewById(R.id.t12TextView2);
        t12TextView3 = findViewById(R.id.t12TextView3);
        t12TextView4 = findViewById(R.id.t12TextView4);
        t12TextView5 = findViewById(R.id.t12TextView5);
        t12TextView6 = findViewById(R.id.t12TextView6);
        t12TextView7 = findViewById(R.id.t12TextView7);
        t12TextView8 = findViewById(R.id.t12TextView8);
        t12TextView9 = findViewById(R.id.t12TextView9);
        t12TextView10 = findViewById(R.id.t12TextView10);
        t12TextView12 = findViewById(R.id.t12TextView12);
        t12TextView12 = findViewById(R.id.t12TextView12);
        t12TextView13 = findViewById(R.id.t12TextView13);
        t12TextView14 = findViewById(R.id.t12TextView14);
        t12TextView15 = findViewById(R.id.t12TextView15);
        t12TextView16 = findViewById(R.id.t12TextView16);
        t12TextView17 = findViewById(R.id.t12TextView17);
        t12TextView18 = findViewById(R.id.t12TextView18);
        t12TextView19 = findViewById(R.id.t12TextView19);
        t12TextView20 = findViewById(R.id.t12TextView20);
        t12TextView21 = findViewById(R.id.t12TextView21);
        t12TextView22 = findViewById(R.id.t12TextView22);
        t12TextView23 = findViewById(R.id.t12TextView23);
        t12TextView24 = findViewById(R.id.t12TextView24);
        t12TextView25 = findViewById(R.id.t12TextView25);
        t12TextView26 = findViewById(R.id.t12TextView26);
        t12TextView27 = findViewById(R.id.t12TextView27);
        t12TextView28 = findViewById(R.id.t12TextView28);
        t12TextView29 = findViewById(R.id.t12TextView29);
        t12TextView30 = findViewById(R.id.t12TextView30);
        t12TextView31 = findViewById(R.id.t12TextView31);
        t12TextView32 = findViewById(R.id.t12TextView32);
        t12TextView33 = findViewById(R.id.t12TextView33);
        t12TextView34 = findViewById(R.id.t12TextView34);
        t12TextView35 = findViewById(R.id.t12TextView35);
        t12TextView36 = findViewById(R.id.t12TextView36);
        t12TextView37 = findViewById(R.id.t12TextView37);
        t12TextView38 = findViewById(R.id.t12TextView38);
        t12TextView39 = findViewById(R.id.t12TextView39);
        t12TextView40 = findViewById(R.id.t12TextView40);
        t12TextView41 = findViewById(R.id.t12TextView41);
        t12TextView42 = findViewById(R.id.t12TextView42);
        t12TextView43 = findViewById(R.id.t12TextView43);
        t12TextView44 = findViewById(R.id.t12TextView44);
        t12SolutionExample1 = findViewById(R.id.t12SolutionExample1);
        t12SolutionExample2 = findViewById(R.id.t12SolutionExample2);
        t12SolutionExample3 = findViewById(R.id.t12SolutionExample3);
        t12SolutionExample4 = findViewById(R.id.t12SolutionExample4);
        t12SolutionExample5 = findViewById(R.id.t12SolutionExample5);
        t12Solution1 = findViewById(R.id.t12Solution1);
        t12Solution2 = findViewById(R.id.t12Solution2);
        t12Solution3 = findViewById(R.id.t12Solution3);
        t12Solution4 = findViewById(R.id.t12Solution4);
        t12Solution5 = findViewById(R.id.t12Solution5);
        t12Latex_1 = findViewById(R.id.t12Latex_1);
        t12Latex_2 = findViewById(R.id.t12Latex_2);
        t12Latex_3 = findViewById(R.id.t12Latex_3);
        t12Latex_4 = findViewById(R.id.t12Latex_4);
        t12Latex_5 = findViewById(R.id.t12Latex_5);
        t12Latex_6 = findViewById(R.id.t12Latex_6);
        t12Latex_7 = findViewById(R.id.t12Latex_7);
        t12Latex_8 = findViewById(R.id.t12Latex_8);
        t12Latex_9 = findViewById(R.id.t12Latex_9);
        t12Latex_10 = findViewById(R.id.t12Latex_10);
        t12Latex_11 = findViewById(R.id.t12Latex_11);
        t12Latex_12 = findViewById(R.id.t12Latex_12);
        t12Latex_13 = findViewById(R.id.t12Latex_13);
        t12Latex_14 = findViewById(R.id.t12Latex_14);
        t12Latex_15 = findViewById(R.id.t12Latex_15);
        t12Latex_16 = findViewById(R.id.t12Latex_16);
        t12Latex_17 = findViewById(R.id.t12Latex_17);
        t12Latex_18 = findViewById(R.id.t12Latex_18);
        t12Latex_19 = findViewById(R.id.t12Latex_19);
        t12Latex_20 = findViewById(R.id.t12Latex_20);
        t12Latex_21 = findViewById(R.id.t12Latex_21);
        t12Latex_22 = findViewById(R.id.t12Latex_22);
        t12Latex_23 = findViewById(R.id.t12Latex_23);
        t12Latex_24 = findViewById(R.id.t12Latex_24);
        t12ZoomControls = findViewById(R.id.t12ZoomControls);
        t12Back = findViewById(R.id.t12Back);
        t12Menu = findViewById(R.id.t12Menu);
        t12ScrollView = findViewById(R.id.t12ScrollView);
        t12ActScore = findViewById(R.id.t12ActScore);
        t12ActDirection = findViewById(R.id.t12ActDirection);
        t12ActQuestion = findViewById(R.id.t12ActQuestion);
        t12ActAns = findViewById(R.id.t12ActAns);
        t12ActSolText = findViewById(R.id.t12ActSolText);
        t12ActFeedback = findViewById(R.id.t12ActFeedback);
        t12ActStart = findViewById(R.id.t12ActStart);
        t12ActOpt1 = findViewById(R.id.t12ActOpt1);
        t12ActOpt2 = findViewById(R.id.t12ActOpt2);
        t12ActOpt3 = findViewById(R.id.t12ActOpt3);
        t12ActOpt4 = findViewById(R.id.t12ActOpt4);
        t12ActSubmit = findViewById(R.id.t12ActSubmit);
        t12ActLayout = findViewById(R.id.t12ActLayout);
        t12ActOpts = findViewById(R.id.t12ActOpts);
        t12ActAnsLayout = findViewById(R.id.t12ActAnsLayout);
        t12Act1Direction = findViewById(R.id.t12Act1Direction);
        t12Act2Direction = findViewById(R.id.t12Act2Direction);
        t12Act3Direction = findViewById(R.id.t12Act3Direction);
        t12Act4Direction = findViewById(R.id.t12Act4Direction);
        t12Act5Direction = findViewById(R.id.t12Act5Direction);
        t12Act1Problems = findViewById(R.id.t12Act1Problems);
        t12Act2Problems = findViewById(R.id.t12Act2Problems);
        t12Act3Problems = findViewById(R.id.t12Act3Problems);
        t12Act4Problems = findViewById(R.id.t12Act4Problems);
        t12Act5Problems = findViewById(R.id.t12Act5Problems);

        dbHandler = new DBHandler(this);
        startTime12 = System.currentTimeMillis();

        loadScore();
        t12ActScore.setText("Score: " + scoreValue + "/" + t12ActQuesLength);

        String t12TextViewFormat2 = "<b><i>Fundamental Counting Principles</i></b><br><br>We will explore counting methods that will help you count the members of a set and the outcomes of an event. To understand better, let us consider the examples below.<br><br>Suppose Camila is planning to attend a birthday party. She is trying to decide what to wear. She has shirts in the colors black, brown, and white. She has black pants and jeans. How many different outfits can Camila choose from assuming that she selects one shirt and one pair of pants.<br><br>To visualize the number of possible outcomes or choices for a pair of pants and shirt that Camila could wear, let us use the Tree diagram. A <b><i>Tree diagram</i></b> is a device used to list all possibilities of a sequence of events in a systematic way.  Thus, this is a way of visualizing all possible outcomes in an organized manner.";
        String t12TextViewFormat9 = "<i>Fundamental Counting Principle</i><br><br>In a compound event in which the first event may occur in <i>n<sub>1</sub></i> different ways, the second event may occur in <i>n<sub>2</sub></i> different ways, and so on, and the <i>k<sup>th</sup></i> event may occur in <i>n<sub>k</sub></i> different ways, the total number of ways the compound event may occur is";
        String t12TextViewFormat14 = "<i>1<sup>st</sup> child</i>";
        String t12TextViewFormat15 = "<i>2<sup>nd</sup> child</i>";
        String t12TextViewFormat16 = "<i>3<sup>rd</sup> child</i>";
        String t12TextViewFormat18 = "<b>Example 1</b><br><br>In a fast-food chain, a customer can choose from the 3 types of rice, 5 different viands, 3 kinds of drinks, and 2 kinds of desserts. In how many ways can this person choose what to have if he is to order one from each group?";
        String t12TextViewFormat20 = "<b>Example 2</b><br><br>The digits 3, 4, 5, 6, and 7 are to be used to form a five-digit number. How many different numbers can be formed if";
        String t12TextViewFormat28 = "<b>Example 3</b><br><br>Three-digit numbers are formed from the digits 0, 1, 2, 3, 4, 5, 6, 7, 8, and 9.";
        String t12TextViewFormat33 = "<b>Example 4</b><br><br>The LTO in the Philippines issues a current license plate format LLL-DDDD plates (where L represents a letter and D represents a one-digit number) for four-wheel vehicles (e.g. NFS 1234).";
        String t12TextViewFormat37 = "<b>Example 5</b><br><br>If a coin is tossed or flipped three times,";
        String t12Act1DirectionFormat = "<b>Activity 1</b><br><br>Solve each of the following problems.";
        String t12Act2DirectionFormat = "<b>Activity 2</b><br><br>An employee ID number at a large company consists of 3-digit numbers and a letter such as 123A, 367B, and 234Z.";
        String t12Act3DirectionFormat = "<b>Activity 3</b><br><br>Four-digit numbers are formed from the digits 2, 3, 4, 5, 6, 7, and 8.";
        String t12Act4DirectionFormat = "<b>Activity 4</b><br><br>The digits 1, 2, 3, 4, 5, and 6 are to be used to form a six-digit number. How many different numbers can be formed if";
        String t12Act5DirectionFormat = "<b>Activity 5</b><br><br>If a coin is tossed or flipped four times,";

        TextView[] textViewHtml = {t12TextView2, t12TextView9, t12TextView14, t12TextView15, t12TextView16, t12TextView18, t12TextView20, t12TextView28, t12TextView33, t12TextView37, t12Act1Direction, t12Act2Direction, t12Act3Direction, t12Act4Direction, t12Act5Direction};
        String[] textViewFormat = {t12TextViewFormat2, t12TextViewFormat9, t12TextViewFormat14, t12TextViewFormat15, t12TextViewFormat16, t12TextViewFormat18, t12TextViewFormat20, t12TextViewFormat28, t12TextViewFormat33, t12TextViewFormat37, t12Act1DirectionFormat, t12Act2DirectionFormat, t12Act3DirectionFormat, t12Act4DirectionFormat, t12Act5DirectionFormat};

        for (int i = 0; i < textViewHtml.length; i++) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i], Html.FROM_HTML_MODE_COMPACT));
            } else {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i]));
            }
        }

        t12Latex_1.setLatexDrawable(JLatexMathDrawable.builder("n_1 \\cdot n_2 \\cdot n_3 \\cdot ... \\cdot n_k").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_2.setLatexDrawable(JLatexMathDrawable.builder("3").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_3.setLatexDrawable(JLatexMathDrawable.builder("\\cdot").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_4.setLatexDrawable(JLatexMathDrawable.builder("2").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_5.setLatexDrawable(JLatexMathDrawable.builder("= 6 \\text{ ways}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_6.setLatexDrawable(JLatexMathDrawable.builder("2").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_7.setLatexDrawable(JLatexMathDrawable.builder("\\cdot").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_8.setLatexDrawable(JLatexMathDrawable.builder("2").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_9.setLatexDrawable(JLatexMathDrawable.builder("\\cdot").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_10.setLatexDrawable(JLatexMathDrawable.builder("2").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_11.setLatexDrawable(JLatexMathDrawable.builder("= 8 \\text{ ways}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_12.setLatexDrawable(JLatexMathDrawable.builder("3 \\cdot 5 \\cdot 3 \\cdot 2 = 90 \\text{ ways}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_13.setLatexDrawable(JLatexMathDrawable.builder("\\frac{5}{1^{st} \\text{ digit}} × \\frac{5}{2^{nd} \\text{ digit}} × \\frac{5}{3^{rd} \\text{ digit}} × \\frac{5}{4^{th} \\text{ digit}} × \\frac{5}{5^{th} \\text{ digit}} = 3125 \\text{ ways}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_14.setLatexDrawable(JLatexMathDrawable.builder("\\frac{5\\text{ choices}}{1^{st} \\text{ digit}} × \\frac{4 \\text{ choices}}{2^{nd} \\text{ digit}} × \\frac{3 \\text{ choices}}{3^{rd} \\text{ digit}} × \\frac{2 \\text{ choices}}{4^{th} \\text{ digit}} × \\frac{1 \\text{ choice}}{5^{th} \\text{ digit}} = 120 \\text{ ways}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_15.setLatexDrawable(JLatexMathDrawable.builder("\\frac{\\text{}}{1^{st} \\text{ digit}} × \\frac{\\text{}}{2^{nd} \\text{ digit}} × \\frac{\\text{}}{3^{rd} \\text{ digit}} × \\frac{\\text{}}{4^{th} \\text{ digit}} × \\frac{3 \\text{ choices}}{5^{th} \\text{ digit}}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_16.setLatexDrawable(JLatexMathDrawable.builder("\\frac{4\\text{ choices}}{1^{st} \\text{ digit}} × \\frac{3 \\text{ choices}}{2^{nd} \\text{ digit}} × \\frac{2 \\text{ choices}}{3^{rd} \\text{ digit}} × \\frac{1 \\text{ choices}}{4^{th} \\text{ digit}} × \\frac{3 \\text{ choices}}{5^{th} \\text{ digit}} = 72 \\text{ ways}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_17.setLatexDrawable(JLatexMathDrawable.builder("\\frac{3\\text{ choices}}{1^{st} \\text{ digit}} × \\frac{\\text{}}{2^{nd} \\text{ digit}} × \\frac{\\text{}}{3^{rd} \\text{ digit}} × \\frac{\\text{}}{4^{th} \\text{ digit}} × \\frac{\\text{}}{5^{th} \\text{ digit}}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_18.setLatexDrawable(JLatexMathDrawable.builder("\\frac{3\\text{ choices}}{1^{st} \\text{ digit}} × \\frac{4 \\text{ choices}}{2^{nd} \\text{ digit}} × \\frac{4 \\text{ choices}}{3^{rd} \\text{ digit}} × \\frac{4 \\text{ choices}}{4^{th} \\text{ digit}} × \\frac{4 \\text{ choices}}{5^{th} \\text{ digit}} = 768 \\text{ ways}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_19.setLatexDrawable(JLatexMathDrawable.builder("\\frac{9\\text{ choices}}{1^{st} \\text{ digit}} × \\frac{10 \\text{ choices}}{2^{nd} \\text{ digit}} × \\frac{10 \\text{ choices}}{3^{rd} \\text{ digit}} = 900 \\text{ ways}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_20.setLatexDrawable(JLatexMathDrawable.builder("\\frac{9\\text{ choices}}{1^{st} \\text{ digit}} × \\frac{10 \\text{ choices}}{2^{nd} \\text{ digit}} × \\frac{5 \\text{ choices}}{3^{rd} \\text{ digit}} = 450 \\text{ ways}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_21.setLatexDrawable(JLatexMathDrawable.builder("\\frac{9\\text{ choices}}{1^{st} \\text{ digit}} × \\frac{8 \\text{ choices}}{2^{nd} \\text{ digit}} × \\frac{5 \\text{ choices}}{3^{rd} \\text{ digit}} = 360 \\text{ ways}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_22.setLatexDrawable(JLatexMathDrawable.builder("26 \\cdot 26 \\cdot 26 \\cdot 10 \\cdot 10 \\cdot 10 \\cdot 10 = 175,760,000 \\text{ ways}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_23.setLatexDrawable(JLatexMathDrawable.builder("26 \\cdot 25 \\cdot 24 \\cdot 10 \\cdot 9 \\cdot 8 \\cdot 7 = 78,624,000 \\text{ ways}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t12Latex_24.setLatexDrawable(JLatexMathDrawable.builder("2 × 2 × 2 = 8 \\text{ ways}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());

        TextView[] textViewTitle = {t12TextViewTitle1, t12TextViewTitle2, t12TextViewTitle3, t12TextViewTitle4, t12TextViewTitle5};
        TextView[] textView = {t12TextView1, t12TextView2, t12TextView3, t12TextView4, t12TextView5, t12TextView6, t12TextView7, t12TextView8, t12TextView9, t12TextView10, t12TextView12, t12TextView13, t12TextView14, t12TextView15, t12TextView16, t12TextView17, t12TextView18, t12TextView19, t12TextView20, t12TextView21, t12TextView22, t12TextView23, t12TextView24, t12TextView25, t12TextView26, t12TextView27, t12TextView28, t12TextView29, t12TextView30, t12TextView31, t12TextView32, t12TextView33, t12TextView34, t12TextView35, t12TextView36, t12TextView37, t12TextView38, t12TextView39, t12TextView40, t12TextView41, t12TextView42, t12TextView43, t12TextView44, t12ActScore, t12ActSolText, t12ActDirection, t12ActQuestion, t12Act1Direction, t12Act1Problems, t12Act2Direction, t12Act2Problems, t12Act3Direction, t12Act3Problems, t12Act4Direction, t12Act4Problems, t12Act5Direction, t12Act5Problems, t12SolutionExample1, t12SolutionExample2, t12SolutionExample3, t12SolutionExample4, t12SolutionExample5};

        t12ZoomControls.setOnZoomInClickListener(new View.OnClickListener() {
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

        t12ZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
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

        t12Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //Example Solutions

        TextView[] solutions = {t12SolutionExample1, t12SolutionExample2, t12SolutionExample3, t12SolutionExample4, t12SolutionExample5};
        LinearLayout[] solLayout = {t12Solution1, t12Solution2, t12Solution3, t12Solution4, t12Solution5};

        for (int i = 0; i < solutions.length; i++) {
            int finalI = i;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                solutions[finalI].setText(Html.fromHtml("<u>Show Solution</u>", Html.FROM_HTML_MODE_COMPACT));
            } else {
                solutions[finalI].setText(Html.fromHtml("<u>Show Solution</u>"));
            }
            solutions[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (hideSolution) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            solutions[finalI].setText(Html.fromHtml("<u>Hide Solution</u>", Html.FROM_HTML_MODE_COMPACT));
                        } else {
                            solutions[finalI].setText(Html.fromHtml("<u>Hide Solution</u>"));
                        }
                        solLayout[finalI].setVisibility(View.VISIBLE);
                        hideSolution = false;
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            solutions[finalI].setText(Html.fromHtml("<u>Show Solution</u>", Html.FROM_HTML_MODE_COMPACT));
                        } else {
                            solutions[finalI].setText(Html.fromHtml("<u>Show Solution</u>"));
                        }
                        solLayout[finalI].setVisibility(View.GONE);
                        hideSolution = true;
                    }
                }
            });
        }

        t12Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuDialog();
            }
        });

        t12ActStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t12ActLayout.setVisibility(View.VISIBLE);
                t12ActOpts.setVisibility(View.VISIBLE);
                t12ActAnsLayout.setVisibility(View.INVISIBLE);
                t12ActSolText.setVisibility(View.GONE);
                t12ActStart.setVisibility(View.GONE);
                t12ActDirection.setText("Read and understand each question carefully and select your answer from the multiple-choice options.");
                t12ActFeedback.setImageDrawable(null);
                t12ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(8).build());
                Button[] buttons = {t12ActOpt1, t12ActOpt2, t12ActOpt3, t12ActOpt4};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
                t12ActSubmit.setText("Submit");
                t12ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                currentIndex = 0;
                score = 0;
                nextQuestion = false;
                generateT12ActQuestions();
            }
        });

        t12ActSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nextQuestion == false) {
                    nextQuestion = true;
                    t12ActSubmit.setText("Next");
                    t12ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.black));
                    Button[] buttons = {t12ActOpt1, t12ActOpt2, t12ActOpt3, t12ActOpt4};
                    for (int i = 0; i < buttons.length; i++) {
                        buttons[i].setEnabled(false);
                    }
                    t12ActSolText.setVisibility(View.VISIBLE);
                    t12ActAns.setLatexDrawable(JLatexMathDrawable.builder(solution).textSize(50).background(0xFFb0d6f5).padding(10).build());
                    if (selectedAnswer.equals(answer)) {
                        t12ActFeedback.setImageResource(R.drawable.round_check_24);
                        score++;
                    } else {
                        t12ActFeedback.setImageResource(R.drawable.round_clear_24);
                    }
                }else {
                    currentIndex++;
                    if (currentIndex < t12ActQuesLength) {
                        generateT12ActQuestions();
                        nextQuestion = false;
                        t12ActAnsLayout.setVisibility(View.INVISIBLE);
                        t12ActSolText.setVisibility(View.GONE);
                        t12ActSubmit.setText("Submit");
                        t12ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                        t12ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(10).build());
                        t12ActFeedback.setImageDrawable(null);
                        Button[] buttons = {t12ActOpt1, t12ActOpt2, t12ActOpt3, t12ActOpt4};
                        for (int i = 0; i < buttons.length; i++) {
                            buttons[i].setEnabled(true);
                            buttons[i].setBackgroundTintList(null);
                            buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                            buttons[i].setTextColor(getResources().getColor(R.color.white));
                        }
                    } else {
                        showScore();
                    }
                }
            }
        });

        t12ActOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t12ActOpt1.getText().toString();
                t12ActAnsLayout.setVisibility(View.VISIBLE);
                t12ActOpt1.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t12ActOpt1.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t12ActOpt4, t12ActOpt2, t12ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t12ActOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t12ActOpt2.getText().toString();
                t12ActAnsLayout.setVisibility(View.VISIBLE);
                t12ActOpt2.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t12ActOpt2.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t12ActOpt4, t12ActOpt1, t12ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t12ActOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t12ActOpt3.getText().toString();
                t12ActAnsLayout.setVisibility(View.VISIBLE);
                t12ActOpt3.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t12ActOpt3.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t12ActOpt4, t12ActOpt2, t12ActOpt1};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t12ActOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t12ActOpt4.getText().toString();
                t12ActAnsLayout.setVisibility(View.VISIBLE);
                t12ActOpt4.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t12ActOpt4.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t12ActOpt1, t12ActOpt2, t12ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
    }

    private void generateT12ActQuestions() {
        t12ActQuestion.setText(activityQuestions.getT12ActQuestions(currentIndex));
        t12ActOpt1.setText(activityQuestions.getT12ActChoice1(currentIndex));
        t12ActOpt2.setText(activityQuestions.getT12ActChoice2(currentIndex));
        t12ActOpt3.setText(activityQuestions.getT12ActChoice3(currentIndex));
        t12ActOpt4.setText(activityQuestions.getT12ActChoice4(currentIndex));
        answer = activityQuestions.getT12ActAnswers(currentIndex);
        solution = activityQuestions.getT12ActSolutions(currentIndex);
    }

    private void showScore() {
        t12ActLayout.setVisibility(View.GONE);
        t12ActOpts.setVisibility(View.GONE);
        t12ActAnsLayout.setVisibility(View.GONE);
        t12ActStart.setVisibility(View.VISIBLE);
        t12ActStart.setText("Try Again");
        String actDirectionFormat = "Assessment Complete!<br>Your score is <b>" + score + "</b> out of " + t12ActQuesLength + ".";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            t12ActDirection.setText(Html.fromHtml(actDirectionFormat, Html.FROM_HTML_MODE_COMPACT));
        } else {
            t12ActDirection.setText(Html.fromHtml(actDirectionFormat));
        }
        t12ActScore.setText("Score: " + score + "/" + t12ActQuesLength);
        storeScore(score);
    }

    private void storeScore(int score) {
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_SCORE, score);
        editor.apply();
    }

    private void loadScore() {
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        scoreValue = prefs.getInt(KEY_SCORE, 0);
    }

    private void menuDialog() {
        LayoutInflater inflater = LayoutInflater.from(TopicTwelveActivity.this);
        View view =  inflater.inflate(R.layout.custom_menu, null);

        TextView objectives = view.findViewById(R.id.objectives);
        TextView introduction = view.findViewById(R.id.introduction);
        TextView examples = view.findViewById(R.id.examples);
        TextView activities =view.findViewById(R.id.activities);
        TextView assessment = view.findViewById(R.id.assessment);

        TextView menu[] = {objectives, introduction, examples, activities, assessment};
        TextView title[] = {t12TextViewTitle1, t12TextViewTitle2, t12TextViewTitle3, t12TextViewTitle4, t12TextViewTitle5};
        String format[] = {"<u>Objectives</u>", "<u>Introduction to lesson</u>", "<u>Illustrative Examples</u>", "<u>Activities</u>", "<u>Assessment</u>"};

        AlertDialog.Builder builder = new AlertDialog.Builder(TopicTwelveActivity.this);
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
                    t12ScrollView.smoothScrollTo(0, title[finalI].getTop());
                    dialog.dismiss();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        endTime12 = System.currentTimeMillis();
        long timeDiff = endTime12 - startTime12;
        int newTime = (int) (timeDiff / 1000);

        Boolean checkId = dbHandler.checkTopicsId(789);
        if (checkId == true) {
            Map<String, String> studyTime = dbHandler.getTopicsId(789);
            if (!studyTime.isEmpty()) {
                int prevTime = Integer.parseInt(studyTime.get(TIME_IN_SEC));
                int totalTime = newTime + prevTime;
                dbHandler.updateTime(new StudyModelClass(789, totalTime));
            }
        } else {
            dbHandler.storeStudyTime(new StudyModelClass(789, newTime));
        }

        super.onBackPressed();
    }
}