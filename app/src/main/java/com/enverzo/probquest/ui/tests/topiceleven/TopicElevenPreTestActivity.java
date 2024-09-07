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

public class TopicElevenPreTestActivity extends AppCompatActivity {
    private LinearLayout t11PreTestEnterPasscode, t11PreTestInstruction, t11PreTestLayout;
    private RelativeLayout t11PreTestScore, t11PreTestHeader;
    private ListView t11PreTestListView;
    private EditText t11PreTestPasscode;
    private Button t11PreTestBackCode, t11PreTestSendCode, t11PreTestInsBack, t11PreTestInsStart, t11PreTestOptA, t11PreTestOptB, t11PreTestOptC, t11PreTestOptD, t11PreTestNext, t11PreTestResult;
    private TextView t11PreTestItem, t11PreTestTimer, t11PreTestQuestion, t11PreTestScoreDisp, t11PreTestTimeDisp, t11PreTestResultScore;
    private ProgressBar t11PreTestProgress;
    private ImageView t11PreTestResultExit;
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
    private String answer, solution, selectedAnswer, t11PreTestTotalScore, t11PreTestTotalTime, t111Questions, t111Btn1, t111Btn2, t111Btn3, t111Btn4, t111Solutions, t111Answers;
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
        setContentView(R.layout.activity_topic_eleven_pre_test);

        random = new Random();
        dbHandler = new DBHandler(this);

        t11PreTestEnterPasscode = findViewById(R.id.t11PreTestEnterPasscode);
        t11PreTestInstruction = findViewById(R.id.t11PreTestInstruction);
        t11PreTestLayout = findViewById(R.id.t11PreTestLayout);
        t11PreTestScore = findViewById(R.id.t11PreTestScore);
        t11PreTestHeader = findViewById(R.id.t11PreTestHeader);
        t11PreTestListView = findViewById(R.id.t11PreTestListView);
        t11PreTestPasscode = findViewById(R.id.t11PreTestPasscode);
        t11PreTestBackCode = findViewById(R.id.t11PreTestBackCode);
        t11PreTestSendCode = findViewById(R.id.t11PreTestSendCode);
        t11PreTestInsBack = findViewById(R.id.t11PreTestInsBack);
        t11PreTestInsStart = findViewById(R.id.t11PreTestInsStart);
        t11PreTestOptA = findViewById(R.id.t11PreTestOptA);
        t11PreTestOptB = findViewById(R.id.t11PreTestOptB);
        t11PreTestOptC = findViewById(R.id.t11PreTestOptC);
        t11PreTestOptD = findViewById(R.id.t11PreTestOptD);
        t11PreTestNext = findViewById(R.id.t11PreTestNext);
        t11PreTestResult = findViewById(R.id.t11PreTestResult);
        t11PreTestItem = findViewById(R.id.t11PreTestItem);
        t11PreTestTimer = findViewById(R.id.t11PreTestTimer);
        t11PreTestQuestion = findViewById(R.id.t11PreTestQuestion);
        t11PreTestScoreDisp = findViewById(R.id.t11PreTestScoreDisp);
        t11PreTestTimeDisp = findViewById(R.id.t11PreTestTimeDisp);
        t11PreTestResultScore = findViewById(R.id.t11PreTestResultScore);
        t11PreTestProgress = findViewById(R.id.t11PreTestProgress);
        t11PreTestResultExit = findViewById(R.id.t11PreTestResultExit);

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

        ViewResultAdapter viewResultAdapter = new ViewResultAdapter(TopicElevenPreTestActivity.this, testQuestions, btn1, btn2, btn3, btn4, testSolutions, testAnswers, solVis, ansVis, mark, btnbg1, btnbg2, btnbg3, btnbg4);
        t11PreTestListView.setAdapter(viewResultAdapter);

        checkTestCode = dbHandler.checkCode(2358);
        if (checkTestCode == true) {
            t11PreTestEnterPasscode.setVisibility(View.GONE);
            t11PreTestScore.setVisibility(View.VISIBLE);

            scoreAndTime = dbHandler.getScoreTime(2358);
            if (!scoreAndTime.isEmpty()) {
                t11PreTestScoreDisp.setText("Score: " + scoreAndTime.get(SCORE) + "/" + questionLength);
                int totalSeconds = Integer.parseInt(scoreAndTime.get(TIME));
                int min = (totalSeconds % 3600) / 60;
                int secs = totalSeconds % 60;
                String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
                t11PreTestTimeDisp.setText("Time: " + totalTime);
            }
        } else {
            t11PreTestEnterPasscode.setVisibility(View.VISIBLE);
        }

