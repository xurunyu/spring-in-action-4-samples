package com.example.demo.soundsystem;

import org.springframework.stereotype.Component;

public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Peppers's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

    @Override
    public void playTrack(int trackNumber) {

    }
}
