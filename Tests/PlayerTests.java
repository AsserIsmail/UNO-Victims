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
}
