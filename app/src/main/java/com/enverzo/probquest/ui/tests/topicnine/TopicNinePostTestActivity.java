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

public class TopicNinePostTestActivity extends AppCompatActivity {
    private LinearLayout t9PostTestEnterPasscode, t9PostTestInstruction, t9PostTestLayout;
    private RelativeLayout t9PostTestScore, t9PostTestHeader;
    private ListView t9PostTestListView;
    private EditText t9PostTestPasscode;
    private Button t9PostTestBackCode, t9PostTestSendCode, t9PostTestInsBack, t9PostTestInsStart, t9PostTestOptA, t9PostTestOptB, t9PostTestOptC, t9PostTestOptD, t9PostTestNext, t9PostTestResult;
    private TextView t9PostTestItem, t9PostTestTimer, t9PostTestQuestion, t9PostTestScoreDisp, t9PostTestTimeDisp, t9PostTestResultScore;
    private ProgressBar t9PostTestProgress;
    private ImageView t9PostTestResultExit;
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
    private String answer, solution, selectedAnswer, t9PostTestTotalScore, t9PostTestTotalTime, t92Questions, t92Btn1, t92Btn2, t92Btn3, t92Btn4, t92Solutions, t92Answers;
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
        setContentView(R.layout.activity_topic_nine_post_test);

        random = new Random();
        dbHandler = new DBHandler(this);

        t9PostTestEnterPasscode = findViewById(R.id.t9PostTestEnterPasscode);
        t9PostTestInstruction = findViewById(R.id.t9PostTestInstruction);
        t9PostTestLayout = findViewById(R.id.t9PostTestLayout);
        t9PostTestScore = findViewById(R.id.t9PostTestScore);
        t9PostTestHeader = findViewById(R.id.t9PostTestHeader);
        t9PostTestListView = findViewById(R.id.t9PostTestListView);
        t9PostTestPasscode = findViewById(R.id.t9PostTestPasscode);
        t9PostTestBackCode = findViewById(R.id.t9PostTestBackCode);
        t9PostTestSendCode = findViewById(R.id.t9PostTestSendCode);
        t9PostTestInsBack = findViewById(R.id.t9PostTestInsBack);
        t9PostTestInsStart = findViewById(R.id.t9PostTestInsStart);
        t9PostTestOptA = findViewById(R.id.t9PostTestOptA);
        t9PostTestOptB = findViewById(R.id.t9PostTestOptB);
        t9PostTestOptC = findViewById(R.id.t9PostTestOptC);
        t9PostTestOptD = findViewById(R.id.t9PostTestOptD);
        t9PostTestNext = findViewById(R.id.t9PostTestNext);
        t9PostTestResult = findViewById(R.id.t9PostTestResult);
        t9PostTestItem = findViewById(R.id.t9PostTestItem);
        t9PostTestTimer = findViewById(R.id.t9PostTestTimer);
        t9PostTestQuestion = findViewById(R.id.t9PostTestQuestion);
        t9PostTestScoreDisp = findViewById(R.id.t9PostTestScoreDisp);
        t9PostTestTimeDisp = findViewById(R.id.t9PostTestTimeDisp);
        t9PostTestResultScore = findViewById(R.id.t9PostTestResultScore);
        t9PostTestProgress = findViewById(R.id.t9PostTestProgress);
        t9PostTestResultExit = findViewById(R.id.t9PostTestResultExit);

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

        ViewResultAdapter viewResultAdapter = new ViewResultAdapter(TopicNinePostTestActivity.this, testQuestions, btn1, btn2, btn3, btn4, testSolutions, testAnswers, solVis, ansVis, mark, btnbg1, btnbg2, btnbg3, btnbg4);
        t9PostTestListView.setAdapter(viewResultAdapter);

