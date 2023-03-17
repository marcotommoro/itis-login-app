package com.example.loginexample;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Question {
    String question;
    ArrayList<String> options;

    Question(String question){
        this.question = question;
    }

    public void setOptions(String []options){
        this.options = new ArrayList<String>(Arrays.asList(options));
        System.out.println(this.options);
    }
}
