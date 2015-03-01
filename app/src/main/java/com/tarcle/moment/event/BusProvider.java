package com.tarcle.moment.event;

import com.squareup.otto.Bus;

public final class BusProvider {
    
    protected static Bus bus = new Bus();
    
    private BusProvider(){}
    
    public static Bus getInstance() {
        return bus;
    }
}
