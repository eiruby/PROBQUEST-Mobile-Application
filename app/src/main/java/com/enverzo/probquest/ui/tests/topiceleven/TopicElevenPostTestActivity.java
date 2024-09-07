package com.enverzo.probquest.ui.tests.topiceleven;

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

public class TopicElevenPostTestActivity extends AppCompatActivity {
    private LinearLayout t11PostTestEnterPasscode, t11PostTestInstruction, t11PostTestLayout;
    private RelativeLayout t11PostTestScore, t11PostTestHeader;
    private ListView t11PostTestListView;
    private EditText t11PostTestPasscode;
    private Button t11PostTestBackCode, t11PostTestSendCode, t11PostTestInsBack, t11PostTestInsStart, t11PostTestOptA, t11PostTestOptB, t11PostTestOptC, t11PostTestOptD, t11PostTestNext, t11PostTestResult;
    private TextView t11PostTestItem, t11PostTestTimer, t11PostTestQuestion, t11PostTestScoreDisp, t11PostTestTimeDisp, t11PostTestResultScore;
    private ProgressBar t11PostTestProgress;
    private ImageView t11PostTestResultExit;
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
    private TopicElevenQuestion question = new TopicElevenQuestion();
    private int questionLength = 10;
    private String answer, solution, selectedAnswer, t11PostTestTotalScore, t11PostTestTotalTime, t112Questions, t112Btn1, t112Btn2, t112Btn3, t112Btn4, t112Solutions, t112Answers;
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
        setContentView(R.layout.activity_topic_eleven_post_test);

        random = new Random();
        dbHandler = new DBHandler(this);

        t11PostTestEnterPasscode = findViewById(R.id.t11PostTestEnterPasscode);
        t11PostTestInstruction = findViewById(R.id.t11PostTestInstruction);
        t11PostTestLayout = findViewById(R.id.t11PostTestLayout);
        t11PostTestScore = findViewById(R.id.t11PostTestScore);
        t11PostTestHeader = findViewById(R.id.t11PostTestHeader);
        t11PostTestListView = findViewById(R.id.t11PostTestListView);
        t11PostTestPasscode = findViewById(R.id.t11PostTestPasscode);
        t11PostTestBackCode = findViewById(R.id.t11PostTestBackCode);
        t11PostTestSendCode = findViewById(R.id.t11PostTestSendCode);
        t11PostTestInsBack = findViewById(R.id.t11PostTestInsBack);
        t11PostTestInsStart = findViewById(R.id.t11PostTestInsStart);
        t11PostTestOptA = findViewById(R.id.t11PostTestOptA);
        t11PostTestOptB = findViewById(R.id.t11PostTestOptB);
        t11PostTestOptC = findViewById(R.id.t11PostTestOptC);
        t11PostTestOptD = findViewById(R.id.t11PostTestOptD);
        t11PostTestNext = findViewById(R.id.t11PostTestNext);
        t11PostTestResult = findViewById(R.id.t11PostTestResult);
        t11PostTestItem = findViewById(R.id.t11PostTestItem);
        t11PostTestTimer = findViewById(R.id.t11PostTestTimer);
        t11PostTestQuestion = findViewById(R.id.t11PostTestQuestion);
        t11PostTestScoreDisp = findViewById(R.id.t11PostTestScoreDisp);
        t11PostTestTimeDisp = findViewById(R.id.t11PostTestTimeDisp);
        t11PostTestResultScore = findViewById(R.id.t11PostTestResultScore);
        t11PostTestProgress = findViewById(R.id.t11PostTestProgress);
        t11PostTestResultExit = findViewById(R.id.t11PostTestResultExit);

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

        ViewResultAdapter viewResultAdapter = new ViewResultAdapter(TopicElevenPostTestActivity.this, testQuestions, btn1, btn2, btn3, btn4, testSolutions, testAnswers, solVis, ansVis, mark, btnbg1, btnbg2, btnbg3, btnbg4);
        t11PostTestListView.setAdapter(viewResultAdapter);

