package com.tarcle.moment.view;

import android.view.View;
import android.widget.TextView;

import com.tarcle.moment.R;
import com.tarcle.moment.TarcleRobolectricTestRunner;
import com.tarcle.moment.model.Circle;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RuntimeEnvironment;

import java.util.ArrayList;

import butterknife.ButterKnife;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

@RunWith(TarcleRobolectricTestRunner.class)
public class CircleListAdapterTest {

    private CircleListAdapter adapter;

    @Before
    public void setUp() throws Exception {
        ArrayList<Circle> circles = newArrayList(
                new Circle().setName("Circle Song").setDescription("The circle Song description").build(),
                new Circle().setName("Circle Tang").setDescription("The circle Tang description")
                        .setFollowersCount(30).setTopicsCount(120).setRolesCount(99).build()
        );

        adapter = new CircleListAdapter(RuntimeEnvironment.application, R.layout.circle_list_item, circles);
    }

    @Test
    public void shouldShowGroupName() {
        View view = adapter.getView(0, null, null);
        TextView circleName = ButterKnife.findById(view, R.id.circle_name);
        assertThat(circleName.getText().toString()).isEqualTo("Circle Song");
    }

    @Test
    public void shouldShowFormattedStatus() {
        View view = adapter.getView(1, null, null);
        TextView circleDesc = ButterKnife.findById(view, R.id.circle_status);
        assertThat(circleDesc.getText().toString()).isEqualTo("关注: 30, 帖子: 120, 角色: 99");
    }

    @Test
    public void shouldShowDesc() {
        View view = adapter.getView(1, null, null);
        TextView circleDesc = ButterKnife.findById(view, R.id.circle_desc);
        assertThat(circleDesc.getText().toString()).isEqualTo("The circle Tang description");
    }
}