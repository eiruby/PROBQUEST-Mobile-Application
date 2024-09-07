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
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.ZoomControls;

import com.enverzo.probquest.DBHandler;
import com.enverzo.probquest.R;

import java.util.Map;

import ru.noties.jlatexmath.JLatexMathDrawable;
import ru.noties.jlatexmath.JLatexMathView;

public class TopicFourActivity extends AppCompatActivity {
    private TextView t4TextViewTitle1, t4TextViewTitle2, t4TextViewTitle3, t4TextViewTitle4, t4TextViewTitle5, t4TextViewTitle6, t4TextView1, t4TextView2, t4TextView3, t4TextView4, t4TextView5, t4TextView6, t4TextView7, t4TextView8, t4TextView9, t4TextView10, t4TextView11, t4TextView12, t4TextView13, t4TextView14, t4TextView15, t4TextView16, t4TextView17, t4TextView18, t4TextView19, t4TextView20, t4TextView21, t4TextView22, t4TextView23, t4TextView24, t4TextView25, t4TextView26, t4TextView27, t4TextView28, t4TextView29, t4TextView30, t4TextView31, t4TextView32, t4ActScore, t4ActSolText, t4ActDirection, t4ActQuestion, t4Act1Direction, t4Act1Problems, t4Act2Direction, t4Act2Problems, t4Act3Direction, t4Act3Problems, t4Act4Direction, t4Act4Problems, t4Act5Direction, t4SolutionExample1, t4SolutionExample2, t4SolutionExample3, t4SolutionExample4, t4SolutionExample5;
    private JLatexMathView t4Latex_1, t4Latex_2, t4Latex_3, t4Latex_4, t4Latex_5, t4Latex_6, t4Latex_7, t4Latex_8, t4Latex_9, t4Latex_10, t4Latex_11, t4ActAns;
    private ImageView t4Back, t4ActFeedback, t4Menu;
    private Button t4ActStart, t4ActOpt1, t4ActOpt2, t4ActOpt3, t4ActOpt4, t4ActSubmit;
    private LinearLayout t4ActLayout, t4ActOpts, t4ActAnsLayout, t4Solution1, t4Solution2, t4Solution3, t4Solution4, t4Solution5;
    private VideoView t4Video;
    private ZoomControls t4ZoomControls;
    private ScrollView t4ScrollView;
    private int textSize = 16, currentIndex, score;
    private String selectedAnswer, answer;
    private boolean nextQuestion = false, hideSolution = true;
    private long startTime4, endTime4, scoreValue;
    private ActivityQuestions activityQuestions = new ActivityQuestions();
    private int t4ActQuesLength = activityQuestions.t4ActQuestions.length;
    private static final String PREFS_FILE_NAME = "ActivityScore4";
    private static final String KEY_SCORE = "score";
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_four);

        dbHandler = new DBHandler(this);

        t4Back = findViewById(R.id.t4Back);
        t4TextViewTitle1 = findViewById(R.id.t4TextViewTitle1);
        t4TextViewTitle2 = findViewById(R.id.t4TextViewTitle2);
        t4TextViewTitle3 = findViewById(R.id.t4TextViewTitle3);
        t4TextViewTitle4 = findViewById(R.id.t4TextViewTitle4);
        t4TextViewTitle5 = findViewById(R.id.t4TextViewTitle5);
        t4TextViewTitle6 = findViewById(R.id.t4TextViewTitle6);
        t4TextView1 = findViewById(R.id.t4TextView1);
        t4TextView2 = findViewById(R.id.t4TextView2);
        t4TextView3 = findViewById(R.id.t4TextView3);
        t4TextView4 = findViewById(R.id.t4TextView4);
        t4TextView5 = findViewById(R.id.t4TextView5);
        t4TextView6 = findViewById(R.id.t4TextView6);
        t4TextView7 = findViewById(R.id.t4TextView7);
        t4TextView8 = findViewById(R.id.t4TextView8);
        t4TextView9 = findViewById(R.id.t4TextView9);
        t4TextView10 = findViewById(R.id.t4TextView10);
        t4TextView11 = findViewById(R.id.t4TextView11);
        t4TextView12 = findViewById(R.id.t4TextView12);
        t4TextView13 = findViewById(R.id.t4TextView13);
        t4TextView14 = findViewById(R.id.t4TextView14);
        t4TextView15 = findViewById(R.id.t4TextView15);
        t4TextView16 = findViewById(R.id.t4TextView16);
        t4TextView17 = findViewById(R.id.t4TextView17);
        t4TextView18 = findViewById(R.id.t4TextView18);
        t4TextView19 = findViewById(R.id.t4TextView19);
        t4TextView20 = findViewById(R.id.t4TextView20);
        t4TextView21 = findViewById(R.id.t4TextView21);
        t4TextView22 = findViewById(R.id.t4TextView22);
        t4TextView23 = findViewById(R.id.t4TextView23);
        t4TextView24 = findViewById(R.id.t4TextView24);
        t4TextView25 = findViewById(R.id.t4TextView25);
        t4TextView26 = findViewById(R.id.t4TextView26);
        t4TextView27 = findViewById(R.id.t4TextView27);
        t4TextView28 = findViewById(R.id.t4TextView28);
        t4TextView29 = findViewById(R.id.t4TextView29);
        t4TextView30 = findViewById(R.id.t4TextView30);
        t4TextView31 = findViewById(R.id.t4TextView31);
        t4TextView32 = findViewById(R.id.t4TextView32);
        t4SolutionExample1 = findViewById(R.id.t4SolutionExample1);
        t4SolutionExample2 = findViewById(R.id.t4SolutionExample2);
        t4SolutionExample3 = findViewById(R.id.t4SolutionExample3);
        t4SolutionExample4 = findViewById(R.id.t4SolutionExample4);
        t4SolutionExample5 = findViewById(R.id.t4SolutionExample5);
        t4Solution1 = findViewById(R.id.t4Solution1);
        t4Solution2 = findViewById(R.id.t4Solution2);
        t4Solution3 = findViewById(R.id.t4Solution3);
        t4Solution4 = findViewById(R.id.t4Solution4);
        t4Solution5 = findViewById(R.id.t4Solution5);
        t4Latex_1 = findViewById(R.id.t4Latex_1);
        t4Latex_2 = findViewById(R.id.t4Latex_2);
        t4Latex_3 = findViewById(R.id.t4Latex_3);
        t4Latex_4 = findViewById(R.id.t4Latex_4);
        t4Latex_5 = findViewById(R.id.t4Latex_5);
        t4Latex_6 = findViewById(R.id.t4Latex_6);
        t4Latex_7 = findViewById(R.id.t4Latex_7);
        t4Latex_8 = findViewById(R.id.t4Latex_8);
        t4Latex_9 = findViewById(R.id.t4Latex_9);
        t4Latex_10 = findViewById(R.id.t4Latex_10);
        t4Latex_11 = findViewById(R.id.t4Latex_11);
        t4Video = findViewById(R.id.t4Video);
        t4Menu = findViewById(R.id.t4Menu);
        t4ScrollView = findViewById(R.id.t4ScrollView);
        t4ZoomControls = findViewById(R.id.t4ZoomControls);
        t4ActScore = findViewById(R.id.t4ActScore);
        t4ActDirection = findViewById(R.id.t4ActDirection);
        t4ActQuestion = findViewById(R.id.t4ActQuestion);
        t4ActSolText = findViewById(R.id.t4ActSolText);
        t4ActFeedback = findViewById(R.id.t4ActFeedback);
        t4ActAns = findViewById(R.id.t4ActAns);
        t4ActStart = findViewById(R.id.t4ActStart);
        t4ActOpt1 = findViewById(R.id.t4ActOpt1);
        t4ActOpt2 = findViewById(R.id.t4ActOpt2);
        t4ActOpt3 = findViewById(R.id.t4ActOpt3);
        t4ActOpt4 = findViewById(R.id.t4ActOpt4);
        t4ActSubmit = findViewById(R.id.t4ActSubmit);
        t4ActLayout = findViewById(R.id.t4ActLayout);
        t4ActOpts = findViewById(R.id.t4ActOpts);
        t4ActAnsLayout = findViewById(R.id.t4ActAnsLayout);
        t4Act1Direction = findViewById(R.id.t4Act1Direction);
        t4Act2Direction = findViewById(R.id.t4Act2Direction);
        t4Act3Direction = findViewById(R.id.t4Act3Direction);
        t4Act4Direction = findViewById(R.id.t4Act4Direction);
        t4Act5Direction = findViewById(R.id.t4Act5Direction);
        t4Act1Problems = findViewById(R.id.t4Act1Problems);
        t4Act2Problems = findViewById(R.id.t4Act2Problems);
        t4Act3Problems = findViewById(R.id.t4Act3Problems);
        t4Act4Problems = findViewById(R.id.t4Act4Problems);

        startTime4 = System.currentTimeMillis();

        t4Latex_1.setLatexDrawable(JLatexMathDrawable.builder("P(A \\cup B) = P(A \\text{ or } B) = P(A) + P(B) - P(A \\text{ and } B)").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t4Latex_2.setLatexDrawable(JLatexMathDrawable.builder("P(3) = \\frac{1}{6} \\text{,}\\\\P(\\text{odd number}) = \\frac{3}{6} \\text{, and}\\\\P(\\text{3 and odd number}) = \\frac{1}{6}").textSize(50).background(0xFFffffff).padding(10).build());
        t4Latex_3.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ or } B) = P(A) + P(B) - P(A \\text{ and } B) \\\\ P(\\text{3 or odd number}) \\\\ = P(3) + P(\\text{odd number}) - P(\\text{3 and odd number}) \\\\ = \\frac{1}{6} + \\frac{3}{6} - \\frac{1}{6}\\\\= \\frac{3}{6}\\\\= \\frac{1}{2}").textSize(50).background(0xFFffffff).padding(10).build());
        t4Latex_4.setLatexDrawable(JLatexMathDrawable.builder("P(\\text{red card}) = \\frac{26}{52} = \\frac{1}{2} \\\\ P(\\text{face card}) = \\frac{12}{52} = \\frac{4}{13} \\\\ P(\\text{red and face card}) = \\frac{6}{52} = \\frac{3}{26}").textSize(50).background(0xFFffffff).padding(10).build());
        t4Latex_5.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ or } B) = P(A) + P(B) - P(A \\text{ and } B) \\\\ P(\\text{red or face card}) \\\\ = P(red card) + P(\\text{face card}) - P(\\text{red and face card}) \\\\ = \\frac{26}{52} + \\frac{12}{52} - \\frac{6}{52} \\\\ = \\frac{32}{52} \\\\ = \\frac{8}{13}").textSize(50).background(0xFFffffff).padding(10).build());
        t4Latex_6.setLatexDrawable(JLatexMathDrawable.builder("n(\\text{vowel}) = 4 \\\\ n(\\text{vowel and letter}) = 4 \\\\ n(S) = 26").textSize(50).background(0xFFffffff).padding(10).build());
        t4Latex_7.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ or } B) = P(A) + P(B) - P(A \\text{ and } B) \\\\ P(\\text{vowel or letter}) \\\\ = P(\\text{vowel}) + P(\\text{letter}) - P(\\text{vowel and letter}) \\\\ = \\frac{4}{26} + \\frac{7}{26} - \\frac{4}{26} \\\\ = \\frac{7}{26}").textSize(50).background(0xFFffffff).padding(10).build());
        t4Latex_8.setLatexDrawable(JLatexMathDrawable.builder("P(\\text{even number}) = \\frac{15}{30} \\\\ P(\\text{Multiple of 5}) = \\frac{6}{30} \\\\ P(\\text{even number and multiple of 5}) = \\frac{3}{30}").textSize(50).background(0xFFffffff).padding(10).build());
        t4Latex_9.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ or } B) = P(A) + P(B) - P(A \\text{ and } B) \\\\ P(\\text{even or multiple of 5}) \\\\ = P(\\text{even}) + P(\\text{multiple of 5}) - P(\\text{even and multiple of 5}) \\\\ = \\frac{15}{30} + \\frac{6}{30} - \\frac{3}{30} \\\\ = \\frac{18}{30} \\\\ = \\frac{3}{5}").textSize(50).background(0xFFffffff).padding(10).build());
        t4Latex_10.setLatexDrawable(JLatexMathDrawable.builder("n(\\text{men}) = 18 \\\\ n(\\text{women}) = 12 \\\\ n(\\text{married men}) = \\frac{2}{3} × 18 = 12 \\\\ n(\\text{married women}) = \\frac{1}{2} × 12 = 6 \\\\ \\text{Thus,} \\\\ n(\\text{men}) = 18 \\\\ n(\\text{married}) = 12 + 6 = 18 \\\\ n(\\text{man and married}) = 12 \\\\ n(S) = 30").textSize(50).background(0xFFffffff).padding(10).build());
        t4Latex_11.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ or } B) = P(A) + P(B) - P(A \\text{ and } B) \\\\ P(\\text{man or married}) \\\\ = P(\\text{man}) + P(\\text{married}) - P(\\text{man and married}) \\\\ = \\frac{18}{30} + \\frac{18}{30} - \\frac{12}{30} \\\\ = \\frac{24}{30} \\\\ = \\frac{4}{5}").textSize(50).background(0xFFffffff).padding(10).build());

        String t4TextViewFormat2 = "<b><i>What is a Non-Mutually Exclusive Event?</i></b><br><br><b>Non-mutually exclusive events</b> are events that can happen at the same time. For example, landing an even number or a number divisible by 4 on a die. These two events have a possibility that both events can happen together. Also, two sets are <i>non-mutually exclusive</i> if they share common elements.<br><br>Consider the set A as all numbers from 10 to 20, and the set B as all multiples of 3 from 1 to 20:";
        String t4TextViewFormat3 = "Set A = {10, 11, <b>12</b>, 13, 14, <b>15</b>, 16, 17, <b>18</b>, 19, 20}<br>Set B = {3, 6, 9, <b>12</b>, <b>15</b>, <b>18</b>}";
        String t4TextViewFormat4 = "We call them <b>non-mutually exclusive</b> since they share the common elements of 12, 15, and 18.<br><br><i>Other examples of non-mutually exclusive events are the following:</i>";
        String t4TextViewFormat6 = "<b><i>How to calculate the probability of non-mutually exclusive events?</i></b><br><br>If A and B are two non-mutually exclusive events, then the probability of <b>A or B</b> occurring is both of their probabilities added together and subtracting the probability of both of them occurring.";
        String t4TextViewFormat8 = "<b>Example 1</b><br><br>What is the probability of a die showing a number 3 or an odd number?";
        String t4TextViewFormat13 = "<b>Example 2</b><br><br>A card is drawn at random from a well-shuffled deck of 52 cards. Find the probability that the card drawn is a red or a face card?";
        String t4TextViewFormat18 = "<b>Example 3</b><br><br>Twenty-six tiles, each with a letter of the English alphabet, are placed in a bag and one tile is drawn at random. What is the probability of selecting a vowel or a letter from the word <i>courage</i>?";
        String t4TextViewFormat20 = "P(A) is the probability of selecting a vowel from the word <i>courage</i><br>P(B) is the probability of selecting a letter from the word <i>courage</i><br>P(A and B) is the probability of selecting a vowel or a letter from the word <i>courage</i><br><br>From the word <i>courage</i>, there are 4 vowels {o, u, a, e}, and 7 letters {c, o, u, r, a, g, e}.<br>Observe that the vowels and the 7 letters have common elements, that is, the vowels itself {o, u, a, e}.<br><br>Thus,";
        String t4TextViewFormat22 = "The probability of selecting a vowel or a letter from the word <i>courage</i> is 7/26.";
        String t4TextViewFormat23 = "<b>Example 4</b><br><br>Each of the numbers 1 – 30 is written on a slip of paper, rolled and put in a box and mixed thoroughly. One number is picked up at random. Find the probability that the picked number is even or a multiple of 5?";
        String t4TextViewFormat28 = "<b>Example 5</b><br><br>The Shoes store has 30 employees, 18 men and 12 women. Two-thirds of the men and half of the women are married. Find the probability that one of the employees chosen at random is a man or is married?";
        String t4Act1DirectionFormat = "<b>Activity 1</b><br><br>A die is rolled. What is the probability of getting";
        String t4Act2DirectionFormat = "<b>Activity 2</b><br><br>A card is drawn at random from a deck of cards. What is the probability of getting";
        String t4Act3DirectionFormat = "<b>Activity 3</b><br><br>Each of the numbers 1 – 30 is written on a slip of paper, rolled and put in a box and mixed thoroughly. One number is picked up at random. What is the probability that the picked number is";
        String t4Act4DirectionFormat = "<b>Activity 4</b><br><br>The Shoes store has 40 employees, 24 men and 16 women. Two – thirds of the men and half of the women are married. What is the probability that one of the employees chosen at random is";
        String t4Act5DirectionFormat = "<b>Activity 5</b><br><br>Twenty – six tiles, each with a letter of the English alphabet, are placed in a bag and one tile is drawn at random. What is the probability of selecting a consonant or a letter from the word smart?";

        TextView[] textViewHtml = {t4TextView2, t4TextView3, t4TextView4, t4TextView6, t4TextView8, t4TextView13, t4TextView18, t4TextView20, t4TextView22, t4TextView23, t4TextView28, t4Act1Direction, t4Act2Direction, t4Act3Direction, t4Act4Direction, t4Act5Direction};
        String[] textViewFormat = {t4TextViewFormat2, t4TextViewFormat3, t4TextViewFormat4, t4TextViewFormat6, t4TextViewFormat8, t4TextViewFormat13, t4TextViewFormat18, t4TextViewFormat20, t4TextViewFormat22, t4TextViewFormat23, t4TextViewFormat28, t4Act1DirectionFormat, t4Act2DirectionFormat, t4Act3DirectionFormat, t4Act4DirectionFormat, t4Act5DirectionFormat};

        for (int i = 0; i < textViewHtml.length; i++) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i], Html.FROM_HTML_MODE_COMPACT));
            } else {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i]));
            }
        }

        loadScore();
        t4ActScore.setText("Score: " + scoreValue + "/" + t4ActQuesLength);

        t4Video.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.nonmutually_exclusive_events);
        MediaController mediaController = new MediaController(TopicFourActivity.this);
        mediaController.setAnchorView(t4Video);
        t4Video.setMediaController(mediaController);

        TextView[] textViewTitle = {t4TextViewTitle1, t4TextViewTitle2, t4TextViewTitle3, t4TextViewTitle4, t4TextViewTitle5, t4TextViewTitle6};
        TextView[] textView = {t4TextView1, t4TextView2, t4TextView3, t4TextView4, t4TextView5, t4TextView6, t4TextView7, t4TextView8, t4TextView9, t4TextView10, t4TextView11, t4TextView12, t4TextView13, t4TextView14, t4TextView15, t4TextView16, t4TextView17, t4TextView18, t4TextView19, t4TextView20, t4TextView21, t4TextView22, t4TextView23, t4TextView24, t4TextView25, t4TextView26, t4TextView27, t4TextView28, t4TextView29, t4TextView30, t4TextView31, t4TextView32, t4ActScore, t4ActSolText, t4ActDirection, t4ActQuestion, t4Act1Direction, t4Act1Problems, t4Act2Direction, t4Act2Problems, t4Act3Direction, t4Act3Problems, t4Act4Direction, t4Act4Problems, t4Act5Direction, t4SolutionExample1, t4SolutionExample2, t4SolutionExample3, t4SolutionExample4, t4SolutionExample5};

        t4ZoomControls.setOnZoomInClickListener(new View.OnClickListener() {
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

        t4ZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
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

        t4Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //Example Solutions

        TextView[] solutions = {t4SolutionExample1, t4SolutionExample2, t4SolutionExample3, t4SolutionExample4, t4SolutionExample5};
        LinearLayout[] solLayout = {t4Solution1, t4Solution2, t4Solution3, t4Solution4, t4Solution5};

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

        t4Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuDialog();
            }
        });

        t4ActStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t4ActLayout.setVisibility(View.VISIBLE);
                t4ActOpts.setVisibility(View.VISIBLE);
                t4ActAnsLayout.setVisibility(View.INVISIBLE);
                t4ActSolText.setVisibility(View.GONE);
                t4ActStart.setVisibility(View.GONE);
                t4ActDirection.setText("Read and understand each question carefully and select your answer from the multiple-choice options.");
                t4ActFeedback.setImageDrawable(null);
                t4ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(10).build());
                Button[] buttons = {t4ActOpt1, t4ActOpt2, t4ActOpt3, t4ActOpt4};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
                t4ActSubmit.setText("Submit");
                t4ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                currentIndex = 0;
                score = 0;
                nextQuestion = false;
                generateT4ActQuestions();
            }
        });

        t4ActSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nextQuestion == false) {
                    nextQuestion = true;
                    t4ActSubmit.setText("Next");
                    t4ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.black));
                    Button[] buttons = {t4ActOpt1, t4ActOpt2, t4ActOpt3, t4ActOpt4};
                    for (int i = 0; i < buttons.length; i++) {
                        buttons[i].setEnabled(false);
                    }
                    t4ActSolText.setVisibility(View.VISIBLE);
                    t4ActAns.setLatexDrawable(JLatexMathDrawable.builder(answer).textSize(50).background(0xFFb0d6f5).padding(10).build());
                    if (selectedAnswer.equals(answer)) {
                        t4ActFeedback.setImageResource(R.drawable.round_check_24);
                        score++;
                    } else {
                        t4ActFeedback.setImageResource(R.drawable.round_clear_24);
                    }
                }else {
                    currentIndex++;
                    if (currentIndex < t4ActQuesLength) {
                        generateT4ActQuestions();
                        nextQuestion = false;
                        t4ActAnsLayout.setVisibility(View.INVISIBLE);
                        t4ActSolText.setVisibility(View.GONE);
                        t4ActSubmit.setText("Submit");
                        t4ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                        t4ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(10).build());
                        t4ActFeedback.setImageDrawable(null);
                        Button[] buttons = {t4ActOpt1, t4ActOpt2, t4ActOpt3, t4ActOpt4};
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

        t4ActOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t4ActOpt1.getText().toString();
                t4ActAnsLayout.setVisibility(View.VISIBLE);
                t4ActSolText.setVisibility(View.GONE);
                t4ActOpt1.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t4ActOpt1.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t4ActOpt4, t4ActOpt2, t4ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t4ActOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t4ActOpt2.getText().toString();
                t4ActAnsLayout.setVisibility(View.VISIBLE);
                t4ActSolText.setVisibility(View.GONE);
                t4ActOpt2.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t4ActOpt2.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t4ActOpt1, t4ActOpt4, t4ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t4ActOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t4ActOpt3.getText().toString();
                t4ActAnsLayout.setVisibility(View.VISIBLE);
                t4ActSolText.setVisibility(View.GONE);
                t4ActOpt3.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t4ActOpt3.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t4ActOpt1, t4ActOpt2, t4ActOpt4};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t4ActOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t4ActOpt4.getText().toString();
                t4ActAnsLayout.setVisibility(View.VISIBLE);
                t4ActSolText.setVisibility(View.GONE);
                t4ActOpt4.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t4ActOpt4.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t4ActOpt1, t4ActOpt2, t4ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

    }

    private void generateT4ActQuestions() {
        t4ActQuestion.setText(activityQuestions.getT4ActQuestions(currentIndex));
        t4ActOpt1.setText(activityQuestions.getT4ActChoice1(currentIndex));
        t4ActOpt2.setText(activityQuestions.getT4ActChoice2(currentIndex));
        t4ActOpt3.setText(activityQuestions.getT4ActChoice3(currentIndex));
        t4ActOpt4.setText(activityQuestions.getT4ActChoice4(currentIndex));
        answer = activityQuestions.getT4ActAnswers(currentIndex);
    }

    private void showScore() {
        t4ActLayout.setVisibility(View.GONE);
        t4ActOpts.setVisibility(View.GONE);
        t4ActAnsLayout.setVisibility(View.GONE);
        t4ActStart.setVisibility(View.VISIBLE);
        t4ActStart.setText("Try Again");
        String actDirectionFormat = "Assessment Complete!<br>Your score is <b>" + score + "</b> out of " + t4ActQuesLength + ".";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            t4ActDirection.setText(Html.fromHtml(actDirectionFormat, Html.FROM_HTML_MODE_COMPACT));
        } else {
            t4ActDirection.setText(Html.fromHtml(actDirectionFormat));
        }
        t4ActScore.setText("Score: " + score + "/" + t4ActQuesLength);
        storescore(score);
    }

    private void storescore(int score) {
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
        LayoutInflater inflater = LayoutInflater.from(TopicFourActivity.this);
        View view =  inflater.inflate(R.layout.custom_menu, null);

        TextView objectives = view.findViewById(R.id.objectives);
        TextView introduction = view.findViewById(R.id.introduction);
        TextView examples = view.findViewById(R.id.examples);
        TextView activities =view.findViewById(R.id.activities);
        TextView assessment = view.findViewById(R.id.assessment);

        TextView menu[] = {objectives, introduction, examples, activities, assessment};
        TextView title[] = {t4TextViewTitle1, t4TextViewTitle2, t4TextViewTitle3, t4TextViewTitle4, t4TextViewTitle5};
        String format[] = {"<u>Objectives</u>", "<u>Introduction to lesson</u>", "<u>Illustrative Examples</u>", "<u>Activities</u>", "<u>Assessment</u>"};

        AlertDialog.Builder builder = new AlertDialog.Builder(TopicFourActivity.this);
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
                    t4ScrollView.smoothScrollTo(0, title[finalI].getTop());
                    dialog.dismiss();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        endTime4 = System.currentTimeMillis();
        long timeDiff = endTime4 - startTime4;
        int newTime = (int) (timeDiff / 1000);

        Boolean checkId = dbHandler.checkTopicsId(613);
        if (checkId == true) {
            Map<String, String> studyTime = dbHandler.getTopicsId(613);
            if (!studyTime.isEmpty()) {
                int prevTime = Integer.parseInt(studyTime.get(TIME_IN_SEC));
                int totalTime = newTime + prevTime;
                dbHandler.updateTime(new StudyModelClass(613, totalTime));
            }
        } else {
            dbHandler.storeStudyTime(new StudyModelClass(613, newTime));
        }

        super.onBackPressed();
    }
}