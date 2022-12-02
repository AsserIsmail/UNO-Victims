package Tests;
import base.Card;
import base.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.basic.BasicTreeUI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTests {


    @Test
    public void PlayerTests(){
        Player p = new Player("Bob", "R");
        assertEquals(p.getName(), "Bob");
        assertEquals(p.getCB(), "R");

        assertFalse(p.getUno());
        assertFalse(p.getReady());

        p.uno();
        p.setReady();

        assertTrue(p.getUno());
        assertTrue(p.getReady());
    }



    @Test
    public void PlayerDrawTest(){
        Player p = new Player("Bob", "R");
        Card card = new Card("blue", "5");
        Card card1 = new Card("red", "0");

        Stack<Card> deck = new Stack<>();
        deck.push(card1);
        deck.push(card);
        p.draw(deck);

        ArrayList<Card> result = new ArrayList<>(List.of(new Card[]{card}));


        assertEquals(result, p.getHand());

    }

    @Test
    public void PlayerSetAvailableCardsTest(){
        Player p = new Player("Bob", "R");
        Card card = new Card("blue", "5");
        Card card1 = new Card("green", "7");
        Card card2 = new Card("blue", "7");
        Card card3 = new Card("red", "0");

        Stack<Card> deck = new Stack<>();
        deck.push(card);
        deck.push(card1);
        deck.push(card2);
        deck.push(card3);
        p.draw(deck);
        p.draw(deck);
        p.draw(deck);
        p.draw(deck);
        p.setAvailableCards(card2);

        ArrayList<Card> result = new ArrayList<>(List.of(new Card[]{card2,card1,card}));


        assertEquals(result, p.getACards());

    }


    @Test
    public void PlayerPlayTest(){
        Player p = new Player("Bob", "R");
        Card card = new Card("blue", "5");
        Card card2 = new Card("blue", "7");

        Stack<Card> deck = new Stack<>();
        deck.push(card);

        p.draw(deck);
        p.setAvailableCards(card2);

        assertTrue(p.play(card));
        assertTrue(p.getHand().isEmpty());

    }


}