        checkTestCode = dbHandler.checkCode(7368);
        if (checkTestCode == true) {
            t11PostTestEnterPasscode.setVisibility(View.GONE);
            t11PostTestScore.setVisibility(View.VISIBLE);

            scoreAndTime = dbHandler.getScoreTime(7368);
            if (!scoreAndTime.isEmpty()) {
                t11PostTestScoreDisp.setText("Score: " + scoreAndTime.get(SCORE) + "/" + questionLength);
                t11PostTestTimeDisp.setText("Time: " + scoreAndTime.get(TIME));
            }
        } else {
            t11PostTestEnterPasscode.setVisibility(View.VISIBLE);
        }

        t11PostTestBackCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t11PostTestSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t11PostTestPasscode.getText().toString().isEmpty()) {
                    Toast.makeText(TopicElevenPostTestActivity.this, "Require passcode", Toast.LENGTH_SHORT).show();
                } else {
                    passcode = Integer.valueOf(t11PostTestPasscode.getText().toString());
                    checkTestCode = dbHandler.checkCode(passcode);

                    if (checkTestCode == true) {
                        Toast.makeText(TopicElevenPostTestActivity.this, "You have already taken this test", Toast.LENGTH_SHORT).show();
                    } else {
                        if (passcode.equals(7368)) {
                            t11PostTestEnterPasscode.setVisibility(View.GONE);
                            t11PostTestInstruction.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(TopicElevenPostTestActivity.this, "Incorrect passcode", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        t11PostTestInsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t11PostTestInsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t11PostTestInstruction.setVisibility(View.GONE);
                t11PostTestLayout.setVisibility(View.VISIBLE);

                isTestOngoing = true;

                score = 0;
                currentQuestionIndex = 0;
                quizLevel = 1;

                t11PostTestProgress.setMax(questionLength);
                t11PostTestProgress.setProgress(currentQuestionIndex + 1);

                startTime = System.currentTimeMillis();
                NextQuestion();
            }
        });

        t11PostTestNext.setOnClickListener(new View.OnClickListener() {
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
                    t112Questions = question.getG1PostTestQuestion(randomIndex);
                    t112Btn1 = question.getG1PostTestChoice1(randomIndex);
                    t112Btn2 = question.getG1PostTestChoice2(randomIndex);
                    t112Btn3 = question.getG1PostTestChoice3(randomIndex);
                    t112Btn4 = question.getG1PostTestChoice4(randomIndex);
                    t112Solutions = question.getG1PostTestSolution(randomIndex);
                    t112Answers = question.getG1PostTestSolution(randomIndex);
                } else if (quizLevel == 2) {
                    t112Questions = question.getG2PostTestQuestion(randomIndex);
                    t112Btn1 = question.getG2PostTestChoice1(randomIndex);
                    t112Btn2 = question.getG2PostTestChoice2(randomIndex);
                    t112Btn3 = question.getG2PostTestChoice3(randomIndex);
                    t112Btn4 = question.getG2PostTestChoice4(randomIndex);
                    t112Solutions = question.getG2PostTestSolution(randomIndex);
                    t112Answers = question.getG2PostTestSolution(randomIndex);
//                } else if (quizLevel == 3) {
//                    t112Questions = question.getG3PostTestQuestion(randomIndex);
//                    t112Btn1 = question.getG3PostTestChoice1(randomIndex);
//                    t112Btn2 = question.getG3PostTestChoice2(randomIndex);
//                    t112Btn3 = question.getG3PostTestChoice3(randomIndex);
//                    t112Btn4 = question.getG3PostTestChoice4(randomIndex);
//                    t112Solutions = question.getG3PostTestSolution(randomIndex);
//                    t112Answers = question.getG3PostTestSolution(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT112Result(new TestResultModelClass(t112Questions, t112Btn1, t112Btn2, t112Btn3, t112Btn4, t112Solutions, t112Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t11PostTestProgress.setProgress(currentQuestionIndex + 1);
                    NextQuestion();
                    resetButtonStyle();
                } else {
                    countDownTimer.cancel();
                    showScore();
                }
            }
        });

        t11PostTestResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t11PostTestScore.setVisibility(View.GONE);
                t11PostTestListView.setVisibility(View.VISIBLE);
                t11PostTestHeader.setVisibility(View.VISIBLE);

                testQuestions.clear();
                btn1.clear();
                btn2.clear();
                btn3.clear();
                btn4.clear();
                testSolutions.clear();
                testAnswers.clear();
                solVis.clear();
                ansVis.clear();

                t11PostTestResultScore.setText("Score " + t11PostTestTotalScore + "/" + questionLength);
                ((ViewResultAdapter) t11PostTestListView.getAdapter()).notifyDataSetChanged();

                int markCheck = R.drawable.round_check_24;
                int markWrong = R.drawable.round_clear_24;
                int btnSlc = R.drawable.custom_selected_button;
                int btnOpt = R.drawable.custom_option_button;

                for (int i = 0; i < questionLength; i++) {
                    TestResultModelClass testResult = dbHandler.getT112Result(i+1);
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

                checkTestCode = dbHandler.checkCode(7368);
                if (checkTestCode == true) {
                    scoreAndTime = dbHandler.getScoreTime(7368);
                    if (!scoreAndTime.isEmpty()) {
                        t11PostTestResultScore.setText("Score " + scoreAndTime.get(SCORE) + "/" + questionLength);
                    }
                }
            }
        });

        t11PostTestResultExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t11PostTestOptA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 1;
                selectedAnswer = t11PostTestOptA.getText().toString();
                t11PostTestNext.setVisibility(View.VISIBLE);
                t11PostTestOptA.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t11PostTestOptA.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t11PostTestOptB, t11PostTestOptC, t11PostTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t11PostTestOptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 2;
                selectedAnswer = t11PostTestOptB.getText().toString();
                t11PostTestNext.setVisibility(View.VISIBLE);
                t11PostTestOptB.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t11PostTestOptB.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t11PostTestOptA, t11PostTestOptC, t11PostTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t11PostTestOptC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 3;
                selectedAnswer = t11PostTestOptC.getText().toString();
                t11PostTestNext.setVisibility(View.VISIBLE);
                t11PostTestOptC.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t11PostTestOptC.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t11PostTestOptA, t11PostTestOptB, t11PostTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t11PostTestOptD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 4;
                selectedAnswer = t11PostTestOptD.getText().toString();
                t11PostTestNext.setVisibility(View.VISIBLE);
                t11PostTestOptD.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t11PostTestOptD.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t11PostTestOptA, t11PostTestOptB, t11PostTestOptC};
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
            Toast.makeText(TopicElevenPostTestActivity.this, "Can't go back. Test is ongoing.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(TopicElevenPostTestActivity.this, NavigationActivity.class);
            intent.putExtra("loadToTestsFragment", R.id.navigation_tests);
            startActivity(intent);
            finish();
            super.onBackPressed();
        }
    }

    private void NextQuestion() {
        t11PostTestItem.setText((currentQuestionIndex + 1) + " of " + questionLength + " Questions");

        if (quizLevel == 1) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
                quizLevel = 2;
            }
            t11PostTestQuestion.setText(question.getG1PostTestQuestion(randomIndex));
            t11PostTestOptA.setText(question.getG1PostTestChoice1(randomIndex));
            t11PostTestOptB.setText(question.getG1PostTestChoice2(randomIndex));
            t11PostTestOptC.setText(question.getG1PostTestChoice3(randomIndex));
            t11PostTestOptD.setText(question.getG1PostTestChoice4(randomIndex));
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
            t11PostTestQuestion.setText(question.getG2PostTestQuestion(randomIndex));
            t11PostTestOptA.setText(question.getG2PostTestChoice1(randomIndex));
            t11PostTestOptB.setText(question.getG2PostTestChoice2(randomIndex));
            t11PostTestOptC.setText(question.getG2PostTestChoice3(randomIndex));
            t11PostTestOptD.setText(question.getG2PostTestChoice4(randomIndex));
            answer = question.getG2PostTestCorrectAnswer(randomIndex);
            solution = question.getG2PostTestSolution(randomIndex);
