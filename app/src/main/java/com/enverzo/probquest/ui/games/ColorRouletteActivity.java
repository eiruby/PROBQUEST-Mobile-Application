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
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.enverzo.probquest.R;

import java.util.Random;

public class ColorRouletteActivity extends AppCompatActivity {
    private ImageView rouletteExit, wheelImageView, rouletteMechanicsImage;
    private TextView rouletteMechanicsText, rouletteHighScore, rouletteScore;
    private Button redButton, blueButton, yellowButton, greenButton, rouletteRestart, rouletteSpin, rouletteMechanics, cancelRouletteMechanics;
    private View rouletteMaskView;
    private RelativeLayout rouletteMechanicsContent;
    private int index, score, degree, result, highScore;
    private boolean isSpinning = false;
    private String[] sectors;
    private int[] sectorsDegrees;
    private static final int RED = 1;
    private static final int BLUE = 2;
    private static final int YELLOW = 3;
    private static final int GREEN = 4;
    private static final int LOSE = 5;
    private static final String PREFS_FILE_NAME = "ColorRouletteScore";
    private static final String KEY_HIGH_SCORE = "g2HighScore";
    private Runnable runnable1, runnable2, runnable3, runnable4, runnable5, runnable6, runnable7, runnable8;
    private Handler handler;
    private MediaPlayer spinSound, mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_roulette);

        rouletteExit = findViewById(R.id.rouletteExit);
        wheelImageView = findViewById(R.id.wheelImageView);
        rouletteHighScore = findViewById(R.id.rouletteHighScore);
        rouletteScore = findViewById(R.id.rouletteScore);
        redButton = findViewById(R.id.redButton);
        blueButton = findViewById(R.id.blueButton);
        yellowButton = findViewById(R.id.yellowButton);
        greenButton = findViewById(R.id.greenButton);
        rouletteRestart = findViewById(R.id.rouletteRestart);
        rouletteSpin = findViewById(R.id.rouletteSpin);
        rouletteMechanics = findViewById(R.id.rouletteMechanics);
        cancelRouletteMechanics = findViewById(R.id.cancelRouletteMechanics);
        rouletteMechanicsText = findViewById(R.id.rouletteMechanicsText);
        rouletteMechanicsImage = findViewById(R.id.rouletteMechanicsImage);
        rouletteMaskView = findViewById(R.id.rouletteMaskView);
        rouletteMechanicsContent = findViewById(R.id.rouletteMechanicsContent);

        score = 0;

        loadHighScore();
        rouletteHighScore.setText("High Score: " + highScore);
        handler = new Handler();
        
        wheelGenerator();
        rouletteExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        rouletteSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isSpinning) {
                    spinSound = MediaPlayer.create(ColorRouletteActivity.this, R.raw.spin_sound);
                    spinSound.start();
                    spinWheel();
                    isSpinning = true;
                    rouletteSpin.setVisibility(View.INVISIBLE);
                    redButton.setEnabled(false);
                    blueButton.setEnabled(false);
                    yellowButton.setEnabled(false);
                    greenButton.setEnabled(false);
                }
            }
        });

        rouletteRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wheelGenerator();
                resetButton();
            }
        });

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = 1;
                rouletteSpin.setVisibility(View.VISIBLE);
                redButton.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                redButton.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {blueButton, yellowButton, greenButton};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = 2;
                rouletteSpin.setVisibility(View.VISIBLE);
                blueButton.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                blueButton.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {redButton, yellowButton, greenButton};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = 3;
                rouletteSpin.setVisibility(View.VISIBLE);
                yellowButton.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                yellowButton.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {redButton, blueButton, greenButton};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = 4;
                rouletteSpin.setVisibility(View.VISIBLE);
                greenButton.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                greenButton.setTextColor(getResources().getColor(R.color.blue));
                Button[] buttons = {redButton, blueButton, yellowButton};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                    buttons[i].setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        runnable1 = new Runnable() {
            @Override
            public void run() {
                rouletteMechanicsText.setText("The roulette wheel consists of 16 slots, each colored either red, blue, green, or yellow.");
                rouletteMechanicsImage.setImageResource(R.drawable.female_teacher2);
            }
        };

        runnable2 = new Runnable() {
            @Override
            public void run() {
                rouletteMechanicsText.setText("The distribution of colors across the wheel is uneven.");
            }
        };

        runnable3 = new Runnable() {
            @Override
            public void run() {
                rouletteMechanicsText.setText("You begin by making a prediction, choosing one of the four colors: red, blue, green, or yellow.");
                rouletteMechanicsImage.setImageResource(R.drawable.female_teacher1);
            }
        };

        runnable4 = new Runnable() {
            @Override
            public void run() {
                rouletteMechanicsText.setText("Once you've made your prediction, spin the wheel.");
                rouletteMechanicsImage.setImageResource(R.drawable.female_teacher3);
            }
        };

        runnable5 = new Runnable() {
            @Override
            public void run() {
                rouletteMechanicsText.setText("If the wheel lands on the color you predicted, you win the round and earn 2 points.");
            }
        };

        runnable6 = new Runnable() {
            @Override
            public void run() {
                rouletteMechanicsText.setText("However, if your prediction is incorrect, you lose 1 point.");
            }
        };

        runnable7 = new Runnable() {
            @Override
            public void run() {
                rouletteMechanicsText.setText("Good luck, and enjoy the game!");
                rouletteMechanicsImage.setImageResource(R.drawable.female_teacher4);
            }
        };

        runnable8 = new Runnable() {
            @Override
            public void run() {
                rouletteExit.setEnabled(true);
                rouletteMechanics.setVisibility(View.VISIBLE);
                rouletteMaskView.setVisibility(View.GONE);
                rouletteMechanicsContent.setVisibility(View.GONE);
                Button[] buttons = {redButton, blueButton, yellowButton, greenButton, rouletteSpin, rouletteRestart};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                }
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
            }
        };

        rouletteMechanics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rouletteExit.setEnabled(false);
                Button[] buttons = {redButton, blueButton, yellowButton, greenButton, rouletteSpin, rouletteRestart};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(false);
                }
                rouletteMechanics.setVisibility(View.INVISIBLE);
                rouletteMaskView.setVisibility(View.VISIBLE);
                rouletteMechanicsContent.setVisibility(View.VISIBLE);

                Animation slideRight = AnimationUtils.loadAnimation(ColorRouletteActivity.this, R.anim.slide_right);
                Animation slideUp = AnimationUtils.loadAnimation(ColorRouletteActivity.this, R.anim.slide_up);
                rouletteMechanicsText.setAnimation(slideRight);
                rouletteMechanicsImage.setAnimation(slideUp);

                rouletteMechanicsText.setText("Welcome to the Color Roulette game! Here’s how you can play:");
                rouletteMechanicsImage.setImageResource(R.drawable.female_teacher4);

                slideUp.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mediaPlayer = MediaPlayer.create(ColorRouletteActivity.this, R.raw.tut_color_roulette);
                        mediaPlayer.start();
                        handler.postDelayed(runnable1, 4300);
                        handler.postDelayed(runnable2, 11900);
                        handler.postDelayed(runnable3, 15800);
                        handler.postDelayed(runnable4, 23100);
                        handler.postDelayed(runnable5, 26100);
                        handler.postDelayed(runnable6, 31700);
                        handler.postDelayed(runnable7, 36500);
                        handler.postDelayed(runnable8, 40000);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        cancelRouletteMechanics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rouletteExit.setEnabled(true);
                rouletteMechanics.setVisibility(View.VISIBLE);
                rouletteMaskView.setVisibility(View.GONE);
                rouletteMechanicsContent.setVisibility(View.GONE);
                Button[] buttons = {redButton, blueButton, yellowButton, greenButton, rouletteSpin, rouletteRestart};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                }
                handler.removeCallbacks(runnable1);
                handler.removeCallbacks(runnable2);
                handler.removeCallbacks(runnable3);
                handler.removeCallbacks(runnable4);
                handler.removeCallbacks(runnable5);
                handler.removeCallbacks(runnable6);
                handler.removeCallbacks(runnable7);
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
        rouletteExit.setEnabled(true);
        rouletteMechanics.setVisibility(View.VISIBLE);
        rouletteMaskView.setVisibility(View.GONE);
        rouletteMechanicsContent.setVisibility(View.GONE);
        Button[] buttons = {redButton, blueButton, yellowButton, greenButton, rouletteSpin, rouletteRestart};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(true);
        }
        handler.removeCallbacks(runnable1);
        handler.removeCallbacks(runnable2);
        handler.removeCallbacks(runnable3);
        handler.removeCallbacks(runnable4);
        handler.removeCallbacks(runnable5);
        handler.removeCallbacks(runnable6);
        handler.removeCallbacks(runnable7);
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void onBackPressed() {
        if (spinSound != null) {
            spinSound.stop();
            spinSound.release();
            spinSound = null;
        }
        super.onBackPressed();
    }

    private void spinWheel() {
        degree = new Random().nextInt(sectors.length - 1);
        RotateAnimation rotateAnimation = new RotateAnimation(0, (360 * sectors.length) + sectorsDegrees[degree],
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setDuration(2500);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                rouletteRestart.setVisibility(View.VISIBLE);
                isSpinning = false;
                points();
                if (spinSound != null) {
                    spinSound.stop();
                    spinSound.release();
                    spinSound = null;
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        wheelImageView.startAnimation(rotateAnimation);
    }

    private void points() {
        String color = sectors[sectors.length - (degree + 1)];
        if (index == 1 && color == "red") {
            score += 2;
            result = RED;
        } else if (index == 2 && color == "blue") {
            score += 2;
            result = BLUE;
        } else if (index == 3 && color == "yellow") {
            score += 2;
            result = YELLOW;
        } else if (index == 4 && color == "green") {
            score += 2;
            result = GREEN;
        } else {
            score--;
            if (score < 1) {
                score = 0;
            } else {
                result = LOSE;
            }
        }

        rouletteScore.setText(String.valueOf("Score: " + score));
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
            rouletteHighScore.setText("High Score: " + highScore);
        }
    }

    private void wheelGenerator() {
        int value = randomWheel();
        int res = getResources().getIdentifier("wheel_" + value, "drawable", getPackageName());
        wheelImageView.setImageResource(res);

        if (value == 1) {
            sectors = new String[]{"red", "yellow", "green", "green", "blue", "green", "blue", "green", "yellow", "blue", "blue", "yellow"};
        } else if (value == 2) {
            sectors = new String[]{"yellow", "yellow", "red", "blue", "yellow", "red", "blue", "green", "green", "blue", "red", "yellow"};
        } else if (value == 3) {
            sectors = new String[]{"blue", "red", "green", "yellow", "yellow", "blue", "green", "green", "red", "red", "red", "blue"};
        } else if (value == 4) {
            sectors = new String[]{"green", "blue", "yellow", "blue", "green", "yellow", "yellow", "red", "blue", "green", "red", "blue"};
        }

        sectorsDegrees = new int[sectors.length];
        getDegreesForSectors();
    }

    private void getDegreesForSectors(){
        int sectorDegree = 360/sectors.length;
        for (int i = 0; i < sectors.length; i++) {
            sectorsDegrees[i] = (i + 1) * sectorDegree;
        }
    }

    private int randomWheel() {
        return new Random().nextInt(4)+1;
    }

    private void resetButton() {
        rouletteRestart.setVisibility(View.INVISIBLE);
        rouletteSpin.setVisibility(View.INVISIBLE);
        Button[] buttons = {redButton, blueButton, yellowButton, greenButton};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(true);
            buttons[i].setBackgroundResource(R.drawable.custom_option_button);
            buttons[i].setBackgroundTintList(getResources().getColorStateList(R.color.blue));
            buttons[i].setTextColor(getResources().getColor(R.color.white));
        }
    }
}