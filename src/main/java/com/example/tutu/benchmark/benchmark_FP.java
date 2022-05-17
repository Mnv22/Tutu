package com.example.tutu.benchmark;

import com.example.tutu.benchmark.logger.ConsoleLogger;
import com.example.tutu.benchmark.logger.ILogger;
import com.example.tutu.benchmark.logger.TimeUnit;
import com.example.tutu.benchmark.timer.ITimer;
import com.example.tutu.benchmark.timer.Timer;

import java.io.IOException;

public class benchmark_FP {
    ITimer timer;
    ILogger log;
    IBenchmark bench;
    TimeUnit unit;
    int parameter;

    public benchmark_FP(){
        timer=new Timer();
        bench= new CPUFixedPoint();
        log=new ConsoleLogger();
        unit= TimeUnit.Mili;
        parameter=10000000;
    }

    public double run() throws IOException {
        bench.initialize(parameter);
        for(int i=0;i<150;i++)
            bench.warmup();

        timer.start();
        for (int i=0;i<500;i++)
            bench.run(NumberRepresentation.INT_ARITHMETIC);
        long time=timer.stop();
        double MOPS;
        double seconds=time/500*(Math.pow(10.0,-9));
        MOPS= ((CPUFixedPoint) bench).INT_ARITHMETIC_OPS*parameter/(seconds*1000000.0);
        bench.clean();
        log.close();
        return MOPS;
    }
}
