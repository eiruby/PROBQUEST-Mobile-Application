package com.enverzo.probquest.ui.tests.topictwelve;

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

public class TopicTwelvePreTestActivity extends AppCompatActivity {
    private LinearLayout t12PreTestEnterPasscode, t12PreTestInstruction, t12PreTestLayout;
    private RelativeLayout t12PreTestScore, t12PreTestHeader;
    private ListView t12PreTestListView;
    private EditText t12PreTestPasscode;
    private Button t12PreTestBackCode, t12PreTestSendCode, t12PreTestInsBack, t12PreTestInsStart, t12PreTestOptA, t12PreTestOptB, t12PreTestOptC, t12PreTestOptD, t12PreTestNext, t12PreTestResult;
    private TextView t12PreTestItem, t12PreTestTimer, t12PreTestQuestion, t12PreTestScoreDisp, t12PreTestTimeDisp, t12PreTestResultScore;
    private ProgressBar t12PreTestProgress;
    private ImageView t12PreTestResultExit;
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
    private TopicTwelveQuestion question = new TopicTwelveQuestion();
    private int questionLength = 10;
    private String answer, solution, selectedAnswer, t12PreTestTotalScore, t12PreTestTotalTime, t121Questions, t121Btn1, t121Btn2, t121Btn3, t121Btn4, t121Solutions, t121Answers;
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
        setContentView(R.layout.activity_topic_twelve_pre_test);

        random = new Random();
        dbHandler = new DBHandler(this);

        t12PreTestEnterPasscode = findViewById(R.id.t12PreTestEnterPasscode);
        t12PreTestInstruction = findViewById(R.id.t12PreTestInstruction);
        t12PreTestLayout = findViewById(R.id.t12PreTestLayout);
        t12PreTestScore = findViewById(R.id.t12PreTestScore);
        t12PreTestHeader = findViewById(R.id.t12PreTestHeader);
        t12PreTestListView = findViewById(R.id.t12PreTestListView);
        t12PreTestPasscode = findViewById(R.id.t12PreTestPasscode);
        t12PreTestBackCode = findViewById(R.id.t12PreTestBackCode);
        t12PreTestSendCode = findViewById(R.id.t12PreTestSendCode);
        t12PreTestInsBack = findViewById(R.id.t12PreTestInsBack);
        t12PreTestInsStart = findViewById(R.id.t12PreTestInsStart);
        t12PreTestOptA = findViewById(R.id.t12PreTestOptA);
        t12PreTestOptB = findViewById(R.id.t12PreTestOptB);
        t12PreTestOptC = findViewById(R.id.t12PreTestOptC);
        t12PreTestOptD = findViewById(R.id.t12PreTestOptD);
        t12PreTestNext = findViewById(R.id.t12PreTestNext);
        t12PreTestResult = findViewById(R.id.t12PreTestResult);
        t12PreTestItem = findViewById(R.id.t12PreTestItem);
        t12PreTestTimer = findViewById(R.id.t12PreTestTimer);
        t12PreTestQuestion = findViewById(R.id.t12PreTestQuestion);
        t12PreTestScoreDisp = findViewById(R.id.t12PreTestScoreDisp);
        t12PreTestTimeDisp = findViewById(R.id.t12PreTestTimeDisp);
        t12PreTestResultScore = findViewById(R.id.t12PreTestResultScore);
        t12PreTestProgress = findViewById(R.id.t12PreTestProgress);
        t12PreTestResultExit = findViewById(R.id.t12PreTestResultExit);

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

        ViewResultAdapter viewResultAdapter = new ViewResultAdapter(TopicTwelvePreTestActivity.this, testQuestions, btn1, btn2, btn3, btn4, testSolutions, testAnswers, solVis, ansVis, mark, btnbg1, btnbg2, btnbg3, btnbg4);
        t12PreTestListView.setAdapter(viewResultAdapter);

