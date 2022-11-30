package base.DCLL;

/*
A class representing a node in a doubly circular linked list.
 */

import base.Player;

public class Node {

    public Player player;

    public Node next;

    public Node prev;



    public Node(Player p) {
        this.player = p;
        this.next = null;
        this.prev = null;
    }



}
