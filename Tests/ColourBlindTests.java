//package Tests;
//
//import base.Cards.Card;
//import base.ColourblindCards.HCCard;
//import base.ColourblindCards.SGBKCard;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class ColourBlindTests {
//
//
//    @Test
//    public void DecorateNameTest(){
//
//        Card c1 = new Card("blue", "5");
//        HCCard c1hc = new HCCard(c1);
//
//        assertEquals(c1hc.getFrontSrc(), c1.getFrontSrc() + "HC");
//        assertEquals(c1hc.getBackSrc(), c1.getBackSrc() + "HC");
//
//    }
//
//
//    @Test
//    public void DecorateIsPlayableTest(){
//
//        Card c1 = new Card("blue", "0");
//        Card c2 = new Card("blue", "5");
//        Card c3 = new Card("red", "0");
//
//        HCCard c1hc = new HCCard(c1);
//        HCCard c2hc = new HCCard(c2);
//        HCCard c3hc = new HCCard(c3);
//
//        assertTrue(c1hc.isPlayable(c2hc));
//        assertTrue(c1hc.isPlayable(c3hc));
//        assertFalse(c2hc.isPlayable(c3hc));
//
//
//    }
//
//
//    @Test
//    public void equalsTest(){
//
//        Card c1 = new Card("red", "1");
//        Card c2 = new Card("red", "1");
//
//        HCCard c1hc = new HCCard(c1);
//        HCCard c2hc = new HCCard(c2);
//
//        assertTrue(c1hc.equals(c2hc));
//
//    }
//
//
//    @Test
//    public void nestedTest(){
//
//        Card c1 = new Card("red", "1");
//        Card c2 = new Card("red", "5");
//
//
//        SGBKCard dec1 = new SGBKCard(c1);
//        HCCard dec11 = new HCCard(dec1);
//
//        assertEquals(dec11.getFrontSrc(), "red_1_HC.png");
//        assertEquals(dec11, dec1);
//        assertTrue(c2.isPlayable(dec11));
//        assertTrue(c2.isPlayable(dec1));
//
//    }
//
//
//}