        checkTestCode = dbHandler.checkCode(6235);
        if (checkTestCode == true) {
            t12PreTestEnterPasscode.setVisibility(View.GONE);
            t12PreTestScore.setVisibility(View.VISIBLE);

            scoreAndTime = dbHandler.getScoreTime(6235);
            if (!scoreAndTime.isEmpty()) {
                t12PreTestScoreDisp.setText("Score: " + scoreAndTime.get(SCORE) + "/" + questionLength);
                int totalSeconds = Integer.parseInt(scoreAndTime.get(TIME));
                int min = (totalSeconds % 3600) / 60;
                int secs = totalSeconds % 60;
                String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
                t12PreTestTimeDisp.setText("Time: " + totalTime);
            }
        } else {
            t12PreTestEnterPasscode.setVisibility(View.VISIBLE);
        }

        t12PreTestBackCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t12PreTestSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t12PreTestPasscode.getText().toString().isEmpty()) {
                    Toast.makeText(TopicTwelvePreTestActivity.this, "Require passcode", Toast.LENGTH_SHORT).show();
                } else {
                    passcode = Integer.valueOf(t12PreTestPasscode.getText().toString());
                    checkTestCode = dbHandler.checkCode(passcode);

                    if (checkTestCode == true) {
                        Toast.makeText(TopicTwelvePreTestActivity.this, "You have already taken this test", Toast.LENGTH_SHORT).show();
                    } else {
                        if (passcode.equals(6235)) {
                            t12PreTestEnterPasscode.setVisibility(View.GONE);
                            t12PreTestInstruction.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(TopicTwelvePreTestActivity.this, "Incorrect passcode", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        t12PreTestInsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t12PreTestInsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t12PreTestInstruction.setVisibility(View.GONE);
                t12PreTestLayout.setVisibility(View.VISIBLE);

                isTestOngoing = true;

                score = 0;
                currentQuestionIndex = 0;
                quizLevel = 1;

                t12PreTestProgress.setMax(questionLength);
                t12PreTestProgress.setProgress(currentQuestionIndex + 1);

                startTime = System.currentTimeMillis();
                NextQuestion();
            }
        });

        t12PreTestNext.setOnClickListener(new View.OnClickListener() {
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
                    t121Questions = question.getG1PreTestQuestion(randomIndex);
                    t121Btn1 = question.getG1PreTestChoice1(randomIndex);
                    t121Btn2 = question.getG1PreTestChoice2(randomIndex);
                    t121Btn3 = question.getG1PreTestChoice3(randomIndex);
                    t121Btn4 = question.getG1PreTestChoice4(randomIndex);
                    t121Solutions = question.getG1PreTestSolution(randomIndex);
                    t121Answers = question.getG1PreTestSolution(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t121Questions = question.getG2PreTestQuestion(randomIndex);
                    t121Btn1 = question.getG2PreTestChoice1(randomIndex);
                    t121Btn2 = question.getG2PreTestChoice2(randomIndex);
                    t121Btn3 = question.getG2PreTestChoice3(randomIndex);
                    t121Btn4 = question.getG2PreTestChoice4(randomIndex);
                    t121Solutions = question.getG2PreTestSolution(randomIndex);
                    t121Answers = question.getG2PreTestSolution(randomIndex);
//                } else if (currentQuestionIndex > 9) {
//                    t121Questions = question.getG3PreTestQuestion(randomIndex);
//                    t121Btn1 = question.getG3PreTestChoice1(randomIndex);
//                    t121Btn2 = question.getG3PreTestChoice2(randomIndex);
//                    t121Btn3 = question.getG3PreTestChoice3(randomIndex);
//                    t121Btn4 = question.getG3PreTestChoice4(randomIndex);
//                    t121Solutions = question.getG3PreTestSolution(randomIndex);
//                    t121Answers = question.getG3PreTestSolution(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT121Result(new TestResultModelClass(t121Questions, t121Btn1, t121Btn2, t121Btn3, t121Btn4, t121Solutions, t121Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t12PreTestProgress.setProgress(currentQuestionIndex + 1);
                    NextQuestion();
                    resetButtonStyle();
                } else {
                    countDownTimer.cancel();
                    showScore();
                }
            }
        });

        t12PreTestResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t12PreTestScore.setVisibility(View.GONE);
                t12PreTestListView.setVisibility(View.VISIBLE);
                t12PreTestHeader.setVisibility(View.VISIBLE);

                testQuestions.clear();
                btn1.clear();
                btn2.clear();
                btn3.clear();
                btn4.clear();
                testSolutions.clear();
                testAnswers.clear();
                solVis.clear();
                ansVis.clear();

                t12PreTestResultScore.setText("Score " + t12PreTestTotalScore + "/" + questionLength);
                ((ViewResultAdapter) t12PreTestListView.getAdapter()).notifyDataSetChanged();

                int markCheck = R.drawable.round_check_24;
                int markWrong = R.drawable.round_clear_24;
                int btnSlc = R.drawable.custom_selected_button;
                int btnOpt = R.drawable.custom_option_button;

                for (int i = 0; i < questionLength; i++) {
                    TestResultModelClass testResult = dbHandler.getT121Result(i+1);
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

                checkTestCode = dbHandler.checkCode(6235);
                if (checkTestCode == true) {
                    scoreAndTime = dbHandler.getScoreTime(6235);
                    if (!scoreAndTime.isEmpty()) {
                        t12PreTestResultScore.setText("Score " + scoreAndTime.get(SCORE) + "/" + questionLength);
                    }
                }
            }
        });

        t12PreTestResultExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t12PreTestOptA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 1;
                selectedAnswer = t12PreTestOptA.getText().toString();
                t12PreTestNext.setVisibility(View.VISIBLE);
                t12PreTestOptA.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t12PreTestOptA.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t12PreTestOptB, t12PreTestOptC, t12PreTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t12PreTestOptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 2;
                selectedAnswer = t12PreTestOptB.getText().toString();
                t12PreTestNext.setVisibility(View.VISIBLE);
                t12PreTestOptB.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t12PreTestOptB.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t12PreTestOptA, t12PreTestOptC, t12PreTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t12PreTestOptC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 3;
                selectedAnswer = t12PreTestOptC.getText().toString();
                t12PreTestNext.setVisibility(View.VISIBLE);
                t12PreTestOptC.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t12PreTestOptC.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t12PreTestOptA, t12PreTestOptB, t12PreTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t12PreTestOptD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 4;
                selectedAnswer = t12PreTestOptD.getText().toString();
                t12PreTestNext.setVisibility(View.VISIBLE);
                t12PreTestOptD.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t12PreTestOptD.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t12PreTestOptA, t12PreTestOptB, t12PreTestOptC};
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
            Toast.makeText(TopicTwelvePreTestActivity.this, "Can't go back. Test is ongoing.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(TopicTwelvePreTestActivity.this, NavigationActivity.class);
            intent.putExtra("loadToTestsFragment", R.id.navigation_tests);
            startActivity(intent);
            finish();
            super.onBackPressed();
        }
    }

    private void NextQuestion() {
        t12PreTestItem.setText((currentQuestionIndex + 1) + " of " + questionLength + " Questions");

        if (quizLevel == 1) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
                quizLevel = 2;
            }
            t12PreTestQuestion.setText(question.getG1PreTestQuestion(randomIndex));
            t12PreTestOptA.setText(question.getG1PreTestChoice1(randomIndex));
            t12PreTestOptB.setText(question.getG1PreTestChoice2(randomIndex));
            t12PreTestOptC.setText(question.getG1PreTestChoice3(randomIndex));
            t12PreTestOptD.setText(question.getG1PreTestChoice4(randomIndex));
            answer = question.getG1PreTestCorrectAnswer(randomIndex);
            solution = question.getG1PreTestSolution(randomIndex);
        } else if (quizLevel == 2) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
