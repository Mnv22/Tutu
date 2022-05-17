package com.example.tutu.benchmark.logger;

import java.io.IOException;

public interface ILogger {
    void write(Long l) throws IOException;
    void write(String s) throws  IOException;
    void write(Object ... values) throws IOException;
    void close() throws IOException;

    void writeTime(long value, TimeUnit unit) throws IOException;
    void writeTime(String s, long value, TimeUnit unit) throws  IOException;

}
