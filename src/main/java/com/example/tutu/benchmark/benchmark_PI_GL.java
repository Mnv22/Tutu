package com.example.tutu.benchmark;

import com.example.tutu.benchmark.IBenchmark;
import com.example.tutu.benchmark.logger.ConsoleLogger;
import com.example.tutu.benchmark.logger.ILogger;
import com.example.tutu.benchmark.logger.TimeUnit;
import com.example.tutu.benchmark.timer.ITimer;
import com.example.tutu.benchmark.timer.Timer;

import java.io.IOException;

public class benchmark_PI_GL {
    ITimer timer;
    ILogger log;
    IBenchmark bench;
    TimeUnit unit;
    int iterations;
    int parameter;
    public benchmark_PI_GL(){
        timer=new Timer();
        bench= new CPUDigitsOfPi();
        log=new ConsoleLogger();
        unit= TimeUnit.Mili;
        iterations=10;
    }

    public long run(int number_of_digits) throws IOException{
        parameter= number_of_digits;
        bench.initialize(parameter);
        for(int i=0;i<iterations/2;i++)
            bench.warmup();
        for (int i=0;i<iterations;i++) {
            timer.resume();
            bench.run();
            long time = timer.pause();
           // log.writeTime(" finished in ", time, unit);
            bench.clean();
        }
       // log.writeTime("Average time: ", timer.stop()/iterations, TimeUnit.Mili);
        long time=(long)(timer.stop()*Math.pow(10,-6))/iterations;
        log.close();
        bench.clean();
        return time;


    }

    public void stop() throws IOException{
        bench.cancel();
    }
}
