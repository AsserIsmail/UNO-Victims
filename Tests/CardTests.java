package Tests;

import base.Cards.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CardTests {

    @Test
    public void CardTests(){
        Card c = new Card("blue", "5");
        assertEquals(c.getColour(), "blue");
        assertEquals(c.getSymbol(), "5");
    }

    @Test
    public void CardEqualsTest(){
        Card c = new Card("red", "0");
        assertFalse(c.equals(new Card("blue", "5")));
        assertTrue(c.equals(new Card("red", "0")));
    }

    @Test
    public void CardImageTest(){

        Card c = new Card("wild", "pick_four");
        assertEquals(c.getFrontSrc(), "wild_pick_four.png");
        assertEquals(c.getBackSrc(), "card_back.png");

    }

    @Test
    public void CardIsPlayable(){

        Card c1 = new Card("red", "1");
        Card c2 = new Card("red", "5");
        Card c3 = new Card("green", "1");

        assertTrue(c1.isPlayable(c2));
        assertTrue(c1.isPlayable(c3));
        assertFalse(c2.isPlayable(c3));

    }

}