        checkTestCode = dbHandler.checkCode(4606);
        if (checkTestCode == true) {
            t9PostTestEnterPasscode.setVisibility(View.GONE);
            t9PostTestScore.setVisibility(View.VISIBLE);

            scoreAndTime = dbHandler.getScoreTime(4606);
            if (!scoreAndTime.isEmpty()) {
                t9PostTestScoreDisp.setText("Score: " + scoreAndTime.get(SCORE) + "/" + questionLength);
                t9PostTestTimeDisp.setText("Time: " + scoreAndTime.get(TIME));
            }
        } else {
            t9PostTestEnterPasscode.setVisibility(View.VISIBLE);
        }

        t9PostTestBackCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t9PostTestSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t9PostTestPasscode.getText().toString().isEmpty()) {
                    Toast.makeText(TopicNinePostTestActivity.this, "Require passcode", Toast.LENGTH_SHORT).show();
                } else {
                    passcode = Integer.valueOf(t9PostTestPasscode.getText().toString());
                    checkTestCode = dbHandler.checkCode(passcode);

                    if (checkTestCode == true) {
                        Toast.makeText(TopicNinePostTestActivity.this, "You have already taken this test", Toast.LENGTH_SHORT).show();
                    } else {
                        if (passcode.equals(4606)) {
                            t9PostTestEnterPasscode.setVisibility(View.GONE);
                            t9PostTestInstruction.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(TopicNinePostTestActivity.this, "Incorrect passcode", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        t9PostTestInsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t9PostTestInsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t9PostTestInstruction.setVisibility(View.GONE);
                t9PostTestLayout.setVisibility(View.VISIBLE);

                isTestOngoing = true;

                score = 0;
                currentQuestionIndex = 0;
                quizLevel = 1;

                t9PostTestProgress.setMax(questionLength);
                t9PostTestProgress.setProgress(currentQuestionIndex + 1);

                startTime = System.currentTimeMillis();
                NextQuestion();
            }
        });

        t9PostTestNext.setOnClickListener(new View.OnClickListener() {
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
                    t92Questions = question.getG1PostTestQuestion(randomIndex);
                    t92Btn1 = question.getG1PostTestChoice1(randomIndex);
                    t92Btn2 = question.getG1PostTestChoice2(randomIndex);
                    t92Btn3 = question.getG1PostTestChoice3(randomIndex);
                    t92Btn4 = question.getG1PostTestChoice4(randomIndex);
                    t92Solutions = question.getG1PostTestSolution(randomIndex);
                    t92Answers = question.getG1PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t92Questions = question.getG2PostTestQuestion(randomIndex);
                    t92Btn1 = question.getG2PostTestChoice1(randomIndex);
                    t92Btn2 = question.getG2PostTestChoice2(randomIndex);
                    t92Btn3 = question.getG2PostTestChoice3(randomIndex);
                    t92Btn4 = question.getG2PostTestChoice4(randomIndex);
                    t92Solutions = question.getG2PostTestSolution(randomIndex);
                    t92Answers = question.getG2PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex > 9) {
                    t92Questions = question.getG3PostTestQuestion(randomIndex);
                    t92Btn1 = question.getG3PostTestChoice1(randomIndex);
                    t92Btn2 = question.getG3PostTestChoice2(randomIndex);
                    t92Btn3 = question.getG3PostTestChoice3(randomIndex);
                    t92Btn4 = question.getG3PostTestChoice4(randomIndex);
                    t92Solutions = question.getG3PostTestSolution(randomIndex);
                    t92Answers = question.getG3PostTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT92Result(new TestResultModelClass(t92Questions, t92Btn1, t92Btn2, t92Btn3, t92Btn4, t92Solutions, t92Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t9PostTestProgress.setProgress(currentQuestionIndex + 1);
                    NextQuestion();
                    resetButtonStyle();
                } else {
                    countDownTimer.cancel();
                    showScore();
                }
            }
        });

        t9PostTestResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t9PostTestScore.setVisibility(View.GONE);
                t9PostTestListView.setVisibility(View.VISIBLE);
                t9PostTestHeader.setVisibility(View.VISIBLE);

                testQuestions.clear();
                btn1.clear();
                btn2.clear();
                btn3.clear();
                btn4.clear();
                testSolutions.clear();
                testAnswers.clear();
                solVis.clear();
                ansVis.clear();

                t9PostTestResultScore.setText("Score " + t9PostTestTotalScore + "/" + questionLength);
                ((ViewResultAdapter) t9PostTestListView.getAdapter()).notifyDataSetChanged();

                int markCheck = R.drawable.round_check_24;
                int markWrong = R.drawable.round_clear_24;
                int btnSlc = R.drawable.custom_selected_button;
                int btnOpt = R.drawable.custom_option_button;

                for (int i = 0; i < questionLength; i++) {
                    TestResultModelClass testResult = dbHandler.getT92Result(i+1);
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

                checkTestCode = dbHandler.checkCode(4606);
                if (checkTestCode == true) {
                    scoreAndTime = dbHandler.getScoreTime(4606);
                    if (!scoreAndTime.isEmpty()) {
                        t9PostTestResultScore.setText("Score " + scoreAndTime.get(SCORE) + "/" + questionLength);
                    }
                }
            }
        });

        t9PostTestResultExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t9PostTestOptA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 1;
                selectedAnswer = t9PostTestOptA.getText().toString();
                t9PostTestNext.setVisibility(View.VISIBLE);
                t9PostTestOptA.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t9PostTestOptA.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t9PostTestOptB, t9PostTestOptC, t9PostTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t9PostTestOptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 2;
                selectedAnswer = t9PostTestOptB.getText().toString();
                t9PostTestNext.setVisibility(View.VISIBLE);
                t9PostTestOptB.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t9PostTestOptB.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t9PostTestOptA, t9PostTestOptC, t9PostTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t9PostTestOptC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 3;
                selectedAnswer = t9PostTestOptC.getText().toString();
                t9PostTestNext.setVisibility(View.VISIBLE);
                t9PostTestOptC.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t9PostTestOptC.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t9PostTestOptA, t9PostTestOptB, t9PostTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t9PostTestOptD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 4;
                selectedAnswer = t9PostTestOptD.getText().toString();
                t9PostTestNext.setVisibility(View.VISIBLE);
                t9PostTestOptD.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t9PostTestOptD.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t9PostTestOptA, t9PostTestOptB, t9PostTestOptC};
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
            Toast.makeText(TopicNinePostTestActivity.this, "Can't go back. Test is ongoing.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(TopicNinePostTestActivity.this, NavigationActivity.class);
            intent.putExtra("loadToTestsFragment", R.id.navigation_tests);
            startActivity(intent);
            finish();
            super.onBackPressed();
        }
    }

    private void NextQuestion() {
        t9PostTestItem.setText((currentQuestionIndex + 1) + " of " + questionLength + " Questions");

        if (quizLevel == 1) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
                quizLevel = 2;
            }
            t9PostTestQuestion.setText(question.getG1PostTestQuestion(randomIndex));
            t9PostTestOptA.setText(question.getG1PostTestChoice1(randomIndex));
            t9PostTestOptB.setText(question.getG1PostTestChoice2(randomIndex));
            t9PostTestOptC.setText(question.getG1PostTestChoice3(randomIndex));
            t9PostTestOptD.setText(question.getG1PostTestChoice4(randomIndex));
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
            t9PostTestQuestion.setText(question.getG2PostTestQuestion(randomIndex));
            t9PostTestOptA.setText(question.getG2PostTestChoice1(randomIndex));
            t9PostTestOptB.setText(question.getG2PostTestChoice2(randomIndex));
            t9PostTestOptC.setText(question.getG2PostTestChoice3(randomIndex));
            t9PostTestOptD.setText(question.getG2PostTestChoice4(randomIndex));
            answer = question.getG2PostTestAnswer(randomIndex);
        } else if (quizLevel == 3) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
            }
            t9PostTestQuestion.setText(question.getG3PostTestQuestion(randomIndex));
            t9PostTestOptA.setText(question.getG3PostTestChoice1(randomIndex));
            t9PostTestOptB.setText(question.getG3PostTestChoice2(randomIndex));
            t9PostTestOptC.setText(question.getG3PostTestChoice3(randomIndex));
            t9PostTestOptD.setText(question.getG3PostTestChoice4(randomIndex));
            answer = question.getG3PostTestAnswer(randomIndex);
        }

        if ((currentQuestionIndex + 1) < questionLength) {
            t9PostTestNext.setText("Next");
        } else if ((currentQuestionIndex + 1) == questionLength) {
            t9PostTestNext.setText("Submit");
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
                    t92Questions = question.getG1PostTestQuestion(randomIndex);
                    t92Btn1 = question.getG1PostTestChoice1(randomIndex);
                    t92Btn2 = question.getG1PostTestChoice2(randomIndex);
                    t92Btn3 = question.getG1PostTestChoice3(randomIndex);
                    t92Btn4 = question.getG1PostTestChoice4(randomIndex);
                    t92Solutions = question.getG1PostTestSolution(randomIndex);
                    t92Answers = question.getG1PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t92Questions = question.getG2PostTestQuestion(randomIndex);
                    t92Btn1 = question.getG2PostTestChoice1(randomIndex);
                    t92Btn2 = question.getG2PostTestChoice2(randomIndex);
                    t92Btn3 = question.getG2PostTestChoice3(randomIndex);
                    t92Btn4 = question.getG2PostTestChoice4(randomIndex);
                    t92Solutions = question.getG2PostTestSolution(randomIndex);
                    t92Answers = question.getG2PostTestAnswer(randomIndex);
                } else if (currentQuestionIndex > 9) {
                    t92Questions = question.getG3PostTestQuestion(randomIndex);
                    t92Btn1 = question.getG3PostTestChoice1(randomIndex);
                    t92Btn2 = question.getG3PostTestChoice2(randomIndex);
                    t92Btn3 = question.getG3PostTestChoice3(randomIndex);
                    t92Btn4 = question.getG3PostTestChoice4(randomIndex);
                    t92Solutions = question.getG3PostTestSolution(randomIndex);
                    t92Answers = question.getG3PostTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT92Result(new TestResultModelClass(t92Questions, t92Btn1, t92Btn2, t92Btn3, t92Btn4, t92Solutions, t92Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t9PostTestProgress.setProgress(currentQuestionIndex + 1);
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
        t9PostTestTimer.setText(timerFormatted);

        if (timeLeftInMillis < 10000) {
            t9PostTestTimer.setTextColor(Color.RED);
        } else {
            t9PostTestTimer.setTextColor(Color.WHITE);
        }

        if (timeLeftInMillis == 0) {
            Toast.makeText(this, "Times Up!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showScore() {
        t9PostTestLayout.setVisibility(View.GONE);
        t9PostTestScore.setVisibility(View.VISIBLE);

        isTestOngoing = false;

        t9PostTestTotalScore = String.valueOf(score);
        t9PostTestScoreDisp.setText("Score: " + t9PostTestTotalScore + "/" + questionLength);

        long endTime = System.currentTimeMillis();
        long timeDiff = endTime - startTime;
        int totalSeconds = (int) (timeDiff / 1000);

        int min = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;
        t9PostTestTotalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
        t9PostTestTimeDisp.setText("Time: " + t9PostTestTotalTime);

        String totalSecs = String.valueOf(totalSeconds);

        dbHandler.storeTestScore(new TestsModelClass(4606, t9PostTestTotalScore, totalSecs));
    }

    private void resetButtonStyle() {
        t9PostTestNext.setVisibility(View.INVISIBLE);
        Button[] buttons = {t9PostTestOptA, t9PostTestOptB, t9PostTestOptC, t9PostTestOptD};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackgroundTintList(null);
            buttons[i].setBackgroundResource(R.drawable.custom_option_button);
            buttons[i].setTextColor(getResources().getColor(R.color.black));
        }
    }
}