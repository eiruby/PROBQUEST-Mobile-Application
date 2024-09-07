package com.enverzo.probquest.ui.tests.topicseven;

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

public class TopicSevenPreTestActivity extends AppCompatActivity {
    private LinearLayout t7PreTestEnterPasscode, t7PreTestInstruction, t7PreTestLayout;
    private RelativeLayout t7PreTestScore, t7PreTestHeader;
    private ListView t7PreTestListView;
    private EditText t7PreTestPasscode;
    private Button t7PreTestBackCode, t7PreTestSendCode, t7PreTestInsBack, t7PreTestInsStart, t7PreTestOptA, t7PreTestOptB, t7PreTestOptC, t7PreTestOptD, t7PreTestNext, t7PreTestResult;
    private TextView t7PreTestItem, t7PreTestTimer, t7PreTestQuestion, t7PreTestScoreDisp, t7PreTestTimeDisp, t7PreTestResultScore;
    private ProgressBar t7PreTestProgress;
    private ImageView t7PreTestResultExit;
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
    private TopicSevenQuestion question = new TopicSevenQuestion();
    private int questionLength = 15;
    private String answer, selectedAnswer, t7PreTestTotalScore, t7PreTestTotalTime, t71Questions, t71Btn1, t71Btn2, t71Btn3, t71Btn4, t71Solutions, t71Answers;
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
        setContentView(R.layout.activity_topic_seven_pre_test);

        random = new Random();
        dbHandler = new DBHandler(this);

        t7PreTestEnterPasscode = findViewById(R.id.t7PreTestEnterPasscode);
        t7PreTestInstruction = findViewById(R.id.t7PreTestInstruction);
        t7PreTestLayout = findViewById(R.id.t7PreTestLayout);
        t7PreTestScore = findViewById(R.id.t7PreTestScore);
        t7PreTestHeader = findViewById(R.id.t7PreTestHeader);
        t7PreTestListView = findViewById(R.id.t7PreTestListView);
        t7PreTestPasscode = findViewById(R.id.t7PreTestPasscode);
        t7PreTestBackCode = findViewById(R.id.t7PreTestBackCode);
        t7PreTestSendCode = findViewById(R.id.t7PreTestSendCode);
        t7PreTestInsBack = findViewById(R.id.t7PreTestInsBack);
        t7PreTestInsStart = findViewById(R.id.t7PreTestInsStart);
        t7PreTestOptA = findViewById(R.id.t7PreTestOptA);
        t7PreTestOptB = findViewById(R.id.t7PreTestOptB);
        t7PreTestOptC = findViewById(R.id.t7PreTestOptC);
        t7PreTestOptD = findViewById(R.id.t7PreTestOptD);
        t7PreTestNext = findViewById(R.id.t7PreTestNext);
        t7PreTestResult = findViewById(R.id.t7PreTestResult);
        t7PreTestItem = findViewById(R.id.t7PreTestItem);
        t7PreTestTimer = findViewById(R.id.t7PreTestTimer);
        t7PreTestQuestion = findViewById(R.id.t7PreTestQuestion);
        t7PreTestScoreDisp = findViewById(R.id.t7PreTestScoreDisp);
        t7PreTestTimeDisp = findViewById(R.id.t7PreTestTimeDisp);
        t7PreTestResultScore = findViewById(R.id.t7PreTestResultScore);
        t7PreTestProgress = findViewById(R.id.t7PreTestProgress);
        t7PreTestResultExit = findViewById(R.id.t7PreTestResultExit);

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

        ViewResultAdapter viewResultAdapter = new ViewResultAdapter(TopicSevenPreTestActivity.this, testQuestions, btn1, btn2, btn3, btn4, testSolutions, testAnswers, solVis, ansVis, mark, btnbg1, btnbg2, btnbg3, btnbg4);
        t7PreTestListView.setAdapter(viewResultAdapter);

        checkTestCode = dbHandler.checkCode(3741);
        if (checkTestCode == true) {
            t7PreTestEnterPasscode.setVisibility(View.GONE);
            t7PreTestScore.setVisibility(View.VISIBLE);

            scoreAndTime = dbHandler.getScoreTime(3741);
            if (!scoreAndTime.isEmpty()) {
                t7PreTestScoreDisp.setText("Score: " + scoreAndTime.get(SCORE) + "/" + questionLength);
                int totalSeconds = Integer.parseInt(scoreAndTime.get(TIME));
                int min = (totalSeconds % 3600) / 60;
                int secs = totalSeconds % 60;
                String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
                t7PreTestTimeDisp.setText("Time: " + totalTime);
            }
        } else {
            t7PreTestEnterPasscode.setVisibility(View.VISIBLE);
        }

