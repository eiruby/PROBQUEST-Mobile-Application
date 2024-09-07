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

public class TopicTwelvePostTestActivity extends AppCompatActivity {
    private LinearLayout t12PostTestEnterPasscode, t12PostTestInstruction, t12PostTestLayout;
    private RelativeLayout t12PostTestScore, t12PostTestHeader;
    private ListView t12PostTestListView;
    private EditText t12PostTestPasscode;
    private Button t12PostTestBackCode, t12PostTestSendCode, t12PostTestInsBack, t12PostTestInsStart, t12PostTestOptA, t12PostTestOptB, t12PostTestOptC, t12PostTestOptD, t12PostTestNext, t12PostTestResult;
    private TextView t12PostTestItem, t12PostTestTimer, t12PostTestQuestion, t12PostTestScoreDisp, t12PostTestTimeDisp, t12PostTestResultScore;
    private ProgressBar t12PostTestProgress;
    private ImageView t12PostTestResultExit;
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
    private String answer, solution, selectedAnswer, t12PostTestTotalScore, t12PostTestTotalTime, t122Questions, t122Btn1, t122Btn2, t122Btn3, t122Btn4, t122Solutions, t122Answers;
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
        setContentView(R.layout.activity_topic_twelve_post_test);

        random = new Random();
        dbHandler = new DBHandler(this);

        t12PostTestEnterPasscode = findViewById(R.id.t12PostTestEnterPasscode);
        t12PostTestInstruction = findViewById(R.id.t12PostTestInstruction);
        t12PostTestLayout = findViewById(R.id.t12PostTestLayout);
        t12PostTestScore = findViewById(R.id.t12PostTestScore);
        t12PostTestHeader = findViewById(R.id.t12PostTestHeader);
        t12PostTestListView = findViewById(R.id.t12PostTestListView);
        t12PostTestPasscode = findViewById(R.id.t12PostTestPasscode);
        t12PostTestBackCode = findViewById(R.id.t12PostTestBackCode);
        t12PostTestSendCode = findViewById(R.id.t12PostTestSendCode);
        t12PostTestInsBack = findViewById(R.id.t12PostTestInsBack);
        t12PostTestInsStart = findViewById(R.id.t12PostTestInsStart);
        t12PostTestOptA = findViewById(R.id.t12PostTestOptA);
        t12PostTestOptB = findViewById(R.id.t12PostTestOptB);
        t12PostTestOptC = findViewById(R.id.t12PostTestOptC);
        t12PostTestOptD = findViewById(R.id.t12PostTestOptD);
        t12PostTestNext = findViewById(R.id.t12PostTestNext);
        t12PostTestResult = findViewById(R.id.t12PostTestResult);
        t12PostTestItem = findViewById(R.id.t12PostTestItem);
        t12PostTestTimer = findViewById(R.id.t12PostTestTimer);
        t12PostTestQuestion = findViewById(R.id.t12PostTestQuestion);
        t12PostTestScoreDisp = findViewById(R.id.t12PostTestScoreDisp);
        t12PostTestTimeDisp = findViewById(R.id.t12PostTestTimeDisp);
        t12PostTestResultScore = findViewById(R.id.t12PostTestResultScore);
        t12PostTestProgress = findViewById(R.id.t12PostTestProgress);
        t12PostTestResultExit = findViewById(R.id.t12PostTestResultExit);

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

        ViewResultAdapter viewResultAdapter = new ViewResultAdapter(TopicTwelvePostTestActivity.this, testQuestions, btn1, btn2, btn3, btn4, testSolutions, testAnswers, solVis, ansVis, mark, btnbg1, btnbg2, btnbg3, btnbg4);
        t12PostTestListView.setAdapter(viewResultAdapter);

        checkTestCode = dbHandler.checkCode(5038);
        if (checkTestCode == true) {
            t12PostTestEnterPasscode.setVisibility(View.GONE);
            t12PostTestScore.setVisibility(View.VISIBLE);

            scoreAndTime = dbHandler.getScoreTime(5038);
            if (!scoreAndTime.isEmpty()) {
                t12PostTestScoreDisp.setText("Score: " + scoreAndTime.get(SCORE) + "/" + questionLength);
                t12PostTestTimeDisp.setText("Time: " + scoreAndTime.get(TIME));
            }
        } else {
            t12PostTestEnterPasscode.setVisibility(View.VISIBLE);
        }

