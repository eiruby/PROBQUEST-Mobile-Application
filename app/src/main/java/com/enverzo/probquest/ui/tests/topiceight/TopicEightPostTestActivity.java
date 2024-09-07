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

public class TopicEightPostTestActivity extends AppCompatActivity {
    private LinearLayout t8PostTestEnterPasscode, t8PostTestInstruction, t8PostTestLayout;
    private RelativeLayout t8PostTestScore, t8PostTestHeader;
    private ListView t8PostTestListView;
    private EditText t8PostTestPasscode;
    private Button t8PostTestBackCode, t8PostTestSendCode, t8PostTestInsBack, t8PostTestInsStart, t8PostTestOptA, t8PostTestOptB, t8PostTestOptC, t8PostTestOptD, t8PostTestNext, t8PostTestResult;
    private TextView t8PostTestItem, t8PostTestTimer, t8PostTestQuestion, t8PostTestScoreDisp, t8PostTestTimeDisp, t8PostTestResultScore;
    private ProgressBar t8PostTestProgress;
    private ImageView t8PostTestResultExit;
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
    private String answer, selectedAnswer, t8PostTestTotalScore, t8PostTestTotalTime, t82Questions, t82Btn1, t82Btn2, t82Btn3, t82Btn4, t82Solutions, t82Answers;
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
        setContentView(R.layout.activity_topic_eight_post_test);

        random = new Random();
        dbHandler = new DBHandler(this);

        t8PostTestEnterPasscode = findViewById(R.id.t8PostTestEnterPasscode);
        t8PostTestInstruction = findViewById(R.id.t8PostTestInstruction);
        t8PostTestLayout = findViewById(R.id.t8PostTestLayout);
        t8PostTestScore = findViewById(R.id.t8PostTestScore);
        t8PostTestHeader = findViewById(R.id.t8PostTestHeader);
        t8PostTestListView = findViewById(R.id.t8PostTestListView);
        t8PostTestPasscode = findViewById(R.id.t8PostTestPasscode);
        t8PostTestBackCode = findViewById(R.id.t8PostTestBackCode);
        t8PostTestSendCode = findViewById(R.id.t8PostTestSendCode);
        t8PostTestInsBack = findViewById(R.id.t8PostTestInsBack);
        t8PostTestInsStart = findViewById(R.id.t8PostTestInsStart);
        t8PostTestOptA = findViewById(R.id.t8PostTestOptA);
        t8PostTestOptB = findViewById(R.id.t8PostTestOptB);
        t8PostTestOptC = findViewById(R.id.t8PostTestOptC);
        t8PostTestOptD = findViewById(R.id.t8PostTestOptD);
        t8PostTestNext = findViewById(R.id.t8PostTestNext);
        t8PostTestResult = findViewById(R.id.t8PostTestResult);
        t8PostTestItem = findViewById(R.id.t8PostTestItem);
        t8PostTestTimer = findViewById(R.id.t8PostTestTimer);
        t8PostTestQuestion = findViewById(R.id.t8PostTestQuestion);
        t8PostTestScoreDisp = findViewById(R.id.t8PostTestScoreDisp);
        t8PostTestTimeDisp = findViewById(R.id.t8PostTestTimeDisp);
        t8PostTestResultScore = findViewById(R.id.t8PostTestResultScore);
        t8PostTestProgress = findViewById(R.id.t8PostTestProgress);
        t8PostTestResultExit = findViewById(R.id.t8PostTestResultExit);

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

        ViewResultAdapter viewResultAdapter = new ViewResultAdapter(TopicEightPostTestActivity.this, testQuestions, btn1, btn2, btn3, btn4, testSolutions, testAnswers, solVis, ansVis, mark, btnbg1, btnbg2, btnbg3, btnbg4);
        t8PostTestListView.setAdapter(viewResultAdapter);

