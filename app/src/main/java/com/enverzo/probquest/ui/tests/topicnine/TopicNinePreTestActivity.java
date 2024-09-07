package com.enverzo.probquest.ui.tests.topicnine;

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

public class TopicNinePreTestActivity extends AppCompatActivity {
    private LinearLayout t9PreTestEnterPasscode, t9PreTestInstruction, t9PreTestLayout;
    private RelativeLayout t9PreTestScore, t9PreTestHeader;
    private ListView t9PreTestListView;
    private EditText t9PreTestPasscode;
    private Button t9PreTestBackCode, t9PreTestSendCode, t9PreTestInsBack, t9PreTestInsStart, t9PreTestOptA, t9PreTestOptB, t9PreTestOptC, t9PreTestOptD, t9PreTestNext, t9PreTestResult;
    private TextView t9PreTestItem, t9PreTestTimer, t9PreTestQuestion, t9PreTestScoreDisp, t9PreTestTimeDisp, t9PreTestResultScore;
    private ProgressBar t9PreTestProgress;
    private ImageView t9PreTestResultExit;
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
    private TopicNineQuestion question = new TopicNineQuestion();
    private int questionLength = 15;
    private String answer, selectedAnswer, t9PreTestTotalScore, t9PreTestTotalTime, t91Questions, t91Btn1, t91Btn2, t91Btn3, t91Btn4, t91Solutions, t91Answers;
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
        setContentView(R.layout.activity_topic_nine_pre_test);

        random = new Random();
        dbHandler = new DBHandler(this);

        t9PreTestEnterPasscode = findViewById(R.id.t9PreTestEnterPasscode);
        t9PreTestInstruction = findViewById(R.id.t9PreTestInstruction);
        t9PreTestLayout = findViewById(R.id.t9PreTestLayout);
        t9PreTestScore = findViewById(R.id.t9PreTestScore);
        t9PreTestHeader = findViewById(R.id.t9PreTestHeader);
        t9PreTestListView = findViewById(R.id.t9PreTestListView);
        t9PreTestPasscode = findViewById(R.id.t9PreTestPasscode);
        t9PreTestBackCode = findViewById(R.id.t9PreTestBackCode);
        t9PreTestSendCode = findViewById(R.id.t9PreTestSendCode);
        t9PreTestInsBack = findViewById(R.id.t9PreTestInsBack);
        t9PreTestInsStart = findViewById(R.id.t9PreTestInsStart);
        t9PreTestOptA = findViewById(R.id.t9PreTestOptA);
        t9PreTestOptB = findViewById(R.id.t9PreTestOptB);
        t9PreTestOptC = findViewById(R.id.t9PreTestOptC);
        t9PreTestOptD = findViewById(R.id.t9PreTestOptD);
        t9PreTestNext = findViewById(R.id.t9PreTestNext);
        t9PreTestResult = findViewById(R.id.t9PreTestResult);
        t9PreTestItem = findViewById(R.id.t9PreTestItem);
        t9PreTestTimer = findViewById(R.id.t9PreTestTimer);
        t9PreTestQuestion = findViewById(R.id.t9PreTestQuestion);
        t9PreTestScoreDisp = findViewById(R.id.t9PreTestScoreDisp);
        t9PreTestTimeDisp = findViewById(R.id.t9PreTestTimeDisp);
        t9PreTestResultScore = findViewById(R.id.t9PreTestResultScore);
        t9PreTestProgress = findViewById(R.id.t9PreTestProgress);
        t9PreTestResultExit = findViewById(R.id.t9PreTestResultExit);

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

        ViewResultAdapter viewResultAdapter = new ViewResultAdapter(TopicNinePreTestActivity.this, testQuestions, btn1, btn2, btn3, btn4, testSolutions, testAnswers, solVis, ansVis, mark, btnbg1, btnbg2, btnbg3, btnbg4);
        t9PreTestListView.setAdapter(viewResultAdapter);

