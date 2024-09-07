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

public class TopicTenActivity extends AppCompatActivity {
    private TextView t10TextViewTitle1, t10TextViewTitle2, t10TextViewTitle3, t10TextViewTitle4, t10TextViewTitle5, t10TextViewTitle6, t10TextView1, t10TextView2, t10TextView3, t10TextView4, t10TextView5, t10TextView6, t10TextView7, t10TextView8, t10TextView9, t10TextView10, t10TextView11, t10TextView12, t10TextView13, t10ActScore, t10ActSolText, t10ActDirection, t10ActQuestion, t10Act1Direction, t10Act1Problems, t10Act2Direction, t10Act2Problems, t10Act3Direction, t10Act3Problems, t10SolutionExample1, t10SolutionExample2, t10SolutionExample3, t10SolutionExample4, t10SolutionExample5;
    private JLatexMathView t10Latex_1, t10Latex_2, t10Latex_3, t10Latex_4, t10Latex_5, t10Latex_6, t10Latex_7, t10ActAns;
    private Button t10ActStart, t10ActOpt1, t10ActOpt2, t10ActOpt3, t10ActOpt4, t10ActSubmit;
    private ImageView t10ActFeedback, t10Back, t10Menu;
    private LinearLayout t10ActLayout, t10ActOpts, t10ActAnsLayout, t10Solution1, t10Solution2, t10Solution3, t10Solution4, t10Solution5;
    private ZoomControls t10ZoomControls;
    private ScrollView t10ScrollView;
    private int textSize = 16, currentIndex, score;
    private String selectedAnswer, answer, solution;
    private ActivityQuestions activityQuestions = new ActivityQuestions();
    private int t10ActQuesLength = activityQuestions.t10ActQuestions.length;
    private boolean nextQuestion = false, hideSolution = true;
    private static final String PREFS_FILE_NAME = "ActivityScore10";
    private static final String KEY_SCORE = "score";
    private long startTime10, endTime10, scoreValue;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_ten);

        t10TextViewTitle1 = findViewById(R.id.t10TextViewTitle1);
        t10TextViewTitle2 = findViewById(R.id.t10TextViewTitle2);
        t10TextViewTitle3 = findViewById(R.id.t10TextViewTitle3);
        t10TextViewTitle4 = findViewById(R.id.t10TextViewTitle4);
        t10TextViewTitle5 = findViewById(R.id.t10TextViewTitle5);
        t10TextViewTitle6 = findViewById(R.id.t10TextViewTitle6);
        t10TextView1 = findViewById(R.id.t10TextView1);
        t10TextView2 = findViewById(R.id.t10TextView2);
        t10TextView3 = findViewById(R.id.t10TextView3);
        t10TextView4 = findViewById(R.id.t10TextView4);
        t10TextView5 = findViewById(R.id.t10TextView5);
        t10TextView6 = findViewById(R.id.t10TextView6);
        t10TextView7 = findViewById(R.id.t10TextView7);
        t10TextView8 = findViewById(R.id.t10TextView8);
        t10TextView9 = findViewById(R.id.t10TextView9);
        t10TextView10 = findViewById(R.id.t10TextView10);
        t10TextView11 = findViewById(R.id.t10TextView11);
        t10TextView12 = findViewById(R.id.t10TextView12);
        t10TextView13 = findViewById(R.id.t10TextView13);
        t10SolutionExample1 = findViewById(R.id.t10SolutionExample1);
        t10SolutionExample2 = findViewById(R.id.t10SolutionExample2);
        t10SolutionExample3 = findViewById(R.id.t10SolutionExample3);
        t10SolutionExample4 = findViewById(R.id.t10SolutionExample4);
        t10SolutionExample5 = findViewById(R.id.t10SolutionExample5);
        t10Solution1 = findViewById(R.id.t10Solution1);
        t10Solution2 = findViewById(R.id.t10Solution2);
        t10Solution3 = findViewById(R.id.t10Solution3);
        t10Solution4 = findViewById(R.id.t10Solution4);
        t10Solution5 = findViewById(R.id.t10Solution5);
        t10Latex_1 = findViewById(R.id.t10Latex_1);
        t10Latex_2 = findViewById(R.id.t10Latex_2);
        t10Latex_3 = findViewById(R.id.t10Latex_3);
        t10Latex_4 = findViewById(R.id.t10Latex_4);
        t10Latex_5 = findViewById(R.id.t10Latex_5);
        t10Latex_6 = findViewById(R.id.t10Latex_6);
        t10Latex_7 = findViewById(R.id.t10Latex_7);
        t10ZoomControls = findViewById(R.id.t10ZoomControls);
        t10Back = findViewById(R.id.t10Back);
        t10Menu = findViewById(R.id.t10Menu);
        t10ScrollView = findViewById(R.id.t10ScrollView);
        t10ActScore = findViewById(R.id.t10ActScore);
        t10ActDirection = findViewById(R.id.t10ActDirection);
        t10ActQuestion = findViewById(R.id.t10ActQuestion);
        t10ActAns = findViewById(R.id.t10ActAns);
        t10ActSolText = findViewById(R.id.t10ActSolText);
        t10ActFeedback = findViewById(R.id.t10ActFeedback);
        t10ActStart = findViewById(R.id.t10ActStart);
        t10ActOpt1 = findViewById(R.id.t10ActOpt1);
        t10ActOpt2 = findViewById(R.id.t10ActOpt2);
        t10ActOpt3 = findViewById(R.id.t10ActOpt3);
        t10ActOpt4 = findViewById(R.id.t10ActOpt4);
        t10ActSubmit = findViewById(R.id.t10ActSubmit);
        t10ActLayout = findViewById(R.id.t10ActLayout);
        t10ActOpts = findViewById(R.id.t10ActOpts);
        t10ActAnsLayout = findViewById(R.id.t10ActAnsLayout);
        t10Act1Direction = findViewById(R.id.t10Act1Direction);
        t10Act2Direction = findViewById(R.id.t10Act2Direction);
        t10Act3Direction = findViewById(R.id.t10Act3Direction);
        t10Act1Problems = findViewById(R.id.t10Act1Problems);
        t10Act2Problems = findViewById(R.id.t10Act2Problems);
        t10Act3Problems = findViewById(R.id.t10Act3Problems);

        dbHandler = new DBHandler(this);
        startTime10 = System.currentTimeMillis();

        loadScore();
        t10ActScore.setText("Score: " + scoreValue + "/" + t10ActQuesLength);

        String t10TextViewFormat2 = "<b>Permutations with Identical Objects</b><br><br>From the previous lessons, we have considered getting the arrangements of <b>n</b> distinct objects. Word like <i>“friends”</i> is an example of a distinct since none of the letters are the same. Thus, the number of distinct permutations can be made from the letters of the word <i>“friends”</i> is <sub>7</sub>P<sub>7</sub> or 7! = 5,040 ways. Now, consider the word <i>“forever”</i> where some of each letter were repeated or the same such as two letter <i>‘r’</i> and two letter <i>‘e’</i> in it. This will affect the number of ways you can arrange the letters of the word and this type of problem is called <b>permutation of identical objects</b>.";
        String t10TextViewFormat3 = "The number of permutations of <i>n</i> objects of which <i>n<sub>1</sub></i> are of one kind, <i>n<sub>2</sub></i> are of a second kind,...and <i>n<sub>k</sub></i> are of a <i>kth</i> kind is given by";
        String t10TextViewFormat4 = "<b>Example 1</b><br><br>The covered walk of a school is to be lined with flags. How many different arrangements are there of the 12 flags if 5 are red, 4 are light green, 2 are purple, and 1 is blue?";
        String t10TextViewFormat5 = "In the 12 flags (n = 12), there are 5 red (n<sub>1</sub> = 5), 4 light green (n<sub>2</sub> = 4), and 2 purple (n<sub>3</sub> = 2) and 1 blue. Thus, these flags can be arranged in";
        String t10TextViewFormat6 = "<b>Example 2</b><br><br>How many different 11-letter words can be formed from the letters in the word PROBABILITY?";
        String t10TextViewFormat7 = "In the letter-word PROBABILITY (n = 11), there are two letter B’s (n<sub>1</sub> = 2), two letters I’s (n<sub>2</sub> = 2), and the rest of the letters appeared once. Thus, these letters can be arranged in";
        String t10TextViewFormat8 = "<b>Example 3</b><br><br>In how many ways can two identical mathematics books, four identical english books, three identical computer books, and one science book to put on the bookshelf?";
        String t10TextViewFormat9 = "There are total of 10 books (n =10) of which are 2 mathematics books (n<sub>1</sub> = 2), 4 english books (n<sub>2</sub> = 4), 3 computer books (n<sub>3</sub> = 4), and 1 science book. Thus, these books can be arranged in";
        String t10TextViewFormat10 = "<b>Example 4</b><br><br>How many distinct permutations can be made from the letters of the word “Research”?";
        String t10TextViewFormat11 = "In the letter-word <i>“Research”</i> (n = 8), there are two letters <b>e</b>’s (n<sub>1</sub> = 2) and the rest of the letters appeared once. Note that the capital letter <b>R</b> and the small letter <b>r</b> are not the same. Thus, these letters can be arranged in";
        String t10TextViewFormat12 = "<b>Example 5</b><br><br>How many different ten-digit numerals can be written using the digits 1, 5, 5, 5, 7, 7, 7, 7, 7, and 9?";
        String t10TextViewFormat13 = "In the ten-digit numerals (n =10), there are three 5’s (n<sub>1</sub> =3), five 7’s (n<sub>2</sub> =5). Thus, these digits can be arranged in";
        String t10Act1DirectionFormat = "<b>Activity 1</b><br><br>Evaluate the following:";
        String t10Act2DirectionFormat = "<b>Activity 2</b><br><br>How many different ways can the letters of the following words be arranged?";
        String t10Act3DirectionFormat = "<b>Activity 3</b><br><br>Solve each of the following problems.";

        TextView[] textViewHtml = {t10TextView2, t10TextView3, t10TextView4, t10TextView5, t10TextView6, t10TextView7, t10TextView8, t10TextView9, t10TextView10, t10TextView11, t10TextView12, t10TextView13, t10Act1Direction, t10Act2Direction, t10Act3Direction};
        String[] textViewFormat = {t10TextViewFormat2, t10TextViewFormat3, t10TextViewFormat4, t10TextViewFormat5, t10TextViewFormat6, t10TextViewFormat7, t10TextViewFormat8, t10TextViewFormat9, t10TextViewFormat10, t10TextViewFormat11, t10TextViewFormat12, t10TextViewFormat13, t10Act1DirectionFormat, t10Act2DirectionFormat, t10Act3DirectionFormat};

        for (int i = 0; i < textViewHtml.length; i++) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i], Html.FROM_HTML_MODE_COMPACT));
            } else {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i]));
            }
        }

        t10Latex_1.setLatexDrawable(JLatexMathDrawable.builder("\\frac{n!}{n_1! \\cdot n_2! \\cdot ... \\cdot n_k!}").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t10Latex_2.setLatexDrawable(JLatexMathDrawable.builder("\\text{where } n = n_1 + n_2 + ... + n_k").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t10Latex_3.setLatexDrawable(JLatexMathDrawable.builder("\\frac{n!}{n_1! n_2! n_3! n_k!} = \\frac{12!}{5! 4! 2!} \\\\ = \\frac{12 \\cdot 11 \\cdot 10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (2 \\cdot 1)} \\\\ = 83,160 \\text{ ways} \\\\ \\text{There are 83,160 different arrangements.}").textSize(50).background(0xFFffffff).padding(10).build());
        t10Latex_4.setLatexDrawable(JLatexMathDrawable.builder("\\frac{n!}{n_1! n_2! n_3! n_k!} = \\frac{11!}{2! 2!} \\\\ = \\frac{11 \\cdot 10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1) \\cdot (2 \\cdot 1)} \\\\ = 9,979,200 \\text{ ways} \\\\ \\text{There are 9,979,200 different arrangements.}").textSize(50).background(0xFFffffff).padding(10).build());
        t10Latex_5.setLatexDrawable(JLatexMathDrawable.builder("\\frac{n!}{n_1! n_2! n_3! n_k!} = \\frac{10!}{2! 4! 3!} \\\\ = \\frac{10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1) \\cdot (4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1)} \\\\ = 12,600 \\text{ ways} \\\\ \\text{There are 12,600 different arrangements.}").textSize(50).background(0xFFffffff).padding(10).build());
        t10Latex_6.setLatexDrawable(JLatexMathDrawable.builder("\\frac{n!}{n_1! n_2! n_3! n_k!} = \\frac{8!}{2!} \\\\ = \\frac{8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{2 \\cdot 1} \\\\ = 20,160 \\text{ ways} \\\\ \\text{There are 20,160 different arrangements.}").textSize(50).background(0xFFffffff).padding(10).build());
        t10Latex_7.setLatexDrawable(JLatexMathDrawable.builder("\\frac{n!}{n_1! n_2! n_3! n_k!} = \\frac{10!}{3! 5!} \\\\ = \\frac{10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(3 \\cdot 2 \\cdot 1) \\cdot (5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1)} \\\\ = 5,040 \\text{ ways} \\\\ \\text{There are 5,040 different arrangements.}").textSize(50).background(0xFFffffff).padding(10).build());

        TextView[] textViewTitle = {t10TextViewTitle1, t10TextViewTitle2, t10TextViewTitle3, t10TextViewTitle4, t10TextViewTitle5, t10TextViewTitle6};
        TextView[] textView = {t10TextView1, t10TextView2, t10TextView3, t10TextView4, t10TextView5, t10TextView6, t10TextView7, t10TextView8, t10TextView9, t10TextView10, t10TextView11, t10TextView12, t10TextView13, t10ActScore, t10ActSolText, t10ActDirection, t10ActQuestion, t10Act1Direction, t10Act1Problems, t10Act2Direction, t10Act2Problems, t10Act3Direction, t10Act3Problems, t10SolutionExample1, t10SolutionExample2, t10SolutionExample3, t10SolutionExample4, t10SolutionExample5};

        t10ZoomControls.setOnZoomInClickListener(new View.OnClickListener() {
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

        t10ZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
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

        t10Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //Example Solutions

        TextView[] solutions = {t10SolutionExample1, t10SolutionExample2, t10SolutionExample3, t10SolutionExample4, t10SolutionExample5};
        LinearLayout[] solLayout = {t10Solution1, t10Solution2, t10Solution3, t10Solution4, t10Solution5};

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

        t10Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuDialog();
            }
        });

        t10ActStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t10ActLayout.setVisibility(View.VISIBLE);
                t10ActOpts.setVisibility(View.VISIBLE);
                t10ActAnsLayout.setVisibility(View.INVISIBLE);
                t10ActSolText.setVisibility(View.GONE);
                t10ActStart.setVisibility(View.GONE);
                t10ActDirection.setText("Read and understand each question carefully and select your answer from the multiple-choice options.");
                t10ActFeedback.setImageDrawable(null);
                t10ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(8).build());
                Button[] buttons = {t10ActOpt1, t10ActOpt2, t10ActOpt3, t10ActOpt4};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
                t10ActSubmit.setText("Submit");
                t10ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                currentIndex = 0;
                score = 0;
                nextQuestion = false;
                generateT10ActQuestions();
            }
        });

        t10ActSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nextQuestion == false) {
                    nextQuestion = true;
                    t10ActSubmit.setText("Next");
                    t10ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.black));
                    Button[] buttons = {t10ActOpt1, t10ActOpt2, t10ActOpt3, t10ActOpt4};
                    for (int i = 0; i < buttons.length; i++) {
                        buttons[i].setEnabled(false);
                    }
                    t10ActSolText.setVisibility(View.VISIBLE);
                    t10ActAns.setLatexDrawable(JLatexMathDrawable.builder(solution).textSize(50).background(0xFFb0d6f5).padding(10).build());
                    if (selectedAnswer.equals(answer)) {
                        t10ActFeedback.setImageResource(R.drawable.round_check_24);
                        score++;
                    } else {
                        t10ActFeedback.setImageResource(R.drawable.round_clear_24);
                    }
                }else {
                    currentIndex++;
                    if (currentIndex < t10ActQuesLength) {
                        generateT10ActQuestions();
                        nextQuestion = false;
                        t10ActAnsLayout.setVisibility(View.INVISIBLE);
                        t10ActSolText.setVisibility(View.GONE);
                        t10ActSubmit.setText("Submit");
                        t10ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                        t10ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(10).build());
                        t10ActFeedback.setImageDrawable(null);
                        Button[] buttons = {t10ActOpt1, t10ActOpt2, t10ActOpt3, t10ActOpt4};
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

        t10ActOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t10ActOpt1.getText().toString();
                t10ActAnsLayout.setVisibility(View.VISIBLE);
                t10ActOpt1.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t10ActOpt1.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t10ActOpt4, t10ActOpt2, t10ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t10ActOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t10ActOpt2.getText().toString();
                t10ActAnsLayout.setVisibility(View.VISIBLE);
                t10ActOpt2.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t10ActOpt2.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t10ActOpt4, t10ActOpt1, t10ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t10ActOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t10ActOpt3.getText().toString();
                t10ActAnsLayout.setVisibility(View.VISIBLE);
                t10ActOpt3.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t10ActOpt3.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t10ActOpt4, t10ActOpt2, t10ActOpt1};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t10ActOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t10ActOpt4.getText().toString();
                t10ActAnsLayout.setVisibility(View.VISIBLE);
                t10ActOpt4.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t10ActOpt4.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t10ActOpt1, t10ActOpt2, t10ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
    }

    private void generateT10ActQuestions() {
        t10ActQuestion.setText(activityQuestions.getT10ActQuestions(currentIndex));
        t10ActOpt1.setText(activityQuestions.getT10ActChoice1(currentIndex));
        t10ActOpt2.setText(activityQuestions.getT10ActChoice2(currentIndex));
        t10ActOpt3.setText(activityQuestions.getT10ActChoice3(currentIndex));
        t10ActOpt4.setText(activityQuestions.getT10ActChoice4(currentIndex));
        answer = activityQuestions.getT10ActAnswers(currentIndex);
        solution = activityQuestions.getT10ActSolutions(currentIndex);
    }

    private void showScore() {
        t10ActLayout.setVisibility(View.GONE);
        t10ActOpts.setVisibility(View.GONE);
        t10ActAnsLayout.setVisibility(View.GONE);
        t10ActStart.setVisibility(View.VISIBLE);
        t10ActStart.setText("Try Again");
        String actDirectionFormat = "Assessment Complete!<br>Your score is <b>" + score + "</b> out of " + t10ActQuesLength + ".";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            t10ActDirection.setText(Html.fromHtml(actDirectionFormat, Html.FROM_HTML_MODE_COMPACT));
        } else {
            t10ActDirection.setText(Html.fromHtml(actDirectionFormat));
        }
        t10ActScore.setText("Score: " + score + "/" + t10ActQuesLength);
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
        LayoutInflater inflater = LayoutInflater.from(TopicTenActivity.this);
        View view =  inflater.inflate(R.layout.custom_menu, null);

        TextView objectives = view.findViewById(R.id.objectives);
        TextView introduction = view.findViewById(R.id.introduction);
        TextView examples = view.findViewById(R.id.examples);
        TextView activities =view.findViewById(R.id.activities);
        TextView assessment = view.findViewById(R.id.assessment);

        TextView menu[] = {objectives, introduction, examples, activities, assessment};
        TextView title[] = {t10TextViewTitle1, t10TextViewTitle2, t10TextViewTitle3, t10TextViewTitle4, t10TextViewTitle5};
        String format[] = {"<u>Objectives</u>", "<u>Introduction to lesson</u>", "<u>Illustrative Examples</u>", "<u>Activities</u>", "<u>Assessment</u>"};

        AlertDialog.Builder builder = new AlertDialog.Builder(TopicTenActivity.this);
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
                    t10ScrollView.smoothScrollTo(0, title[finalI].getTop());
                    dialog.dismiss();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        endTime10 = System.currentTimeMillis();
        long timeDiff = endTime10 - startTime10;
        int newTime = (int) (timeDiff / 1000);

        Boolean checkId = dbHandler.checkTopicsId(826);
        if (checkId == true) {
            Map<String, String> studyTime = dbHandler.getTopicsId(826);
            if (!studyTime.isEmpty()) {
                int prevTime = Integer.parseInt(studyTime.get(TIME_IN_SEC));
                int totalTime = newTime + prevTime;
                dbHandler.updateTime(new StudyModelClass(826, totalTime));
            }
        } else {
            dbHandler.storeStudyTime(new StudyModelClass(826, newTime));
        }

        super.onBackPressed();
    }
}