package src_files;

import java.util.ArrayList;
import java.util.Random;

public class Deck_32 
{
    
    // variables
    ArrayList<Card> cardsInDeck;            //stores the cards' blueprints, so we wil have 8 cards x 4 class = 32 cards in total
    int numberOfCardsInDeck;                // = 32

    // methods
    public Card getRandomCard()
    {
        Random rand = new Random();
        int r = rand.nextInt(32);
        return cardsInDeck.get(r);
    }

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

    public void makeCardBlueprints()
    {
        cardsInDeck = new ArrayList<Card>();
        //----- Piano -----
        Card p_Attack1 = new Attack_Card(0,'a', 2, 2);
        cardsInDeck.add(p_Attack1);
        Card p_Attack2 = new Attack_Card(1, 'a', 3, 3);
        cardsInDeck.add(p_Attack2);
        Card p_Attack3 = new Attack_Card(2, 'a', 3, 2);
        cardsInDeck.add(p_Attack3);
        Card p_Attack4 = new Attack_Card(3,'a', 2, 3);
        cardsInDeck.add(p_Attack4);

        Card p_Shield1 = new Shield_Card(4,'s', 2, 2);
        cardsInDeck.add(p_Shield1);
        Card p_Shield2 = new Shield_Card(5,'s', 3, 3);
        cardsInDeck.add(p_Shield2);

        Card p_Heal1 = new Heal_Card(6,'h', 3, 2);
        cardsInDeck.add(p_Heal1);
        Card p_Heal2 = new Heal_Card(7,'h', 2, 3);
        cardsInDeck.add(p_Heal2);

        //----- Drums -----
        Card d_Attack1 = new Attack_Card(8,'a', 2, 2);
        cardsInDeck.add(d_Attack1);
        Card d_Attack2 = new Attack_Card(9, 'a', 3, 3);
        cardsInDeck.add(d_Attack2);
        Card d_Attack3 = new Attack_Card(10, 'a', 3, 2);
        cardsInDeck.add(d_Attack3);
        Card d_Attack4 = new Attack_Card(11,'a', 2, 3);
        cardsInDeck.add(d_Attack4);

        Card d_Shield1 = new Shield_Card(12,'s', 2, 2);
        cardsInDeck.add(d_Shield1);
        Card d_Shield2 = new Shield_Card(13,'s', 3, 3);
        cardsInDeck.add(d_Shield2);

        Card d_Heal1 = new Heal_Card(14,'h', 3, 2);
        cardsInDeck.add(d_Heal1);
        Card d_Heal2 = new Heal_Card(15,'h', 2, 3);
        cardsInDeck.add(d_Heal2);

        //----- Saxophone -----
        Card s_Attack1 = new Attack_Card(16,'a', 2, 2);
        cardsInDeck.add(s_Attack1);
        Card s_Attack2 = new Attack_Card(17, 'a', 3, 3);
        cardsInDeck.add(s_Attack2);
        Card s_Attack3 = new Attack_Card(18, 'a', 3, 2);
        cardsInDeck.add(s_Attack3);
        Card s_Attack4 = new Attack_Card(19,'a', 2, 3);
        cardsInDeck.add(s_Attack4);

        Card s_Shield1 = new Shield_Card(20,'s', 2, 2);
        cardsInDeck.add(s_Shield1);
        Card s_Shield2 = new Shield_Card(21,'s', 3, 3);
        cardsInDeck.add(s_Shield2);

        Card s_Heal1 = new Heal_Card(22,'h', 3, 2);
        cardsInDeck.add(s_Heal1);
        Card s_Heal2 = new Heal_Card(23,'h', 2, 3);
        cardsInDeck.add(s_Heal2);

        //----- Harp. ----- 
        Card h_Attack1 = new Attack_Card(24,'a', 2, 2);
        cardsInDeck.add(h_Attack1);
        Card h_Attack2 = new Attack_Card(25, 'a', 3, 3);
        cardsInDeck.add(h_Attack2);
        Card h_Attack3 = new Attack_Card(26, 'a', 3, 2);
        cardsInDeck.add(h_Attack3);
        Card h_Attack4 = new Attack_Card(27,'a', 2, 3);
        cardsInDeck.add(h_Attack4);

        Card h_Shield1 = new Shield_Card(28,'s', 2, 2);
        cardsInDeck.add(h_Shield1);
        Card h_Shield2 = new Shield_Card(29,'s', 3, 3);
        cardsInDeck.add(h_Shield2);

        Card h_Heal1 = new Heal_Card(30,'h', 3, 2);
        cardsInDeck.add(h_Heal1);
        Card h_Heal2 = new Heal_Card(31,'h', 2, 3);
        cardsInDeck.add(h_Heal2);

        if(cardsInDeck.size() != 32)
        {
            for(int i = 0; i < 50; i++)
            {
                System.out.println("ERROR! No of cards in the current deck: " + cardsInDeck.size() + "/32");
            }
        }
    }

    //constructor
    public void Deck32()
    {
        makeCardBlueprints();
    }
}
