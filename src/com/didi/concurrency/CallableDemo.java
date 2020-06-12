package com.didi.concurrency;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {


    public  static void main(String[] args)
    {

        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();

        for(int i = 0 ;i<5 ; i++){

            results.add(executorService.submit(new TaskWithResult(i)));


        }
        for (Future<String>fs:results) {

            try
            {


                System.out.println(fs.get());
            }catch (InterruptedException e ){
                System.out.println(e);
                return;
            }catch (ExecutionException e){

                System.out.println(e
                );
            }finally {
                executorService.shutdown();
            }

        }


    }}
