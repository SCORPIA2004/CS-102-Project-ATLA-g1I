package src_files;

public class Arena 
{
    public Player p1;
    public Player p2;

    public Arena(Player player1, Player player2)
    {
        p1 = player1;
        p2 = player2;
    }

    public void arena_game()
    {
        // Arena arena = new Arena(p1, p2);
        //1-setup the arena
        //2-give player cards
            //2.1-make a deck
            // p1.makeGameDeck();               //already initialised deck when declared in player hand
            //2.2-give player 4 cards from it
            for(int i = 0; i < 4; i++)
            {
                p1.givePlayerCard();
            }
            for(int i = 0; i < 4; i++)
            {
                p2.givePlayerCard();
            }

            System.out.println("Player 1 health: " + p1.health);
            System.out.println("Player 1 shield: " + p1.shield);
            System.out.println("Player 1 mana: " + p1.mana);
        //3-now we play the turns
            //3.1-p1 plays card
                //3.1.1-p1 chooses which card to play from his hand
                int p1CardChoice = 1;
                //3.1.2-play this card
                char p1PlayedCardType = p1.playerHand.getThisHand().get(p1CardChoice).getType();
                

    }


    public static void main(String[] args) 
    {
    }
    
}
