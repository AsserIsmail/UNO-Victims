
import java.util.ArrayList;

import javax.swing.text.html.ImageView;

public class Player {

    private String name;
    private ArrayList<Card> cards;
    private ArrayList<ImageView> cardsView;
    private boolean firstStarter = false;

    public Player(String initName) {
        name = initName;
        cards = new ArrayList<Card>();
        cardsView = new ArrayList<ImageView>();

    }

    public void setFirstStarter(boolean firstStarter) {
        this.firstStarter = firstStarter;
    }

    public boolean isFirstStarter() {
        return firstStarter;
    }

    public Card discard(Card discarded) throws IllegalArgumentException {

        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).equals(discarded)) {
                return cards.remove(i);

            }
        }
        throw new IllegalArgumentException("You don't have that card");

    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void draw(Card drawn) {

        cards.add(drawn);
    }
    public void draw(ImageView drawn) {

        cardsView.add(drawn);

    }

    public ArrayList<ImageView> getCardsView() {
        return cardsView;
    }

    public String toString() {

        return name;
    }

}
