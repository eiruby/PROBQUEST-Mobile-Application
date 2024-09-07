package com.enverzo.probquest.ui.games;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.enverzo.probquest.R;

import java.util.Random;

public class RollDiceActivity extends AppCompatActivity {
    private ImageView diceExit, dice1, dice2, diceMechanicsImage;
    private TextView sumTextView, rollDiceInstruction, rollDiceHighScore, rollDiceScore, diceMechanicsText;
    private Button rollDiceRoll, lessThan7, equalTo7, greaterThan7,rollDiceRestart, diceMechanics, cancelDiceMechanics;
    private View diceMaskView;
    private RelativeLayout diceMechanicsContent;
    private int animationCounter, index, result, score, highScore;
    private static final int WIN_LESS_THAN_7 = 1;
    private static final int WIN_GREATER_THAN_7 = 2;
    private static final int WIN_EQUAL_TO_7 = 3;
    private static final int LOSE = 4;
    private static final String PREFS_FILE_NAME = "RollDiceHighScore";
    private static final String KEY_HIGH_SCORE = "highScore";
    private Runnable runnable1, runnable2, runnable3, runnable4, runnable5, runnable6, runnable7;
    private Handler handler;
    private MediaPlayer rollSound, mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_dice);

        rollDiceRoll = findViewById(R.id.rollDiceRoll);
        rollDiceRestart = findViewById(R.id.rollDiceRestart);
        diceExit = findViewById(R.id.diceExit);
        lessThan7 = findViewById(R.id.lessThan7);
        equalTo7 = findViewById(R.id.equalTo7);
        greaterThan7 = findViewById(R.id.greaterThan7);
        sumTextView = findViewById(R.id.sumTextView);
        rollDiceHighScore = findViewById(R.id.rollDiceHighScore);
        rollDiceScore = findViewById(R.id.rollDiceScore);
        dice1 = findViewById(R.id.dice1);
        dice2 = findViewById(R.id.dice2);
        diceMechanics = findViewById(R.id.diceMechanics);
        cancelDiceMechanics = findViewById(R.id.cancelDiceMechanics);
        diceMechanicsImage = findViewById(R.id.diceMechanicsImage);
        diceMechanicsText = findViewById(R.id.diceMechanicsText);
        diceMaskView = findViewById(R.id.diceMaskView);
        diceMechanicsContent = findViewById(R.id.diceMechanicsContent);

        animationCounter = 0;
        index = 0;
        result = 0;
        score = 0;
        handler = new Handler();

        loadHighScore();
        rollDiceHighScore.setText("High Score: " + highScore);

        diceExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        lessThan7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = 1;
                rollDiceRoll.setVisibility(View.VISIBLE);
                lessThan7.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                lessThan7.setTextColor(getResources().getColor(R.color.purple));
                Button[] buttons = {equalTo7, greaterThan7};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setBackgroundTintList(getResources().getColorStateList(R.color.purple));
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        equalTo7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = 2;
                rollDiceRoll.setVisibility(View.VISIBLE);
                equalTo7.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                equalTo7.setTextColor(getResources().getColor(R.color.purple));
                Button[] buttons = {lessThan7, greaterThan7};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setBackgroundTintList(getResources().getColorStateList(R.color.purple));
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        greaterThan7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = 3;
                rollDiceRoll.setVisibility(View.VISIBLE);
                greaterThan7.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                greaterThan7.setTextColor(getResources().getColor(R.color.purple));
                Button[] buttons = {lessThan7, equalTo7};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setBackgroundTintList(getResources().getColorStateList(R.color.purple));
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        rollDiceRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index > 0) {
                    rollSound = MediaPlayer.create(RollDiceActivity.this, R.raw.rolling_dice_sound);
                    rollSound.start();
                    rollDice();
                    lessThan7.setEnabled(false);
                    equalTo7.setEnabled(false);
                    greaterThan7.setEnabled(false);
                    rollDiceRoll.setVisibility(View.INVISIBLE);
                }
            }
        });

        rollDiceRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDiceRoll.setEnabled(true);
                rollDiceRestart.setVisibility(View.INVISIBLE);
                sumTextView.setText("Sum:");
                Button[] buttons = {lessThan7, equalTo7, greaterThan7};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setBackgroundTintList(getResources().getColorStateList(R.color.purple));
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        runnable1 = new Runnable() {
            @Override
            public void run() {
                diceMechanicsText.setText("You begin by predicting whether the sum of two rolled dice will be less than 7, greater than 7, or equal to 7.");
                diceMechanicsImage.setImageResource(R.drawable.male_teacher3);
            }
        };

        runnable2 = new Runnable() {
            @Override
            public void run() {
                diceMechanicsText.setText("Once you've made your prediction, click the roll button to initiate the dice roll.");
            }
        };

        runnable3 = new Runnable() {
            @Override
            public void run() {
                diceMechanicsText.setText("The resulting numbers will be added up to determine the sum.");
            }
        };

        runnable4 = new Runnable() {
            @Override
            public void run() {
                diceMechanicsText.setText("If your prediction matches the actual sum, you win the round and earn 2 points.");
                diceMechanicsImage.setImageResource(R.drawable.male_teacher1);
            }
        };

        runnable5 = new Runnable() {
            @Override
            public void run() {
                diceMechanicsText.setText("However, if your prediction is incorrect, you lose 1 point.");
            }
        };

        runnable6 = new Runnable() {
            @Override
            public void run() {
                diceMechanicsText.setText("Good luck, and enjoy the game!");
                diceMechanicsImage.setImageResource(R.drawable.male_teacher2);
            }
        };

        runnable7 = new Runnable() {
            @Override
            public void run() {
                diceExit.setEnabled(true);
                Button[] buttons = {lessThan7, equalTo7, greaterThan7, rollDiceRestart, rollDiceRoll};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                }
                diceMechanics.setVisibility(View.VISIBLE);
                diceMaskView.setVisibility(View.GONE);
                diceMechanicsContent.setVisibility(View.GONE);
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
            }
        };

        diceMechanics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diceExit.setEnabled(false);
                Button[] buttons = {lessThan7, equalTo7, greaterThan7, rollDiceRestart, rollDiceRoll};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(false);
                }
                diceMechanics.setVisibility(View.INVISIBLE);
                diceMaskView.setVisibility(View.VISIBLE);
                diceMechanicsContent.setVisibility(View.VISIBLE);

                Animation slideRight = AnimationUtils.loadAnimation(RollDiceActivity.this, R.anim.slide_right);
                Animation slideUp = AnimationUtils.loadAnimation(RollDiceActivity.this, R.anim.slide_up);
                diceMechanicsText.setAnimation(slideRight);
                diceMechanicsImage.setAnimation(slideUp);

                diceMechanicsText.setText("Welcome to the Roll Dice game! Here’s how you can play:");
                diceMechanicsImage.setImageResource(R.drawable.male_teacher2);

                slideUp.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mediaPlayer = MediaPlayer.create(RollDiceActivity.this, R.raw.tut_roll_dice);
                        mediaPlayer.start();
                        handler.postDelayed(runnable1, 5000);
                        handler.postDelayed(runnable2, 12300);
                        handler.postDelayed(runnable3, 17200);
                        handler.postDelayed(runnable4, 21000);
                        handler.postDelayed(runnable5, 26200);
                        handler.postDelayed(runnable6, 31500);
                        handler.postDelayed(runnable7, 34000);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        cancelDiceMechanics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diceExit.setEnabled(true);
                diceMechanics.setVisibility(View.VISIBLE);
                diceMaskView.setVisibility(View.GONE);
                diceMechanicsContent.setVisibility(View.GONE);
                Button[] buttons = {lessThan7, equalTo7, greaterThan7, rollDiceRestart, rollDiceRoll};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                }
                handler.removeCallbacks(runnable1);
                handler.removeCallbacks(runnable2);
                handler.removeCallbacks(runnable3);
                handler.removeCallbacks(runnable4);
                handler.removeCallbacks(runnable5);
                handler.removeCallbacks(runnable6);
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        diceExit.setEnabled(true);
        diceMechanics.setVisibility(View.VISIBLE);
        diceMaskView.setVisibility(View.GONE);
        diceMechanicsContent.setVisibility(View.GONE);
        Button[] buttons = {lessThan7, equalTo7, greaterThan7, rollDiceRestart, rollDiceRoll};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(true);
        }
        handler.removeCallbacks(runnable1);
        handler.removeCallbacks(runnable2);
        handler.removeCallbacks(runnable3);
        handler.removeCallbacks(runnable4);
        handler.removeCallbacks(runnable5);
        handler.removeCallbacks(runnable6);
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void onBackPressed() {
        if (rollSound != null) {
            rollSound.stop();
            rollSound.release();
            rollSound = null;
        }
        super.onBackPressed();
    }

    private void rollDice() {
        final Animation anim = AnimationUtils.loadAnimation(RollDiceActivity.this, R.anim.roll_button);
        dice1.startAnimation(anim);
        dice2.startAnimation(anim);

        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animationCounter++;
                if (animationCounter == 1) {
                    rollAndSetDiceValues();
                    animationCounter = 0;
                }
                if (rollSound != null) {
                    rollSound.stop();
                    rollSound.release();
                    rollSound = null;
                }
                rollDiceRestart.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void rollAndSetDiceValues() {
        int value1 = randomDiceValue();
        int value2 = randomDiceValue();
        int res1 = getResources().getIdentifier("dice_" + value1, "drawable", getPackageName());
        int res2 = getResources().getIdentifier("dice_" + value2, "drawable", getPackageName());

        dice1.setImageResource(res1);
        dice2.setImageResource(res2);

        int sum = value1 + value2;
        sumTextView.setText("Sum: " + sum);

        if (index == 1 && sum < 7) {
            score += 2;
            result = WIN_LESS_THAN_7;
        } else if (index == 2 && sum == 7) {
            score += 4;
            result = WIN_EQUAL_TO_7;
        } else if (index == 3 && sum > 7) {
            score += 2;
            result = WIN_GREATER_THAN_7;
        } else {
            score -= 1;
            if (score < 1) {
                score = 0;
            } else {
                result = LOSE;
            }
        }

        rollDiceScore.setText("Score: "+score);
        updateHighScore(score);
    }

    private void loadHighScore() {
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        highScore = prefs.getInt(KEY_HIGH_SCORE, 0);
    }

    private void saveHighScore(int score) {
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGH_SCORE, score);
        editor.apply();
    }

    private void updateHighScore(int newScore) {
        if (newScore > highScore) {
            highScore = newScore;
            saveHighScore(highScore);
            rollDiceHighScore.setText("High Score: " + highScore);
        }
    }

    private int randomDiceValue() {
        return new Random().nextInt(6) + 1;
    }
}