package com.enverzo.probquest.ui.tests.topicten;

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

public class TopicTenPostTestActivity extends AppCompatActivity {
    private LinearLayout t10PostTestEnterPasscode, t10PostTestInstruction, t10PostTestLayout;
    private RelativeLayout t10PostTestScore, t10PostTestHeader;
    private ListView t10PostTestListView;
    private EditText t10PostTestPasscode;
    private Button t10PostTestBackCode, t10PostTestSendCode, t10PostTestInsBack, t10PostTestInsStart, t10PostTestOptA, t10PostTestOptB, t10PostTestOptC, t10PostTestOptD, t10PostTestNext, t10PostTestResult;
    private TextView t10PostTestItem, t10PostTestTimer, t10PostTestQuestion, t10PostTestScoreDisp, t10PostTestTimeDisp, t10PostTestResultScore;
    private ProgressBar t10PostTestProgress;
    private ImageView t10PostTestResultExit;
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
    private TopicTenQuestion question = new TopicTenQuestion();
    private int questionLength = 10;
    private String answer, solution, selectedAnswer, t10PostTestTotalScore, t10PostTestTotalTime, t102Questions, t102Btn1, t102Btn2, t102Btn3, t102Btn4, t102Solutions, t102Answers;
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
        setContentView(R.layout.activity_topic_ten_post_test);

        random = new Random();
        dbHandler = new DBHandler(this);

        t10PostTestEnterPasscode = findViewById(R.id.t10PostTestEnterPasscode);
        t10PostTestInstruction = findViewById(R.id.t10PostTestInstruction);
        t10PostTestLayout = findViewById(R.id.t10PostTestLayout);
        t10PostTestScore = findViewById(R.id.t10PostTestScore);
        t10PostTestHeader = findViewById(R.id.t10PostTestHeader);
        t10PostTestListView = findViewById(R.id.t10PostTestListView);
        t10PostTestPasscode = findViewById(R.id.t10PostTestPasscode);
        t10PostTestBackCode = findViewById(R.id.t10PostTestBackCode);
        t10PostTestSendCode = findViewById(R.id.t10PostTestSendCode);
        t10PostTestInsBack = findViewById(R.id.t10PostTestInsBack);
        t10PostTestInsStart = findViewById(R.id.t10PostTestInsStart);
        t10PostTestOptA = findViewById(R.id.t10PostTestOptA);
        t10PostTestOptB = findViewById(R.id.t10PostTestOptB);
        t10PostTestOptC = findViewById(R.id.t10PostTestOptC);
        t10PostTestOptD = findViewById(R.id.t10PostTestOptD);
        t10PostTestNext = findViewById(R.id.t10PostTestNext);
        t10PostTestResult = findViewById(R.id.t10PostTestResult);
        t10PostTestItem = findViewById(R.id.t10PostTestItem);
        t10PostTestTimer = findViewById(R.id.t10PostTestTimer);
        t10PostTestQuestion = findViewById(R.id.t10PostTestQuestion);
        t10PostTestScoreDisp = findViewById(R.id.t10PostTestScoreDisp);
        t10PostTestTimeDisp = findViewById(R.id.t10PostTestTimeDisp);
        t10PostTestResultScore = findViewById(R.id.t10PostTestResultScore);
        t10PostTestProgress = findViewById(R.id.t10PostTestProgress);
        t10PostTestResultExit = findViewById(R.id.t10PostTestResultExit);

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

        ViewResultAdapter viewResultAdapter = new ViewResultAdapter(TopicTenPostTestActivity.this, testQuestions, btn1, btn2, btn3, btn4, testSolutions, testAnswers, solVis, ansVis, mark, btnbg1, btnbg2, btnbg3, btnbg4);
        t10PostTestListView.setAdapter(viewResultAdapter);

