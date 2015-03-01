package com.tarcle.moment.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tarcle.moment.R;
import com.tarcle.moment.model.Circle;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class CircleListAdapter extends ArrayAdapter<Circle> {
    private LayoutInflater inflater;
    private int resource;
    private ArrayList<Circle> circles;

    public CircleListAdapter(Context context, int resource, ArrayList<Circle> circles) {
        super(context, resource, circles);
        this.circles = circles;
        this.resource = resource;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Circle getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(resource, null, false);
            holder.circleName = ButterKnife.findById(convertView, R.id.circle_name);
            holder.circleAvatar = ButterKnife.findById(convertView, R.id.circle_avatar);
            holder.circleDesc = ButterKnife.findById(convertView, R.id.circle_desc);
            holder.circleStatus = ButterKnife.findById(convertView, R.id.circle_status);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Circle circle = circles.get(position);

        if (circle.getAvatar() == null) {
            holder.circleAvatar.setImageResource(R.drawable.tarcle_icon);
        } else {
            Picasso.with(getContext()).load(circle.getAvatar()).into(holder.circleAvatar);
        }

        holder.circleName.setText(circle.getName());
        holder.circleDesc.setText(circle.getDescription());
        holder.circleStatus.setText(renderStatus(circle));

        return convertView;

    }

    private String renderStatus(Circle circle) {
        StringBuilder builder = new StringBuilder("关注: ")
                .append(circle.getFollowersCount())
                .append(", 帖子: ")
                .append(circle.getTopicsCount())
                .append(", 角色: ")
                .append(circle.getTopicsCount());
        return builder.toString();
    }

    final class ViewHolder {
        ImageView circleAvatar;
        TextView circleName;
        TextView circleDesc;
        TextView circleStatus;
    }
}
