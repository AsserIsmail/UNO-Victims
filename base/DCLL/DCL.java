/*
A class representing a doubly circular linked list. Keeps track of the turns of players in a game of UNO.
 */

package base.DCLL;
import base.Board;
import base.Player;


public class DCL {

    private Node head;


    /*
    Create a DOubly linked circular list to keep track of the turn of the players
     */
    public DCL (int playerNum, Player[] players){

        Player firstP = players[0];
        Node firstN = new Node(firstP);
        this.head = firstN; // Create head

        // Create pointers
        Node curr = firstN;
        Node prev = firstN;

        // Go through the number of players and create a node for each and link together
        for (int i = 1; i < playerNum; i++){

            // Create a new node for the current player
            Node newP = new Node(players[i]);

            // Link current to next
            curr.next = newP;
            curr = curr.next;

            // Link previous node
            curr.prev = prev;
            prev = curr;

        }

        // Link last node to the first node again to complete the circle
        curr.next = firstN;
        curr = curr.next;
        curr.prev = prev;
    }



    /*
    Gives the next player according to the rotation of the came. (e.g. clockwise or counterclockwise)
     */
    public Player getNext(int r){

        if (r == 1){
            return this.head.next.player;
        } else if (r == -1){
            return this.head.prev.player;
        }

        return null;
    }

    /*
    Goes to the next player
     */
    public void goToNext(int r) {
        if (r == 1){
            this.head = this.head.next;
        } else if (r == -1){
            this.head = this.head.prev;
        }
    }

    public Player giveCurr(){
        return this.head.player;
    }

}
