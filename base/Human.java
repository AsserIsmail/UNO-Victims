package base;

import base.Cards.Card;

public class Human extends Player{
    private String colourBlind; // the form of colourblindness that this player has

    private boolean isReady = false; // represents if the player has the readied up status in the lobby

    /**
     * Constructor for a new Uno Player with their entered name and form of colourblindness
     *
     * @param playerName name
     * @param cB         colourBlind
     */
    public Human(String playerName, String cB) {
        super(playerName);
        this.colourBlind = cB;
    }
    /**
     * returns the form of cb the player has selected
     * @return colourblind variant
     */
    public String getCB(){
        return this.colourBlind;
    }

    /**
     * returns whether a player can play the specified card or not and removes from the players hand if it can be played
     * @return true if the selected card is playable
     */
    public boolean playCard(Card selectedCard){
        for(Card c:this.getACards()){
            if(c.isPlayable(selectedCard)){
                this.getHand().remove(c);
                return true;
            }
        }
        return false;
    }

    /**
     * sets the players status to ready
     */
    public void setReady(){
        this.isReady = true;
    }
    /**
     * returns the players ready status
     * @return true if the player is ready
     */
    public boolean getReady(){
        return this.isReady;
    }
}
