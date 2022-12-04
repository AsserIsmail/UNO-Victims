package Tests;
import base.Card;
import base.DCLL.DCL;
import base.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.basic.BasicTreeUI;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DCLLTests {

    @Test
    public void CreationDCLTest(){
        Player p = new Player("Bob", "R");
        Player p1 = new Player("Rob", "R");
        Player p2 = new Player("Larry", "R");
        Player p3 = new Player("Barry", "R");

        DCL dcl = new DCL(4, new Player[]{p, p1, p2, p3});

        ArrayList<Player> result = new ArrayList<>(List.of(new Player[]{p, p1, p2, p3}));

        assertEquals(dcl.giveCurr(), p);

        for (int i = 0; i<4; i++){
            assertEquals(dcl.giveCurr(), result.get(i));
            dcl.giveNext(1);
        }

        ArrayList<Player> result1 = new ArrayList<>(List.of(new Player[]{p, p3, p2, p1}));

        assertEquals(dcl.giveCurr(), p);


        for (int i = 0; i<4; i++){
            assertEquals(dcl.giveCurr(), result1.get(i));
            dcl.giveNext(-1);
        }



    }


}
