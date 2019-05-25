package com.liucj.learn.meetup;

public class ServiceDemo implements Runnable {
    @Override
    public void run() {
        if (ParameterParser.getParameterL()) {
            System.out.println("parameter " + ParameterParser.PARAMETER_L + " is true");
        } else {
            System.out.println("parameter " + ParameterParser.PARAMETER_L + " is false");
        }

        if (ParameterParser.getParameterP() != 0) {
            System.out.println("parameter " + ParameterParser.PARAMETER_P + " is " + ParameterParser.getParameterP());
        } else {
            System.out.println("parameter " + ParameterParser.PARAMETER_P + " is default value 0");
        }

        if (ParameterParser.getParameterD() == null ||
                ParameterParser.getParameterD().equals("")) {
            System.out.println("parameter " + ParameterParser.PARAMETER_D + " is default value blank");
        }else {
            System.out.println("parameter " + ParameterParser.PARAMETER_D + " is " + ParameterParser.getParameterD());
        }
    }
}
