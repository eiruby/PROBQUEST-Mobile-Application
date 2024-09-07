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

public class TopicSixActivity extends AppCompatActivity {
    private TextView t6TextViewTitle1, t6TextViewTitle2, t6TextViewTitle3, t6TextViewTitle4, t6TextViewTitle5, t6TextViewTitle6, t6TextView1, t6TextView2, t6TextView3, t6TextView4, t6TextView5, t6TextView6, t6TextView7, t6TextView8, t6TextView9, t6TextView10, t6TextView11, t6TextView12, t6TextView13, t6TextView14, t6TextView15, t6TextView16, t6TextView17, t6TextView18, t6TextView19, t6TextView20, t6TextView21, t6TextView22, t6TextView23, t6TextView24, t6TextView25, t6TextView26, t6TextView27, t6TextView28, t6TextView29, t6TextView30, t6TextView31, t6TextView32, t6TextView33, t6TextView34, t6TextView35, t6TextView36, t6TextView37, t6TextView38, t6TextView39, t6TextView40, t6TextView41, t6TextView42, t6TextView43, t6TextView44, t6TextView45, t6TextView46, t6TextView47, t6TextView48, t6TextView49, t6TextView50, t6TextView51, t6TextView52, t6TextView53, t6TextView54, t6TextView55, t6TextView56, t6TextView57, t6TextView58, t6TextView59, t6TextView60, t6TextView61, t6TextView62, t6TextView63, t6TextView64, t6TextView65, t6TextView66, t6TextView67, t6TextView68, t6TextView69, t6TextView70, t6TextView71, t6TextView72, t6TextView73, t6TextView74, t6TextView75, t6TextView76, t6TextView77, t6TextView78, t6TextView79, t6TextView80, t6TextView81, t6TextView82, t6TextView83, t6TextView84, t6TextView85, t6TextView86, t6TextView87, t6TextView88, t6TextView89, t6TextView90, t6TextView91, t6TextView92, t6TextView93, t6TextView94, t6TextView95, t6TextView96, t6TextView97, t6TextView98, t6TextView99, t6TextView100, t6TextView101, t6TextView102, t6TextView103, t6TextView104, t6TextView105, t6TextView106, t6TextView107, t6TextView108, t6TextView109, t6TextView110, t6TextView111, t6TextView112, t6TextView113, t6TextView114, t6TextView115, t6TextView116, t6TextView117, t6TextView118, t6TextView119, t6TextView120, t6TextView121, t6TextView122, t6TextView123, t6TextView124, t6TextView125, t6TextView126, t6TextView127, t6TextView128, t6TextView129, t6TextView130, t6TextView131, t6TextView132, t6TextView133, t6TextView134, t6ActScore, t6ActSolText, t6ActDirection, t6ActQuestion, t6Act1Direction, t6Act1Problems, t6Act2Direction, t6Act2Problems, t6Act3Direction, t6Act3Problems, t6Act4Direction, t6Act4Problems, t6Act5Direction, t6Act5Problems, t6SolutionExample1, t6SolutionExample2, t6SolutionExample3, t6SolutionExample4, t6SolutionExample5;
    private JLatexMathView t6Latex_1, t6Latex_2, t6Latex_3, t6Latex_4, t6Latex_5, t6Latex_6, t6Latex_7, t6Latex_8, t6Latex_9, t6Latex_10, t6Latex_11, t6Latex_12, t6Latex_13, t6Latex_14, t6Latex_15, t6Latex_16, t6Latex_17, t6Latex_18, t6Latex_19, t6Latex_20, t6Latex_21, t6Latex_22, t6Latex_23, t6Latex_24, t6Latex_25, t6Latex_26, t6Latex_27, t6Latex_28, t6Latex_29, t6Latex_30, t6Latex_31, t6Latex_32, t6Latex_33, t6Latex_34, t6Latex_35, t6Latex_36, t6Latex_37, t6Latex_38, t6Latex_39, t6ActAns;
    private ImageView t6ActFeedback, t6Back, t6Menu;
    private Button t6ActStart, t6ActOpt1, t6ActOpt2, t6ActOpt3, t6ActOpt4, t6ActSubmit;
    private LinearLayout t6ActLayout, t6ActOpts, t6ActAnsLayout, t6Solution1, t6Solution2, t6Solution3, t6Solution4, t6Solution5;
    private ZoomControls t6ZoomControls;
    private ScrollView t6ScrollView;
    private int textSize = 16, currentIndex, score;
    private String selectedAnswer, answer, solution;
    private ActivityQuestions activityQuestions = new ActivityQuestions();
    private int t6ActQuesLength = activityQuestions.t6ActQuestions.length;
    private boolean nextQuestion = false, hideSolution = true;
    private static final String PREFS_FILE_NAME = "ActivityScore6";
    private static final String KEY_SCORE = "score";
    private long startTime6, endTime6, scoreValue;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_six);

        dbHandler = new DBHandler(this);

        t6Back = findViewById(R.id.t6Back);
        t6TextViewTitle1 = findViewById(R.id.t6TextViewTitle1);
        t6TextViewTitle2 = findViewById(R.id.t6TextViewTitle2);
        t6TextViewTitle3 = findViewById(R.id.t6TextViewTitle3);
        t6TextViewTitle4 = findViewById(R.id.t6TextViewTitle4);
        t6TextViewTitle5 = findViewById(R.id.t6TextViewTitle5);
        t6TextViewTitle6 = findViewById(R.id.t6TextViewTitle6);
        t6TextView1 = findViewById(R.id.t6TextView1);
        t6TextView2 = findViewById(R.id.t6TextView2);
        t6TextView3 = findViewById(R.id.t6TextView3);
        t6TextView4 = findViewById(R.id.t6TextView4);
        t6TextView5 = findViewById(R.id.t6TextView5);
        t6TextView6 = findViewById(R.id.t6TextView6);
        t6TextView7 = findViewById(R.id.t6TextView7);
        t6TextView8 = findViewById(R.id.t6TextView8);
        t6TextView9 = findViewById(R.id.t6TextView9);
        t6TextView10 = findViewById(R.id.t6TextView10);
        t6TextView11 = findViewById(R.id.t6TextView11);
        t6TextView12 = findViewById(R.id.t6TextView12);
        t6TextView13 = findViewById(R.id.t6TextView13);
        t6TextView14 = findViewById(R.id.t6TextView14);
        t6TextView15 = findViewById(R.id.t6TextView15);
        t6TextView16 = findViewById(R.id.t6TextView16);
        t6TextView17 = findViewById(R.id.t6TextView17);
        t6TextView18 = findViewById(R.id.t6TextView18);
        t6TextView19 = findViewById(R.id.t6TextView19);
        t6TextView20 = findViewById(R.id.t6TextView20);
        t6TextView21 = findViewById(R.id.t6TextView21);
        t6TextView22 = findViewById(R.id.t6TextView22);
        t6TextView23 = findViewById(R.id.t6TextView23);
        t6TextView24 = findViewById(R.id.t6TextView24);
        t6TextView25 = findViewById(R.id.t6TextView25);
        t6TextView26 = findViewById(R.id.t6TextView26);
        t6TextView27 = findViewById(R.id.t6TextView27);
        t6TextView28 = findViewById(R.id.t6TextView28);
        t6TextView29 = findViewById(R.id.t6TextView29);
        t6TextView30 = findViewById(R.id.t6TextView30);
        t6TextView31 = findViewById(R.id.t6TextView31);
        t6TextView32 = findViewById(R.id.t6TextView32);
        t6TextView33 = findViewById(R.id.t6TextView33);
        t6TextView34 = findViewById(R.id.t6TextView34);
        t6TextView35 = findViewById(R.id.t6TextView35);
        t6TextView36 = findViewById(R.id.t6TextView36);
        t6TextView37 = findViewById(R.id.t6TextView37);
        t6TextView38 = findViewById(R.id.t6TextView38);
        t6TextView39 = findViewById(R.id.t6TextView39);
        t6TextView40 = findViewById(R.id.t6TextView40);
        t6TextView41 = findViewById(R.id.t6TextView41);
        t6TextView42 = findViewById(R.id.t6TextView42);
        t6TextView43 = findViewById(R.id.t6TextView43);
        t6TextView44 = findViewById(R.id.t6TextView44);
        t6TextView45 = findViewById(R.id.t6TextView45);
        t6TextView46 = findViewById(R.id.t6TextView46);
        t6TextView47 = findViewById(R.id.t6TextView47);
        t6TextView48 = findViewById(R.id.t6TextView48);
        t6TextView49 = findViewById(R.id.t6TextView49);
        t6TextView50 = findViewById(R.id.t6TextView50);
        t6TextView51 = findViewById(R.id.t6TextView51);
        t6TextView52 = findViewById(R.id.t6TextView52);
        t6TextView53 = findViewById(R.id.t6TextView53);
        t6TextView54 = findViewById(R.id.t6TextView54);
        t6TextView55 = findViewById(R.id.t6TextView55);
        t6TextView56 = findViewById(R.id.t6TextView56);
        t6TextView57 = findViewById(R.id.t6TextView57);
        t6TextView58 = findViewById(R.id.t6TextView58);
        t6TextView59 = findViewById(R.id.t6TextView59);
        t6TextView60 = findViewById(R.id.t6TextView60);
        t6TextView61 = findViewById(R.id.t6TextView61);
        t6TextView62 = findViewById(R.id.t6TextView62);
        t6TextView63 = findViewById(R.id.t6TextView63);
        t6TextView64 = findViewById(R.id.t6TextView64);
        t6TextView65 = findViewById(R.id.t6TextView65);
        t6TextView66 = findViewById(R.id.t6TextView66);
        t6TextView67 = findViewById(R.id.t6TextView67);
        t6TextView68 = findViewById(R.id.t6TextView68);
        t6TextView69 = findViewById(R.id.t6TextView69);
        t6TextView70 = findViewById(R.id.t6TextView70);
        t6TextView71 = findViewById(R.id.t6TextView71);
        t6TextView72 = findViewById(R.id.t6TextView72);
        t6TextView73 = findViewById(R.id.t6TextView73);
        t6TextView74 = findViewById(R.id.t6TextView74);
        t6TextView75 = findViewById(R.id.t6TextView75);
        t6TextView76 = findViewById(R.id.t6TextView76);
        t6TextView77 = findViewById(R.id.t6TextView77);
        t6TextView78 = findViewById(R.id.t6TextView78);
        t6TextView79 = findViewById(R.id.t6TextView79);
        t6TextView80 = findViewById(R.id.t6TextView80);
        t6TextView81 = findViewById(R.id.t6TextView81);
        t6TextView82 = findViewById(R.id.t6TextView82);
        t6TextView83 = findViewById(R.id.t6TextView83);
        t6TextView84 = findViewById(R.id.t6TextView84);
        t6TextView85 = findViewById(R.id.t6TextView85);
        t6TextView86 = findViewById(R.id.t6TextView86);
        t6TextView87 = findViewById(R.id.t6TextView87);
        t6TextView88 = findViewById(R.id.t6TextView88);
        t6TextView89 = findViewById(R.id.t6TextView89);
        t6TextView90 = findViewById(R.id.t6TextView90);
        t6TextView91 = findViewById(R.id.t6TextView91);
        t6TextView92 = findViewById(R.id.t6TextView92);
        t6TextView93 = findViewById(R.id.t6TextView93);
        t6TextView94 = findViewById(R.id.t6TextView94);
        t6TextView95 = findViewById(R.id.t6TextView95);
        t6TextView96 = findViewById(R.id.t6TextView96);
        t6TextView97 = findViewById(R.id.t6TextView97);
        t6TextView98 = findViewById(R.id.t6TextView98);
        t6TextView99 = findViewById(R.id.t6TextView99);
        t6TextView100 = findViewById(R.id.t6TextView100);
        t6TextView101 = findViewById(R.id.t6TextView101);
        t6TextView102 = findViewById(R.id.t6TextView102);
        t6TextView103 = findViewById(R.id.t6TextView103);
        t6TextView104 = findViewById(R.id.t6TextView104);
        t6TextView105 = findViewById(R.id.t6TextView105);
        t6TextView106 = findViewById(R.id.t6TextView106);
        t6TextView107 = findViewById(R.id.t6TextView107);
        t6TextView108 = findViewById(R.id.t6TextView108);
        t6TextView109 = findViewById(R.id.t6TextView109);
        t6TextView110 = findViewById(R.id.t6TextView110);
        t6TextView111 = findViewById(R.id.t6TextView111);
        t6TextView112 = findViewById(R.id.t6TextView112);
        t6TextView113 = findViewById(R.id.t6TextView113);
        t6TextView114 = findViewById(R.id.t6TextView114);
        t6TextView115 = findViewById(R.id.t6TextView115);
        t6TextView116 = findViewById(R.id.t6TextView116);
        t6TextView117 = findViewById(R.id.t6TextView117);
        t6TextView118 = findViewById(R.id.t6TextView118);
        t6TextView119 = findViewById(R.id.t6TextView119);
        t6TextView120 = findViewById(R.id.t6TextView120);
        t6TextView121 = findViewById(R.id.t6TextView121);
        t6TextView122 = findViewById(R.id.t6TextView122);
        t6TextView123 = findViewById(R.id.t6TextView123);
        t6TextView124 = findViewById(R.id.t6TextView124);
        t6TextView125 = findViewById(R.id.t6TextView125);
        t6TextView126 = findViewById(R.id.t6TextView126);
        t6TextView127 = findViewById(R.id.t6TextView127);
        t6TextView128 = findViewById(R.id.t6TextView128);
        t6TextView129 = findViewById(R.id.t6TextView129);
        t6TextView130 = findViewById(R.id.t6TextView130);
        t6TextView131 = findViewById(R.id.t6TextView131);
        t6TextView132 = findViewById(R.id.t6TextView132);
        t6TextView133 = findViewById(R.id.t6TextView133);
        t6TextView134 = findViewById(R.id.t6TextView134);
        t6SolutionExample1 = findViewById(R.id.t6SolutionExample1);
        t6SolutionExample2 = findViewById(R.id.t6SolutionExample2);
        t6SolutionExample3 = findViewById(R.id.t6SolutionExample3);
        t6SolutionExample4 = findViewById(R.id.t6SolutionExample4);
        t6SolutionExample5 = findViewById(R.id.t6SolutionExample5);
        t6Solution1 = findViewById(R.id.t6Solution1);
        t6Solution2 = findViewById(R.id.t6Solution2);
        t6Solution3 = findViewById(R.id.t6Solution3);
        t6Solution4 = findViewById(R.id.t6Solution4);
        t6Solution5 = findViewById(R.id.t6Solution5);
        t6Latex_1 = findViewById(R.id.t6Latex_1);
        t6Latex_2 = findViewById(R.id.t6Latex_2);
        t6Latex_3 = findViewById(R.id.t6Latex_3);
        t6Latex_4 = findViewById(R.id.t6Latex_4);
        t6Latex_5 = findViewById(R.id.t6Latex_5);
        t6Latex_6 = findViewById(R.id.t6Latex_6);
        t6Latex_7 = findViewById(R.id.t6Latex_7);
        t6Latex_8 = findViewById(R.id.t6Latex_8);
        t6Latex_9 = findViewById(R.id.t6Latex_9);
        t6Latex_10 = findViewById(R.id.t6Latex_10);
        t6Latex_11 = findViewById(R.id.t6Latex_11);
        t6Latex_12 = findViewById(R.id.t6Latex_12);
        t6Latex_13 = findViewById(R.id.t6Latex_13);
        t6Latex_14 = findViewById(R.id.t6Latex_14);
        t6Latex_15 = findViewById(R.id.t6Latex_15);
        t6Latex_16 = findViewById(R.id.t6Latex_16);
        t6Latex_17 = findViewById(R.id.t6Latex_17);
        t6Latex_18 = findViewById(R.id.t6Latex_18);
        t6Latex_19 = findViewById(R.id.t6Latex_19);
        t6Latex_20 = findViewById(R.id.t6Latex_20);
        t6Latex_21 = findViewById(R.id.t6Latex_21);
        t6Latex_22 = findViewById(R.id.t6Latex_22);
        t6Latex_23 = findViewById(R.id.t6Latex_23);
        t6Latex_24 = findViewById(R.id.t6Latex_24);
        t6Latex_25 = findViewById(R.id.t6Latex_25);
        t6Latex_26 = findViewById(R.id.t6Latex_26);
        t6Latex_27 = findViewById(R.id.t6Latex_27);
        t6Latex_28 = findViewById(R.id.t6Latex_28);
        t6Latex_29 = findViewById(R.id.t6Latex_29);
        t6Latex_30 = findViewById(R.id.t6Latex_30);
        t6Latex_31 = findViewById(R.id.t6Latex_31);
        t6Latex_32 = findViewById(R.id.t6Latex_32);
        t6Latex_33 = findViewById(R.id.t6Latex_33);
        t6Latex_34 = findViewById(R.id.t6Latex_34);
        t6Latex_35 = findViewById(R.id.t6Latex_35);
        t6Latex_36 = findViewById(R.id.t6Latex_36);
        t6Latex_37 = findViewById(R.id.t6Latex_37);
        t6Latex_38 = findViewById(R.id.t6Latex_38);
        t6Latex_39 = findViewById(R.id.t6Latex_39);
        t6ZoomControls = findViewById(R.id.t6ZoomControls);
        t6Menu = findViewById(R.id.t6Menu);
        t6ScrollView = findViewById(R.id.t6ScrollView);
        t6ActScore = findViewById(R.id.t6ActScore);
        t6ActDirection = findViewById(R.id.t6ActDirection);
        t6ActQuestion = findViewById(R.id.t6ActQuestion);
        t6ActAns = findViewById(R.id.t6ActAns);
        t6ActSolText = findViewById(R.id.t6ActSolText);
        t6ActFeedback = findViewById(R.id.t6ActFeedback);
        t6ActStart = findViewById(R.id.t6ActStart);
        t6ActOpt1 = findViewById(R.id.t6ActOpt1);
        t6ActOpt2 = findViewById(R.id.t6ActOpt2);
        t6ActOpt3 = findViewById(R.id.t6ActOpt3);
        t6ActOpt4 = findViewById(R.id.t6ActOpt4);
        t6ActSubmit = findViewById(R.id.t6ActSubmit);
        t6ActLayout = findViewById(R.id.t6ActLayout);
        t6ActOpts = findViewById(R.id.t6ActOpts);
        t6ActAnsLayout = findViewById(R.id.t6ActAnsLayout);
        t6Act1Direction = findViewById(R.id.t6Act1Direction);
        t6Act2Direction = findViewById(R.id.t6Act2Direction);
        t6Act3Direction = findViewById(R.id.t6Act3Direction);
        t6Act4Direction = findViewById(R.id.t6Act4Direction);
        t6Act5Direction = findViewById(R.id.t6Act5Direction);
        t6Act1Problems = findViewById(R.id.t6Act1Problems);
        t6Act2Problems = findViewById(R.id.t6Act2Problems);
        t6Act3Problems = findViewById(R.id.t6Act3Problems);
        t6Act4Problems = findViewById(R.id.t6Act4Problems);
        t6Act5Problems = findViewById(R.id.t6Act5Problems);

        startTime6 = System.currentTimeMillis();

        loadScore();
        t6ActScore.setText("Score: " + scoreValue + "/" + t6ActQuesLength);

        t6Latex_1.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B | A)").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_2.setLatexDrawable(JLatexMathDrawable.builder("P(A) = P(\\text{red}) = \\frac{6}{15}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_3.setLatexDrawable(JLatexMathDrawable.builder("P(B) = P(\\text{blue}) = \\frac{5}{14}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_4.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B | A) \\\\ = \\frac{6}{15} \\times \\frac{5}{14} \\\\ = \\frac{1}{7}").textSize(50).background(0xFFffffff).padding(10).build());
        t6Latex_5.setLatexDrawable(JLatexMathDrawable.builder("P(A) = P(\\text{blue}) = \\frac{5}{15}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_6.setLatexDrawable(JLatexMathDrawable.builder("P(B) = P(\\text{blue}) = \\frac{4}{14}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_7.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B | A) \\\\ = \\frac{5}{15} \\times \\frac{4}{14} \\\\ = \\frac{2}{21}").textSize(50).background(0xFFffffff).padding(10).build());
        t6Latex_8.setLatexDrawable(JLatexMathDrawable.builder("P(A) = P(\\text{yellow}) = \\frac{4}{15}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_9.setLatexDrawable(JLatexMathDrawable.builder("P(B) = P(\\text{yellow}) = \\frac{3}{14}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_10.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B | A) \\\\ = \\frac{4}{15} \\times \\frac{3}{14} \\\\ = \\frac{2}{35}").textSize(50).background(0xFFffffff).padding(10).build());
        t6Latex_11.setLatexDrawable(JLatexMathDrawable.builder("P(A) = P(\\text{red}) = \\frac{6}{15}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_12.setLatexDrawable(JLatexMathDrawable.builder("P(B) = P(\\text{red}) = \\frac{5}{14}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_13.setLatexDrawable(JLatexMathDrawable.builder("P(C) = P(\\text{blue}) = \\frac{5}{13}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_14.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B | A) \\times P(C | B) \\\\ = \\frac{6}{15} \\times \\frac{5}{14} \\times \\frac{5}{13} \\\\ = \\frac{5}{91}").textSize(50).background(0xFFffffff).padding(10).build());
        t6Latex_15.setLatexDrawable(JLatexMathDrawable.builder("P(A) = P(\\text{red}) = \\frac{6}{15}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_16.setLatexDrawable(JLatexMathDrawable.builder("P(B) = P(\\text{blue}) = \\frac{5}{14}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_17.setLatexDrawable(JLatexMathDrawable.builder("P(C) = P(\\text{yellow}) = \\frac{4}{13}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_18.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B | A) \\times P(C | B) \\\\ = \\frac{6}{15} \\times \\frac{5}{14} \\times \\frac{4}{13} \\\\ = \\frac{4}{91}").textSize(50).background(0xFFffffff).padding(10).build());
        t6Latex_19.setLatexDrawable(JLatexMathDrawable.builder("P(A) = P(\\text{jack}) = \\frac{4}{52}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_20.setLatexDrawable(JLatexMathDrawable.builder("P(B) = P(\\text{king}) = \\frac{4}{51}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_21.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B | A) \\\\ = \\frac{4}{52} \\times \\frac{4}{51} \\\\ = \\frac{4}{663}").textSize(50).background(0xFFffffff).padding(10).build());
        t6Latex_22.setLatexDrawable(JLatexMathDrawable.builder("P(A) = P(\\text{ace}) = \\frac{4}{52}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_23.setLatexDrawable(JLatexMathDrawable.builder("P(B) = P(\\text{ace}) = \\frac{3}{51}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_24.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B | A) \\\\ = \\frac{4}{52} \\times \\frac{3}{51} \\\\ = \\frac{3}{663}").textSize(50).background(0xFFffffff).padding(10).build());
        t6Latex_25.setLatexDrawable(JLatexMathDrawable.builder("P(A) = P(\\text{diamond}) = \\frac{13}{52}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_26.setLatexDrawable(JLatexMathDrawable.builder("P(B) = P(\\text{black}) = \\frac{26}{51}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_27.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B | A) \\\\ = \\frac{13}{52} \\times \\frac{26}{51} \\\\ = \\frac{13}{102}").textSize(50).background(0xFFffffff).padding(10).build());
        t6Latex_28.setLatexDrawable(JLatexMathDrawable.builder("P(A) = P(\\text{diamond}) = \\frac{13}{52}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_29.setLatexDrawable(JLatexMathDrawable.builder("P(B) = P(\\text{red}) = \\frac{25}{51}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_30.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B | A) \\\\ = \\frac{13}{52} \\times \\frac{25}{51} \\\\ = \\frac{25}{104}").textSize(50).background(0xFFffffff).padding(10).build());
        t6Latex_31.setLatexDrawable(JLatexMathDrawable.builder("P(A) = P(\\text{white}) = \\frac{6}{10}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_32.setLatexDrawable(JLatexMathDrawable.builder("P(B) = P(\\text{white}) = \\frac{5}{9}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_33.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B | A) \\\\ = \\frac{6}{10} \\times \\frac{5}{9} \\\\ = \\frac{1}{3}").textSize(50).background(0xFFffffff).padding(10).build());
        t6Latex_34.setLatexDrawable(JLatexMathDrawable.builder("P(A) = P(\\text{buko juice}) = \\frac{4}{10}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_35.setLatexDrawable(JLatexMathDrawable.builder("P(B) = P(\\text{buko juice}) = \\frac{3}{9}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_36.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B | A) \\\\ = \\frac{4}{10} \\times \\frac{3}{9} \\\\ = \\frac{2}{15}").textSize(50).background(0xFFffffff).padding(10).build());
        t6Latex_37.setLatexDrawable(JLatexMathDrawable.builder("P(A) = P(\\text{boy}) = \\frac{18}{30}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_38.setLatexDrawable(JLatexMathDrawable.builder("P(B) = P(\\text{girl}) = \\frac{12}{29}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t6Latex_39.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B | A) \\\\ = \\frac{18}{30} \\times \\frac{12}{29} \\\\ = \\frac{36}{145}").textSize(50).background(0xFFffffff).padding(10).build());

        String t6TextViewFormat2 = "<b><i>What are Dependent Events in Probability?</i></b><br><br>Events are <b>dependent</b> if the outcome of one event affects the outcome of another. For example, if you draw two colored balls from a bag and the first ball is not <b><i>replaced</i></b> before you draw the second ball then the outcome of the second draw will be affected by the outcome of the first draw.";
        String t6TextViewFormat3 = "If A and B are dependent events, then the probability of A happening <b>AND</b> the probability of B happening, given A, is P(A) × P(B after A).<br><br>Thus,";
        String t6TextViewFormat5 = "<b>Example 1</b><br><br>1. A bag contains 6 red, 5 blue, and 4 yellow marbles. Marbles are drawn in succession without replacement. What is the probability of drawing";
        String t6TextViewFormat7 = "(a) Let A be the event of drawing a red marble<br>Let B be the event of drawing a blue marble";
        String t6TextViewFormat63 = "<b>Example 2</b><br><br>Two cards are chosen at random without replacement from 52 ordinary deck of cards. What is the probability of getting";
        String t6TextViewFormat65 = "(a) Let A be the event of drawing a jack<br>Let B be the event of drawing a king";
        String t6TextViewFormat105 = "<b>Example 3</b><br><br>There are 6 green towels and 4 white towels in a drawer. If one towel is taken out without looking and then a second is taken out, what is the probability that they both will be white?";
        String t6TextViewFormat115 = "<b>Example 4</b><br><br>There are four glasses of buko juice and six glasses of pineapple juice in the cooler. Jef drinks two of them at random. What is the probability that he drank two glasses of buko juice?";
        String t6TextViewFormat125 = "<b>Example 5</b><br><br>Out of 30 students there are 18 boys and 12 girls. If a teacher chooses two students at random to present their project in math, what is the probability that he chooses a boy first, and then a girl on the second?";
        String t6Act1DirectionFormat = "<b>Activity 1</b><br><br>A box contains 5 white, 3 brown and 2 green marbles. Marbles are drawn in succession without replacement. What is the probability of drawing";
        String t6Act2DirectionFormat = "<b>Activity 2</b><br><br>A bag has seven red and three green balls. Two balls are drawn in sequence without replacement. What is the probability that";
        String t6Act3DirectionFormat = "<b>Activity 3</b><br><br>A box of chocolates contains 12 milk chocolates, 10 dark chocolates, and 3 white chocolates. Iya randomly chooses a chocolate, eats it, and then randomly chooses another chocolate. What is the probability that Iya chooses";
        String t6Act4DirectionFormat = "<b>Activity 4</b><br><br>A card is drawn from a deck of cards. Then the card is not replaced, the deck is reshuffled, and a second card is drawn. What is the probability of getting";
        String t6Act5DirectionFormat = "<b>Activity 5</b><br><br>Suppose a card is selected at random from an ordinary deck of 52 playing cards.<br><br>Let A = event a face card is selected<br>Let B = event a king is selected<br>Let C = event a heart is selected<br><br>Determine the following probabilities.";

        TextView[] textViewHtml = {t6TextView2, t6TextView3, t6TextView5, t6TextView7, t6TextView63, t6TextView65, t6TextView105, t6TextView115, t6TextView125, t6Act1Direction, t6Act2Direction, t6Act3Direction, t6Act4Direction, t6Act5Direction};
        String[] textViewFormat = {t6TextViewFormat2, t6TextViewFormat3, t6TextViewFormat5, t6TextViewFormat7, t6TextViewFormat63, t6TextViewFormat65, t6TextViewFormat105, t6TextViewFormat115, t6TextViewFormat125, t6Act1DirectionFormat, t6Act2DirectionFormat, t6Act3DirectionFormat, t6Act4DirectionFormat, t6Act5DirectionFormat};

        for (int i = 0; i < textViewHtml.length; i++) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i], Html.FROM_HTML_MODE_COMPACT));
            } else {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i]));
            }
        }

        TextView[] textViewTitle = {t6TextViewTitle1, t6TextViewTitle2, t6TextViewTitle3, t6TextViewTitle4, t6TextViewTitle5, t6TextViewTitle6};
        TextView[] textView = {t6TextView1, t6TextView2, t6TextView3, t6TextView4, t6TextView5, t6TextView6, t6TextView7, t6TextView8, t6TextView9, t6TextView10, t6TextView11, t6TextView12, t6TextView13, t6TextView14, t6TextView15, t6TextView16, t6TextView17, t6TextView18, t6TextView19, t6TextView20, t6TextView21, t6TextView22, t6TextView23, t6TextView24, t6TextView25, t6TextView26, t6TextView27, t6TextView28, t6TextView29, t6TextView30, t6TextView31, t6TextView32, t6TextView33, t6TextView34, t6TextView35, t6TextView36, t6TextView37, t6TextView38, t6TextView39, t6TextView40, t6TextView41, t6TextView42, t6TextView43, t6TextView44, t6TextView45, t6TextView46, t6TextView47, t6TextView48, t6TextView49, t6TextView50, t6TextView51, t6TextView52, t6TextView53, t6TextView54, t6TextView55, t6TextView56, t6TextView57, t6TextView58, t6TextView59, t6TextView60, t6TextView61, t6TextView62, t6TextView63, t6TextView64, t6TextView65, t6TextView66, t6TextView67, t6TextView68, t6TextView69, t6TextView70, t6TextView71, t6TextView72, t6TextView73, t6TextView74, t6TextView75, t6TextView76, t6TextView77, t6TextView78, t6TextView79, t6TextView80, t6TextView81, t6TextView82, t6TextView83, t6TextView84, t6TextView85, t6TextView86, t6TextView87, t6TextView88, t6TextView89, t6TextView90, t6TextView91, t6TextView92, t6TextView93, t6TextView94, t6TextView95, t6TextView96, t6TextView97, t6TextView98, t6TextView99, t6TextView100, t6TextView101, t6TextView102, t6TextView103, t6TextView104, t6TextView105, t6TextView106, t6TextView107, t6TextView108, t6TextView109, t6TextView110, t6TextView111, t6TextView112, t6TextView113, t6TextView114, t6TextView115, t6TextView116, t6TextView117, t6TextView118, t6TextView119, t6TextView120, t6TextView121, t6TextView122, t6TextView123, t6TextView124, t6TextView125, t6TextView126, t6TextView127, t6TextView128, t6TextView129, t6TextView130, t6TextView131, t6TextView132, t6TextView133, t6TextView134, t6ActScore, t6ActSolText, t6ActDirection, t6ActQuestion, t6Act1Direction, t6Act1Problems, t6Act2Direction, t6Act2Problems, t6Act3Direction, t6Act3Problems, t6Act4Direction, t6Act4Problems, t6Act5Direction, t6Act5Problems, t6SolutionExample1, t6SolutionExample2, t6SolutionExample3, t6SolutionExample4, t6SolutionExample5};

        t6ZoomControls.setOnZoomInClickListener(new View.OnClickListener() {
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

        t6ZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
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

        t6Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //Example Solutions

        TextView[] solutions = {t6SolutionExample1, t6SolutionExample2, t6SolutionExample3, t6SolutionExample4, t6SolutionExample5};
        LinearLayout[] solLayout = {t6Solution1, t6Solution2, t6Solution3, t6Solution4, t6Solution5};

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

        t6Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuDialog();
            }
        });

        t6ActStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t6ActLayout.setVisibility(View.VISIBLE);
                t6ActOpts.setVisibility(View.VISIBLE);
                t6ActAnsLayout.setVisibility(View.INVISIBLE);
                t6ActSolText.setVisibility(View.GONE);
                t6ActStart.setVisibility(View.GONE);
                t6ActDirection.setText("Read and understand each question carefully and select your answer from the multiple-choice options.");
                t6ActFeedback.setImageDrawable(null);
                t6ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(10).build());
                Button[] buttons = {t6ActOpt1, t6ActOpt2, t6ActOpt3, t6ActOpt4};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
                t6ActSubmit.setText("Submit");
                t6ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                currentIndex = 0;
                score = 0;
                nextQuestion = false;
                generateT6ActQuestions();
            }
        });

        t6ActSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nextQuestion == false) {
                    nextQuestion = true;
                    t6ActSubmit.setText("Next");
                    t6ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.black));
                    Button[] buttons = {t6ActOpt1, t6ActOpt2, t6ActOpt3, t6ActOpt4};
                    for (int i = 0; i < buttons.length; i++) {
                        buttons[i].setEnabled(false);
                    }
                    t6ActSolText.setVisibility(View.VISIBLE);
                    t6ActAns.setLatexDrawable(JLatexMathDrawable.builder(solution).textSize(50).background(0xFFb0d6f5).padding(10).build());
                    if (selectedAnswer.equals(answer)) {
                        t6ActFeedback.setImageResource(R.drawable.round_check_24);
                        score++;
                    } else {
                        t6ActFeedback.setImageResource(R.drawable.round_clear_24);
                    }
                }else {
                    currentIndex++;
                    if (currentIndex < t6ActQuesLength) {
                        generateT6ActQuestions();
                        nextQuestion = false;
                        t6ActAnsLayout.setVisibility(View.INVISIBLE);
                        t6ActSolText.setVisibility(View.GONE);
                        t6ActSubmit.setText("Submit");
                        t6ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                        t6ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(10).build());
                        t6ActFeedback.setImageDrawable(null);
                        Button[] buttons = {t6ActOpt1, t6ActOpt2, t6ActOpt3, t6ActOpt4};
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

        t6ActOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t6ActOpt1.getText().toString();
                t6ActAnsLayout.setVisibility(View.VISIBLE);
                t6ActSolText.setVisibility(View.GONE);
                t6ActOpt1.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t6ActOpt1.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t6ActOpt4, t6ActOpt2, t6ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t6ActOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t6ActOpt2.getText().toString();
                t6ActAnsLayout.setVisibility(View.VISIBLE);
                t6ActSolText.setVisibility(View.GONE);
                t6ActOpt2.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t6ActOpt2.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t6ActOpt1, t6ActOpt4, t6ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t6ActOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t6ActOpt3.getText().toString();
                t6ActAnsLayout.setVisibility(View.VISIBLE);
                t6ActSolText.setVisibility(View.GONE);
                t6ActOpt3.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t6ActOpt3.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t6ActOpt1, t6ActOpt2, t6ActOpt4};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t6ActOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t6ActOpt4.getText().toString();
                t6ActAnsLayout.setVisibility(View.VISIBLE);
                t6ActSolText.setVisibility(View.GONE);
                t6ActOpt4.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t6ActOpt4.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t6ActOpt1, t6ActOpt2, t6ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

    }

    private void generateT6ActQuestions() {
        t6ActQuestion.setText(activityQuestions.getT6ActQuestions(currentIndex));
        t6ActOpt1.setText(activityQuestions.getT6ActChoice1(currentIndex));
        t6ActOpt2.setText(activityQuestions.getT6ActChoice2(currentIndex));
        t6ActOpt3.setText(activityQuestions.getT6ActChoice3(currentIndex));
        t6ActOpt4.setText(activityQuestions.getT6ActChoice4(currentIndex));
        answer = activityQuestions.getT6ActAnswers(currentIndex);
        solution = activityQuestions.getT6ActSolutions(currentIndex);
    }

    private void showScore() {
        t6ActLayout.setVisibility(View.GONE);
        t6ActOpts.setVisibility(View.GONE);
        t6ActAnsLayout.setVisibility(View.GONE);
        t6ActStart.setVisibility(View.VISIBLE);
        t6ActStart.setText("Try Again");
        String actDirectionFormat = "Assessment Complete!<br>Your score is <b>" + score + "</b> out of " + t6ActQuesLength + ".";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            t6ActDirection.setText(Html.fromHtml(actDirectionFormat, Html.FROM_HTML_MODE_COMPACT));
        } else {
            t6ActDirection.setText(Html.fromHtml(actDirectionFormat));
        }
        t6ActScore.setText("Score: " + score + "/" + t6ActQuesLength);
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
        LayoutInflater inflater = LayoutInflater.from(TopicSixActivity.this);
        View view =  inflater.inflate(R.layout.custom_menu, null);

        TextView objectives = view.findViewById(R.id.objectives);
        TextView introduction = view.findViewById(R.id.introduction);
        TextView examples = view.findViewById(R.id.examples);
        TextView activities =view.findViewById(R.id.activities);
        TextView assessment = view.findViewById(R.id.assessment);

        TextView menu[] = {objectives, introduction, examples, activities, assessment};
        TextView title[] = {t6TextViewTitle1, t6TextViewTitle2, t6TextViewTitle3, t6TextViewTitle4, t6TextViewTitle5};
        String format[] = {"<u>Objectives</u>", "<u>Introduction to lesson</u>", "<u>Illustrative Examples</u>", "<u>Activities</u>", "<u>Assessment</u>"};

        AlertDialog.Builder builder = new AlertDialog.Builder(TopicSixActivity.this);
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
                    t6ScrollView.smoothScrollTo(0, title[finalI].getTop());
                    dialog.dismiss();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        endTime6 = System.currentTimeMillis();
        long timeDiff = endTime6 - startTime6;
        int newTime = (int) (timeDiff / 1000);

        Boolean checkId = dbHandler.checkTopicsId(607);
        if (checkId == true) {
            Map<String, String> studyTime = dbHandler.getTopicsId(607);
            if (!studyTime.isEmpty()) {
                int prevTime = Integer.parseInt(studyTime.get(TIME_IN_SEC));
                int totalTime = newTime + prevTime;
                dbHandler.updateTime(new StudyModelClass(607, totalTime));
            }
        } else {
            dbHandler.storeStudyTime(new StudyModelClass(607, newTime));
        }

        super.onBackPressed();
    }
}