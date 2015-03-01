package com.tarcle.moment.event;

import com.squareup.otto.Bus;

public class BusProviderInjection {

    public static void setBus(Bus bus) {
        BusProvider.bus = bus;
    }
}