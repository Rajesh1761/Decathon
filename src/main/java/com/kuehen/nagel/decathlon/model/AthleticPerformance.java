package com.kuehen.nagel.decathlon.model;

import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Builder
@Data
public class AthleticPerformance {
    private String name;
    private double sprint100m;
    private double longJump;
    private double shotPut;
    private double highJump;
    private double sprint400m;
    private double sprint110mHurdles;
    private double discusThrow;
    private double poleVault;
    private double javelinThrow;
    private Integer sprint1500mInSeconds;

    public int getScore() {
        return  calculate100m() +
                calculateLongJump() +
                calculateShotPut() +
                calculateHighJump() +
                calculate400m() +
                calculate110mHurdles() +
                calculateDiscusThrow() +
                calculatePoleVault() +
                calculateJavelinThrow() +
                calculate1500m();
    }
    public int calculate100m() {
        return Optional.ofNullable(sprint100m).map(Decathlon.sprint100M::calculate).orElse(0);
    }

    public int calculateLongJump() {
        return Optional.of(longJump).map(Decathlon.longJump::calculate).orElse(0);
    }

    public int calculateShotPut() {
        return Optional.of(shotPut).map(Decathlon.shotPut::calculate).orElse(0);
    }

    public int calculateHighJump() {
        return Optional.of(highJump).map(Decathlon.highJump::calculate).orElse(0);
    }

    public int calculate400m() {
        return Optional.of(sprint400m).map(Decathlon.sprint400M::calculate).orElse(0);
    }

    public int calculate110mHurdles() {
        return Optional.of(sprint110mHurdles).map(Decathlon.sprint100MHurdle::calculate).orElse(0);
    }

    public int calculateDiscusThrow() {
        return Optional.of(discusThrow).map(Decathlon.discusThrow::calculate).orElse(0);
    }

    public int calculatePoleVault() {
        return Optional.of(poleVault).map(Decathlon.poleVault::calculate).orElse(0);
    }

    public int calculateJavelinThrow() {
        return Optional.of(javelinThrow).map(Decathlon.javelinThrow::calculate).orElse(0);
    }

    public int calculate1500m() {
        return Optional.ofNullable(sprint1500mInSeconds).map(Decathlon.sprint1500M::calculate).orElse(0);
    }

}
