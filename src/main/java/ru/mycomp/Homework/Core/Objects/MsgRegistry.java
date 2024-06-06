package ru.mycomp.Homework.Core.Objects;

import java.util.concurrent.atomic.AtomicInteger;

public class MsgRegistry {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static String getMsg() {
        int index = counter.incrementAndGet();
        return ("Message №"+index);
    }
}
