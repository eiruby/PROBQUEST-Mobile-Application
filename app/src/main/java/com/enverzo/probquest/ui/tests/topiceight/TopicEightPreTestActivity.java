package com.enverzo.probquest.ui.tests.topiceight;

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

public class TopicEightPreTestActivity extends AppCompatActivity {
    private LinearLayout t8PreTestEnterPasscode, t8PreTestInstruction, t8PreTestLayout;
    private RelativeLayout t8PreTestScore, t8PreTestHeader;
    private ListView t8PreTestListView;
    private EditText t8PreTestPasscode;
    private Button t8PreTestBackCode, t8PreTestSendCode, t8PreTestInsBack, t8PreTestInsStart, t8PreTestOptA, t8PreTestOptB, t8PreTestOptC, t8PreTestOptD, t8PreTestNext, t8PreTestResult;
    private TextView t8PreTestItem, t8PreTestTimer, t8PreTestQuestion, t8PreTestScoreDisp, t8PreTestTimeDisp, t8PreTestResultScore;
    private ProgressBar t8PreTestProgress;
    private ImageView t8PreTestResultExit;
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
    private TopicEightQuestion question = new TopicEightQuestion();
    private int questionLength = 15;
    private String answer, selectedAnswer, t8PreTestTotalScore, t8PreTestTotalTime, t81Questions, t81Btn1, t81Btn2, t81Btn3, t81Btn4, t81Solutions, t81Answers;
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
        setContentView(R.layout.activity_topic_eight_pre_test);

        random = new Random();
        dbHandler = new DBHandler(this);

        t8PreTestEnterPasscode = findViewById(R.id.t8PreTestEnterPasscode);
        t8PreTestInstruction = findViewById(R.id.t8PreTestInstruction);
        t8PreTestLayout = findViewById(R.id.t8PreTestLayout);
        t8PreTestScore = findViewById(R.id.t8PreTestScore);
        t8PreTestHeader = findViewById(R.id.t8PreTestHeader);
        t8PreTestListView = findViewById(R.id.t8PreTestListView);
        t8PreTestPasscode = findViewById(R.id.t8PreTestPasscode);
        t8PreTestBackCode = findViewById(R.id.t8PreTestBackCode);
        t8PreTestSendCode = findViewById(R.id.t8PreTestSendCode);
        t8PreTestInsBack = findViewById(R.id.t8PreTestInsBack);
        t8PreTestInsStart = findViewById(R.id.t8PreTestInsStart);
        t8PreTestOptA = findViewById(R.id.t8PreTestOptA);
        t8PreTestOptB = findViewById(R.id.t8PreTestOptB);
        t8PreTestOptC = findViewById(R.id.t8PreTestOptC);
        t8PreTestOptD = findViewById(R.id.t8PreTestOptD);
        t8PreTestNext = findViewById(R.id.t8PreTestNext);
        t8PreTestResult = findViewById(R.id.t8PreTestResult);
        t8PreTestItem = findViewById(R.id.t8PreTestItem);
        t8PreTestTimer = findViewById(R.id.t8PreTestTimer);
        t8PreTestQuestion = findViewById(R.id.t8PreTestQuestion);
        t8PreTestScoreDisp = findViewById(R.id.t8PreTestScoreDisp);
        t8PreTestTimeDisp = findViewById(R.id.t8PreTestTimeDisp);
        t8PreTestResultScore = findViewById(R.id.t8PreTestResultScore);
        t8PreTestProgress = findViewById(R.id.t8PreTestProgress);
        t8PreTestResultExit = findViewById(R.id.t8PreTestResultExit);

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

        ViewResultAdapter viewResultAdapter = new ViewResultAdapter(TopicEightPreTestActivity.this, testQuestions, btn1, btn2, btn3, btn4, testSolutions, testAnswers, solVis, ansVis, mark, btnbg1, btnbg2, btnbg3, btnbg4);
        t8PreTestListView.setAdapter(viewResultAdapter);

