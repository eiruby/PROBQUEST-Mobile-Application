package com.enverzo.probquest.ui.games;

import android.media.MediaPlayer;
import android.os.Bundle;
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

import androidx.fragment.app.Fragment;

import com.enverzo.probquest.R;

import java.util.ArrayList;
import java.util.List;

public class GamesFragment extends Fragment {
    private Button tutorialGames, tutorialCancel3;
    private TextView tutorialText3;
    private RelativeLayout tutorialContent3;
    private View maskView3;
    private ListView listViewGames;
    private String[] games = {"Worksheets", "Quiz Bee", "Roll Dice", "Color Roulette", "Higher or Lower", "Coin Flip"};
    private List<String> gameName = new ArrayList<>();
    private List<String> gameDesc = new ArrayList<>();
    private int[] gameImg = new int[games.length];
    private int[] gameBg = new int[games.length];
    private boolean[] gameBtn = new boolean[games.length];
    private Handler handler = new Handler();
    private Runnable runnable1, runnable2, runnable3, runnable4, runnable5, runnable6, runnable7, runnable8, runnable9, runnable10, runnable11, runnable12, runnable13, runnable14;
    private ImageView tutorialImage3;
    private MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_games, container, false);

        listViewGames = root.findViewById(R.id.listViewGames);
        tutorialGames = root.findViewById(R.id.tutorialGames);
        tutorialCancel3 = root.findViewById(R.id.tutorialCancel3);
        tutorialText3 = root.findViewById(R.id.tutorialText3);
        tutorialContent3 = root.findViewById(R.id.tutorialContent3);
        maskView3 = root.findViewById(R.id.maskView3);
        tutorialImage3 = root.findViewById(R.id.tutorialImage3);

        gameName.clear();
        gameDesc.clear();

        GamesAdapter gamesAdapter = new GamesAdapter(requireActivity(), gameName, gameDesc, gameImg, gameBg, gameBtn);
        listViewGames.setAdapter(gamesAdapter);
        ((GamesAdapter) listViewGames.getAdapter()).notifyDataSetChanged();

        String worksheetsDesc = "Engaging face-to-face activities for interactive learning";
        String quizBeeDesc = "Test your skills with quizzes ranging from easy to difficult levels";
        String rollDiceDesc = "Predict the total sum of two rolled dice";
        String colorRouletteDesc = "Spin a wheel to predict the color it will land on";
        String cardGuessDesc = "Bet on whether the next card is higher or lower than the last one";
        String coinTossDesc = "Flip a coin to get heads or tails results";

        String[] description = {worksheetsDesc, quizBeeDesc, rollDiceDesc, colorRouletteDesc, cardGuessDesc, coinTossDesc};
        int[] imgName = {R.drawable.game_1, R.drawable.game_2, R.drawable.game_3, R.drawable.game_4, R.drawable.game_5, R.drawable.game_6};
        int[] colorName = {R.color.topic1, R.color.topic2, R.color.topic3, R.color.topic4, R.color.topic5, R.color.topic6};

        for (int i = 0; i < games.length; i++) {
            gameName.add(games[i]);
            gameImg[i] = imgName[i];
            gameBg[i] = colorName[i];
            gameBtn[i] = true;
            gameDesc.add(description[i]);
        }

        tutorialGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation slideRight = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_right);
                Animation slideUp = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up);
                tutorialContent3.setVisibility(View.VISIBLE);
                maskView3.setVisibility(View.VISIBLE);
                tutorialText3.setAnimation(slideRight);
                tutorialImage3.setAnimation(slideUp);

                tutorialText3.setText("Welcome to the Games feature, where learning meets fun in six exciting ways!");
                tutorialImage3.setImageResource(R.drawable.female_teacher3);

                for (int i = 0; i < games.length; i++) {
                    gameBtn[i] = false;
                }
                gamesAdapter.notifyDataSetChanged();

                tutorialGames.setEnabled(false);

                slideUp.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.tutorial_games);
                        mediaPlayer.start();
                        handler.postDelayed(runnable1, 5200);
                        handler.postDelayed(runnable2, 7400);
                        handler.postDelayed(runnable3, 12400);
                        handler.postDelayed(runnable4, 15800);
                        handler.postDelayed(runnable5, 20900);
                        handler.postDelayed(runnable6, 24000);
                        handler.postDelayed(runnable7, 28200);
                        handler.postDelayed(runnable8, 30300);
                        handler.postDelayed(runnable9, 33900);
                        handler.postDelayed(runnable10, 41000);
                        handler.postDelayed(runnable11, 46250);
                        handler.postDelayed(runnable12, 50800);
                        handler.postDelayed(runnable13, 56500);
                        handler.postDelayed(runnable14, 60000);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        runnable1 = new Runnable() {
            @Override
            public void run() {
                tutorialText3.setText("First off, we have Worksheets,");
                tutorialImage3.setImageResource(R.drawable.female_teacher2);
            }
        };

        runnable2 = new Runnable() {
            @Override
            public void run() {
                tutorialText3.setText("providing printable worksheets that you can save as PDFs for class engagement.");
            }
        };

        runnable3 = new Runnable() {
            @Override
            public void run() {
                tutorialText3.setText("Next, tests your wits with Quiz Bee,");
            }
        };

        runnable4 = new Runnable() {
            @Override
            public void run() {
                tutorialText3.setText("a probability quiz spanning easy, average, and difficult levels.");
            }
        };

        runnable5 = new Runnable() {
            @Override
            public void run() {
                tutorialText3.setText("For a dose of excitement, try Roll Dice,");
            }
        };

        runnable6 = new Runnable() {
            @Override
            public void run() {
                tutorialText3.setText("where you'll roll two dice and predict the total sum of their roll.");
            }
        };

        runnable7 = new Runnable() {
            @Override
            public void run() {
                tutorialText3.setText("Try your luck with Color Roulette,");
            }
        };

        runnable8 = new Runnable() {
            @Override
            public void run() {
                tutorialText3.setText("where you'll spin a wheel and predict the color it will land on.");
            }
        };

        runnable9 = new Runnable() {
            @Override
            public void run() {
                tutorialText3.setText("Then, bet on whether the next card drawn will be higher or lower than the last card with Higher or Lower.");
            }
        };

        runnable10 = new Runnable() {
            @Override
            public void run() {
                tutorialText3.setText("Lastly, produce random heads or tails results with the Coin Flip simulator.");
            }
        };

        runnable11 = new Runnable() {
            @Override
            public void run() {
                tutorialText3.setText("Simply click on the 'Play' button of your preferred game to start playing.");
                tutorialImage3.setImageResource(R.drawable.female_teacher1);
            }
        };

        runnable12 = new Runnable() {
            @Override
            public void run() {
                tutorialText3.setText("These games will not only build your probability skills but also have a blast while doing so.");
            }
        };

        runnable13 = new Runnable() {
            @Override
            public void run() {
                tutorialText3.setText("Have fun and enjoy the games!");
                tutorialImage3.setImageResource(R.drawable.female_teacher4);
            }
        };

        runnable14 = new Runnable() {
            @Override
            public void run() {
                tutorialContent3.setVisibility(View.GONE);
                maskView3.setVisibility(View.GONE);
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
                for (int i = 0; i < games.length; i++) {
                    gameBtn[i] = true;
                }
                gamesAdapter.notifyDataSetChanged();
                tutorialGames.setEnabled(true);
            }
        };

        tutorialCancel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tutorialContent3.setVisibility(View.GONE);
                maskView3.setVisibility(View.GONE);
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
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
                handler.removeCallbacks(runnable11);
                handler.removeCallbacks(runnable12);
                for (int i = 0; i < games.length; i++) {
                    gameBtn[i] = true;
                }
                gamesAdapter.notifyDataSetChanged();
                tutorialGames.setEnabled(true);
            }
        });

        return root;
    }
    @Override
    public void onStop()  {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
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
        handler.removeCallbacks(runnable11);
        handler.removeCallbacks(runnable12);
    }
}
