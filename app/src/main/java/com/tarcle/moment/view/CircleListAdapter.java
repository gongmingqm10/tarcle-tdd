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

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CircleListAdapter extends ArrayAdapter<Circle> {
    private LayoutInflater inflater;
    private int resource;

    public CircleListAdapter(Context context, int resource, List<Circle> circles) {
        super(context, resource, circles);
        this.resource = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public Circle getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(resource, null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.populate(getItem(position));
        return convertView;
    }

    final class ViewHolder {
        @Bind(R.id.circle_name)TextView circleName;
        @Bind(R.id.circle_avatar)ImageView circleAvatar;
        @Bind(R.id.circle_desc)TextView circleDesc;
        @Bind(R.id.circle_status)TextView circleStatus;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public void populate(final Circle circle) {
            if (circle.getAvatar() == null) {
                circleAvatar.setImageResource(R.drawable.tarcle_icon);
            } else {
                Picasso.with(getContext()).load(circle.getAvatar()).into(circleAvatar);
            }
           circleName.setText(circle.getName());
           circleDesc.setText(circle.getDescription());
           circleStatus.setText(renderStatus(circle));
        }

        private String renderStatus(Circle circle) {
            return String.format(
                    "%s: %s, %s: %s, %s: %s",
                    getContext().getString(R.string.follow),
                    circle.getFollowersCount(),
                    getContext().getString(R.string.post),
                    circle.getTopicsCount(),
                    getContext().getString(R.string.role),
                    circle.getRolesCount());
        }
    }
}
