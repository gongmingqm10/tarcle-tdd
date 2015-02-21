package com.tarcle.moment.activity;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

@LargeTest
public class RootActivityEspressoTest extends ActivityInstrumentationTestCase2<RootActivity> {

    public RootActivityEspressoTest() {
        super(RootActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testActivityNotNull() {
        assertNotNull(getActivity());
    }

}