        t12PostTestBackCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t12PostTestSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t12PostTestPasscode.getText().toString().isEmpty()) {
                    Toast.makeText(TopicTwelvePostTestActivity.this, "Require passcode", Toast.LENGTH_SHORT).show();
                } else {
                    passcode = Integer.valueOf(t12PostTestPasscode.getText().toString());
                    checkTestCode = dbHandler.checkCode(passcode);

                    if (checkTestCode == true) {
                        Toast.makeText(TopicTwelvePostTestActivity.this, "You have already taken this test", Toast.LENGTH_SHORT).show();
                    } else {
                        if (passcode.equals(5038)) {
                            t12PostTestEnterPasscode.setVisibility(View.GONE);
                            t12PostTestInstruction.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(TopicTwelvePostTestActivity.this, "Incorrect passcode", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        t12PostTestInsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t12PostTestInsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t12PostTestInstruction.setVisibility(View.GONE);
                t12PostTestLayout.setVisibility(View.VISIBLE);

                isTestOngoing = true;

                score = 0;
                currentQuestionIndex = 0;
                quizLevel = 1;

                t12PostTestProgress.setMax(questionLength);
                t12PostTestProgress.setProgress(currentQuestionIndex + 1);

                startTime = System.currentTimeMillis();
                NextQuestion();
            }
        });

        t12PostTestNext.setOnClickListener(new View.OnClickListener() {
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
                    t122Questions = question.getG1PostTestQuestion(randomIndex);
                    t122Btn1 = question.getG1PostTestChoice1(randomIndex);
                    t122Btn2 = question.getG1PostTestChoice2(randomIndex);
                    t122Btn3 = question.getG1PostTestChoice3(randomIndex);
                    t122Btn4 = question.getG1PostTestChoice4(randomIndex);
                    t122Solutions = question.getG1PostTestSolution(randomIndex);
                    t122Answers = question.getG1PostTestSolution(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t122Questions = question.getG2PostTestQuestion(randomIndex);
                    t122Btn1 = question.getG2PostTestChoice1(randomIndex);
                    t122Btn2 = question.getG2PostTestChoice2(randomIndex);
                    t122Btn3 = question.getG2PostTestChoice3(randomIndex);
                    t122Btn4 = question.getG2PostTestChoice4(randomIndex);
                    t122Solutions = question.getG2PostTestSolution(randomIndex);
                    t122Answers = question.getG2PostTestSolution(randomIndex);
//                } else if (currentQuestionIndex > 9) {
//                    t122Questions = question.getG3PostTestQuestion(randomIndex);
//                    t122Btn1 = question.getG3PostTestChoice1(randomIndex);
//                    t122Btn2 = question.getG3PostTestChoice2(randomIndex);
//                    t122Btn3 = question.getG3PostTestChoice3(randomIndex);
//                    t122Btn4 = question.getG3PostTestChoice4(randomIndex);
//                    t122Solutions = question.getG3PostTestSolution(randomIndex);
//                    t122Answers = question.getG3PostTestSolution(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT122Result(new TestResultModelClass(t122Questions, t122Btn1, t122Btn2, t122Btn3, t122Btn4, t122Solutions, t122Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t12PostTestProgress.setProgress(currentQuestionIndex + 1);
                    NextQuestion();
                    resetButtonStyle();
                } else {
                    countDownTimer.cancel();
                    showScore();
                }
            }
        });

        t12PostTestResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t12PostTestScore.setVisibility(View.GONE);
                t12PostTestListView.setVisibility(View.VISIBLE);
                t12PostTestHeader.setVisibility(View.VISIBLE);

                testQuestions.clear();
                btn1.clear();
                btn2.clear();
                btn3.clear();
                btn4.clear();
                testSolutions.clear();
                testAnswers.clear();
                solVis.clear();
                ansVis.clear();

                t12PostTestResultScore.setText("Score " + t12PostTestTotalScore + "/" + questionLength);
                ((ViewResultAdapter) t12PostTestListView.getAdapter()).notifyDataSetChanged();

                int markCheck = R.drawable.round_check_24;
                int markWrong = R.drawable.round_clear_24;
                int btnSlc = R.drawable.custom_selected_button;
                int btnOpt = R.drawable.custom_option_button;

                for (int i = 0; i < questionLength; i++) {
                    TestResultModelClass testResult = dbHandler.getT122Result(i+1);
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

                checkTestCode = dbHandler.checkCode(5038);
                if (checkTestCode == true) {
                    scoreAndTime = dbHandler.getScoreTime(5038);
                    if (!scoreAndTime.isEmpty()) {
                        t12PostTestResultScore.setText("Score " + scoreAndTime.get(SCORE) + "/" + questionLength);
                    }
                }
            }
        });

        t12PostTestResultExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t12PostTestOptA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 1;
                selectedAnswer = t12PostTestOptA.getText().toString();
                t12PostTestNext.setVisibility(View.VISIBLE);
                t12PostTestOptA.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t12PostTestOptA.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t12PostTestOptB, t12PostTestOptC, t12PostTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t12PostTestOptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 2;
                selectedAnswer = t12PostTestOptB.getText().toString();
                t12PostTestNext.setVisibility(View.VISIBLE);
                t12PostTestOptB.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t12PostTestOptB.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t12PostTestOptA, t12PostTestOptC, t12PostTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t12PostTestOptC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 3;
                selectedAnswer = t12PostTestOptC.getText().toString();
                t12PostTestNext.setVisibility(View.VISIBLE);
                t12PostTestOptC.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t12PostTestOptC.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t12PostTestOptA, t12PostTestOptB, t12PostTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t12PostTestOptD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 4;
                selectedAnswer = t12PostTestOptD.getText().toString();
                t12PostTestNext.setVisibility(View.VISIBLE);
                t12PostTestOptD.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t12PostTestOptD.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t12PostTestOptA, t12PostTestOptB, t12PostTestOptC};
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
            Toast.makeText(TopicTwelvePostTestActivity.this, "Can't go back. Test is ongoing.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(TopicTwelvePostTestActivity.this, NavigationActivity.class);
            intent.putExtra("loadToTestsFragment", R.id.navigation_tests);
            startActivity(intent);
            finish();
            super.onBackPressed();
        }
    }

    private void NextQuestion() {
        t12PostTestItem.setText((currentQuestionIndex + 1) + " of " + questionLength + " Questions");

        if (quizLevel == 1) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
                quizLevel = 2;
            }
            t12PostTestQuestion.setText(question.getG1PostTestQuestion(randomIndex));
            t12PostTestOptA.setText(question.getG1PostTestChoice1(randomIndex));
            t12PostTestOptB.setText(question.getG1PostTestChoice2(randomIndex));
            t12PostTestOptC.setText(question.getG1PostTestChoice3(randomIndex));
            t12PostTestOptD.setText(question.getG1PostTestChoice4(randomIndex));
            answer = question.getG1PostTestCorrectAnswer(randomIndex);
            solution = question.getG1PostTestSolution(randomIndex);
        } else if (quizLevel == 2) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
