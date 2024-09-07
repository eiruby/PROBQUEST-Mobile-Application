package com.enverzo.probquest.ui.tests.topicfour;

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

public class TopicFourPostTestActivity extends AppCompatActivity {
    private LinearLayout t4PostTestEnterPasscode, t4PostTestInstruction, t4PostTestLayout;
    private RelativeLayout t4PostTestScore, t4PostTestHeader;
    private ListView t4PostTestListView;
    private EditText t4PostTestPasscode;
    private Button t4PostTestBackCode, t4PostTestSendCode, t4PostTestInsBack, t4PostTestInsStart, t4PostTestOptA, t4PostTestOptB, t4PostTestOptC, t4PostTestOptD, t4PostTestNext, t4PostTestResult;
    private TextView t4PostTestItem, t4PostTestTimer, t4PostTestQuestion, t4PostTestScoreDisp, t4PostTestTimeDisp, t4PostTestResultScore;
    private ProgressBar t4PostTestProgress;
    private ImageView t4PostTestResultExit;
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
    private int[] mark, btnbg1, btnbg2, btnbg3, storeMark, storeBtnbg1, storeBtnbg2, storeBtnbg3, storeBtnbg4;
    private int[] btnbg4;
    private TopicFourQuestion question = new TopicFourQuestion();
    private int questionLength = 15;
    private String answer, selectedAnswer, t4PostTestTotalScore, t4PostTestTotalTime, t42Questions, t42Btn1, t42Btn2, t42Btn3, t42Btn4, t42Solutions, t42Answers;
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
        setContentView(R.layout.activity_topic_four_post_test);

        random = new Random();
        dbHandler = new DBHandler(this);

        t4PostTestEnterPasscode = findViewById(R.id.t4PostTestEnterPasscode);
        t4PostTestInstruction = findViewById(R.id.t4PostTestInstruction);
        t4PostTestLayout = findViewById(R.id.t4PostTestLayout);
        t4PostTestScore = findViewById(R.id.t4PostTestScore);
        t4PostTestHeader = findViewById(R.id.t4PostTestHeader);
        t4PostTestListView = findViewById(R.id.t4PostTestListView);
        t4PostTestPasscode = findViewById(R.id.t4PostTestPasscode);
        t4PostTestBackCode = findViewById(R.id.t4PostTestBackCode);
        t4PostTestSendCode = findViewById(R.id.t4PostTestSendCode);
        t4PostTestInsBack = findViewById(R.id.t4PostTestInsBack);
        t4PostTestInsStart = findViewById(R.id.t4PostTestInsStart);
        t4PostTestOptA = findViewById(R.id.t4PostTestOptA);
        t4PostTestOptB = findViewById(R.id.t4PostTestOptB);
        t4PostTestOptC = findViewById(R.id.t4PostTestOptC);
        t4PostTestOptD = findViewById(R.id.t4PostTestOptD);
        t4PostTestNext = findViewById(R.id.t4PostTestNext);
        t4PostTestResult = findViewById(R.id.t4PostTestResult);
        t4PostTestItem = findViewById(R.id.t4PostTestItem);
        t4PostTestTimer = findViewById(R.id.t4PostTestTimer);
        t4PostTestQuestion = findViewById(R.id.t4PostTestQuestion);
        t4PostTestScoreDisp = findViewById(R.id.t4PostTestScoreDisp);
        t4PostTestTimeDisp = findViewById(R.id.t4PostTestTimeDisp);
        t4PostTestResultScore = findViewById(R.id.t4PostTestResultScore);
        t4PostTestProgress = findViewById(R.id.t4PostTestProgress);
        t4PostTestResultExit = findViewById(R.id.t4PostTestResultExit);

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

        ViewResultAdapter viewResultAdapter = new ViewResultAdapter(TopicFourPostTestActivity.this, testQuestions, btn1, btn2, btn3, btn4, testSolutions, testAnswers, solVis, ansVis, mark, btnbg1, btnbg2, btnbg3, btnbg4);
        t4PostTestListView.setAdapter(viewResultAdapter);

        checkTestCode = dbHandler.checkCode(3186);
        if (checkTestCode == true) {
            t4PostTestEnterPasscode.setVisibility(View.GONE);
            t4PostTestScore.setVisibility(View.VISIBLE);

            scoreAndTime = dbHandler.getScoreTime(3186);
            if (!scoreAndTime.isEmpty()) {
                t4PostTestScoreDisp.setText("Score: " + scoreAndTime.get(SCORE) + "/" + questionLength);
                t4PostTestTimeDisp.setText("Time: " + scoreAndTime.get(TIME));
            }
        } else {
            t4PostTestEnterPasscode.setVisibility(View.VISIBLE);
        }

