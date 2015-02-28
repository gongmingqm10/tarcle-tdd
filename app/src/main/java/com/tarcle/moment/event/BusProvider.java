package com.tarcle.moment.event;

import com.squareup.otto.Bus;

public final class BusProvider {
    
    private static final Bus bus = new Bus();
    
    private BusProvider(){}
    
    public static Bus getInstance() {
        return bus;
    }
}