        checkTestCode = dbHandler.checkCode(5739);
        if (checkTestCode == true) {
            t10PostTestEnterPasscode.setVisibility(View.GONE);
            t10PostTestScore.setVisibility(View.VISIBLE);

            scoreAndTime = dbHandler.getScoreTime(5739);
            if (!scoreAndTime.isEmpty()) {
                t10PostTestScoreDisp.setText("Score: " + scoreAndTime.get(SCORE) + "/" + questionLength);
                t10PostTestTimeDisp.setText("Time: " + scoreAndTime.get(TIME));
            }
        } else {
            t10PostTestEnterPasscode.setVisibility(View.VISIBLE);
        }

        t10PostTestBackCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t10PostTestSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t10PostTestPasscode.getText().toString().isEmpty()) {
                    Toast.makeText(TopicTenPostTestActivity.this, "Require passcode", Toast.LENGTH_SHORT).show();
                } else {
                    passcode = Integer.valueOf(t10PostTestPasscode.getText().toString());
                    checkTestCode = dbHandler.checkCode(passcode);

                    if (checkTestCode == true) {
                        Toast.makeText(TopicTenPostTestActivity.this, "You have already taken this test", Toast.LENGTH_SHORT).show();
                    } else {
                        if (passcode.equals(5739)) {
                            t10PostTestEnterPasscode.setVisibility(View.GONE);
                            t10PostTestInstruction.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(TopicTenPostTestActivity.this, "Incorrect passcode", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        t10PostTestInsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t10PostTestInsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t10PostTestInstruction.setVisibility(View.GONE);
                t10PostTestLayout.setVisibility(View.VISIBLE);

                isTestOngoing = true;

                score = 0;
                currentQuestionIndex = 0;
                quizLevel = 1;

                t10PostTestProgress.setMax(questionLength);
                t10PostTestProgress.setProgress(currentQuestionIndex + 1);

                startTime = System.currentTimeMillis();
                NextQuestion();
            }
        });

        t10PostTestNext.setOnClickListener(new View.OnClickListener() {
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
                    t102Questions = question.getG1PostTestQuestion(randomIndex);
                    t102Btn1 = question.getG1PostTestChoice1(randomIndex);
                    t102Btn2 = question.getG1PostTestChoice2(randomIndex);
                    t102Btn3 = question.getG1PostTestChoice3(randomIndex);
                    t102Btn4 = question.getG1PostTestChoice4(randomIndex);
                    t102Solutions = question.getG1PostTestSolution(randomIndex);
                    t102Answers = question.getG1PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t102Questions = question.getG2PostTestQuestion(randomIndex);
                    t102Btn1 = question.getG2PostTestChoice1(randomIndex);
                    t102Btn2 = question.getG2PostTestChoice2(randomIndex);
                    t102Btn3 = question.getG2PostTestChoice3(randomIndex);
                    t102Btn4 = question.getG2PostTestChoice4(randomIndex);
                    t102Solutions = question.getG2PostTestSolution(randomIndex);
                    t102Answers = question.getG2PostTestAnswer(randomIndex);
//                } else if (currentQuestionIndex > 9) {
//                    t102Questions = question.getG3PostTestQuestion(randomIndex);
//                    t102Btn1 = question.getG3PostTestChoice1(randomIndex);
//                    t102Btn2 = question.getG3PostTestChoice2(randomIndex);
//                    t102Btn3 = question.getG3PostTestChoice3(randomIndex);
//                    t102Btn4 = question.getG3PostTestChoice4(randomIndex);
//                    t102Solutions = question.getG3PostTestSolution(randomIndex);
//                    t102Answers = question.getG3PostTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT102Result(new TestResultModelClass(t102Questions, t102Btn1, t102Btn2, t102Btn3, t102Btn4, t102Solutions, t102Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t10PostTestProgress.setProgress(currentQuestionIndex + 1);
                    NextQuestion();
                    resetButtonStyle();
                } else {
                    countDownTimer.cancel();
                    showScore();
                }
            }
        });

        t10PostTestResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t10PostTestScore.setVisibility(View.GONE);
                t10PostTestListView.setVisibility(View.VISIBLE);
                t10PostTestHeader.setVisibility(View.VISIBLE);

                testQuestions.clear();
                btn1.clear();
                btn2.clear();
                btn3.clear();
                btn4.clear();
                testSolutions.clear();
                testAnswers.clear();
                solVis.clear();
                ansVis.clear();

                t10PostTestResultScore.setText("Score " + t10PostTestTotalScore + "/" + questionLength);
                ((ViewResultAdapter) t10PostTestListView.getAdapter()).notifyDataSetChanged();

                int markCheck = R.drawable.round_check_24;
                int markWrong = R.drawable.round_clear_24;
                int btnSlc = R.drawable.custom_selected_button;
                int btnOpt = R.drawable.custom_option_button;

                for (int i = 0; i < questionLength; i++) {
                    TestResultModelClass testResult = dbHandler.getT102Result(i+1);
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

                checkTestCode = dbHandler.checkCode(5739);
                if (checkTestCode == true) {
                    scoreAndTime = dbHandler.getScoreTime(5739);
                    if (!scoreAndTime.isEmpty()) {
                        t10PostTestResultScore.setText("Score " + scoreAndTime.get(SCORE) + "/" + questionLength);
                    }
                }
            }
        });

        t10PostTestResultExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t10PostTestOptA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 1;
                selectedAnswer = t10PostTestOptA.getText().toString();
                t10PostTestNext.setVisibility(View.VISIBLE);
                t10PostTestOptA.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t10PostTestOptA.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t10PostTestOptB, t10PostTestOptC, t10PostTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t10PostTestOptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 2;
                selectedAnswer = t10PostTestOptB.getText().toString();
                t10PostTestNext.setVisibility(View.VISIBLE);
                t10PostTestOptB.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t10PostTestOptB.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t10PostTestOptA, t10PostTestOptC, t10PostTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t10PostTestOptC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 3;
                selectedAnswer = t10PostTestOptC.getText().toString();
                t10PostTestNext.setVisibility(View.VISIBLE);
                t10PostTestOptC.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t10PostTestOptC.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t10PostTestOptA, t10PostTestOptB, t10PostTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t10PostTestOptD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 4;
                selectedAnswer = t10PostTestOptD.getText().toString();
                t10PostTestNext.setVisibility(View.VISIBLE);
                t10PostTestOptD.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t10PostTestOptD.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t10PostTestOptA, t10PostTestOptB, t10PostTestOptC};
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
            Toast.makeText(TopicTenPostTestActivity.this, "Can't go back. Test is ongoing.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(TopicTenPostTestActivity.this, NavigationActivity.class);
            intent.putExtra("loadToTestsFragment", R.id.navigation_tests);
            startActivity(intent);
            finish();
            super.onBackPressed();
        }
    }

    private void NextQuestion() {
        t10PostTestItem.setText((currentQuestionIndex + 1) + " of " + questionLength + " Questions");

        if (quizLevel == 1) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
                quizLevel = 2;
            }
            t10PostTestQuestion.setText(question.getG1PostTestQuestion(randomIndex));
            t10PostTestOptA.setText(question.getG1PostTestChoice1(randomIndex));
            t10PostTestOptB.setText(question.getG1PostTestChoice2(randomIndex));
            t10PostTestOptC.setText(question.getG1PostTestChoice3(randomIndex));
            t10PostTestOptD.setText(question.getG1PostTestChoice4(randomIndex));
            answer = question.getG1PostTestAnswer(randomIndex);
        } else if (quizLevel == 2) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
