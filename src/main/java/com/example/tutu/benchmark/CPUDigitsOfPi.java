
package com.example.tutu.benchmark;

import com.example.tutu.benchmark.IBenchmark;

import java.math.BigDecimal;
import java.math.MathContext;

public class CPUDigitsOfPi implements IBenchmark {
    BigDecimal a,b,t,p;
    BigDecimal x,y;
    BigDecimal Pi;

    int running=0;

    int precizion;
    int iterations;
    MathContext mc, mc2;
    public void initialize(Object... params) {
        precizion= (Integer) params[0];
        iterations= (int)(Math.log(precizion)/Math.log(2) + 1);
        mc= new MathContext(precizion);
        mc2= new MathContext(precizion/2);

        a=new BigDecimal(1.0);

        b=new BigDecimal(2.0);
        b=b.sqrt(mc);
        b=BigDecimal.valueOf(1.0).divide(b,mc);

        t=new BigDecimal(1.0/4.0);

        p=new BigDecimal(1.0);


    }
    public void warmup(){
        int running=1;
        for(int i=0; (i<iterations/2) && (running==1); i++)
        {
            x=a.add(b).divide(BigDecimal.valueOf(2.0),mc2);
            y=a.multiply(b).sqrt(mc2);
            t=t.subtract(p.multiply(a.subtract(x).multiply(a.subtract(x))));
            a=x;
            b=y;
            p=p.multiply(BigDecimal.valueOf(2.0));
        }
        Pi=a.add(b).multiply(a.add(b)).divide(t.multiply(BigDecimal.valueOf(4)),mc2);
    }

    public void run() {
        int running=1;
        for(int i=0; (i<iterations) && (running==1); i++)
        {
            x=a.add(b).divide(BigDecimal.valueOf(2.0),mc);
            y=a.multiply(b).sqrt(mc);
            t=t.subtract(p.multiply(a.subtract(x).multiply(a.subtract(x))));
            a=x;
            b=y;
            p=p.multiply(BigDecimal.valueOf(2.0));
        }
        Pi=a.add(b).multiply(a.add(b)).divide(t.multiply(BigDecimal.valueOf(4)),mc);
       // System.out.println(Pi);
    }

    public void run(Object... params) {

    }

    public void cancel() {
        this.running=0;
    }

    public void clean() {

    }
}
