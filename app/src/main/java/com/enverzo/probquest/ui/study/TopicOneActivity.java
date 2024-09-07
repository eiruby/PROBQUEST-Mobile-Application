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

public class TopicOneActivity extends AppCompatActivity {
    private TextView t1TextViewTitle1, t1TextViewTitle2, t1TextViewTitle3, t1TextViewTitle4, t1TextViewTitle5, t1TextViewTitle6, t1TextView1, t1TextView2, t1TextView3, t1TextView4, t1TextView5, t1TextView6, t1TextView7, t1TextView8, t1TextView9, t1TextView10, t1TextView11, t1TextView12, t1TextView13, t1TextView14, t1TextView15, t1TextView16, t1TextView17, t1TextView18, t1TextView19, t1TextView20, t1TextView21, t1TextView22, t1TextView23, t1TextView24, t1TextView25, t1TextView26, t1TextView27, t1TextView28, t1TextView29, t1TextView30, t1TextView31, t1TextView32, t1TextView33, t1TextView34, t1TextView35, t1TextView36, t1TextView37, t1TextView38, t1TextView39, t1TextView40, t1TextView41, t1TextView42, t1TextView43, t1TextView44, t1TextView45, t1TextView46, t1TextView47, t1TextView48, t1TextView49, t1TextView50, t1TextView51, t1TextView52, t1TextView53, t1TextView54, t1TextView55, t1TextView56, t1TextView67, t1TextView68, t1TextView70, t1TextView71, t1TextView72, t1TextView73, t1TextView74, t1TextView75, t1TextView76, t1TextView77, t1TextView78, t1TextView79, t1ActScore, t1ActSolText, t1ActDirection, t1ActQuestion, t1Act1Direction, t1Act1Problems, t1Act2Direction, t1Act2Problems, t1Act3Direction, t1Act3Problems, t1Act4Direction, t1Act4Problems, t1Act5Direction, t1Act5Problems, t1SolutionExample1, t1SolutionExample2, t1SolutionExample3, t1SolutionExample4, t1SolutionExample5;
    private JLatexMathView t1Latex_1, t1Latex_2, t1Latex_3, t1Latex_4, t1Latex_5, t1Latex_6, t1Latex_7, t1Latex_8, t1Latex_9, t1Latex_10, t1Latex_11, t1Latex_12, t1Latex_13, t1Latex_14, t1Latex_15, t1Latex_22, t1Latex_23, t1Latex_24, t1Latex_25, t1Latex_26, t1Latex_27, t1Latex_28, t1ActAns;
    private Button t1ActStart, t1ActOpt1, t1ActOpt2, t1ActOpt3, t1ActOpt4, t1ActSubmit;
    private ImageView t1ActFeedback, t1Back, t1Menu;
    private LinearLayout t1ActLayout, t1ActOpts, t1ActAnsLayout, t1Solution1, t1Solution2, t1Solution3, t1Solution4, t1Solution5;
    private VideoView t1Video;
    private ZoomControls t1ZoomControls;
    private ScrollView t1ScrollView;
    private int textSize = 16, currentIndex, score;
    private String selectedAnswer, answer, solution;
    private ActivityQuestions activityQuestions = new ActivityQuestions();
    private int t1ActQuesLength = activityQuestions.t1ActQuestions.length;
    private boolean nextQuestion = false, hideSolution = true;
    private static final String PREFS_FILE_NAME = "ActivityScore1";
    private static final String KEY_SCORE = "score";
    private long startTime1, endTime1, scoreValue;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_one);

        dbHandler = new DBHandler(this);

        t1Back = findViewById(R.id.t1Back);
        t1TextViewTitle1 = findViewById(R.id.t1TextViewTitle1);
        t1TextViewTitle2 = findViewById(R.id.t1TextViewTitle2);
        t1TextViewTitle3 = findViewById(R.id.t1TextViewTitle3);
        t1TextViewTitle4 = findViewById(R.id.t1TextViewTitle4);
        t1TextViewTitle5 = findViewById(R.id.t1TextViewTitle5);
        t1TextViewTitle6 = findViewById(R.id.t1TextViewTitle6);
        t1TextView1 = findViewById(R.id.t1TextView1);
        t1TextView2 = findViewById(R.id.t1TextView2);
        t1TextView3 = findViewById(R.id.t1TextView3);
        t1TextView4 = findViewById(R.id.t1TextView4);
        t1TextView5 = findViewById(R.id.t1TextView5);
        t1TextView6 = findViewById(R.id.t1TextView6);
        t1TextView7 = findViewById(R.id.t1TextView7);
        t1TextView8 = findViewById(R.id.t1TextView8);
        t1TextView9 = findViewById(R.id.t1TextView9);
        t1TextView10 = findViewById(R.id.t1TextView10);
        t1TextView11 = findViewById(R.id.t1TextView11);
        t1TextView12 = findViewById(R.id.t1TextView12);
        t1TextView13 = findViewById(R.id.t1TextView13);
        t1TextView14 = findViewById(R.id.t1TextView14);
        t1TextView15 = findViewById(R.id.t1TextView15);
        t1TextView16 = findViewById(R.id.t1TextView16);
        t1TextView17 = findViewById(R.id.t1TextView17);
        t1TextView18 = findViewById(R.id.t1TextView18);
        t1TextView19 = findViewById(R.id.t1TextView19);
        t1TextView20 = findViewById(R.id.t1TextView20);
        t1TextView21 = findViewById(R.id.t1TextView21);
        t1TextView22 = findViewById(R.id.t1TextView22);
        t1TextView23 = findViewById(R.id.t1TextView23);
        t1TextView24 = findViewById(R.id.t1TextView24);
        t1TextView25 = findViewById(R.id.t1TextView25);
        t1TextView26 = findViewById(R.id.t1TextView26);
        t1TextView27 = findViewById(R.id.t1TextView27);
        t1TextView28 = findViewById(R.id.t1TextView28);
        t1TextView29 = findViewById(R.id.t1TextView29);
        t1TextView30 = findViewById(R.id.t1TextView30);
        t1TextView31 = findViewById(R.id.t1TextView31);
        t1TextView32 = findViewById(R.id.t1TextView32);
        t1TextView33 = findViewById(R.id.t1TextView33);
        t1TextView34 = findViewById(R.id.t1TextView34);
        t1TextView35 = findViewById(R.id.t1TextView35);
        t1TextView36 = findViewById(R.id.t1TextView36);
        t1TextView37 = findViewById(R.id.t1TextView37);
        t1TextView38 = findViewById(R.id.t1TextView38);
        t1TextView39 = findViewById(R.id.t1TextView39);
        t1TextView40 = findViewById(R.id.t1TextView40);
        t1TextView41 = findViewById(R.id.t1TextView41);
        t1TextView42 = findViewById(R.id.t1TextView42);
        t1TextView43 = findViewById(R.id.t1TextView43);
        t1TextView44 = findViewById(R.id.t1TextView44);
        t1TextView45 = findViewById(R.id.t1TextView45);
        t1TextView46 = findViewById(R.id.t1TextView46);
        t1TextView47 = findViewById(R.id.t1TextView47);
        t1TextView48 = findViewById(R.id.t1TextView48);
        t1TextView49 = findViewById(R.id.t1TextView49);
        t1TextView50 = findViewById(R.id.t1TextView50);
        t1TextView51 = findViewById(R.id.t1TextView51);
        t1TextView52 = findViewById(R.id.t1TextView52);
        t1TextView53 = findViewById(R.id.t1TextView53);
        t1TextView54 = findViewById(R.id.t1TextView54);
        t1TextView55 = findViewById(R.id.t1TextView55);
        t1TextView56 = findViewById(R.id.t1TextView56);
        t1TextView67 = findViewById(R.id.t1TextView67);
        t1TextView68 = findViewById(R.id.t1TextView68);
        t1TextView70 = findViewById(R.id.t1TextView70);
        t1TextView71 = findViewById(R.id.t1TextView71);
        t1TextView72 = findViewById(R.id.t1TextView72);
        t1TextView73 = findViewById(R.id.t1TextView73);
        t1TextView74 = findViewById(R.id.t1TextView74);
        t1TextView75 = findViewById(R.id.t1TextView75);
        t1TextView76 = findViewById(R.id.t1TextView76);
        t1TextView77 = findViewById(R.id.t1TextView77);
        t1TextView78 = findViewById(R.id.t1TextView78);
        t1TextView79 = findViewById(R.id.t1TextView79);
        t1SolutionExample1 = findViewById(R.id.t1SolutionExample1);
        t1SolutionExample2 = findViewById(R.id.t1SolutionExample2);
        t1SolutionExample3 = findViewById(R.id.t1SolutionExample3);
        t1SolutionExample4 = findViewById(R.id.t1SolutionExample4);
        t1SolutionExample5 = findViewById(R.id.t1SolutionExample5);
        t1Solution1 = findViewById(R.id.t1Solution1);
        t1Solution2 = findViewById(R.id.t1Solution2);
        t1Solution3 = findViewById(R.id.t1Solution3);
        t1Solution4 = findViewById(R.id.t1Solution4);
        t1Solution5 = findViewById(R.id.t1Solution5);
        t1Latex_1 = findViewById(R.id.t1Latex_1);
        t1Latex_2 = findViewById(R.id.t1Latex_2);
        t1Latex_3 = findViewById(R.id.t1Latex_3);
        t1Latex_4 = findViewById(R.id.t1Latex_4);
        t1Latex_5 = findViewById(R.id.t1Latex_5);
        t1Latex_6 = findViewById(R.id.t1Latex_6);
        t1Latex_7 = findViewById(R.id.t1Latex_7);
        t1Latex_8 = findViewById(R.id.t1Latex_8);
        t1Latex_9 = findViewById(R.id.t1Latex_9);
        t1Latex_10 = findViewById(R.id.t1Latex_10);
        t1Latex_11 = findViewById(R.id.t1Latex_11);
        t1Latex_12 = findViewById(R.id.t1Latex_12);
        t1Latex_13 = findViewById(R.id.t1Latex_13);
        t1Latex_14 = findViewById(R.id.t1Latex_14);
        t1Latex_15 = findViewById(R.id.t1Latex_15);
        t1Latex_22 = findViewById(R.id.t1Latex_22);
        t1Latex_23 = findViewById(R.id.t1Latex_23);
        t1Latex_24 = findViewById(R.id.t1Latex_24);
        t1Latex_25 = findViewById(R.id.t1Latex_25);
        t1Latex_26 = findViewById(R.id.t1Latex_26);
        t1Latex_27 = findViewById(R.id.t1Latex_27);
        t1Latex_28 = findViewById(R.id.t1Latex_28);
        t1ZoomControls = findViewById(R.id.t1ZoomControls);
        t1Video = findViewById(R.id.t1Video);
        t1Back = findViewById(R.id.t1Back);
        t1Menu = findViewById(R.id.t1Menu);
        t1ScrollView = findViewById(R.id.t1ScrollView);
        t1ActScore = findViewById(R.id.t1ActScore);
        t1ActDirection = findViewById(R.id.t1ActDirection);
        t1ActQuestion = findViewById(R.id.t1ActQuestion);
        t1ActAns = findViewById(R.id.t1ActAns);
        t1ActSolText = findViewById(R.id.t1ActSolText);
        t1ActFeedback = findViewById(R.id.t1ActFeedback);
        t1ActStart = findViewById(R.id.t1ActStart);
        t1ActOpt1 = findViewById(R.id.t1ActOpt1);
        t1ActOpt2 = findViewById(R.id.t1ActOpt2);
        t1ActOpt3 = findViewById(R.id.t1ActOpt3);
        t1ActOpt4 = findViewById(R.id.t1ActOpt4);
        t1ActSubmit = findViewById(R.id.t1ActSubmit);
        t1ActLayout = findViewById(R.id.t1ActLayout);
        t1ActOpts = findViewById(R.id.t1ActOpts);
        t1ActAnsLayout = findViewById(R.id.t1ActAnsLayout);
        t1Act1Direction = findViewById(R.id.t1Act1Direction);
        t1Act2Direction = findViewById(R.id.t1Act2Direction);
        t1Act3Direction = findViewById(R.id.t1Act3Direction);
        t1Act4Direction = findViewById(R.id.t1Act4Direction);
        t1Act5Direction = findViewById(R.id.t1Act5Direction);
        t1Act1Problems = findViewById(R.id.t1Act1Problems);
        t1Act2Problems = findViewById(R.id.t1Act2Problems);
        t1Act3Problems = findViewById(R.id.t1Act3Problems);
        t1Act4Problems = findViewById(R.id.t1Act4Problems);
        t1Act5Problems = findViewById(R.id.t1Act5Problems);

        startTime1 = System.currentTimeMillis();

        String t1TextViewFormat2 = "<b><i>Sample Space and the Simple Event</i></b><br><br><b>Probability</b> is a field of mathematics that deals with chance. It deals with the occurrence of a random event. The probability of an event is a number between 0 and 1. If an event is sure to happen, then it has a certain probability. If an event is more likely to happen than not happen, then it has a likely probability. If the likelihood of two events happening is the same, then they have equal probability.";
        String t1TextViewFormat3 = "One of the basic concepts in the study of probability is the sample space. A <b>sample space</b> is the set of all possible outcomes of an experiment. An <b>experiment</b> is an activity in which the results cannot be predicted with certainty. In an experiment of tossing a coin, for example, the two possible outcomes are head and tail.";
        String t1TextViewFormat9 = "<i>Other examples that illustrate the sample space (S) of experiments are:</i><br><br>1. In taking a test of multiple choice with 4 options, the sample space has 4 outcomes,";
        String t1TextViewFormat19 = "Another basic concept in the study of probability is the event. An <b>event</b> is a subset of a sample space. An event may contain some, all, or none of the possible outcomes comprising the sample space.  For example, in an experiment of tossing a coin the event (E) of getting a head is H.";
        String t1TextViewFormat25 = "An event may be a simple event or compound event. A <b>simple event</b> refers to an event with a single outcome while a <b>compound event</b> is any event combining two or more simple events. When a single coin is tossed, the event where a tail appears is a simple event. If the same coin is tossed twice, the event that two tails appear consecutively is a simple event, but the event that at least one head appears is a compound event. The possible outcomes for these compound events are HH, HT, and TH.<br><br>In this lesson, we will be dealing with the probability of simple events. In any experiment, when finding the probability of events occurring, we will use the formula:";
        String t1TextViewFormat27 = "<b>Example 1</b><br><br>A playing card is drawn at random from a well-shuffled deck of 52 cards. Find the probability of drawing";
        String t1TextViewFormat42 = "<b>Example 2</b><br><br>A box contains 9 violet marbles, 8 yellow marbles, and 3 green marbles. If a marble is picked at random, what is the probability that it is";
        String t1TextViewFormat52 = "<b>Example 3</b><br><br>A six-sided die is rolled, what is the probability of getting";
        String t1TextViewFormat54 = "<b>Example 4</b><br><br>A married couple plans to have three children. What is the probability that all three will be boys?";
        String t1TextViewFormat74 = "<b>Example 5</b><br><br>There are x orange balls, 4 purple balls, and 2x + 6 yellow balls in a box. One ball is selected at random from the box. If the probability that the selected ball is orange is equal to 1/4, what is the value of x? The selected ball is then put back into the box and another ball is then selected. Find the probability that the selected ball will be";
        String t1Act1DirectionFormat = "<b>Activity 1</b><br><br>Find the number of outcomes of a sample space associated with each random experience.";
        String t1Act2DirectionFormat = "<b>Activity 2</b><br><br>A spinner with 10 equally likely outcomes is spinned. The possible outcomes are 1,2,3,4,5,6,7,8,9, and 10. What is the probability of getting:";
        String t1Act3DirectionFormat = "<b>Activity 3</b><br><br>A die is rolled. What is the probability of getting:";
        String t1Act4DirectionFormat = "<b>Activity 4</b><br><br>A card is drawn at random from a deck of 52 cards. What is the probability of getting:";
        String t1Act5DirectionFormat = "<b>Activity 5</b><br><br>There are x white balls, 4 black balls, and 2x + 6 green balls in a box. One ball is selected at random from the box. If the probability that the selected ball is orange is equal to 1/4, what is the value of x? The selected ball is then put back into the box and another ball is then selected. What is the probability that the selected ball will be";

        TextView[] textViewsHtml = {t1TextView2, t1TextView3, t1TextView9, t1TextView19, t1TextView25, t1TextView27, t1TextView42, t1TextView52, t1TextView54, t1TextView74, t1Act1Direction, t1Act2Direction, t1Act3Direction, t1Act4Direction, t1Act5Direction};
        String[] textViewFormat = {t1TextViewFormat2, t1TextViewFormat3, t1TextViewFormat9, t1TextViewFormat19, t1TextViewFormat25, t1TextViewFormat27, t1TextViewFormat42, t1TextViewFormat52, t1TextViewFormat54, t1TextViewFormat74, t1Act1DirectionFormat, t1Act2DirectionFormat, t1Act3DirectionFormat, t1Act4DirectionFormat, t1Act5DirectionFormat};

        for (int i = 0; i < textViewsHtml.length; i++) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                textViewsHtml[i].setText(Html.fromHtml(textViewFormat[i], Html.FROM_HTML_MODE_COMPACT));
            } else {
                textViewsHtml[i].setText(Html.fromHtml(textViewFormat[i]));
            }
        }

        t1Latex_1.setLatexDrawable(JLatexMathDrawable.builder("\\text{Probability of Event } = \\frac{\\text{number of event}}{\\text{number of sample space}} \\text{ or}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t1Latex_2.setLatexDrawable(JLatexMathDrawable.builder("\\text{Probability of Event } = \\frac{\\text{number of possible outcomes to an Event E}}{\\text{total number of outcomes}}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t1Latex_3.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{n(E)}{n(S)}").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t1Latex_4.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{\\text{number of event}}{\\text{number of sample space}} = \\frac{n(E)}{n(S)} \\\\ P(\\text{drawing a heart}) = \\frac{13}{52} = \\frac{1}{4}").textSize(50).background(0xFFffffff).padding(10).build());
        t1Latex_5.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{\\text{number of event}}{\\text{number of sample space}} = \\frac{n(E)}{n(S)} \\\\ P(\\text{drawing a red card}) = \\frac{26}{52} = \\frac{1}{2}").textSize(50).background(0xFFffffff).padding(10).build());
        t1Latex_6.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{\\text{number of event}}{\\text{number of sample space}} = \\frac{n(E)}{n(S)} \\\\ P(\\text{drawing a face card}) = \\frac{12}{52} = \\frac{3}{13}").textSize(50).background(0xFFffffff).padding(10).build());
        t1Latex_7.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{\\text{number of event}}{\\text{number of sample space}} = \\frac{n(E)}{n(S)} \\\\ P(\\text{drawing a king}) = \\frac{4}{52} = \\frac{1}{13}").textSize(50).background(0xFFffffff).padding(10).build());
        t1Latex_8.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{\\text{number of event}}{\\text{number of sample space}} = \\frac{n(E)}{n(S)} \\\\ P(\\text{drawing a jack of diamonds}) = \\frac{1}{52}").textSize(50).background(0xFFffffff).padding(10).build());
        t1Latex_9.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{\\text{number of event}}{\\text{number of sample space}} = \\frac{n(E)}{n(S)} \\\\ P(\\text{drawing a red queen}) = \\frac{2}{52} = \\frac{1}{26}").textSize(50).background(0xFFffffff).padding(10).build());
        t1Latex_10.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{\\text{number of event}}{\\text{number of sample space}} = \\frac{n(E)}{n(S)} \\\\ P(\\text{picking a violet marble}) = \\frac{9}{20}").textSize(50).background(0xFFffffff).padding(10).build());
        t1Latex_11.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{\\text{number of event}}{\\text{number of sample space}} = \\frac{n(E)}{n(S)} \\\\ P(\\text{picking a yellow marble}) = \\frac{8}{20} = \\frac{2}{5}").textSize(50).background(0xFFffffff).padding(10).build());
        t1Latex_12.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{\\text{number of event}}{\\text{number of sample space}} = \\frac{n(E)}{n(S)} \\\\ P(\\text{picking a green marble}) = \\frac{3}{20}").textSize(50).background(0xFFffffff).padding(10).build());
        t1Latex_13.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{\\text{number of event}}{\\text{number of sample space}} = \\frac{n(E)}{n(S)} \\\\ P(\\text{picking a not green marble}) = \\frac{17}{20}").textSize(50).background(0xFFffffff).padding(10).build());
        t1Latex_14.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{\\text{number of event}}{\\text{number of sample space}} = \\frac{n(E)}{n(S)} \\\\ P(\\text{getting a 5}) = \\frac{1}{6}").textSize(50).background(0xFFffffff).padding(10).build());
        t1Latex_15.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{\\text{number of event}}{\\text{number of sample space}} = \\frac{n(E)}{n(S)} \\\\ P(\\text{getting two tails}) = \\frac{1}{8}").textSize(50).background(0xFFffffff).padding(10).build());
        t1Latex_22.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{\\text{number of event}}{\\text{number of sample space}} = \\frac{n(E)}{n(S)} \\\\ P(\\text{getting an even number}) = \\frac{3}{6} = \\frac{1}{2}").textSize(50).background(0xFFffffff).padding(10).build());
        t1Latex_23.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{\\text{number of event}}{\\text{number of sample space}} = \\frac{n(E)}{n(S)} \\\\ P(\\text{getting a prime number}) = \\frac{3}{6} = \\frac{1}{2}").textSize(50).background(0xFFffffff).padding(10).build());
        t1Latex_24.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{\\text{number of event}}{\\text{number of sample space}} = \\frac{n(E)}{n(S)} \\\\ P(\\text{getting a factor of 6}) = \\frac{4}{6} = \\frac{2}{3}").textSize(50).background(0xFFffffff).padding(10).build());
        t1Latex_25.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{\\text{number of event}}{\\text{number of sample space}} = \\frac{n(E)}{n(S)} \\\\ P(\\text{getting a composite number}) = \\frac{1}{6}").textSize(50).background(0xFFffffff).padding(10).build());
        t1Latex_26.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{\\text{number of event}}{\\text{number of sample space}} = \\frac{n(E)}{n(S)} \\\\ P(\\text{ball is orange}) = \\frac{x}{2x + 6} = \\frac{1}{4} \\\\ 4x = 2x + 6 \\\\ 2x = 6 \\\\ x = 3").textSize(50).background(0xFFffffff).padding(10).build());
        t1Latex_27.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{\\text{number of event}}{\\text{number of sample space}} = \\frac{n(E)}{n(S)} \\\\ P(\\text{selecting a purple ball}) = \\frac{4}{19}").textSize(50).background(0xFFffffff).padding(10).build());
        t1Latex_28.setLatexDrawable(JLatexMathDrawable.builder("P(E) = \\frac{\\text{number of event}}{\\text{number of sample space}} = \\frac{n(E)}{n(S)} \\\\ P(\\text{selecting a yellow ball}) = \\frac{12}{19}").textSize(50).background(0xFFffffff).padding(10).build());

        t1Video.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.simple_events);
        MediaController mediaController = new MediaController(TopicOneActivity.this);
        mediaController.setAnchorView(t1Video);
        t1Video.setMediaController(mediaController);

        loadScore();
        t1ActScore.setText("Score: " + scoreValue + "/" + t1ActQuesLength);

        t1Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        TextView[] textViewTitle = new TextView[]{t1TextViewTitle1, t1TextViewTitle2, t1TextViewTitle3, t1TextViewTitle4, t1TextViewTitle5, t1TextViewTitle6};
        TextView[] textView = new TextView[]{t1TextView1, t1TextView2, t1TextView3, t1TextView4, t1TextView5, t1TextView6, t1TextView7, t1TextView8, t1TextView9, t1TextView10, t1TextView11, t1TextView12, t1TextView13, t1TextView14, t1TextView15, t1TextView16, t1TextView17, t1TextView18, t1TextView19, t1TextView20, t1TextView21, t1TextView22, t1TextView23, t1TextView24, t1TextView25, t1TextView26, t1TextView27, t1TextView28, t1TextView29, t1TextView30, t1TextView31, t1TextView32, t1TextView33, t1TextView34, t1TextView35, t1TextView36, t1TextView37, t1TextView38, t1TextView39, t1TextView40, t1TextView41, t1TextView42, t1TextView43, t1TextView44, t1TextView45, t1TextView46, t1TextView47, t1TextView48, t1TextView49, t1TextView50, t1TextView51, t1TextView52, t1TextView53, t1TextView54, t1TextView55, t1TextView56, t1TextView67, t1TextView68, t1TextView70, t1TextView71, t1TextView72, t1TextView73, t1TextView74, t1TextView75, t1TextView76, t1TextView77, t1TextView78, t1TextView79, t1ActScore, t1ActSolText, t1ActDirection, t1ActQuestion, t1Act1Direction, t1Act1Problems, t1Act2Direction, t1Act2Problems, t1Act3Direction, t1Act3Problems, t1Act4Direction, t1Act4Problems, t1Act5Direction, t1Act5Problems, t1SolutionExample1, t1SolutionExample2, t1SolutionExample3, t1SolutionExample4};

        t1ZoomControls.setOnZoomInClickListener(new View.OnClickListener() {
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

        t1ZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
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

        //Example Solutions

        TextView[] solutions = {t1SolutionExample1, t1SolutionExample2, t1SolutionExample3, t1SolutionExample4, t1SolutionExample5};
        LinearLayout[] solLayout = {t1Solution1, t1Solution2, t1Solution3, t1Solution4, t1Solution5};

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

        t1Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuDialog();
            }
        });

        t1ActStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1ActLayout.setVisibility(View.VISIBLE);
                t1ActOpts.setVisibility(View.VISIBLE);
                t1ActAnsLayout.setVisibility(View.INVISIBLE);
                t1ActSolText.setVisibility(View.GONE);
                t1ActStart.setVisibility(View.GONE);
                t1ActDirection.setText("Read and understand each question carefully and select your answer from the multiple-choice options.");
                t1ActFeedback.setImageDrawable(null);
                t1ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(8).build());
                Button[] buttons = {t1ActOpt1, t1ActOpt2, t1ActOpt3, t1ActOpt4};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
                t1ActSubmit.setText("Submit");
                t1ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                currentIndex = 0;
                score = 0;
                nextQuestion = false;
                generateT1ActQuestions();
            }
        });

        t1ActSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nextQuestion == false) {
                    nextQuestion = true;
                    t1ActSubmit.setText("Next");
                    t1ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.black));
                    Button[] buttons = {t1ActOpt1, t1ActOpt2, t1ActOpt3, t1ActOpt4};
                    for (int i = 0; i < buttons.length; i++) {
                        buttons[i].setEnabled(false);
                    }
                    t1ActSolText.setVisibility(View.VISIBLE);
                    t1ActAns.setLatexDrawable(JLatexMathDrawable.builder(answer).textSize(50).background(0xFFb0d6f5).padding(10).build());
                    if (selectedAnswer.equals(answer)) {
                        t1ActFeedback.setImageResource(R.drawable.round_check_24);
                        score++;
                    } else {
                        t1ActFeedback.setImageResource(R.drawable.round_clear_24);
                    }
                }else {
                    currentIndex++;
                    if (currentIndex < t1ActQuesLength) {
                        generateT1ActQuestions();
                        nextQuestion = false;
                        t1ActAnsLayout.setVisibility(View.INVISIBLE);
                        t1ActSolText.setVisibility(View.GONE);
                        t1ActSubmit.setText("Submit");
                        t1ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                        t1ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(10).build());
                        t1ActFeedback.setImageDrawable(null);
                        Button[] buttons = {t1ActOpt1, t1ActOpt2, t1ActOpt3, t1ActOpt4};
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

        t1ActOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t1ActOpt1.getText().toString();
                t1ActAnsLayout.setVisibility(View.VISIBLE);
                t1ActOpt1.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t1ActOpt1.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t1ActOpt4, t1ActOpt2, t1ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t1ActOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t1ActOpt2.getText().toString();
                t1ActAnsLayout.setVisibility(View.VISIBLE);
                t1ActOpt2.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t1ActOpt2.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t1ActOpt4, t1ActOpt1, t1ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t1ActOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t1ActOpt3.getText().toString();
                t1ActAnsLayout.setVisibility(View.VISIBLE);
                t1ActOpt3.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t1ActOpt3.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t1ActOpt4, t1ActOpt2, t1ActOpt1};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t1ActOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t1ActOpt4.getText().toString();
                t1ActAnsLayout.setVisibility(View.VISIBLE);
                t1ActOpt4.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t1ActOpt4.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t1ActOpt1, t1ActOpt2, t1ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
    }

    private void generateT1ActQuestions() {
        t1ActQuestion.setText(activityQuestions.getT1ActQuestions(currentIndex));
        t1ActOpt1.setText(activityQuestions.getT1ActChoice1(currentIndex));
        t1ActOpt2.setText(activityQuestions.getT1ActChoice2(currentIndex));
        t1ActOpt3.setText(activityQuestions.getT1ActChoice3(currentIndex));
        t1ActOpt4.setText(activityQuestions.getT1ActChoice4(currentIndex));
        answer = activityQuestions.getT1ActAnswers(currentIndex);
    }

    private void showScore() {
        t1ActLayout.setVisibility(View.GONE);
        t1ActOpts.setVisibility(View.GONE);
        t1ActAnsLayout.setVisibility(View.GONE);
        t1ActStart.setVisibility(View.VISIBLE);
        t1ActStart.setText("Try Again");
        String actDirectionFormat = "Assessment Complete!<br>Your score is <b>" + score + "</b> out of " + t1ActQuesLength + ".";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            t1ActDirection.setText(Html.fromHtml(actDirectionFormat, Html.FROM_HTML_MODE_COMPACT));
        } else {
            t1ActDirection.setText(Html.fromHtml(actDirectionFormat));
        }
        t1ActScore.setText("Score: " + score + "/" + t1ActQuesLength);
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
        LayoutInflater inflater = LayoutInflater.from(TopicOneActivity.this);
        View view =  inflater.inflate(R.layout.custom_menu, null);

        TextView objectives = view.findViewById(R.id.objectives);
        TextView introduction = view.findViewById(R.id.introduction);
        TextView examples = view.findViewById(R.id.examples);
        TextView activities =view.findViewById(R.id.activities);
        TextView assessment = view.findViewById(R.id.assessment);

        TextView menu[] = {objectives, introduction, examples, activities, assessment};
        TextView title[] = {t1TextViewTitle1, t1TextViewTitle2, t1TextViewTitle3, t1TextViewTitle4, t1TextViewTitle5};
        String format[] = {"<u>Objectives</u>", "<u>Introduction to lesson</u>", "<u>Illustrative Examples</u>", "<u>Activities</u>", "<u>Assessment</u>"};

        AlertDialog.Builder builder = new AlertDialog.Builder(TopicOneActivity.this);
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
                    t1ScrollView.smoothScrollTo(0, title[finalI].getTop());
                    dialog.dismiss();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        endTime1 = System.currentTimeMillis();
        long timeDiff = endTime1 - startTime1;
        int newTime = (int) (timeDiff / 1000);

        Boolean checkId = dbHandler.checkTopicsId(470);
        if (checkId == true) {
            Map<String, String> studyTime = dbHandler.getTopicsId(470);
            if (!studyTime.isEmpty()) {
                int prevTime = Integer.parseInt(studyTime.get(TIME_IN_SEC));
                int totalTime = newTime + prevTime;
                dbHandler.updateTime(new StudyModelClass(470, totalTime));
            }
        } else {
            dbHandler.storeStudyTime(new StudyModelClass(470, newTime));
        }

        super.onBackPressed();
    }
}