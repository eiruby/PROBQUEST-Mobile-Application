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

public class TopicSevenPostTestActivity extends AppCompatActivity {
    private LinearLayout t7PostTestEnterPasscode, t7PostTestInstruction, t7PostTestLayout;
    private RelativeLayout t7PostTestScore, t7PostTestHeader;
    private ListView t7PostTestListView;
    private EditText t7PostTestPasscode;
    private Button t7PostTestBackCode, t7PostTestSendCode, t7PostTestInsBack, t7PostTestInsStart, t7PostTestOptA, t7PostTestOptB, t7PostTestOptC, t7PostTestOptD, t7PostTestNext, t7PostTestResult;
    private TextView t7PostTestItem, t7PostTestTimer, t7PostTestQuestion, t7PostTestScoreDisp, t7PostTestTimeDisp, t7PostTestResultScore;
    private ProgressBar t7PostTestProgress;
    private ImageView t7PostTestResultExit;
    private Integer passcode;
    private boolean isTestOngoing = false;
    private int currentQuestionIndex, score, buttonIndex, quizLevel, randomIndex, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4, solStyle = View.GONE, ansStyle = View.VISIBLE;
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
    private String answer, solution, selectedAnswer, t7PostTestTotalScore, t7PostTestTotalTime, t72Questions, t72Btn1, t72Btn2, t72Btn3, t72Btn4, t72Solutions, t72Answers;
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
        setContentView(R.layout.activity_topic_seven_post_test);

        random = new Random();
        dbHandler = new DBHandler(this);

        t7PostTestEnterPasscode = findViewById(R.id.t7PostTestEnterPasscode);
        t7PostTestInstruction = findViewById(R.id.t7PostTestInstruction);
        t7PostTestLayout = findViewById(R.id.t7PostTestLayout);
        t7PostTestScore = findViewById(R.id.t7PostTestScore);
        t7PostTestHeader = findViewById(R.id.t7PostTestHeader);
        t7PostTestListView = findViewById(R.id.t7PostTestListView);
        t7PostTestPasscode = findViewById(R.id.t7PostTestPasscode);
        t7PostTestBackCode = findViewById(R.id.t7PostTestBackCode);
        t7PostTestSendCode = findViewById(R.id.t7PostTestSendCode);
        t7PostTestInsBack = findViewById(R.id.t7PostTestInsBack);
        t7PostTestInsStart = findViewById(R.id.t7PostTestInsStart);
        t7PostTestOptA = findViewById(R.id.t7PostTestOptA);
        t7PostTestOptB = findViewById(R.id.t7PostTestOptB);
        t7PostTestOptC = findViewById(R.id.t7PostTestOptC);
        t7PostTestOptD = findViewById(R.id.t7PostTestOptD);
        t7PostTestNext = findViewById(R.id.t7PostTestNext);
        t7PostTestResult = findViewById(R.id.t7PostTestResult);
        t7PostTestItem = findViewById(R.id.t7PostTestItem);
        t7PostTestTimer = findViewById(R.id.t7PostTestTimer);
        t7PostTestQuestion = findViewById(R.id.t7PostTestQuestion);
        t7PostTestScoreDisp = findViewById(R.id.t7PostTestScoreDisp);
        t7PostTestTimeDisp = findViewById(R.id.t7PostTestTimeDisp);
        t7PostTestResultScore = findViewById(R.id.t7PostTestResultScore);
        t7PostTestProgress = findViewById(R.id.t7PostTestProgress);
        t7PostTestResultExit = findViewById(R.id.t7PostTestResultExit);

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

        ViewResultAdapter viewResultAdapter = new ViewResultAdapter(TopicSevenPostTestActivity.this, testQuestions, btn1, btn2, btn3, btn4, testSolutions, testAnswers, solVis, ansVis, mark, btnbg1, btnbg2, btnbg3, btnbg4);
        t7PostTestListView.setAdapter(viewResultAdapter);

        checkTestCode = dbHandler.checkCode(2658);
        if (checkTestCode == true) {
            t7PostTestEnterPasscode.setVisibility(View.GONE);
            t7PostTestScore.setVisibility(View.VISIBLE);

            scoreAndTime = dbHandler.getScoreTime(2658);
            if (!scoreAndTime.isEmpty()) {
                t7PostTestScoreDisp.setText("Score: " + scoreAndTime.get(SCORE) + "/" + questionLength);
                t7PostTestTimeDisp.setText("Time: " + scoreAndTime.get(TIME));
            }
        } else {
            t7PostTestEnterPasscode.setVisibility(View.VISIBLE);
        }