        t7PreTestBackCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t7PreTestSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t7PreTestPasscode.getText().toString().isEmpty()) {
                    Toast.makeText(TopicSevenPreTestActivity.this, "Require passcode", Toast.LENGTH_SHORT).show();
                } else {
                    passcode = Integer.valueOf(t7PreTestPasscode.getText().toString());
                    checkTestCode = dbHandler.checkCode(passcode);

                    if (checkTestCode == true) {
                        Toast.makeText(TopicSevenPreTestActivity.this, "You have already taken this test", Toast.LENGTH_SHORT).show();
                    } else {
                        if (passcode.equals(3741)) {
                            t7PreTestEnterPasscode.setVisibility(View.GONE);
                            t7PreTestInstruction.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(TopicSevenPreTestActivity.this, "Incorrect passcode", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        t7PreTestInsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t7PreTestInsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t7PreTestInstruction.setVisibility(View.GONE);
                t7PreTestLayout.setVisibility(View.VISIBLE);

                isTestOngoing = true;

                score = 0;
                currentQuestionIndex = 0;
                quizLevel = 1;

                t7PreTestProgress.setMax(questionLength);
                t7PreTestProgress.setProgress(currentQuestionIndex + 1);

                startTime = System.currentTimeMillis();
                NextQuestion();
            }
        });

        t7PreTestNext.setOnClickListener(new View.OnClickListener() {
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
                    t71Questions = question.getG1PreTestQuestion(randomIndex);
                    t71Btn1 = question.getG1PreTestChoice1(randomIndex);
                    t71Btn2 = question.getG1PreTestChoice2(randomIndex);
                    t71Btn3 = question.getG1PreTestChoice3(randomIndex);
                    t71Btn4 = question.getG1PreTestChoice4(randomIndex);
                    t71Solutions = question.getG1PreTestSolution(randomIndex);
                    t71Answers = question.getG1PreTestAnswer(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t71Questions = question.getG2PreTestQuestion(randomIndex);
                    t71Btn1 = question.getG2PreTestChoice1(randomIndex);
                    t71Btn2 = question.getG2PreTestChoice2(randomIndex);
                    t71Btn3 = question.getG2PreTestChoice3(randomIndex);
                    t71Btn4 = question.getG2PreTestChoice4(randomIndex);
                    t71Solutions = question.getG2PreTestSolution(randomIndex);
                    t71Answers = question.getG2PreTestAnswer(randomIndex);
                } else if (currentQuestionIndex > 9) {
                    t71Questions = question.getG3PreTestQuestion(randomIndex);
                    t71Btn1 = question.getG3PreTestChoice1(randomIndex);
                    t71Btn2 = question.getG3PreTestChoice2(randomIndex);
                    t71Btn3 = question.getG3PreTestChoice3(randomIndex);
                    t71Btn4 = question.getG3PreTestChoice4(randomIndex);
                    t71Solutions = question.getG3PreTestSolution(randomIndex);
                    t71Answers = question.getG3PreTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT71Result(new TestResultModelClass(t71Questions, t71Btn1, t71Btn2, t71Btn3, t71Btn4, t71Solutions, t71Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t7PreTestProgress.setProgress(currentQuestionIndex + 1);
                    NextQuestion();
                    resetButtonStyle();
                } else {
                    countDownTimer.cancel();
                    showScore();
                }
            }
        });

        t7PreTestResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t7PreTestScore.setVisibility(View.GONE);
                t7PreTestListView.setVisibility(View.VISIBLE);
                t7PreTestHeader.setVisibility(View.VISIBLE);

                testQuestions.clear();
                btn1.clear();
                btn2.clear();
                btn3.clear();
                btn4.clear();
                testSolutions.clear();
                testAnswers.clear();
                solVis.clear();
                ansVis.clear();

                t7PreTestResultScore.setText("Score " + t7PreTestTotalScore + "/" + questionLength);
                ((ViewResultAdapter) t7PreTestListView.getAdapter()).notifyDataSetChanged();

                int markCheck = R.drawable.round_check_24;
                int markWrong = R.drawable.round_clear_24;
                int btnSlc = R.drawable.custom_selected_button;
                int btnOpt = R.drawable.custom_option_button;

                for (int i = 0; i < questionLength; i++) {
                    TestResultModelClass testResult = dbHandler.getT71Result(i+1);
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

                checkTestCode = dbHandler.checkCode(3741);
                if (checkTestCode == true) {
                    scoreAndTime = dbHandler.getScoreTime(3741);
                    if (!scoreAndTime.isEmpty()) {
                        t7PreTestResultScore.setText("Score " + scoreAndTime.get(SCORE) + "/" + questionLength);
                    }
                }
            }
        });

        t7PreTestResultExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t7PreTestOptA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 1;
                selectedAnswer = t7PreTestOptA.getText().toString();
                t7PreTestNext.setVisibility(View.VISIBLE);
                t7PreTestOptA.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t7PreTestOptA.setTextColor(getResources().getColor(R.color.white));
                t7PreTestOptB.setBackgroundTintList(null);
                t7PreTestOptB.setBackgroundResource(R.drawable.custom_option_button);
                t7PreTestOptB.setTextColor(getResources().getColor(R.color.black));
                t7PreTestOptC.setBackgroundTintList(null);
                t7PreTestOptC.setBackgroundResource(R.drawable.custom_option_button);
                t7PreTestOptC.setTextColor(getResources().getColor(R.color.black));
                t7PreTestOptD.setBackgroundTintList(null);
                t7PreTestOptD.setBackgroundResource(R.drawable.custom_option_button);
                t7PreTestOptD.setTextColor(getResources().getColor(R.color.black));
            }
        });

        t7PreTestOptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 2;
                selectedAnswer = t7PreTestOptB.getText().toString();
                t7PreTestNext.setVisibility(View.VISIBLE);
                t7PreTestOptB.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t7PreTestOptB.setTextColor(getResources().getColor(R.color.white));
                t7PreTestOptA.setBackgroundTintList(null);
                t7PreTestOptA.setBackgroundResource(R.drawable.custom_option_button);
                t7PreTestOptA.setTextColor(getResources().getColor(R.color.black));
                t7PreTestOptC.setBackgroundTintList(null);
                t7PreTestOptC.setBackgroundResource(R.drawable.custom_option_button);
                t7PreTestOptC.setTextColor(getResources().getColor(R.color.black));
                t7PreTestOptD.setBackgroundTintList(null);
                t7PreTestOptD.setBackgroundResource(R.drawable.custom_option_button);
                t7PreTestOptD.setTextColor(getResources().getColor(R.color.black));
            }
        });

        t7PreTestOptC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 3;
                selectedAnswer = t7PreTestOptC.getText().toString();
                t7PreTestNext.setVisibility(View.VISIBLE);
                t7PreTestOptC.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t7PreTestOptC.setTextColor(getResources().getColor(R.color.white));
                t7PreTestOptA.setBackgroundTintList(null);
                t7PreTestOptA.setBackgroundResource(R.drawable.custom_option_button);
                t7PreTestOptA.setTextColor(getResources().getColor(R.color.black));
                t7PreTestOptB.setBackgroundTintList(null);
                t7PreTestOptB.setBackgroundResource(R.drawable.custom_option_button);
                t7PreTestOptB.setTextColor(getResources().getColor(R.color.black));
                t7PreTestOptD.setBackgroundTintList(null);
                t7PreTestOptD.setBackgroundResource(R.drawable.custom_option_button);
                t7PreTestOptD.setTextColor(getResources().getColor(R.color.black));
            }
        });

        t7PreTestOptD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 4;
                selectedAnswer = t7PreTestOptD.getText().toString();
                t7PreTestNext.setVisibility(View.VISIBLE);
                t7PreTestOptD.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t7PreTestOptD.setTextColor(getResources().getColor(R.color.white));
                t7PreTestOptA.setBackgroundTintList(null);
                t7PreTestOptA.setBackgroundResource(R.drawable.custom_option_button);
                t7PreTestOptA.setTextColor(getResources().getColor(R.color.black));
                t7PreTestOptC.setBackgroundTintList(null);
                t7PreTestOptC.setBackgroundResource(R.drawable.custom_option_button);
                t7PreTestOptC.setTextColor(getResources().getColor(R.color.black));
                t7PreTestOptB.setBackgroundTintList(null);
                t7PreTestOptB.setBackgroundResource(R.drawable.custom_option_button);
                t7PreTestOptB.setTextColor(getResources().getColor(R.color.black));
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (isTestOngoing) {
            Toast.makeText(TopicSevenPreTestActivity.this, "Can't go back. Test is ongoing.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(TopicSevenPreTestActivity.this, NavigationActivity.class);
            intent.putExtra("loadToTestsFragment", R.id.navigation_tests);
            startActivity(intent);
            finish();
            super.onBackPressed();
        }
    }

    private void NextQuestion() {
        t7PreTestItem.setText((currentQuestionIndex + 1) + " of " + questionLength + " Questions");

        if (quizLevel == 1) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
                quizLevel = 2;
            }
            t7PreTestQuestion.setText(question.getG1PreTestQuestion(randomIndex));
            t7PreTestOptA.setText(question.getG1PreTestChoice1(randomIndex));
            t7PreTestOptB.setText(question.getG1PreTestChoice2(randomIndex));
            t7PreTestOptC.setText(question.getG1PreTestChoice3(randomIndex));
            t7PreTestOptD.setText(question.getG1PreTestChoice4(randomIndex));
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
            t7PreTestQuestion.setText(question.getG2PreTestQuestion(randomIndex));
            t7PreTestOptA.setText(question.getG2PreTestChoice1(randomIndex));
            t7PreTestOptB.setText(question.getG2PreTestChoice2(randomIndex));
            t7PreTestOptC.setText(question.getG2PreTestChoice3(randomIndex));
            t7PreTestOptD.setText(question.getG2PreTestChoice4(randomIndex));
            answer = question.getG2PreTestAnswer(randomIndex);
        } else if (quizLevel == 3) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
            }
            t7PreTestQuestion.setText(question.getG3PreTestQuestion(randomIndex));
            t7PreTestOptA.setText(question.getG3PreTestChoice1(randomIndex));
            t7PreTestOptB.setText(question.getG3PreTestChoice2(randomIndex));
            t7PreTestOptC.setText(question.getG3PreTestChoice3(randomIndex));
            t7PreTestOptD.setText(question.getG3PreTestChoice4(randomIndex));
            answer = question.getG3PreTestAnswer(randomIndex);
        }

        if ((currentQuestionIndex + 1) < questionLength) {
            t7PreTestNext.setText("Next");
        } else if ((currentQuestionIndex + 1) == questionLength) {
            t7PreTestNext.setText("Submit");
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
                    t71Questions = question.getG1PreTestQuestion(randomIndex);
                    t71Btn1 = question.getG1PreTestChoice1(randomIndex);
                    t71Btn2 = question.getG1PreTestChoice2(randomIndex);
                    t71Btn3 = question.getG1PreTestChoice3(randomIndex);
                    t71Btn4 = question.getG1PreTestChoice4(randomIndex);
                    t71Solutions = question.getG1PreTestSolution(randomIndex);
                    t71Answers = question.getG1PreTestAnswer(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t71Questions = question.getG2PreTestQuestion(randomIndex);
                    t71Btn1 = question.getG2PreTestChoice1(randomIndex);
                    t71Btn2 = question.getG2PreTestChoice2(randomIndex);
                    t71Btn3 = question.getG2PreTestChoice3(randomIndex);
                    t71Btn4 = question.getG2PreTestChoice4(randomIndex);
                    t71Solutions = question.getG2PreTestSolution(randomIndex);
                    t71Answers = question.getG2PreTestAnswer(randomIndex);
                } else if (currentQuestionIndex > 9) {
                    t71Questions = question.getG3PreTestQuestion(randomIndex);
                    t71Btn1 = question.getG3PreTestChoice1(randomIndex);
                    t71Btn2 = question.getG3PreTestChoice2(randomIndex);
                    t71Btn3 = question.getG3PreTestChoice3(randomIndex);
                    t71Btn4 = question.getG3PreTestChoice4(randomIndex);
                    t71Solutions = question.getG3PreTestSolution(randomIndex);
                    t71Answers = question.getG3PreTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT71Result(new TestResultModelClass(t71Questions, t71Btn1, t71Btn2, t71Btn3, t71Btn4, t71Solutions, t71Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t7PreTestProgress.setProgress(currentQuestionIndex + 1);
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
        t7PreTestTimer.setText(timerFormatted);

        if (timeLeftInMillis < 10000) {
            t7PreTestTimer.setTextColor(Color.RED);
        } else {
            t7PreTestTimer.setTextColor(Color.WHITE);
        }

        if (timeLeftInMillis == 0) {
            Toast.makeText(this, "Times Up!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showScore() {
        t7PreTestLayout.setVisibility(View.GONE);
        t7PreTestScore.setVisibility(View.VISIBLE);

        isTestOngoing = false;

        t7PreTestTotalScore = String.valueOf(score);
        t7PreTestScoreDisp.setText("Score: " + t7PreTestTotalScore + "/" + questionLength);

        long endTime = System.currentTimeMillis();
        long timeDiff = endTime - startTime;
        int totalSeconds = (int) (timeDiff / 1000);

        int min = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;
        t7PreTestTotalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
        t7PreTestTimeDisp.setText("Time: " + t7PreTestTotalTime);

        String totalSecs = String.valueOf(totalSeconds);

        dbHandler.storeTestScore(new TestsModelClass(3741, t7PreTestTotalScore, totalSecs));
    }

    private void resetButtonStyle() {
        t7PreTestNext.setVisibility(View.INVISIBLE);
        Button[] buttons = {t7PreTestOptA, t7PreTestOptB, t7PreTestOptC, t7PreTestOptD};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackgroundTintList(null);
            buttons[i].setBackgroundResource(R.drawable.custom_option_button);
            buttons[i].setTextColor(getResources().getColor(R.color.black));
        }
    }
}