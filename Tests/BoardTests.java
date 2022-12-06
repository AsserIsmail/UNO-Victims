//package Tests;
//
//
//import base.Board;
//import base.Cards.AbstractCard;
//import base.Cards.Card;
//import base.Human;
//import base.Player;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class BoardTests {
//
//    @Test
//    public void BoardTest(){
//        Player p = new Human("Bob", "Normal");
//        Player p1 = new Human("Rob", "Normal");
//        Player p2 = new Human("Larry", "Normal");
//        Player p3 = new Human("Barry", "Normal");
//        Board board = new Board(new Player[]{p, p1, p2, p3}, "");
//
//        assertEquals(board.getCurrentPlayer(), p);
//        assertEquals(board.getDirection(), 1);
//        assertEquals(board.getNumPlayers(), 4);
//        assertEquals(board.getNextPlayer(), p1);
//        assertEquals(board.getTurn(), 0);
//
//    }
//    @Test
//    public void BoardDeckTest(){
//        Player p = new Human("Bob", "Normal");
//        Player p1 = new Human("Rob", "Normal");
//        Player p2 = new Human("Larry", "Normal");
//        Player p3 = new Human("Barry", "Normal");
//        Board board = new Board(new Player[]{p, p1, p2, p3}, "");
//
//
//        ArrayList result1 = new ArrayList<>(List.of("blue 0", "blue 1", "blue 1", "blue 2", "blue 2",
//                "blue 3", "blue 3", "blue 4", "blue 4", "blue 5", "blue 5", "blue 6", "blue 6", "blue 7", "blue 7",
//                "blue 8", "blue 8", "blue 9", "blue 9", "blue picker", "blue picker", "blue skip", "blue skip", "" +
//                "blue reverse", "blue reverse", "green 0", "green 1", "green 1", "green 2", "green 2", "green 3",
//                "green 3", "green 4", "green 4", "green 5", "green 5", "green 6", "green 6", "green 7", "green 7",
//                "green 8", "green 8", "green 9", "green 9", "green picker", "green picker", "green skip", "green skip",
//                "green reverse", "green reverse", "yellow 0", "yellow 1", "yellow 1", "yellow 2", "yellow 2", "yellow 3",
//                "yellow 3", "yellow 4", "yellow 4", "yellow 5", "yellow 5", "yellow 6", "yellow 6", "yellow 7",
//                "yellow 7", "yellow 8", "yellow 8", "yellow 9", "yellow 9", "yellow picker", "yellow picker",
//                "yellow skip", "yellow skip", "yellow reverse", "yellow reverse", "red 0", "red 1", "red 1", "red 2",
//                "red 2", "red 3", "red 3", "red 4", "red 4", "red 5", "red 5", "red 6", "red 6", "red 7", "red 7",
//                "red 8", "red 8", "red 9", "red 9", "red picker", "red picker", "red skip", "red skip", "red reverse",
//                "red reverse", "wild color_changer", "wild pick_four", "wild color_changer", "wild pick_four",
//                "wild color_changer", "wild pick_four", "wild color_changer", "wild pick_four"));
//
//
//
//
//        ArrayList<AbstractCard> result = new ArrayList<>(board.getDrawDeck());
//
//
//        assertEquals(result.size(), result1.size()-1);
//
//        for (Object card: result1){
//            Card card1 = new Card(card.toString().split(" ")[0],card.toString().split(" ")[1]);
//            assertTrue(result.contains(card1));
//        }
//
//
//    }
//
//
//
//
//
//
//
//
//
//}
