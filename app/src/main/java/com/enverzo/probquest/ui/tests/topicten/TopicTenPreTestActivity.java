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

public class TopicTenPreTestActivity extends AppCompatActivity {
    private LinearLayout t10PreTestEnterPasscode, t10PreTestInstruction, t10PreTestLayout;
    private RelativeLayout t10PreTestScore, t10PreTestHeader;
    private ListView t10PreTestListView;
    private EditText t10PreTestPasscode;
    private Button t10PreTestBackCode, t10PreTestSendCode, t10PreTestInsBack, t10PreTestInsStart, t10PreTestOptA, t10PreTestOptB, t10PreTestOptC, t10PreTestOptD, t10PreTestNext, t10PreTestResult;
    private TextView t10PreTestItem, t10PreTestTimer, t10PreTestQuestion, t10PreTestScoreDisp, t10PreTestTimeDisp, t10PreTestResultScore;
    private ProgressBar t10PreTestProgress;
    private ImageView t10PreTestResultExit;
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
    private String answer, solution, selectedAnswer, t10PreTestTotalScore, t10PreTestTotalTime, t101Questions, t101Btn1, t101Btn2, t101Btn3, t101Btn4, t101Solutions, t101Answers;
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
        setContentView(R.layout.activity_topic_ten_pre_test);

        random = new Random();
        dbHandler = new DBHandler(this);

        t10PreTestEnterPasscode = findViewById(R.id.t10PreTestEnterPasscode);
        t10PreTestInstruction = findViewById(R.id.t10PreTestInstruction);
        t10PreTestLayout = findViewById(R.id.t10PreTestLayout);
        t10PreTestScore = findViewById(R.id.t10PreTestScore);
        t10PreTestHeader = findViewById(R.id.t10PreTestHeader);
        t10PreTestListView = findViewById(R.id.t10PreTestListView);
        t10PreTestPasscode = findViewById(R.id.t10PreTestPasscode);
        t10PreTestBackCode = findViewById(R.id.t10PreTestBackCode);
        t10PreTestSendCode = findViewById(R.id.t10PreTestSendCode);
        t10PreTestInsBack = findViewById(R.id.t10PreTestInsBack);
        t10PreTestInsStart = findViewById(R.id.t10PreTestInsStart);
        t10PreTestOptA = findViewById(R.id.t10PreTestOptA);
        t10PreTestOptB = findViewById(R.id.t10PreTestOptB);
        t10PreTestOptC = findViewById(R.id.t10PreTestOptC);
        t10PreTestOptD = findViewById(R.id.t10PreTestOptD);
        t10PreTestNext = findViewById(R.id.t10PreTestNext);
        t10PreTestResult = findViewById(R.id.t10PreTestResult);
        t10PreTestItem = findViewById(R.id.t10PreTestItem);
        t10PreTestTimer = findViewById(R.id.t10PreTestTimer);
        t10PreTestQuestion = findViewById(R.id.t10PreTestQuestion);
        t10PreTestScoreDisp = findViewById(R.id.t10PreTestScoreDisp);
        t10PreTestTimeDisp = findViewById(R.id.t10PreTestTimeDisp);
        t10PreTestResultScore = findViewById(R.id.t10PreTestResultScore);
        t10PreTestProgress = findViewById(R.id.t10PreTestProgress);
        t10PreTestResultExit = findViewById(R.id.t10PreTestResultExit);

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

        ViewResultAdapter viewResultAdapter = new ViewResultAdapter(TopicTenPreTestActivity.this, testQuestions, btn1, btn2, btn3, btn4, testSolutions, testAnswers, solVis, ansVis, mark, btnbg1, btnbg2, btnbg3, btnbg4);
        t10PreTestListView.setAdapter(viewResultAdapter);