        t7PostTestBackCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t7PostTestSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t7PostTestPasscode.getText().toString().isEmpty()) {
                    Toast.makeText(TopicSevenPostTestActivity.this, "Require passcode", Toast.LENGTH_SHORT).show();
                } else {
                    passcode = Integer.valueOf(t7PostTestPasscode.getText().toString());
                    checkTestCode = dbHandler.checkCode(passcode);

                    if (checkTestCode == true) {
                        Toast.makeText(TopicSevenPostTestActivity.this, "You have already taken this test", Toast.LENGTH_SHORT).show();
                    } else {
                        if (passcode.equals(2658)) {
                            t7PostTestEnterPasscode.setVisibility(View.GONE);
                            t7PostTestInstruction.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(TopicSevenPostTestActivity.this, "Incorrect passcode", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        t7PostTestInsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t7PostTestInsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t7PostTestInstruction.setVisibility(View.GONE);
                t7PostTestLayout.setVisibility(View.VISIBLE);

                isTestOngoing = true;

                score = 0;
                currentQuestionIndex = 0;
                quizLevel = 1;

                t7PostTestProgress.setMax(questionLength);
                t7PostTestProgress.setProgress(currentQuestionIndex + 1);

                startTime = System.currentTimeMillis();
                NextQuestion();
            }
        });

        t7PostTestNext.setOnClickListener(new View.OnClickListener() {
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
                    t72Questions = question.getG1PostTestQuestion(randomIndex);
                    t72Btn1 = question.getG1PostTestChoice1(randomIndex);
                    t72Btn2 = question.getG1PostTestChoice2(randomIndex);
                    t72Btn3 = question.getG1PostTestChoice3(randomIndex);
                    t72Btn4 = question.getG1PostTestChoice4(randomIndex);
                    t72Solutions = question.getG1PostTestSolution(randomIndex);
                    t72Answers = question.getG1PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t72Questions = question.getG2PostTestQuestion(randomIndex);
                    t72Btn1 = question.getG2PostTestChoice1(randomIndex);
                    t72Btn2 = question.getG2PostTestChoice2(randomIndex);
                    t72Btn3 = question.getG2PostTestChoice3(randomIndex);
                    t72Btn4 = question.getG2PostTestChoice4(randomIndex);
                    t72Solutions = question.getG2PostTestSolution(randomIndex);
                    t72Answers = question.getG2PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex > 9) {
                    t72Questions = question.getG3PostTestQuestion(randomIndex);
                    t72Btn1 = question.getG3PostTestChoice1(randomIndex);
                    t72Btn2 = question.getG3PostTestChoice2(randomIndex);
                    t72Btn3 = question.getG3PostTestChoice3(randomIndex);
                    t72Btn4 = question.getG3PostTestChoice4(randomIndex);
                    t72Solutions = question.getG3PostTestSolution(randomIndex);
                    t72Answers = question.getG3PostTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT72Result(new TestResultModelClass(t72Questions, t72Btn1, t72Btn2, t72Btn3, t72Btn4, t72Solutions, t72Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t7PostTestProgress.setProgress(currentQuestionIndex + 1);
                    NextQuestion();
                    resetButtonStyle();
                } else {
                    countDownTimer.cancel();
                    showScore();
                }
            }
        });

        t7PostTestResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t7PostTestScore.setVisibility(View.GONE);
                t7PostTestListView.setVisibility(View.VISIBLE);
                t7PostTestHeader.setVisibility(View.VISIBLE);

                testQuestions.clear();
                btn1.clear();
                btn2.clear();
                btn3.clear();
                btn4.clear();
                testSolutions.clear();
                testAnswers.clear();
                solVis.clear();
                ansVis.clear();

                t7PostTestResultScore.setText("Score " + t7PostTestTotalScore + "/" + questionLength);
                ((ViewResultAdapter) t7PostTestListView.getAdapter()).notifyDataSetChanged();

                int markCheck = R.drawable.round_check_24;
                int markWrong = R.drawable.round_clear_24;
                int btnSlc = R.drawable.custom_selected_button;
                int btnOpt = R.drawable.custom_option_button;

                for (int i = 0; i < questionLength; i++) {
                    TestResultModelClass testResult = dbHandler.getT72Result(i+1);
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

                checkTestCode = dbHandler.checkCode(2658);
                if (checkTestCode == true) {
                    scoreAndTime = dbHandler.getScoreTime(2658);
                    if (!scoreAndTime.isEmpty()) {
                        t7PostTestResultScore.setText("Score " + scoreAndTime.get(SCORE) + "/" + questionLength);
                    }
                }
            }
        });

        t7PostTestResultExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t7PostTestOptA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 1;
                selectedAnswer = t7PostTestOptA.getText().toString();
                t7PostTestNext.setVisibility(View.VISIBLE);
                t7PostTestOptA.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t7PostTestOptA.setTextColor(getResources().getColor(R.color.white));
                t7PostTestOptB.setBackgroundTintList(null);
                t7PostTestOptB.setBackgroundResource(R.drawable.custom_option_button);
                t7PostTestOptB.setTextColor(getResources().getColor(R.color.black));
                t7PostTestOptC.setBackgroundTintList(null);
                t7PostTestOptC.setBackgroundResource(R.drawable.custom_option_button);
                t7PostTestOptC.setTextColor(getResources().getColor(R.color.black));
                t7PostTestOptD.setBackgroundTintList(null);
                t7PostTestOptD.setBackgroundResource(R.drawable.custom_option_button);
                t7PostTestOptD.setTextColor(getResources().getColor(R.color.black));
            }
        });

        t7PostTestOptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 2;
                selectedAnswer = t7PostTestOptB.getText().toString();
                t7PostTestNext.setVisibility(View.VISIBLE);
                t7PostTestOptB.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t7PostTestOptB.setTextColor(getResources().getColor(R.color.white));
                t7PostTestOptA.setBackgroundTintList(null);
                t7PostTestOptA.setBackgroundResource(R.drawable.custom_option_button);
                t7PostTestOptA.setTextColor(getResources().getColor(R.color.black));
                t7PostTestOptC.setBackgroundTintList(null);
                t7PostTestOptC.setBackgroundResource(R.drawable.custom_option_button);
                t7PostTestOptC.setTextColor(getResources().getColor(R.color.black));
                t7PostTestOptD.setBackgroundTintList(null);
                t7PostTestOptD.setBackgroundResource(R.drawable.custom_option_button);
                t7PostTestOptD.setTextColor(getResources().getColor(R.color.black));
            }
        });

        t7PostTestOptC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 3;
                selectedAnswer = t7PostTestOptC.getText().toString();
                t7PostTestNext.setVisibility(View.VISIBLE);
                t7PostTestOptC.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t7PostTestOptC.setTextColor(getResources().getColor(R.color.white));
                t7PostTestOptA.setBackgroundTintList(null);
                t7PostTestOptA.setBackgroundResource(R.drawable.custom_option_button);
                t7PostTestOptA.setTextColor(getResources().getColor(R.color.black));
                t7PostTestOptB.setBackgroundTintList(null);
                t7PostTestOptB.setBackgroundResource(R.drawable.custom_option_button);
                t7PostTestOptB.setTextColor(getResources().getColor(R.color.black));
                t7PostTestOptD.setBackgroundTintList(null);
                t7PostTestOptD.setBackgroundResource(R.drawable.custom_option_button);
                t7PostTestOptD.setTextColor(getResources().getColor(R.color.black));
            }
        });

        t7PostTestOptD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 4;
                selectedAnswer = t7PostTestOptD.getText().toString();
                t7PostTestNext.setVisibility(View.VISIBLE);
                t7PostTestOptD.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t7PostTestOptD.setTextColor(getResources().getColor(R.color.white));
                t7PostTestOptA.setBackgroundTintList(null);
                t7PostTestOptA.setBackgroundResource(R.drawable.custom_option_button);
                t7PostTestOptA.setTextColor(getResources().getColor(R.color.black));
                t7PostTestOptC.setBackgroundTintList(null);
                t7PostTestOptC.setBackgroundResource(R.drawable.custom_option_button);
                t7PostTestOptC.setTextColor(getResources().getColor(R.color.black));
                t7PostTestOptB.setBackgroundTintList(null);
                t7PostTestOptB.setBackgroundResource(R.drawable.custom_option_button);
                t7PostTestOptB.setTextColor(getResources().getColor(R.color.black));
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (isTestOngoing) {
            Toast.makeText(TopicSevenPostTestActivity.this, "Can't go back. Test is ongoing.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(TopicSevenPostTestActivity.this, NavigationActivity.class);
            intent.putExtra("loadToTestsFragment", R.id.navigation_tests);
            startActivity(intent);
            finish();
            super.onBackPressed();
        }
    }

    private void NextQuestion() {
        t7PostTestItem.setText((currentQuestionIndex + 1) + " of " + questionLength + " Questions");

        if (quizLevel == 1) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
                quizLevel = 2;
            }
            t7PostTestQuestion.setText(question.getG1PostTestQuestion(randomIndex));
            t7PostTestOptA.setText(question.getG1PostTestChoice1(randomIndex));
            t7PostTestOptB.setText(question.getG1PostTestChoice2(randomIndex));
            t7PostTestOptC.setText(question.getG1PostTestChoice3(randomIndex));
            t7PostTestOptD.setText(question.getG1PostTestChoice4(randomIndex));
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
            t7PostTestQuestion.setText(question.getG2PostTestQuestion(randomIndex));
            t7PostTestOptA.setText(question.getG2PostTestChoice1(randomIndex));
            t7PostTestOptB.setText(question.getG2PostTestChoice2(randomIndex));
            t7PostTestOptC.setText(question.getG2PostTestChoice3(randomIndex));
            t7PostTestOptD.setText(question.getG2PostTestChoice4(randomIndex));
            answer = question.getG2PostTestAnswer(randomIndex);
        } else if (quizLevel == 3) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
            }
            t7PostTestQuestion.setText(question.getG3PostTestQuestion(randomIndex));
            t7PostTestOptA.setText(question.getG3PostTestChoice1(randomIndex));
            t7PostTestOptB.setText(question.getG3PostTestChoice2(randomIndex));
            t7PostTestOptC.setText(question.getG3PostTestChoice3(randomIndex));
            t7PostTestOptD.setText(question.getG3PostTestChoice4(randomIndex));
            answer = question.getG3PostTestAnswer(randomIndex);
        }

        if ((currentQuestionIndex + 1) < questionLength) {
            t7PostTestNext.setText("Next");
        } else if ((currentQuestionIndex + 1) == questionLength) {
            t7PostTestNext.setText("Submit");
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
                    t72Questions = question.getG1PostTestQuestion(randomIndex);
                    t72Btn1 = question.getG1PostTestChoice1(randomIndex);
                    t72Btn2 = question.getG1PostTestChoice2(randomIndex);
                    t72Btn3 = question.getG1PostTestChoice3(randomIndex);
                    t72Btn4 = question.getG1PostTestChoice4(randomIndex);
                    t72Solutions = question.getG1PostTestSolution(randomIndex);
                    t72Answers = question.getG1PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t72Questions = question.getG2PostTestQuestion(randomIndex);
                    t72Btn1 = question.getG2PostTestChoice1(randomIndex);
                    t72Btn2 = question.getG2PostTestChoice2(randomIndex);
                    t72Btn3 = question.getG2PostTestChoice3(randomIndex);
                    t72Btn4 = question.getG2PostTestChoice4(randomIndex);
                    t72Solutions = question.getG2PostTestSolution(randomIndex);
                    t72Answers = question.getG2PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex > 9) {
                    t72Questions = question.getG3PostTestQuestion(randomIndex);
                    t72Btn1 = question.getG3PostTestChoice1(randomIndex);
                    t72Btn2 = question.getG3PostTestChoice2(randomIndex);
                    t72Btn3 = question.getG3PostTestChoice3(randomIndex);
                    t72Btn4 = question.getG3PostTestChoice4(randomIndex);
                    t72Solutions = question.getG3PostTestSolution(randomIndex);
                    t72Answers = question.getG3PostTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT72Result(new TestResultModelClass(t72Questions, t72Btn1, t72Btn2, t72Btn3, t72Btn4, t72Solutions, t72Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t7PostTestProgress.setProgress(currentQuestionIndex + 1);
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
        t7PostTestTimer.setText(timerFormatted);

        if (timeLeftInMillis < 10000) {
            t7PostTestTimer.setTextColor(Color.RED);
        } else {
            t7PostTestTimer.setTextColor(Color.WHITE);
        }

        if (timeLeftInMillis == 0) {
            Toast.makeText(this, "Times Up!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showScore() {
        t7PostTestLayout.setVisibility(View.GONE);
        t7PostTestScore.setVisibility(View.VISIBLE);

        isTestOngoing = false;

        t7PostTestTotalScore = String.valueOf(score);
        t7PostTestScoreDisp.setText("Score: " + t7PostTestTotalScore + "/" + questionLength);

        long endTime = System.currentTimeMillis();
        long timeDiff = endTime - startTime;
        int totalSeconds = (int) (timeDiff / 1000);

        int min = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;
        t7PostTestTotalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
        t7PostTestTimeDisp.setText("Time: " + t7PostTestTotalTime);

        String totalSecs = String.valueOf(totalSeconds);

        dbHandler.storeTestScore(new TestsModelClass(2658, t7PostTestTotalScore, totalSecs));
    }

    private void resetButtonStyle() {
        t7PostTestNext.setVisibility(View.INVISIBLE);
        Button[] buttons = {t7PostTestOptA, t7PostTestOptB, t7PostTestOptC, t7PostTestOptD};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackgroundTintList(null);
            buttons[i].setBackgroundResource(R.drawable.custom_option_button);
            buttons[i].setTextColor(getResources().getColor(R.color.black));
        }
    }
}