package com.didi.concurrency;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String> {


    private int id  ;

    public TaskWithResult(int i) {
        this.id  = i ;
    }



    @Override
    public String call() throws Exception {
        return "TaskWithResult id "+ id;
    }
}
