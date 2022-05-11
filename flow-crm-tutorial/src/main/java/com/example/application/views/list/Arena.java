package com.example.application.views.list;

import java.util.Scanner;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;

public class Arena
{
    public Player p1;
    public Player p2;
    public Card pPlayedCard;
    public int p1CardChoice;
    public int p2CardChoice;

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
                p1.givePlayerCard(p1.getInstrumentName());
            }
            for(int i = 0; i < 4; i++)
            {
                p2.givePlayerCard(p2.getInstrumentName());
            }

            System.out.println("Player 1 health: " + p1.health);
            System.out.println("Player 1 shield: " + p1.shield);
            System.out.println("Player 1 mana: " + p1.mana);
        //3-now we play the turns
                
        in.close();
    }
    
    public void playTurn()
    {
        if(!isGameOver())
            playP1();
        if(!isGameOver())
            playP2();

    }

    private void playCard(Player p, Player e, int pCardChoice, char pPlayedCardType) 
    {
        System.out.println(p.toStringForPlayer());
        pPlayedCard = p.playerHand.getThisHand().get(pCardChoice);
        // System.out.println("DEBUG HERE!!!");
        p.playerHand.removeCard(pPlayedCard);
        p.playerHand.putRandomCardIntoHand(p.getInstrumentName());
        p.mana = p.mana - pPlayedCard.getMana();
        if(p.mana < 3)
            p.mana = 3;
        if(pPlayedCardType == 'a') //attack card
        {
            //if enemy has shield, attack that first
            if(e.getShield() <= 0)
                e.updateHealth(((Attack_Card)pPlayedCard).getAttackAmount());
            else    //meaning some/full shield
            {
                if(e.getShield() >= ((Attack_Card)pPlayedCard).getAttackAmount())       // can absorb full damage
                    e.updateShield(((Attack_Card)pPlayedCard).getAttackAmount());
                else    //cannot absorb full damage (shield < attack)
                {
                    e.updateHealth(((Attack_Card)pPlayedCard).getAttackAmount() - e.getShield());
                    e.updateShield(e.getShield());
                }
            }
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

    public boolean playP1() 
    {
        //3.1-p1 plays card
            //3.1.1-p1 chooses which card to play from his hand 
        System.out.println("Which card do you want to play? [0,1,2,3]");
        // 3.1.2-Take user card choice
        // p1CardChoice = in.nextInt();
        // p1CardChoice = 1;       //take 1 as example
        char p1PlayedCardType = p1.playerHand.getThisHand().get(p1CardChoice).getType();
        System.out.println(p1.toStringForPlayer());
        System.out.println("Chosen card: " + p1.playerHand.getThisHand().get(p1CardChoice).toString());
        // System.out.println("DEBUG HERE");
        //3.1.3-can the card be played? i.e. is there enough mana
        if(p1.getMana() >= p1.playerHand.getThisHand().get(p1CardChoice).getMana())
        {
        //invalid choice, so need to ask user to reinput their card choice
        //3.1.4-play this card
            playCard(p1, p2, p1CardChoice, p1PlayedCardType);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean playP2() 
    {
        //3.1-p1 plays card
            //3.1.1-p1 chooses which card to play from his hand 
            System.out.println("Which card do you want to play? [0,1,2,3]");
            // System.out.println(p2.toStringForPlayer());
            System.out.println("Chosen card: " + p2.playerHand.getThisHand().get(p2CardChoice).toString());
            // 3.1.2-Take user card choice
                // p1CardChoice = in.nextInt();
            // p2CardChoice = 1;       //take 1 as example
            //3.1.2-play this card
            System.out.println(p2.toStringForPlayer());
            char p2PlayedCardType = p2.playerHand.getThisHand().get(p2CardChoice).getType();
            if(p2.getMana() >= p2.playerHand.getThisHand().get(p1CardChoice).getMana())
            {
            //invalid choice, so need to ask user to reinput their card choice
            //3.1.4-play this card
                playCard(p2, p1, p2CardChoice, p2PlayedCardType);
                return true;
            }
            else
            {
                // Notification notEnoughMana = Notification.show("Not enough mana!");
                // notEnoughMana.addThemeVariants(NotificationVariant.LUMO_ERROR);
                return false;
            }
    
    }

    public boolean isGameOver()
    {
        return (p1.getHealth() <= 0 || p2.getHealth() <= 0);
    }
    public static void main(String[] args) 
    {

    }
}
