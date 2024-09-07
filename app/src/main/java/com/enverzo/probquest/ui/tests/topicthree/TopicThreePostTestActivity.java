package com.enverzo.probquest.ui.tests.topicthree;

import static com.enverzo.probquest.DBHandler.SCORE;
import static com.enverzo.probquest.DBHandler.TIME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.enverzo.probquest.DBHandler;
import com.enverzo.probquest.NavigationActivity;
import com.enverzo.probquest.R;
import com.enverzo.probquest.ui.tests.TestResultModelClass;
import com.enverzo.probquest.ui.tests.TestsModelClass;
import com.enverzo.probquest.ui.tests.ViewResultAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class TopicThreePostTestActivity extends AppCompatActivity {
    private LinearLayout t3PostTestEnterPasscode, t3PostTestInstruction, t3PostTestLayout;
    private RelativeLayout t3PostTestScore, t3PostTestHeader;
    private ListView t3PostTestListView;
    private EditText t3PostTestPasscode;
    private Button t3PostTestBackCode, t3PostTestSendCode, t3PostTestInsBack, t3PostTestInsStart, t3PostTestOptA, t3PostTestOptB, t3PostTestOptC, t3PostTestOptD, t3PostTestNext, t3PostTestResult;
    private TextView t3PostTestItem, t3PostTestTimer, t3PostTestQuestion, t3PostTestScoreDisp, t3PostTestTimeDisp, t3PostTestResultScore;
    private ProgressBar t3PostTestProgress;
    private ImageView t3PostTestResultExit;
    private Integer passcode;
    private boolean isTestOngoing = false;
    private int currentQuestionIndex, score, buttonIndex, randomIndex, quizLevel, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4, solStyle = View.GONE, ansStyle = View.VISIBLE;
    private long startTime, timeLeftInMillis;
    private List<String> testQuestions = new ArrayList<>();
    private List<String> testSolutions = new ArrayList<>();
    private List<String> testAnswers = new ArrayList<>();
    private List<String> btn1 = new ArrayList<>();
    private List<String> btn2 = new ArrayList<>();
    private List<String> btn3 = new ArrayList<>();
    private List<String> btn4 = new ArrayList<>();
    private List<Integer> solVis = new ArrayList<>();
    private List<Integer> ansVis = new ArrayList<>();
    private int[] mark, btnbg1, btnbg2, btnbg3, btnbg4, storeMark, storeBtnbg1, storeBtnbg2, storeBtnbg3, storeBtnbg4;
    private TopicThreeQuestion question = new TopicThreeQuestion();
    private int questionLength = 15;
    private String answer, selectedAnswer, t3PostTestTotalScore, t3PostTestTotalTime, t32Questions, t32Btn1, t32Btn2, t32Btn3, t32Btn4, t32Solutions, t32Answers;
    private CountDownTimer countDownTimer;
    private static final long COUNTDOWN_IN_MILLIS = 180000;
    private Set<Integer> shownQuestionIndices = new HashSet<>();
    private Random random;
    private Boolean checkTestCode;
    private Map<String, String> scoreAndTime;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_three_post_test);

        random = new Random();
        dbHandler = new DBHandler(this);

        t3PostTestEnterPasscode = findViewById(R.id.t3PostTestEnterPasscode);
        t3PostTestInstruction = findViewById(R.id.t3PostTestInstruction);
        t3PostTestLayout = findViewById(R.id.t3PostTestLayout);
        t3PostTestScore = findViewById(R.id.t3PostTestScore);
        t3PostTestHeader = findViewById(R.id.t3PostTestHeader);
        t3PostTestListView = findViewById(R.id.t3PostTestListView);
        t3PostTestPasscode = findViewById(R.id.t3PostTestPasscode);
        t3PostTestBackCode = findViewById(R.id.t3PostTestBackCode);
        t3PostTestSendCode = findViewById(R.id.t3PostTestSendCode);
        t3PostTestInsBack = findViewById(R.id.t3PostTestInsBack);
        t3PostTestInsStart = findViewById(R.id.t3PostTestInsStart);
        t3PostTestOptA = findViewById(R.id.t3PostTestOptA);
        t3PostTestOptB = findViewById(R.id.t3PostTestOptB);
        t3PostTestOptC = findViewById(R.id.t3PostTestOptC);
        t3PostTestOptD = findViewById(R.id.t3PostTestOptD);
        t3PostTestNext = findViewById(R.id.t3PostTestNext);
        t3PostTestResult = findViewById(R.id.t3PostTestResult);
        t3PostTestItem = findViewById(R.id.t3PostTestItem);
        t3PostTestTimer = findViewById(R.id.t3PostTestTimer);
        t3PostTestQuestion = findViewById(R.id.t3PostTestQuestion);
        t3PostTestScoreDisp = findViewById(R.id.t3PostTestScoreDisp);
        t3PostTestTimeDisp = findViewById(R.id.t3PostTestTimeDisp);
        t3PostTestResultScore = findViewById(R.id.t3PostTestResultScore);
        t3PostTestProgress = findViewById(R.id.t3PostTestProgress);
        t3PostTestResultExit = findViewById(R.id.t3PostTestResultExit);

        mark = new int[questionLength];
        btnbg1 = new int[questionLength];
        btnbg2 = new int[questionLength];
        btnbg3 = new int[questionLength];
        btnbg4 = new int[questionLength];
        storeMark = new int[questionLength];
        storeBtnbg1 = new int[questionLength];
        storeBtnbg2 = new int[questionLength];
        storeBtnbg3 = new int[questionLength];
        storeBtnbg4 = new int[questionLength];

        ViewResultAdapter viewResultAdapter = new ViewResultAdapter(TopicThreePostTestActivity.this, testQuestions, btn1, btn2, btn3, btn4, testSolutions, testAnswers, solVis, ansVis, mark, btnbg1, btnbg2, btnbg3, btnbg4);
        t3PostTestListView.setAdapter(viewResultAdapter);

        checkTestCode = dbHandler.checkCode(7436);
        if (checkTestCode == true) {
            t3PostTestEnterPasscode.setVisibility(View.GONE);
            t3PostTestScore.setVisibility(View.VISIBLE);

            scoreAndTime = dbHandler.getScoreTime(7436);
            if (!scoreAndTime.isEmpty()) {
                t3PostTestScoreDisp.setText("Score: " + scoreAndTime.get(SCORE) + "/" + questionLength);
                int totalSeconds = Integer.parseInt(scoreAndTime.get(TIME));
                int min = (totalSeconds % 3600) / 60;
                int secs = totalSeconds % 60;
                String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
                t3PostTestTimeDisp.setText("Time: " + totalTime);
            }
        } else {
            t3PostTestEnterPasscode.setVisibility(View.VISIBLE);
        }

        t3PostTestBackCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t3PostTestSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t3PostTestPasscode.getText().toString().isEmpty()) {
                    Toast.makeText(TopicThreePostTestActivity.this, "Require passcode", Toast.LENGTH_SHORT).show();
                } else {
                    passcode = Integer.valueOf(t3PostTestPasscode.getText().toString());
                    checkTestCode = dbHandler.checkCode(passcode);

                    if (checkTestCode == true) {
                        Toast.makeText(TopicThreePostTestActivity.this, "You have already taken this test", Toast.LENGTH_SHORT).show();
                    } else {
                        if (passcode.equals(7436)) {
                            t3PostTestEnterPasscode.setVisibility(View.GONE);
                            t3PostTestInstruction.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(TopicThreePostTestActivity.this, "Incorrect passcode", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        t3PostTestInsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t3PostTestInsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t3PostTestInstruction.setVisibility(View.GONE);
                t3PostTestLayout.setVisibility(View.VISIBLE);

                isTestOngoing = true;

                score = 0;
                currentQuestionIndex = 0;
                quizLevel = 1;

                t3PostTestProgress.setMax(questionLength);
                t3PostTestProgress.setProgress(currentQuestionIndex + 1);

                startTime = System.currentTimeMillis();
                NextQuestion();
            }
        });

        t3PostTestNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedAnswer.equals(answer)) {
                    storeMark[currentQuestionIndex] = R.drawable.round_check_24;
                    score++;
                } else {
                    storeMark[currentQuestionIndex] = R.drawable.round_clear_24;
                }

                if (buttonIndex == 1) {
                    storeBtnbg1[currentQuestionIndex] = R.drawable.custom_selected_button;
                    storeBtnbg2[currentQuestionIndex] = R.drawable.custom_option_button;
                    storeBtnbg3[currentQuestionIndex] = R.drawable.custom_option_button;
                    storeBtnbg4[currentQuestionIndex] = R.drawable.custom_option_button;
                } else if (buttonIndex == 2) {
                    storeBtnbg2[currentQuestionIndex] = R.drawable.custom_selected_button;
                    storeBtnbg1[currentQuestionIndex] = R.drawable.custom_option_button;
                    storeBtnbg3[currentQuestionIndex] = R.drawable.custom_option_button;
                    storeBtnbg4[currentQuestionIndex] = R.drawable.custom_option_button;
                } else if (buttonIndex == 3) {
                    storeBtnbg3[currentQuestionIndex] = R.drawable.custom_selected_button;
                    storeBtnbg2[currentQuestionIndex] = R.drawable.custom_option_button;
                    storeBtnbg1[currentQuestionIndex] = R.drawable.custom_option_button;
                    storeBtnbg4[currentQuestionIndex] = R.drawable.custom_option_button;
                } else if (buttonIndex == 4) {
                    storeBtnbg4[currentQuestionIndex] = R.drawable.custom_selected_button;
                    storeBtnbg1[currentQuestionIndex] = R.drawable.custom_option_button;
                    storeBtnbg2[currentQuestionIndex] = R.drawable.custom_option_button;
                    storeBtnbg3[currentQuestionIndex] = R.drawable.custom_option_button;
                }

                if (currentQuestionIndex < 5) {
                    t32Questions = question.getG1PostTestQuestion(randomIndex);
                    t32Btn1 = question.getG1PostTestChoice1(randomIndex);
                    t32Btn2 = question.getG1PostTestChoice2(randomIndex);
                    t32Btn3 = question.getG1PostTestChoice3(randomIndex);
                    t32Btn4 = question.getG1PostTestChoice4(randomIndex);
                    t32Solutions = question.getSolution(randomIndex);
                    t32Answers = question.getG1PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t32Questions = question.getG2PostTestQuestion(randomIndex);
                    t32Btn1 = question.getG2PostTestChoice1(randomIndex);
                    t32Btn2 = question.getG2PostTestChoice2(randomIndex);
                    t32Btn3 = question.getG2PostTestChoice3(randomIndex);
                    t32Btn4 = question.getG2PostTestChoice4(randomIndex);
                    t32Solutions = question.getSolution(randomIndex);
                    t32Answers = question.getG2PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex > 9) {
                    t32Questions = question.getG3PostTestQuestion(randomIndex);
                    t32Btn1 = question.getG3PostTestChoice1(randomIndex);
                    t32Btn2 = question.getG3PostTestChoice2(randomIndex);
                    t32Btn3 = question.getG3PostTestChoice3(randomIndex);
                    t32Btn4 = question.getG3PostTestChoice4(randomIndex);
                    t32Solutions = question.getSolution(randomIndex);
                    t32Answers = question.getG3PostTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT32Result(new TestResultModelClass(t32Questions, t32Btn1, t32Btn2, t32Btn3, t32Btn4, t32Solutions, t32Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t3PostTestProgress.setProgress(currentQuestionIndex + 1);
                    NextQuestion();
                    resetButtonStyle();
                } else {
                    countDownTimer.cancel();
                    showScore();
                }
            }
        });

        t3PostTestResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t3PostTestScore.setVisibility(View.GONE);
                t3PostTestListView.setVisibility(View.VISIBLE);
                t3PostTestHeader.setVisibility(View.VISIBLE);
                t3PostTestResultScore.setText("Score " + t3PostTestTotalScore + "/" + questionLength);
                ((ViewResultAdapter) t3PostTestListView.getAdapter()).notifyDataSetChanged();

                int markCheck = R.drawable.round_check_24;
                int markWrong = R.drawable.round_clear_24;
                int btnSlc = R.drawable.custom_selected_button;
                int btnOpt = R.drawable.custom_option_button;

                for (int i = 0; i < questionLength; i++) {
                    TestResultModelClass testResult = dbHandler.getT32Result(i+1);
                    testQuestions.add(testResult.getTestQuestion());
                    btn1.add(testResult.getBtn1());
                    btn2.add(testResult.getBtn2());
                    btn3.add(testResult.getBtn3());
                    btn4.add(testResult.getBtn4());
                    testSolutions.add(testResult.getTestSolution());
                    testAnswers.add(testResult.getTestAnswer());
                    solVis.add(View.GONE);
                    ansVis.add(View.VISIBLE);

                    if (testResult.getMark() == markCheck) {
                        mark[i] = R.drawable.round_check_24;
                    } else if (testResult.getMark() == markWrong) {
                        mark[i] = R.drawable.round_clear_24;
                    }
                    if (testResult.getBtnbg1() == btnOpt) {
                        btnbg1[i] = R.drawable.custom_option_button;
                    } else if (testResult.getBtnbg1() == btnSlc) {
                        btnbg1[i] =R.drawable.custom_selected_button;
                    }
                    if (testResult.getBtnbg2() == btnOpt) {
                        btnbg2[i] = R.drawable.custom_option_button;
                    } else if (testResult.getBtnbg2() == btnSlc) {
                        btnbg2[i] =R.drawable.custom_selected_button;
                    }
                    if (testResult.getBtnbg3() == btnOpt) {
                        btnbg3[i] = R.drawable.custom_option_button;
                    } else if (testResult.getBtnbg3() == btnSlc) {
                        btnbg3[i] =R.drawable.custom_selected_button;
                    }
                    if (testResult.getBtnbg4() == btnOpt) {
                        btnbg4[i] = R.drawable.custom_option_button;
                    } else if (testResult.getBtnbg4() == btnSlc) {
                        btnbg4[i] =R.drawable.custom_selected_button;
                    }
                }

                checkTestCode = dbHandler.checkCode(7436);
                if (checkTestCode == true) {
                    scoreAndTime = dbHandler.getScoreTime(7436);
                    if (!scoreAndTime.isEmpty()) {
                        t3PostTestResultScore.setText("Score " + scoreAndTime.get(SCORE) + "/" + questionLength);
                    }
                }
            }
        });

        t3PostTestResultExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t3PostTestOptA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 1;
                selectedAnswer = t3PostTestOptA.getText().toString();
                t3PostTestNext.setVisibility(View.VISIBLE);
                t3PostTestOptA.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t3PostTestOptA.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t3PostTestOptB, t3PostTestOptC, t3PostTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t3PostTestOptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 2;
                selectedAnswer = t3PostTestOptB.getText().toString();
                t3PostTestNext.setVisibility(View.VISIBLE);
                t3PostTestOptB.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t3PostTestOptB.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t3PostTestOptA, t3PostTestOptC, t3PostTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t3PostTestOptC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 3;
                selectedAnswer = t3PostTestOptC.getText().toString();
                t3PostTestNext.setVisibility(View.VISIBLE);
                t3PostTestOptC.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t3PostTestOptC.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t3PostTestOptA, t3PostTestOptB, t3PostTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t3PostTestOptD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 4;
                selectedAnswer = t3PostTestOptD.getText().toString();
                t3PostTestNext.setVisibility(View.VISIBLE);
                t3PostTestOptD.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t3PostTestOptD.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t3PostTestOptA, t3PostTestOptB, t3PostTestOptC};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (isTestOngoing) {
            Toast.makeText(TopicThreePostTestActivity.this, "Can't go back. Test is ongoing.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(TopicThreePostTestActivity.this, NavigationActivity.class);
            intent.putExtra("loadToTestsFragment", R.id.navigation_tests);
            startActivity(intent);
            finish();
            super.onBackPressed();
        }
    }

    private void NextQuestion() {
        t3PostTestItem.setText((currentQuestionIndex + 1) + " of " + questionLength + " Questions");

        if (quizLevel == 1) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
                quizLevel = 2;
            }
            t3PostTestQuestion.setText(question.getG1PostTestQuestion(randomIndex));
            t3PostTestOptA.setText(question.getG1PostTestChoice1(randomIndex));
            t3PostTestOptB.setText(question.getG1PostTestChoice2(randomIndex));
            t3PostTestOptC.setText(question.getG1PostTestChoice3(randomIndex));
            t3PostTestOptD.setText(question.getG1PostTestChoice4(randomIndex));
            answer = question.getG1PostTestAnswer(randomIndex);
        } else if (quizLevel == 2) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
                quizLevel = 3;
            }
            t3PostTestQuestion.setText(question.getG2PostTestQuestion(randomIndex));
            t3PostTestOptA.setText(question.getG2PostTestChoice1(randomIndex));
            t3PostTestOptB.setText(question.getG2PostTestChoice2(randomIndex));
            t3PostTestOptC.setText(question.getG2PostTestChoice3(randomIndex));
            t3PostTestOptD.setText(question.getG2PostTestChoice4(randomIndex));
            answer = question.getG2PostTestAnswer(randomIndex);
        } else if (quizLevel == 3) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
            }
            t3PostTestQuestion.setText(question.getG3PostTestQuestion(randomIndex));
            t3PostTestOptA.setText(question.getG3PostTestChoice1(randomIndex));
            t3PostTestOptB.setText(question.getG3PostTestChoice2(randomIndex));
            t3PostTestOptC.setText(question.getG3PostTestChoice3(randomIndex));
            t3PostTestOptD.setText(question.getG3PostTestChoice4(randomIndex));
            answer = question.getG3PostTestAnswer(randomIndex);
        }

        if ((currentQuestionIndex + 1) < questionLength) {
            t3PostTestNext.setText("Next");
        } else if ((currentQuestionIndex + 1) == questionLength) {
            t3PostTestNext.setText("Submit");
        }

        timeLeftInMillis = COUNTDOWN_IN_MILLIS;
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
                updateCountDownText();

                storeMark[currentQuestionIndex] = R.drawable.round_clear_24;
                storeBtnbg1[currentQuestionIndex] = R.drawable.custom_option_button;
                storeBtnbg2[currentQuestionIndex] = R.drawable.custom_option_button;
                storeBtnbg3[currentQuestionIndex] = R.drawable.custom_option_button;
                storeBtnbg4[currentQuestionIndex] = R.drawable.custom_option_button;

                if (currentQuestionIndex < 5) {
                    t32Questions = question.getG1PostTestQuestion(randomIndex);
                    t32Btn1 = question.getG1PostTestChoice1(randomIndex);
                    t32Btn2 = question.getG1PostTestChoice2(randomIndex);
                    t32Btn3 = question.getG1PostTestChoice3(randomIndex);
                    t32Btn4 = question.getG1PostTestChoice4(randomIndex);
                    t32Solutions = question.getSolution(randomIndex);
                    t32Answers = question.getG1PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t32Questions = question.getG2PostTestQuestion(randomIndex);
                    t32Btn1 = question.getG2PostTestChoice1(randomIndex);
                    t32Btn2 = question.getG2PostTestChoice2(randomIndex);
                    t32Btn3 = question.getG2PostTestChoice3(randomIndex);
                    t32Btn4 = question.getG2PostTestChoice4(randomIndex);
                    t32Solutions = question.getSolution(randomIndex);
                    t32Answers = question.getG2PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex > 9) {
                    t32Questions = question.getG3PostTestQuestion(randomIndex);
                    t32Btn1 = question.getG3PostTestChoice1(randomIndex);
                    t32Btn2 = question.getG3PostTestChoice2(randomIndex);
                    t32Btn3 = question.getG3PostTestChoice3(randomIndex);
                    t32Btn4 = question.getG3PostTestChoice4(randomIndex);
                    t32Solutions = question.getSolution(randomIndex);
                    t32Answers = question.getG3PostTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT32Result(new TestResultModelClass(t32Questions, t32Btn1, t32Btn2, t32Btn3, t32Btn4, t32Solutions, t32Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t3PostTestProgress.setProgress(currentQuestionIndex + 1);
                    NextQuestion();
                    resetButtonStyle();
                } else {
                    countDownTimer.cancel();
                    showScore();
                }
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis/1000) /60;
        int seconds = (int) (timeLeftInMillis/1000) %60;

        String timerFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
        t3PostTestTimer.setText(timerFormatted);

        if (timeLeftInMillis < 10000) {
            t3PostTestTimer.setTextColor(Color.RED);
        } else {
            t3PostTestTimer.setTextColor(Color.WHITE);
        }

        if (timeLeftInMillis == 0) {
            Toast.makeText(this, "Times Up!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showScore() {
        t3PostTestLayout.setVisibility(View.GONE);
        t3PostTestScore.setVisibility(View.VISIBLE);

        isTestOngoing = false;

        t3PostTestTotalScore = String.valueOf(score);
        t3PostTestScoreDisp.setText("Score: " + t3PostTestTotalScore + "/" + questionLength);

        long endTime = System.currentTimeMillis();
        long timeDiff = endTime - startTime;
        int totalSeconds = (int) (timeDiff / 1000);

        int min = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;
        t3PostTestTotalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
        t3PostTestTimeDisp.setText("Time: " + t3PostTestTotalTime);

        String totalSecs = String.valueOf(totalSeconds);

        dbHandler.storeTestScore(new TestsModelClass(7436, t3PostTestTotalScore, totalSecs));
    }

    private void resetButtonStyle() {
        t3PostTestNext.setVisibility(View.INVISIBLE);
        Button[] buttons = {t3PostTestOptA, t3PostTestOptB, t3PostTestOptC, t3PostTestOptD};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackgroundTintList(null);
            buttons[i].setBackgroundResource(R.drawable.custom_option_button);
            buttons[i].setTextColor(getResources().getColor(R.color.black));
        }
    }
}