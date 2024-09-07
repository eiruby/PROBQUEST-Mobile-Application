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
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.ZoomControls;

import com.enverzo.probquest.DBHandler;
import com.enverzo.probquest.R;

import java.util.Map;

import ru.noties.jlatexmath.JLatexMathDrawable;
import ru.noties.jlatexmath.JLatexMathView;

public class TopicThreeActivity extends AppCompatActivity {
    private TextView t3TextViewTitle1, t3TextViewTitle2, t3TextViewTitle3, t3TextViewTitle4, t3TextViewTitle5, t3TextViewTitle6, t3TextView1, t3TextView2, t3TextView3, t3TextView4, t3TextView5, t3TextView6, t3TextView7, t3TextView8, t3TextView9, t3TextView10, t3TextView11, t3TextView12, t3TextView13, t3TextView14, t3TextView15, t3TextView18, t3TextView19, t3TextView23, t3TextView24, t3TextView25, t3TextView26, t3TextView27, t3TextView28, t3TextView29, t3TextView30, t3TextView31, t3TextView32, t3TextView33, t3TextView34, t3TextView35, t3TextView36, t3TextView37, t3TextView38, t3TextView39, t3TextView40, t3TextView41, t3TextView42, t3TextView43, t3TextView44, t3TextView45, t3TextView46, t3TextView47, t3Act1Score, t3ActScore, t3Act1Direction, t3ActDirection, t3Act1Question, t3ActQuestion, t3ActSolText, t3Act2Direction, t3Act3Direction, t3Act4Direction, t3Act5Direction, t3SolutionExample1, t3SolutionExample2, t3SolutionExample3, t3SolutionExample4, t3SolutionExample5;
    private ImageView t3Back, t3Act1Feedback, t3ActFeedback, t3Menu;
    private JLatexMathView t3Latex_1, t3Latex_2, t3Latex_3, t3Latex_4, t3Latex_5, t3Latex_8, t3Latex_9, t3Latex_10, t3Latex_11, t3Latex_12, t3Latex_13, t3Latex_14, t3Latex_15, t3Latex_16, t3Latex_17, t3Latex_18, t3Latex_19, t3Latex_20, t3Latex_21, t3ActAns;
    private LinearLayout t3Act1Layout, t3Act1Opts, t3ActOpts, t3ActLayout, t3ActAnsLayout, t3Solution1, t3Solution2, t3Solution3, t3Solution4, t3Solution5;
    private Button t3Act1Opt1, t3Act1Opt2, t3Act1Start, t3Act1Submit, t3ActStart, t3ActSubmit, t3ActOpt1, t3ActOpt2, t3ActOpt3, t3ActOpt4;
    private VideoView t3Video;
    private ActivityQuestions activityQuestions = new ActivityQuestions();
    private int t3Act1QuesLength = 10, t3ActQuesLength = activityQuestions.t3ActQuestions.length;
    private ZoomControls t3ZoomControls;
    private ScrollView t3ScrollView;
    private int textSize = 16, score1, score, currentIndex;
    private long startTime3, endTime3, scoreValue1, scoreValue;
    private boolean nextQuestion = false, activityOngoing = false, activity1Selected = false, activitySelected = false, hideSolution = true;
    private String selectedAnswer, answer1, answer;
    private static final String PREFS_FILE_NAME = "ActivityScore3";
    private static final String KEY_SCORE1 = "score1";
    private static final String KEY_SCORE = "score";
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_three);

        dbHandler = new DBHandler(this);

        t3Back = findViewById(R.id.t3Back);
        t3TextViewTitle1 = findViewById(R.id.t3TextViewTitle1);
        t3TextViewTitle2 = findViewById(R.id.t3TextViewTitle2);
        t3TextViewTitle3 = findViewById(R.id.t3TextViewTitle3);
        t3TextViewTitle4 = findViewById(R.id.t3TextViewTitle4);
        t3TextViewTitle5 = findViewById(R.id.t3TextViewTitle5);
        t3TextViewTitle6 = findViewById(R.id.t3TextViewTitle6);
        t3TextView1 = findViewById(R.id.t3TextView1);
        t3TextView2 = findViewById(R.id.t3TextView2);
        t3TextView3 = findViewById(R.id.t3TextView3);
        t3TextView4 = findViewById(R.id.t3TextView4);
        t3TextView5 = findViewById(R.id.t3TextView5);
        t3TextView6 = findViewById(R.id.t3TextView6);
        t3TextView7 = findViewById(R.id.t3TextView7);
        t3TextView8 = findViewById(R.id.t3TextView8);
        t3TextView9 = findViewById(R.id.t3TextView9);
        t3TextView10 = findViewById(R.id.t3TextView10);
        t3TextView11 = findViewById(R.id.t3TextView11);
        t3TextView12 = findViewById(R.id.t3TextView12);
        t3TextView13 = findViewById(R.id.t3TextView13);
        t3TextView14 = findViewById(R.id.t3TextView14);
        t3TextView15 = findViewById(R.id.t3TextView15);
        t3TextView18 = findViewById(R.id.t3TextView18);
        t3TextView19 = findViewById(R.id.t3TextView19);
        t3TextView23 = findViewById(R.id.t3TextView23);
        t3TextView24 = findViewById(R.id.t3TextView24);
        t3TextView25 = findViewById(R.id.t3TextView25);
        t3TextView26 = findViewById(R.id.t3TextView26);
        t3TextView27 = findViewById(R.id.t3TextView27);
        t3TextView28 = findViewById(R.id.t3TextView28);
        t3TextView29 = findViewById(R.id.t3TextView29);
        t3TextView30 = findViewById(R.id.t3TextView30);
        t3TextView31 = findViewById(R.id.t3TextView31);
        t3TextView32 = findViewById(R.id.t3TextView32);
        t3TextView33 = findViewById(R.id.t3TextView33);
        t3TextView34 = findViewById(R.id.t3TextView34);
        t3TextView35 = findViewById(R.id.t3TextView35);
        t3TextView36 = findViewById(R.id.t3TextView36);
        t3TextView37 = findViewById(R.id.t3TextView37);
        t3TextView38 = findViewById(R.id.t3TextView38);
        t3TextView39 = findViewById(R.id.t3TextView39);
        t3TextView40 = findViewById(R.id.t3TextView40);
        t3TextView41 = findViewById(R.id.t3TextView41);
        t3TextView42 = findViewById(R.id.t3TextView42);
        t3TextView43 = findViewById(R.id.t3TextView43);
        t3TextView44 = findViewById(R.id.t3TextView44);
        t3TextView45 = findViewById(R.id.t3TextView45);
        t3TextView46 = findViewById(R.id.t3TextView46);
        t3TextView47 = findViewById(R.id.t3TextView47);
        t3SolutionExample1 = findViewById(R.id.t3SolutionExample1);
        t3SolutionExample2 = findViewById(R.id.t3SolutionExample2);
        t3SolutionExample3 = findViewById(R.id.t3SolutionExample3);
        t3SolutionExample4 = findViewById(R.id.t3SolutionExample4);
        t3SolutionExample5 = findViewById(R.id.t3SolutionExample5);
        t3Solution1 = findViewById(R.id.t3Solution1);
        t3Solution2 = findViewById(R.id.t3Solution2);
        t3Solution3 = findViewById(R.id.t3Solution3);
        t3Solution4 = findViewById(R.id.t3Solution4);
        t3Solution5 = findViewById(R.id.t3Solution5);
        t3Latex_1 = findViewById(R.id.t3Latex_1);
        t3Latex_2 = findViewById(R.id.t3Latex_2);
        t3Latex_3 = findViewById(R.id.t3Latex_3);
        t3Latex_4 = findViewById(R.id.t3Latex_4);
        t3Latex_5 = findViewById(R.id.t3Latex_5);
        t3Latex_8 = findViewById(R.id.t3Latex_8);
        t3Latex_9 = findViewById(R.id.t3Latex_9);
        t3Latex_10 = findViewById(R.id.t3Latex_10);
        t3Latex_11 = findViewById(R.id.t3Latex_11);
        t3Latex_12 = findViewById(R.id.t3Latex_12);
        t3Latex_13 = findViewById(R.id.t3Latex_13);
        t3Latex_14 = findViewById(R.id.t3Latex_14);
        t3Latex_15 = findViewById(R.id.t3Latex_15);
        t3Latex_16 = findViewById(R.id.t3Latex_16);
        t3Latex_17 = findViewById(R.id.t3Latex_17);
        t3Latex_18 = findViewById(R.id.t3Latex_18);
        t3Latex_19 = findViewById(R.id.t3Latex_19);
        t3Latex_20 = findViewById(R.id.t3Latex_20);
        t3Latex_21 = findViewById(R.id.t3Latex_21);
        t3Video = findViewById(R.id.t3Video);
        t3Menu = findViewById(R.id.t3Menu);
        t3ZoomControls = findViewById(R.id.t3ZoomControls);
        t3ScrollView = findViewById(R.id.t3ScrollView);
        t3Act1Score = findViewById(R.id.t3Act1Score);
        t3Act1Direction = findViewById(R.id.t3Act1Direction);
        t3Act1Question = findViewById(R.id.t3Act1Question);
        t3Act1Feedback = findViewById(R.id.t3Act1Feedback);
        t3Act1Layout = findViewById(R.id.t3Act1Layout);
        t3Act1Opts = findViewById(R.id.t3Act1Opt);
        t3Act1Opt1 = findViewById(R.id.t3Act1Opt1);
        t3Act1Opt2 = findViewById(R.id.t3Act1Opt2);
        t3Act1Start = findViewById(R.id.t3Act1Start);
        t3Act1Submit = findViewById(R.id.t3Act1Submit);
        t3ActScore = findViewById(R.id.t3ActScore);
        t3ActDirection = findViewById(R.id.t3ActDirection);
        t3ActQuestion = findViewById(R.id.t3ActQuestion);
        t3ActFeedback = findViewById(R.id.t3ActFeedback);
        t3ActLayout = findViewById(R.id.t3ActLayout);
        t3ActOpts = findViewById(R.id.t3ActOpts);
        t3ActOpt1 = findViewById(R.id.t3ActOpt1);
        t3ActOpt2 = findViewById(R.id.t3ActOpt2);
        t3ActOpt3 = findViewById(R.id.t3ActOpt3);
        t3ActOpt4 = findViewById(R.id.t3ActOpt4);
        t3ActStart = findViewById(R.id.t3ActStart);
        t3ActSubmit = findViewById(R.id.t3ActSubmit);
        t3ActAns = findViewById(R.id.t3ActAns);
        t3ActAnsLayout = findViewById(R.id.t3ActAnsLayout);
        t3ActSolText = findViewById(R.id.t3ActSolText);
        t3Act2Direction = findViewById(R.id.t3Act2Direction);
        t3Act3Direction = findViewById(R.id.t3Act3Direction);
        t3Act4Direction = findViewById(R.id.t3Act4Direction);
        t3Act5Direction = findViewById(R.id.t3Act5Direction);

        startTime3 = System.currentTimeMillis();

        t3Latex_1.setLatexDrawable(JLatexMathDrawable.builder("P(A \\cap B) = P(A \\text{ or } B) = P(A) + P(B)").textSize(50).background(0xFFffffff).padding(10).align(JLatexMathDrawable.ALIGN_CENTER).build());
        t3Latex_2.setLatexDrawable(JLatexMathDrawable.builder("P(2) = \\frac{1}{6} \\text{ and } P(5) = \\frac{1}{6}").textSize(50).background(0xFFffffff).padding(10).build());
        t3Latex_3.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ or } B) = P(A) + P(B) \\\\ P(2 \\text{ or } 5) = P(2) + P(5) \\\\ = \\frac{1}{6} + \\frac{1}{6} \\\\ = \\frac{2}{6} = \\frac{1}{3}").textSize(50).background(0xFFffffff).padding(10).build());
        t3Latex_4.setLatexDrawable(JLatexMathDrawable.builder("P(queen) = \\frac{4}{52} = \\frac{1}{13} \\text{ and } P(ace) = \\frac{4}{52} = \\frac{1}{13}").textSize(50).background(0xFFffffff).padding(10).build());
        t3Latex_5.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ or } B) = P(A) + P(B) \\\\ P(queen \\text{ or } ace) = P(queen) + P(ace) \\\\ = \\frac{1}{13} + \\frac{1}{13} \\\\ = \\frac{2}{13}").textSize(50).background(0xFFffffff).padding(10).build());
        t3Latex_8.setLatexDrawable(JLatexMathDrawable.builder("P(\\text{head and 2}) = \\frac{1}{12}, \\\\ P(\\text{tail and 4}) = \\frac{1}{12}").textSize(50).background(0xFFffffff).padding(10).build());
        t3Latex_9.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ or } B) = P(A) + P(B) \\\\ P(\\text{(head and 2) or (tail and 4)}) \\\\ = P(\\text{head and 2}) + P(\\text{tail and 4}) \\\\ = \\frac{1}{12} + \\frac{1}{12} \\\\ = \\frac{2}{12} = \\frac{1}{6}").textSize(50).background(0xFFffffff).padding(10).build());
        t3Latex_10.setLatexDrawable(JLatexMathDrawable.builder("P(China) = \\frac{2}{7}, \\\\ P(Philippines) = \\frac{1}{3}, \\\\ P(USA) = \\frac{1}{5}").textSize(50).background(0xFFffffff).padding(10).build());
        t3Latex_11.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ or } B) = P(A) + P(B) \\\\ P(Philippines\\text{ or }USA) = P(Philippines) + P(USA) \\\\ = \\frac{1}{3} + \\frac{1}{5} \\\\ = \\frac{8}{15}").textSize(50).background(0xFFffffff).padding(10).build());
        t3Latex_12.setLatexDrawable(JLatexMathDrawable.builder("P(\\text{all heads}) = \\frac{1}{8}, \\\\ P(\\text{exactly two tails}) = \\frac{3}{8}").textSize(50).background(0xFFffffff).padding(10).build());
        t3Latex_13.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ or } B) = P(A) + P(B) \\\\ P(\\text{all heads or exactly two tails}) \\\\ = P(\\text{all heads}) + P(\\text{exactly two tails}) \\\\ = \\frac{1}{8} + \\frac{3}{8} \\\\ = \\frac{4}{8} = \\frac{1}{2}").textSize(50).background(0xFFffffff).padding(10).build());
        t3Latex_14.setLatexDrawable(JLatexMathDrawable.builder("P(\\text{all tails}) = \\frac{1}{8}, \\\\ P(\\text{at least one head}) = \\frac{7}{8}").textSize(50).background(0xFFffffff).padding(10).build());
        t3Latex_15.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ or } B) = P(A) + P(B) \\\\ P(\\text{all tails or at least one head}) \\\\ = P(\\text{all tails}) + P(\\text{at least one head}) \\\\ = \\frac{1}{8} + \\frac{7}{8} \\\\ = \\frac{8}{8} = 1").textSize(50).background(0xFFffffff).padding(10).build());
        t3Latex_16.setLatexDrawable(JLatexMathDrawable.builder("P(\\text{exactly two heads}) = \\frac{3}{8}, \\\\ P(\\text{exactly two tails}) = \\frac{3}{8}").textSize(50).background(0xFFffffff).padding(10).build());
        t3Latex_17.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ or } B) = P(A) + P(B) \\\\ P(\\text{exactly two heads or exactly two tails}) \\\\ = P(\\text{exactly two heads}) + P(\\text{exactly two tails}) \\\\ = \\frac{3}{8} + \\frac{3}{8} \\\\ = \\frac{6}{8} = \\frac{3}{4}").textSize(50).background(0xFFffffff).padding(10).build());
        t3Latex_18.setLatexDrawable(JLatexMathDrawable.builder("P(\\text{all heads}) = \\frac{1}{8} \\text{ and} \\\\ P(\\text{all tails}) = \\frac{1}{8}").textSize(50).background(0xFFffffff).padding(10).build());
        t3Latex_19.setLatexDrawable(JLatexMathDrawable.builder("P(\\text{neither A nor B}) = 1 - [P(A) + P(B)] \\\\ P(\\text{neither all heads nor all tails}) \\\\ = 1 - [P(\\text{all heads}) + P(\\text{all tails})] \\\\ = 1 - [\\frac{1}{8} + \\frac{1}{8}] \\\\ = 1 - \\frac{2}{8} \\\\ = \\frac{3}{4}").textSize(50).background(0xFFffffff).padding(10).build());
        t3Latex_20.setLatexDrawable(JLatexMathDrawable.builder("P(\\text{exactly one head}) = \\frac{3}{8} \\text{ and} \\\\ P(\\text{exactly one tail}) = \\frac{3}{8}").textSize(50).background(0xFFffffff).padding(10).build());
        t3Latex_21.setLatexDrawable(JLatexMathDrawable.builder("P(\\text{neither A nor B}) = 1 - [P(A) + P(B)] \\\\ = 1 - [P(\\text{exactly one head}) + P(\\text{exactly one tail})] \\\\ = 1 - [\\frac{3}{8} + \\frac{3}{8}] \\\\ = 1 - \\frac{6}{8} \\\\ = \\frac{1}{4}").textSize(50).background(0xFFffffff).padding(10).build());

        String t3TextViewFormat2 = "<b><i>What is a Mutually Exclusive Events?</i></b><br><br><b>Mutually exclusive events</b> are two or more events that cannot happen at the same time. For example, if we toss a coin, either heads or tails might turn up, but not heads and tails at the same time. There is no other way you could get both results. Similarly, in a single throw of a die, we can only have one number shown at the top face. If you roll a 3 or 5 on a die, the results either be a 3 or a 5 but not both. Such events are also called disjoint events since they do not happen simultaneously.<br><br>Also, two sets are known to be <b><i>mutually exclusive</i></b> when they have no common elements. Consider the set of all even positive integers, and the set of all odd positive integers:";
        String t3TextViewFormat4 = "This is a mutually exclusive event since none of the elements of set A are in set B, and vice-versa.<br><br><b>Non-mutually exclusive events</b> are events that can happen at the same time. For example, landing an even number or a number divisible by 4 on a die. These two events have a possibility that both events can happen together. Also, two sets are <b><i>non-mutually exclusive</i></b> if they share common elements.<br><br>Consider the set A as all numbers from 10 to 20, and the set B as all multiples of 3 from 1 to 20:";
        String t3TextViewFormat5 = "Set A = {10, 11, <b>12</b>, 13, 14, <b>15</b>, 16, 17, <b>18</b>, 19, 20}<br>Set B = {3, 6, 9, <b>12</b>, <b>15</b>, <b>18</b>}";
        String t3TextViewFormat6 = "We call them <b>non-mutually exclusive</b> since they share the common elements of 12, 15, and 18.<br><br><i>Other examples of mutually exclusive events are the following:</i>";
        String t3TextViewFormat8 = "<b><i>How to calculate the probability of mutually exclusive events?</i></b><br><br>If A and B are said to be mutually exclusive events, then the probability of an event A occurring or the probability of event B occurring that is";
        String t3TextViewFormat11 = "<b>Example 1</b><br><br>What is the probability of a die showing a 2 or 5?";
        String t3TextViewFormat15 = "<b>Example 2</b><br><br>A card is drawn at random from a well-shuffled deck of 52 cards. Find the probability that the card drawn is";
        String t3TextViewFormat23 = "<b>Example 3</b><br><br>A coin is tossed and a die is rolled. What is the probability of landing on the head side of the coin and rolling a 2 on the die or landing on the tail side of the coin and rolling on a 4 on the die?";
        String t3TextViewFormat24 = "P(A) = P(head and 2) is the probability of landing on the head side of the coin and rolling a 2 on the die.<br>P(B) = P(tail and 4) is the probability of landing on the tail side of the coin and rolling a 4 on the die.<br><br>There are 12 possible outcomes when a coin is tossed and a die is rolled: {1H, <b>2H</b>, 3H, 4H, 5H, 6H, 1T, 2T, 3T, <b>4T</b>, 5T, 6T}.<br>There exists one 2H (head and 2) and one 4T (tail and 4).<br><br>Thus,";
        String t3TextViewFormat26 = "<b>Example 4</b><br><br>The probabilities of three teams, China, Philippines, and the USA, of winning the dragon boat racing are 2/7, 1/3, and 1/5, respectively. Assuming that only one team wins the race, what is the probability that either the Philippines or the USA wins?";
        String t3TextViewFormat29 = "<b>Example 5</b><br><br>A coin is tossed three times in succession. What is the probability of";
        String t3Act2DirectionFormat = "<b>Activity 2</b><br><br>A bag contains 10 white balls, 12 black balls, and 8 green balls. One ball is drawn from the bag. What is the probability of getting";
        String t3Act3DirectionFormat = "<b>Activity 3</b><br><br>A coin is tossed four times in succession. What is the probability of getting";
        String t3Act4DirectionFormat = "<b>Activity 4</b><br><br>Two dice are rolled. What is the probability of getting";
        String t3Act5DirectionFormat = "<b>Activity 5</b><br><br>If one card is drawn from an ordinary deck of cards, what is the probability of getting";

        TextView[] textViewHtml = {t3TextView2, t3TextView4, t3TextView5, t3TextView6, t3TextView8, t3TextView11, t3TextView15, t3TextView23, t3TextView24, t3TextView26, t3TextView29, t3Act2Direction, t3Act3Direction, t3Act4Direction, t3Act5Direction};
        String[] textViewFormat = {t3TextViewFormat2, t3TextViewFormat4, t3TextViewFormat5, t3TextViewFormat6, t3TextViewFormat8, t3TextViewFormat11, t3TextViewFormat15, t3TextViewFormat23, t3TextViewFormat24, t3TextViewFormat26, t3TextViewFormat29, t3Act2DirectionFormat, t3Act3DirectionFormat, t3Act4DirectionFormat, t3Act5DirectionFormat};

        for (int i = 0; i < textViewHtml.length; i++) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i], Html.FROM_HTML_MODE_COMPACT));
            } else {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i]));
            }
        }

        t3Video.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.mutually_exclusive_events);
        MediaController mediaController = new MediaController(TopicThreeActivity.this);
        mediaController.setAnchorView(t3Video);
        t3Video.setMediaController(mediaController);

        loadScore();
        t3Act1Score.setText("Score: " + scoreValue1 + "/" + t3Act1QuesLength);
        t3ActScore.setText("Score: " + scoreValue + "/" + t3ActQuesLength);

        TextView[] textViewTitle = {t3TextViewTitle1, t3TextViewTitle2, t3TextViewTitle3, t3TextViewTitle4, t3TextViewTitle5, t3TextViewTitle6};
        TextView[] textView = {t3TextView1, t3TextView2, t3TextView3, t3TextView4, t3TextView5, t3TextView6, t3TextView7, t3TextView8, t3TextView9, t3TextView10, t3TextView11, t3TextView12, t3TextView13, t3TextView14, t3TextView15, t3TextView18, t3TextView19, t3TextView23, t3TextView24, t3TextView25, t3TextView26, t3TextView27, t3TextView28, t3TextView29, t3TextView30, t3TextView31, t3TextView32, t3TextView33, t3TextView34, t3TextView35, t3TextView36, t3TextView37, t3TextView38, t3TextView39, t3TextView40, t3TextView41, t3TextView42, t3TextView43, t3TextView44, t3TextView45, t3TextView46, t3TextView47, t3Act1Score, t3ActScore, t3Act1Direction, t3ActDirection, t3Act1Question, t3ActQuestion, t3ActSolText, t3Act2Direction, t3Act3Direction, t3Act4Direction, t3Act5Direction, t3SolutionExample1, t3SolutionExample2, t3SolutionExample3, t3SolutionExample4, t3SolutionExample5};

        t3ZoomControls.setOnZoomInClickListener(new View.OnClickListener() {
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

        t3ZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
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

        t3Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //Example Solutions

        TextView[] solutions = {t3SolutionExample1, t3SolutionExample2, t3SolutionExample3, t3SolutionExample4, t3SolutionExample5};
        LinearLayout[] solLayout = {t3Solution1, t3Solution2, t3Solution3, t3Solution4, t3Solution5};

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

        t3Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuDialog();
            }
        });

        t3Act1Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activityOngoing == true) {
                    Toast.makeText(TopicThreeActivity.this, "An activity is ongoing.", Toast.LENGTH_SHORT).show();
                } else {
                    activityOngoing = true;
                    activity1Selected = true;
                    activitySelected = false;
                    t3Act1Layout.setVisibility(View.VISIBLE);
                    t3Act1Opts.setVisibility(View.VISIBLE);
                    t3Act1Submit.setVisibility(View.INVISIBLE);
                    t3Act1Start.setVisibility(View.GONE);
                    t3Act1Direction.setText("Determine if each pair of events are mutually exclusive or not. Choose Y if it is a mutually exclusive event, otherwise N if it is not.");
                    t3Act1Feedback.setImageDrawable(null);
                    Button[] buttons = {t3Act1Opt1, t3Act1Opt2};
                    for (int i = 0; i < buttons.length; i++) {
                        buttons[i].setEnabled(true);
                        buttons[i].setBackgroundTintList(null);
                        buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                        buttons[i].setTextColor(getResources().getColor(R.color.white));
                    }
                    t3Act1Submit.setText("Submit");
                    t3Act1Submit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                    currentIndex = 0;
                    score1 = 0;
                    nextQuestion = false;
                    generateT3Act1Questions();
                }
            }
        });

        t3Act1Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nextQuestion == false) {
                    nextQuestion = true;
                    t3Act1Submit.setText("Next");
                    t3Act1Submit.setBackgroundTintList(getResources().getColorStateList(R.color.black));
                    t3Act1Opt1.setEnabled(false);
                    t3Act1Opt2.setEnabled(false);
                    if (selectedAnswer.equals(answer1)) {
                        t3Act1Feedback.setImageResource(R.drawable.round_check_24);
                        score1++;
                    } else {
                        t3Act1Feedback.setImageResource(R.drawable.round_clear_24);
                    }
                }else {
                    currentIndex++;
                    if (currentIndex < t3Act1QuesLength) {
                        generateT3Act1Questions();
                        nextQuestion = false;
                        t3Act1Feedback.setImageDrawable(null);
                        t3Act1Submit.setVisibility(View.INVISIBLE);
                        t3Act1Submit.setText("Submit");
                        t3Act1Submit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                        Button[] buttons = {t3Act1Opt1, t3Act1Opt2};
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

        t3Act1Opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = "Y";
                t3Act1Submit.setVisibility(View.VISIBLE);
                t3Act1Opt1.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t3Act1Opt1.setTextColor(getResources().getColor(R.color.blue));
                t3Act1Opt2.setBackgroundTintList(null);
                t3Act1Opt2.setBackgroundResource(R.drawable.custom_selected_button);
                t3Act1Opt2.setTextColor(getResources().getColor(R.color.white));
            }
        });

        t3Act1Opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = "N";
                t3Act1Submit.setVisibility(View.VISIBLE);
                t3Act1Opt2.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t3Act1Opt2.setTextColor(getResources().getColor(R.color.blue));
                t3Act1Opt1.setBackgroundTintList(null);
                t3Act1Opt1.setBackgroundResource(R.drawable.custom_selected_button);
                t3Act1Opt1.setTextColor(getResources().getColor(R.color.white));
            }
        });

        t3ActStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activityOngoing == true) {
                    Toast.makeText(TopicThreeActivity.this, "An activity is ongoing.", Toast.LENGTH_SHORT).show();
                } else {
                    activityOngoing = true;
                    activitySelected = true;
                    activity1Selected = false;
                    t3ActLayout.setVisibility(View.VISIBLE);
                    t3ActOpts.setVisibility(View.VISIBLE);
                    t3ActAnsLayout.setVisibility(View.INVISIBLE);
                    t3ActSolText.setVisibility(View.GONE);
                    t3ActStart.setVisibility(View.GONE);
                    t3ActDirection.setText("Read and understand each question carefully and select your answer from the multiple-choice options.");
                    t3ActFeedback.setImageDrawable(null);
                    t3ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(10).build());
                    Button[] buttons = {t3ActOpt1, t3ActOpt2, t3ActOpt3, t3ActOpt4};
                    for (int i = 0; i < buttons.length; i++) {
                        buttons[i].setEnabled(true);
                        buttons[i].setBackgroundTintList(null);
                        buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                        buttons[i].setTextColor(getResources().getColor(R.color.white));
                    }
                    t3ActSubmit.setText("Submit");
                    t3ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                    currentIndex = 0;
                    score = 0;
                    nextQuestion = false;
                    generateT3ActQuestions();
                }
            }
        });

        t3ActSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nextQuestion == false) {
                    nextQuestion = true;
                    t3ActSubmit.setText("Next");
                    t3ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.black));
                    Button[] buttons = {t3ActOpt1, t3ActOpt2, t3ActOpt3, t3ActOpt4};
                    for (int i = 0; i < buttons.length; i++) {
                        buttons[i].setEnabled(false);
                    }
                    t3ActSolText.setVisibility(View.VISIBLE);
                    t3ActAns.setLatexDrawable(JLatexMathDrawable.builder(answer).textSize(50).background(0xFFb0d6f5).padding(10).build());
                    if (selectedAnswer.equals(answer)) {
                        t3ActFeedback.setImageResource(R.drawable.round_check_24);
                        score++;
                    } else {
                        t3ActFeedback.setImageResource(R.drawable.round_clear_24);
                    }
                }else {
                    currentIndex++;
                    if (currentIndex < t3ActQuesLength) {
                        generateT3ActQuestions();
                        nextQuestion = false;
                        t3ActAnsLayout.setVisibility(View.INVISIBLE);
                        t3ActSolText.setVisibility(View.GONE);
                        t3ActSubmit.setText("Submit");
                        t3ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                        t3ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(10).build());
                        t3ActFeedback.setImageDrawable(null);
                        Button[] buttons = {t3ActOpt1, t3ActOpt2, t3ActOpt3, t3ActOpt4};
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

        t3ActOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t3ActOpt1.getText().toString();
                t3ActAnsLayout.setVisibility(View.VISIBLE);
                t3ActSolText.setVisibility(View.GONE);
                t3ActOpt1.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t3ActOpt1.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t3ActOpt4, t3ActOpt2, t3ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t3ActOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t3ActOpt2.getText().toString();
                t3ActAnsLayout.setVisibility(View.VISIBLE);
                t3ActSolText.setVisibility(View.GONE);
                t3ActOpt2.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t3ActOpt2.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t3ActOpt1, t3ActOpt4, t3ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t3ActOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t3ActOpt3.getText().toString();
                t3ActAnsLayout.setVisibility(View.VISIBLE);
                t3ActSolText.setVisibility(View.GONE);
                t3ActOpt3.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t3ActOpt3.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t3ActOpt1, t3ActOpt2, t3ActOpt4};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t3ActOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t3ActOpt4.getText().toString();
                t3ActAnsLayout.setVisibility(View.VISIBLE);
                t3ActSolText.setVisibility(View.GONE);
                t3ActOpt4.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t3ActOpt4.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t3ActOpt1, t3ActOpt2, t3ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

    }

    private void generateT3Act1Questions() {
        t3Act1Question.setText(activityQuestions.getT3Act1Question(currentIndex));
        answer1 = activityQuestions.getT3Act1Answer(currentIndex);
    }

    private void generateT3ActQuestions() {
        t3ActQuestion.setText(activityQuestions.getT3ActQuestions(currentIndex));
        t3ActOpt1.setText(activityQuestions.getT3ActChoice1(currentIndex));
        t3ActOpt2.setText(activityQuestions.getT3ActChoice2(currentIndex));
        t3ActOpt3.setText(activityQuestions.getT3ActChoice3(currentIndex));
        t3ActOpt4.setText(activityQuestions.getT3ActChoice4(currentIndex));
        answer = activityQuestions.getT3ActAnswers(currentIndex);
    }

    private void showScore() {
        if (activity1Selected == true) {
            t3Act1Layout.setVisibility(View.GONE);
            t3Act1Opts.setVisibility(View.GONE);
            t3Act1Submit.setVisibility(View.GONE);
            t3Act1Start.setVisibility(View.VISIBLE);
            t3Act1Start.setText("Try Again");
            activityOngoing = false;
            String actDirectionFormat = "Activity 1 Complete!<br>Your score is <b>" + score1 + "</b> out of " + t3Act1QuesLength + ".";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                t3Act1Direction.setText(Html.fromHtml(actDirectionFormat, Html.FROM_HTML_MODE_COMPACT));
            } else {
                t3Act1Direction.setText(Html.fromHtml(actDirectionFormat));
            }
            t3Act1Score.setText("Score: " + score1 + "/" + t3Act1QuesLength);
            storeScore1(score1);
        } else if (activitySelected == true) {
            t3ActLayout.setVisibility(View.GONE);
            t3ActOpts.setVisibility(View.GONE);
            t3ActAnsLayout.setVisibility(View.GONE);
            t3ActStart.setVisibility(View.VISIBLE);
            t3ActStart.setText("Try Again");
            activityOngoing = false;
            String actDirectionFormat = "Assessment Complete!<br>Your score is <b>" + score + "</b> out of " + t3ActQuesLength + ".";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                t3ActDirection.setText(Html.fromHtml(actDirectionFormat, Html.FROM_HTML_MODE_COMPACT));
            } else {
                t3ActDirection.setText(Html.fromHtml(actDirectionFormat));
            }
            t3ActScore.setText("Score: " + score + "/" + t3ActQuesLength);
            storeScore3(score);
        }
    }

    private void storeScore1(int score1) {
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_SCORE1, score1);
        editor.apply();
    }

    private void storeScore3(int score) {
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_SCORE, score);
        editor.apply();
    }


    private void loadScore() {
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        scoreValue1 = prefs.getInt(KEY_SCORE1, 0);
        scoreValue = prefs.getInt(KEY_SCORE, 0);
    }

    private void menuDialog() {
        LayoutInflater inflater = LayoutInflater.from(TopicThreeActivity.this);
        View view =  inflater.inflate(R.layout.custom_menu, null);

        TextView objectives = view.findViewById(R.id.objectives);
        TextView introduction = view.findViewById(R.id.introduction);
        TextView examples = view.findViewById(R.id.examples);
        TextView activities =view.findViewById(R.id.activities);
        TextView assessment = view.findViewById(R.id.assessment);

        TextView menu[] = {objectives, introduction, examples, activities, assessment};
        TextView title[] = {t3TextViewTitle1, t3TextViewTitle2, t3TextViewTitle3, t3TextViewTitle4, t3TextViewTitle5};
        String format[] = {"<u>Objectives</u>", "<u>Introduction to lesson</u>", "<u>Illustrative Examples</u>", "<u>Activities</u>", "<u>Assessment</u>"};

        AlertDialog.Builder builder = new AlertDialog.Builder(TopicThreeActivity.this);
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
                    t3ScrollView.smoothScrollTo(0, title[finalI].getTop());
                    dialog.dismiss();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        endTime3 = System.currentTimeMillis();
        long timeDiff = endTime3 - startTime3;
        int newTime = (int) (timeDiff / 1000);

        Boolean checkId = dbHandler.checkTopicsId(590);
        if (checkId == true) {
            Map<String, String> studyTime = dbHandler.getTopicsId(590);
            if (!studyTime.isEmpty()) {
                int prevTime = Integer.parseInt(studyTime.get(TIME_IN_SEC));
                int totalTime = newTime + prevTime;
                dbHandler.updateTime(new StudyModelClass(590, totalTime));
            }
        } else {
            dbHandler.storeStudyTime(new StudyModelClass(590, newTime));
        }

        super.onBackPressed();
    }
}