package Tests;
import base.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.basic.BasicTreeUI;


import static org.junit.jupiter.api.Assertions.*;


public class PlayerTests {

        @Test
        public void dealTest(){
            Computer bob = new Computer("bob");
            Human p1 = new Human("Norton", "null");
            Board board = new Board(new Player[]{p1, bob});
            p1.deal(board.getDrawDeck());
            bob.deal(board.getDrawDeck());
            assertEquals(7, bob.getHand().size());
            assertEquals(7, p1.getHand().size());
        }



import static org.junit.jupiter.api.Assertions.*;

public class PlayerTests {


    @Test
    public void PlayerTests(){
        Player p = new Player("Bob", "Normal");
        assertEquals(p.getName(), "Bob");
        assertEquals(p.getCB(), "Normal");

        assertFalse(p.getUno());
        assertFalse(p.getReady());

        p.uno();
        p.setReady();

        assertTrue(p.getUno());
        assertTrue(p.getReady());
    }



    @Test
    public void PlayerDrawTest(){
        Player p = new Player("Bob", "Normal");
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
        Player p = new Player("Bob", "Normal");
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
        Player p = new Player("Bob", "Normal");
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
