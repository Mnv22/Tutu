package com.example.tutu.benchmark.logger;

public enum TimeUnit {
    Nano(0),Micro(1),Mili(2),Sec(3);

    public final int value;

    private TimeUnit(int value){
        this.value=value;
    }

    public static double converter(long time, TimeUnit from, TimeUnit to)
    {
        return time*(Math.pow(10,3*(from.value - to.value)));
    }
}
