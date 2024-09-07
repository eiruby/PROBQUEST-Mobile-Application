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

public class TopicFiveActivity extends AppCompatActivity {
    private TextView t5TextViewTitle1, t5TextViewTitle2, t5TextViewTitle3, t5TextViewTitle4, t5TextViewTitle5, t5TextViewTitle6, t5TextView1, t5TextView2, t5TextView3, t5TextView4, t5TextView5, t5TextView6, t5TextView7, t5TextView8, t5TextView9, t5TextView10, t5TextView11, t5TextView12, t5TextView13, t5TextView14, t5TextView15, t5TextView16, t5TextView17, t5TextView18, t5TextView19, t5TextView20, t5TextView21, t5TextView22, t5TextView23, t5TextView24, t5TextView25, t5TextView26, t5TextView27, t5TextView28, t5TextView29, t5TextView30, t5TextView31, t5TextView32, t5TextView33, t5TextView34, t5TextView35, t5TextView36, t5TextView37, t5TextView38, t5TextView39, t5TextView40, t5TextView41, t5TextView42, t5TextView43, t5TextView44, t5TextView45, t5TextView46, t5TextView47, t5TextView48, t5TextView49, t5TextView50, t5TextView51, t5TextView52, t5TextView53, t5TextView54, t5TextView55, t5TextView56, t5TextView57, t5TextView58, t5TextView59, t5TextView60, t5TextView61, t5TextView62, t5TextView63, t5TextView64, t5TextView65, t5TextView66, t5TextView67, t5TextView68, t5TextView69, t5TextView70, t5TextView71, t5TextView72, t5TextView73, t5TextView74, t5TextView75, t5TextView76, t5TextView77, t5ActScore, t5ActSolText, t5ActDirection, t5ActQuestion, t5Act1Direction, t5Act1Problems, t5Act2Direction, t5Act2Problems, t5Act3Direction, t5Act3Problems, t5Act4Direction, t5Act4Problems, t5Act5Direction, t5Act5Problems, t5SolutionExample1, t5SolutionExample2, t5SolutionExample3, t5SolutionExample4, t5SolutionExample5;
    private JLatexMathView t5Latex_1, t5Latex_2, t5Latex_3, t5Latex_4, t5Latex_5, t5Latex_6, t5Latex_7, t5Latex_8, t5Latex_9, t5Latex_10, t5Latex_11, t5Latex_12, t5Latex_13, t5Latex_14, t5Latex_15, t5Latex_16, t5Latex_17, t5Latex_18, t5Latex_19, t5Latex_20, t5Latex_21, t5ActAns;
    private ImageView t5ActFeedback, t5ActImg, t5Back, t5Menu;
    private Button t5ActStart, t5ActOpt1, t5ActOpt2, t5ActOpt3, t5ActOpt4, t5ActSubmit;
    private LinearLayout t5ActLayout, t5ActOpts, t5ActAnsLayout, t5Solution1, t5Solution2, t5Solution3, t5Solution4, t5Solution5;
    private VideoView t5Video;
    private ZoomControls t5ZoomControls;
    private ScrollView t5ScrollView;
    private int textSize = 16, currentIndex, score, actLevel;
    private String selectedAnswer, answer, solution;
    private ActivityQuestions activityQuestions = new ActivityQuestions();
    private int t5ActQuesLength = activityQuestions.t5ActQuestions.length;
    private boolean nextQuestion = false, hideSolution = true;
    private static final String PREFS_FILE_NAME = "ActivityScore5";
    private static final String KEY_SCORE = "score";
    private long startTime5, endTime5, scoreValue;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_five);

        dbHandler = new DBHandler(this);

        t5Back = findViewById(R.id.t5Back);
        t5TextViewTitle1 = findViewById(R.id.t5TextViewTitle1);
        t5TextViewTitle2 = findViewById(R.id.t5TextViewTitle2);
        t5TextViewTitle3 = findViewById(R.id.t5TextViewTitle3);
        t5TextViewTitle4 = findViewById(R.id.t5TextViewTitle4);
        t5TextViewTitle5 = findViewById(R.id.t5TextViewTitle5);
        t5TextViewTitle6 = findViewById(R.id.t5TextViewTitle6);
        t5TextView1 = findViewById(R.id.t5TextView1);
        t5TextView2 = findViewById(R.id.t5TextView2);
        t5TextView3 = findViewById(R.id.t5TextView3);
        t5TextView4 = findViewById(R.id.t5TextView4);
        t5TextView5 = findViewById(R.id.t5TextView5);
        t5TextView6 = findViewById(R.id.t5TextView6);
        t5TextView7 = findViewById(R.id.t5TextView7);
        t5TextView8 = findViewById(R.id.t5TextView8);
        t5TextView9 = findViewById(R.id.t5TextView9);
        t5TextView10 = findViewById(R.id.t5TextView10);
        t5TextView11 = findViewById(R.id.t5TextView11);
        t5TextView12 = findViewById(R.id.t5TextView12);
        t5TextView13 = findViewById(R.id.t5TextView13);
        t5TextView14 = findViewById(R.id.t5TextView14);
        t5TextView15 = findViewById(R.id.t5TextView15);
        t5TextView16 = findViewById(R.id.t5TextView16);
        t5TextView17 = findViewById(R.id.t5TextView17);
        t5TextView18 = findViewById(R.id.t5TextView18);
        t5TextView19 = findViewById(R.id.t5TextView19);
        t5TextView20 = findViewById(R.id.t5TextView20);
        t5TextView21 = findViewById(R.id.t5TextView21);
        t5TextView22 = findViewById(R.id.t5TextView22);
        t5TextView23 = findViewById(R.id.t5TextView23);
        t5TextView24 = findViewById(R.id.t5TextView24);
        t5TextView25 = findViewById(R.id.t5TextView25);
        t5TextView26 = findViewById(R.id.t5TextView26);
        t5TextView27 = findViewById(R.id.t5TextView27);
        t5TextView28 = findViewById(R.id.t5TextView28);
        t5TextView29 = findViewById(R.id.t5TextView29);
        t5TextView30 = findViewById(R.id.t5TextView30);
        t5TextView31 = findViewById(R.id.t5TextView31);
        t5TextView32 = findViewById(R.id.t5TextView32);
        t5TextView33 = findViewById(R.id.t5TextView33);
        t5TextView34 = findViewById(R.id.t5TextView34);
        t5TextView35 = findViewById(R.id.t5TextView35);
        t5TextView36 = findViewById(R.id.t5TextView36);
        t5TextView37 = findViewById(R.id.t5TextView37);
        t5TextView38 = findViewById(R.id.t5TextView38);
        t5TextView39 = findViewById(R.id.t5TextView39);
        t5TextView40 = findViewById(R.id.t5TextView40);
        t5TextView41 = findViewById(R.id.t5TextView41);
        t5TextView42 = findViewById(R.id.t5TextView42);
        t5TextView43 = findViewById(R.id.t5TextView43);
        t5TextView44 = findViewById(R.id.t5TextView44);
        t5TextView45 = findViewById(R.id.t5TextView45);
        t5TextView46 = findViewById(R.id.t5TextView46);
        t5TextView47 = findViewById(R.id.t5TextView47);
        t5TextView48 = findViewById(R.id.t5TextView48);
        t5TextView49 = findViewById(R.id.t5TextView49);
        t5TextView50 = findViewById(R.id.t5TextView50);
        t5TextView51 = findViewById(R.id.t5TextView51);
        t5TextView52 = findViewById(R.id.t5TextView52);
        t5TextView53 = findViewById(R.id.t5TextView53);
        t5TextView54 = findViewById(R.id.t5TextView54);
        t5TextView55 = findViewById(R.id.t5TextView55);
        t5TextView56 = findViewById(R.id.t5TextView56);
        t5TextView57 = findViewById(R.id.t5TextView57);
        t5TextView58 = findViewById(R.id.t5TextView58);
        t5TextView59 = findViewById(R.id.t5TextView59);
        t5TextView60 = findViewById(R.id.t5TextView60);
        t5TextView61 = findViewById(R.id.t5TextView61);
        t5TextView62 = findViewById(R.id.t5TextView62);
        t5TextView63 = findViewById(R.id.t5TextView63);
        t5TextView64 = findViewById(R.id.t5TextView64);
        t5TextView65 = findViewById(R.id.t5TextView65);
        t5TextView66 = findViewById(R.id.t5TextView66);
        t5TextView67 = findViewById(R.id.t5TextView67);
        t5TextView68 = findViewById(R.id.t5TextView68);
        t5TextView69 = findViewById(R.id.t5TextView69);
        t5TextView70 = findViewById(R.id.t5TextView70);
        t5TextView71 = findViewById(R.id.t5TextView71);
        t5TextView72 = findViewById(R.id.t5TextView72);
        t5TextView73 = findViewById(R.id.t5TextView73);
        t5TextView74 = findViewById(R.id.t5TextView74);
        t5TextView75 = findViewById(R.id.t5TextView75);
        t5TextView76 = findViewById(R.id.t5TextView76);
        t5TextView77 = findViewById(R.id.t5TextView77);
        t5SolutionExample1 = findViewById(R.id.t5SolutionExample1);
        t5SolutionExample2 = findViewById(R.id.t5SolutionExample2);
        t5SolutionExample3 = findViewById(R.id.t5SolutionExample3);
        t5SolutionExample4 = findViewById(R.id.t5SolutionExample4);
        t5SolutionExample5 = findViewById(R.id.t5SolutionExample5);
        t5Solution1 = findViewById(R.id.t5Solution1);
        t5Solution2 = findViewById(R.id.t5Solution2);
        t5Solution3 = findViewById(R.id.t5Solution3);
        t5Solution4 = findViewById(R.id.t5Solution4);
        t5Solution5 = findViewById(R.id.t5Solution5);
        t5Latex_1 = findViewById(R.id.t5Latex_1);
        t5Latex_2 = findViewById(R.id.t5Latex_2);
        t5Latex_3 = findViewById(R.id.t5Latex_3);
        t5Latex_4 = findViewById(R.id.t5Latex_4);
        t5Latex_5 = findViewById(R.id.t5Latex_5);
        t5Latex_6 = findViewById(R.id.t5Latex_6);
        t5Latex_7 = findViewById(R.id.t5Latex_7);
        t5Latex_8 = findViewById(R.id.t5Latex_8);
        t5Latex_9 = findViewById(R.id.t5Latex_9);
        t5Latex_10 = findViewById(R.id.t5Latex_10);
        t5Latex_11 = findViewById(R.id.t5Latex_11);
        t5Latex_12 = findViewById(R.id.t5Latex_12);
        t5Latex_13 = findViewById(R.id.t5Latex_13);
        t5Latex_14 = findViewById(R.id.t5Latex_14);
        t5Latex_15 = findViewById(R.id.t5Latex_15);
        t5Latex_16 = findViewById(R.id.t5Latex_16);
        t5Latex_17 = findViewById(R.id.t5Latex_17);
        t5Latex_18 = findViewById(R.id.t5Latex_18);
        t5Latex_19 = findViewById(R.id.t5Latex_19);
        t5Latex_20 = findViewById(R.id.t5Latex_20);
        t5Latex_21 = findViewById(R.id.t5Latex_21);
        t5Video = findViewById(R.id.t5Video);
        t5ZoomControls = findViewById(R.id.t5ZoomControls);
        t5Menu = findViewById(R.id.t5Menu);
        t5ScrollView = findViewById(R.id.t5ScrollView);
        t5ActScore = findViewById(R.id.t5ActScore);
        t5ActDirection = findViewById(R.id.t5ActDirection);
        t5ActQuestion = findViewById(R.id.t5ActQuestion);
        t5ActAns = findViewById(R.id.t5ActAns);
        t5ActSolText = findViewById(R.id.t5ActSolText);
        t5ActFeedback = findViewById(R.id.t5ActFeedback);
        t5ActStart = findViewById(R.id.t5ActStart);
        t5ActImg = findViewById(R.id.t5ActImg);
        t5ActOpt1 = findViewById(R.id.t5ActOpt1);
        t5ActOpt2 = findViewById(R.id.t5ActOpt2);
        t5ActOpt3 = findViewById(R.id.t5ActOpt3);
        t5ActOpt4 = findViewById(R.id.t5ActOpt4);
        t5ActSubmit = findViewById(R.id.t5ActSubmit);
        t5ActLayout = findViewById(R.id.t5ActLayout);
        t5ActOpts = findViewById(R.id.t5ActOpts);
        t5ActAnsLayout = findViewById(R.id.t5ActAnsLayout);
        t5Act1Direction = findViewById(R.id.t5Act1Direction);
        t5Act2Direction = findViewById(R.id.t5Act2Direction);
        t5Act3Direction = findViewById(R.id.t5Act3Direction);
        t5Act4Direction = findViewById(R.id.t5Act4Direction);
        t5Act5Direction = findViewById(R.id.t5Act5Direction);
        t5Act1Problems = findViewById(R.id.t5Act1Problems);
        t5Act2Problems = findViewById(R.id.t5Act2Problems);
        t5Act3Problems = findViewById(R.id.t5Act3Problems);
        t5Act4Problems = findViewById(R.id.t5Act4Problems);
        t5Act5Problems = findViewById(R.id.t5Act5Problems);

        startTime5 = System.currentTimeMillis();

        t5Latex_1.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(\\text{3 and odd number}) = P(3) \\times P(\\text{odd number}) \\\\ = \\frac{1}{6} \\times \\frac{1}{2} \\\\ = \\frac{1}{12}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_2.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(\\text{even number and prime number}) \\\\ = P(\\text{even}) \\times P(\\text{prime}) \\\\ = \\frac{1}{2} \\times \\frac{1}{2} \\\\ = \\frac{1}{4}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_3.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(5\\text{ and }5) = P(5) \\times P(5) \\\\ = \\frac{1}{6} \\times \\frac{1}{6} \\\\ = \\frac{1}{36}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_4.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(\\text{factor of 4 and multiple of 2}) \\\\ = P(\\text{factor of 4}) \\times P(\\text{multiple of 2}) \\\\ = \\frac{1}{2} \\times \\frac{1}{2} \\\\ = \\frac{1}{4}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_5.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(\\text{composite number and number less than 3}) \\\\ = P(\\text{composite number}) \\times P(\\text{number less than 3}) \\\\ = \\frac{1}{3} \\times \\frac{1}{3} \\\\ = \\frac{1}{9}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_6.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(J\\text{ and }R) = P(J) \\times P(R) \\\\ = \\frac{1}{5} \\times \\frac{1}{6} \\\\ = \\frac{1}{30}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_7.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(L\\text{ and }L) = P(L) \\times P(L) \\\\ = \\frac{1}{5} \\times \\frac{1}{6} \\\\ = \\frac{1}{30}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_8.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(\\text{vowel and vowel}) = P(\\text{vowel}) \\times P(\\text{vowel}) \\\\ = \\frac{3}{5} \\times \\frac{1}{3} \\\\ = \\frac{1}{5}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_9.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(\\text{jack and ace}) = P(\\text{jack}) \\times P(\\text{ace}) \\\\ = \\frac{1}{13} \\times \\frac{1}{13} \\\\ = \\frac{1}{169}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_10.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(\\text{diamond and red king}) = P(\\text{diamond}) \\times P(\\text{red king}) \\\\ = \\frac{1}{4} \\times \\frac{1}{26} \\\\ = \\frac{1}{104}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_11.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(\\text{black card and a queen}) \\\\ = P(\\text{black card}) \\times P(\\text{queen}) \\\\ = \\frac{1}{2} \\times \\frac{1}{13} \\\\ = \\frac{1}{26}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_12.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(\\text{face card and a number card}) \\\\ = P(\\text{face card}) \\times P(\\text{number card}) \\\\ = \\frac{3}{14} \\times \\frac{10}{13} \\\\ = \\frac{15}{91}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_13.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(\\text{king of hearts and a club card}) \\\\ = P(\\text{king of hearts}) \\times P(\\text{club}) \\\\ = \\frac{1}{52} \\times \\frac{1}{4} \\\\ = \\frac{1}{208}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_14.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(4\\text{ and a head}) = P(4) \\times P(\\text{head}) \\\\ = \\frac{1}{6} \\times \\frac{1}{2} \\\\ = \\frac{1}{12}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_15.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(\\text{odd number and a head}) = P(\\text{odd number}) \\times P(\\text{head}) \\\\ = \\frac{1}{2} \\times \\frac{1}{2} \\\\ = \\frac{1}{4}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_16.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(\\text{even number and a tail}) = P(\\text{odd number}) \\times P(\\text{tail}) \\\\ = \\frac{1}{2} \\times \\frac{1}{2} \\\\ = \\frac{1}{4}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_17.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(\\text{prime number and a head}) = P(\\text{prime number}) \\times P(\\text{head}) \\\\ = \\frac{1}{2} \\times \\frac{1}{2} \\\\ = \\frac{1}{4}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_18.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(\\text{factor of 6 and a tail}) = P(\\text{factor of 6}) \\times P(\\text{tail}) \\\\ = \\frac{2}{3} \\times \\frac{1}{2} \\\\ = \\frac{1}{3}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_19.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B \\text{ and } C) = P(A) \\times P(B) \\times P(C) \\\\ P(\\text{red ball and red ball and red ball}) \\\\ = P(\\text{red ball}) \\times P(\\text{red ball}) \\times P(\\text{red ball}) \\\\ = \\frac{5}{8} \\times \\frac{5}{8} \\times \\frac{5}{8} \\\\ = \\frac{125}{512}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_20.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(\\text{yellow ball and yellow ball}) \\\\ = P(\\text{yelllow ball}) \\times P(\\text{yellow ball}) \\\\ = \\frac{3}{8} \\times \\frac{3}{8} \\\\ = \\frac{9}{64}").textSize(50).background(0xFFffffff).padding(10).build());
        t5Latex_21.setLatexDrawable(JLatexMathDrawable.builder("P(A \\text{ and } B) = P(A) \\times P(B) \\\\ P(\\text{red ball and yellow ball}) \\\\ = P(\\text{red ball}) \\times P(\\text{yellow ball}) \\\\ = \\frac{5}{8} \\times \\frac{3}{8} \\\\ = \\frac{15}{64}").textSize(50).background(0xFFffffff).padding(10).build());

        String t5TextViewFormat2 = "<b><i>What are Independent Events in Probability?</i></b><br><br>Events are <b>independent</b> if the outcome of one event does not affect the outcome of another. For example, if you throw a die and a coin, the number on the die does not affect the result you get on the coin. In the same manner, the outcome in getting the head or tail of the coin does not affect the result you get on the die. Other examples are picking a card from a deck and flipping a fair coin, a fair die rolled two times, and others.<br><br><i>Some other examples of independent events are:</i>";
        String t5TextViewFormat4 = "Observe that an independent event usually uses the conjunction word “AND” to connect the two events. The use of the word AND is not observed in the last example as this event occurs one after the other.<br><br><b><i>How to calculate the probability of independent events?</i></b><br><br>If A and B are independent events, then the probability of A happening AND the probability of B happening is P(A) × P(B).";
        String t5TextViewFormat5 = "<b>Example 1</b><br><br>Two dice are rolled one after the other. What is the probability of getting";
        String t5TextViewFormat7 = "(a) Let A be the event that the first die rolled a 3.<br>Let B be the event that the second die comes up with an odd number.";
        String t5TextViewFormat22 = "<b>Example 2</b><br><br>Two sets of cards with a letter on each card as follows are placed into separate bags. Sara randomly picked one card from each bag. What is the probability that";
        String t5TextViewFormat24 = "(a) Let A be the event that the letter picked in bag 1 is J.<br>Let B be the event that the letter picked in bag 2 is R.";
        String t5TextViewFormat33 = "<b>Example 3</b><br><br>A card is chosen at random from a deck of 52 cards. It is then replaced and a second card is chosen. What is the probability of choosing";
        String t5TextViewFormat35 = "(a) Let A be the event that the card picked is a jack<br>Let B be the event that the card picked is an ace";
        String t5TextViewFormat50 = "<b>Example 4</b><br><br>A die and a coin are tossed. What is the probability of getting";
        String t5TextViewFormat52 = "(a) Let A be the event that the die comes up 4<br>Let B be the event that the coin lands head";
        String t5TextViewFormat67 = "<b>Example 5</b><br><br>A jar contains 5 red balls and 3 yellow balls. A ball is drawn from the jar and returned before the next draw.";
        String t5TextViewFormat69 = "(a) Let A be the event that the first drawn ball is a red ball.<br>Let B be the event that the second drawn ball is a red ball.<br>Let C be the event that the third drawn ball is a red ball.";
        String t5Act1DirectionFormat = "<b>Activity 1</b><br><br>A bag contains 4 red marbles and 2 blue marbles. Mikee draws a marble and then returns it to the bag. She draws a second marble. What is the probability that";
        String t5Act2DirectionFormat = "<b>Activity 2</b><br><br>A die and a coin are tossed. What is the probability of getting";
        String t5Act3DirectionFormat = "<b>Activity 3</b><br><br>A die is rolled twice. What is the probability of getting";
        String t5Act4DirectionFormat = "<b>Activity 4</b><br><br>A card is drawn from a deck of cards. Then the card is replaced, the deck is reshuffled, and a second card is drawn. What is the probability of getting";
        String t5Act5DirectionFormat = "<b>Activity 5</b><br><br>A die has 1, 2, 3, 4, 5, and 6 on its faces. A cube has A, B, C, D, E, and F on its faces. When the die and cube are rolled, what is the probability of getting";

        TextView[] textViewHtml = {t5TextView2, t5TextView4, t5TextView5, t5TextView7, t5TextView22, t5TextView24, t5TextView33, t5TextView35, t5TextView50, t5TextView52, t5TextView67, t5TextView69, t5Act1Direction, t5Act2Direction, t5Act3Direction, t5Act4Direction, t5Act5Direction};
        String[] textViewFormat = {t5TextViewFormat2, t5TextViewFormat4, t5TextViewFormat5, t5TextViewFormat7, t5TextViewFormat22, t5TextViewFormat24, t5TextViewFormat33, t5TextViewFormat35, t5TextViewFormat50, t5TextViewFormat52, t5TextViewFormat67, t5TextViewFormat69, t5Act1DirectionFormat, t5Act2DirectionFormat, t5Act3DirectionFormat, t5Act4DirectionFormat, t5Act5DirectionFormat};

        for (int i = 0; i < textViewHtml.length; i++) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i], Html.FROM_HTML_MODE_COMPACT));
            } else {
                textViewHtml[i].setText(Html.fromHtml(textViewFormat[i]));
            }
        }

        loadScore();
        t5ActScore.setText("Score: " + scoreValue + "/" + t5ActQuesLength);

        t5Video.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.dependent_independent_events);
        MediaController mediaController = new MediaController(TopicFiveActivity.this);
        mediaController.setAnchorView(t5Video);
        t5Video.setMediaController(mediaController);

        TextView[] textViewTitle = {t5TextViewTitle1, t5TextViewTitle2, t5TextViewTitle3, t5TextViewTitle4, t5TextViewTitle5, t5TextViewTitle6};
        TextView[] textView = {t5TextViewTitle1, t5TextViewTitle2, t5TextViewTitle3, t5TextViewTitle4, t5TextViewTitle5, t5TextViewTitle6, t5TextView1, t5TextView2, t5TextView3, t5TextView4, t5TextView5, t5TextView6, t5TextView7, t5TextView8, t5TextView9, t5TextView10, t5TextView11, t5TextView12, t5TextView13, t5TextView14, t5TextView15, t5TextView16, t5TextView17, t5TextView18, t5TextView19, t5TextView20, t5TextView21, t5TextView22, t5TextView23, t5TextView24, t5TextView25, t5TextView26, t5TextView27, t5TextView28, t5TextView29, t5TextView30, t5TextView31, t5TextView32, t5TextView33, t5TextView34, t5TextView35, t5TextView36, t5TextView37, t5TextView38, t5TextView39, t5TextView40, t5TextView41, t5TextView42, t5TextView43, t5TextView44, t5TextView45, t5TextView46, t5TextView47, t5TextView48, t5TextView49, t5TextView50, t5TextView51, t5TextView52, t5TextView53, t5TextView54, t5TextView55, t5TextView56, t5TextView57, t5TextView58, t5TextView59, t5TextView60, t5TextView61, t5TextView62, t5TextView63, t5TextView64, t5TextView65, t5TextView66, t5TextView67, t5TextView68, t5TextView69, t5TextView70, t5TextView71, t5TextView72, t5TextView73, t5TextView74, t5TextView75, t5TextView76, t5TextView77, t5ActScore, t5ActSolText, t5ActDirection, t5ActQuestion, t5Act1Direction, t5Act1Problems, t5Act2Direction, t5Act2Problems, t5Act3Direction, t5Act3Problems, t5Act4Direction, t5Act4Problems, t5Act5Direction, t5Act5Problems, t5SolutionExample1, t5SolutionExample2, t5SolutionExample3, t5SolutionExample4, t5SolutionExample5};

        t5ZoomControls.setOnZoomInClickListener(new View.OnClickListener() {
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

        t5ZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
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

        t5Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //Example Solutions

        TextView[] solutions = {t5SolutionExample1, t5SolutionExample2, t5SolutionExample3, t5SolutionExample4, t5SolutionExample5};
        LinearLayout[] solLayout = {t5Solution1, t5Solution2, t5Solution3, t5Solution4, t5Solution5};

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

        t5Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuDialog();
            }
        });

        t5ActStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t5ActLayout.setVisibility(View.VISIBLE);
                t5ActImg.setVisibility(View.GONE);
                t5ActOpts.setVisibility(View.VISIBLE);
                t5ActAnsLayout.setVisibility(View.INVISIBLE);
                t5ActSolText.setVisibility(View.GONE);
                t5ActStart.setVisibility(View.GONE);
                t5ActDirection.setText("Read and understand each question carefully and select your answer from the multiple-choice options.");
                t5ActFeedback.setImageDrawable(null);
                t5ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(10).build());
                Button[] buttons = {t5ActOpt1, t5ActOpt2, t5ActOpt3, t5ActOpt4};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
                t5ActSubmit.setText("Submit");
                t5ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                currentIndex = 0;
                score = 0;
                nextQuestion = false;
                generateT5ActQuestions();
            }
        });

        t5ActSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nextQuestion == false) {
                    nextQuestion = true;
                    t5ActSubmit.setText("Next");
                    t5ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.black));
                    Button[] buttons = {t5ActOpt1, t5ActOpt2, t5ActOpt3, t5ActOpt4};
                    for (int i = 0; i < buttons.length; i++) {
                        buttons[i].setEnabled(false);
                    }
                    t5ActSolText.setVisibility(View.VISIBLE);
                    t5ActAns.setLatexDrawable(JLatexMathDrawable.builder(solution).textSize(50).background(0xFFb0d6f5).padding(10).build());
                    if (selectedAnswer.equals(answer)) {
                        t5ActFeedback.setImageResource(R.drawable.round_check_24);
                        score++;
                    } else {
                        t5ActFeedback.setImageResource(R.drawable.round_clear_24);
                    }
                }else {
                    currentIndex++;
                    if (currentIndex < t5ActQuesLength) {
                        generateT5ActQuestions();
                        nextQuestion = false;
                        t5ActAnsLayout.setVisibility(View.INVISIBLE);
                        t5ActSolText.setVisibility(View.GONE);
                        t5ActSubmit.setText("Submit");
                        t5ActSubmit.setBackgroundTintList(getResources().getColorStateList(R.color.sea_green));
                        t5ActAns.setLatexDrawable(JLatexMathDrawable.builder("").textSize(50).background(0xFFb0d6f5).padding(10).build());
                        t5ActFeedback.setImageDrawable(null);
                        Button[] buttons = {t5ActOpt1, t5ActOpt2, t5ActOpt3, t5ActOpt4};
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

        t5ActOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t5ActOpt1.getText().toString();
                t5ActAnsLayout.setVisibility(View.VISIBLE);
                t5ActSolText.setVisibility(View.GONE);
                t5ActOpt1.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t5ActOpt1.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t5ActOpt4, t5ActOpt2, t5ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t5ActOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t5ActOpt2.getText().toString();
                t5ActAnsLayout.setVisibility(View.VISIBLE);
                t5ActSolText.setVisibility(View.GONE);
                t5ActOpt2.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t5ActOpt2.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t5ActOpt1, t5ActOpt4, t5ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t5ActOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t5ActOpt3.getText().toString();
                t5ActAnsLayout.setVisibility(View.VISIBLE);
                t5ActSolText.setVisibility(View.GONE);
                t5ActOpt3.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t5ActOpt3.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t5ActOpt1, t5ActOpt2, t5ActOpt4};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        t5ActOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = t5ActOpt4.getText().toString();
                t5ActAnsLayout.setVisibility(View.VISIBLE);
                t5ActSolText.setVisibility(View.GONE);
                t5ActOpt4.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                t5ActOpt4.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {t5ActOpt1, t5ActOpt2, t5ActOpt3};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_selected_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

    }

    private void generateT5ActQuestions() {
        t5ActQuestion.setText(activityQuestions.getT5ActQuestions(currentIndex));
        t5ActOpt1.setText(activityQuestions.getT5ActChoice1(currentIndex));
        t5ActOpt2.setText(activityQuestions.getT5ActChoice2(currentIndex));
        t5ActOpt3.setText(activityQuestions.getT5ActChoice3(currentIndex));
        t5ActOpt4.setText(activityQuestions.getT5ActChoice4(currentIndex));
        answer = activityQuestions.getT5ActAnswers(currentIndex);
        solution = activityQuestions.getT5ActSolutions(currentIndex);
        if (currentIndex == 9) {
            t5ActImg.setVisibility(View.VISIBLE);
        } else {
            t5ActImg.setVisibility(View.GONE);
        }
    }

    private void showScore() {
        t5ActLayout.setVisibility(View.GONE);
        t5ActOpts.setVisibility(View.GONE);
        t5ActAnsLayout.setVisibility(View.GONE);
        t5ActImg.setVisibility(View.GONE);
        t5ActStart.setVisibility(View.VISIBLE);
        t5ActStart.setText("Try Again");
        String actDirectionFormat = "Assessment Complete!<br>Your score is <b>" + score + "</b> out of " + t5ActQuesLength + ".";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            t5ActDirection.setText(Html.fromHtml(actDirectionFormat, Html.FROM_HTML_MODE_COMPACT));
        } else {
            t5ActDirection.setText(Html.fromHtml(actDirectionFormat));
        }
        t5ActScore.setText("Score: " + score + "/" + t5ActQuesLength);
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
        LayoutInflater inflater = LayoutInflater.from(TopicFiveActivity.this);
        View view =  inflater.inflate(R.layout.custom_menu, null);

        TextView objectives = view.findViewById(R.id.objectives);
        TextView introduction = view.findViewById(R.id.introduction);
        TextView examples = view.findViewById(R.id.examples);
        TextView activities =view.findViewById(R.id.activities);
        TextView assessment = view.findViewById(R.id.assessment);

        TextView menu[] = {objectives, introduction, examples, activities, assessment};
        TextView title[] = {t5TextViewTitle1, t5TextViewTitle2, t5TextViewTitle3, t5TextViewTitle4, t5TextViewTitle5};
        String format[] = {"<u>Objectives</u>", "<u>Introduction to lesson</u>", "<u>Illustrative Examples</u>", "<u>Activities</u>", "<u>Assessment</u>"};

        AlertDialog.Builder builder = new AlertDialog.Builder(TopicFiveActivity.this);
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
                    t5ScrollView.smoothScrollTo(0, title[finalI].getTop());
                    dialog.dismiss();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        endTime5 = System.currentTimeMillis();
        long timeDiff = endTime5 - startTime5;
        int newTime = (int) (timeDiff / 1000);

        Boolean checkId = dbHandler.checkTopicsId(176);
        if (checkId == true) {
            Map<String, String> studyTime = dbHandler.getTopicsId(176);
            if (!studyTime.isEmpty()) {
                int prevTime = Integer.parseInt(studyTime.get(TIME_IN_SEC));
                int totalTime = newTime + prevTime;
                Boolean updated = dbHandler.updateTime(new StudyModelClass(176, totalTime));
            }
        } else {
            dbHandler.storeStudyTime(new StudyModelClass(176, newTime));
        }

        super.onBackPressed();
    }
}