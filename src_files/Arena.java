package src_files;

import java.util.Scanner;

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
        Scanner in = new Scanner(System.in);
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
                

    }

    private void playCard(Player p, Player e, int pCardChoice, char pPlayedCardType) 
    {
        Card pPlayedCard = p.playerHand.getThisHand().get(pCardChoice);
            p.playerHand.removeCard(pPlayedCard);

        if(pPlayedCardType == 'a') //attack card
        {
            //if enemy has shield, attack that first
            if(e.getShield() <= 0)
                e.updateHealth(((Attack_Card)pPlayedCard).getAttackAmount());
            else    //meaning no shield
                e.updateShield(((Attack_Card)pPlayedCard).getAttackAmount());
        }
        else if(pPlayedCardType == 's') //shield card
        {
            p.healShield(((Shield_Card)pPlayedCard).getShieldAmount());
        }
        else //its heal
        {
            p.healHealth((((Heal_Card)pPlayedCard).getHealAmount())); 
        }
    }

    public void playTurn()
    {
        if(p1.getHealth() > 0 && p2.getHealth() > 0)
            playP1();
        if(p1.getHealth() > 0 && p2.getHealth() > 0)
            playP2();
    }

    public void playP1() 
    {
        //3.1-p1 plays card
            //3.1.1-p1 chooses which card to play from his hand 
        int p1CardChoice;
        System.out.println("Which card do you want to play? [1,2,3,4]");
        // 3.1.2-Take user card choice
            // p1CardChoice = in.nextInt();
        p1CardChoice = 1;       //take 1 as example
        //3.1.2-play this card
        char p1PlayedCardType = p1.playerHand.getThisHand().get(p1CardChoice).getType();
        playCard(p1, p2, p1CardChoice, p1PlayedCardType);
    }
    public void playP2() 
    {
        //3.1-p1 plays card
            //3.1.1-p1 chooses which card to play from his hand 
            int p2CardChoice;
            System.out.println("Which card do you want to play? [1,2,3,4]");
            // 3.1.2-Take user card choice
                // p1CardChoice = in.nextInt();
            p2CardChoice = 1;       //take 1 as example
            //3.1.2-play this card
            char p2PlayedCardType = p2.playerHand.getThisHand().get(p2CardChoice).getType();
            playCard(p2, p1, p2CardChoice, p2PlayedCardType);    
    }

    public static void main(String[] args) 
    {

    }
}