        t11PreTestBackCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t11PreTestSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t11PreTestPasscode.getText().toString().isEmpty()) {
                    Toast.makeText(TopicElevenPreTestActivity.this, "Require passcode", Toast.LENGTH_SHORT).show();
                } else {
                    passcode = Integer.valueOf(t11PreTestPasscode.getText().toString());
                    checkTestCode = dbHandler.checkCode(passcode);

                    if (checkTestCode == true) {
                        Toast.makeText(TopicElevenPreTestActivity.this, "You have already taken this test", Toast.LENGTH_SHORT).show();
                    } else {
                        if (passcode.equals(2358)) {
                            t11PreTestEnterPasscode.setVisibility(View.GONE);
                            t11PreTestInstruction.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(TopicElevenPreTestActivity.this, "Incorrect passcode", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        t11PreTestInsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t11PreTestInsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t11PreTestInstruction.setVisibility(View.GONE);
                t11PreTestLayout.setVisibility(View.VISIBLE);

                isTestOngoing = true;

                score = 0;
                currentQuestionIndex = 0;
                quizLevel = 1;

                t11PreTestProgress.setMax(questionLength);
                t11PreTestProgress.setProgress(currentQuestionIndex + 1);

                startTime = System.currentTimeMillis();
                NextQuestion();
            }
        });

        t11PreTestNext.setOnClickListener(new View.OnClickListener() {
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
                    t111Questions = question.getG1PreTestQuestion(randomIndex);
                    t111Btn1 = question.getG1PreTestChoice1(randomIndex);
                    t111Btn2 = question.getG1PreTestChoice2(randomIndex);
                    t111Btn3 = question.getG1PreTestChoice3(randomIndex);
                    t111Btn4 = question.getG1PreTestChoice4(randomIndex);
                    t111Solutions = question.getG1PreTestSolution(randomIndex);
                    t111Answers = question.getG1PreTestSolution(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t111Questions = question.getG2PreTestQuestion(randomIndex);
                    t111Btn1 = question.getG2PreTestChoice1(randomIndex);
                    t111Btn2 = question.getG2PreTestChoice2(randomIndex);
                    t111Btn3 = question.getG2PreTestChoice3(randomIndex);
                    t111Btn4 = question.getG2PreTestChoice4(randomIndex);
                    t111Solutions = question.getG2PreTestSolution(randomIndex);
                    t111Answers = question.getG2PreTestSolution(randomIndex);
//                } else if (currentQuestionIndex > 9) {
//                    t111Questions = question.getG3PreTestQuestion(randomIndex);
//                    t111Btn1 = question.getG3PreTestChoice1(randomIndex);
//                    t111Btn2 = question.getG3PreTestChoice2(randomIndex);
//                    t111Btn3 = question.getG3PreTestChoice3(randomIndex);
//                    t111Btn4 = question.getG3PreTestChoice4(randomIndex);
//                    t111Solutions = question.getG3PreTestSolution(randomIndex);
//                    t111Answers = question.getG3PreTestSolution(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT111Result(new TestResultModelClass(t111Questions, t111Btn1, t111Btn2, t111Btn3, t111Btn4, t111Solutions, t111Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t11PreTestProgress.setProgress(currentQuestionIndex + 1);
                    NextQuestion();
                    resetButtonStyle();
                } else {
                    countDownTimer.cancel();
                    showScore();
                }
            }
        });

        t11PreTestResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t11PreTestScore.setVisibility(View.GONE);
                t11PreTestListView.setVisibility(View.VISIBLE);
                t11PreTestHeader.setVisibility(View.VISIBLE);

                testQuestions.clear();
                btn1.clear();
                btn2.clear();
                btn3.clear();
                btn4.clear();
                testSolutions.clear();
                testAnswers.clear();
                solVis.clear();
                ansVis.clear();

                t11PreTestResultScore.setText("Score " + t11PreTestTotalScore + "/" + questionLength);
                ((ViewResultAdapter) t11PreTestListView.getAdapter()).notifyDataSetChanged();

                int markCheck = R.drawable.round_check_24;
                int markWrong = R.drawable.round_clear_24;
                int btnSlc = R.drawable.custom_selected_button;
                int btnOpt = R.drawable.custom_option_button;

                for (int i = 0; i < questionLength; i++) {
                    TestResultModelClass testResult = dbHandler.getT111Result(i+1);
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

                checkTestCode = dbHandler.checkCode(2358);
                if (checkTestCode == true) {
                    scoreAndTime = dbHandler.getScoreTime(2358);
                    if (!scoreAndTime.isEmpty()) {
                        t11PreTestResultScore.setText("Score " + scoreAndTime.get(SCORE) + "/" + questionLength);
                    }
                }
            }
        });

        t11PreTestResultExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        t11PreTestOptA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 1;
                selectedAnswer = t11PreTestOptA.getText().toString();
                t11PreTestNext.setVisibility(View.VISIBLE);
                t11PreTestOptA.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t11PreTestOptA.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t11PreTestOptB, t11PreTestOptC, t11PreTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t11PreTestOptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 2;
                selectedAnswer = t11PreTestOptB.getText().toString();
                t11PreTestNext.setVisibility(View.VISIBLE);
                t11PreTestOptB.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t11PreTestOptB.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t11PreTestOptA, t11PreTestOptC, t11PreTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t11PreTestOptC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 3;
                selectedAnswer = t11PreTestOptC.getText().toString();
                t11PreTestNext.setVisibility(View.VISIBLE);
                t11PreTestOptC.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t11PreTestOptC.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t11PreTestOptA, t11PreTestOptB, t11PreTestOptD};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBackgroundTintList(null);
                    buttons[i].setBackgroundResource(R.drawable.custom_option_button);
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        t11PreTestOptD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIndex = 4;
                selectedAnswer = t11PreTestOptD.getText().toString();
                t11PreTestNext.setVisibility(View.VISIBLE);
                t11PreTestOptD.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
                t11PreTestOptD.setTextColor(getResources().getColor(R.color.white));
                Button[] buttons = {t11PreTestOptA, t11PreTestOptB, t11PreTestOptC};
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
            Toast.makeText(TopicElevenPreTestActivity.this, "Can't go back. Test is ongoing.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(TopicElevenPreTestActivity.this, NavigationActivity.class);
            intent.putExtra("loadToTestsFragment", R.id.navigation_tests);
            startActivity(intent);
            finish();
            super.onBackPressed();
        }
    }

    private void NextQuestion() {
        t11PreTestItem.setText((currentQuestionIndex + 1) + " of " + questionLength + " Questions");

        if (quizLevel == 1) {
            do {
                randomIndex = random.nextInt(5);
            } while (shownQuestionIndices.contains(randomIndex));
            shownQuestionIndices.add(randomIndex);
            if (shownQuestionIndices.size() == 5) {
                shownQuestionIndices.clear();
                quizLevel = 2;
            }
            t11PreTestQuestion.setText(question.getG1PreTestQuestion(randomIndex));
            t11PreTestOptA.setText(question.getG1PreTestChoice1(randomIndex));
            t11PreTestOptB.setText(question.getG1PreTestChoice2(randomIndex));
            t11PreTestOptC.setText(question.getG1PreTestChoice3(randomIndex));
            t11PreTestOptD.setText(question.getG1PreTestChoice4(randomIndex));
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
            t11PreTestQuestion.setText(question.getG2PreTestQuestion(randomIndex));
            t11PreTestOptA.setText(question.getG2PreTestChoice1(randomIndex));
            t11PreTestOptB.setText(question.getG2PreTestChoice2(randomIndex));
            t11PreTestOptC.setText(question.getG2PreTestChoice3(randomIndex));
            t11PreTestOptD.setText(question.getG2PreTestChoice4(randomIndex));
            answer = question.getG2PreTestCorrectAnswer(randomIndex);
//        }  else if (quizLevel == 3) {
//                do {
//                    randomIndex = random.nextInt(5);
//                } while (shownQuestionIndices.contains(randomIndex));
//                shownQuestionIndices.add(randomIndex);
//                if (shownQuestionIndices.size() == 5) {
//                    shownQuestionIndices.clear();
//                }
//                t11PreTestQuestion.setText(question.getG3PreTestQuestion(randomIndex));
//                t11PreTestOptA.setText(question.getG3PreTestChoice1(randomIndex));
//                t11PreTestOptB.setText(question.getG3PreTestChoice2(randomIndex));
//                t11PreTestOptC.setText(question.getG3PreTestChoice3(randomIndex));
//                t11PreTestOptD.setText(question.getG3PreTestChoice4(randomIndex));
//                answer = question.getG3PreTestCorrectAnswer(randomIndex);
//                solution = question.getG3PreTestSolution(randomIndex);
        }

        if ((currentQuestionIndex + 1) < questionLength) {
            t11PreTestNext.setText("Next");
        } else if ((currentQuestionIndex + 1) == questionLength) {
            t11PreTestNext.setText("Submit");
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
                    t111Questions = question.getG1PreTestQuestion(randomIndex);
                    t111Btn1 = question.getG1PreTestChoice1(randomIndex);
                    t111Btn2 = question.getG1PreTestChoice2(randomIndex);
                    t111Btn3 = question.getG1PreTestChoice3(randomIndex);
                    t111Btn4 = question.getG1PreTestChoice4(randomIndex);
                    t111Solutions = question.getG1PreTestSolution(randomIndex);
                    t111Answers = question.getG1PreTestSolution(randomIndex);
                } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
                    t111Questions = question.getG2PreTestQuestion(randomIndex);
                    t111Btn1 = question.getG2PreTestChoice1(randomIndex);
                    t111Btn2 = question.getG2PreTestChoice2(randomIndex);
                    t111Btn3 = question.getG2PreTestChoice3(randomIndex);
                    t111Btn4 = question.getG2PreTestChoice4(randomIndex);
                    t111Solutions = question.getG2PreTestSolution(randomIndex);
                    t111Answers = question.getG2PreTestSolution(randomIndex);
//                } else if (currentQuestionIndex > 9) {
//                    t111Questions = question.getG3PreTestQuestion(randomIndex);
//                    t111Btn1 = question.getG3PreTestChoice1(randomIndex);
//                    t111Btn2 = question.getG3PreTestChoice2(randomIndex);
//                    t111Btn3 = question.getG3PreTestChoice3(randomIndex);
//                    t111Btn4 = question.getG3PreTestChoice4(randomIndex);
//                    t111Solutions = question.getG3PreTestSolution(randomIndex);
//                    t111Answers = question.getG3PreTestSolution(randomIndex);
                }

                markImage = storeMark[currentQuestionIndex];
                btnStyle1 = storeBtnbg1[currentQuestionIndex];
                btnStyle2 = storeBtnbg2[currentQuestionIndex];
                btnStyle3 = storeBtnbg3[currentQuestionIndex];
                btnStyle4 = storeBtnbg4[currentQuestionIndex];

                dbHandler.storeT111Result(new TestResultModelClass(t111Questions, t111Btn1, t111Btn2, t111Btn3, t111Btn4, t111Solutions, t111Answers,
                        solStyle, ansStyle, markImage, btnStyle1, btnStyle2, btnStyle3, btnStyle4));

                currentQuestionIndex++;

                if (currentQuestionIndex < questionLength) {
                    t11PreTestProgress.setProgress(currentQuestionIndex + 1);
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
        t11PreTestTimer.setText(timerFormatted);

        if (timeLeftInMillis < 10000) {
            t11PreTestTimer.setTextColor(Color.RED);
        } else {
            t11PreTestTimer.setTextColor(Color.WHITE);
        }

        if (timeLeftInMillis == 0) {
            Toast.makeText(this, "Times Up!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showScore() {
        t11PreTestLayout.setVisibility(View.GONE);
        t11PreTestScore.setVisibility(View.VISIBLE);

        isTestOngoing = false;

        t11PreTestTotalScore = String.valueOf(score);
        t11PreTestScoreDisp.setText("Score: " + t11PreTestTotalScore + "/" + questionLength);

        long endTime = System.currentTimeMillis();
        long timeDiff = endTime - startTime;
        int totalSeconds = (int) (timeDiff / 1000);

        int min = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;
        t11PreTestTotalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
        t11PreTestTimeDisp.setText("Time: " + t11PreTestTotalTime);

        String totalSecs = String.valueOf(totalSeconds);

        dbHandler.storeTestScore(new TestsModelClass(2358, t11PreTestTotalScore, totalSecs));
    }

    private void resetButtonStyle() {
        t11PreTestNext.setVisibility(View.INVISIBLE);
        Button[] buttons = {t11PreTestOptA, t11PreTestOptB, t11PreTestOptC, t11PreTestOptD};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackgroundTintList(null);
            buttons[i].setBackgroundResource(R.drawable.custom_option_button);
            buttons[i].setTextColor(getResources().getColor(R.color.black));
        }
    }
}