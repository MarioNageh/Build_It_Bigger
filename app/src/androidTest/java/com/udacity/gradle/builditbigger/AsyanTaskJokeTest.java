package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.Network.AsyanTaskJoke;

import static junit.framework.Assert.assertNotNull;


public class AsyanTaskJokeTest extends AndroidTestCase {

    @SuppressWarnings("unchecked")
    public void test() {
        String jokenotnull = null;
        AsyanTaskJoke asyanTaskJoke = new AsyanTaskJoke(getContext(), null);
        asyanTaskJoke.execute();
        try {
            jokenotnull = asyanTaskJoke.get();
            // we will get not-empty,String
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(jokenotnull);
    }
}
