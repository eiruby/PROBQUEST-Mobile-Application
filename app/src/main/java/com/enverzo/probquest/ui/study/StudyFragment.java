package com.enverzo.probquest.ui.study;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.enverzo.probquest.DBHandler;
import com.enverzo.probquest.R;

import java.util.ArrayList;
import java.util.List;

public class StudyFragment extends Fragment {
    private TextView greetings;
    private Button questBtn, tutorialStudy, tutorialCancel;
    private TextView tutorialText;
    private String[] lessonName = {"Simple Events", "Compound Events", "Mutually Exclusive Events", "Non-Mutually Exclusive Events", "Independent Events", "Dependent Events", "Permutation of n Distinct Objects Taken n at a Time", "Permutation of n Distinct Objects Taken r at a Time", "Circular Permutation", "Permutations with Identical Objects", "Combination", "Fundamental Counting Principle"};
    private ListView listViewLesson;
    private List<String> topicName = new ArrayList<>();
    private List<String> topicObj = new ArrayList<>();
    private int[] topicImg = new int[lessonName.length];
    private int[] topicBg = new int[lessonName.length];
    private boolean[] topicBtn = new boolean[lessonName.length];
    private RelativeLayout tutorialContent;
    private CardView tutorialQuest;
    private View maskView;
    private Handler handler;
    private Runnable runnable1, runnable2, runnable3, runnable4, runnable5, runnable6, runnable7, runnable8, runnable9, runnable10;
    private ImageView tutorialImage;
    private MediaPlayer mediaPlayer;
    private LessonAdapter lessonAdapter;
    private boolean beforePlayer2 = true;
    DBHandler dbHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_study, container, false);

        greetings = root.findViewById(R.id.greetings);
        listViewLesson = root.findViewById(R.id.listViewLesson);
        questBtn = root.findViewById(R.id.questBtn);
        tutorialStudy = root.findViewById(R.id.tutorialStudy);
        tutorialContent = root.findViewById(R.id.tutorialContent);
        tutorialText = root.findViewById(R.id.tutorialText);
        tutorialImage = root.findViewById(R.id.tutorialImage);
        tutorialCancel = root.findViewById(R.id.tutorialCancel);
        tutorialQuest = root.findViewById(R.id.tutorialQuest);
        maskView = root.findViewById(R.id.maskView);

        dbHandler = new DBHandler(requireContext());
        Cursor cursor = dbHandler.getUser(1);
        if (cursor.moveToNext()) {
            greetings.setText("Hi, " + cursor.getString(1) + "!");
        }

        topicName.clear();
        topicObj.clear();

        lessonAdapter = new LessonAdapter(requireActivity(), topicName, topicObj, topicImg, topicBg, topicBtn);
        listViewLesson.setAdapter(lessonAdapter);
        ((LessonAdapter) listViewLesson.getAdapter()).notifyDataSetChanged();

        String lessonT1Format = "In this lesson, we will learn how to determine the sample space of an event and find the probability of simple events.";
        String lessonT2Format = "In this lesson, we will learn how to differentiate between simple events and compound events through given event/s.";
        String lessonT3Format = "In this lesson, we will learn how to find the probability of mutually exclusive events.";
        String lessonT4Format = "In this lesson, we will learn how to find the probability of non-mutually exclusive events.";
        String lessonT5Format = "In this lesson, we will learn how to find the probability of independent events.";
        String lessonT6Format = "In this lesson, we will learn how to find the probability of dependent events.";
        String lessonT7Format = "In this lesson, we will learn how to find the permutation of n distinct objects taken n at a time.";
        String lessonT8Format = "In this lesson, we will learn how to find the permutation of n distinct objects taken r at a time.";
        String lessonT9Format = "In this lesson, we will learn how to find the number of permutations of n distinct objects arranged in a circle.";
        String lessonT10Format = "In this lesson, we will learn how to find the number of permutations of n objects some are alike or identical.";
        String lessonT11Format = "In this lesson, we will learn how to find the number of arrangements in which the order of selection is not important.";
        String lessonT12Format = "In this lesson, we will learn how to use a tree diagram in determining all possible outcomes of a compound event and finding the number of ways a compound event may occur using the fundamental principle of counting.";

        String[] format = {lessonT1Format, lessonT2Format, lessonT3Format, lessonT4Format, lessonT5Format, lessonT6Format, lessonT7Format, lessonT8Format, lessonT9Format, lessonT10Format, lessonT11Format, lessonT12Format};
        int[] imgName = {R.drawable.topic_1, R.drawable.topic_2, R.drawable.topic_3, R.drawable.topic_4, R.drawable.topic_5, R.drawable.topic_6, R.drawable.topic_7, R.drawable.topic_8, R.drawable.topic_9, R.drawable.topic_10, R.drawable.topic_11, R.drawable.topic_12};
        int[] colorName = {R.color.topic1, R.color.topic2, R.color.topic3, R.color.topic4, R.color.topic5, R.color.topic6, R.color.topic7, R.color.topic8, R.color.topic9, R.color.topic10, R.color.topic11, R.color.topic12};

        for (int i = 0; i < lessonName.length; i++) {
            topicName.add(lessonName[i]);
            topicImg[i] = imgName[i];
            topicBg[i] = colorName[i];
            topicBtn[i] = true;
            topicObj.add(format[i]);
        }

        questBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireActivity(), QuestActivity.class);
                startActivity(intent);
            }
        });

        handler = new Handler();
        runnable1 = new Runnable() {
            @Override
            public void run() {
                tutorialText.setText("I'm Ms. Camila, your guide through this exciting journey of learning.");
            }
        };
        runnable2 = new Runnable() {
            @Override
            public void run() {
                tutorialText.setText("Here, you'll find your probability quests and lessons.");
                tutorialImage.setImageResource(R.drawable.female_teacher1);
            }
        };
        runnable3 = new Runnable() {
            @Override
            public void run() {
                tutorialText.setText("In the Probability Quest section, you will find your quests laid out.");
                tutorialImage.setImageResource(R.drawable.female_teacher3);
                tutorialQuest.setVisibility(View.VISIBLE);
            }
        };
        runnable4 = new Runnable() {
            @Override
            public void run() {
                tutorialText.setText("To begin your quests, simply click on the 'Quest' button.");
            }
        };
        runnable5 = new Runnable() {
            @Override
            public void run() {
                tutorialText.setText("Below you'll discover our twelve (12) lessons.");
                tutorialImage.setImageResource(R.drawable.female_teacher2);
                tutorialQuest.setVisibility(View.GONE);
            }
        };
        runnable6 = new Runnable() {
            @Override
            public void run() {
                tutorialText.setText("Each lesson features interactive content, including readings, video lectures, and hands-on activities and assessments.");
            }
        };
        runnable7 = new Runnable() {
            @Override
            public void run() {
                tutorialText.setText("Just click the 'Start Lesson' button to begin your study session.");
            }
        };
        runnable8 = new Runnable() {
            @Override
            public void run() {
                tutorialText.setText("So, what are you waiting for?");
                tutorialImage.setImageResource(R.drawable.female_teacher4);
            }
        };
        runnable9 = new Runnable() {
            @Override
            public void run() {
                tutorialText.setText("Dive into PROBQUEST today and level up your understanding of probability.");
            }
        };
        runnable10 = new Runnable() {
            @Override
            public void run() {
                tutorialContent.setVisibility(View.GONE);
                maskView.setVisibility(View.GONE);
                tutorialQuest.setVisibility(View.GONE);
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
                questBtn.setEnabled(true);
                tutorialStudy.setEnabled(true);
                for (int i = 0; i < lessonName.length; i++) {
                    topicBtn[i] = true;
                }
                lessonAdapter.notifyDataSetChanged();
            }
        };

        tutorialStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation slideRight = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_right);
                Animation slideUp = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up);
                tutorialContent.setVisibility(View.VISIBLE);
                maskView.setVisibility(View.VISIBLE);
                tutorialText.setAnimation(slideRight);
                tutorialImage.setAnimation(slideUp);

                tutorialText.setText("Welcome to the Study feature of the PROBQUEST app!");
                tutorialImage.setImageResource(R.drawable.female_teacher4);

                questBtn.setEnabled(false);
                tutorialStudy.setEnabled(false);
                for (int i = 0; i < lessonName.length; i++) {
                    topicBtn[i] = false;
                }
                lessonAdapter.notifyDataSetChanged();

                slideUp.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.tutorial_study);
                        mediaPlayer.start();
                        handler.postDelayed(runnable1, 2800);
                        handler.postDelayed(runnable2, 7000);
                        handler.postDelayed(runnable3, 10800);
                        handler.postDelayed(runnable4, 14800);
                        handler.postDelayed(runnable5, 18200);
                        handler.postDelayed(runnable6, 20900);
                        handler.postDelayed(runnable7, 28250);
                        handler.postDelayed(runnable8, 31600);
                        handler.postDelayed(runnable9, 33500);
                        handler.postDelayed(runnable10, 39000);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        tutorialCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tutorialContent.setVisibility(View.GONE);
                maskView.setVisibility(View.GONE);
                tutorialQuest.setVisibility(View.GONE);
                handler.removeCallbacks(runnable1);
                handler.removeCallbacks(runnable2);
                handler.removeCallbacks(runnable3);
                handler.removeCallbacks(runnable4);
                handler.removeCallbacks(runnable5);
                handler.removeCallbacks(runnable6);
                handler.removeCallbacks(runnable7);
                handler.removeCallbacks(runnable8);
                handler.removeCallbacks(runnable9);
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
                questBtn.setEnabled(true);
                tutorialStudy.setEnabled(true);
                for (int i = 0; i < lessonName.length; i++) {
                    topicBtn[i] = true;
                }
                lessonAdapter.notifyDataSetChanged();
            }
        });

        return root;
    }
    @Override
    public void onStop()  {
        super.onStop();
        tutorialContent.setVisibility(View.GONE);
        maskView.setVisibility(View.GONE);
        tutorialQuest.setVisibility(View.GONE);
        handler.removeCallbacks(runnable1);
        handler.removeCallbacks(runnable2);
        handler.removeCallbacks(runnable3);
        handler.removeCallbacks(runnable4);
        handler.removeCallbacks(runnable5);
        handler.removeCallbacks(runnable6);
        handler.removeCallbacks(runnable7);
        handler.removeCallbacks(runnable8);
        handler.removeCallbacks(runnable9);
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        questBtn.setEnabled(true);
        tutorialStudy.setEnabled(true);
        for (int i = 0; i < lessonName.length; i++) {
            topicBtn[i] = true;
        }
        lessonAdapter.notifyDataSetChanged();
    }
}