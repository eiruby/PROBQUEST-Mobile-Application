package com.enverzo.probquest.ui.tests;

import static com.enverzo.probquest.DBHandler.SCORE;
import static com.enverzo.probquest.DBHandler.TIME;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.enverzo.probquest.R;
import com.enverzo.probquest.DBHandler;
import com.enverzo.probquest.ui.tests.topiceight.TopicEightPostTestActivity;
import com.enverzo.probquest.ui.tests.topiceight.TopicEightPreTestActivity;
import com.enverzo.probquest.ui.tests.topiceleven.TopicElevenPostTestActivity;
import com.enverzo.probquest.ui.tests.topiceleven.TopicElevenPreTestActivity;
import com.enverzo.probquest.ui.tests.topicfive.TopicFivePostTestActivity;
import com.enverzo.probquest.ui.tests.topicfive.TopicFivePreTestActivity;
import com.enverzo.probquest.ui.tests.topicfour.TopicFourPostTestActivity;
import com.enverzo.probquest.ui.tests.topicfour.TopicFourPreTestActivity;
import com.enverzo.probquest.ui.tests.topicnine.TopicNinePostTestActivity;
import com.enverzo.probquest.ui.tests.topicnine.TopicNinePreTestActivity;
import com.enverzo.probquest.ui.tests.topicone.TopicOnePostTestActivity;
import com.enverzo.probquest.ui.tests.topicone.TopicOnePreTestActivity;
import com.enverzo.probquest.ui.tests.topicseven.TopicSevenPostTestActivity;
import com.enverzo.probquest.ui.tests.topicseven.TopicSevenPreTestActivity;
import com.enverzo.probquest.ui.tests.topicsix.TopicSixPostTestActivity;
import com.enverzo.probquest.ui.tests.topicsix.TopicSixPreTestActivity;
import com.enverzo.probquest.ui.tests.topicten.TopicTenPostTestActivity;
import com.enverzo.probquest.ui.tests.topicten.TopicTenPreTestActivity;
import com.enverzo.probquest.ui.tests.topicthree.TopicThreePostTestActivity;
import com.enverzo.probquest.ui.tests.topicthree.TopicThreePreTestActivity;
import com.enverzo.probquest.ui.tests.topictwelve.TopicTwelvePostTestActivity;
import com.enverzo.probquest.ui.tests.topictwelve.TopicTwelvePreTestActivity;
import com.enverzo.probquest.ui.tests.topictwo.TopicTwoPostTestActivity;
import com.enverzo.probquest.ui.tests.topictwo.TopicTwoPreTestActivity;

import java.util.Locale;
import java.util.Map;

public class TestsFragment extends Fragment {