//                quizLevel = 3;
            }
            t12PostTestQuestion.setText(question.getG2PostTestQuestion(randomIndex));
            t12PostTestOptA.setText(question.getG2PostTestChoice1(randomIndex));
            t12PostTestOptB.setText(question.getG2PostTestChoice2(randomIndex));
            t12PostTestOptC.setText(question.getG2PostTestChoice3(randomIndex));
            t12PostTestOptD.setText(question.getG2PostTestChoice4(randomIndex));
            answer = question.getG2PostTestCorrectAnswer(randomIndex);
            solution = question.getG2PostTestSolution(randomIndex);
//        } else if (quizLevel == 3) {
//            do {
//                randomIndex = random.nextInt(5);
//            } while (shownQuestionIndices.contains(randomIndex));
//            shownQuestionIndices.add(randomIndex);
//            if (shownQuestionIndices.size() == 5) {
//                shownQuestionIndices.clear();
//            }
//            t12PostTestQuestion.setText(question.getG3PostTestQuestion(randomIndex));
//            t12PostTestOptA.setText(question.getG3PostTestChoice1(randomIndex));
//            t12PostTestOptB.setText(question.getG3PostTestChoice2(randomIndex));
//            t12PostTestOptC.setText(question.getG3PostTestChoice3(randomIndex));
//            t12PostTestOptD.setText(question.getG3PostTestChoice4(randomIndex));
//            answer = question.getG3PostTestCorrectAnswer(randomIndex);
//            solution = question.getG3PostTestSolution(randomIndex);
        }

        if ((currentQuestionIndex + 1) < questionLength) {
            t12PostTestNext.setText("Next");
        } else if ((currentQuestionIndex + 1) == questionLength) {
            t12PostTestNext.setText("Submit");
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
                    t122Questions = question.getG1PostTestQuestion(randomIndex);
                    t122Btn1 = question.getG1PostTestChoice1(randomIndex);
                    t122Btn2 = question.getG1PostTestChoice2(randomIndex);
                    t122Btn3 = question.getG1PostTestChoice3(randomIndex);
                    t122Btn4 = question.getG1PostTestChoice4(randomIndex);
                    t122Solutions = question.getG1PostTestSolution(randomIndex);
                    t122Answers = question.getG1PostTestSolution(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t122Questions = question.getG2PostTestQuestion(randomIndex);
                    t122Btn1 = question.getG2PostTestChoice1(randomIndex);
                    t122Btn2 = question.getG2PostTestChoice2(randomIndex);
                    t122Btn3 = question.getG2PostTestChoice3(randomIndex);
                    t122Btn4 = question.getG2PostTestChoice4(randomIndex);
                    t122Solutions = question.getG2PostTestSolution(randomIndex);
                    t122Answers = question.getG2PostTestSolution(randomIndex);
//                } else if (currentQuestionIndex > 9) {
//                    t122Questions = question.getG3PostTestQuestion(randomIndex);
//                    t122Btn1 = question.getG3PostTestChoice1(randomIndex);
//                    t122Btn2 = question.getG3PostTestChoice2(randomIndex);
//                    t122Btn3 = question.getG3PostTestChoice3(randomIndex);
//                    t122Btn4 = question.getG3PostTestChoice4(randomIndex);
//                    t122Solutions = question.getG3PostTestSolution(randomIndex);
//                    t122Answers = question.getG3PostTestSolution(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT122Result(new TestResultModelClass(t122Questions, t122Btn1, t122Btn2, t122Btn3, t122Btn4, t122Solutions, t122Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t12PostTestProgress.setProgress(currentQuestionIndex + 1);
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
        t12PostTestTimer.setText(timerFormatted);

        if (timeLeftInMillis < 10000) {
            t12PostTestTimer.setTextColor(Color.RED);
        } else {
            t12PostTestTimer.setTextColor(Color.WHITE);
        }

        if (timeLeftInMillis == 0) {
            Toast.makeText(this, "Times Up!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showScore() {
        t12PostTestLayout.setVisibility(View.GONE);
        t12PostTestScore.setVisibility(View.VISIBLE);

        isTestOngoing = false;

        t12PostTestTotalScore = String.valueOf(score);
        t12PostTestScoreDisp.setText("Score: " + t12PostTestTotalScore + "/" + questionLength);

        long endTime = System.currentTimeMillis();
        long timeDiff = endTime - startTime;
        int totalSeconds = (int) (timeDiff / 1000);

        int min = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;
        t12PostTestTotalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
        t12PostTestTimeDisp.setText("Time: " + t12PostTestTotalTime);

        String totalSecs = String.valueOf(totalSeconds);

        dbHandler.storeTestScore(new TestsModelClass(5038, t12PostTestTotalScore, totalSecs));
    }

    private void resetButtonStyle() {
        t12PostTestNext.setVisibility(View.INVISIBLE);
        Button[] buttons = {t12PostTestOptA, t12PostTestOptB, t12PostTestOptC, t12PostTestOptD};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackgroundTintList(null);
            buttons[i].setBackgroundResource(R.drawable.custom_option_button);
            buttons[i].setTextColor(getResources().getColor(R.color.black));
        }
    }
}