        checkTestCode = dbHandler.checkCode(5822);
        if (checkTestCode == true) {
            t8PostTestEnterPasscode.setVisibility(View.GONE);
            t8PostTestScore.setVisibility(View.VISIBLE);

            scoreAndTime = dbHandler.getScoreTime(5822);
            if (!scoreAndTime.isEmpty()) {
                t8PostTestScoreDisp.setText("Score: " + scoreAndTime.get(SCORE) + "/" + questionLength);
                t8PostTestTimeDisp.setText("Time: " + scoreAndTime.get(TIME));
            }
        } else {
            t8PostTestEnterPasscode.setVisibility(View.VISIBLE);
        }

        t8PostTestBackCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t8PostTestSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t8PostTestPasscode.getText().toString().isEmpty()) {
                    Toast.makeText(TopicEightPostTestActivity.this, "Require passcode", Toast.LENGTH_SHORT).show();
                } else {
                    passcode = Integer.valueOf(t8PostTestPasscode.getText().toString());
                    checkTestCode = dbHandler.checkCode(passcode);

                    if (checkTestCode == true) {
                        Toast.makeText(TopicEightPostTestActivity.this, "You have already taken this test", Toast.LENGTH_SHORT).show();
                    } else {
                        if (passcode.equals(5822)) {
                            t8PostTestEnterPasscode.setVisibility(View.GONE);
                            t8PostTestInstruction.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(TopicEightPostTestActivity.this, "Incorrect passcode", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        t8PostTestInsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t8PostTestInsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t8PostTestInstruction.setVisibility(View.GONE);
                t8PostTestLayout.setVisibility(View.VISIBLE);

                isTestOngoing = true;

                score = 0;
                currentQuestionIndex = 0;
                quizLevel = 1;

                t8PostTestProgress.setMax(questionLength);
                t8PostTestProgress.setProgress(currentQuestionIndex + 1);

                startTime = System.currentTimeMillis();
                NextQuestion();
            }
        });

        t8PostTestNext.setOnClickListener(new View.OnClickListener() {
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
                    t82Questions = question.getG1PostTestQuestion(randomIndex);
                    t82Btn1 = question.getG1PostTestChoice1(randomIndex);
                    t82Btn2 = question.getG1PostTestChoice2(randomIndex);
                    t82Btn3 = question.getG1PostTestChoice3(randomIndex);
                    t82Btn4 = question.getG1PostTestChoice4(randomIndex);
                    t82Solutions = question.getG1PostTestSolution(randomIndex);
                    t82Answers = question.getG1PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t82Questions = question.getG2PostTestQuestion(randomIndex);
                    t82Btn1 = question.getG2PostTestChoice1(randomIndex);
                    t82Btn2 = question.getG2PostTestChoice2(randomIndex);
                    t82Btn3 = question.getG2PostTestChoice3(randomIndex);
                    t82Btn4 = question.getG2PostTestChoice4(randomIndex);
                    t82Solutions = question.getG2PostTestSolution(randomIndex);
                    t82Answers = question.getG2PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex > 9) {
                    t82Questions = question.getG3PostTestQuestion(randomIndex);
                    t82Btn1 = question.getG3PostTestChoice1(randomIndex);
                    t82Btn2 = question.getG3PostTestChoice2(randomIndex);
                    t82Btn3 = question.getG3PostTestChoice3(randomIndex);
                    t82Btn4 = question.getG3PostTestChoice4(randomIndex);
                    t82Solutions = question.getG3PostTestSolution(randomIndex);
                    t82Answers = question.getG3PostTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT82Result(new TestResultModelClass(t82Questions, t82Btn1, t82Btn2, t82Btn3, t82Btn4, t82Solutions, t82Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t8PostTestProgress.setProgress(currentQuestionIndex + 1);
                    NextQuestion();
                    resetButtonStyle();
                } else {
                    countDownTimer.cancel();
                    showScore();
                }
            }
        });

        t8PostTestResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t8PostTestScore.setVisibility(View.GONE);
                t8PostTestListView.setVisibility(View.VISIBLE);
                t8PostTestHeader.setVisibility(View.VISIBLE);

                testQuestions.clear();
                btn1.clear();
                btn2.clear();
                btn3.clear();
                btn4.clear();
                testSolutions.clear();
                testAnswers.clear();
                solVis.clear();
                ansVis.clear();

                t8PostTestResultScore.setText("Score " + t8PostTestTotalScore + "/" + questionLength);
                ((ViewResultAdapter) t8PostTestListView.getAdapter()).notifyDataSetChanged();

                int markCheck = R.drawable.round_check_24;
                int markWrong = R.drawable.round_clear_24;
                int btnSlc = R.drawable.custom_selected_button;
                int btnOpt = R.drawable.custom_option_button;

                for (int i = 0; i < questionLength; i++) {
                    TestResultModelClass testResult = dbHandler.getT82Result(i+1);
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

                checkTestCode = dbHandler.checkCode(5822);
                if (checkTestCode == true) {
                    scoreAndTime = dbHandler.getScoreTime(5822);
                    if (!scoreAndTime.isEmpty()) {
                        t8PostTestResultScore.setText("Score " + scoreAndTime.get(SCORE) + "/" + questionLength);
                    }
                }
            }
        });

        t8PostTestResultExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t8PostTestOptA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 1;
                selectedAnswer = t8PostTestOptA.getText().toString();
                t8PostTestNext.setVisibility(View.VISIBLE);
                t8PostTestOptA.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t8PostTestOptA.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t8PostTestOptB, t8PostTestOptC, t8PostTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t8PostTestOptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 2;
                selectedAnswer = t8PostTestOptB.getText().toString();
                t8PostTestNext.setVisibility(View.VISIBLE);
                t8PostTestOptB.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t8PostTestOptB.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t8PostTestOptA, t8PostTestOptC, t8PostTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t8PostTestOptC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 3;
                selectedAnswer = t8PostTestOptC.getText().toString();
                t8PostTestNext.setVisibility(View.VISIBLE);
                t8PostTestOptC.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t8PostTestOptC.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t8PostTestOptA, t8PostTestOptB, t8PostTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t8PostTestOptD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 4;
                selectedAnswer = t8PostTestOptD.getText().toString();
                t8PostTestNext.setVisibility(View.VISIBLE);
                t8PostTestOptD.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t8PostTestOptD.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t8PostTestOptA, t8PostTestOptB, t8PostTestOptC};
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
            Toast.makeText(TopicEightPostTestActivity.this, "Can't go back. Test is ongoing.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(TopicEightPostTestActivity.this, NavigationActivity.class);
            intent.putExtra("loadToTestsFragment", R.id.navigation_tests);
            startActivity(intent);
            finish();
            super.onBackPressed();
        }
    }

    private void NextQuestion() {
        t8PostTestItem.setText((currentQuestionIndex + 1) + " of " + questionLength + " Questions");

        if (quizLevel == 1) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
                quizLevel = 2;
            }
            t8PostTestQuestion.setText(question.getG1PostTestQuestion(randomIndex));
            t8PostTestOptA.setText(question.getG1PostTestChoice1(randomIndex));
            t8PostTestOptB.setText(question.getG1PostTestChoice2(randomIndex));
            t8PostTestOptC.setText(question.getG1PostTestChoice3(randomIndex));
            t8PostTestOptD.setText(question.getG1PostTestChoice4(randomIndex));
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
            t8PostTestQuestion.setText(question.getG2PostTestQuestion(randomIndex));
            t8PostTestOptA.setText(question.getG2PostTestChoice1(randomIndex));
            t8PostTestOptB.setText(question.getG2PostTestChoice2(randomIndex));
            t8PostTestOptC.setText(question.getG2PostTestChoice3(randomIndex));
            t8PostTestOptD.setText(question.getG2PostTestChoice4(randomIndex));
            answer = question.getG2PostTestAnswer(randomIndex);
        } else if (quizLevel == 3) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
            }
            t8PostTestQuestion.setText(question.getG3PostTestQuestion(randomIndex));
            t8PostTestOptA.setText(question.getG3PostTestChoice1(randomIndex));
            t8PostTestOptB.setText(question.getG3PostTestChoice2(randomIndex));
            t8PostTestOptC.setText(question.getG3PostTestChoice3(randomIndex));
            t8PostTestOptD.setText(question.getG3PostTestChoice4(randomIndex));
            answer = question.getG3PostTestAnswer(randomIndex);
        }

        if ((currentQuestionIndex + 1) < questionLength) {
            t8PostTestNext.setText("Next");
        } else if ((currentQuestionIndex + 1) == questionLength) {
            t8PostTestNext.setText("Submit");
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
                    t82Questions = question.getG1PostTestQuestion(randomIndex);
                    t82Btn1 = question.getG1PostTestChoice1(randomIndex);
                    t82Btn2 = question.getG1PostTestChoice2(randomIndex);
                    t82Btn3 = question.getG1PostTestChoice3(randomIndex);
                    t82Btn4 = question.getG1PostTestChoice4(randomIndex);
                    t82Solutions = question.getG1PostTestSolution(randomIndex);
                    t82Answers = question.getG1PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t82Questions = question.getG2PostTestQuestion(randomIndex);
                    t82Btn1 = question.getG2PostTestChoice1(randomIndex);
                    t82Btn2 = question.getG2PostTestChoice2(randomIndex);
                    t82Btn3 = question.getG2PostTestChoice3(randomIndex);
                    t82Btn4 = question.getG2PostTestChoice4(randomIndex);
                    t82Solutions = question.getG2PostTestSolution(randomIndex);
                    t82Answers = question.getG2PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex > 9) {
                    t82Questions = question.getG3PostTestQuestion(randomIndex);
                    t82Btn1 = question.getG3PostTestChoice1(randomIndex);
                    t82Btn2 = question.getG3PostTestChoice2(randomIndex);
                    t82Btn3 = question.getG3PostTestChoice3(randomIndex);
                    t82Btn4 = question.getG3PostTestChoice4(randomIndex);
                    t82Solutions = question.getG3PostTestSolution(randomIndex);
                    t82Answers = question.getG3PostTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT82Result(new TestResultModelClass(t82Questions, t82Btn1, t82Btn2, t82Btn3, t82Btn4, t82Solutions, t82Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t8PostTestProgress.setProgress(currentQuestionIndex + 1);
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
        t8PostTestTimer.setText(timerFormatted);

        if (timeLeftInMillis < 10000) {
            t8PostTestTimer.setTextColor(Color.RED);
        } else {
            t8PostTestTimer.setTextColor(Color.WHITE);
        }

        if (timeLeftInMillis == 0) {
            Toast.makeText(this, "Times Up!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showScore() {
        t8PostTestLayout.setVisibility(View.GONE);
        t8PostTestScore.setVisibility(View.VISIBLE);

        isTestOngoing = false;

        t8PostTestTotalScore = String.valueOf(score);
        t8PostTestScoreDisp.setText("Score: " + t8PostTestTotalScore + "/" + questionLength);

        long endTime = System.currentTimeMillis();
        long timeDiff = endTime - startTime;
        int totalSeconds = (int) (timeDiff / 1000);

        int min = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;
        t8PostTestTotalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
        t8PostTestTimeDisp.setText("Time: " + t8PostTestTotalTime);

        String totalSecs = String.valueOf(totalSeconds);

        dbHandler.storeTestScore(new TestsModelClass(5822, t8PostTestTotalScore, totalSecs));
    }

    private void resetButtonStyle() {
        t8PostTestNext.setVisibility(View.INVISIBLE);
        Button[] buttons = {t8PostTestOptA, t8PostTestOptB, t8PostTestOptC, t8PostTestOptD};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackgroundTintList(null);
            buttons[i].setBackgroundResource(R.drawable.custom_option_button);
            buttons[i].setTextColor(getResources().getColor(R.color.black));
        }
    }
}