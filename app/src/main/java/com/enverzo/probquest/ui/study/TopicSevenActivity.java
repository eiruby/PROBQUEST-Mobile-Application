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

public class TopicSevenActivity extends AppCompatActivity {
    private TextView t7TextViewTitle1, t7TextViewTitle2, t7TextViewTitle3, t7TextViewTitle4, t7TextViewTitle5, t7TextView1, t7TextView2, t7TextView3, t7TextView4, t7TextView5, t7TextView6, t7TextView7, t7TextView8, t7TextView9, t7TextView10, t7TextView11, t7TextView12, t7TextView13, t7TextView14, t7TextView15, t7TextView16, t7TextView17, t7TextView18, t7ActScore, t7ActSolText, t7ActDirection, t7ActQuestion, t7Act1Direction, t7Act1Problems, t7Act2Direction, t7Act2Problems, t7Act3Direction, t7Act3Problems, t7Act4Direction, t7Act4Problems, t7Act5Direction, t7Act5Problems, t7SolutionExample1, t7SolutionExample2, t7SolutionExample3, t7SolutionExample4, t7SolutionExample5;
    private JLatexMathView t7Latex_1, t7Latex_2, t7Latex_3, t7Latex_4, t7Latex_5, t7Latex_6, t7ActAns;
    private Button t7ActStart, t7ActOpt1, t7ActOpt2, t7ActOpt3, t7ActOpt4, t7ActSubmit, t7Act1Start, t7Act1Submit, t7Act2Start, t7Act2Submit, t7Act3Start, t7Act3Submit, t7Act4Start, t7Act4Submit, t7Act5Start, t7Act5Submit;
    private ImageView t7ActFeedback, t7Back, t7Menu;
    private LinearLayout t7ActLayout, t7ActOpts, t7ActAnsLayout, t7Solution1, t7Solution2, t7Solution3, t7Solution4, t7Solution5;
    private ZoomControls t7ZoomControls;

