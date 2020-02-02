package com.example.demo.soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.contrib.java.lang.system.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Autowired
    private CompactDisc cd;

    @Autowired
    private MediaPlayer player;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }

    @Test
    public void play() {
        player.play();
        assertEquals("Playing " + "Sgt. Peppers's Lonely Hearts Club Band" + " by " + "The Beatles\n", log.getLog());
    }

}