//                quizLevel = 3;
            }
            t10PostTestQuestion.setText(question.getG2PostTestQuestion(randomIndex));
            t10PostTestOptA.setText(question.getG2PostTestChoice1(randomIndex));
            t10PostTestOptB.setText(question.getG2PostTestChoice2(randomIndex));
            t10PostTestOptC.setText(question.getG2PostTestChoice3(randomIndex));
            t10PostTestOptD.setText(question.getG2PostTestChoice4(randomIndex));
            answer = question.getG2PostTestAnswer(randomIndex);
//        } else if (quizLevel == 3) {
//            do {
//                randomIndex = random.nextInt(5);
//            } while (shownQuestionIndices.contains(randomIndex));
//            shownQuestionIndices.add(randomIndex);
//            if (shownQuestionIndices.size() == 5) {
//                shownQuestionIndices.clear();
//            }
//            t10PostTestQuestion.setText(question.getG3PostTestQuestion(randomIndex));
//            t10PostTestOptA.setText(question.getG3PostTestChoice1(randomIndex));
//            t10PostTestOptB.setText(question.getG3PostTestChoice2(randomIndex));
//            t10PostTestOptC.setText(question.getG3PostTestChoice3(randomIndex));
//            t10PostTestOptD.setText(question.getG3PostTestChoice4(randomIndex));
//            answer = question.getG3PostTestAnswer(randomIndex);
        }

        if ((currentQuestionIndex + 1) < questionLength) {
            t10PostTestNext.setText("Next");
        } else if ((currentQuestionIndex + 1) == questionLength) {
            t10PostTestNext.setText("Submit");
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
                    t102Questions = question.getG1PostTestQuestion(randomIndex);
                    t102Btn1 = question.getG1PostTestChoice1(randomIndex);
                    t102Btn2 = question.getG1PostTestChoice2(randomIndex);
                    t102Btn3 = question.getG1PostTestChoice3(randomIndex);
                    t102Btn4 = question.getG1PostTestChoice4(randomIndex);
                    t102Solutions = question.getG1PostTestSolution(randomIndex);
                    t102Answers = question.getG1PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t102Questions = question.getG2PostTestQuestion(randomIndex);
                    t102Btn1 = question.getG2PostTestChoice1(randomIndex);
                    t102Btn2 = question.getG2PostTestChoice2(randomIndex);
                    t102Btn3 = question.getG2PostTestChoice3(randomIndex);
                    t102Btn4 = question.getG2PostTestChoice4(randomIndex);
                    t102Solutions = question.getG2PostTestSolution(randomIndex);
                    t102Answers = question.getG2PostTestAnswer(randomIndex);
//                } else if (currentQuestionIndex > 9) {
//                    t102Questions = question.getG3PostTestQuestion(randomIndex);
//                    t102Btn1 = question.getG3PostTestChoice1(randomIndex);
//                    t102Btn2 = question.getG3PostTestChoice2(randomIndex);
//                    t102Btn3 = question.getG3PostTestChoice3(randomIndex);
//                    t102Btn4 = question.getG3PostTestChoice4(randomIndex);
//                    t102Solutions = question.getG3PostTestSolution(randomIndex);
//                    t102Answers = question.getG3PostTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT102Result(new TestResultModelClass(t102Questions, t102Btn1, t102Btn2, t102Btn3, t102Btn4, t102Solutions, t102Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t10PostTestProgress.setProgress(currentQuestionIndex + 1);
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
        t10PostTestTimer.setText(timerFormatted);

        if (timeLeftInMillis < 10000) {
            t10PostTestTimer.setTextColor(Color.RED);
        } else {
            t10PostTestTimer.setTextColor(Color.WHITE);
        }

        if (timeLeftInMillis == 0) {
            Toast.makeText(this, "Times Up!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showScore() {
        t10PostTestLayout.setVisibility(View.GONE);
        t10PostTestScore.setVisibility(View.VISIBLE);

        isTestOngoing = false;

        t10PostTestTotalScore = String.valueOf(score);
        t10PostTestScoreDisp.setText("Score: " + t10PostTestTotalScore + "/" + questionLength);

        long endTime = System.currentTimeMillis();
        long timeDiff = endTime - startTime;
        int totalSeconds = (int) (timeDiff / 1000);

        int min = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;
        t10PostTestTotalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
        t10PostTestTimeDisp.setText("Time: " + t10PostTestTotalTime);

        String totalSecs = String.valueOf(totalSeconds);

        dbHandler.storeTestScore(new TestsModelClass(5739, t10PostTestTotalScore, totalSecs));
    }

    private void resetButtonStyle() {
        t10PostTestNext.setVisibility(View.INVISIBLE);
        Button[] buttons = {t10PostTestOptA, t10PostTestOptB, t10PostTestOptC, t10PostTestOptD};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackgroundTintList(null);
            buttons[i].setBackgroundResource(R.drawable.custom_option_button);
            buttons[i].setTextColor(getResources().getColor(R.color.black));
        }
    }
}