package com.example.tutu.benchmark;

import com.example.tutu.benchmark.IBenchmark;
import com.example.tutu.benchmark.logger.ConsoleLogger;
import com.example.tutu.benchmark.logger.ILogger;
import com.example.tutu.benchmark.logger.TimeUnit;
import com.example.tutu.benchmark.timer.ITimer;
import com.example.tutu.benchmark.timer.Timer;

import java.io.IOException;


public class TestCPUDigitsOfPiMC {

    public static void main(String[] args) throws IOException {
        ITimer timer=new Timer();
        ILogger log= new ConsoleLogger();
        IBenchmark bench= new CPUDigitsOfPiMC();
        TimeUnit unit= TimeUnit.Mili;


        int iterations=10;
        final int parameter= 100000000;
        bench.initialize(parameter);

        for(int i=0;i<iterations/2;i++)
            bench.warmup();

        for (int i=0;i<iterations;i++) {
            timer.resume();
            bench.run();
            long time = timer.pause();
            bench.clean();
            log.write("Run: ", i);
            log.writeTime(" finished in ", time, unit);
        }


        log.writeTime("Average time: ", timer.stop()/iterations, TimeUnit.Mili);
        log.close();
        bench.clean();


    }

}
