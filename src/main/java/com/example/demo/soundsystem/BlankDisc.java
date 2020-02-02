package com.example.demo.soundsystem;

import java.util.List;

public class BlankDisc implements CompactDisc {

    private  String title;
    private  String artist;
    private List<String> tracks;

    @Override
    public void play() {

    }

    @Override
    public void playTrack(int trackNumber) {

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

}
