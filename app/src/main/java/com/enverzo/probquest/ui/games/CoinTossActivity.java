package com.enverzo.probquest.ui.games;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
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
import android.widget.TextView;

import com.enverzo.probquest.R;

import java.util.Random;

public class CoinTossActivity extends AppCompatActivity {

    private ImageView coinTossExit, coin, coinMechanicsImage;
    private TextView headsText, flipsText, tailsText, noHeads, noTails, coinMechanicsText;
    private Button resetData, flipBtn, coinMechanics, cancelCoinMechanics;
    private View coinMaskView;
    private RelativeLayout coinMechanicsContent;
    private int numHeads, numFlips, numTails, side, headPercentage, tailPercentage;
    private Random random = new Random();
    private Runnable runnable1, runnable2, runnable3, runnable4, runnable5, runnable6, runnable7;
    private Handler handler;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_toss);

        coinTossExit = findViewById(R.id.coinTossExit);
        coin = findViewById(R.id.coin);
        headsText = findViewById(R.id.headsText);
        flipsText = findViewById(R.id.flipsText);
        tailsText = findViewById(R.id.tailsText);
        noHeads = findViewById(R.id.noHeads);
        noTails = findViewById(R.id.noTails);
        resetData = findViewById(R.id.resetData);
        flipBtn = findViewById(R.id.flipBtn);
        coinMechanics = findViewById(R.id.coinMechanics);
        cancelCoinMechanics = findViewById(R.id.cancelCoinMechanics);
        coinMechanicsText = findViewById(R.id.coinMechanicsText);
        coinMechanicsImage = findViewById(R.id.coinMechanicsImage);
        coinMechanicsContent = findViewById(R.id.coinMechanicsContent);
        coinMaskView = findViewById(R.id.coinMaskView);

        handler = new Handler(Looper.getMainLooper());

        coinTossExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        resetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipsText.setText(String.valueOf(0));
                numFlips = 0;
                numHeads = 0;
                numTails = 0;
                headPercentage = 0;
                tailPercentage = 0;
                headsText.setText(headPercentage + "%");
                tailsText.setText(tailPercentage + "%");
                noHeads.setText(numHeads + " Heads");
                noTails.setText(numTails + " Tails");
            }
        });

        flipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                side = random.nextInt(2);
                flipCoin();
                flipBtn.setEnabled(false);
                resetData.setEnabled(false);
            }
        });

        runnable1 = new Runnable() {
            @Override
            public void run() {
                coinMechanicsText.setText("This game simulates a head or tail coin toss.");
            }
        };

        runnable2 = new Runnable() {
            @Override
            public void run() {
                coinMechanicsText.setText("To make an instant random decision, simply click the 'Flip' button to flip the coin.");
                coinMechanicsImage.setImageResource(R.drawable.male_teacher3);
            }
        };

        runnable3 = new Runnable() {
            @Override
            public void run() {
                coinMechanicsText.setText("The screen will display whether the result is heads or tails.");
            }
        };

        runnable4 = new Runnable() {
            @Override
            public void run() {
                coinMechanicsText.setText("Additionally, it will show the total number of flips,");
            }
        };

        runnable5 = new Runnable() {
            @Override
            public void run() {
                coinMechanicsText.setText("as well as the number and percentages of heads and tails.");
            }
        };

        runnable6 = new Runnable() {
            @Override
            public void run() {
                coinMechanicsText.setText("Good luck, and enjoy the game!");
                coinMechanicsImage.setImageResource(R.drawable.male_teacher2);
            }
        };

        runnable7 = new Runnable() {
            @Override
            public void run() {
                coinTossExit.setEnabled(true);
                resetData.setEnabled(true);
                flipBtn.setEnabled(true);
                coinMechanics.setVisibility(View.VISIBLE);
                coinMaskView.setVisibility(View.GONE);
                coinMechanicsContent.setVisibility(View.GONE);
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
            }
        };

        coinMechanics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coinTossExit.setEnabled(false);
                resetData.setEnabled(false);
                flipBtn.setEnabled(false);
                coinMechanics.setVisibility(View.INVISIBLE);
                coinMaskView.setVisibility(View.VISIBLE);
                coinMechanicsContent.setVisibility(View.VISIBLE);

                Animation slideRight = AnimationUtils.loadAnimation(CoinTossActivity.this, R.anim.slide_right);
                Animation slideUp = AnimationUtils.loadAnimation(CoinTossActivity.this, R.anim.slide_up);
                coinMechanicsText.setAnimation(slideRight);
                coinMechanicsImage.setAnimation(slideUp);

                coinMechanicsText.setText("Welcome to the Coin Flip game! Here’s how you can play:");
                coinMechanicsImage.setImageResource(R.drawable.male_teacher2);

                slideUp.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mediaPlayer = MediaPlayer.create(CoinTossActivity.this, R.raw.tut_coin_flip);
                        mediaPlayer.start();
                        handler.postDelayed(runnable1, 5400);
                        handler.postDelayed(runnable2, 8900);
                        handler.postDelayed(runnable3, 14300);
                        handler.postDelayed(runnable4, 18100);
                        handler.postDelayed(runnable5, 20950);
                        handler.postDelayed(runnable6, 24700);
                        handler.postDelayed(runnable7, 27000);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        cancelCoinMechanics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coinTossExit.setEnabled(true);
                resetData.setEnabled(true);
                flipBtn.setEnabled(true);
                coinMechanics.setVisibility(View.VISIBLE);
                coinMaskView.setVisibility(View.GONE);
                coinMechanicsContent.setVisibility(View.GONE);
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
    public void onStop()  {
        super.onStop();
        coinTossExit.setEnabled(true);
        resetData.setEnabled(true);
        flipBtn.setEnabled(true);
        coinMechanics.setVisibility(View.VISIBLE);
        coinMaskView.setVisibility(View.GONE);
        coinMechanicsContent.setVisibility(View.GONE);
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

    private void flipCoin() {
        coin.animate()
            .setDuration(1000)
            .rotationYBy(1800f)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(@NonNull Animator animator) {
                        coin.setClickable(false);
                    }

                    @Override
                    public void onAnimationEnd(@NonNull Animator animator) {
                        numFlips += 1;
                        flipsText.setText(String.valueOf(numFlips));

                        if (side == 0) {
                            coin.setImageResource(R.drawable.head);
                            numHeads += 1;
                            noHeads.setText(numHeads + " Heads");
                        } else if (side == 1) {
                            coin.setImageResource(R.drawable.tail);
                            numTails += 1;
                            noTails.setText(numTails + " Tails");
                        }

                        headPercentage = Math.round(((float) numHeads / numFlips) * 100);
                        headsText.setText(String.valueOf(headPercentage) + "%");

                        tailPercentage = Math.round(((float) numTails / numFlips) * 100);
                        tailsText.setText(String.valueOf(tailPercentage) + "%");

                        flipBtn.setEnabled(true);
                        resetData.setEnabled(true);
                    }

                    @Override
                    public void onAnimationCancel(@NonNull Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(@NonNull Animator animator) {

                    }
                });
    }
}