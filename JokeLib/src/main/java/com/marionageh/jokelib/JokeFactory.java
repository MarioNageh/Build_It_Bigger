package com.marionageh.jokelib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeFactory {
    private ArrayList<String> Jokes;
    private Random random;

    public JokeFactory() {
        Jokes=new ArrayList<>();
        Jokes.add("Jokees1");
        Jokes.add("Jokees2");
        Jokes.add("Jokees3");
        Jokes.add("Jokees4");
        Jokes.add("Jokees5");
        Jokes.add("Jokees6");
        Jokes.add("Jokees7");
        Jokes.add("Jokees8");
        Jokes.add("Jokees9");
        Jokes.add("Jokees10");
        Jokes.add("Jokees11");
        Jokes.add("Jokees12");
        Jokes.add("Jokees13");
        random = new Random();
    }


    public String getJokeRandom() {
        return Jokes.get(random.nextInt(Jokes.size()));
    }
}
