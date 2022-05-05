package src_files;

public class Main_Game 
{
    public Player p1;
    public Player p2;

    public Main_Game(Player player1, Player player2)
    {
        p1 = player1;
        p2 = player2;
    }

    public void givePlayerCard()
    {
        p1.playerHand.
    }

    public void arena_game()
    {
        Main_Game arena = new Main_Game(p1, p2);
        //1-setup the arena
        //2-give player cards
            //2.1-make a deck
            arena.makeGameDeck();
            //2.2-give player 4 cards from it
            for(int i = 0; i < 4; i++)
            {
                p1.givePlayerCard();
            }

    }

    public static void main(String[] args) 
    {
    }
    
}
