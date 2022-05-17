package com.example.tutu.benchmark.logger;

import java.io.IOException;

public class ConsoleLogger implements ILogger{
    public void write(Long l){
        System.out.println(l);
    }
    public void write(String s) {
        System.out.println(s);
    }


    public void write(Object... values) throws IOException {
        for (Object value : values)
            if (value instanceof String) System.out.print((String)value);
            else if(value instanceof Long) System.out.print(Long.toString((Long)value));
            else if(value instanceof  Integer) System.out.print(Integer.toString((Integer)value));
            else if (value instanceof Double) System.out.print(Double.toString((Double)value));
    }

    public void writeTime(long value, TimeUnit unit) {
        TimeUnit current= TimeUnit.Nano;
        System.out.println(TimeUnit.converter(value,current,unit));
    }

    public void writeTime(String s, long value, TimeUnit unit){
        TimeUnit current= TimeUnit.Nano;
        System.out.println(s + Long.toString((long) TimeUnit.converter(value,current,unit)) + " " + unit);
    }

    public void close() {}
}