        t4PostTestBackCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t4PostTestSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t4PostTestPasscode.getText().toString().isEmpty()) {
                    Toast.makeText(TopicFourPostTestActivity.this, "Require passcode", Toast.LENGTH_SHORT).show();
                } else {
                    passcode = Integer.valueOf(t4PostTestPasscode.getText().toString());
                    checkTestCode = dbHandler.checkCode(passcode);

                    if (checkTestCode == true) {
                        Toast.makeText(TopicFourPostTestActivity.this, "You have already taken this test", Toast.LENGTH_SHORT).show();
                    } else {
                        if (passcode.equals(3186)) {
                            t4PostTestEnterPasscode.setVisibility(View.GONE);
                            t4PostTestInstruction.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(TopicFourPostTestActivity.this, "Incorrect passcode", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        t4PostTestInsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t4PostTestInsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t4PostTestInstruction.setVisibility(View.GONE);
                t4PostTestLayout.setVisibility(View.VISIBLE);

                isTestOngoing = true;

                score = 0;
                currentQuestionIndex = 0;
                quizLevel = 1;

                t4PostTestProgress.setMax(questionLength);
                t4PostTestProgress.setProgress(currentQuestionIndex + 1);

                startTime = System.currentTimeMillis();
                NextQuestion();
            }
        });

        t4PostTestNext.setOnClickListener(new View.OnClickListener() {
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

                if (quizLevel == 1) {
                    t42Questions = question.getG1PostTestQuestion(randomIndex);
                    t42Btn1 = question.getG1PostTestChoice1(randomIndex);
                    t42Btn2 = question.getG1PostTestChoice2(randomIndex);
                    t42Btn3 = question.getG1PostTestChoice3(randomIndex);
                    t42Btn4 = question.getG1PostTestChoice4(randomIndex);
                    t42Solutions = question.getSolution(randomIndex);
                    t42Answers = question.getG1PostTestAnswer(randomIndex);
                } else if (quizLevel == 2) {
                    t42Questions = question.getG2PostTestQuestion(randomIndex);
                    t42Btn1 = question.getG2PostTestChoice1(randomIndex);
                    t42Btn2 = question.getG2PostTestChoice2(randomIndex);
                    t42Btn3 = question.getG2PostTestChoice3(randomIndex);
                    t42Btn4 = question.getG2PostTestChoice4(randomIndex);
                    t42Solutions = question.getSolution(randomIndex);
                    t42Answers = question.getG2PostTestAnswer(randomIndex);
                } else if (quizLevel == 3) {
                    t42Questions = question.getG3PostTestQuestion(randomIndex);
                    t42Btn1 = question.getG3PostTestChoice1(randomIndex);
                    t42Btn2 = question.getG3PostTestChoice2(randomIndex);
                    t42Btn3 = question.getG3PostTestChoice3(randomIndex);
                    t42Btn4 = question.getG3PostTestChoice4(randomIndex);
                    t42Solutions = question.getSolution(randomIndex);
                    t42Answers = question.getG3PostTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT42Result(new TestResultModelClass(t42Questions, t42Btn1, t42Btn2, t42Btn3, t42Btn4, t42Solutions, t42Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t4PostTestProgress.setProgress(currentQuestionIndex + 1);
                    NextQuestion();
                    resetButtonStyle();
                } else {
                    countDownTimer.cancel();
                    showScore();
                }
            }
        });

        t4PostTestResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t4PostTestScore.setVisibility(View.GONE);
                t4PostTestListView.setVisibility(View.VISIBLE);
                t4PostTestHeader.setVisibility(View.VISIBLE);

                t4PostTestResultScore.setText("Score " + t4PostTestTotalScore + "/" + questionLength);
                ((ViewResultAdapter) t4PostTestListView.getAdapter()).notifyDataSetChanged();

                int markCheck = R.drawable.round_check_24;
                int markWrong = R.drawable.round_clear_24;
                int btnSlc = R.drawable.custom_selected_button;
                int btnOpt = R.drawable.custom_option_button;

                for (int i = 0; i < questionLength; i++) {
                    TestResultModelClass testResult = dbHandler.getT42Result(i+1);
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

                checkTestCode = dbHandler.checkCode(3186);
                if (checkTestCode == true) {
                    scoreAndTime = dbHandler.getScoreTime(3186);
                    if (!scoreAndTime.isEmpty()) {
                        t4PostTestResultScore.setText("Score " + scoreAndTime.get(SCORE) + "/" + questionLength);
                    }
                }
            }
        });

        t4PostTestResultExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t4PostTestOptA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 1;
                selectedAnswer = t4PostTestOptA.getText().toString();
                t4PostTestNext.setVisibility(View.VISIBLE);
                t4PostTestOptA.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t4PostTestOptA.setTextColor(getResources().getColor(R.color.white));
                t4PostTestOptB.setBackgroundTintList(null);
                t4PostTestOptB.setBackgroundResource(R.drawable.custom_option_button);
                t4PostTestOptB.setTextColor(getResources().getColor(R.color.black));
                t4PostTestOptC.setBackgroundTintList(null);
                t4PostTestOptC.setBackgroundResource(R.drawable.custom_option_button);
                t4PostTestOptC.setTextColor(getResources().getColor(R.color.black));
                t4PostTestOptD.setBackgroundTintList(null);
                t4PostTestOptD.setBackgroundResource(R.drawable.custom_option_button);
                t4PostTestOptD.setTextColor(getResources().getColor(R.color.black));
            }
        });

        t4PostTestOptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 2;
                selectedAnswer = t4PostTestOptB.getText().toString();
                t4PostTestNext.setVisibility(View.VISIBLE);
                t4PostTestOptB.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t4PostTestOptB.setTextColor(getResources().getColor(R.color.white));
                t4PostTestOptA.setBackgroundTintList(null);
                t4PostTestOptA.setBackgroundResource(R.drawable.custom_option_button);
                t4PostTestOptA.setTextColor(getResources().getColor(R.color.black));
                t4PostTestOptC.setBackgroundTintList(null);
                t4PostTestOptC.setBackgroundResource(R.drawable.custom_option_button);
                t4PostTestOptC.setTextColor(getResources().getColor(R.color.black));
                t4PostTestOptD.setBackgroundTintList(null);
                t4PostTestOptD.setBackgroundResource(R.drawable.custom_option_button);
                t4PostTestOptD.setTextColor(getResources().getColor(R.color.black));
            }
        });

        t4PostTestOptC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 3;
                selectedAnswer = t4PostTestOptC.getText().toString();
                t4PostTestNext.setVisibility(View.VISIBLE);
                t4PostTestOptC.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t4PostTestOptC.setTextColor(getResources().getColor(R.color.white));
                t4PostTestOptA.setBackgroundTintList(null);
                t4PostTestOptA.setBackgroundResource(R.drawable.custom_option_button);
                t4PostTestOptA.setTextColor(getResources().getColor(R.color.black));
                t4PostTestOptB.setBackgroundTintList(null);
                t4PostTestOptB.setBackgroundResource(R.drawable.custom_option_button);
                t4PostTestOptB.setTextColor(getResources().getColor(R.color.black));
                t4PostTestOptD.setBackgroundTintList(null);
                t4PostTestOptD.setBackgroundResource(R.drawable.custom_option_button);
                t4PostTestOptD.setTextColor(getResources().getColor(R.color.black));
            }
        });

        t4PostTestOptD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 4;
                selectedAnswer = t4PostTestOptD.getText().toString();
                t4PostTestNext.setVisibility(View.VISIBLE);
                t4PostTestOptD.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t4PostTestOptD.setTextColor(getResources().getColor(R.color.white));
                t4PostTestOptA.setBackgroundTintList(null);
                t4PostTestOptA.setBackgroundResource(R.drawable.custom_option_button);
                t4PostTestOptA.setTextColor(getResources().getColor(R.color.black));
                t4PostTestOptC.setBackgroundTintList(null);
                t4PostTestOptC.setBackgroundResource(R.drawable.custom_option_button);
                t4PostTestOptC.setTextColor(getResources().getColor(R.color.black));
                t4PostTestOptB.setBackgroundTintList(null);
                t4PostTestOptB.setBackgroundResource(R.drawable.custom_option_button);
                t4PostTestOptB.setTextColor(getResources().getColor(R.color.black));
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (isTestOngoing) {
            Toast.makeText(TopicFourPostTestActivity.this, "Can't go back. Test is ongoing.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(TopicFourPostTestActivity.this, NavigationActivity.class);
            intent.putExtra("loadToTestsFragment", R.id.navigation_tests);
            startActivity(intent);
            finish();
            super.onBackPressed();
        }
    }

    private void NextQuestion() {
        t4PostTestItem.setText((currentQuestionIndex + 1) + " of " + questionLength + " Questions");

        if (quizLevel == 1) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
                quizLevel = 2;
            }
            t4PostTestQuestion.setText(question.getG1PostTestQuestion(randomIndex));
            t4PostTestOptA.setText(question.getG1PostTestChoice1(randomIndex));
            t4PostTestOptB.setText(question.getG1PostTestChoice2(randomIndex));
            t4PostTestOptC.setText(question.getG1PostTestChoice3(randomIndex));
            t4PostTestOptD.setText(question.getG1PostTestChoice4(randomIndex));
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
            t4PostTestQuestion.setText(question.getG2PostTestQuestion(randomIndex));
            t4PostTestOptA.setText(question.getG2PostTestChoice1(randomIndex));
            t4PostTestOptB.setText(question.getG2PostTestChoice2(randomIndex));
            t4PostTestOptC.setText(question.getG2PostTestChoice3(randomIndex));
            t4PostTestOptD.setText(question.getG2PostTestChoice4(randomIndex));
            answer = question.getG2PostTestAnswer(randomIndex);
        } else if (quizLevel == 3) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
            }
            t4PostTestQuestion.setText(question.getG3PostTestQuestion(randomIndex));
            t4PostTestOptA.setText(question.getG3PostTestChoice1(randomIndex));
            t4PostTestOptB.setText(question.getG3PostTestChoice2(randomIndex));
            t4PostTestOptC.setText(question.getG3PostTestChoice3(randomIndex));
            t4PostTestOptD.setText(question.getG3PostTestChoice4(randomIndex));
            answer = question.getG3PostTestAnswer(randomIndex);
        }

        if ((currentQuestionIndex + 1) < questionLength) {
            t4PostTestNext.setText("Next");
        } else if ((currentQuestionIndex + 1) == questionLength) {
            t4PostTestNext.setText("Submit");
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
                    t42Questions = question.getG1PostTestQuestion(randomIndex);
                    t42Btn1 = question.getG1PostTestChoice1(randomIndex);
                    t42Btn2 = question.getG1PostTestChoice2(randomIndex);
                    t42Btn3 = question.getG1PostTestChoice3(randomIndex);
                    t42Btn4 = question.getG1PostTestChoice4(randomIndex);
                    t42Solutions = question.getSolution(randomIndex);
                    t42Answers = question.getG1PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t42Questions = question.getG2PostTestQuestion(randomIndex);
                    t42Btn1 = question.getG2PostTestChoice1(randomIndex);
                    t42Btn2 = question.getG2PostTestChoice2(randomIndex);
                    t42Btn3 = question.getG2PostTestChoice3(randomIndex);
                    t42Btn4 = question.getG2PostTestChoice4(randomIndex);
                    t42Solutions = question.getSolution(randomIndex);
                    t42Answers = question.getG2PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex > 9) {
                    t42Questions = question.getG3PostTestQuestion(randomIndex);
                    t42Btn1 = question.getG3PostTestChoice1(randomIndex);
                    t42Btn2 = question.getG3PostTestChoice2(randomIndex);
                    t42Btn3 = question.getG3PostTestChoice3(randomIndex);
                    t42Btn4 = question.getG3PostTestChoice4(randomIndex);
                    t42Solutions = question.getSolution(randomIndex);
                    t42Answers = question.getG3PostTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT42Result(new TestResultModelClass(t42Questions, t42Btn1, t42Btn2, t42Btn3, t42Btn4, t42Solutions, t42Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t4PostTestProgress.setProgress(currentQuestionIndex + 1);
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
        t4PostTestTimer.setText(timerFormatted);

        if (timeLeftInMillis < 10000) {
            t4PostTestTimer.setTextColor(Color.RED);
        } else {
            t4PostTestTimer.setTextColor(Color.WHITE);
        }

        if (timeLeftInMillis == 0) {
            Toast.makeText(this, "Times Up!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showScore() {
        t4PostTestLayout.setVisibility(View.GONE);
        t4PostTestScore.setVisibility(View.VISIBLE);

        isTestOngoing = false;

        t4PostTestTotalScore = String.valueOf(score);
        t4PostTestScoreDisp.setText("Score: " + t4PostTestTotalScore + "/" + questionLength);

        long endTime = System.currentTimeMillis();
        long timeDiff = endTime - startTime;
        int totalSeconds = (int) (timeDiff / 1000);

        int min = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;
        t4PostTestTotalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
        t4PostTestTimeDisp.setText("Time: " + t4PostTestTotalTime);

        String totalSecs = String.valueOf(totalSeconds);

        dbHandler.storeTestScore(new TestsModelClass(3186, t4PostTestTotalScore, totalSecs));
    }

    private void resetButtonStyle() {
        t4PostTestNext.setVisibility(View.INVISIBLE);
        t4PostTestOptA.setBackgroundTintList(null);
        t4PostTestOptA.setBackgroundResource(R.drawable.custom_option_button);
        t4PostTestOptA.setTextColor(getResources().getColor(R.color.black));
        t4PostTestOptB.setBackgroundTintList(null);
        t4PostTestOptB.setBackgroundResource(R.drawable.custom_option_button);
        t4PostTestOptB.setTextColor(getResources().getColor(R.color.black));
        t4PostTestOptC.setBackgroundTintList(null);
        t4PostTestOptC.setBackgroundResource(R.drawable.custom_option_button);
        t4PostTestOptC.setTextColor(getResources().getColor(R.color.black));
        t4PostTestOptD.setBackgroundTintList(null);
        t4PostTestOptD.setBackgroundResource(R.drawable.custom_option_button);
        t4PostTestOptD.setTextColor(getResources().getColor(R.color.black));
    }
}