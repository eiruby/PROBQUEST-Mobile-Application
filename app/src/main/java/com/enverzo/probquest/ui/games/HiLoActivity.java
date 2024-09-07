package com.enverzo.probquest.ui.games;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.enverzo.probquest.R;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HiLoActivity extends AppCompatActivity {

    private TextView remainingPointsText, betPointsText, hiloMechanicsText;
    private ImageView hiloExit, hiloMechanicsImage, firstCard, secondCard, thirdCard, fourthCard, fifthCard, sixthCard, seventhCard, eighthCard, ninthCard;
    private Button higher, lower, hiloMechanics, cancelHiloMechanics;
    private SeekBar seekBar;
    private View hiloMaskView;
    private RelativeLayout hiloMechanicsContent;
    private int index, remainingPoints, betPoints, currentValue;
    private Set<String> usedCardCombinations = new HashSet<>();
    private Random random = new Random();
    private Runnable runnableDialog, runnable1, runnable2, runnable3, runnable4, runnable5, runnable6, runnable7, runnable8, runnable9, runnable10, runnable11;
    private Handler handler;
    private MediaPlayer mediaPlayer;
    private boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hilo);

        remainingPointsText = findViewById(R.id.remainingPoints);
        betPointsText = findViewById(R.id.betPoints);
        hiloExit = findViewById(R.id.hiloExit);
        firstCard = findViewById(R.id.firstCard);
        secondCard = findViewById(R.id.secondCard);
        thirdCard = findViewById(R.id.thirdCard);
        fourthCard = findViewById(R.id.fourthCard);
        fifthCard = findViewById(R.id.fifthCard);
        sixthCard = findViewById(R.id.sixthCard);
        seventhCard = findViewById(R.id.seventhCard);
        eighthCard = findViewById(R.id.eighthCard);
        ninthCard = findViewById(R.id.ninthCard);
        higher = findViewById(R.id.higher);
        lower = findViewById(R.id.lower);
        seekBar = findViewById(R.id.seekBar);
        hiloMechanics = findViewById(R.id.hiloMechanics);
        cancelHiloMechanics = findViewById(R.id.cancelHiloMechanics);
        hiloMechanicsText = findViewById(R.id.hiloMechanicsText);
        hiloMechanicsImage = findViewById(R.id.hiloMechanicsImage);
        hiloMechanicsContent = findViewById(R.id.hiloMechanicsContent);
        hiloMaskView = findViewById(R.id.hiloMaskView);

        index = 1;
        remainingPoints = 40;
        currentValue = 0;
        betPoints = 0;
        betPointsText.setText(String.valueOf(0));
        handler = new Handler(Looper.getMainLooper());

        firstCardReveal();

        hiloExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int points, boolean b) {
                betPointsText.setText(String.valueOf(points));
                betPoints = points;
                if (points >= 1) {
                    higher.setEnabled(true);
                    lower.setEnabled(true);
                } else {
                    higher.setEnabled(false);
                    lower.setEnabled(false);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        higher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                revealCardHi();
            }
        });

        lower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                revealCardLo();
            }
        });

        runnableDialog = new Runnable() {
            @Override
            public void run() {
                gameDialog();
            }
        };

        runnable1 = new Runnable() {
            @Override
            public void run() {
                hiloMechanicsText.setText("First, you'll bet on whether the next card drawn will be higher or lower than the last one.");
                hiloMechanicsImage.setImageResource(R.drawable.female_teacher2);
            }
        };

        runnable2 = new Runnable() {
            @Override
            public void run() {
                hiloMechanicsText.setText("The cards are ranked from Ace (the lowest) to King (the highest).");
            }
        };

        runnable3 = new Runnable() {
            @Override
            public void run() {
                hiloMechanicsText.setText("The game begins by automatically revealing the first card from a deck of 9 cards.");
            }
        };

        runnable4 = new Runnable() {
            @Override
            public void run() {
                hiloMechanicsText.setText("Based on this card, you’ll place your bet. You can bet anywhere from 1 to 40 points.");
                hiloMechanicsImage.setImageResource(R.drawable.female_teacher1);
            }
        };

        runnable5 = new Runnable() {
            @Override
            public void run() {
                hiloMechanicsText.setText("Once your bet is placed, click on either the 'Higher' or 'Lower' button to make your prediction.");
                hiloMechanicsImage.setImageResource(R.drawable.female_teacher3);
            }
        };

        runnable6 = new Runnable() {
            @Override
            public void run() {
                hiloMechanicsText.setText("If your guess is correct, you will win double your bet amount.");
                hiloMechanicsImage.setImageResource(R.drawable.female_teacher4);
            }
        };

        runnable7 = new Runnable() {
            @Override
            public void run() {
                hiloMechanicsText.setText("If your guess is wrong, you will lose your bet amount.");
            }
        };

        runnable8 = new Runnable() {
            @Override
            public void run() {
                hiloMechanicsText.setText("In the event of a tie, where the same card appears again, your points will remain unchanged.");
            }
        };

        runnable9 = new Runnable() {
            @Override
            public void run() {
                hiloMechanicsText.setText("You can adjust your bet between each round.");
            }
        };

        runnable10 = new Runnable() {
            @Override
            public void run() {
                hiloMechanicsText.setText("Good luck, and enjoy the game!");
            }
        };

        runnable11 = new Runnable() {
            @Override
            public void run() {
                hiloExit.setEnabled(true);
                seekBar.setEnabled(true);
                if (betPoints < 1) {
                    higher.setEnabled(false);
                    lower.setEnabled(false);
                } else {
                    higher.setEnabled(true);
                    lower.setEnabled(true);
                }
                hiloMechanics.setVisibility(View.VISIBLE);
                hiloMaskView.setVisibility(View.GONE);
                hiloMechanicsContent.setVisibility(View.GONE);
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
            }
        };

        hiloMechanics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hiloExit.setEnabled(false);
                seekBar.setEnabled(false);
                higher.setEnabled(false);
                lower.setEnabled(false);
                hiloMechanics.setVisibility(View.INVISIBLE);
                hiloMaskView.setVisibility(View.VISIBLE);
                hiloMechanicsContent.setVisibility(View.VISIBLE);

                Animation slideRight = AnimationUtils.loadAnimation(HiLoActivity.this, R.anim.slide_right);
                Animation slideUp = AnimationUtils.loadAnimation(HiLoActivity.this, R.anim.slide_up);
                hiloMechanicsText.setAnimation(slideRight);
                hiloMechanicsImage.setAnimation(slideUp);

                hiloMechanicsText.setText("Welcome to the Higher or Lower game! Here’s how you can play:");
                hiloMechanicsImage.setImageResource(R.drawable.female_teacher4);

                slideUp.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mediaPlayer = MediaPlayer.create(HiLoActivity.this, R.raw.tut_hilo);
                        mediaPlayer.start();
                        handler.postDelayed(runnable1, 3900);
                        handler.postDelayed(runnable2, 9500);
                        handler.postDelayed(runnable3, 14500);
                        handler.postDelayed(runnable4, 20000);
                        handler.postDelayed(runnable5, 26300);
                        handler.postDelayed(runnable6, 32300);
                        handler.postDelayed(runnable7, 36500);
                        handler.postDelayed(runnable8, 40400);
                        handler.postDelayed(runnable9, 46900);
                        handler.postDelayed(runnable10, 49700);
                        handler.postDelayed(runnable11, 52800);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        cancelHiloMechanics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hiloExit.setEnabled(true);
                seekBar.setEnabled(true);
                hiloMechanics.setVisibility(View.VISIBLE);
                hiloMaskView.setVisibility(View.GONE);
                hiloMechanicsContent.setVisibility(View.GONE);
                if (betPoints < 1) {
                    higher.setEnabled(false);
                    lower.setEnabled(false);
                } else {
                    higher.setEnabled(true);
                    lower.setEnabled(true);
                }
                handler.removeCallbacks(runnable1);
                handler.removeCallbacks(runnable2);
                handler.removeCallbacks(runnable3);
                handler.removeCallbacks(runnable4);
                handler.removeCallbacks(runnable5);
                handler.removeCallbacks(runnable6);
                handler.removeCallbacks(runnable7);
                handler.removeCallbacks(runnable8);
                handler.removeCallbacks(runnable9);
                handler.removeCallbacks(runnable10);
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
            }
        });
    }

    @Override
    public void onStop()  {
        super.onStop();
        hiloExit.setEnabled(true);
        seekBar.setEnabled(true);
        hiloMechanics.setVisibility(View.VISIBLE);
        hiloMaskView.setVisibility(View.GONE);
        hiloMechanicsContent.setVisibility(View.GONE);
        if (betPoints < 1) {
            higher.setEnabled(false);
            lower.setEnabled(false);
        } else {
            higher.setEnabled(true);
            lower.setEnabled(true);
        }
        handler.removeCallbacks(runnable1);
        handler.removeCallbacks(runnable2);
        handler.removeCallbacks(runnable3);
        handler.removeCallbacks(runnable4);
        handler.removeCallbacks(runnable5);
        handler.removeCallbacks(runnable6);
        handler.removeCallbacks(runnable7);
        handler.removeCallbacks(runnable8);
        handler.removeCallbacks(runnable9);
        handler.removeCallbacks(runnable10);
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private int randomCardValue() {
        return random.nextInt(13)+1;
    }

    private String getRandomCardType() {
        String[] cardTypes = {"diamonds","clubs","hearts","spades"};
        return cardTypes[new Random().nextInt(cardTypes.length)];
    }

    private void firstCardReveal() {
        int value = randomCardValue();
        String cardType = getRandomCardType();
        String cardTypeValue = cardType + "_" + value;
        usedCardCombinations.add(cardTypeValue);
        int res = getResources().getIdentifier(cardTypeValue, "drawable", getPackageName());
        if (index == 1) {
            firstCard.setImageResource(res);
            currentValue = value;
            index = 2;
        }
    }

    private void revealCardHi() {
        int value;
        String cardType;
        String cardTypeValue;
        do {
            value = randomCardValue();
            cardType = getRandomCardType();
            cardTypeValue = cardType + "_" + value;
        } while (usedCardCombinations.contains(cardTypeValue));
        usedCardCombinations.add(cardTypeValue);
        int res = getResources().getIdentifier(cardTypeValue, "drawable", getPackageName());

        setCardImageAtIndex(index, res);

        if (currentValue < value) {
            remainingPoints += betPoints;
            remainingPointsText.setText("Points: " + remainingPoints);
        } else if (currentValue > value) {
            remainingPoints -= betPoints;
            if (remainingPoints < 1) {
                remainingPoints = 0;
                remainingPointsText.setText("Points: " + remainingPoints);
                higher.setEnabled(false);
                lower.setEnabled(false);
                seekBar.setEnabled(false);
                gameOver = true;
                handler.postDelayed(runnableDialog, 300);
            } else {
                remainingPointsText.setText("Points: " + remainingPoints);
            }
        } else {
            remainingPointsText.setText("Points: " + remainingPoints);
        }
        currentValue = value;
        index++;

        if (index == 10) {
            higher.setEnabled(false);
            lower.setEnabled(false);
            seekBar.setEnabled(false);
            gameOver = false;
            handler.postDelayed(runnableDialog, 300);
        }
    }

    private void revealCardLo() {
        int value;
        String cardType;
        String cardTypeValue;
        do {
            value = randomCardValue();
            cardType = getRandomCardType();
            cardTypeValue = cardType + "_" + value;
        } while (usedCardCombinations.contains(cardTypeValue));
        usedCardCombinations.add(cardTypeValue);
        int res = getResources().getIdentifier(cardTypeValue, "drawable", getPackageName());

        setCardImageAtIndex(index, res);

        if (currentValue > value) {
            remainingPoints += betPoints;
            remainingPointsText.setText("Points: " + remainingPoints);
        } else if (currentValue < value) {
            remainingPoints -= betPoints;
            if (remainingPoints < 1) {
                remainingPoints = 0;
                remainingPointsText.setText("Points: " + remainingPoints);
                higher.setEnabled(false);
                lower.setEnabled(false);
                seekBar.setEnabled(false);
                gameOver = true;
                handler.postDelayed(runnableDialog, 300);
            } else {

                remainingPointsText.setText("Points: " + remainingPoints);
            }
        } else {
            remainingPointsText.setText("Points: " + remainingPoints);
        }

        currentValue = value;
        index++;

        if (index == 10) {
            higher.setEnabled(false);
            lower.setEnabled(false);
            seekBar.setEnabled(false);
            gameOver = false;
            handler.postDelayed(runnableDialog, 300);
        }
    }

    private void setCardImageAtIndex(int index, int res) {
        switch (index) {
            case 2:
                secondCard.setImageResource(res);
                break;
            case 3:
                thirdCard.setImageResource(res);
                break;
            case 4:
                fourthCard.setImageResource(res);
                break;
            case 5:
                fifthCard.setImageResource(res);
                break;
            case 6:
                sixthCard.setImageResource(res);
                break;
            case 7:
                seventhCard.setImageResource(res);
                break;
            case 8:
                eighthCard.setImageResource(res);
                break;
            case 9:
                ninthCard.setImageResource(res);
                break;
        }
    }

    private void gameDialog() {
        View view = getLayoutInflater().inflate(R.layout.custom_popup_games, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view).setCancelable(false);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        LottieAnimationView gameResponseImg = view.findViewById(R.id.gameResponseImg);
        TextView gameResponseText = view.findViewById(R.id.gameResponseText);
        Button gameRestartBtn = view.findViewById(R.id.gameRestartBtn);
        Button gameExitBtn = view.findViewById(R.id.gameExitBtn);

        if (gameOver == true) {
            gameResponseImg.setAnimation(R.raw.sad_emoji);
            gameResponseText.setText("Sorry, you're short on points to continue the game");
            gameRestartBtn.setText("Restart");
            gameRestartBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();
                    higher.setEnabled(true);
                    lower.setEnabled(true);
                    seekBar.setEnabled(true);
                    index = 1;
                    currentValue = 0;
                    remainingPoints = 40;
                    seekBar.setMax(40);
                    seekBar.setProgress(0);
                    betPoints = 0;
                    betPointsText.setText(String.valueOf(0));
                    remainingPointsText.setText("Points: " + remainingPoints);
                    firstCardReveal();
                    usedCardCombinations.clear();
                    ImageView[] imageViews = {secondCard, thirdCard, fourthCard, fifthCard, sixthCard, seventhCard, eighthCard, ninthCard};
                    for (int i = 0; i < imageViews.length; i++) {
                        imageViews[i].setImageResource(getResources().getIdentifier("card_back", "drawable", getPackageName()));
                    }
                }
            });
        } else if (gameOver == false) {
            gameResponseImg.setAnimation(R.raw.happy_emoji);
            gameResponseText.setText("Congratulations on winning the game! Ready for another round?");
            gameRestartBtn.setText("Continue");
            gameRestartBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();
                    higher.setEnabled(true);
                    lower.setEnabled(true);
                    seekBar.setEnabled(true);
                    index = 1;
                    currentValue = 0;
                    int currentMax = seekBar.getMax();
                    seekBar.setMax(currentMax*2);
                    seekBar.setProgress(0);
                    betPoints = 0;
                    betPointsText.setText(String.valueOf(0));
                    firstCardReveal();
                    usedCardCombinations.clear();
                    ImageView[] imageViews = {secondCard, thirdCard, fourthCard, fifthCard, sixthCard, seventhCard, eighthCard, ninthCard};
                    for (int i = 0; i < imageViews.length; i++) {
                        imageViews[i].setImageResource(getResources().getIdentifier("card_back", "drawable", getPackageName()));
                    }
                }
            });

        }

        gameExitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                onBackPressed();
            }
        });
    }
}