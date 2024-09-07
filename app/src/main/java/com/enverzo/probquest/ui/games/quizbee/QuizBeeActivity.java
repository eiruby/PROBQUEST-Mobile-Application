package com.enverzo.probquest.ui.games.quizbee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.enverzo.probquest.DBHandler;
import com.enverzo.probquest.R;

import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

public class QuizBeeActivity extends AppCompatActivity {
    private Button quizMechanics, cancelQuizMechanics, easyPuzzles, mediumPuzzles, hardPuzzles, easySubmit, mediumSubmit, hardSubmit, scoreTryAgain, scoreExit;
    private TextView quizMechanicsText, easyTimer, easyQuestion, easySolvedProblems, mediumTimer, mediumQuestion, mediumSolvedProblems, hardTimer, hardQuestion, hardSolvedProblems, scoreHeader, scoreTextView;
    private ImageView puzzlesExit, quizMechanicsImage, puzzleMusic, easyExit, easyImage, mediumExit, mediumImage, hardExit, hardImage;
    private EditText easyInput, mediumInput, hardInput;
    private MediaPlayer puzzleBgMusic, mediaPlayer, buttonSound, correctSound, wrongSound, timerSound;
    private RelativeLayout homeLayout, quizMechanicsContent, easyLayout, mediumLayout, hardLayout, scoreLayout;
    private View quizMaskView;
    private boolean isGameOngoing = false;
    private boolean musicPlaying = true;
    private boolean timerRunning, easySelected, mediumSelected, hardSelected;
    private int currentProblemIndex, solved, randomIndex, wrongTimesUp;
    private static final long COUNTDOWN_IN_MILLIS_EASY = 61000, COUNTDOWN_IN_MILLIS_MEDIUM = 121000, COUNTDOWN_IN_MILLIS_HARD = 181000;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    private EasyProblems easyProblems = new EasyProblems();
    private int easyProblemLength = easyProblems.problems.length;
    private MediumProblems mediumProblems = new MediumProblems();
    private int mediumProblemLength = mediumProblems.problems.length;
    private HardProblems hardProblems = new HardProblems();
    private int hardProblemLength = hardProblems.problems.length;
    private String easyAnswer, mediumAnswer, hardAnswer;
    private Set<Integer> shownProblemIndices = new HashSet<>();
    private Runnable runnable1, runnable2, runnable3, runnable4, runnable5, runnable6, runnable7, runnable8, runnable9, runnable10, runnable11, runnable12;
    private Handler handler;
    Random random = new Random();
    private Cursor cursor;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzles);

        easyPuzzles = findViewById(R.id.easyPuzzles);
        mediumPuzzles = findViewById(R.id.mediumPuzzles);
        hardPuzzles = findViewById(R.id.hardPuzzles);
        puzzlesExit = findViewById(R.id.puzzlesExit);
        puzzleMusic = findViewById(R.id.puzzleMusic);
        homeLayout = findViewById(R.id.homeLayout);
        easyLayout = findViewById(R.id.easyLayout);
        easyExit = findViewById(R.id.easyExit);
        easySolvedProblems = findViewById(R.id.easySolvedProblems);
        easyTimer = findViewById(R.id.easyTimer);
        easyQuestion = findViewById(R.id.easyQuestion);
        easyImage = findViewById(R.id.easyImage);
        easyInput = findViewById(R.id.easyInput);
        easySubmit = findViewById(R.id.easySubmit);
        mediumLayout = findViewById(R.id.mediumLayout);
        mediumExit = findViewById(R.id.mediumExit);
        mediumSolvedProblems = findViewById(R.id.mediumSolvedProblems);
        mediumTimer = findViewById(R.id.mediumTimer);
        mediumQuestion = findViewById(R.id.mediumQuestion);
        mediumImage = findViewById(R.id.mediumImage);
        mediumInput = findViewById(R.id.mediumInput);
        mediumSubmit = findViewById(R.id.mediumSubmit);
        hardLayout = findViewById(R.id.hardLayout);
        hardExit = findViewById(R.id.hardExit);
        hardSolvedProblems = findViewById(R.id.hardSolvedProblems);
        hardTimer = findViewById(R.id.hardTimer);
        hardQuestion = findViewById(R.id.hardQuestion);
        hardImage = findViewById(R.id.hardImage);
        hardInput = findViewById(R.id.hardInput);
        hardSubmit = findViewById(R.id.hardSubmit);
        scoreLayout = findViewById(R.id.scoreLayout);
        scoreHeader = findViewById(R.id.scoreHeader);
        scoreTextView = findViewById(R.id.scoreTextView);
        scoreTryAgain = findViewById(R.id.scoreTryAgain);
        scoreExit = findViewById(R.id.scoreExit);
        quizMechanics = findViewById(R.id.quizMechanics);
        cancelQuizMechanics = findViewById(R.id.cancelQuizMechanics);
        quizMechanicsText = findViewById(R.id.quizMechanicsText);
        quizMechanicsImage = findViewById(R.id.quizMechanicsImage);
        quizMechanicsContent = findViewById(R.id.quizMechanicsContent);
        quizMaskView = findViewById(R.id.quizMaskView);

        buttonSound = MediaPlayer.create(QuizBeeActivity.this, R.raw.button_sound);
        puzzleBgMusic = MediaPlayer.create(QuizBeeActivity.this, R.raw.puzzle_music);
        puzzleBgMusic.setLooping(true);
        puzzleBgMusic.start();

        handler = new Handler();
        dbHandler = new DBHandler(this);

        puzzlesExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        puzzleMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 buttonSound.start();
                if (musicPlaying) {
                    puzzleMusic.setImageResource(R.drawable.baseline_volume_off_24);
                    musicPlaying = false;
                    puzzleBgMusic.pause();
                } else {
                    musicPlaying = true;
                    puzzleMusic.setImageResource(R.drawable.baseline_volume_up_24);
                    puzzleBgMusic.start();
                }
            }
        });

        easyPuzzles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSound.start();
                homeLayout.setVisibility(View.GONE);
                easyLayout.setVisibility(View.VISIBLE);
                
                isGameOngoing = true;
                easySelected = true;
                mediumSelected = false;
                hardSelected = false;
                solved = 0;
                currentProblemIndex = 0;
                easyInput.setText("");

                easyNextQuestion();
            }
        });

        easyExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSound.start();
                onBackPressed();
            }
        });

        easySubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSound.start();
                String easyEnteredAnswer = easyInput.getText().toString();
                isGameOngoing = false;

                if (easyEnteredAnswer.equals(easyAnswer)) {
                    solved++;
                    showCorrectDialog();
                } else if (easyEnteredAnswer.isEmpty() || easyEnteredAnswer != easyAnswer) {
                    wrongTimesUp = 1;
                    showWrongDialog();
                }

                countDownTimer.cancel();
            }
        });

        mediumPuzzles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSound.start();
                homeLayout.setVisibility(View.GONE);
                mediumLayout.setVisibility(View.VISIBLE);

                isGameOngoing = true;
                mediumSelected = true;
                easySelected = false;
                hardSelected = false;
                solved = 0;
                currentProblemIndex = 0;
                mediumInput.setText("");

                mediumNextQuestion();
            }
        });

        mediumExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSound.start();
                onBackPressed();
            }
        });

        mediumSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSound.start();
                String mediumEnteredAnswer = mediumInput.getText().toString();
                isGameOngoing = false;

                if (mediumEnteredAnswer.equals(mediumAnswer)) {
                    solved++;
                    showCorrectDialog();
                } else if (mediumEnteredAnswer.isEmpty() || mediumEnteredAnswer != mediumAnswer) {
                    wrongTimesUp = 1;
                    showWrongDialog();
                }

                countDownTimer.cancel();
            }
        });

        hardPuzzles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSound.start();
                homeLayout.setVisibility(View.GONE);
                hardLayout.setVisibility(View.VISIBLE);

                isGameOngoing = true;
                easySelected = false;
                mediumSelected = false;
                hardSelected = true;
                solved = 0;
                currentProblemIndex = 0;
                hardInput.setText("");

                hardNextQuestion();
            }
        });

        hardExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSound.start();
                onBackPressed();
            }
        });

        hardSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSound.start();
                String hardEnteredAnswer = hardInput.getText().toString();
                isGameOngoing = false;

                if (hardEnteredAnswer.equals(hardAnswer)) {
                    solved++;
                    showCorrectDialog();
                } else if (hardEnteredAnswer.isEmpty() || hardEnteredAnswer != hardAnswer) {
                    wrongTimesUp = 1;
                    showWrongDialog();
                }

                countDownTimer.cancel();
            }
        });

        scoreTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSound.start();
                scoreLayout.setVisibility(View.GONE);
                if (easySelected) {
                    easyLayout.setVisibility(View.VISIBLE);
                    isGameOngoing = true;
                    easySelected = true;
                    mediumSelected = false;
                    hardSelected = false;
                    solved = 0;
                    currentProblemIndex = 0;
                    easyInput.setText("");
                    easyNextQuestion();
                } else if (mediumSelected) {
                    mediumLayout.setVisibility(View.VISIBLE);
                    isGameOngoing = true;
                    easySelected = false;
                    mediumSelected = true;
                    hardSelected = false;
                    solved = 0;
                    currentProblemIndex = 0;
                    mediumInput.setText("");
                    mediumNextQuestion();
                } else if (hardSelected) {
                    hardLayout.setVisibility(View.VISIBLE);
                    isGameOngoing = true;
                    easySelected = false;
                    mediumSelected = false;
                    hardSelected = true;
                    solved = 0;
                    currentProblemIndex = 0;
                    hardInput.setText("");
                    hardNextQuestion();
                }
            }
        });

        scoreExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSound.start();
                homeLayout.setVisibility(View.VISIBLE);
                easyLayout.setVisibility(View.GONE);
                mediumLayout.setVisibility(View.GONE);
                hardLayout.setVisibility(View.GONE);
                scoreLayout.setVisibility(View.GONE);
            }
        });

        runnable1 = new Runnable() {
            @Override
            public void run() {
                quizMechanicsText.setText("Each level consists of 10 probability quiz items,");
                quizMechanicsImage.setImageResource(R.drawable.female_teacher2);
            }
        };

        runnable2 = new Runnable() {
            @Override
            public void run() {
                quizMechanicsText.setText("with 1 minute for the easy level, 2 minutes for the average level,");
            }
        };

        runnable3 = new Runnable() {
            @Override
            public void run() {
                quizMechanicsText.setText("and 3 minutes for the difficult level to complete and submit your answers.");
            }
        };

        runnable4 = new Runnable() {
            @Override
            public void run() {
                quizMechanicsText.setText("For each question, you must write your answer in the form of a fraction or whole number in its simplest form.");
                quizMechanicsImage.setImageResource(R.drawable.female_teacher4);
            }
        };

        runnable5 = new Runnable() {
            @Override
            public void run() {
                quizMechanicsText.setText("Upon submission, I will immediately evaluate your answer.");
            }
        };

        runnable6 = new Runnable() {
            @Override
            public void run() {
                quizMechanicsText.setText("Correct answers earn points, while incorrect answers earn no points.");
            }
        };

        runnable7 = new Runnable() {
            @Override
            public void run() {
                quizMechanicsText.setText("If you fail to submit your answer within the time limit or provide an incorrect response,");
            }
        };

        runnable8 = new Runnable() {
            @Override
            public void run() {
                quizMechanicsText.setText("you’ll have the option to retry the question.");
            }
        };

        runnable9 = new Runnable() {
            @Override
            public void run() {
                quizMechanicsText.setText("Once you’ve completed all 10 items in a level, I’ll compute and display your total score.");
                quizMechanicsImage.setImageResource(R.drawable.female_teacher3);
            }
        };

        runnable10 = new Runnable() {
            @Override
            public void run() {
                quizMechanicsText.setText("You can then choose to retry the game if you wish.");
            }
        };

        runnable11 = new Runnable() {
            @Override
            public void run() {
                quizMechanicsText.setText("Good luck, and enjoy the Quiz Bee!");
                quizMechanicsImage.setImageResource(R.drawable.female_teacher4);
            }
        };

        runnable12 = new Runnable() {
            @Override
            public void run() {
                puzzlesExit.setEnabled(true);
                Button[] buttons = {easyPuzzles, mediumPuzzles, hardPuzzles};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                }
                quizMechanics.setVisibility(View.VISIBLE);
                quizMaskView.setVisibility(View.GONE);
                quizMechanicsContent.setVisibility(View.GONE);
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
            }
        };

        quizMechanics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                puzzlesExit.setEnabled(false);
                Button[] buttons = {easyPuzzles, mediumPuzzles, hardPuzzles};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(false);
                }
                quizMechanics.setVisibility(View.INVISIBLE);
                quizMaskView.setVisibility(View.VISIBLE);
                quizMechanicsContent.setVisibility(View.VISIBLE);

                Animation slideRight = AnimationUtils.loadAnimation(QuizBeeActivity.this, R.anim.slide_right);
                Animation slideUp = AnimationUtils.loadAnimation(QuizBeeActivity.this, R.anim.slide_up);
                quizMechanicsText.setAnimation(slideRight);
                quizMechanicsImage.setAnimation(slideUp);

                quizMechanicsText.setText("Welcome to the Quiz Bee game! Here’s how you can play:");
                quizMechanicsImage.setImageResource(R.drawable.female_teacher4);

                slideUp.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mediaPlayer = MediaPlayer.create(QuizBeeActivity.this, R.raw.tut_quiz_bee);
                        mediaPlayer.start();
                        handler.postDelayed(runnable1, 3300);
                        handler.postDelayed(runnable2, 6800);
                        handler.postDelayed(runnable3, 10700);
                        handler.postDelayed(runnable4, 15200);
                        handler.postDelayed(runnable5, 22200);
                        handler.postDelayed(runnable6, 26500);
                        handler.postDelayed(runnable7, 32050);
                        handler.postDelayed(runnable8, 37900);
                        handler.postDelayed(runnable9, 41000);
                        handler.postDelayed(runnable10, 47300);
                        handler.postDelayed(runnable11, 50700);
                        handler.postDelayed(runnable12, 54000);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        cancelQuizMechanics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                puzzlesExit.setEnabled(true);
                quizMechanics.setVisibility(View.VISIBLE);
                quizMaskView.setVisibility(View.GONE);
                quizMechanicsContent.setVisibility(View.GONE);
                Button[] buttons = {easyPuzzles, mediumPuzzles, hardPuzzles};
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
                handler.removeCallbacks(runnable8);
                handler.removeCallbacks(runnable9);
                handler.removeCallbacks(runnable10);
                handler.removeCallbacks(runnable11);
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (isGameOngoing) {
            showExitDialog();
        } else {
            if (puzzleBgMusic != null) {
                puzzleBgMusic.stop();
                puzzleBgMusic.release();
                puzzleBgMusic = null;
            }
            if (buttonSound != null) {
                buttonSound.stop();
                buttonSound.release();
                buttonSound = null;
            }
            if (correctSound != null) {
                correctSound.stop();
                correctSound.release();
                correctSound = null;
            }
            if (wrongSound != null) {
                wrongSound.stop();
                wrongSound.release();
                wrongSound = null;
            }
            if (timerSound != null) {
                timerSound.stop();
                timerSound.release();
                timerSound = null;
            }
            super.onBackPressed();
        }
    }

    private void showExitDialog() {
        View view = getLayoutInflater().inflate(R.layout.custom_exit_dialog, null);
        Button yesButton = view.findViewById(R.id.yesButton);
        Button noButton = view.findViewById(R.id.noButton);

        AlertDialog.Builder builder = new AlertDialog.Builder(this) ;
        builder.setView(view).setCancelable(false);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        countDownTimer.cancel();

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSound.start();
                alertDialog.dismiss();
                homeLayout.setVisibility(View.VISIBLE);
                shownProblemIndices.clear();
                isGameOngoing = false;

                if (easySelected) {
                    easyLayout.setVisibility(View.GONE);
                    easyInput.setText("");
                    easySelected = false;
                } else if (mediumSelected) {
                    mediumLayout.setVisibility(View.GONE);
                    mediumInput.setText("");
                    mediumSelected = false;
                } else if (hardSelected) {
                    hardLayout.setVisibility(View.GONE);
                    hardInput.setText("");
                    hardSelected = false;
                }
            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSound.start();
                alertDialog.dismiss();
                if (isGameOngoing) {
                    startCountDown();
                } else {
                    isGameOngoing = true;
                    currentProblemIndex++;

                    if (easySelected) {
                        if (currentProblemIndex < easyProblemLength) {
                            easyNextQuestion();
                            easySolvedProblems.setText("Solved: " + solved + "/" + easyProblemLength);
                            easyInput.setText("");
                        } else {
                            countDownTimer.cancel();
                            showScore();
                        }
                    } else if (mediumSelected) {
                        if (currentProblemIndex < mediumProblemLength) {
                            mediumNextQuestion();
                            mediumSolvedProblems.setText("Solved: " + solved + "/" + mediumProblemLength);
                            mediumInput.setText("");
                        } else {
                            countDownTimer.cancel();
                            showScore();
                        }
                    } else if (hardSelected) {
                        if (currentProblemIndex < hardProblemLength) {
                            hardNextQuestion();
                            hardSolvedProblems.setText("Solved: " + solved + "/" + hardProblemLength);
                            hardInput.setText("");
                        } else {
                            countDownTimer.cancel();
                            showScore();
                        }
                    }
                }
            }
        });
    }

    private void easyNextQuestion() {
        do {
            randomIndex = random.nextInt(easyProblemLength);
        } while (shownProblemIndices.contains(randomIndex));

        shownProblemIndices.add(randomIndex);

        if (shownProblemIndices.size() == easyProblemLength) {
            shownProblemIndices.clear();
        }

        easySolvedProblems.setText("Solved: " + solved + "/" + easyProblemLength);
        
        easyQuestion.setText(easyProblems.getProblem(randomIndex));
        easyImage.setImageResource(getResources().getIdentifier(easyProblems.getImageName(randomIndex), "drawable", getPackageName()));
        easyAnswer = easyProblems.getCorrectAnswer(randomIndex);

        timeLeftInMillis = COUNTDOWN_IN_MILLIS_EASY;
        startCountDown();
    }

    private void mediumNextQuestion() {
        do {
            randomIndex = random.nextInt(mediumProblemLength);
        } while (shownProblemIndices.contains(randomIndex));

        shownProblemIndices.add(randomIndex);

        if (shownProblemIndices.size() == mediumProblemLength) {
            shownProblemIndices.clear();
        }

        mediumSolvedProblems.setText("Solved: " + solved + "/" + mediumProblemLength);

        mediumQuestion.setText(mediumProblems.getProblem(randomIndex));
        mediumImage.setImageResource(getResources().getIdentifier(mediumProblems.getImageName(randomIndex), "drawable", getPackageName()));
        mediumAnswer = mediumProblems.getCorrectAnswer(randomIndex);

        timeLeftInMillis = COUNTDOWN_IN_MILLIS_MEDIUM;
        startCountDown();
    }

    private void hardNextQuestion() {
        do {
            randomIndex = random.nextInt(hardProblemLength);
        } while (shownProblemIndices.contains(randomIndex));

        shownProblemIndices.add(randomIndex);

        if (shownProblemIndices.size() == hardProblemLength) {
            shownProblemIndices.clear();
        }

        hardSolvedProblems.setText("Solved: " + solved + "/" + hardProblemLength);

        hardQuestion.setText(hardProblems.getProblem(randomIndex));
        hardImage.setImageResource(getResources().getIdentifier(hardProblems.getImageName(randomIndex), "drawable", getPackageName()));
        hardAnswer = hardProblems.getCorrectAnswer(randomIndex);

        timeLeftInMillis = COUNTDOWN_IN_MILLIS_HARD;
        startCountDown();
    }

    private void startCountDown() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        countDownTimer = new CountDownTimer(timeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                wrongTimesUp = 2;
                updateCountDownText();
                showWrongDialog();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis/1000) /60;
        int seconds = (int) (timeLeftInMillis/1000) %60;

        String timerFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
        easyTimer.setText(timerFormatted);
        mediumTimer.setText(timerFormatted);
        hardTimer.setText(timerFormatted);

        if (timeLeftInMillis < 11000) {
            easyTimer.setTextColor(Color.RED);
            mediumTimer.setTextColor(Color.RED);
            hardTimer.setTextColor(Color.RED);

            if (timerSound == null) {
                timerSound = MediaPlayer.create(QuizBeeActivity.this, R.raw.timer_sound);
                timerSound.start();
            }
        } else if (timeLeftInMillis == 0000) {
            timerSound.stop();
        }else {
            easyTimer.setTextColor(Color.WHITE);
            mediumTimer.setTextColor(Color.WHITE);
            hardTimer.setTextColor(Color.WHITE);
        }
    }

    private void showCorrectDialog() {
        View view = getLayoutInflater().inflate(R.layout.custom_response, null);
        LottieAnimationView happyEmoji = view.findViewById(R.id.responseImage);
        TextView correctText = view.findViewById(R.id.responseText);
        Button tryAgainButton = view.findViewById(R.id.tryAgainButton);
        Button nextButton = view.findViewById(R.id.nextButton);
        Button exitButton = view.findViewById(R.id.exitButton);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view).setCancelable(false);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        happyEmoji.setAnimation(R.raw.happy_emoji);
        correctText.setText("CORRECT!");
        correctText.setTextColor(getResources().getColor(R.color.correct));
        tryAgainButton.setVisibility(View.GONE);

        correctSound = MediaPlayer.create(QuizBeeActivity.this, R.raw.correct_sound);
        correctSound.start();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSound.start();
                alertDialog.dismiss();
                isGameOngoing = true;
                currentProblemIndex++;

                if (easySelected) {
                    if (currentProblemIndex < easyProblemLength) {
                        easyNextQuestion();
                        easySolvedProblems.setText("Solved: " + solved + "/" + easyProblemLength);
                        easyInput.setText("");
                    } else {
                        countDownTimer.cancel();
                        showScore();
                    }
                } else if (mediumSelected) {
                    if (currentProblemIndex < mediumProblemLength) {
                        mediumNextQuestion();
                        mediumSolvedProblems.setText("Solved: " + solved + "/" + mediumProblemLength);
                        mediumInput.setText("");
                    } else {
                        countDownTimer.cancel();
                        showScore();
                    }
                } else if (hardSelected) {
                    if (currentProblemIndex < hardProblemLength) {
                        hardNextQuestion();
                        hardSolvedProblems.setText("Solved: " + solved + "/" + hardProblemLength);
                        hardInput.setText("");
                    } else {
                        countDownTimer.cancel();
                        showScore();
                    }
                }
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSound.start();
                alertDialog.dismiss();
                showExitDialog();
            }
        });
    }

    private void showWrongDialog() {
        View view = getLayoutInflater().inflate(R.layout.custom_response, null);
        LottieAnimationView sadEmoji = view.findViewById(R.id.responseImage);
        TextView wrongText = view.findViewById(R.id.responseText);
        Button tryAgainButton = view.findViewById(R.id.tryAgainButton);
        Button nextButton = view.findViewById(R.id.nextButton);
        Button exitButton = view.findViewById(R.id.exitButton);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view).setCancelable(false);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        sadEmoji.setAnimation(R.raw.sad_emoji);
        if (wrongTimesUp == 1) {
            wrongText.setText("NICE TRY!");
        } else if (wrongTimesUp == 2) {
            wrongText.setText("TIME'S UP!");
        }
        wrongText.setTextColor(getResources().getColor(R.color.wrong));
        tryAgainButton.setVisibility(View.VISIBLE);

        wrongSound = MediaPlayer.create(QuizBeeActivity.this, R.raw.wrong_sound);
        wrongSound.start();

        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSound.start();
                alertDialog.dismiss();
                isGameOngoing = true;
                if (easySelected) {
                    timeLeftInMillis = COUNTDOWN_IN_MILLIS_EASY;
                } else if (mediumSelected) {
                    timeLeftInMillis = COUNTDOWN_IN_MILLIS_MEDIUM;
                } else if (hardSelected) {
                    timeLeftInMillis = COUNTDOWN_IN_MILLIS_HARD;
                }
                startCountDown();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSound.start();
                alertDialog.dismiss();
                isGameOngoing = true;
                currentProblemIndex++;

                if (easySelected) {
                    if (currentProblemIndex < easyProblemLength) {
                        easyNextQuestion();
                        easySolvedProblems.setText("Solved: " + solved + "/" + easyProblemLength);
                        easyInput.setText("");
                    } else {
                        countDownTimer.cancel();
                        showScore();
                    }
                } else if (mediumSelected) {
                    if (currentProblemIndex < mediumProblemLength) {
                        mediumNextQuestion();
                        mediumSolvedProblems.setText("Solved: " + solved + "/" + mediumProblemLength);
                        mediumInput.setText("");
                    } else {
                        countDownTimer.cancel();
                        showScore();
                    }
                } else if (hardSelected) {
                    if (currentProblemIndex < hardProblemLength) {
                        hardNextQuestion();
                        hardSolvedProblems.setText("Solved: " + solved + "/" + hardProblemLength);
                        hardInput.setText("");
                    } else {
                        countDownTimer.cancel();
                        showScore();
                    }
                }
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSound.start();
                alertDialog.dismiss();
                showExitDialog();
            }
        });
    }

    private void showScore() {
        easyLayout.setVisibility(View.GONE);
        mediumLayout.setVisibility(View.GONE);
        hardLayout.setVisibility(View.GONE);
        scoreLayout.setVisibility(View.VISIBLE);
        isGameOngoing = false;
        if (easySelected) {
            scoreHeader.setText("Easy Level Complete!");
            scoreTextView.setText("Your score is " + solved + " out of " + easyProblemLength);
        } else if (mediumSelected) {
            scoreHeader.setText("Average Level Complete!");
            scoreTextView.setText("Your score is " + solved + " out of " + mediumProblemLength);
        } else if (hardSelected) {
            scoreHeader.setText("Difficult Level Complete!");
            scoreTextView.setText("Your score is " + solved + " out of " + hardProblemLength);
        }
    }
}