//        } else if (quizLevel == 3) {
//            do {
//                randomIndex = random.nextInt(5);
//            } while (shownQuestionIndices.contains(randomIndex));
//            shownQuestionIndices.add(5);
//            if (shownQuestionIndices.size() == questionLength) {
//                shownQuestionIndices.clear();
//            }
//            t11PostTestQuestion.setText(question.getG3PostTestQuestion(randomIndex));
//            t11PostTestOptA.setText(question.getG3PostTestChoice1(randomIndex));
//            t11PostTestOptB.setText(question.getG3PostTestChoice2(randomIndex));
//            t11PostTestOptC.setText(question.getG3PostTestChoice3(randomIndex));
//            t11PostTestOptD.setText(question.getG3PostTestChoice4(randomIndex));
//            answer = question.getG3PostTestCorrectAnswer(randomIndex);
//            solution = question.getG3PostTestSolution(randomIndex);
        }

        if ((currentQuestionIndex + 1) < questionLength) {
            t11PostTestNext.setText("Next");
        } else if ((currentQuestionIndex + 1) == questionLength) {
            t11PostTestNext.setText("Submit");
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

                if (quizLevel == 1) {
                    t112Questions = question.getG1PostTestQuestion(randomIndex);
                    t112Btn1 = question.getG1PostTestChoice1(randomIndex);
                    t112Btn2 = question.getG1PostTestChoice2(randomIndex);
                    t112Btn3 = question.getG1PostTestChoice3(randomIndex);
                    t112Btn4 = question.getG1PostTestChoice4(randomIndex);
                    t112Solutions = question.getG1PostTestSolution(randomIndex);
                    t112Answers = question.getG1PostTestSolution(randomIndex);
                } else if (quizLevel == 2) {
                    t112Questions = question.getG2PostTestQuestion(randomIndex);
                    t112Btn1 = question.getG2PostTestChoice1(randomIndex);
                    t112Btn2 = question.getG2PostTestChoice2(randomIndex);
                    t112Btn3 = question.getG2PostTestChoice3(randomIndex);
                    t112Btn4 = question.getG2PostTestChoice4(randomIndex);
                    t112Solutions = question.getG2PostTestSolution(randomIndex);
                    t112Answers = question.getG2PostTestSolution(randomIndex);
//                } else if (quizLevel == 3) {
//                    t112Questions = question.getG3PostTestQuestion(randomIndex);
//                    t112Btn1 = question.getG3PostTestChoice1(randomIndex);
//                    t112Btn2 = question.getG3PostTestChoice2(randomIndex);
//                    t112Btn3 = question.getG3PostTestChoice3(randomIndex);
//                    t112Btn4 = question.getG3PostTestChoice4(randomIndex);
//                    t112Solutions = question.getG3PostTestSolution(randomIndex);
//                    t112Answers = question.getG3PostTestSolution(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT112Result(new TestResultModelClass(t112Questions, t112Btn1, t112Btn2, t112Btn3, t112Btn4, t112Solutions, t112Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t11PostTestProgress.setProgress(currentQuestionIndex + 1);
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
        t11PostTestTimer.setText(timerFormatted);

        if (timeLeftInMillis < 10000) {
            t11PostTestTimer.setTextColor(Color.RED);
        } else {
            t11PostTestTimer.setTextColor(Color.WHITE);
        }

        if (timeLeftInMillis == 0) {
            Toast.makeText(this, "Times Up!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showScore() {
        t11PostTestLayout.setVisibility(View.GONE);
        t11PostTestScore.setVisibility(View.VISIBLE);

        isTestOngoing = false;

        t11PostTestTotalScore = String.valueOf(score);
        t11PostTestScoreDisp.setText("Score: " + t11PostTestTotalScore + "/" + questionLength);

        long endTime = System.currentTimeMillis();
        long timeDiff = endTime - startTime;
        int totalSeconds = (int) (timeDiff / 1000);

        int min = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;
        t11PostTestTotalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
        t11PostTestTimeDisp.setText("Time: " + t11PostTestTotalTime);

        String totalSecs = String.valueOf(totalSeconds);

        dbHandler.storeTestScore(new TestsModelClass(7368, t11PostTestTotalScore, totalSecs));
    }

    private void resetButtonStyle() {
        t11PostTestNext.setVisibility(View.INVISIBLE);
        Button[] buttons = {t11PostTestOptA, t11PostTestOptB, t11PostTestOptC, t11PostTestOptD};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackgroundTintList(null);
            buttons[i].setBackgroundResource(R.drawable.custom_option_button);
            buttons[i].setTextColor(getResources().getColor(R.color.black));
        }
    }
}