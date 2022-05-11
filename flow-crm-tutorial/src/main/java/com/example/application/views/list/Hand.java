package com.example.application.views.list;
import java.util.ArrayList;

public class Hand {
    

    // variables

    ArrayList<Card> thisHand;
    Deck_32 gameDeck;
    int cardsCounter;

    // setters & getters

    public Hand()
    {
        gameDeck = new Deck_32();
        thisHand = new ArrayList<Card>();
    }
    
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
    public Card getRandomCard(String instrument){
        return gameDeck.getRandomCard(instrument);
    }

    /**
     * adds card into the arraylist thisHand
     */
    public void addCard(Card card){
        this.thisHand.add(card);
        cardsCounter++;
    }
    /**
     * removes card from the arraylist thisHand
     */
    public void removeCard(Card card){
        //card will be removed from hand if hand contains the desired card
        this.thisHand.remove(card);
    }

    public void putRandomCardIntoHand(String instrument)
    {
        Card r = getRandomCard(instrument);
        addCard(r);
        // System.out.println("Added random card into hand");
    }

    public String toStringHand()
    {
        String str = "";
        for(int a = 0; a < 4; a++)
        {
            str = thisHand.get(a).toString() + "\n";
        }
        return str;
    }
    
}