//                quizLevel = 3;
            }
            t12PreTestQuestion.setText(question.getG2PreTestQuestion(randomIndex));
            t12PreTestOptA.setText(question.getG2PreTestChoice1(randomIndex));
            t12PreTestOptB.setText(question.getG2PreTestChoice2(randomIndex));
            t12PreTestOptC.setText(question.getG2PreTestChoice3(randomIndex));
            t12PreTestOptD.setText(question.getG2PreTestChoice4(randomIndex));
            answer = question.getG2PreTestCorrectAnswer(randomIndex);
            solution = question.getG2PreTestSolution(randomIndex);
//        } else if (quizLevel == 3) {
//            do {
//                randomIndex = random.nextInt(5);
//            } while (shownQuestionIndices.contains(randomIndex));
//            shownQuestionIndices.add(randomIndex);
//            if (shownQuestionIndices.size() == 5) {
//                shownQuestionIndices.clear();
//            }
//            t12PreTestQuestion.setText(question.getG3PreTestQuestion(randomIndex));
//            t12PreTestOptA.setText(question.getG3PreTestChoice1(randomIndex));
//            t12PreTestOptB.setText(question.getG3PreTestChoice2(randomIndex));
//            t12PreTestOptC.setText(question.getG3PreTestChoice3(randomIndex));
//            t12PreTestOptD.setText(question.getG3PreTestChoice4(randomIndex));
//            answer = question.getG3PreTestCorrectAnswer(randomIndex);
//            solution = question.getG3PreTestSolution(randomIndex);
        }

        if ((currentQuestionIndex + 1) < questionLength) {
            t12PreTestNext.setText("Next");
        } else if ((currentQuestionIndex + 1) == questionLength) {
            t12PreTestNext.setText("Submit");
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
                    t121Questions = question.getG1PreTestQuestion(randomIndex);
                    t121Btn1 = question.getG1PreTestChoice1(randomIndex);
                    t121Btn2 = question.getG1PreTestChoice2(randomIndex);
                    t121Btn3 = question.getG1PreTestChoice3(randomIndex);
                    t121Btn4 = question.getG1PreTestChoice4(randomIndex);
                    t121Solutions = question.getG1PreTestSolution(randomIndex);
                    t121Answers = question.getG1PreTestSolution(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t121Questions = question.getG2PreTestQuestion(randomIndex);
                    t121Btn1 = question.getG2PreTestChoice1(randomIndex);
                    t121Btn2 = question.getG2PreTestChoice2(randomIndex);
                    t121Btn3 = question.getG2PreTestChoice3(randomIndex);
                    t121Btn4 = question.getG2PreTestChoice4(randomIndex);
                    t121Solutions = question.getG2PreTestSolution(randomIndex);
                    t121Answers = question.getG2PreTestSolution(randomIndex);
//                } else if (currentQuestionIndex > 9) {
//                    t121Questions = question.getG3PreTestQuestion(randomIndex);
//                    t121Btn1 = question.getG3PreTestChoice1(randomIndex);
//                    t121Btn2 = question.getG3PreTestChoice2(randomIndex);
//                    t121Btn3 = question.getG3PreTestChoice3(randomIndex);
//                    t121Btn4 = question.getG3PreTestChoice4(randomIndex);
//                    t121Solutions = question.getG3PreTestSolution(randomIndex);
//                    t121Answers = question.getG3PreTestSolution(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT121Result(new TestResultModelClass(t121Questions, t121Btn1, t121Btn2, t121Btn3, t121Btn4, t121Solutions, t121Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t12PreTestProgress.setProgress(currentQuestionIndex + 1);
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
        t12PreTestTimer.setText(timerFormatted);

        if (timeLeftInMillis < 10000) {
            t12PreTestTimer.setTextColor(Color.RED);
        } else {
            t12PreTestTimer.setTextColor(Color.WHITE);
        }

        if (timeLeftInMillis == 0) {
            Toast.makeText(this, "Times Up!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showScore() {
        t12PreTestLayout.setVisibility(View.GONE);
        t12PreTestScore.setVisibility(View.VISIBLE);

        isTestOngoing = false;

        t12PreTestTotalScore = String.valueOf(score);
        t12PreTestScoreDisp.setText("Score: " + t12PreTestTotalScore + "/" + questionLength);

        long endTime = System.currentTimeMillis();
        long timeDiff = endTime - startTime;
        int totalSeconds = (int) (timeDiff / 1000);

        int min = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;
        t12PreTestTotalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
        t12PreTestTimeDisp.setText("Time: " + t12PreTestTotalTime);

        String totalSecs = String.valueOf(totalSeconds);

        dbHandler.storeTestScore(new TestsModelClass(6235, t12PreTestTotalScore, totalSecs));
    }

    private void resetButtonStyle() {
        t12PreTestNext.setVisibility(View.INVISIBLE);
        Button[] buttons = {t12PreTestOptA, t12PreTestOptB, t12PreTestOptC, t12PreTestOptD};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackgroundTintList(null);
            buttons[i].setBackgroundResource(R.drawable.custom_option_button);
            buttons[i].setTextColor(getResources().getColor(R.color.black));
        }
    }
}