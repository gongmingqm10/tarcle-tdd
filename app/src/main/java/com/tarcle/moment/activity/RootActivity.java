package com.tarcle.moment.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.tarcle.moment.R;
import com.tarcle.moment.fragment.CircleFragment;
import com.tarcle.moment.fragment.MineFragment;
import com.tarcle.moment.fragment.NavigationDrawerFragment;
import com.tarcle.moment.fragment.TopicFragment;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateManager;


public class RootActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private NavigationDrawerFragment mNavigationDrawerFragment;

    private CircleFragment circleFragment;
    private MineFragment mineFragment;
    private TopicFragment topicFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, getFragmentByIndex(position))
                .commit();
    }


    private Fragment getFragmentByIndex(int position) {
        switch (position) {
            case 0:
                if (circleFragment == null) circleFragment = new CircleFragment();
                return circleFragment;
            case 1:
                if (topicFragment == null) topicFragment = new TopicFragment();
                return topicFragment;
            case 2:
                if (mineFragment == null) mineFragment = new MineFragment();
                return mineFragment;
            default:
                return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            getMenuInflater().inflate(R.menu.root, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return item.getItemId() == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    private void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle(getTitle());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkForCrashes();
        checkForUpdates();
    }
    private void checkForCrashes() {
        CrashManager.register(this, "c01e5754d72e78f2854c8b72a646cb36");
    }

    private void checkForUpdates() {
        // Remove this for store builds!
        UpdateManager.register(this, "c01e5754d72e78f2854c8b72a646cb36");
    }
}