    private ScrollView t7ScrollView;
    private int textSize = 16, currentIndex, score;
    private String selectedAnswer, answer, solution;
    private ActivityQuestions activityQuestions = new ActivityQuestions();
    private int t7ActQuesLength = activityQuestions.t7ActQuestions.length;
    private boolean hideSolution = true, nextQuestion = false;
    private static final String PREFS_FILE_NAME = "ActivityScore7";
    private static final String KEY_SCORE = "score";
    private long startTime7, endTime7, scoreValue;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_seven);

        t7TextViewTitle1 = findViewById(R.id.t7TextViewTitle1);
        t7TextViewTitle2 = findViewById(R.id.t7TextViewTitle2);
        t7TextViewTitle3 = findViewById(R.id.t7TextViewTitle3);
        t7TextViewTitle4 = findViewById(R.id.t7TextViewTitle4);
        t7TextViewTitle5 = findViewById(R.id.t7TextViewTitle5);
        t7TextView1 = findViewById(R.id.t7TextView1);
        t7TextView2 = findViewById(R.id.t7TextView2);
        t7TextView3 = findViewById(R.id.t7TextView3);
        t7TextView4 = findViewById(R.id.t7TextView4);
        t7TextView5 = findViewById(R.id.t7TextView5);
        t7TextView6 = findViewById(R.id.t7TextView6);
        t7TextView7 = findViewById(R.id.t7TextView7);
        t7TextView8 = findViewById(R.id.t7TextView8);
        t7TextView9 = findViewById(R.id.t7TextView9);
        t7TextView10 = findViewById(R.id.t7TextView10);
        t7TextView11 = findViewById(R.id.t7TextView11);
        t7TextView12 = findViewById(R.id.t7TextView12);
        t7TextView13 = findViewById(R.id.t7TextView13);
        t7TextView14 = findViewById(R.id.t7TextView14);
        t7TextView15 = findViewById(R.id.t7TextView15);
        t7TextView16 = findViewById(R.id.t7TextView16);
        t7TextView17 = findViewById(R.id.t7TextView17);
        t7TextView18 = findViewById(R.id.t7TextView18);
        t7SolutionExample1 = findViewById(R.id.t7SolutionExample1);
        t7SolutionExample2 = findViewById(R.id.t7SolutionExample2);
        t7SolutionExample3 = findViewById(R.id.t7SolutionExample3);
        t7SolutionExample4 = findViewById(R.id.t7SolutionExample4);
        t7SolutionExample5 = findViewById(R.id.t7SolutionExample5);
        t7Latex_1 = findViewById(R.id.t7Latex_1);
        t7Latex_2 = findViewById(R.id.t7Latex_2);
        t7Latex_3 = findViewById(R.id.t7Latex_3);
        t7Latex_4 = findViewById(R.id.t7Latex_4);
        t7Latex_5 = findViewById(R.id.t7Latex_5);
        t7Latex_6 = findViewById(R.id.t7Latex_6);
        t7ZoomControls = findViewById(R.id.t7ZoomControls);
        t7ScrollView = findViewById(R.id.t7ScrollView);
        t7Back = findViewById(R.id.t7Back);
        t7Menu = findViewById(R.id.t7Menu);
        t7ActScore = findViewById(R.id.t7ActScore);
        t7ActDirection = findViewById(R.id.t7ActDirection);
        t7ActQuestion = findViewById(R.id.t7ActQuestion);
        t7ActSolText = findViewById(R.id.t7ActSolText);
        t7ActAns = findViewById(R.id.t7ActAns);
        t7ActFeedback = findViewById(R.id.t7ActFeedback);
        t7ActStart = findViewById(R.id.t7ActStart);
        t7ActOpt1 = findViewById(R.id.t7ActOpt1);
        t7ActOpt2 = findViewById(R.id.t7ActOpt2);
        t7ActOpt3 = findViewById(R.id.t7ActOpt3);
        t7ActOpt4 = findViewById(R.id.t7ActOpt4);
        t7ActSubmit = findViewById(R.id.t7ActSubmit);
        t7ActLayout = findViewById(R.id.t7ActLayout);
        t7ActOpts = findViewById(R.id.t7ActOpts);
        t7ActAnsLayout = findViewById(R.id.t7ActAnsLayout);
        t7Act1Direction = findViewById(R.id.t7Act1Direction);
        t7Act2Direction = findViewById(R.id.t7Act2Direction);
        t7Act3Direction = findViewById(R.id.t7Act3Direction);
        t7Act4Direction = findViewById(R.id.t7Act4Direction);
        t7Act5Direction = findViewById(R.id.t7Act5Direction);
        t7Act1Problems = findViewById(R.id.t7Act1Problems);
        t7Act2Problems = findViewById(R.id.t7Act2Problems);
        t7Act3Problems = findViewById(R.id.t7Act3Problems);
        t7Act4Problems = findViewById(R.id.t7Act4Problems);
        t7Act5Problems = findViewById(R.id.t7Act5Problems);

        dbHandler = new DBHandler(this);
        startTime7 = System.currentTimeMillis();

        loadScore();
        t7ActScore.setText("Score: " + scoreValue + "/" + t7ActQuesLength);

        String t7TextViewFormat2 = "<b>Permutation of n Distinct Objects Taken n at a Time</b><br><br><b>Permutation</b> is an arrangement of a group of things in a definite order, that is, there is a first element, a second element, a third, etc. In other words, the order of arrangement of the elements is important.<br><br>Consider a set of letters, {K, I, D}. How many ways are there to arrange these letters?<br><br>The number of ways to arrange these 3 letters can be determined by listing the different possible arrangements:";
        String t7TextViewFormat4 = "Thus, there are 6 possible arrangements.<br><br>We can also determine the number of possible arrangements using the <u>Fundamental Counting Principle</u>. We can select any of the 3 letters to be the first. Thus, there are 3 choices for the first letter. Once the first letter has been selected, there are only 2 choices in the second letter. Finally, there is only one choice for the third letter.";
        String t7TextViewFormat6 = "The process of finding the number of possible arrangements of the set of objects can be generalized to a set of <i><b>n</b></i> objects. There are <i><b>n</b></i> choices for the first selection, <i><b>n – 1</b></i> for the second, <i><b>n – 2</b></i> for the third, and so on. For the nth selection, there is only one choice.";
        String t7TextViewFormat7 = "In general, <i><b>n</b></i> distinct objects can be arranged in<br><br><i><b>n(n - 1)(n - 2)(n - 3)(n - 4)...(3)(2)(1) ways</b></i><br><br>we can represent this product by the symbol <i><b>n!</b></i>, which is read as <i>“<u>n factorial</u>”</i><br><br><u>Permutations of <b>n</b> Objects Taken <b>n</b> at a Time</u><br><br>The number of <i><b>n</b></i> permutations taken <i><b>n</b></i> at a time is <i><b>n!</b></i>";
        String t7TextViewFormat9 = "<b>Example 1</b><br><br>How many ways are there to arrange the letters in the set {p, q, r, s, t}?";
        String t7TextViewFormat11 = "<b>Example 2</b><br><br>In how many ways can the letters of the word MATH be arranged?";
        String t7TextViewFormat13 = "<b>Example 3</b><br><br>In how many ways can 6 teachers be arranged in a line during flag ceremony?";
        String t7TextViewFormat15 = "<b>Example 4</b><br><br>How many permutations can be made for 7 different books on a shelf that can accommodate exactly these 7 books?";
        String t7TextViewFormat17 = "<b>Example 5</b><br><br>In how many ways can three boys and two girls be arranged in a row with five seats?";
        String t7TextViewFormat18 = "First, we take books of a particular subject as one unit. Thus, there are 4 units which can be arranged in <sub>4</sub>P<sub>4</sub> = 4! = 24 ways. Now in each of arrangements, mathematics books can be arranged in <sub>3</sub>P<sub>3</sub> = 3! ways, history books in <sub>4</sub>P<sub>4</sub> = 4! ways, chemistry books in <sub>3</sub>P<sub>3</sub> = 3! ways and biology books in <sub>2</sub>P<sub>2</sub> = 2! ways. Thus, the total number of ways:";
        String t7Act1DirectionFormat = "<b>Activity 1</b><br><br>Evaluate the following.";
        String t7Act2DirectionFormat = "<b>Activity 2</b><br><br>Find the number of permutations of the letters in the word:";
        String t7Act3DirectionFormat = "<b>Activity 3</b><br><br>Solve the following:";
        String t7Act4DirectionFormat = "<b>Activity 4</b><br><br>Solve the following:";
        String t7Act5DirectionFormat = "<b>Activity 5</b><br><br>Solve the following:";
        String t7Act1ProblemsFormat = "(a) 9!<br>(b) 12!<br>(c) <sub>5</sub>P<sub>5</sub><br>(d) 0!<br>(e) n!";
        String t7Act2ProblemsFormat = "(a) <i>hope</i><br>(b) <i>time</i><br>(c) <i>GENIUS</i><br>(d) <i>RIGHTS</i><br>(e) <i>EDUCATION</i>";

        TextView[] textViewHtml = {t7TextView2, t7TextView4, t7TextView6, t7TextView7, t7TextView9, t7TextView11, t7TextView13, t7TextView15, t7TextView17, t7TextView18, t7Act1Direction, t7Act2Direction, t7Act3Direction, t7Act4Direction, t7Act5Direction, t7Act1Problems, t7Act2Problems};
        String[] textViewFormat = {t7TextViewFormat2, t7TextViewFormat4, t7TextViewFormat6, t7TextViewFormat7, t7TextViewFormat9, t7TextViewFormat11, t7TextViewFormat13, t7TextViewFormat15, t7TextViewFormat17, t7TextViewFormat18, t7Act1DirectionFormat, t7Act2DirectionFormat, t7Act3DirectionFormat, t7Act4DirectionFormat, t7Act5DirectionFormat, t7Act1ProblemsFormat, t7Act2ProblemsFormat};

        for (int i = 0; i < textViewHtml.length; i++) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i], Html.FROM_HTML_MODE_COMPACT));
            } else {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i]));
            }
        }

        t7Latex_1.setLatexDrawable(JLatexMathDrawable.builder("{}_5P_5 = 5! = 5 × 4 × 3 × 2 × 1 = 125").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t7Latex_2.setLatexDrawable(JLatexMathDrawable.builder("{}_4P_4 = 4! = 4 × 3 × 2 × 1 = 24").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t7Latex_3.setLatexDrawable(JLatexMathDrawable.builder("{}_6P_6 = 6! = 6 × 5 × 4 × 3 × 2 × 1 = 720").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t7Latex_4.setLatexDrawable(JLatexMathDrawable.builder("{}_7P_7 = 7! = 7 × 6 × 5 × 4 × 3 × 2 × 1 = 5040").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t7Latex_5.setLatexDrawable(JLatexMathDrawable.builder("{}_4P_4 × ({}_3P_3 × {}_4P_4 × {}_3P_3 × {}_2P_2)\\\\= 4! × (3! × 4! × 3! × 2!) = 41,472").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t7Latex_6.setLatexDrawable(JLatexMathDrawable.builder("{}_nP_n = P(n,n) = n! = n(n - 1)(n - 2)...(3)(2)(1)").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());

        TextView[] textViewTitle = {t7TextViewTitle1, t7TextViewTitle2, t7TextViewTitle3, t7TextViewTitle4, t7TextViewTitle5};
        TextView[] textView = {t7TextView1, t7TextView2, t7TextView3, t7TextView4, t7TextView5, t7TextView6, t7TextView7, t7TextView8, t7TextView9, t7TextView10, t7TextView11, t7TextView12, t7TextView13, t7TextView14, t7TextView15, t7TextView16, t7TextView17, t7TextView18, t7ActScore, t7ActSolText, t7ActDirection, t7ActQuestion, t7Act1Direction, t7Act1Problems, t7Act2Direction, t7Act2Problems, t7Act3Direction, t7Act3Problems, t7Act4Direction, t7Act4Problems, t7Act5Direction, t7Act5Problems, t7SolutionExample1, t7SolutionExample2, t7SolutionExample3, t7SolutionExample4, t7SolutionExample5};

        t7ZoomControls.setOnZoomInClickListener(new View.OnClickListener() {
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

        t7ZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
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

        t7Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //Example Solutions

        TextView[] solutions = {t7SolutionExample1, t7SolutionExample2, t7SolutionExample3, t7SolutionExample4, t7SolutionExample5};
        JLatexMathView[] solLatex = {t7Latex_1, t7Latex_2, t7Latex_3, t7Latex_4, t7Latex_5};
        TextView[] solTextView = {t7TextView10, t7TextView12, t7TextView14, t7TextView16, t7TextView18};

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
                        solTextView[finalI].setVisibility(View.VISIBLE);
                        if (finalI == 4) {
                            solLatex[finalI].setVisibility(View.GONE);
                        } else {
                            solLatex[finalI].setVisibility(View.VISIBLE);
                        }
                        hideSolution = false;
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            solutions[finalI].setText(Html.fromHtml("<u>Show Solution</u>", Html.FROM_HTML_MODE_COMPACT));
                        } else {
                            solutions[finalI].setText(Html.fromHtml("<u>Show Solution</u>"));
                        }
                        solTextView[finalI].setVisibility(View.GONE);
                        solLatex[finalI].setVisibility(View.GONE);
                        hideSolution = true;
                    }
                }
            });
        }

        t7Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuDialog();
            }
        });

        //Assessment

        t7ActStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t7ActLayout.setVisibility(View.VISIBLE);
                t7ActOpts.setVisibility(View.VISIBLE);
                t7ActAnsLayout.setVisibility(View.INVISIBLE);
                t7ActSolText.setVisibility(View.GONE);
                t7ActStart.setVisibility(View.GONE);
                t7ActDirection.setText("Read and understand each question carefully and select your answer from the multiple-choice options.");
                t7ActFeedback.setImageDrawable(null);
                t7ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(8).build());
                Button[] buttons = {t7ActOpt1, t7ActOpt2, t7ActOpt3, t7ActOpt4};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
                t7ActSubmit.setText("Submit");

                t7ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                currentIndex = 0;
                score = 0;
                nextQuestion = false;
                generateT7ActQuestions();
            }
        });

        t7ActSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nextQuestion == false) {
                    nextQuestion = true;
                    t7ActSubmit.setText("Next");
                    t7ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.black));
                    Button[] buttons = {t7ActOpt1, t7ActOpt2, t7ActOpt3, t7ActOpt4};
                    for (int i = 0; i < buttons.length; i++) {
                        buttons[i].setEnabled(false);
                    }
                    t7ActSolText.setVisibility(View.VISIBLE);
                    t7ActAns.setLatexDrawable(JLatexMathDrawable.builder(solution).textSize(50).background(0xFFb0d6f5).padding(10).build());
                    if (selectedAnswer.equals(answer)) {
                        t7ActFeedback.setImageResource(R.drawable.round_check_24);
                        score++;
                    } else {
                        t7ActFeedback.setImageResource(R.drawable.round_clear_24);
                    }
                }else {
                    currentIndex++;
                    if (currentIndex < t7ActQuesLength) {
                        generateT7ActQuestions();
                        nextQuestion = false;
                        t7ActAnsLayout.setVisibility(View.INVISIBLE);
                        t7ActSolText.setVisibility(View.GONE);
                        t7ActSubmit.setText("Submit");
                        t7ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                        t7ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(10).build());
                        t7ActFeedback.setImageDrawable(null);
                        Button[] buttons = {t7ActOpt1, t7ActOpt2, t7ActOpt3, t7ActOpt4};
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

        t7ActOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t7ActOpt1.getText().toString();
                t7ActAnsLayout.setVisibility(View.VISIBLE);
                t7ActOpt1.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t7ActOpt1.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t7ActOpt4, t7ActOpt2, t7ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t7ActOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t7ActOpt2.getText().toString();
                t7ActAnsLayout.setVisibility(View.VISIBLE);
                t7ActOpt2.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t7ActOpt2.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t7ActOpt4, t7ActOpt1, t7ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t7ActOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t7ActOpt3.getText().toString();
                t7ActAnsLayout.setVisibility(View.VISIBLE);
                t7ActOpt3.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t7ActOpt3.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t7ActOpt4, t7ActOpt2, t7ActOpt1};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t7ActOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t7ActOpt4.getText().toString();
                t7ActAnsLayout.setVisibility(View.VISIBLE);
                t7ActOpt4.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t7ActOpt4.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t7ActOpt1, t7ActOpt2, t7ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
    }

    private void generateT7ActQuestions() {
        t7ActQuestion.setText(activityQuestions.getT7ActQuestions(currentIndex));
        t7ActOpt1.setText(activityQuestions.getT7ActChoice1(currentIndex));
        t7ActOpt2.setText(activityQuestions.getT7ActChoice2(currentIndex));
        t7ActOpt3.setText(activityQuestions.getT7ActChoice3(currentIndex));
        t7ActOpt4.setText(activityQuestions.getT7ActChoice4(currentIndex));
        answer = activityQuestions.getT7ActAnswers(currentIndex);
        solution = activityQuestions.getT7ActSolutions(currentIndex);
    }

    private void showScore() {
        t7ActLayout.setVisibility(View.GONE);
        t7ActOpts.setVisibility(View.GONE);
        t7ActAnsLayout.setVisibility(View.GONE);
        t7ActStart.setVisibility(View.VISIBLE);
        t7ActStart.setText("Try Again");
        String actDirectionFormat = "Assessment Complete!<br>Your score is <b>" + score + "</b> out of " + t7ActQuesLength + ".";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            t7ActDirection.setText(Html.fromHtml(actDirectionFormat, Html.FROM_HTML_MODE_COMPACT));
        } else {
            t7ActDirection.setText(Html.fromHtml(actDirectionFormat));
        }
        t7ActScore.setText("Score: " + score + "/" + t7ActQuesLength);
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
        LayoutInflater inflater = LayoutInflater.from(TopicSevenActivity.this);
        View view =  inflater.inflate(R.layout.custom_menu, null);

        TextView objectives = view.findViewById(R.id.objectives);
        TextView introduction = view.findViewById(R.id.introduction);
        TextView examples = view.findViewById(R.id.examples);
        TextView activities =view.findViewById(R.id.activities);
        TextView assessment = view.findViewById(R.id.assessment);

        TextView menu[] = {objectives, introduction, examples, activities, assessment};
        TextView title[] = {t7TextViewTitle1, t7TextViewTitle2, t7TextViewTitle3, t7TextViewTitle4, t7TextViewTitle5};
        String format[] = {"<u>Objectives</u>", "<u>Introduction to lesson</u>", "<u>Illustrative Examples</u>", "<u>Activities</u>", "<u>Assessment</u>"};

        AlertDialog.Builder builder = new AlertDialog.Builder(TopicSevenActivity.this);
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
                    t7ScrollView.smoothScrollTo(0, title[finalI].getTop());
                    dialog.dismiss();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        endTime7 = System.currentTimeMillis();
        long timeDiff = endTime7 - startTime7;
        int newTime = (int) (timeDiff / 1000);

        Boolean checkId = dbHandler.checkTopicsId(724);
        if (checkId == true) {
            Map<String, String> studyTime = dbHandler.getTopicsId(724);
            if (!studyTime.isEmpty()) {
                int prevTime = Integer.parseInt(studyTime.get(TIME_IN_SEC));
                int totalTime = newTime + prevTime;
                dbHandler.updateTime(new StudyModelClass(724, totalTime));
            }
        } else {
            dbHandler.storeStudyTime(new StudyModelClass(724, newTime));
        }

        super.onBackPressed();
    }
}