        checkTestCode = dbHandler.checkCode(2768);
        if (checkTestCode == true) {
            t10PreTestEnterPasscode.setVisibility(View.GONE);
            t10PreTestScore.setVisibility(View.VISIBLE);

            scoreAndTime = dbHandler.getScoreTime(2768);
            if (!scoreAndTime.isEmpty()) {
                t10PreTestScoreDisp.setText("Score: " + scoreAndTime.get(SCORE) + "/" + questionLength);
                int totalSeconds = Integer.parseInt(scoreAndTime.get(TIME));
                int min = (totalSeconds % 3600) / 60;
                int secs = totalSeconds % 60;
                String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
                t10PreTestTimeDisp.setText("Time: " + totalTime);
            }
        } else {
            t10PreTestEnterPasscode.setVisibility(View.VISIBLE);
        }

        t10PreTestBackCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t10PreTestSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t10PreTestPasscode.getText().toString().isEmpty()) {
                    Toast.makeText(TopicTenPreTestActivity.this, "Require passcode", Toast.LENGTH_SHORT).show();
                } else {
                    passcode = Integer.valueOf(t10PreTestPasscode.getText().toString());
                    checkTestCode = dbHandler.checkCode(passcode);

                    if (checkTestCode == true) {
                        Toast.makeText(TopicTenPreTestActivity.this, "You have already taken this test", Toast.LENGTH_SHORT).show();
                    } else {
                        if (passcode.equals(2768)) {
                            t10PreTestEnterPasscode.setVisibility(View.GONE);
                            t10PreTestInstruction.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(TopicTenPreTestActivity.this, "Incorrect passcode", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        t10PreTestInsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t10PreTestInsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t10PreTestInstruction.setVisibility(View.GONE);
                t10PreTestLayout.setVisibility(View.VISIBLE);

                isTestOngoing = true;

                score = 0;
                currentQuestionIndex = 0;
                quizLevel = 1;

                t10PreTestProgress.setMax(questionLength);
                t10PreTestProgress.setProgress(currentQuestionIndex + 1);

                startTime = System.currentTimeMillis();
                NextQuestion();
            }
        });

        t10PreTestNext.setOnClickListener(new View.OnClickListener() {
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
                    t101Questions = question.getG1PreTestQuestion(randomIndex);
                    t101Btn1 = question.getG1PreTestChoice1(randomIndex);
                    t101Btn2 = question.getG1PreTestChoice2(randomIndex);
                    t101Btn3 = question.getG1PreTestChoice3(randomIndex);
                    t101Btn4 = question.getG1PreTestChoice4(randomIndex);
                    t101Solutions = question.getG1PreTestSolution(randomIndex);
                    t101Answers = question.getG1PreTestAnswer(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t101Questions = question.getG2PreTestQuestion(randomIndex);
                    t101Btn1 = question.getG2PreTestChoice1(randomIndex);
                    t101Btn2 = question.getG2PreTestChoice2(randomIndex);
                    t101Btn3 = question.getG2PreTestChoice3(randomIndex);
                    t101Btn4 = question.getG2PreTestChoice4(randomIndex);
                    t101Solutions = question.getG2PreTestSolution(randomIndex);
                    t101Answers = question.getG2PreTestAnswer(randomIndex);
//                } else if (currentQuestionIndex > 9) {
//                    t101Questions = question.getG3PreTestQuestion(randomIndex);
//                    t101Btn1 = question.getG3PreTestChoice1(randomIndex);
//                    t101Btn2 = question.getG3PreTestChoice2(randomIndex);
//                    t101Btn3 = question.getG3PreTestChoice3(randomIndex);
//                    t101Btn4 = question.getG3PreTestChoice4(randomIndex);
//                    t101Solutions = question.getG3PreTestSolution(randomIndex);
//                    t101Answers = question.getG3PreTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT101Result(new TestResultModelClass(t101Questions, t101Btn1, t101Btn2, t101Btn3, t101Btn4, t101Solutions, t101Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t10PreTestProgress.setProgress(currentQuestionIndex + 1);
                    NextQuestion();
                    resetButtonStyle();
                } else {
                    countDownTimer.cancel();
                    showScore();
                }
            }
        });

        t10PreTestResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t10PreTestScore.setVisibility(View.GONE);
                t10PreTestListView.setVisibility(View.VISIBLE);
                t10PreTestHeader.setVisibility(View.VISIBLE);

                testQuestions.clear();
                btn1.clear();
                btn2.clear();
                btn3.clear();
                btn4.clear();
                testSolutions.clear();
                testAnswers.clear();
                solVis.clear();
                ansVis.clear();

                t10PreTestResultScore.setText("Score " + t10PreTestTotalScore + "/" + questionLength);
                ((ViewResultAdapter) t10PreTestListView.getAdapter()).notifyDataSetChanged();

                int markCheck = R.drawable.round_check_24;
                int markWrong = R.drawable.round_clear_24;
                int btnSlc = R.drawable.custom_selected_button;
                int btnOpt = R.drawable.custom_option_button;

                for (int i = 0; i < questionLength; i++) {
                    TestResultModelClass testResult = dbHandler.getT101Result(i+1);
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

                checkTestCode = dbHandler.checkCode(2768);
                if (checkTestCode == true) {
                    scoreAndTime = dbHandler.getScoreTime(2768);
                    if (!scoreAndTime.isEmpty()) {
                        t10PreTestResultScore.setText("Score " + scoreAndTime.get(SCORE) + "/" + questionLength);
                    }
                }
            }
        });

        t10PreTestResultExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t10PreTestOptA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 1;
                selectedAnswer = t10PreTestOptA.getText().toString();
                t10PreTestNext.setVisibility(View.VISIBLE);
                t10PreTestOptA.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t10PreTestOptA.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t10PreTestOptB, t10PreTestOptC, t10PreTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t10PreTestOptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 2;
                selectedAnswer = t10PreTestOptB.getText().toString();
                t10PreTestNext.setVisibility(View.VISIBLE);
                t10PreTestOptB.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t10PreTestOptB.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t10PreTestOptA, t10PreTestOptC, t10PreTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t10PreTestOptC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 3;
                selectedAnswer = t10PreTestOptC.getText().toString();
                t10PreTestNext.setVisibility(View.VISIBLE);
                t10PreTestOptC.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t10PreTestOptC.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t10PreTestOptA, t10PreTestOptB, t10PreTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t10PreTestOptD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 4;
                selectedAnswer = t10PreTestOptD.getText().toString();
                t10PreTestNext.setVisibility(View.VISIBLE);
                t10PreTestOptD.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t10PreTestOptD.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t10PreTestOptA, t10PreTestOptB, t10PreTestOptC};
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
            Toast.makeText(TopicTenPreTestActivity.this, "Can't go back. Test is ongoing.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(TopicTenPreTestActivity.this, NavigationActivity.class);
            intent.putExtra("loadToTestsFragment", R.id.navigation_tests);
            startActivity(intent);
            finish();
            super.onBackPressed();
        }
    }

    private void NextQuestion() {
        t10PreTestItem.setText((currentQuestionIndex + 1) + " of " + questionLength + " Questions");

        if (quizLevel == 1) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
                quizLevel = 2;
            }
            t10PreTestQuestion.setText(question.getG1PreTestQuestion(randomIndex));
            t10PreTestOptA.setText(question.getG1PreTestChoice1(randomIndex));
            t10PreTestOptB.setText(question.getG1PreTestChoice2(randomIndex));
            t10PreTestOptC.setText(question.getG1PreTestChoice3(randomIndex));
            t10PreTestOptD.setText(question.getG1PreTestChoice4(randomIndex));
            answer = question.getG1PreTestAnswer(randomIndex);
        } else if (quizLevel == 2) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