        checkTestCode = dbHandler.checkCode(6792);
        if (checkTestCode == true) {
            t8PreTestEnterPasscode.setVisibility(View.GONE);
            t8PreTestScore.setVisibility(View.VISIBLE);

            scoreAndTime = dbHandler.getScoreTime(6792);
            if (!scoreAndTime.isEmpty()) {
                t8PreTestScoreDisp.setText("Score: " + scoreAndTime.get(SCORE) + "/" + questionLength);
                int totalSeconds = Integer.parseInt(scoreAndTime.get(TIME));
                int min = (totalSeconds % 3600) / 60;
                int secs = totalSeconds % 60;
                String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
                t8PreTestTimeDisp.setText("Time: " + totalTime);
            }
        } else {
            t8PreTestEnterPasscode.setVisibility(View.VISIBLE);
        }

        t8PreTestBackCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t8PreTestSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t8PreTestPasscode.getText().toString().isEmpty()) {
                    Toast.makeText(TopicEightPreTestActivity.this, "Require passcode", Toast.LENGTH_SHORT).show();
                } else {
                    passcode = Integer.valueOf(t8PreTestPasscode.getText().toString());
                    checkTestCode = dbHandler.checkCode(passcode);

                    if (checkTestCode == true) {
                        Toast.makeText(TopicEightPreTestActivity.this, "You have already taken this test", Toast.LENGTH_SHORT).show();
                    } else {
                        if (passcode.equals(6792)) {
                            t8PreTestEnterPasscode.setVisibility(View.GONE);
                            t8PreTestInstruction.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(TopicEightPreTestActivity.this, "Incorrect passcode", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        t8PreTestInsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t8PreTestInsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t8PreTestInstruction.setVisibility(View.GONE);
                t8PreTestLayout.setVisibility(View.VISIBLE);

                isTestOngoing = true;

                score = 0;
                currentQuestionIndex = 0;
                quizLevel = 1;

                t8PreTestProgress.setMax(questionLength);
                t8PreTestProgress.setProgress(currentQuestionIndex + 1);

                startTime = System.currentTimeMillis();
                NextQuestion();
            }
        });

        t8PreTestNext.setOnClickListener(new View.OnClickListener() {
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
                    t81Questions = question.getG1PreTestQuestion(randomIndex);
                    t81Btn1 = question.getG1PreTestChoice1(randomIndex);
                    t81Btn2 = question.getG1PreTestChoice2(randomIndex);
                    t81Btn3 = question.getG1PreTestChoice3(randomIndex);
                    t81Btn4 = question.getG1PreTestChoice4(randomIndex);
                    t81Solutions = question.getG1PreTestSolution(randomIndex);
                    t81Answers = question.getG1PreTestAnswer(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t81Questions = question.getG2PreTestQuestion(randomIndex);
                    t81Btn1 = question.getG2PreTestChoice1(randomIndex);
                    t81Btn2 = question.getG2PreTestChoice2(randomIndex);
                    t81Btn3 = question.getG2PreTestChoice3(randomIndex);
                    t81Btn4 = question.getG2PreTestChoice4(randomIndex);
                    t81Solutions = question.getG2PreTestSolution(randomIndex);
                    t81Answers = question.getG2PreTestAnswer(randomIndex);
                } else if (currentQuestionIndex > 9) {
                    t81Questions = question.getG3PreTestQuestion(randomIndex);
                    t81Btn1 = question.getG3PreTestChoice1(randomIndex);
                    t81Btn2 = question.getG3PreTestChoice2(randomIndex);
                    t81Btn3 = question.getG3PreTestChoice3(randomIndex);
                    t81Btn4 = question.getG3PreTestChoice4(randomIndex);
                    t81Solutions = question.getG3PreTestSolution(randomIndex);
                    t81Answers = question.getG3PreTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT81Result(new TestResultModelClass(t81Questions, t81Btn1, t81Btn2, t81Btn3, t81Btn4, t81Solutions, t81Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t8PreTestProgress.setProgress(currentQuestionIndex + 1);
                    NextQuestion();
                    resetButtonStyle();
                } else {
                    countDownTimer.cancel();
                    showScore();
                }
            }
        });

        t8PreTestResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t8PreTestScore.setVisibility(View.GONE);
                t8PreTestListView.setVisibility(View.VISIBLE);
                t8PreTestHeader.setVisibility(View.VISIBLE);

                testQuestions.clear();
                btn1.clear();
                btn2.clear();
                btn3.clear();
                btn4.clear();
                testSolutions.clear();
                testAnswers.clear();
                solVis.clear();
                ansVis.clear();

                t8PreTestResultScore.setText("Score " + t8PreTestTotalScore + "/" + questionLength);
                ((ViewResultAdapter) t8PreTestListView.getAdapter()).notifyDataSetChanged();

                int markCheck = R.drawable.round_check_24;
                int markWrong = R.drawable.round_clear_24;
                int btnSlc = R.drawable.custom_selected_button;
                int btnOpt = R.drawable.custom_option_button;

                for (int i = 0; i < questionLength; i++) {
                    TestResultModelClass testResult = dbHandler.getT81Result(i+1);
                    testQuestions.add(testResult.getTestQuestion());
                    btn1.add(testResult.getBtn1());
                    btn2.add(testResult.getBtn2());
                    btn3.add(testResult.getBtn3());
                    btn4.add(testResult.getBtn4());
                    testAnswers.add(testResult.getTestSolution());
                    testSolutions.add(testResult.getTestAnswer());
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

                checkTestCode = dbHandler.checkCode(6792);
                if (checkTestCode == true) {
                    scoreAndTime = dbHandler.getScoreTime(6792);
                    if (!scoreAndTime.isEmpty()) {
                        t8PreTestResultScore.setText("Score " + scoreAndTime.get(SCORE) + "/" + questionLength);
                    }
                }
            }
        });

        t8PreTestResultExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t8PreTestOptA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 1;
                selectedAnswer = t8PreTestOptA.getText().toString();
                t8PreTestNext.setVisibility(View.VISIBLE);
                t8PreTestOptA.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t8PreTestOptA.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t8PreTestOptB, t8PreTestOptC, t8PreTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t8PreTestOptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 2;
                selectedAnswer = t8PreTestOptB.getText().toString();
                t8PreTestNext.setVisibility(View.VISIBLE);
                t8PreTestOptB.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t8PreTestOptB.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t8PreTestOptA, t8PreTestOptC, t8PreTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t8PreTestOptC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 3;
                selectedAnswer = t8PreTestOptC.getText().toString();
                t8PreTestNext.setVisibility(View.VISIBLE);
                t8PreTestOptC.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t8PreTestOptC.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t8PreTestOptA, t8PreTestOptB, t8PreTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t8PreTestOptD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 4;
                selectedAnswer = t8PreTestOptD.getText().toString();
                t8PreTestNext.setVisibility(View.VISIBLE);
                t8PreTestOptD.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t8PreTestOptD.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t8PreTestOptA, t8PreTestOptB, t8PreTestOptC};
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
            Toast.makeText(TopicEightPreTestActivity.this, "Can't go back. Test is ongoing.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(TopicEightPreTestActivity.this, NavigationActivity.class);
            intent.putExtra("loadToTestsFragment", R.id.navigation_tests);
            startActivity(intent);
            finish();
            super.onBackPressed();
        }
    }

    private void NextQuestion() {
        t8PreTestItem.setText((currentQuestionIndex + 1) + " of " + questionLength + " Questions");

        if (quizLevel == 1) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
                quizLevel = 2;
            }
            t8PreTestQuestion.setText(question.getG1PreTestQuestion(randomIndex));
            t8PreTestOptA.setText(question.getG1PreTestChoice1(randomIndex));
            t8PreTestOptB.setText(question.getG1PreTestChoice2(randomIndex));
            t8PreTestOptC.setText(question.getG1PreTestChoice3(randomIndex));
            t8PreTestOptD.setText(question.getG1PreTestChoice4(randomIndex));
            answer = question.getG1PreTestAnswer(randomIndex);
        } else if (quizLevel == 2) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
                quizLevel = 3;
            }
            t8PreTestQuestion.setText(question.getG2PreTestQuestion(randomIndex));
            t8PreTestOptA.setText(question.getG2PreTestChoice1(randomIndex));
            t8PreTestOptB.setText(question.getG2PreTestChoice2(randomIndex));
            t8PreTestOptC.setText(question.getG2PreTestChoice3(randomIndex));
            t8PreTestOptD.setText(question.getG2PreTestChoice4(randomIndex));
            answer = question.getG2PreTestAnswer(randomIndex);
        } else if (quizLevel == 3) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
            }
            t8PreTestQuestion.setText(question.getG3PreTestQuestion(randomIndex));
            t8PreTestOptA.setText(question.getG3PreTestChoice1(randomIndex));
            t8PreTestOptB.setText(question.getG3PreTestChoice2(randomIndex));
            t8PreTestOptC.setText(question.getG3PreTestChoice3(randomIndex));
            t8PreTestOptD.setText(question.getG3PreTestChoice4(randomIndex));
            answer = question.getG3PreTestAnswer(randomIndex);
        }

        if ((currentQuestionIndex + 1) < questionLength) {
            t8PreTestNext.setText("Next");
        } else if ((currentQuestionIndex + 1) == questionLength) {
            t8PreTestNext.setText("Submit");
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
                    t81Questions = question.getG1PreTestQuestion(randomIndex);
                    t81Btn1 = question.getG1PreTestChoice1(randomIndex);
                    t81Btn2 = question.getG1PreTestChoice2(randomIndex);
                    t81Btn3 = question.getG1PreTestChoice3(randomIndex);
                    t81Btn4 = question.getG1PreTestChoice4(randomIndex);
                    t81Solutions = question.getG1PreTestSolution(randomIndex);
                    t81Answers = question.getG1PreTestAnswer(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t81Questions = question.getG2PreTestQuestion(randomIndex);
                    t81Btn1 = question.getG2PreTestChoice1(randomIndex);
                    t81Btn2 = question.getG2PreTestChoice2(randomIndex);
                    t81Btn3 = question.getG2PreTestChoice3(randomIndex);
                    t81Btn4 = question.getG2PreTestChoice4(randomIndex);
                    t81Solutions = question.getG2PreTestSolution(randomIndex);
                    t81Answers = question.getG2PreTestAnswer(randomIndex);
                } else if (currentQuestionIndex > 9) {
                    t81Questions = question.getG3PreTestQuestion(randomIndex);
                    t81Btn1 = question.getG3PreTestChoice1(randomIndex);
                    t81Btn2 = question.getG3PreTestChoice2(randomIndex);
                    t81Btn3 = question.getG3PreTestChoice3(randomIndex);
                    t81Btn4 = question.getG3PreTestChoice4(randomIndex);
                    t81Solutions = question.getG3PreTestSolution(randomIndex);
                    t81Answers = question.getG3PreTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT81Result(new TestResultModelClass(t81Questions, t81Btn1, t81Btn2, t81Btn3, t81Btn4, t81Solutions, t81Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t8PreTestProgress.setProgress(currentQuestionIndex + 1);
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
        t8PreTestTimer.setText(timerFormatted);

        if (timeLeftInMillis < 10000) {
            t8PreTestTimer.setTextColor(Color.RED);
        } else {
            t8PreTestTimer.setTextColor(Color.WHITE);
        }

        if (timeLeftInMillis == 0) {
            Toast.makeText(this, "Times Up!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showScore() {
        t8PreTestLayout.setVisibility(View.GONE);
        t8PreTestScore.setVisibility(View.VISIBLE);

        isTestOngoing = false;

        t8PreTestTotalScore = String.valueOf(score);
        t8PreTestScoreDisp.setText("Score: " + t8PreTestTotalScore + "/" + questionLength);

        long endTime = System.currentTimeMillis();
        long timeDiff = endTime - startTime;
        int totalSeconds = (int) (timeDiff / 1000);

        int min = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;
        t8PreTestTotalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
        t8PreTestTimeDisp.setText("Time: " + t8PreTestTotalTime);

        String totalSecs = String.valueOf(totalSeconds);

        dbHandler.storeTestScore(new TestsModelClass(6792, t8PreTestTotalScore, totalSecs));
    }

    private void resetButtonStyle() {
        t8PreTestNext.setVisibility(View.INVISIBLE);
        Button[] buttons = {t8PreTestOptA, t8PreTestOptB, t8PreTestOptC, t8PreTestOptD};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackgroundTintList(null);
            buttons[i].setBackgroundResource(R.drawable.custom_option_button);
            buttons[i].setTextColor(getResources().getColor(R.color.black));
        }
    }
}