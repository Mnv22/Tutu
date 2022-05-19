package com.example.tutu.benchmark;

import java.math.BigDecimal;
import java.util.Random;

public class CPUDigitsOfPiMC implements IBenchmark {

        int in = 0;
        int out = 0;
    // Pi with 24 digits
        BigDecimal pi ;
        BigDecimal piCalc ;
        BigDecimal epsilon ;

        int error = 1;
        int running=1;
        int iterations=10000000;

    // get random value
        double getRand() {
            Random rd = new Random();
            return rd.nextDouble();
        }
    // get amount of point inside the circle
        int getIn() {
            return this.in;
        }

    // get amount of points outside the circle
        int getOut() {
            return this.out;
        }


        BigDecimal getPi() {
            return this.pi;
        }

        void resetValues() {
            this.in = 0;
            this.out = 0;
            this.piCalc = new BigDecimal(0.0);
            this.error = 1;
        }
    public void initialize(Object ...params){
        pi = new BigDecimal(3.141592653589793238462643);
        piCalc = new BigDecimal(0.0);
        epsilon = new BigDecimal(0.00001);
        //BigDecimal piTmp = BigDecimal.valueOf(4.0 * ((double) this.getIn() / ((double) this.getIn() + (double) this.getOut())));
    }
    public void warmup() {
        int running = 1;

        // reset the values because of a previous calculation
        this.resetValues();
        // start calculation
        for (int i = 0; i < (iterations / 2) && (running == 1); i++) {
            double x = this.getRand();
            double y = this.getRand();
            if (x * x + y * y <= 1) {
                // point is inside the circle
                this.in++;
            } else {
                // point is outside the circle
                this.out++;
            }
        }
    }

    public void run(){
            int running = 1;
        // reset the values because of a previous calculation
        this.resetValues();
        // start calculation
        for (int i = 0; i < iterations && (running == 1); i++) {
            double x = this.getRand();
            double y = this.getRand();
            if (x * x + y * y <= 1) {
                // point is inside the circle
                this.in++;
            } else {
                // point is outside the circle
                this.out++;
            }
        }
    }

    public void run(Object ... params){}

    public void clean(){}
    public void cancel(){
        this.running = 0;
    }

}
