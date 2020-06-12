package com.didi.concurrency;

import java.util.concurrent.Callable;

public class SleepTask implements Callable<String>

{
    private int id ;

    void SleepTask (int id ){

        this.id = id ;

    }

    @Override
    public String call() throws Exception {
        return "SleepTask  id :"+id;
    }
}
