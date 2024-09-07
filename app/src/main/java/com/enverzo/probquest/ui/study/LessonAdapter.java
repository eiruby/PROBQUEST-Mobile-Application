package com.enverzo.probquest.ui.study;

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

import java.util.List;

public class LessonAdapter extends BaseAdapter {
    private Context context;
    private List<String> topicName;
    private List<String> topicObj;
    private int[] topicImg;
    private int[] topicBg;
    private boolean[] button;

    public LessonAdapter(Context context, List<String> topicName, List<String> topicObj, int[] topicImg, int[] topicBg, boolean[] button) {
        this.context = context;
        this.topicName = topicName;
        this.topicObj = topicObj;
        this.topicImg = topicImg;
        this.topicBg = topicBg;
        this.button = button;
    }

    @Override
    public int getCount() {
        return topicName.size();
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

        TextView textViewTopic = convertView.findViewById(R.id.textViewTopic);
        TextView textViewObj = convertView.findViewById(R.id.textViewObj);
        ImageView imageViewTopic = convertView.findViewById(R.id.imageViewTopic);
        Button topicButton = convertView.findViewById(R.id.topicButton);
        CardView cardViewTopic = convertView.findViewById(R.id.cardViewTopic);

        textViewTopic.setText(topicName.get(position));
        textViewObj.setText(topicObj.get(position));
        imageViewTopic.setImageResource(topicImg[position]);
        cardViewTopic.setCardBackgroundColor(ContextCompat.getColor(context, topicBg[position]));
        topicButton.setEnabled(button[position]);

        topicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0) {
                    Intent intent = new Intent(context, TopicOneActivity.class);
                    context.startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(context, TopicTwoActivity.class);
                    context.startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(context, TopicThreeActivity.class);
                    context.startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(context, TopicFourActivity.class);
                    context.startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(context, TopicFiveActivity.class);
                    context.startActivity(intent);
                }
                if (position == 5) {
                    Intent intent = new Intent(context, TopicSixActivity.class);
                    context.startActivity(intent);
                }
                if (position == 6) {
                    Intent intent = new Intent(context, TopicSevenActivity.class);
                    context.startActivity(intent);
                }
                if (position == 7) {
                    Intent intent = new Intent(context, TopicEightActivity.class);
                    context.startActivity(intent);
                }
                if (position == 8) {
                    Intent intent = new Intent(context, TopicNineActivity.class);
                    context.startActivity(intent);
                }
                if (position == 9) {
                    Intent intent = new Intent(context, TopicTenActivity.class);
                    context.startActivity(intent);
                }
                if (position == 10) {
                    Intent intent = new Intent(context, TopicElevenActivity.class);
                    context.startActivity(intent);
                }
                if (position == 11) {
                    Intent intent = new Intent(context, TopicTwelveActivity.class);
                    context.startActivity(intent);
                }
            }
        });

        return convertView;
    }
}
