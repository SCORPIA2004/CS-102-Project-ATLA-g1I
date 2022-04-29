package src_files;
public class Deck_32 
{
    
    // variables
    ArrayList<Card> cardsInDeck;            //stores the cards' blueprints, so we wil have 8 cards x 4 class = 32 cards in total
    int numberOfCardsInDeck;                // = 32

    public ArrayList<Card> getCardsInDeck() 
    {
        return this.cardsInDeck;
    }

    public void setCardsInDeck(ArrayList<Card> cardsInDeck) 
    {
        this.cardsInDeck = cardsInDeck;
    }

    public int getNumberOfCardsInDeck() 
    {
        return this.numberOfCardsInDeck;
    }

    public void setNumberOfCardsInDeck(int numberOfCardsInDeck) 
    {
        this.numberOfCardsInDeck = numberOfCardsInDeck;
    }

    public ArrayList<Card> makeCardBlueprints()
    {
        // Piano
        Card p_Attack1 = new Card();
        // Drums
        // Saxophone
        // Harp. 

    }

    // methods

    //constructor
    public Deck32()
    {
        setCardsInDeck(32);

    }
}