    private CardView topicOnePreTest, topicOnePostTest, topicTwoPreTest, topicTwoPostTest, topicThreePreTest, topicThreePostTest, topicFourPreTest, topicFourPostTest, topicFivePreTest, topicFivePostTest, topicSixPreTest, topicSixPostTest, topicSevenPreTest, topicSevenPostTest, topicEightPreTest, topicEightPostTest, topicNinePreTest, topicNinePostTest, topicTenPreTest, topicTenPostTest, topicElevenPreTest, topicElevenPostTest, topicTwelvePreTest, topicTwelvePostTest;
    private TextView topicOnePreTestScore, topicOnePreTestTime, topicOnePostTestScore, topicOnePostTestTime, topicTwoPreTestScore, topicTwoPreTestTime, topicTwoPostTestScore, topicTwoPostTestTime, topicThreePreTestScore, topicThreePreTestTime, topicThreePostTestScore, topicThreePostTestTime, topicFourPreTestScore, topicFourPreTestTime, topicFourPostTestScore, topicFourPostTestTime, topicFivePreTestScore, topicFivePreTestTime, topicFivePostTestScore, topicFivePostTestTime, topicSixPreTestScore, topicSixPreTestTime, topicSixPostTestScore, topicSixPostTestTime, topicSevenPreTestScore, topicSevenPreTestTime, topicSevenPostTestScore, topicSevenPostTestTime, topicEightPreTestScore, topicEightPreTestTime, topicEightPostTestScore, topicEightPostTestTime, topicNinePreTestScore, topicNinePreTestTime, topicNinePostTestScore, topicNinePostTestTime, topicTenPreTestScore, topicTenPreTestTime, topicTenPostTestScore, topicTenPostTestTime, topicElevenPreTestScore, topicElevenPreTestTime, topicElevenPostTestScore, topicElevenPostTestTime, topicTwelvePreTestScore, topicTwelvePreTestTime, topicTwelvePostTestScore, topicTwelvePostTestTime, tutorialText2;
    private Map<String, String> scoreAndTime11, scoreAndTime12, scoreAndTime21, scoreAndTime22, scoreAndTime31, scoreAndTime32, scoreAndTime41, scoreAndTime42, scoreAndTime51, scoreAndTime52, scoreAndTime61, scoreAndTime62, scoreAndTime71, scoreAndTime72, scoreAndTime81, scoreAndTime82, scoreAndTime91, scoreAndTime92, scoreAndTime101, scoreAndTime102, scoreAndTime111, scoreAndTime112, scoreAndTime121, scoreAndTime122;
    private ScrollView scrollView2;
    private Button tutorialTest, tutorialCancel2;
    private View maskView2;
    private RelativeLayout tutorialContent2;
    private ImageView tutorialImage2, passcode;
    private MediaPlayer mediaPlayer;
    private Runnable runnable1, runnable2, runnable3, runnable4, runnable5, runnable6, runnable7, runnable8, runnable9;
    private Handler handler = new Handler();;
    DBHandler dbHandler;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_tests, container, false);

        dbHandler = new DBHandler(requireContext());

        topicOnePreTest = root.findViewById(R.id.topicOnePreTest);
        topicTwoPreTest = root.findViewById(R.id.topicTwoPreTest);
        topicThreePreTest = root.findViewById(R.id.topicThreePreTest);
        topicFourPreTest = root.findViewById(R.id.topicFourPreTest);
        topicFivePreTest = root.findViewById(R.id.topicFivePreTest);
        topicSixPreTest = root.findViewById(R.id.topicSixPreTest);
        topicSevenPreTest = root.findViewById(R.id.topicSevenPreTest);
        topicEightPreTest = root.findViewById(R.id.topicEightPreTest);
        topicNinePreTest = root.findViewById(R.id.topicNinePreTest);
        topicTenPreTest = root.findViewById(R.id.topicTenPreTest);
        topicElevenPreTest = root.findViewById(R.id.topicElevenPreTest);
        topicTwelvePreTest = root.findViewById(R.id.topicTwelvePreTest);

        topicOnePostTest = root.findViewById(R.id.topicOnePostTest);
        topicTwoPostTest = root.findViewById(R.id.topicTwoPostTest);
        topicThreePostTest = root.findViewById(R.id.topicThreePostTest);
        topicFourPostTest = root.findViewById(R.id.topicFourPostTest);
        topicFivePostTest = root.findViewById(R.id.topicFivePostTest);
        topicSixPostTest = root.findViewById(R.id.topicSixPostTest);
        topicSevenPostTest = root.findViewById(R.id.topicSevenPostTest);
        topicEightPostTest = root.findViewById(R.id.topicEightPostTest);
        topicNinePostTest = root.findViewById(R.id.topicNinePostTest);
        topicTenPostTest = root.findViewById(R.id.topicTenPostTest);
        topicElevenPostTest = root.findViewById(R.id.topicElevenPostTest);
        topicTwelvePostTest = root.findViewById(R.id.topicTwelvePostTest);

        topicOnePreTestScore = root.findViewById(R.id.topicOnePreTestScore);
        topicTwoPreTestScore = root.findViewById(R.id.topicTwoPreTestScore);
        topicThreePreTestScore = root.findViewById(R.id.topicThreePreTestScore);
        topicFourPreTestScore = root.findViewById(R.id.topicFourPreTestScore);
        topicFivePreTestScore = root.findViewById(R.id.topicFivePreTestScore);
        topicSixPreTestScore = root.findViewById(R.id.topicSixPreTestScore);
        topicSevenPreTestScore = root.findViewById(R.id.topicSevenPreTestScore);
        topicEightPreTestScore = root.findViewById(R.id.topicEightPreTestScore);
        topicNinePreTestScore = root.findViewById(R.id.topicNinePreTestScore);
        topicTenPreTestScore = root.findViewById(R.id.topicTenPreTestScore);
        topicElevenPreTestScore = root.findViewById(R.id.topicElevenPreTestScore);
        topicTwelvePreTestScore = root.findViewById(R.id.topicTwelvePreTestScore);

        topicOnePostTestScore = root.findViewById(R.id.topicOnePostTestScore);
        topicTwoPostTestScore = root.findViewById(R.id.topicTwoPostTestScore);
        topicThreePostTestScore = root.findViewById(R.id.topicThreePostTestScore);
        topicFourPostTestScore = root.findViewById(R.id.topicFourPostTestScore);
        topicFivePostTestScore = root.findViewById(R.id.topicFivePostTestScore);
        topicSixPostTestScore = root.findViewById(R.id.topicSixPostTestScore);
        topicSevenPostTestScore = root.findViewById(R.id.topicSevenPostTestScore);
        topicEightPostTestScore = root.findViewById(R.id.topicEightPostTestScore);
        topicNinePostTestScore = root.findViewById(R.id.topicNinePostTestScore);
        topicTenPostTestScore = root.findViewById(R.id.topicTenPostTestScore);
        topicElevenPostTestScore = root.findViewById(R.id.topicElevenPostTestScore);
        topicTwelvePostTestScore = root.findViewById(R.id.topicTwelvePostTestScore);

        topicOnePreTestTime = root.findViewById(R.id.topicOnePreTestTime);
        topicTwoPreTestTime = root.findViewById(R.id.topicTwoPreTestTime);
        topicThreePreTestTime = root.findViewById(R.id.topicThreePreTestTime);
        topicFourPreTestTime = root.findViewById(R.id.topicFourPreTestTime);
        topicFivePreTestTime = root.findViewById(R.id.topicFivePreTestTime);
        topicSixPreTestTime = root.findViewById(R.id.topicSixPreTestTime);
        topicSevenPreTestTime = root.findViewById(R.id.topicSevenPreTestTime);
        topicEightPreTestTime = root.findViewById(R.id.topicEightPreTestTime);
        topicNinePreTestTime = root.findViewById(R.id.topicNinePreTestTime);
        topicTenPreTestTime = root.findViewById(R.id.topicTenPreTestTime);
        topicElevenPreTestTime = root.findViewById(R.id.topicElevenPreTestTime);
        topicTwelvePreTestTime = root.findViewById(R.id.topicTwelvePreTestTime);

        topicOnePostTestTime = root.findViewById(R.id.topicOnePostTestTime);
        topicTwoPostTestTime = root.findViewById(R.id.topicTwoPostTestTime);
        topicThreePostTestTime = root.findViewById(R.id.topicThreePostTestTime);
        topicFourPostTestTime = root.findViewById(R.id.topicFourPostTestTime);
        topicFivePostTestTime = root.findViewById(R.id.topicFivePostTestTime);
        topicSixPostTestTime = root.findViewById(R.id.topicSixPostTestTime);
        topicSevenPostTestTime = root.findViewById(R.id.topicSevenPostTestTime);
        topicEightPostTestTime = root.findViewById(R.id.topicEightPostTestTime);
        topicNinePostTestTime = root.findViewById(R.id.topicNinePostTestTime);
        topicTenPostTestTime = root.findViewById(R.id.topicTenPostTestTime);
        topicElevenPostTestTime = root.findViewById(R.id.topicElevenPostTestTime);
        topicTwelvePostTestTime = root.findViewById(R.id.topicTwelvePostTestTime);

        tutorialTest = root.findViewById(R.id.tutorialTest);
        tutorialCancel2 = root.findViewById(R.id.tutorialCancel2);
        tutorialText2 = root.findViewById(R.id.tutorialText2);
        scrollView2 = root.findViewById(R.id.scrollView2);
        maskView2 = root.findViewById(R.id.maskView2);
        tutorialContent2 = root.findViewById(R.id.tutorialContent2);
        tutorialImage2 = root.findViewById(R.id.tutorialImage2);
        passcode = root.findViewById(R.id.passcode);

        topicOnePreTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicOnePreTestActivity.class);
                startActivity(intent);
            }
        });

        topicTwoPreTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicTwoPreTestActivity.class);
                startActivity(intent);
            }
        });

        topicThreePreTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicThreePreTestActivity.class);
                startActivity(intent);
            }
        });

        topicFourPreTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicFourPreTestActivity.class);
                startActivity(intent);
            }
        });

        topicFivePreTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicFivePreTestActivity.class);
                startActivity(intent);
            }
        });

        topicSixPreTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicSixPreTestActivity.class);
                startActivity(intent);
            }
        });

        topicSevenPreTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicSevenPreTestActivity.class);
                startActivity(intent);
            }
        });

        topicEightPreTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicEightPreTestActivity.class);
                startActivity(intent);
            }
        });

        topicNinePreTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicNinePreTestActivity.class);
                startActivity(intent);
            }
        });

        topicTenPreTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicTenPreTestActivity.class);
                startActivity(intent);
            }
        });

        topicElevenPreTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicElevenPreTestActivity.class);
                startActivity(intent);
            }
        });

        topicTwelvePreTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicTwelvePreTestActivity.class);
                startActivity(intent);
            }
        });

        topicOnePostTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicOnePostTestActivity.class);
                startActivity(intent);
            }
        });

        topicTwoPostTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicTwoPostTestActivity.class);
                startActivity(intent);
            }
        });

        topicThreePostTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicThreePostTestActivity.class);
                startActivity(intent);
            }
        });

        topicFourPostTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicFourPostTestActivity.class);
                startActivity(intent);
            }
        });

        topicFivePostTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicFivePostTestActivity.class);
                startActivity(intent);
            }
        });

        topicSixPostTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicSixPostTestActivity.class);
                startActivity(intent);
            }
        });

        topicSevenPostTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicSevenPostTestActivity.class);
                startActivity(intent);
            }
        });

        topicEightPostTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicEightPostTestActivity.class);
                startActivity(intent);
            }
        });

        topicNinePostTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicNinePostTestActivity.class);
                startActivity(intent);
            }
        });

        topicTenPostTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicTenPostTestActivity.class);
                startActivity(intent);
            }
        });

        topicElevenPostTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicElevenPostTestActivity.class);
                startActivity(intent);
            }
        });

        topicTwelvePostTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TopicTwelvePostTestActivity.class);
                startActivity(intent);
            }
        });

        scoreAndTime11 = dbHandler.getScoreTime(4276);
        scoreAndTime12 = dbHandler.getScoreTime(6856);
        scoreAndTime21 = dbHandler.getScoreTime(8603);
        scoreAndTime22 = dbHandler.getScoreTime(8970);
        scoreAndTime31 = dbHandler.getScoreTime(7137);
        scoreAndTime32 = dbHandler.getScoreTime(7436);
        scoreAndTime41 = dbHandler.getScoreTime(1067);
        scoreAndTime42 = dbHandler.getScoreTime(3186);
        scoreAndTime51 = dbHandler.getScoreTime(9788);
        scoreAndTime52 = dbHandler.getScoreTime(7260);
        scoreAndTime61 = dbHandler.getScoreTime(3552);
        scoreAndTime62 = dbHandler.getScoreTime(9002);
        scoreAndTime71 = dbHandler.getScoreTime(3741);
        scoreAndTime72 = dbHandler.getScoreTime(2658);
        scoreAndTime81 = dbHandler.getScoreTime(6792);
        scoreAndTime82 = dbHandler.getScoreTime(5822);
        scoreAndTime91 = dbHandler.getScoreTime(9263);
        scoreAndTime92 = dbHandler.getScoreTime(4606);
        scoreAndTime101 = dbHandler.getScoreTime(2768);
        scoreAndTime102 = dbHandler.getScoreTime(5739);
        scoreAndTime111 = dbHandler.getScoreTime(2358);
        scoreAndTime112 = dbHandler.getScoreTime(7368);
        scoreAndTime121 = dbHandler.getScoreTime(6235);
        scoreAndTime122 = dbHandler.getScoreTime(5038);

        if (!scoreAndTime11.isEmpty()) {
            topicOnePreTestScore.setText("Score: " + scoreAndTime11.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime11.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicOnePreTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime12.isEmpty()) {
            topicOnePostTestScore.setText("Score: " + scoreAndTime12.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime12.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicOnePostTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime21.isEmpty()) {
            topicTwoPreTestScore.setText("Score: " + scoreAndTime21.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime21.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicTwoPreTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime22.isEmpty()) {
            topicTwoPostTestScore.setText("Score: " + scoreAndTime22.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime22.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicTwoPostTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime31.isEmpty()) {
            topicThreePreTestScore.setText("Score: " + scoreAndTime31.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime31.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicThreePreTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime32.isEmpty()) {
            topicThreePostTestScore.setText("Score: " + scoreAndTime32.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime32.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicThreePostTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime41.isEmpty()) {
            topicFourPreTestScore.setText("Score: " + scoreAndTime41.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime41.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicFourPreTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime42.isEmpty()) {
            topicFourPostTestScore.setText("Score: " + scoreAndTime42.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime42.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicFourPostTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime51.isEmpty()) {
            topicFivePreTestScore.setText("Score: " + scoreAndTime51.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime51.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicFivePreTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime52.isEmpty()) {
            topicFivePostTestScore.setText("Score: " + scoreAndTime52.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime52.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicFivePostTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime61.isEmpty()) {
            topicSixPreTestScore.setText("Score: " + scoreAndTime61.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime61.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicSixPreTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime62.isEmpty()) {
            topicSixPostTestScore.setText("Score: " + scoreAndTime62.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime62.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicSixPostTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime71.isEmpty()) {
            topicSevenPreTestScore.setText("Score: " + scoreAndTime71.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime71.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicSevenPreTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime72.isEmpty()) {
            topicSevenPostTestScore.setText("Score: " + scoreAndTime72.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime72.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicSevenPostTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime81.isEmpty()) {
            topicEightPreTestScore.setText("Score: " + scoreAndTime81.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime81.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicEightPreTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime82.isEmpty()) {
            topicEightPostTestScore.setText("Score: " + scoreAndTime82.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime82.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicEightPostTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime91.isEmpty()) {
            topicNinePreTestScore.setText("Score: " + scoreAndTime91.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime91.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicNinePreTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime92.isEmpty()) {
            topicNinePostTestScore.setText("Score: " + scoreAndTime92.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime92.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicNinePostTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime101.isEmpty()) {
            topicTenPreTestScore.setText("Score: " + scoreAndTime101.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime101.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicTenPreTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime102.isEmpty()) {
            topicTenPostTestScore.setText("Score: " + scoreAndTime102.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime102.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicTenPostTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime111.isEmpty()) {
            topicElevenPreTestScore.setText("Score: " + scoreAndTime111.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime111.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicElevenPreTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime112.isEmpty()) {
            topicElevenPostTestScore.setText("Score: " + scoreAndTime112.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime112.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicElevenPostTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime121.isEmpty()) {
            topicTwelvePreTestScore.setText("Score: " + scoreAndTime121.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime121.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicTwelvePreTestTime.setText("Time: " + totalTime);
        }
        if (!scoreAndTime122.isEmpty()) {
            topicTwelvePostTestScore.setText("Score: " + scoreAndTime122.get(SCORE));
            int totalSeconds = Integer.parseInt(scoreAndTime122.get(TIME));
            int min = (totalSeconds % 3600) / 60;
            int secs = totalSeconds % 60;
            String totalTime = String.format(Locale.getDefault(), "%02d:%02d", min, secs);
            topicTwelvePostTestTime.setText("Time: " + totalTime);
        }

        CardView[] cardViews = {topicOnePreTest, topicOnePostTest, topicTwoPreTest, topicTwoPostTest, topicThreePreTest, topicThreePostTest, topicFourPreTest, topicFourPostTest, topicFivePreTest, topicFivePostTest, topicSixPreTest, topicSixPostTest, topicSevenPreTest, topicSevenPostTest, topicEightPreTest, topicEightPostTest, topicNinePreTest, topicNinePostTest, topicTenPreTest, topicTenPostTest, topicElevenPreTest, topicElevenPostTest, topicTwelvePreTest, topicTwelvePostTest};

        tutorialTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation slideRight = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_right);
                Animation slideUp = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up);
                tutorialContent2.setVisibility(View.VISIBLE);
                maskView2.setVisibility(View.VISIBLE);
                tutorialText2.setAnimation(slideRight);
                tutorialImage2.setAnimation(slideUp);

                tutorialText2.setText("Welcome to the Test Feature! I'm Mr. Buddy, and let's explore how this feature works.");
                tutorialImage2.setImageResource(R.drawable.male_teacher2);
                for (int i = 0; i < cardViews.length; i++) {
                    cardViews[i].setEnabled(false);
                }
                tutorialTest.setEnabled(false);

                slideUp.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.tutorial_tests);
                        mediaPlayer.start();
                        handler.postDelayed(runnable1, 6000);
                        handler.postDelayed(runnable2, 13100);
                        handler.postDelayed(runnable3, 18200);
                        handler.postDelayed(runnable4, 23800);
                        handler.postDelayed(runnable5, 28900);
                        handler.postDelayed(runnable6, 32350);
                        handler.postDelayed(runnable7, 38200);
                        handler.postDelayed(runnable8, 41000);
                        handler.postDelayed(runnable9, 45000);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        runnable1 = new Runnable() {
            @Override
            public void run() {
                tutorialText2.setText("Here, you'll find both pre-tests and post-tests for each topic, each consisting of 15 items.");
                tutorialImage2.setImageResource(R.drawable.male_teacher3);
            }
        };

        runnable2 = new Runnable() {
            @Override
            public void run() {
                tutorialText2.setText("These tests are designed to assess your understanding and learning outcomes.");
            }
        };

        runnable3 = new Runnable() {
            @Override
            public void run() {
                tutorialText2.setText("Remember, before you can access a test, you'll need to enter a passcode provided by your teacher.");
                tutorialImage2.setImageResource(R.drawable.male_teacher1);
                passcode.setVisibility(View.VISIBLE);
            }
        };

        runnable4 = new Runnable() {
            @Override
            public void run() {
                tutorialText2.setText("Once you've completed the test, your score and the time taken will be displayed.");
                passcode.setVisibility(View.GONE);
            }
        };

        runnable5 = new Runnable() {
            @Override
            public void run() {
                tutorialText2.setText("Please note that each test can only be attempted once.");
            }
        };

        runnable6 = new Runnable() {
            @Override
            public void run() {
                tutorialText2.setText("Once completed, you won't have another chance to retake it, and only your result will be shown.");
            }
        };

        runnable7 = new Runnable() {
            @Override
            public void run() {
                tutorialText2.setText("Now, it's time to put your knowledge to the test!");
                tutorialImage2.setImageResource(R.drawable.male_teacher2);
            }
        };

        runnable8 = new Runnable() {
            @Override
            public void run() {
                tutorialText2.setText("Good luck, and may the odds be ever in your favor.");
            }
        };

        runnable9 = new Runnable() {
            @Override
            public void run() {
                tutorialContent2.setVisibility(View.GONE);
                maskView2.setVisibility(View.GONE);
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
                for (int i = 0; i < cardViews.length; i++) {
                    cardViews[i].setEnabled(true);
                }
                tutorialTest.setEnabled(true);
            }
        };

        tutorialCancel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tutorialContent2.setVisibility(View.GONE);
                maskView2.setVisibility(View.GONE);
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
                handler.removeCallbacks(runnable1);
                handler.removeCallbacks(runnable2);
                handler.removeCallbacks(runnable3);
                handler.removeCallbacks(runnable4);
                handler.removeCallbacks(runnable5);
                handler.removeCallbacks(runnable6);
                handler.removeCallbacks(runnable7);
                handler.removeCallbacks(runnable8);
                for (int i = 0; i < cardViews.length; i++) {
                    cardViews[i].setEnabled(true);
                }
                tutorialTest.setEnabled(true);
            }
        });

        return root;
    }
    @Override
    public void onStop()  {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        handler.removeCallbacks(runnable1);
        handler.removeCallbacks(runnable2);
        handler.removeCallbacks(runnable3);
        handler.removeCallbacks(runnable4);
        handler.removeCallbacks(runnable5);
        handler.removeCallbacks(runnable6);
        handler.removeCallbacks(runnable7);
        handler.removeCallbacks(runnable8);
    }
}