        checkTestCode = dbHandler.checkCode(9263);
        if (checkTestCode == true) {
            t9PreTestEnterPasscode.setVisibility(View.GONE);
            t9PreTestScore.setVisibility(View.VISIBLE);

            scoreAndTime = dbHandler.getScoreTime(9263);
            if (!scoreAndTime.isEmpty()) {
                t9PreTestScoreDisp.setText("Score: " + scoreAndTime.get(SCORE) + "/" + questionLength);
                int totalSeconds = Integer.parseInt(scoreAndTime.get(TIME));
                int min = (totalSeconds % 3600) / 60;
                int secs = totalSeconds % 60;
                String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
                t9PreTestTimeDisp.setText("Time: " + totalTime);
            }
        } else {
            t9PreTestEnterPasscode.setVisibility(View.VISIBLE);
        }

        t9PreTestBackCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t9PreTestSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t9PreTestPasscode.getText().toString().isEmpty()) {
                    Toast.makeText(TopicNinePreTestActivity.this, "Require passcode", Toast.LENGTH_SHORT).show();
                } else {
                    passcode = Integer.valueOf(t9PreTestPasscode.getText().toString());
                    checkTestCode = dbHandler.checkCode(passcode);

                    if (checkTestCode == true) {
                        Toast.makeText(TopicNinePreTestActivity.this, "You have already taken this test", Toast.LENGTH_SHORT).show();
                    } else {
                        if (passcode.equals(9263)) {
                            t9PreTestEnterPasscode.setVisibility(View.GONE);
                            t9PreTestInstruction.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(TopicNinePreTestActivity.this, "Incorrect passcode", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        t9PreTestInsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t9PreTestInsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t9PreTestInstruction.setVisibility(View.GONE);
                t9PreTestLayout.setVisibility(View.VISIBLE);

                isTestOngoing = true;

                score = 0;
                currentQuestionIndex = 0;
                quizLevel = 1;

                t9PreTestProgress.setMax(questionLength);
                t9PreTestProgress.setProgress(currentQuestionIndex + 1);

                startTime = System.currentTimeMillis();
                NextQuestion();
            }
        });

        t9PreTestNext.setOnClickListener(new View.OnClickListener() {
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
                    t91Questions = question.getG1PreTestQuestion(randomIndex);
                    t91Btn1 = question.getG1PreTestChoice1(randomIndex);
                    t91Btn2 = question.getG1PreTestChoice2(randomIndex);
                    t91Btn3 = question.getG1PreTestChoice3(randomIndex);
                    t91Btn4 = question.getG1PreTestChoice4(randomIndex);
                    t91Solutions = question.getSolution(randomIndex);
                    t91Answers = question.getG1PreTestAnswer(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t91Questions = question.getG2PreTestQuestion(randomIndex);
                    t91Btn1 = question.getG2PreTestChoice1(randomIndex);
                    t91Btn2 = question.getG2PreTestChoice2(randomIndex);
                    t91Btn3 = question.getG2PreTestChoice3(randomIndex);
                    t91Btn4 = question.getG2PreTestChoice4(randomIndex);
                    t91Solutions = question.getSolution(randomIndex);
                    t91Answers = question.getG2PreTestAnswer(randomIndex);
                } else if (currentQuestionIndex > 9) {
                    t91Questions = question.getG3PreTestQuestion(randomIndex);
                    t91Btn1 = question.getG3PreTestChoice1(randomIndex);
                    t91Btn2 = question.getG3PreTestChoice2(randomIndex);
                    t91Btn3 = question.getG3PreTestChoice3(randomIndex);
                    t91Btn4 = question.getG3PreTestChoice4(randomIndex);
                    t91Solutions = question.getSolution(randomIndex);
                    t91Answers = question.getG3PreTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT91Result(new TestResultModelClass(t91Questions, t91Btn1, t91Btn2, t91Btn3, t91Btn4, t91Solutions, t91Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t9PreTestProgress.setProgress(currentQuestionIndex + 1);
                    NextQuestion();
                    resetButtonStyle();
                } else {
                    countDownTimer.cancel();
                    showScore();
                }
            }
        });

        t9PreTestResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t9PreTestScore.setVisibility(View.GONE);
                t9PreTestListView.setVisibility(View.VISIBLE);
                t9PreTestHeader.setVisibility(View.VISIBLE);

                testQuestions.clear();
                btn1.clear();
                btn2.clear();
                btn3.clear();
                btn4.clear();
                testSolutions.clear();
                testAnswers.clear();
                solVis.clear();
                ansVis.clear();

                t9PreTestResultScore.setText("Score " + t9PreTestTotalScore + "/" + questionLength);
                ((ViewResultAdapter) t9PreTestListView.getAdapter()).notifyDataSetChanged();

                int markCheck = R.drawable.round_check_24;
                int markWrong = R.drawable.round_clear_24;
                int btnSlc = R.drawable.custom_selected_button;
                int btnOpt = R.drawable.custom_option_button;

                for (int i = 0; i < questionLength; i++) {
                    TestResultModelClass testResult = dbHandler.getT91Result(i+1);
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

                checkTestCode = dbHandler.checkCode(9263);
                if (checkTestCode == true) {
                    scoreAndTime = dbHandler.getScoreTime(9263);
                    if (!scoreAndTime.isEmpty()) {
                        t9PreTestResultScore.setText("Score " + scoreAndTime.get(SCORE) + "/" + questionLength);
                    }
                }
            }
        });

        t9PreTestResultExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t9PreTestOptA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 1;
                selectedAnswer = t9PreTestOptA.getText().toString();
                t9PreTestNext.setVisibility(View.VISIBLE);
                t9PreTestOptA.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t9PreTestOptA.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t9PreTestOptB, t9PreTestOptC, t9PreTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t9PreTestOptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 2;
                selectedAnswer = t9PreTestOptB.getText().toString();
                t9PreTestNext.setVisibility(View.VISIBLE);
                t9PreTestOptB.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t9PreTestOptB.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t9PreTestOptA, t9PreTestOptC, t9PreTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t9PreTestOptC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 3;
                selectedAnswer = t9PreTestOptC.getText().toString();
                t9PreTestNext.setVisibility(View.VISIBLE);
                t9PreTestOptC.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t9PreTestOptC.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t9PreTestOptA, t9PreTestOptB, t9PreTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t9PreTestOptD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 4;
                selectedAnswer = t9PreTestOptD.getText().toString();
                t9PreTestNext.setVisibility(View.VISIBLE);
                t9PreTestOptD.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t9PreTestOptD.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t9PreTestOptA, t9PreTestOptB, t9PreTestOptC};
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
            Toast.makeText(TopicNinePreTestActivity.this, "Can't go back. Test is ongoing.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(TopicNinePreTestActivity.this, NavigationActivity.class);
            intent.putExtra("loadToTestsFragment", R.id.navigation_tests);
            startActivity(intent);
            finish();
            super.onBackPressed();
        }
    }

    private void NextQuestion() {
        t9PreTestItem.setText((currentQuestionIndex + 1) + " of " + questionLength + " Questions");

        if (quizLevel == 1) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
                quizLevel = 2;
            }
            t9PreTestQuestion.setText(question.getG1PreTestQuestion(randomIndex));
            t9PreTestOptA.setText(question.getG1PreTestChoice1(randomIndex));
            t9PreTestOptB.setText(question.getG1PreTestChoice2(randomIndex));
            t9PreTestOptC.setText(question.getG1PreTestChoice3(randomIndex));
            t9PreTestOptD.setText(question.getG1PreTestChoice4(randomIndex));
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
            t9PreTestQuestion.setText(question.getG2PreTestQuestion(randomIndex));
            t9PreTestOptA.setText(question.getG2PreTestChoice1(randomIndex));
            t9PreTestOptB.setText(question.getG2PreTestChoice2(randomIndex));
            t9PreTestOptC.setText(question.getG2PreTestChoice3(randomIndex));
            t9PreTestOptD.setText(question.getG2PreTestChoice4(randomIndex));
            answer = question.getG2PreTestAnswer(randomIndex);
        } else if (quizLevel == 3) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
            }
            t9PreTestQuestion.setText(question.getG3PreTestQuestion(randomIndex));
            t9PreTestOptA.setText(question.getG3PreTestChoice1(randomIndex));
            t9PreTestOptB.setText(question.getG3PreTestChoice2(randomIndex));
            t9PreTestOptC.setText(question.getG3PreTestChoice3(randomIndex));
            t9PreTestOptD.setText(question.getG3PreTestChoice4(randomIndex));
            answer = question.getG3PreTestAnswer(randomIndex);
        }

        if ((currentQuestionIndex + 1) < questionLength) {
            t9PreTestNext.setText("Next");
        } else if ((currentQuestionIndex + 1) == questionLength) {
            t9PreTestNext.setText("Submit");
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
                    t91Questions = question.getG1PreTestQuestion(randomIndex);
                    t91Btn1 = question.getG1PreTestChoice1(randomIndex);
                    t91Btn2 = question.getG1PreTestChoice2(randomIndex);
                    t91Btn3 = question.getG1PreTestChoice3(randomIndex);
                    t91Btn4 = question.getG1PreTestChoice4(randomIndex);
                    t91Solutions = question.getSolution(randomIndex);
                    t91Answers = question.getG1PreTestAnswer(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t91Questions = question.getG2PreTestQuestion(randomIndex);
                    t91Btn1 = question.getG2PreTestChoice1(randomIndex);
                    t91Btn2 = question.getG2PreTestChoice2(randomIndex);
                    t91Btn3 = question.getG2PreTestChoice3(randomIndex);
                    t91Btn4 = question.getG2PreTestChoice4(randomIndex);
                    t91Solutions = question.getSolution(randomIndex);
                    t91Answers = question.getG2PreTestAnswer(randomIndex);
                } else if (currentQuestionIndex > 9) {
                    t91Questions = question.getG3PreTestQuestion(randomIndex);
                    t91Btn1 = question.getG3PreTestChoice1(randomIndex);
                    t91Btn2 = question.getG3PreTestChoice2(randomIndex);
                    t91Btn3 = question.getG3PreTestChoice3(randomIndex);
                    t91Btn4 = question.getG3PreTestChoice4(randomIndex);
                    t91Solutions = question.getSolution(randomIndex);
                    t91Answers = question.getG3PreTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT91Result(new TestResultModelClass(t91Questions, t91Btn1, t91Btn2, t91Btn3, t91Btn4, t91Solutions, t91Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t9PreTestProgress.setProgress(currentQuestionIndex + 1);
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
        t9PreTestTimer.setText(timerFormatted);

        if (timeLeftInMillis < 10000) {
            t9PreTestTimer.setTextColor(Color.RED);
        } else {
            t9PreTestTimer.setTextColor(Color.WHITE);
        }

        if (timeLeftInMillis == 0) {
            Toast.makeText(this, "Times Up!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showScore() {
        t9PreTestLayout.setVisibility(View.GONE);
        t9PreTestScore.setVisibility(View.VISIBLE);

        isTestOngoing = false;

        t9PreTestTotalScore = String.valueOf(score);
        t9PreTestScoreDisp.setText("Score: " + t9PreTestTotalScore + "/" + questionLength);

        long endTime = System.currentTimeMillis();
        long timeDiff = endTime - startTime;
        int totalSeconds = (int) (timeDiff / 1000);

        int min = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;
        t9PreTestTotalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
        t9PreTestTimeDisp.setText("Time: " + t9PreTestTotalTime);

        String totalSecs = String.valueOf(totalSeconds);

        dbHandler.storeTestScore(new TestsModelClass(9263, t9PreTestTotalScore, totalSecs));
    }

    private void resetButtonStyle() {
        t9PreTestNext.setVisibility(View.INVISIBLE);
        Button[] buttons = {t9PreTestOptA, t9PreTestOptB, t9PreTestOptC, t9PreTestOptD};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackgroundTintList(null);
            buttons[i].setBackgroundResource(R.drawable.custom_option_button);
            buttons[i].setTextColor(getResources().getColor(R.color.black));
        }
    }
}