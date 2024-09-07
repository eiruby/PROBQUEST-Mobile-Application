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

public class TopicNineActivity extends AppCompatActivity {
    private TextView t9TextViewTitle1, t9TextViewTitle2, t9TextViewTitle3, t9TextViewTitle4, t9TextViewTitle5, t9TextView1, t9TextView2, t9TextView3, t9TextView4, t9TextView5, t9TextView6, t9TextView7, t9TextView8, t9TextView9, t9TextView10, t9TextView11, t9TextView12, t9TextView13, t9TextView14, t9TextView15, t9TextView16, t9TextView17, t9TextView18, t9TextView19, t9TextView20, t9TextView21, t9TextView22, t9TextView23, t9TextView24, t9TextView25, t9TextView26, t9TextView27, t9TextView28, t9TextView29, t9TextView30, t9TextView31, t9TextView32, t9TextView33, t9TextView34, t9TextView35, t9TextView36, t9TextView37, t9TextView38, t9TextView39, t9TextView40, t9TextView41, t9TextView42, t9TextView43, t9TextView44, t9TextView45, t9TextView46, t9TextView47, t9TextView48, t9TextView49, t9TextView50, t9TextView51, t9TextView52, t9TextView53, t9TextView54, t9TextView55, t9TextView56, t9TextView57, t9TextView58, t9TextView59, t9SolutionExample1, t9SolutionExample2, t9SolutionExample3, t9SolutionExample4, t9SolutionExample5, t9Act1Direction, t9Act1Problems, t9Act2Direction, t9Act2Problems, t9Act3Direction, t9Act3Problems, t9Act4Direction, t9Act4Problems, t9Act5Direction, t9Act5Problems, t9ActScore, t9ActDirection, t9ActQuestion, t9ActSolText;
    private JLatexMathView t9Latex_1, t9Latex_2, t9Latex_3, t9Latex_4, t9Latex_5, t9Latex_6, t9Latex_7, t9Latex_8, t9Latex_9, t9Latex_10, t9Latex_11, t9Latex_12, t9Latex_13, t9Latex_14, t9Latex_15, t9Latex_16, t9ActAns;
    private Button t9ActStart, t9ActOpt1, t9ActOpt2, t9ActOpt3, t9ActOpt4, t9ActSubmit;
    private ImageView t9ActFeedback, t9Back, t9Menu;
    private LinearLayout t9ActLayout, t9ActOpts, t9ActAnsLayout, t9Solution1, t9Solution2, t9Solution3, t9Solution4, t9Solution5;
    private ZoomControls t9ZoomControls;
    private ScrollView t9ScrollView;
    private int textSize = 16, currentIndex, score;
    private String selectedAnswer, answer, solution;
    private ActivityQuestions activityQuestions = new ActivityQuestions();
    private int t9ActQuesLength = activityQuestions.t9ActQuestions.length;
    private boolean nextQuestion = false, hideSolution = false;
    private static final String PREFS_FILE_NAME = "ActivityScore9";
    private static final String KEY_SCORE = "score";
    private long startTime9, endTime9, scoreValue;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_nine);

        t9TextViewTitle1 = findViewById(R.id.t9TextViewTitle1);
        t9TextViewTitle2 = findViewById(R.id.t9TextViewTitle2);
        t9TextViewTitle3 = findViewById(R.id.t9TextViewTitle3);
        t9TextViewTitle4 = findViewById(R.id.t9TextViewTitle4);
        t9TextViewTitle5 = findViewById(R.id.t9TextViewTitle5);
        t9TextView1 = findViewById(R.id.t9TextView1);
        t9TextView2 = findViewById(R.id.t9TextView2);
        t9TextView3 = findViewById(R.id.t9TextView3);
        t9TextView4 = findViewById(R.id.t9TextView4);
        t9TextView5 = findViewById(R.id.t9TextView5);
        t9TextView6 = findViewById(R.id.t9TextView6);
        t9TextView7 = findViewById(R.id.t9TextView7);
        t9TextView8 = findViewById(R.id.t9TextView8);
        t9TextView9 = findViewById(R.id.t9TextView9);
        t9TextView10 = findViewById(R.id.t9TextView10);
        t9TextView11 = findViewById(R.id.t9TextView11);
        t9TextView12 = findViewById(R.id.t9TextView12);
        t9TextView13 = findViewById(R.id.t9TextView13);
        t9TextView14 = findViewById(R.id.t9TextView14);
        t9TextView15 = findViewById(R.id.t9TextView15);
        t9TextView16 = findViewById(R.id.t9TextView16);
        t9TextView17 = findViewById(R.id.t9TextView17);
        t9TextView18 = findViewById(R.id.t9TextView18);
        t9TextView19 = findViewById(R.id.t9TextView19);
        t9TextView20 = findViewById(R.id.t9TextView20);
        t9TextView21 = findViewById(R.id.t9TextView21);
        t9TextView22 = findViewById(R.id.t9TextView22);
        t9TextView23 = findViewById(R.id.t9TextView23);
        t9TextView24 = findViewById(R.id.t9TextView24);
        t9TextView25 = findViewById(R.id.t9TextView25);
        t9TextView26 = findViewById(R.id.t9TextView26);
        t9TextView27 = findViewById(R.id.t9TextView27);
        t9TextView28 = findViewById(R.id.t9TextView28);
        t9TextView29 = findViewById(R.id.t9TextView29);
        t9TextView30 = findViewById(R.id.t9TextView30);
        t9TextView31 = findViewById(R.id.t9TextView31);
        t9TextView32 = findViewById(R.id.t9TextView32);
        t9TextView33 = findViewById(R.id.t9TextView33);
        t9TextView34 = findViewById(R.id.t9TextView34);
        t9TextView35 = findViewById(R.id.t9TextView35);
        t9TextView36 = findViewById(R.id.t9TextView36);
        t9TextView37 = findViewById(R.id.t9TextView37);
        t9TextView38 = findViewById(R.id.t9TextView38);
        t9TextView39 = findViewById(R.id.t9TextView39);
        t9TextView40 = findViewById(R.id.t9TextView40);
        t9TextView41 = findViewById(R.id.t9TextView41);
        t9TextView42 = findViewById(R.id.t9TextView42);
        t9TextView43 = findViewById(R.id.t9TextView43);
        t9TextView44 = findViewById(R.id.t9TextView44);
        t9TextView45 = findViewById(R.id.t9TextView45);
        t9TextView46 = findViewById(R.id.t9TextView46);
        t9TextView47 = findViewById(R.id.t9TextView47);
        t9TextView48 = findViewById(R.id.t9TextView48);
        t9TextView49 = findViewById(R.id.t9TextView49);
        t9TextView50 = findViewById(R.id.t9TextView50);
        t9TextView51 = findViewById(R.id.t9TextView51);
        t9TextView52 = findViewById(R.id.t9TextView52);
        t9TextView53 = findViewById(R.id.t9TextView53);
        t9TextView54 = findViewById(R.id.t9TextView54);
        t9TextView55 = findViewById(R.id.t9TextView55);
        t9TextView56 = findViewById(R.id.t9TextView56);
        t9TextView57 = findViewById(R.id.t9TextView57);
        t9TextView58 = findViewById(R.id.t9TextView58);
        t9TextView59 = findViewById(R.id.t9TextView59);
        t9SolutionExample1 = findViewById(R.id.t9SolutionExample1);
        t9SolutionExample2 = findViewById(R.id.t9SolutionExample2);
        t9SolutionExample3 = findViewById(R.id.t9SolutionExample3);
        t9SolutionExample4 = findViewById(R.id.t9SolutionExample4);
        t9SolutionExample5 = findViewById(R.id.t9SolutionExample5);
        t9Latex_1 = findViewById(R.id.t9Latex_1);
        t9Latex_2 = findViewById(R.id.t9Latex_2);
        t9Latex_3 = findViewById(R.id.t9Latex_3);
        t9Latex_4 = findViewById(R.id.t9Latex_4);
        t9Latex_5 = findViewById(R.id.t9Latex_5);
        t9Latex_6 = findViewById(R.id.t9Latex_6);
        t9Latex_7 = findViewById(R.id.t9Latex_7);
        t9Latex_8 = findViewById(R.id.t9Latex_8);
        t9Latex_9 = findViewById(R.id.t9Latex_9);
        t9Latex_10 = findViewById(R.id.t9Latex_10);
        t9Latex_11 = findViewById(R.id.t9Latex_11);
        t9Latex_12 = findViewById(R.id.t9Latex_12);
        t9Latex_13 = findViewById(R.id.t9Latex_13);
        t9Latex_14 = findViewById(R.id.t9Latex_14);
        t9Latex_15 = findViewById(R.id.t9Latex_15);
        t9Latex_16 = findViewById(R.id.t9Latex_16);
        t9Solution1 = findViewById(R.id.t9Solution1);
        t9Solution2 = findViewById(R.id.t9Solution2);
        t9Solution3 = findViewById(R.id.t9Solution3);
        t9Solution4 = findViewById(R.id.t9Solution4);
        t9Solution5 = findViewById(R.id.t9Solution5);
        t9ZoomControls = findViewById(R.id.t9ZoomControls);
        t9ScrollView = findViewById(R.id.t9ScrollView);
        t9Back = findViewById(R.id.t9Back);
        t9Menu = findViewById(R.id.t9Menu);
        t9Act1Direction = findViewById(R.id.t9Act1Direction);
        t9Act2Direction = findViewById(R.id.t9Act2Direction);
        t9Act3Direction = findViewById(R.id.t9Act3Direction);
        t9Act4Direction = findViewById(R.id.t9Act4Direction);
        t9Act5Direction = findViewById(R.id.t9Act5Direction);
        t9Act1Problems = findViewById(R.id.t9Act1Problems);
        t9Act2Problems = findViewById(R.id.t9Act2Problems);
        t9Act3Problems = findViewById(R.id.t9Act3Problems);
        t9Act4Problems = findViewById(R.id.t9Act4Problems);
        t9Act5Problems = findViewById(R.id.t9Act5Problems);
        t9ActScore = findViewById(R.id.t9ActScore);
        t9ActDirection = findViewById(R.id.t9ActDirection);
        t9ActQuestion = findViewById(R.id.t9ActQuestion);
        t9ActAns = findViewById(R.id.t9ActAns);
        t9ActFeedback = findViewById(R.id.t9ActFeedback);
        t9ActStart = findViewById(R.id.t9ActStart);
        t9ActOpt1 = findViewById(R.id.t9ActOpt1);
        t9ActOpt2 = findViewById(R.id.t9ActOpt2);
        t9ActOpt3 = findViewById(R.id.t9ActOpt3);
        t9ActOpt4 = findViewById(R.id.t9ActOpt4);
        t9ActSubmit = findViewById(R.id.t9ActSubmit);
        t9ActLayout = findViewById(R.id.t9ActLayout);
        t9ActOpts = findViewById(R.id.t9ActOpts);
        t9ActSolText = findViewById(R.id.t9ActSolText);
        t9ActAnsLayout = findViewById(R.id.t9ActAnsLayout);

        dbHandler = new DBHandler(this);
        startTime9 = System.currentTimeMillis();

        loadScore();
        t9ActScore.setText("Score: " + scoreValue + "/" + t9ActQuesLength);

        String t9TextViewFormat2 = "<b><i>Circular Permutation</i></b><br><br>Permutation that occur by arranging objects in a circle are called <b>circular permutations</b>. To find the number of ways of arranging <b>n</b> different objects in a circle, we first fix or select a position for one of the objects. The others can be placed in their positions in (n-1)! different ways.";
        String t9TextViewFormat3 = "The number of circular permutations of <b>n</b> objects is";
        String t9TextViewFormat34 = "We use the computation P = 1 × 3 × 2 × 1 = 3! to know the number of ways four people can be seated in a roundtable. After simplifying the solution, we conclude that there are 6 ways to arrange four people in a roundtable.<br><br>Thus, If <b>n</b> objects are arranged in a circle, then there are";
        String t9TextViewFormat35 = "permutations of the <b>n</b> objects around the circle.";
        String t9TextViewFormat36 = "<b>Example 1</b><br><br>Find the number of circular permutations of six horses in a carousel?";
        String t9TextViewFormat38 = "<b>Example 2</b><br><br>How many ways can 10 different roses be planted in a circular garden?";
        String t9TextViewFormat40 = "<b>Example 3</b><br><br>How many ways can 7 different keys be arranged on a key ring?";
        String t9TextViewFormat42 = "<b>Example 4</b><br><br>In how many ways can 8 guests be seated in a round table if";
        String t9TextViewFormat52 = "<b>Example 5</b><br><br>How many ways can 4 mothers and 4 kids be seated at a round table if";
        String t9Act1DirectionFormat = "<b>Activity 1</b><br><br>Determine the number of ways to sit around a circular table given the number of people below.";
        String t9Act2DirectionFormat = "<b>Activity 2</b><br><br>Solve each problem.";
        String t9Act3DirectionFormat = "<b>Activity 3</b><br><br>Ramcea has 5 different colored heads including purple and pink. In how many ways can she arrange the beads in a string";
        String t9Act4DirectionFormat = "<b>Activity 4</b><br><br>In how many ways can 7 guests be seated in a round table if";
        String t9Act5DirectionFormat = "<b>Activity 5</b><br><br>How many ways can 4 boys and 4 girls be seated at a round table if:";
        String t9Act1ProblemsFormat = "(a) 5 people<br>(b) 7 people<br>(c) 8 people<br>(d) 10 people<br>(e) 12 people";
        String t9Act2ProblemsFormat = "(a) In how many ways can a group of 9 people arrange themselves in a circular table?<br><br>(b) How many ways can you sit 8 people in a round table with 8 seats?<br><br>(c) The 12 mathematics teachers of Toboy National High School are attending a meeting at the conference hall. In how many different ways can they arrange themselves in a circular table?<br><br>(d) How many ways can 5 different keys be arranged on a key ring?<br><br>(e) In how many ways can 15 different roses be planted in a circular garden?";
        String t9Act4ProblemsFormat = "(a) they can sit anywhere?<br><br>(b) particular guests must sit next to each other, and<br><br>(c) particular guests must not sit next to each other?";
        String t9Act5ProblemsFormat = "(a) no restrictions are imposed?<br><br>(b) The girls and the boys are to occupy alternate seats?<br><br>(c) 3 particular girls must sit together?<br><br>(d) 3 particular girls must not sit together?<br><br>(e) all the girls must sit together?";
        String t9Act3ProblemsFormat = "(a) if there are no restrictions?<br><br>(b) so that the purple and pink beads are adjacent to each other?";

        TextView[] textViewHtml = {t9TextView2, t9TextView3, t9TextView34, t9TextView35, t9TextView36, t9TextView38, t9TextView40, t9TextView42, t9TextView52, t9Act1Direction, t9Act2Direction, t9Act3Direction, t9Act4Direction, t9Act5Direction, t9Act1Problems, t9Act2Problems, t9Act3Problems, t9Act4Problems, t9Act5Problems};
        String[] textViewFormat = {t9TextViewFormat2, t9TextViewFormat3, t9TextViewFormat34, t9TextViewFormat35, t9TextViewFormat36, t9TextViewFormat38, t9TextViewFormat40, t9TextViewFormat42, t9TextViewFormat52, t9Act1DirectionFormat, t9Act2DirectionFormat, t9Act3DirectionFormat, t9Act4DirectionFormat, t9Act5DirectionFormat, t9Act1ProblemsFormat, t9Act2ProblemsFormat, t9Act3ProblemsFormat, t9Act4ProblemsFormat, t9Act5ProblemsFormat};

        for (int i = 0; i < textViewHtml.length; i++) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i], Html.FROM_HTML_MODE_COMPACT));
            } else {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i]));
            }
        }

        t9Latex_1.setLatexDrawable(JLatexMathDrawable.builder("\\frac{n!}{n}\\text{ or }(n - 1)!").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t9Latex_2.setLatexDrawable(JLatexMathDrawable.builder("\\frac{n!}{n}\\text{ or }(n - 1)!").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t9Latex_2.setLatexDrawable(JLatexMathDrawable.builder("\\frac{n!}{n}\\text{ or }(n - 1)!").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t9Latex_3.setLatexDrawable(JLatexMathDrawable.builder("(n - 1)! = (6 - 1)! = 5!\\\\= 5 × 4 × 3 × 2 × 1 = 120").textSize(50).background(0xFFffffff).padding(8).build());
        t9Latex_4.setLatexDrawable(JLatexMathDrawable.builder("(n - 1)! = (10 - 1)! = 9!\\\\= 9 × 8 × 7 × 6 × 5 × 4 × 3 × 2 × 1\\\\= 362,880").textSize(50).background(0xFFffffff).padding(8).build());
        t9Latex_5.setLatexDrawable(JLatexMathDrawable.builder("(n - 1)! = (7 - 1)! = 6!\\\\= 6 × 5 × 4 × 3 × 2 × 1 = 720").textSize(50).background(0xFFffffff).padding(8).build());
        t9Latex_6.setLatexDrawable(JLatexMathDrawable.builder("\\text{(a) }(n - 1)! = (8 - 1)! = 7! = 7 × 6 × 5 × 4 × 3 × 2 × 1\\\\= 5,040").textSize(50).background(0xFFffffff).padding(8).build());
        t9Latex_7.setLatexDrawable(JLatexMathDrawable.builder("2! = 2 × 1 = 2\\text{ ways}").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t9Latex_8.setLatexDrawable(JLatexMathDrawable.builder("(7 - 1)! = 6! = 6 × 5 × 4 × 3 × 2 × 1\\\\= 720 \\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t9Latex_9.setLatexDrawable(JLatexMathDrawable.builder("6! × 2! = 720 × 2 = 1,440\\text{ ways}").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t9Latex_10.setLatexDrawable(JLatexMathDrawable.builder("5,040 - 1,440 = 3,600\\text{ ways}").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t9Latex_11.setLatexDrawable(JLatexMathDrawable.builder("(n - 1)! = (8 - 1)! = 7!\\\\= 7 × 6 × 5 × 4 × 3 × 2 × 1\\\\= 5,040\\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t9Latex_12.setLatexDrawable(JLatexMathDrawable.builder("(n - 1)! = (4 - 1)! = 3!\\\\= 3 × 2 × 1\\\\= 6\\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t9Latex_13.setLatexDrawable(JLatexMathDrawable.builder("n! = 4! = 4 × 3 × 2 × 1 = 24\\text{ ways}").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t9Latex_14.setLatexDrawable(JLatexMathDrawable.builder("6 × 24 = 144\\text{ ways}").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t9Latex_15.setLatexDrawable(JLatexMathDrawable.builder("(n - 1)! = (5 - 1)! = 4!\\\\= 4 × 3 × 2 × 1\\\\= 24\\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t9Latex_16.setLatexDrawable(JLatexMathDrawable.builder("24 × 4! = 24 × 24 = 576\\text{ ways}").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());

        TextView[] textViewTitle = {t9TextViewTitle1, t9TextViewTitle2, t9TextViewTitle3, t9TextViewTitle4, t9TextViewTitle5};
        TextView[] textViews = {t9TextView1, t9TextView2, t9TextView3, t9TextView4, t9TextView5, t9TextView6, t9TextView7, t9TextView8, t9TextView9, t9TextView10, t9TextView11, t9TextView12, t9TextView13, t9TextView14, t9TextView15, t9TextView16, t9TextView17, t9TextView18, t9TextView19, t9TextView20, t9TextView21, t9TextView22, t9TextView23, t9TextView24, t9TextView25, t9TextView26, t9TextView27, t9TextView28, t9TextView29, t9TextView30, t9TextView31, t9TextView32, t9TextView33, t9TextView34, t9TextView35, t9TextView36, t9TextView37, t9TextView38, t9TextView39, t9TextView40, t9TextView41, t9TextView42, t9TextView43, t9TextView44, t9TextView45, t9TextView46, t9TextView47, t9TextView48, t9TextView49, t9TextView50, t9TextView51, t9TextView52, t9TextView53, t9TextView54, t9TextView55, t9TextView56, t9TextView57, t9TextView58, t9TextView59, t9SolutionExample1, t9SolutionExample2, t9SolutionExample3, t9SolutionExample4, t9SolutionExample5, t9Act1Direction, t9Act1Problems, t9Act2Direction, t9Act2Problems, t9Act3Direction, t9Act3Problems, t9Act4Direction, t9Act4Problems, t9Act5Direction, t9Act5Problems, t9ActScore, t9ActDirection, t9ActQuestion, t9ActSolText};

        t9ZoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textSize == 16) {
                    textSize = textSize + 2;
                    for (int i = 0; i < textViews.length; i++) {
                        textViews[i].setTextSize(textSize);
                    }
                    for (int i = 0; i < textViewTitle.length; i++) {
                        textViewTitle[i].setTextSize(20);
                    }
                } else if (textSize == 18) {
                    textSize = textSize + 2;
                    for (int i = 0; i < textViews.length; i++) {
                        textViews[i].setTextSize(textSize);
                    }
                    for (int i = 0; i < textViewTitle.length; i++) {
                        textViewTitle[i].setTextSize(22);
                    }
                }
            }
        });

        t9ZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textSize == 20) {
                    textSize = textSize - 2;
                    for (int i = 0; i < textViews.length; i++) {
                        textViews[i].setTextSize(textSize);
                    }
                    for (int i = 0; i < textViewTitle.length; i++) {
                        textViewTitle[i].setTextSize(20);
                    }
                } else if (textSize == 18) {
                    textSize = textSize - 2;
                    for (int i = 0; i < textViews.length; i++) {
                        textViews[i].setTextSize(textSize);
                    }
                    for (int i = 0; i < textViewTitle.length; i++) {
                        textViewTitle[i].setTextSize(18);
                    }
                }
            }
        });

        t9Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //Example Solutions

        TextView[] solutions = {t9SolutionExample1, t9SolutionExample2, t9SolutionExample3, t9SolutionExample4, t9SolutionExample5};
        LinearLayout[] solLayout = {t9Solution1, t9Solution2, t9Solution3, t9Solution4, t9Solution5};

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

        t9Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuDialog();
            }
        });

        t9ActStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t9ActLayout.setVisibility(View.VISIBLE);
                t9ActOpts.setVisibility(View.VISIBLE);
                t9ActAnsLayout.setVisibility(View.INVISIBLE);
                t9ActSolText.setVisibility(View.GONE);
                t9ActStart.setVisibility(View.GONE);
                t9ActDirection.setText("Read and understand each question carefully and select your answer from the multiple-choice options.");
                t9ActFeedback.setImageDrawable(null);
                t9ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(8).build());
                Button[] buttons = {t9ActOpt1, t9ActOpt2, t9ActOpt3, t9ActOpt4};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
                t9ActSubmit.setText("Submit");
                t9ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                currentIndex = 0;
                score = 0;
                nextQuestion = false;
                generateT9ActQuestions();
            }
        });

        t9ActSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nextQuestion == false) {
                    nextQuestion = true;
                    t9ActSubmit.setText("Next");
                    t9ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.black));
                    Button[] buttons = {t9ActOpt1, t9ActOpt2, t9ActOpt3, t9ActOpt4};
                    for (int i = 0; i < buttons.length; i++) {
                        buttons[i].setEnabled(false);
                    }
                    t9ActSolText.setVisibility(View.VISIBLE);
                    t9ActAns.setLatexDrawable(JLatexMathDrawable.builder(answer).textSize(50).background(0xFFb0d6f5).padding(10).build());
                    if (selectedAnswer.equals(answer)) {
                        t9ActFeedback.setImageResource(R.drawable.round_check_24);
                        score++;
                    } else {
                        t9ActFeedback.setImageResource(R.drawable.round_clear_24);
                    }
                }else {
                    currentIndex++;
                    if (currentIndex < t9ActQuesLength) {
                        generateT9ActQuestions();
                        nextQuestion = false;
                        t9ActAnsLayout.setVisibility(View.INVISIBLE);
                        t9ActSolText.setVisibility(View.GONE);
                        t9ActSubmit.setText("Submit");
                        t9ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                        t9ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(10).build());
                        t9ActFeedback.setImageDrawable(null);
                        Button[] buttons = {t9ActOpt1, t9ActOpt2, t9ActOpt3, t9ActOpt4};
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

        t9ActOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t9ActOpt1.getText().toString();
                t9ActAnsLayout.setVisibility(View.VISIBLE);
                t9ActOpt1.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t9ActOpt1.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t9ActOpt2, t9ActOpt3, t9ActOpt4};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t9ActOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t9ActOpt2.getText().toString();
                t9ActAnsLayout.setVisibility(View.VISIBLE);
                t9ActOpt2.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t9ActOpt2.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t9ActOpt1, t9ActOpt3, t9ActOpt4};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t9ActOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t9ActOpt3.getText().toString();
                t9ActAnsLayout.setVisibility(View.VISIBLE);
                t9ActOpt3.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t9ActOpt3.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t9ActOpt2, t9ActOpt1, t9ActOpt4};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t9ActOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t9ActOpt4.getText().toString();
                t9ActAnsLayout.setVisibility(View.VISIBLE);
                t9ActOpt4.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t9ActOpt4.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t9ActOpt2, t9ActOpt3, t9ActOpt1};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
    }

    private void generateT9ActQuestions() {
        t9ActQuestion.setText(activityQuestions.getT9ActQuestions(currentIndex));
        t9ActOpt1.setText(activityQuestions.getT9ActChoice1(currentIndex));
        t9ActOpt2.setText(activityQuestions.getT9ActChoice2(currentIndex));
        t9ActOpt3.setText(activityQuestions.getT9ActChoice3(currentIndex));
        t9ActOpt4.setText(activityQuestions.getT9ActChoice4(currentIndex));
        answer = activityQuestions.getT9ActAnswers(currentIndex);
    }

    private void showScore() {
        t9ActLayout.setVisibility(View.GONE);
        t9ActOpts.setVisibility(View.GONE);
        t9ActAnsLayout.setVisibility(View.GONE);
        t9ActStart.setVisibility(View.VISIBLE);
        t9ActStart.setText("Try Again");
        String actDirectionFormat = "Activity 5 Complete!<br>Your score is <b>" + score + "</b> out of " + t9ActQuesLength + ".";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            t9ActDirection.setText(Html.fromHtml(actDirectionFormat, Html.FROM_HTML_MODE_COMPACT));
        } else {
            t9ActDirection.setText(Html.fromHtml(actDirectionFormat));
        }
        t9ActScore.setText("Score: " + score + "/" + t9ActQuesLength);
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
        LayoutInflater inflater = LayoutInflater.from(TopicNineActivity.this);
        View view =  inflater.inflate(R.layout.custom_menu, null);

        TextView objectives = view.findViewById(R.id.objectives);
        TextView introduction = view.findViewById(R.id.introduction);
        TextView examples = view.findViewById(R.id.examples);
        TextView activities =view.findViewById(R.id.activities);
        TextView assessment = view.findViewById(R.id.assessment);

        TextView menu[] = {objectives, introduction, examples, activities, assessment};
        TextView title[] = {t9TextViewTitle1, t9TextViewTitle2, t9TextViewTitle3, t9TextViewTitle4, t9TextViewTitle5};
        String format[] = {"<u>Objectives</u>", "<u>Introduction to lesson</u>", "<u>Illustrative Examples</u>", "<u>Activities</u>", "<u>Assessment</u>"};

        AlertDialog.Builder builder = new AlertDialog.Builder(TopicNineActivity.this);
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
                    t9ScrollView.smoothScrollTo(0, title[finalI].getTop());
                    dialog.dismiss();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        endTime9 = System.currentTimeMillis();
        long timeDiff = endTime9 - startTime9;
        int newTime = (int) (timeDiff / 1000);

        Boolean checkId = dbHandler.checkTopicsId(196);
        if (checkId == true) {
            Map<String, String> studyTime = dbHandler.getTopicsId(196);
            if (!studyTime.isEmpty()) {
                int prevTime = Integer.parseInt(studyTime.get(TIME_IN_SEC));
                int totalTime = newTime + prevTime;
                dbHandler.updateTime(new StudyModelClass(196, totalTime));
            }
        } else {
            dbHandler.storeStudyTime(new StudyModelClass(196, newTime));
        }

        super.onBackPressed();
    }
}