//                quizLevel = 3;
            }
            t10PreTestQuestion.setText(question.getG2PreTestQuestion(randomIndex));
            t10PreTestOptA.setText(question.getG2PreTestChoice1(randomIndex));
            t10PreTestOptB.setText(question.getG2PreTestChoice2(randomIndex));
            t10PreTestOptC.setText(question.getG2PreTestChoice3(randomIndex));
            t10PreTestOptD.setText(question.getG2PreTestChoice4(randomIndex));
            answer = question.getG2PreTestAnswer(randomIndex);
//        } else if (quizLevel == 3) {
//            do {
//                randomIndex = random.nextInt(5);
//            } while (shownQuestionIndices.contains(randomIndex));
//            shownQuestionIndices.add(randomIndex);
//            if (shownQuestionIndices.size() == 5) {
//                shownQuestionIndices.clear();
//            }
//            t10PreTestQuestion.setText(question.getG3PreTestQuestion(randomIndex));
//            t10PreTestOptA.setText(question.getG3PreTestChoice1(randomIndex));
//            t10PreTestOptB.setText(question.getG3PreTestChoice2(randomIndex));
//            t10PreTestOptC.setText(question.getG3PreTestChoice3(randomIndex));
//            t10PreTestOptD.setText(question.getG3PreTestChoice4(randomIndex));
//            answer = question.getG3PreTestAnswer(randomIndex);
        }

        if ((currentQuestionIndex + 1) < questionLength) {
            t10PreTestNext.setText("Next");
        } else if ((currentQuestionIndex + 1) == questionLength) {
            t10PreTestNext.setText("Submit");
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
                    t101Questions = question.getG1PreTestQuestion(randomIndex);
                    t101Btn1 = question.getG1PreTestChoice1(randomIndex);
                    t101Btn2 = question.getG1PreTestChoice2(randomIndex);
                    t101Btn3 = question.getG1PreTestChoice3(randomIndex);
                    t101Btn4 = question.getG1PreTestChoice4(randomIndex);
                    t101Solutions = question.getG1PreTestSolution(randomIndex);
                    t101Answers = question.getG1PreTestAnswer(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t101Questions = question.getG2PreTestQuestion(randomIndex);
                    t101Btn1 = question.getG2PreTestChoice1(randomIndex);
                    t101Btn2 = question.getG2PreTestChoice2(randomIndex);
                    t101Btn3 = question.getG2PreTestChoice3(randomIndex);
                    t101Btn4 = question.getG2PreTestChoice4(randomIndex);
                    t101Solutions = question.getG2PreTestSolution(randomIndex);
                    t101Answers = question.getG2PreTestAnswer(randomIndex);
//                } else if (currentQuestionIndex > 9) {
//                    t101Questions = question.getG3PreTestQuestion(randomIndex);
//                    t101Btn1 = question.getG3PreTestChoice1(randomIndex);
//                    t101Btn2 = question.getG3PreTestChoice2(randomIndex);
//                    t101Btn3 = question.getG3PreTestChoice3(randomIndex);
//                    t101Btn4 = question.getG3PreTestChoice4(randomIndex);
//                    t101Solutions = question.getG3PreTestSolution(randomIndex);
//                    t101Answers = question.getG3PreTestAnswer(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT101Result(new TestResultModelClass(t101Questions, t101Btn1, t101Btn2, t101Btn3, t101Btn4, t101Solutions, t101Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t10PreTestProgress.setProgress(currentQuestionIndex + 1);
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
        t10PreTestTimer.setText(timerFormatted);

        if (timeLeftInMillis < 10000) {
            t10PreTestTimer.setTextColor(Color.RED);
        } else {
            t10PreTestTimer.setTextColor(Color.WHITE);
        }

        if (timeLeftInMillis == 0) {
            Toast.makeText(this, "Times Up!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showScore() {
        t10PreTestLayout.setVisibility(View.GONE);
        t10PreTestScore.setVisibility(View.VISIBLE);

        isTestOngoing = false;

        t10PreTestTotalScore = String.valueOf(score);
        t10PreTestScoreDisp.setText("Score: " + t10PreTestTotalScore + "/" + questionLength);

        long endTime = System.currentTimeMillis();
        long timeDiff = endTime - startTime;
        int totalSeconds = (int) (timeDiff / 1000);

        int min = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;
        t10PreTestTotalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
        t10PreTestTimeDisp.setText("Time: " + t10PreTestTotalTime);

        String totalSecs = String.valueOf(totalSeconds);

        dbHandler.storeTestScore(new TestsModelClass(2768, t10PreTestTotalScore, totalSecs));
    }

    private void resetButtonStyle() {
        t10PreTestNext.setVisibility(View.INVISIBLE);
        Button[] buttons = {t10PreTestOptA, t10PreTestOptB, t10PreTestOptC, t10PreTestOptD};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackgroundTintList(null);
            buttons[i].setBackgroundResource(R.drawable.custom_option_button);
            buttons[i].setTextColor(getResources().getColor(R.color.black));
        }
    }
}