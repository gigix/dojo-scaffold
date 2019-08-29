package com.liucj.learn.meetup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ParameterParser {
    public static final String PARAMETER_L = "l";
    public static final String PARAMETER_P = "p";
    public static final String PARAMETER_D = "d";

    public static HashMap<String, ParameterType> parametersConfig = new HashMap<>();
    public static ConcurrentMap<String, Object> parameters = new ConcurrentHashMap<String, Object>();

    static {
        parametersConfig.put(PARAMETER_L, new ParameterType(PARAMETER_L, true, String.class.getSimpleName()));
        parametersConfig.put(PARAMETER_P, new ParameterType(PARAMETER_P, false, Integer.class.getSimpleName()));
        parametersConfig.put(PARAMETER_D, new ParameterType(PARAMETER_D, false, String.class.getSimpleName()));

        parameters.put(PARAMETER_L,Boolean.valueOf(false));
        parameters.put(PARAMETER_P,Integer.valueOf(0));
        parameters.put(PARAMETER_D, "");
    }

    public static void parser(String[] args) {
        List<String> argList = Arrays.asList(args);
//        System.out.println("args is:");
//        argList.forEach(System.out::println);
        Iterator<String> it = argList.iterator();
        boolean getNext = true;
        String key = null;
        String parameter = null;
        String value = null;
        while (it.hasNext()) {
            if (getNext) {
                key = it.next();
            }
            getNext = true;
            parameter = key;
            if (parameter.startsWith("-")) {
                parameter = parameter.substring(1);
                if (parametersConfig.containsKey(parameter)) {
//                    System.out.println("init parameter for " + parameter);
                    if (it.hasNext()) {
                        value = it.next();
                        if (!value.startsWith("-")) {
                            if (parametersConfig.get(parameter).isPosition()) {
                                System.out.println("parameter " + parameter + " don't need a value!");
                                System.exit(-1);
                            } else {
                                if (parametersConfig.get(parameter).getType().equals(String.class.getSimpleName())) {
                                    parameters.put(parameter, (String) value);
                                } else if (parametersConfig.get(parameter).getType().equals(Integer.class.getSimpleName())) {
                                    parameters.put((parameter), Integer.valueOf(value));
                                } else {
                                    parameters.put(parameter, value);
                                }
                                System.out.println("init parameter:"+parameter+ " using value:"+value);
                            }
                        } else {
                            key = value;
                            if (parametersConfig.get(parameter).isPosition()) {
                                parameters.put(parameter, Boolean.valueOf(true));
                                System.out.println("init parameter:"+parameter+ " using value:true");
                                getNext = false;
                            } else {
                                System.out.println("parameter " + parameter + " must hava a value!");
                                System.exit(-1);
                            }
                        }
                    } else {
                        if (parametersConfig.get(parameter).isPosition()) {
                            parameters.put(parameter, Boolean.valueOf(true));
                            System.out.println("init parameter:"+parameter+ " using value:true");
                        } else {
                            System.out.println("parameter " + parameter + " must hava a value!");
                            System.exit(-1);
                        }
                    }
                } else {
                    System.out.println("parameter error,parameter " + parameter + " is not valid!");
                    System.exit(-1);
                }
            } else {
                System.out.println("parameter error,parameter " + parameter + " must start with - !");
                System.exit(-1);
            }
        }
    }

    public static boolean getParameterL() {
        return (Boolean) parameters.get(PARAMETER_L);
    }

    public static int getParameterP() {
        return (int) parameters.get(PARAMETER_P);
    }

    public static String getParameterD() {
        return (String) parameters.get(PARAMETER_D);
    }
}
