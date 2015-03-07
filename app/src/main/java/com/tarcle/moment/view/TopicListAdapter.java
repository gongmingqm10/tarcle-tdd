package com.tarcle.moment.view;

import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.tarcle.moment.R;
import com.tarcle.moment.model.Topic;

import java.util.List;

public class TopicListAdapter extends ArrayAdapter<Topic> {


    private final LayoutInflater inflater;

    public TopicListAdapter(Context context, List<Topic> topics) {
        super(context, 0, topics);
        this.inflater = (LayoutInflater) getContext().getSystemService(Service.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TopicCardView topicCardView = (TopicCardView) convertView;
        
        if (topicCardView == null) {
            topicCardView = (TopicCardView) inflater.inflate(R.layout.topic_card_layout, null, false);
        }
        topicCardView.showTopic(getItem(position));
        
        return topicCardView;
    }
}
