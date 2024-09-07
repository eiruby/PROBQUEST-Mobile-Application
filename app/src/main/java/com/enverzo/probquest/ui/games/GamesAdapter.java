package com.enverzo.probquest.ui.games;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.enverzo.probquest.R;
import com.enverzo.probquest.ui.games.quizbee.QuizBeeActivity;

import java.util.List;

public class GamesAdapter extends BaseAdapter {
    private Context context;
    private List<String> gameName;
    private List<String> gameDesc;
    private int[] gameImg;
    private int[] gameBg;
    private boolean[] button;

    public GamesAdapter(Context context, List<String> gameName, List<String> gameDesc, int[] gameImg, int[] gameBg, boolean[] button) {
        this.context = context;
        this.gameName = gameName;
        this.gameDesc = gameDesc;
        this.gameImg = gameImg;
        this.gameBg = gameBg;
        this.button = button;
    }

    @Override
    public int getCount() {
        return gameName.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_lesson_cardview,parent,false);
        }
        if (position >= getCount()) {
            return convertView;
        }

        TextView textViewName = convertView.findViewById(R.id.textViewTopic);
        TextView textViewDesc = convertView.findViewById(R.id.textViewObj);
        TextView objective = convertView.findViewById(R.id.objective);
        ImageView imageView = convertView.findViewById(R.id.imageViewTopic);
        Button playButton = convertView.findViewById(R.id.topicButton);
        CardView cardViewGame = convertView.findViewById(R.id.cardViewTopic);

        textViewName.setText(gameName.get(position));
        textViewDesc.setText(gameDesc.get(position));
        objective.setVisibility(View.GONE);
        imageView.setImageResource(gameImg[position]);
        cardViewGame.setCardBackgroundColor(ContextCompat.getColor(context, gameBg[position]));
        playButton.setEnabled(button[position]);
        playButton.setText("Play");

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0) {
                    Intent intent = new Intent(context, WorksheetsActivity.class);
                    context.startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(context, QuizBeeActivity.class);
                    context.startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(context, RollDiceActivity.class);
                    context.startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(context, ColorRouletteActivity.class);
                    context.startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(context, HiLoActivity.class);
                    context.startActivity(intent);
                }
                if (position == 5) {
                    Intent intent = new Intent(context, CoinTossActivity.class);
                    context.startActivity(intent);
                }
            }
        });

        return convertView;
    }
}
