package com.kuehen.nagel.decathlon.model;

import com.kuehen.nagel.decathlon.calulations.Events;

import static com.kuehen.nagel.decathlon.utils.DecathlonConstant.fieldEvents;
import static com.kuehen.nagel.decathlon.utils.DecathlonConstant.trackEvents;

public enum Decathlon {

    sprint100M(trackEvents,25.4347, 18.0, 1.81),
    longJump(fieldEvents, 0.14354, 220.0, 1.4),
    shotPut(fieldEvents, 51.39, 1.5, 1.05),
    highJump(fieldEvents, 0.8465, 75.0, 1.42),
    sprint400M(trackEvents, 1.53775, 82.0, 1.81),
    sprint100MHurdle(trackEvents, 5.74352, 28.5, 1.92),
    discusThrow(fieldEvents, 12.91, 4.0, 1.1),
    poleVault(fieldEvents, 0.2797, 100.0, 1.35),
    javelinThrow(fieldEvents, 10.14, 7.0, 1.08),
    sprint1500M(trackEvents, 0.03768, 480.0, 1.85),
    ;
    Decathlon(Events events, double a, double b, double c) {
        this.events = events;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    private final Events events;
    private final double a;
    private final double b;
    private final double c;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public int calculate(double performance) {
        return events.calculate(performance, this);
    }
}
