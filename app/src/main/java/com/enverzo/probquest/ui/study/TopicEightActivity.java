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
import android.widget.GridLayout;
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

public class TopicEightActivity extends AppCompatActivity {
    private TextView t8TextViewTitle1, t8TextViewTitle2, t8TextViewTitle3, t8TextViewTitle4, t8TextViewTitle5, t8TextView1, t8TextView2, t8TextView3, t8TextView4, t8TextView5, t8TextView6, t8TextView7, t8TextView8, t8TextView9, t8TextView10, t8TextView11, t8TextView12, t8TextView13, t8TextView14, t8TextView15, t8TextView16, t8TextView17, t8TextView18, t8TextView19, t8TextView20, t8TextView21, t8TextView22, t8TextView23, t8TextView24, t8TextView25, t8TextView26, t8TextView27, t8TextView28, t8TextView29, t8TextView30, t8TextView31, t8TextView32, t8TextView33, t8TextView34, t8TextView35, t8TextView36, t8TextView37, t8TextView38, t8TextView39, t8TextView40, t8TextView41, t8TextView42, t8TextView43, t8TextView44, t8TextView45, t8ActScore, t8ActDirection, t8ActQuestion, t8ActSolText, t8Act1Direction, t8Act1Problems, t8Act2Direction, t8Act2Problems, t8Act3Direction, t8Act3Problems, t8Act4Direction, t8Act4Problems, t8Act5Direction, t8Act5Problems, t8SolutionExample1, t8SolutionExample2, t8SolutionExample3, t8SolutionExample4, t8SolutionExample5;
    private JLatexMathView t8Latex_1, t8Latex_2, t8Latex_3, t8Latex_4, t8Latex_5, t8Latex_6, t8Latex_7, t8Latex_8, t8Latex_9, t8Latex_10, t8Latex_11, t8Latex_12, t8Latex_13, t8Latex_14, t8Latex_15, t8Latex_16, t8Latex_17, t8ActAns;
    private Button t8ActStart, t8ActOpt1, t8ActOpt2, t8ActOpt3, t8ActOpt4, t8ActSubmit;
    private ImageView t8ActFeedback, t8Back, t8Menu;
    private LinearLayout t8Solution4, t8Solution5, t8ActLayout, t8ActOpts, t8ActAnsLayout;
    private GridLayout t8Solution1, t8Solution2, t8Solution3;
    private ZoomControls t8ZoomControls;
    private ScrollView t8ScrollView;
    private int textSize = 16, currentIndex, score;
    private String selectedAnswer, answer, solution;
    private ActivityQuestions activityQuestions = new ActivityQuestions();
    private int t8ActQuesLength = activityQuestions.t8ActQuestions.length;
    private boolean hideSolution = true, nextQuestion = false;
    private static final String PREFS_FILE_NAME = "ActivityScore8";
    private static final String KEY_SCORE = "score";
    private long startTime8, endTime8, scoreValue;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_eight);

        t8TextViewTitle1 = findViewById(R.id.t8TextViewTitle1);
        t8TextViewTitle2 = findViewById(R.id.t8TextViewTitle2);
        t8TextViewTitle3 = findViewById(R.id.t8TextViewTitle3);
        t8TextViewTitle4 = findViewById(R.id.t8TextViewTitle4);
        t8TextViewTitle5 = findViewById(R.id.t8TextViewTitle5);
        t8TextView1 = findViewById(R.id.t8TextView1);
        t8TextView2 = findViewById(R.id.t8TextView2);
        t8TextView3 = findViewById(R.id.t8TextView3);
        t8TextView4 = findViewById(R.id.t8TextView4);
        t8TextView5 = findViewById(R.id.t8TextView5);
        t8TextView6 = findViewById(R.id.t8TextView6);
        t8TextView7 = findViewById(R.id.t8TextView7);
        t8TextView8 = findViewById(R.id.t8TextView8);
        t8TextView9 = findViewById(R.id.t8TextView9);
        t8TextView10 = findViewById(R.id.t8TextView10);
        t8TextView11 = findViewById(R.id.t8TextView11);
        t8TextView12 = findViewById(R.id.t8TextView12);
        t8TextView13 = findViewById(R.id.t8TextView13);
        t8TextView14 = findViewById(R.id.t8TextView14);
        t8TextView15 = findViewById(R.id.t8TextView15);
        t8TextView16 = findViewById(R.id.t8TextView16);
        t8TextView17 = findViewById(R.id.t8TextView17);
        t8TextView18 = findViewById(R.id.t8TextView18);
        t8TextView19 = findViewById(R.id.t8TextView19);
        t8TextView20 = findViewById(R.id.t8TextView20);
        t8TextView21 = findViewById(R.id.t8TextView21);
        t8TextView22 = findViewById(R.id.t8TextView22);
        t8TextView23 = findViewById(R.id.t8TextView23);
        t8TextView24 = findViewById(R.id.t8TextView24);
        t8TextView25 = findViewById(R.id.t8TextView25);
        t8TextView26 = findViewById(R.id.t8TextView26);
        t8TextView27 = findViewById(R.id.t8TextView27);
        t8TextView28 = findViewById(R.id.t8TextView28);
        t8TextView29 = findViewById(R.id.t8TextView29);
        t8TextView30 = findViewById(R.id.t8TextView30);
        t8TextView31 = findViewById(R.id.t8TextView31);
        t8TextView32 = findViewById(R.id.t8TextView32);
        t8TextView33 = findViewById(R.id.t8TextView33);
        t8TextView34 = findViewById(R.id.t8TextView34);
        t8TextView35 = findViewById(R.id.t8TextView35);
        t8TextView36 = findViewById(R.id.t8TextView36);
        t8TextView37 = findViewById(R.id.t8TextView37);
        t8TextView38 = findViewById(R.id.t8TextView38);
        t8TextView39 = findViewById(R.id.t8TextView39);
        t8TextView40 = findViewById(R.id.t8TextView40);
        t8TextView41 = findViewById(R.id.t8TextView41);
        t8TextView42 = findViewById(R.id.t8TextView42);
        t8TextView43 = findViewById(R.id.t8TextView43);
        t8TextView44 = findViewById(R.id.t8TextView44);
        t8TextView45 = findViewById(R.id.t8TextView45);
        t8Latex_1 = findViewById(R.id.t8Latex_1);
        t8Latex_2 = findViewById(R.id.t8Latex_2);
        t8Latex_3 = findViewById(R.id.t8Latex_3);
        t8Latex_4 = findViewById(R.id.t8Latex_4);
        t8Latex_5 = findViewById(R.id.t8Latex_5);
        t8Latex_6 = findViewById(R.id.t8Latex_6);
        t8Latex_7 = findViewById(R.id.t8Latex_7);
        t8Latex_8 = findViewById(R.id.t8Latex_8);
        t8Latex_9 = findViewById(R.id.t8Latex_9);
        t8Latex_10 = findViewById(R.id.t8Latex_10);
        t8Latex_11 = findViewById(R.id.t8Latex_11);
        t8Latex_12 = findViewById(R.id.t8Latex_12);
        t8Latex_13 = findViewById(R.id.t8Latex_13);
        t8Latex_14 = findViewById(R.id.t8Latex_14);
        t8Latex_15 = findViewById(R.id.t8Latex_15);
        t8Latex_16 = findViewById(R.id.t8Latex_16);
        t8Latex_17 = findViewById(R.id.t8Latex_17);
        t8Solution1 = findViewById(R.id.t8Solution1);
        t8Solution2 = findViewById(R.id.t8Solution2);
        t8Solution3 = findViewById(R.id.t8Solution3);
        t8Solution4 = findViewById(R.id.t8Solution4);
        t8Solution5 = findViewById(R.id.t8Solution5);
        t8SolutionExample1 = findViewById(R.id.t8SolutionExample1);
        t8SolutionExample2 = findViewById(R.id.t8SolutionExample2);
        t8SolutionExample3 = findViewById(R.id.t8SolutionExample3);
        t8SolutionExample4 = findViewById(R.id.t8SolutionExample4);
        t8SolutionExample5 = findViewById(R.id.t8SolutionExample5);
        t8ZoomControls = findViewById(R.id.t8ZoomControls);
        t8ScrollView = findViewById(R.id.t8ScrollView);
        t8Back = findViewById(R.id.t8Back);
        t8Menu = findViewById(R.id.t8Menu);
        t8ActScore = findViewById(R.id.t8ActScore);
        t8ActDirection = findViewById(R.id.t8ActDirection);
        t8ActQuestion = findViewById(R.id.t8ActQuestion);
        t8ActSolText = findViewById(R.id.t8ActSolText);
        t8ActAns = findViewById(R.id.t8ActAns);
        t8ActFeedback = findViewById(R.id.t8ActFeedback);
        t8ActStart = findViewById(R.id.t8ActStart);
        t8ActOpt1 = findViewById(R.id.t8ActOpt1);
        t8ActOpt2 = findViewById(R.id.t8ActOpt2);
        t8ActOpt3 = findViewById(R.id.t8ActOpt3);
        t8ActOpt4 = findViewById(R.id.t8ActOpt4);
        t8ActSubmit = findViewById(R.id.t8ActSubmit);
        t8ActLayout = findViewById(R.id.t8ActLayout);
        t8ActOpts = findViewById(R.id.t8ActOpts);
        t8ActAnsLayout = findViewById(R.id.t8ActAnsLayout);
        t8ActAnsLayout = findViewById(R.id.t8ActAnsLayout);
        t8Act1Direction = findViewById(R.id.t8Act1Direction);
        t8Act2Direction = findViewById(R.id.t8Act2Direction);
        t8Act3Direction = findViewById(R.id.t8Act3Direction);
        t8Act4Direction = findViewById(R.id.t8Act4Direction);
        t8Act5Direction = findViewById(R.id.t8Act5Direction);
        t8Act1Problems = findViewById(R.id.t8Act1Problems);
        t8Act2Problems = findViewById(R.id.t8Act2Problems);
        t8Act3Problems = findViewById(R.id.t8Act3Problems);
        t8Act4Problems = findViewById(R.id.t8Act4Problems);
        t8Act5Problems = findViewById(R.id.t8Act5Problems);

        dbHandler = new DBHandler(this);
        startTime8 = System.currentTimeMillis();

        loadScore();
        t8ActScore.setText("Score: " + scoreValue + "/" + t8ActQuesLength);

        String t8TextViewFormat2 = "<b><i>Permutation of n Different Objects Taken r at a Time</i></b><br><br><b>Permutation</b> is an arrangement of a group of things in a definite order, that is, there is a first element, a second element, a third, etc. In other words, the order of arrangement of the elements is important.<br><br>Consider a set of letters, {L, I, F, E}. How many different ways these 4 letters be arranged if the letters are taken 2 at a time?<br><br><i>Solution</i><br><br>The number of ways to arrange these 4 letters if letters are taken 2 at a time can be determined by <i>listing the different possible arrangements</i>.";
        String t8TextViewFormat4 = "Thus, there are 12 possible arrangements.<br><br>We can also determine the number of possible arrangements using the <i>Fundamental Counting Principle</i>. Since we are to select 2 letters at a time, then we have two positions to fill. Thus, there are 4 choices for the first letter. Once the first letter has been selected, there are only 3 choices for the second letter.";
        String t8TextViewFormat6 = "The process of finding the number of possible arrangements of the set of objects can be generalized to a set of <i><b>n</b></i> objects. There are <i><b>n</b></i> choices for the first selection, <i><b>n – 1</b></i> for the second, <i><b>n – 2</b></i> for the third, and so on. For the <i><b>nth selection</b></i>, there is only one choice.";
        String t8TextViewFormat8 = "In general, <i><b>n</b></i> distinct objects taken <i><b>r</b></i> at a time can be arranged in<br><br><b><i>n(n - 1)(n - 2)(n - 3)(n - 4)...(n - r + 1) ways</i></b><br><br>we can represent this product in the following<br><br><u>Permutations of <i><b>n</b></i> Objects Taken <i><b>r</b></i> at a Time</u><br><br>The number of <i><b>n</b></i> permutations taken <i><b>r</b></i> at a time is";
        String t8TextViewFormat9 = "<b>Example 1</b><br><br>How many 3-letter words can be formed from the word LIFE?";
        String t8TextViewFormat16 = "<b>Example 2</b><br><br>In how many ways can five integers (2,4,6,8,9) permute taken two at a time?";
        String t8TextViewFormat23 = "<b>Example 3</b><br><br>There are 10 semi-finalists of the Miss Universe Philippines beauty pageant. How many ways can the top 3 winners be selected?";
        String t8TextViewFormat28 = "<b>Example 4</b><br><br>In how many ways can 5 children be arranged in a line such that";
        String t8TextViewFormat31 = "The two particular children taken together can be arranged in <sub>2</sub>P<sub>2</sub> or 2!";
        String t8TextViewFormat34 = "<b>Example 5</b><br><br>In how many ways can four different Calculus books and three different Physics books be arranged in a shelf if:";
        String t8TextViewFormat36 = "(a) There are seven books to be arranged but only five books would have space on the shelf.<br><br>Now, we can solve the problem using either the FCP or the formula of <sub>n</sub>P<sub>r</sub>.";
        String t8TextViewFormat40 = "(b) If two particular books are together, then we can treat them as one but are permuted, <sub>2</sub>P<sub>2</sub> or 2!. Thus, we have";
        String t8TextViewFormat41 = "The two particular books that are together, counted as one, and the remaining five books will be permuted, <sub>6</sub>P<sub>6</sub> or 6!. As if we are arranging six books on the shelf.";
        String t8TextViewFormat44 = "(c) The Calculus books can be permuted as <sub>4</sub>P<sub>4</sub> and so with the Physics books as <sub>3</sub>P<sub>3</sub>. Note that these two groupings of books can still be interchanged, which means that the two groups can be permuted as <sub>2</sub>P<sub>2</sub>. To get the arrangements of books of the same kind we have,";
        String t8Act1DirectionFormat = "<b>Activity 1</b><br><br>Evaluate the following.";
        String t8Act2DirectionFormat = "<b>Activity 2</b><br><br>How many four – letter words can be formed from the letters in the word:";
        String t8Act3DirectionFormat = "<b>Activity 3</b><br><br>Solve the following.";
        String t8Act4DirectionFormat = "<b>Activity 4</b><br><br>In how many ways can five different History books and three different Political Science books be arranged in a shelf if:";
        String t8Act5DirectionFormat = "<b>Activity 5</b><br><br>Solve the following";
        String t8Act1ProblemsFormat = "(a) <sub>10</sub>P<sub>4</sub><br>(b) <sub>6</sub>P<sub>6</sub><br>(c) <sub>5</sub>P<sub>3</sub> • <sub>6</sub>P<sub>1</sub><br>(d) <sub>4</sub>P<sub>3</sub> + <sub>3</sub>P<sub>2</sub><br>(e) <sub>x</sub>P<sub>y</sub>";
        String t8Act2ProblemsFormat = "(a) <i>PLANET</i>?<br>(b) <i>LAWYER</i>?<br>(c) <i>HUSBAND</i>?<br>(d) <i>COMPUTER</i>?<br>(e) <i>EARTH</i>?";

        TextView[] textViewHtml = {t8TextView2, t8TextView4, t8TextView6, t8TextView7, t8TextView9, t8TextView16, t8TextView23, t8TextView28, t8TextView31, t8TextView34, t8TextView36, t8TextView40, t8TextView41, t8TextView44, t8Act1Direction, t8Act2Direction, t8Act3Direction, t8Act4Direction, t8Act5Direction, t8Act1Problems, t8Act2Problems};
        String[] textViewFormat = {t8TextViewFormat2, t8TextViewFormat4, t8TextViewFormat6, t8TextViewFormat8, t8TextViewFormat9, t8TextViewFormat16, t8TextViewFormat23, t8TextViewFormat28, t8TextViewFormat31, t8TextViewFormat34, t8TextViewFormat36, t8TextViewFormat40, t8TextViewFormat41, t8TextViewFormat44, t8Act1DirectionFormat, t8Act2DirectionFormat, t8Act3DirectionFormat, t8Act4DirectionFormat, t8Act5DirectionFormat, t8Act1ProblemsFormat, t8Act2ProblemsFormat};

        for (int i = 0; i < textViewHtml.length; i++) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i], Html.FROM_HTML_MODE_COMPACT));
            } else {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i]));
            }
        }

        t8Latex_1.setLatexDrawable(JLatexMathDrawable.builder("{}_nP_r = \\frac{n!}{(n-r)!}").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t8Latex_2.setLatexDrawable(JLatexMathDrawable.builder("{}_nP_r = \\frac{n!}{(n-r)!}").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t8Latex_3.setLatexDrawable(JLatexMathDrawable.builder("{}_4P_2 = \\frac{4!}{(4-2)!} = \\frac{4!}{2!} = \\frac{4 \\cdot 3 \\cdot 2 \\cdot 1}{2 \\cdot 1} = 12 \\text{ possible arrrangments}").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t8Latex_4.setLatexDrawable(JLatexMathDrawable.builder("{}_4P_3 = 4 \\cdot 3 \\cdot 2 = 24").textSize(50).background(0xFFffffff).padding(8).build());
        t8Latex_5.setLatexDrawable(JLatexMathDrawable.builder("{}_4P_3 = \\frac{4!}{(4-3)!} = \\frac{4!}{1!}\\\\= \\frac{4 \\cdot 3 \\cdot 2 \\cdot 1!}{1!}\\\\= 24\\text{ possible arrangements}").textSize(50).background(0xFFffffff).padding(8).build());
        t8Latex_6.setLatexDrawable(JLatexMathDrawable.builder("{}_5P_2 = 5 \\cdot 4 = 20").textSize(50).background(0xFFffffff).padding(8).build());
        t8Latex_7.setLatexDrawable(JLatexMathDrawable.builder("{}_5P_2 = \\frac{5!}{(5-2)!} = \\frac{5!}{3!}\\\\= \\frac{5 \\cdot 4 \\cdot 3!}{3!}\\\\= 20\\text{ possible arrangements}").textSize(50).background(0xFFffffff).padding(8).build());
        t8Latex_8.setLatexDrawable(JLatexMathDrawable.builder("{}_{10}P_3 = 10 \\cdot 9 \\cdot 8 = 720").textSize(50).background(0xFFffffff).padding(8).build());
        t8Latex_9.setLatexDrawable(JLatexMathDrawable.builder("{}_{10}P_3 = \\frac{10!}{(10-3)!} = \\frac{10!}{7!}\\\\= \\frac{10 \\cdot 9 \\cdot 8 \\cdot 7!}{7!}\\\\= 720\\text{ possible arrangements}").textSize(50).background(0xFFffffff).padding(8).build());
        t8Latex_10.setLatexDrawable(JLatexMathDrawable.builder("{}_4P_4 = \\frac{4!}{(4-4)!} = \\frac{4!}{0!} = \\frac{4 \\cdot 3 \\cdot 2 \\cdot 1}{1} = 24 \\\\ \\text{ or } 4! = 24 \\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t8Latex_11.setLatexDrawable(JLatexMathDrawable.builder("{}_2P_2 = \\frac{2!}{(2-2)!} = \\frac{2!}{0!} = \\frac{2 \\cdot 1}{1} = 2 \\\\ \\text{ or } 2! = 2 \\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t8Latex_12.setLatexDrawable(JLatexMathDrawable.builder("{}_7P_5 = 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 = 720").textSize(50).background(0xFFffffff).padding(8).build());
        t8Latex_13.setLatexDrawable(JLatexMathDrawable.builder("{}_7P_5 = \\frac{7!}{(7-5)!} = \\frac{7!}{2!}\\\\= \\frac{7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2!}{2!}\\\\= 2,520\\text{ possible arrangements}").textSize(50).background(0xFFffffff).padding(8).build());
        t8Latex_14.setLatexDrawable(JLatexMathDrawable.builder("{}_2P_2 = \\frac{2!}{(2-2)!} = \\frac{2!}{0!} = \\frac{2 \\cdot 1}{1} = 2 \\\\ \\text{ or } 2! = 2 \\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t8Latex_15.setLatexDrawable(JLatexMathDrawable.builder("{}_6P_6 = \\frac{6!}{(6-6)!} = \\frac{6!}{0!} = \\frac{6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{1} = 720 \\\\ \\text{ or } 6! = 720 \\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t8Latex_16.setLatexDrawable(JLatexMathDrawable.builder("{}_6P_6 \\cdot {}_2P_2 = 720 \\cdot 2 = 1,440 \\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t8Latex_17.setLatexDrawable(JLatexMathDrawable.builder("{}_4P_4 \\cdot {}_3P_3 \\cdot {}_2P_2 \\text{ or } \\\\ 4! \\cdot 3! \\cdot 2! = 288 \\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());


        TextView[] textViewTitle = {t8TextViewTitle1, t8TextViewTitle2, t8TextViewTitle3, t8TextViewTitle4, t8TextViewTitle5};
        TextView[] textView = {t8TextView1, t8TextView2, t8TextView3, t8TextView4, t8TextView5, t8TextView6, t8TextView7, t8TextView8, t8TextView9, t8TextView10, t8TextView11, t8TextView12, t8TextView13, t8TextView14, t8TextView15, t8TextView16, t8TextView17, t8TextView18, t8TextView19, t8TextView20, t8TextView21, t8TextView22, t8TextView23, t8TextView24, t8TextView25, t8TextView26, t8TextView27, t8TextView28, t8TextView29, t8TextView30, t8TextView31, t8TextView32, t8TextView33, t8TextView34, t8TextView35, t8TextView36, t8TextView37, t8TextView38, t8TextView39, t8TextView40, t8TextView41, t8TextView42, t8TextView43, t8TextView44, t8TextView45, t8ActScore, t8ActDirection, t8ActQuestion, t8ActSolText, t8Act1Direction, t8Act1Problems, t8Act2Direction, t8Act2Problems, t8Act3Direction, t8Act3Problems, t8Act4Direction, t8Act4Problems, t8Act5Direction, t8Act5Problems, t8SolutionExample1, t8SolutionExample2, t8SolutionExample3, t8SolutionExample4, t8SolutionExample5};

        t8ZoomControls.setOnZoomInClickListener(new View.OnClickListener() {
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

        t8ZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
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

        t8Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //Example Solutions

        TextView[] solutions = {t8SolutionExample1, t8SolutionExample2, t8SolutionExample3, t8SolutionExample4, t8SolutionExample5};

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
                        if(finalI == 0) {
                            t8Solution1.setVisibility(View.VISIBLE);
                        }
                        if (finalI == 1) {
                            t8Solution2.setVisibility(View.VISIBLE);
                        }
                        if (finalI == 2) {
                            t8Solution3.setVisibility(View.VISIBLE);
                        }
                        if (finalI == 3) {
                            t8Solution4.setVisibility(View.VISIBLE);
                        }
                        if (finalI == 4) {
                            t8Solution5.setVisibility(View.VISIBLE);
                        }
                        hideSolution = false;
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            solutions[finalI].setText(Html.fromHtml("<u>Show Solution</u>", Html.FROM_HTML_MODE_COMPACT));
                        } else {
                            solutions[finalI].setText(Html.fromHtml("<u>Show Solution</u>"));
                        }
                        if (finalI == 0) {
                            t8Solution1.setVisibility(View.GONE);
                        }
                        if (finalI == 1) {
                            t8Solution2.setVisibility(View.GONE);
                        }
                        if (finalI == 2) {
                            t8Solution3.setVisibility(View.GONE);
                        }
                        if (finalI == 3) {
                            t8Solution4.setVisibility(View.GONE);
                        }
                        if (finalI == 4) {
                            t8Solution5.setVisibility(View.GONE);
                        }
                        hideSolution = true;
                    }
                }
            });
        }

        t8Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuDialog();
            }
        });

        //Assessment

        t8ActStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t8ActLayout.setVisibility(View.VISIBLE);
                t8ActOpts.setVisibility(View.VISIBLE);
                t8ActAnsLayout.setVisibility(View.INVISIBLE);
                t8ActSolText.setVisibility(View.GONE);
                t8ActStart.setVisibility(View.GONE);
                t8ActDirection.setText("Read and understand each question carefully and select your answer from the multiple-choice options.");
                t8ActFeedback.setImageDrawable(null);
                t8ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(8).build());
                Button[] buttons = {t8ActOpt1, t8ActOpt2, t8ActOpt3, t8ActOpt4};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
                t8ActSubmit.setText("Submit");
                t8ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                currentIndex = 0;
                score = 0;
                nextQuestion = false;
                generateT8ActQuestions();
            }
        });

        t8ActSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nextQuestion == false) {
                    nextQuestion = true;
                    t8ActSubmit.setText("Next");
                    t8ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.black));
                    Button[] buttons = {t8ActOpt1, t8ActOpt2, t8ActOpt3, t8ActOpt4};
                    for (int i = 0; i < buttons.length; i++) {
                        buttons[i].setEnabled(false);
                    }
                    t8ActSolText.setVisibility(View.VISIBLE);
                    t8ActAns.setLatexDrawable(JLatexMathDrawable.builder(solution).textSize(50).background(0xFFb0d6f5).padding(10).build());
                    if (selectedAnswer.equals(answer)) {
                        t8ActFeedback.setImageResource(R.drawable.round_check_24);
                        score++;
                    } else {
                        t8ActFeedback.setImageResource(R.drawable.round_clear_24);
                    }
                }else {
                    currentIndex++;
                    if (currentIndex < t8ActQuesLength) {
                        generateT8ActQuestions();
                        nextQuestion = false;
                        t8ActAnsLayout.setVisibility(View.INVISIBLE);
                        t8ActSolText.setVisibility(View.GONE);
                        t8ActSubmit.setText("Submit");
                        t8ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                        t8ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(10).build());
                        t8ActFeedback.setImageDrawable(null);
                        Button[] buttons = {t8ActOpt1, t8ActOpt2, t8ActOpt3, t8ActOpt4};
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

        t8ActOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t8ActOpt1.getText().toString();
                t8ActAnsLayout.setVisibility(View.VISIBLE);
                t8ActOpt1.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t8ActOpt1.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t8ActOpt4, t8ActOpt2, t8ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t8ActOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t8ActOpt2.getText().toString();
                t8ActAnsLayout.setVisibility(View.VISIBLE);
                t8ActOpt2.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t8ActOpt2.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t8ActOpt4, t8ActOpt1, t8ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t8ActOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t8ActOpt3.getText().toString();
                t8ActAnsLayout.setVisibility(View.VISIBLE);
                t8ActOpt3.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t8ActOpt3.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t8ActOpt4, t8ActOpt2, t8ActOpt1};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t8ActOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t8ActOpt4.getText().toString();
                t8ActAnsLayout.setVisibility(View.VISIBLE);
                t8ActOpt4.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t8ActOpt4.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t8ActOpt1, t8ActOpt2, t8ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
    }

    private void generateT8ActQuestions() {
        t8ActQuestion.setText(activityQuestions.getT8ActQuestions(currentIndex));
        t8ActOpt1.setText(activityQuestions.getT8ActChoice1(currentIndex));
        t8ActOpt2.setText(activityQuestions.getT8ActChoice2(currentIndex));
        t8ActOpt3.setText(activityQuestions.getT8ActChoice3(currentIndex));
        t8ActOpt4.setText(activityQuestions.getT8ActChoice4(currentIndex));
        answer = activityQuestions.getT8ActAnswers(currentIndex);
        solution = activityQuestions.getT8ActSolutions(currentIndex);
    }

    private void showScore() {
        t8ActLayout.setVisibility(View.GONE);
        t8ActOpts.setVisibility(View.GONE);
        t8ActAnsLayout.setVisibility(View.GONE);
        t8ActStart.setVisibility(View.VISIBLE);
        t8ActStart.setText("Try Again");
        String actDirectionFormat = "Assessment Complete!<br>Your score is <b>" + score + "</b> out of " + t8ActQuesLength + ".";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            t8ActDirection.setText(Html.fromHtml(actDirectionFormat, Html.FROM_HTML_MODE_COMPACT));
        } else {
            t8ActDirection.setText(Html.fromHtml(actDirectionFormat));
        }
        t8ActScore.setText("Score: " + score + "/" + t8ActQuesLength);
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
        LayoutInflater inflater = LayoutInflater.from(TopicEightActivity.this);
        View view =  inflater.inflate(R.layout.custom_menu, null);

        TextView objectives = view.findViewById(R.id.objectives);
        TextView introduction = view.findViewById(R.id.introduction);
        TextView examples = view.findViewById(R.id.examples);
        TextView activities =view.findViewById(R.id.activities);
        TextView assessment = view.findViewById(R.id.assessment);

        TextView menu[] = {objectives, introduction, examples, activities, assessment};
        TextView title[] = {t8TextViewTitle1, t8TextViewTitle2, t8TextViewTitle3, t8TextViewTitle4, t8TextViewTitle5};
        String format[] = {"<u>Objectives</u>", "<u>Introduction to lesson</u>", "<u>Illustrative Examples</u>", "<u>Activities</u>", "<u>Assessment</u>"};

        AlertDialog.Builder builder = new AlertDialog.Builder(TopicEightActivity.this);
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
                    t8ScrollView.smoothScrollTo(0, title[finalI].getTop());
                    dialog.dismiss();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        endTime8 = System.currentTimeMillis();
        long timeDiff = endTime8 - startTime8;
        int newTime = (int) (timeDiff / 1000);

        Boolean checkId = dbHandler.checkTopicsId(313);
        if (checkId == true) {
            Map<String, String> studyTime = dbHandler.getTopicsId(313);
            if (!studyTime.isEmpty()) {
                int prevTime = Integer.parseInt(studyTime.get(TIME_IN_SEC));
                int totalTime = newTime + prevTime;
                dbHandler.updateTime(new StudyModelClass(313, totalTime));
            }
        } else {
            dbHandler.storeStudyTime(new StudyModelClass(313, newTime));
        }

        super.onBackPressed();
    }
}