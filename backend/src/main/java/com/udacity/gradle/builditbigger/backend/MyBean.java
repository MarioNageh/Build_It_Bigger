package com.udacity.gradle.builditbigger.backend;

import com.marionageh.jokelib.JokeFactory;



public class MyBean {

    private JokeFactory jokeFactory;

    public MyBean() {
        jokeFactory=new JokeFactory();
    }

    public String getJoke() {
        return jokeFactory.getJokeRandom();
    }

}