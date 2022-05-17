package com.example.tutu.benchmark.timer;

public class Timer implements ITimer{
    long time;
    long ElapsedTime;
    int paused;
    public void start(){
        time=System.nanoTime();
        paused=0;
        ElapsedTime=0;
    }

    public long pause() {
            if(paused==0) {
                paused=1;
                ElapsedTime=ElapsedTime+(System.nanoTime()-time);
                return (System.nanoTime()-time);
            }
            return 0;
    }

    public void resume(){
            time = System.nanoTime();
            paused=0;
    }

    public long stop(){
        if (paused==1)
            return ElapsedTime;
        else
        {
            paused=1;
            ElapsedTime=ElapsedTime+(System.nanoTime()-time);
            return ElapsedTime;
        }
    }

}
