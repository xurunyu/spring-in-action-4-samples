package com.example.demo.knights;

import com.example.demo.quest.Quest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BraveKnightTest {
    @Test
    public void knightShouldEmbarkOnQuest() {
        Quest mockQuest = mock(Quest.class);
        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();;
    }
}