package com.liucj.learn.meetup;

import java.util.Arrays;

public class DojoMain {
    public static void main(String[] args) {

        System.out.println("args is:");
        System.out.println(Arrays.toString(args));

        System.out.println();
        System.out.println("init parameter starting...");
        ParameterParser.parser(args);

        System.out.println();
        System.out.println("process is starting...");
        Thread demoThread = new Thread(new ServiceDemo());
        demoThread.start();

        try {
            demoThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("process ended.");
    }
}
