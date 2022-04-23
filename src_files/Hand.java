package src_files;
import java.util.ArrayList;

public class Hand {
    

    // variables

    ArrayList<Card> thisHand;
    Deck_32 gameDeck;
    int cardsCounter;

    // setters & getters

    public ArrayList<Card> getThisHand() {
        return this.thisHand;
    }

    public void setThisHand(ArrayList<Card> thisHand) {
        this.thisHand = thisHand;
    }

    public Deck_32 getGameDeck() {
        return this.gameDeck;
    }

    public void setGameDeck(Deck_32 gameDeck) {
        this.gameDeck = gameDeck;
    }

    public int getCardsCounter() {
        return this.cardsCounter;
    }

    public void setCardsCounter(int cardsCounter) {
        this.cardsCounter = cardsCounter;
    }


    // methods

    /**
     *  Generates a random card from the game deck
     */
    public Card getRandomCard(){
        return null;
    }

    /**
     * adds card into the arraylist thisHand
     */
    public void addCard(Card card){
        this.thisHand.add(card);
    }
    /**
     * removes card from the arraylist thisHand
     */
    public void removeCard(Card card){
        this.thisHand.remove(card);
    }
}
