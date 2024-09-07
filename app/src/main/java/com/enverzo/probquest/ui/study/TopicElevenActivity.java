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

public class TopicElevenActivity extends AppCompatActivity {
    private TextView t11TextViewTitle1, t11TextViewTitle2, t11TextViewTitle3, t11TextViewTitle4, t11TextViewTitle5, t11TextViewTitle6, t11TextView1, t11TextView2, t11TextView3, t11TextView4, t11TextView5, t11TextView6, t11TextView7, t11TextView8, t11TextView9, t11TextView10, t11TextView11, t11TextView12, t11TextView13, t11TextView14, t11TextView15, t11TextView16, t11TextView17, t11TextView18, t11TextView19, t11TextView20, t11TextView21, t11TextView22, t11TextView23, t11TextView24, t11TextView25, t11TextView26, t11TextView27, t11TextView28, t11TextView29, t11TextView30, t11TextView31, t11TextView32, t11TextView33, t11TextView34, t11TextView35, t11TextView36, t11TextView37, t11TextView38, t11TextView39, t11TextView40, t11ActScore, t11ActSolText, t11ActDirection, t11ActQuestion, t11Act1Direction, t11Act2Direction, t11Act2Problems, t11Act3Direction, t11Act3Problems, t11SolutionExample1, t11SolutionExample2, t11SolutionExample3, t11SolutionExample4;
    private JLatexMathView t11Latex_1, t11Latex_2, t11Latex_3, t11Latex_4, t11Latex_5, t11Latex_6, t11Latex_7, t11Latex_8, t11Latex_9, t11Latex_10, t11Latex_11, t11Latex_12, t11Latex_13, t11Latex_14, t11Latex_15, t11Latex_16, t11Latex_17, t11Latex_18, t11Latex_19, t11Latex_20, t11Latex_21, t11Latex_22, t11Latex_23, t11Latex_24, t11Latex_25, t11Latex_26, t11Latex_27, t11Latex_28, t11Latex_29, t11Latex_30, t11Latex_31, t11Latex_32, t11Latex_33, t11ActAns, t11Act1Problems;
    private Button t11ActStart, t11ActOpt1, t11ActOpt2, t11ActOpt3, t11ActOpt4, t11ActSubmit;
    private ImageView t11ActFeedback, t11Back, t11Menu;
    private LinearLayout t11ActLayout, t11ActOpts, t11ActAnsLayout, t11Solution1, t11Solution2, t11Solution3, t11Solution4;
    private ZoomControls t11ZoomControls;
    private ScrollView t11ScrollView;
    private int textSize = 16, currentIndex, score, actLevel;
    private String selectedAnswer, answer, solution;
    private ActivityQuestions activityQuestions = new ActivityQuestions();
    private int t11ActQuesLength = activityQuestions.t11ActQuestions.length;
    private boolean nextQuestion = false, hideSolution = true;
    private static final String PREFS_FILE_NAME = "ActivityScore11";
    private static final String KEY_SCORE = "score";
    private long startTime11, endTime11, scoreValue;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_eleven);

        t11TextViewTitle1 = findViewById(R.id.t11TextViewTitle1);
        t11TextViewTitle2 = findViewById(R.id.t11TextViewTitle2);
        t11TextViewTitle3 = findViewById(R.id.t11TextViewTitle3);
        t11TextViewTitle4 = findViewById(R.id.t11TextViewTitle4);
        t11TextViewTitle5 = findViewById(R.id.t11TextViewTitle5);
        t11TextView1 = findViewById(R.id.t11TextView1);
        t11TextView2 = findViewById(R.id.t11TextView2);
        t11TextView3 = findViewById(R.id.t11TextView3);
        t11TextView4 = findViewById(R.id.t11TextView4);
        t11TextView5 = findViewById(R.id.t11TextView5);
        t11TextView6 = findViewById(R.id.t11TextView6);
        t11TextView7 = findViewById(R.id.t11TextView7);
        t11TextView8 = findViewById(R.id.t11TextView8);
        t11TextView9 = findViewById(R.id.t11TextView9);
        t11TextView10 = findViewById(R.id.t11TextView10);
        t11TextView11 = findViewById(R.id.t11TextView11);
        t11TextView12 = findViewById(R.id.t11TextView12);
        t11TextView13 = findViewById(R.id.t11TextView13);
        t11TextView14 = findViewById(R.id.t11TextView14);
        t11TextView15 = findViewById(R.id.t11TextView15);
        t11TextView16 = findViewById(R.id.t11TextView16);
        t11TextView17 = findViewById(R.id.t11TextView17);
        t11TextView18 = findViewById(R.id.t11TextView18);
        t11TextView19 = findViewById(R.id.t11TextView19);
        t11TextView20 = findViewById(R.id.t11TextView20);
        t11TextView21 = findViewById(R.id.t11TextView21);
        t11TextView22 = findViewById(R.id.t11TextView22);
        t11TextView23 = findViewById(R.id.t11TextView23);
        t11TextView24 = findViewById(R.id.t11TextView24);
        t11TextView25 = findViewById(R.id.t11TextView25);
        t11TextView26 = findViewById(R.id.t11TextView26);
        t11TextView27 = findViewById(R.id.t11TextView27);
        t11TextView28 = findViewById(R.id.t11TextView28);
        t11TextView29 = findViewById(R.id.t11TextView29);
        t11TextView30 = findViewById(R.id.t11TextView30);
        t11TextView31 = findViewById(R.id.t11TextView31);
        t11TextView32 = findViewById(R.id.t11TextView32);
        t11TextView33 = findViewById(R.id.t11TextView33);
        t11TextView34 = findViewById(R.id.t11TextView34);
        t11TextView35 = findViewById(R.id.t11TextView35);
        t11TextView36 = findViewById(R.id.t11TextView36);
        t11TextView37 = findViewById(R.id.t11TextView37);
        t11TextView38 = findViewById(R.id.t11TextView38);
        t11TextView39 = findViewById(R.id.t11TextView39);
        t11TextView40 = findViewById(R.id.t11TextView40);
        t11SolutionExample1 = findViewById(R.id.t11SolutionExample1);
        t11SolutionExample2 = findViewById(R.id.t11SolutionExample2);
        t11SolutionExample3 = findViewById(R.id.t11SolutionExample3);
        t11SolutionExample4 = findViewById(R.id.t11SolutionExample4);
        t11Solution1 = findViewById(R.id.t11Solution1);
        t11Solution2 = findViewById(R.id.t11Solution2);
        t11Solution3 = findViewById(R.id.t11Solution3);
        t11Solution4 = findViewById(R.id.t11Solution4);
        t11Latex_1 = findViewById(R.id.t11Latex_1);
        t11Latex_2 = findViewById(R.id.t11Latex_2);
        t11Latex_4 = findViewById(R.id.t11Latex_4);
        t11Latex_6 = findViewById(R.id.t11Latex_6);
        t11Latex_8 = findViewById(R.id.t11Latex_8);
        t11Latex_11 = findViewById(R.id.t11Latex_11);
        t11Latex_13 = findViewById(R.id.t11Latex_13);
        t11Latex_15 = findViewById(R.id.t11Latex_15);
        t11Latex_17 = findViewById(R.id.t11Latex_17);
        t11Latex_18 = findViewById(R.id.t11Latex_18);
        t11Latex_19 = findViewById(R.id.t11Latex_19);
        t11Latex_20 = findViewById(R.id.t11Latex_20);
        t11Latex_21 = findViewById(R.id.t11Latex_21);
        t11Latex_22 = findViewById(R.id.t11Latex_22);
        t11Latex_23 = findViewById(R.id.t11Latex_23);
        t11Latex_24 = findViewById(R.id.t11Latex_24);
        t11Latex_25 = findViewById(R.id.t11Latex_25);
        t11Latex_26 = findViewById(R.id.t11Latex_26);
        t11Latex_27 = findViewById(R.id.t11Latex_27);
        t11Latex_28 = findViewById(R.id.t11Latex_28);
        t11Latex_29 = findViewById(R.id.t11Latex_29);
        t11Latex_30 = findViewById(R.id.t11Latex_30);
        t11Latex_31 = findViewById(R.id.t11Latex_31);
        t11Latex_32 = findViewById(R.id.t11Latex_32);
        t11Latex_33 = findViewById(R.id.t11Latex_33);
        t11ZoomControls = findViewById(R.id.t11ZoomControls);
        t11Back = findViewById(R.id.t11Back);
        t11Menu = findViewById(R.id.t11Menu);
        t11ScrollView = findViewById(R.id.t11ScrollView);
        t11ActScore = findViewById(R.id.t11ActScore);
        t11ActDirection = findViewById(R.id.t11ActDirection);
        t11ActQuestion = findViewById(R.id.t11ActQuestion);
        t11ActAns = findViewById(R.id.t11ActAns);
        t11ActSolText = findViewById(R.id.t11ActSolText);
        t11ActFeedback = findViewById(R.id.t11ActFeedback);
        t11ActStart = findViewById(R.id.t11ActStart);
        t11ActOpt1 = findViewById(R.id.t11ActOpt1);
        t11ActOpt2 = findViewById(R.id.t11ActOpt2);
        t11ActOpt3 = findViewById(R.id.t11ActOpt3);
        t11ActOpt4 = findViewById(R.id.t11ActOpt4);
        t11ActSubmit = findViewById(R.id.t11ActSubmit);
        t11ActLayout = findViewById(R.id.t11ActLayout);
        t11ActOpts = findViewById(R.id.t11ActOpts);
        t11ActAnsLayout = findViewById(R.id.t11ActAnsLayout);
        t11Act1Direction = findViewById(R.id.t11Act1Direction);
        t11Act2Direction = findViewById(R.id.t11Act2Direction);
        t11Act3Direction = findViewById(R.id.t11Act3Direction);
        t11Act1Problems = findViewById(R.id.t11Act1Problems);
        t11Act2Problems = findViewById(R.id.t11Act2Problems);
        t11Act3Problems = findViewById(R.id.t11Act3Problems);

        dbHandler = new DBHandler(this);
        startTime11 = System.currentTimeMillis();

        loadScore();
        t11ActScore.setText("Score: " + scoreValue + "/" + t11ActQuesLength);

        String t11TextViewFormat2 = "<b><i>Combination</i></b><br><br>As a recall, <b>permutation</b> is defined as the arrangements of objects in which the order is important. For instance, AB and BA are two different arrangements; ABC, ACB, BCA, BAC, CAB, and CBA are six different arrangements.<br><br>Now, the lesson will focus on counting sets of objects where their order does not matter. Thus, AB and BA are counted as one; and ABC, ACB, BCA, BAC, CAB, and CBA are the same and counted as one, too. This type of arrangement is called <b>combinations</b>.";
        String t11TextViewFormat3 = "<i>Combination Formula</i><br><br>The number of different arrangements of <i>n</i> objects using <i>r ≤ n</i> of them, in which<br><br>1.  the n objects are distinct<br>2.  once an object is used, it cannot be repeated,  and<br>3.  the order is not important.<br><br>The number of ways of selecting <b>r</b> objects taken from <b>n</b> at a time is <i>C(n,r)</i> where";
        String t11TextViewFormat4 = "<b>Example 1</b><br><br>Evaluate:";
        String t11TextViewFormat6 = "<b>Example 2</b><br><br>How many combinations can be made from H, O, P, E if the letters are taken";
        String t11TextViewFormat8 = "<b>Example 3</b><br><br>How many different committees of 3 people can be formed from a pool of 5 people?";
        String t11TextViewFormat10 = "<b>Example 4</b><br><br>A committee of 4 students is to be chosen from 7 boys and 10 girls. How many committees can be formed if the committee is to be comprised as follows:";
        String t11Act1DirectionFormat ="<b>Activity 1</b><br><br>Evaluate the following:";
        String t11Act2DirectionFormat ="<b>Activity 2</b><br><br>Solve each of the following problems.";
        String t11Act3DirectionFormat ="<b>Activity 3</b><br><br>A committee of 6 students is to be chosen from 7 boys and 8 girls. How many committees can be formed if the committee is";

        TextView[] textViewHtml = {t11TextView2, t11TextView3, t11TextView4, t11TextView6, t11TextView8, t11TextView10, t11Act1Direction, t11Act2Direction, t11Act3Direction};
        String[] textViewFormat = {t11TextViewFormat2, t11TextViewFormat3, t11TextViewFormat4, t11TextViewFormat6, t11TextViewFormat8, t11TextViewFormat10, t11Act1DirectionFormat, t11Act2DirectionFormat, t11Act3DirectionFormat};

        for (int i = 0; i < textViewHtml.length; i++) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i], Html.FROM_HTML_MODE_COMPACT));
            } else {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i]));
            }
        }

        t11Latex_1.setLatexDrawable(JLatexMathDrawable.builder("{}_nC_r = \\frac{n!}{(n-r)!}").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t11Latex_2.setLatexDrawable(JLatexMathDrawable.builder("\\text{(a) } {}_7C_5 \\\\ \\text{(b) } {}_5C_5 \\\\ \\text{(c) } {}_8C_0").textSize(50).background(0xFFffffff).padding(8).build());
        t11Latex_4.setLatexDrawable(JLatexMathDrawable.builder("{}_7C_5 = \\frac{7!}{(7-5)!5!} = \\frac{7!}{2!5!} \\\\ = \\frac{7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1) \\cdot (5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1)} \\\\ = 21 \\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t11Latex_6.setLatexDrawable(JLatexMathDrawable.builder("{}_5C_5 = \\frac{5!}{(5-5)!5!} = \\frac{5!}{0!5!} \\\\ = \\frac{5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(1) \\cdot (5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1)} \\\\ = 1 \\text{ way} \\\\ \\text{Remember that 0! = 1.}").textSize(50).background(0xFFffffff).padding(8).build());
        t11Latex_8.setLatexDrawable(JLatexMathDrawable.builder("{}_8C_0 = \\frac{8!}{(8-0)!0!} = \\frac{8!}{8!0!} \\\\ = \\frac{8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (1)} \\\\ = 1 \\text{ way}").textSize(50).background(0xFFffffff).padding(8).build());
        t11Latex_11.setLatexDrawable(JLatexMathDrawable.builder("{}_4C_1 = \\frac{4!}{(4-1)!1!} = \\frac{4!}{3!1!} \\\\ = \\frac{4 \\cdot 3 \\cdot 2 \\cdot 1}{(3 \\cdot 2 \\cdot 1) \\cdot (1)} \\\\ = 4 \\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t11Latex_13.setLatexDrawable(JLatexMathDrawable.builder("{}_4C_2 = \\frac{4!}{(4-2)!2!} = \\frac{4!}{2!2!} \\\\ = \\frac{4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1) \\cdot (2 \\cdot 1)} \\\\ = 6 \\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t11Latex_15.setLatexDrawable(JLatexMathDrawable.builder("{}_4C_3 = \\frac{4!}{(4-3)!3!} = \\frac{4!}{1!3!} \\\\ = \\frac{4 \\cdot 3 \\cdot 2 \\cdot 1}{(1) \\cdot (3 \\cdot 2 \\cdot 1)} \\\\ = 4 \\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t11Latex_17.setLatexDrawable(JLatexMathDrawable.builder("{}_4C_4 = \\frac{4!}{(4-4)!4!} = \\frac{4!}{0!4!} \\\\ = \\frac{4 \\cdot 3 \\cdot 2 \\cdot 1}{(1) \\cdot (4 \\cdot 3 \\cdot 2 \\cdot 1)} \\\\ = 1 \\text{ way}").textSize(50).background(0xFFffffff).padding(8).build());
        t11Latex_18.setLatexDrawable(JLatexMathDrawable.builder("{}_5C_3 = \\frac{5!}{(5-3)!3!} = \\frac{5!}{2!3!} \\\\ = \\frac{5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1)} \\\\ = 10 \\text{ ways} \\\\ \\text{There are 10 different committees.}").textSize(50).background(0xFFffffff).padding(8).build());
        t11Latex_19.setLatexDrawable(JLatexMathDrawable.builder("{}_7C_4 = \\frac{7!}{(7-4)!4!} = \\frac{7!}{3!4!} \\\\ = \\frac{7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(3 \\cdot 2 \\cdot 1) \\cdot (4 \\cdot 3 \\cdot 2 \\cdot 1)} \\\\ = 35\\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t11Latex_20.setLatexDrawable(JLatexMathDrawable.builder("{}_{10}C_4 = \\frac{10!}{(10-4)!4!} = \\frac{10!}{6!4!} \\\\ = \\frac{10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (4 \\cdot 3 \\cdot 2 \\cdot 1)} \\\\ = 210\\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t11Latex_21.setLatexDrawable(JLatexMathDrawable.builder("{}_7C_3").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t11Latex_22.setLatexDrawable(JLatexMathDrawable.builder("{}_7C_3 = \\frac{7!}{(7-3)!3!} = \\frac{7!}{4!3!} \\\\ = \\frac{7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (3 \\cdot 2 \\cdot 1)} \\\\ = 35\\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t11Latex_23.setLatexDrawable(JLatexMathDrawable.builder("{}_{10}C_1").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t11Latex_24.setLatexDrawable(JLatexMathDrawable.builder("{}_{10}C_1 = \\frac{10!}{(10-1)!1!} = \\frac{10!}{9!1!} \\\\ = \\frac{10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (1)} \\\\ = 1\\text{ way}").textSize(50).background(0xFFffffff).padding(8).build());
        t11Latex_25.setLatexDrawable(JLatexMathDrawable.builder("{}_7C_3 \\cdot {}_{10}C_1 = (35)(1) = 35 \\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t11Latex_26.setLatexDrawable(JLatexMathDrawable.builder("{}_7C_2").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t11Latex_27.setLatexDrawable(JLatexMathDrawable.builder("{}_7C_2 = \\frac{7!}{(7-2)!2!} = \\frac{7!}{5!2!} \\\\ = \\frac{7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (2 \\cdot 1)} \\\\ = 21\\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t11Latex_28.setLatexDrawable(JLatexMathDrawable.builder("{}_{10}C_2").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t11Latex_29.setLatexDrawable(JLatexMathDrawable.builder("{}_{10}C_2 = \\frac{10!}{(10-2)!2!} = \\frac{10!}{8!2!} \\\\ = \\frac{10 \\cdot 9 \\cdot 8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1}{(8 \\cdot 7 \\cdot 6 \\cdot 5 \\cdot 4 \\cdot 3 \\cdot 2 \\cdot 1) \\cdot (2 \\cdot 1)} \\\\ = 45\\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t11Latex_30.setLatexDrawable(JLatexMathDrawable.builder("{}_7C_2 \\cdot {}_{10}C_2 = (21)(45) = 945 \\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t11Latex_31.setLatexDrawable(JLatexMathDrawable.builder("{}_{10}C_3 \\cdot {}_7C_1").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t11Latex_32.setLatexDrawable(JLatexMathDrawable.builder("{}_{10}C_4 \\cdot {}_7C_0").textSize(50).background(0xFFffffff).padding(8).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t11Latex_33.setLatexDrawable(JLatexMathDrawable.builder("({}_{10}C_3 \\cdot {}_7C_1) + ({}_{10}C_4 \\cdot {}_7C_0) \\\\ = (120 \\cdot 7) + (210 \\cdot 1) \\\\ = 840 + 210 \\\\ = 1,050 \\text{ ways}").textSize(50).background(0xFFffffff).padding(8).build());
        t11Act1Problems.setLatexDrawable(JLatexMathDrawable.builder("\\text{(a) }{}_5C_5 \\\\ \\text{(b) }{}_6C_1 \\\\ \\text{(c) }{}_7C_0 \\\\ \\text{(d) }{}_3C_1 \\cdot {}_4C_3 \\\\ \\text{(e) }{}_{15}C_{14}").textSize(50).background(0xFFB0D6F5).padding(8).build());

        TextView[] textViewTitle = {t11TextViewTitle1, t11TextViewTitle2, t11TextViewTitle3, t11TextViewTitle4, t11TextViewTitle5};
        TextView[] textView = {t11TextView1, t11TextView2, t11TextView3, t11TextView4, t11TextView5, t11TextView6, t11TextView7, t11TextView8, t11TextView9, t11TextView10, t11TextView11, t11TextView12, t11TextView13, t11TextView14, t11TextView15, t11TextView16, t11TextView17, t11TextView18, t11TextView19, t11TextView20, t11TextView21, t11TextView22, t11TextView23, t11TextView24, t11TextView25, t11TextView26, t11TextView27, t11TextView28, t11TextView29, t11TextView30, t11TextView31, t11TextView32, t11TextView33, t11TextView34, t11TextView35, t11TextView36, t11TextView37, t11TextView38, t11TextView39, t11TextView40, t11ActScore, t11ActSolText, t11ActDirection, t11ActQuestion, t11Act1Direction, t11Act2Direction, t11Act2Problems, t11Act3Direction, t11Act3Problems, t11SolutionExample1, t11SolutionExample2, t11SolutionExample3, t11SolutionExample4};

        t11ZoomControls.setOnZoomInClickListener(new View.OnClickListener() {
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

        t11ZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
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

        t11Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //Example Solutions

        TextView[] solutions = {t11SolutionExample1, t11SolutionExample2, t11SolutionExample3, t11SolutionExample4};
        LinearLayout[] solLayout = {t11Solution1, t11Solution2, t11Solution3, t11Solution4};

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

        t11Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuDialog();
            }
        });

        t11ActStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t11ActLayout.setVisibility(View.VISIBLE);
                t11ActOpts.setVisibility(View.VISIBLE);
                t11ActAnsLayout.setVisibility(View.INVISIBLE);
                t11ActSolText.setVisibility(View.GONE);
                t11ActStart.setVisibility(View.GONE);
                t11ActDirection.setText("Read and understand each question carefully and select your answer from the multiple-choice options.");
                t11ActFeedback.setImageDrawable(null);
                t11ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(8).build());
                Button[] buttons = {t11ActOpt1, t11ActOpt2, t11ActOpt3, t11ActOpt4};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
                t11ActSubmit.setText("Submit");
                t11ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                currentIndex = 0;
                score = 0;
                nextQuestion = false;
                generateT11ActQuestions();
            }
        });

        t11ActSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nextQuestion == false) {
                    nextQuestion = true;
                    t11ActSubmit.setText("Next");
                    t11ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.black));
                    Button[] buttons = {t11ActOpt1, t11ActOpt2, t11ActOpt3, t11ActOpt4};
                    for (int i = 0; i < buttons.length; i++) {
                        buttons[i].setEnabled(false);
                    }
                    t11ActSolText.setVisibility(View.VISIBLE);
                    t11ActAns.setLatexDrawable(JLatexMathDrawable.builder(solution).textSize(50).background(0xFFb0d6f5).padding(10).build());
                    if (selectedAnswer.equals(answer)) {
                        t11ActFeedback.setImageResource(R.drawable.round_check_24);
                        score++;
                    } else {
                        t11ActFeedback.setImageResource(R.drawable.round_clear_24);
                    }
                }else {
                    currentIndex++;
                    if (currentIndex < t11ActQuesLength) {
                        generateT11ActQuestions();
                        nextQuestion = false;
                        t11ActAnsLayout.setVisibility(View.INVISIBLE);
                        t11ActSolText.setVisibility(View.GONE);
                        t11ActSubmit.setText("Submit");
                        t11ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                        t11ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(10).build());
                        t11ActFeedback.setImageDrawable(null);
                        Button[] buttons = {t11ActOpt1, t11ActOpt2, t11ActOpt3, t11ActOpt4};
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

        t11ActOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t11ActOpt1.getText().toString();
                t11ActAnsLayout.setVisibility(View.VISIBLE);
                t11ActOpt1.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t11ActOpt1.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t11ActOpt4, t11ActOpt2, t11ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t11ActOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t11ActOpt2.getText().toString();
                t11ActAnsLayout.setVisibility(View.VISIBLE);
                t11ActOpt2.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t11ActOpt2.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t11ActOpt4, t11ActOpt1, t11ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t11ActOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t11ActOpt3.getText().toString();
                t11ActAnsLayout.setVisibility(View.VISIBLE);
                t11ActOpt3.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t11ActOpt3.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t11ActOpt4, t11ActOpt2, t11ActOpt1};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t11ActOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t11ActOpt4.getText().toString();
                t11ActAnsLayout.setVisibility(View.VISIBLE);
                t11ActOpt4.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t11ActOpt4.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t11ActOpt1, t11ActOpt2, t11ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

    }

    private void generateT11ActQuestions() {
        t11ActQuestion.setText(activityQuestions.getT11ActQuestions(currentIndex));
        t11ActOpt1.setText(activityQuestions.getT11ActChoice1(currentIndex));
        t11ActOpt2.setText(activityQuestions.getT11ActChoice2(currentIndex));
        t11ActOpt3.setText(activityQuestions.getT11ActChoice3(currentIndex));
        t11ActOpt4.setText(activityQuestions.getT11ActChoice4(currentIndex));
        answer = activityQuestions.getT11ActAnswers(currentIndex);
        solution = activityQuestions.getT11ActSolutions(currentIndex);
    }

    private void showScore() {
        t11ActLayout.setVisibility(View.GONE);
        t11ActOpts.setVisibility(View.GONE);
        t11ActAnsLayout.setVisibility(View.GONE);
        t11ActStart.setVisibility(View.VISIBLE);
        t11ActStart.setText("Try Again");
        String actDirectionFormat = "Assessment Complete!<br>Your score is <b>" + score + "</b> out of " + t11ActQuesLength + ".";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            t11ActDirection.setText(Html.fromHtml(actDirectionFormat, Html.FROM_HTML_MODE_COMPACT));
        } else {
            t11ActDirection.setText(Html.fromHtml(actDirectionFormat));
        }
        t11ActScore.setText("Score: " + score + "/" + t11ActQuesLength);
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
        LayoutInflater inflater = LayoutInflater.from(TopicElevenActivity.this);
        View view =  inflater.inflate(R.layout.custom_menu, null);

        TextView objectives = view.findViewById(R.id.objectives);
        TextView introduction = view.findViewById(R.id.introduction);
        TextView examples = view.findViewById(R.id.examples);
        TextView activities =view.findViewById(R.id.activities);
        TextView assessment = view.findViewById(R.id.assessment);

        TextView menu[] = {objectives, introduction, examples, activities, assessment};
        TextView title[] = {t11TextViewTitle1, t11TextViewTitle2, t11TextViewTitle3, t11TextViewTitle4, t11TextViewTitle5};
        String format[] = {"<u>Objectives</u>", "<u>Introduction to lesson</u>", "<u>Illustrative Examples</u>", "<u>Activities</u>", "<u>Assessment</u>"};

        AlertDialog.Builder builder = new AlertDialog.Builder(TopicElevenActivity.this);
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
                    t11ScrollView.smoothScrollTo(0, title[finalI].getTop());
                    dialog.dismiss();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        endTime11 = System.currentTimeMillis();
        long timeDiff = endTime11 - startTime11;
        int newTime = (int) (timeDiff / 1000);

        Boolean checkId = dbHandler.checkTopicsId(285);
        if (checkId == true) {
            Map<String, String> studyTime = dbHandler.getTopicsId(285);
            if (!studyTime.isEmpty()) {
                int prevTime = Integer.parseInt(studyTime.get(TIME_IN_SEC));
                int totalTime = newTime + prevTime;
                dbHandler.updateTime(new StudyModelClass(285, totalTime));
            }
        } else {
            dbHandler.storeStudyTime(new StudyModelClass(285, newTime));
        }

        super.onBackPressed();
    }
}