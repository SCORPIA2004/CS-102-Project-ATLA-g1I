//THIS is next step after lobby
package com.example.application.views.list;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;


@PageTitle("ATLA")
@Route(value = "ArenaP1Turn")

public class ArenaP1Turn extends VerticalLayout implements GameObject{
    public boolean successfulCardPlay;
    public ArenaP1Turn() {
        gameArena.p1.getPlayerHand().toStringHand();

// ---------------- BACKGROUND HERE ---------------- //
        if (getBgColor().equals("red")) {
            addClassName("arenaP1TurnRed");
        } else if (getBgColor().equals("green")) {
            addClassName("arenaP1TurnGreen");
        } else if (getBgColor().equals("orange")) {
            addClassName("arenaP1TurnOrange");
        } else {
            addClassName("arenaP1TurnPink");
        }

        UI.getCurrent().getElement().getThemeList().add(Lumo.DARK);
        setSizeFull();

// ---------------- Creating Player 1 HERE ---------------- //
        HorizontalLayout p2 = new HorizontalLayout();
        HorizontalLayout empty = new HorizontalLayout();
        HorizontalLayout empty2 = new HorizontalLayout();
        HorizontalLayout p1 = new HorizontalLayout();

        VerticalLayout p2Stats = new VerticalLayout();
        p2Stats.setWidth("150px");

        HorizontalLayout p2Hp = new HorizontalLayout();
        Image hp = new Image("images/blood.png", "hp");
        hp.setWidth("30px");
        hp.setHeight("30px");
        Text p2Health = new Text("" + getP2Health());
        p2Hp.add(hp, p2Health);
        p2Hp.setAlignItems(Alignment.CENTER);

        HorizontalLayout p2Shield = new HorizontalLayout();
        Image shield = new Image("images/shield.png", "shield");
        shield.setWidth("30px");
        shield.setHeight("30px");
        Text p2Shieldd = new Text("" + getP2Shield());
        p2Shield.add(shield, p2Shieldd);
        p2Shield.setAlignItems(Alignment.CENTER);

        HorizontalLayout p2Mana = new HorizontalLayout();
        Image mana = new Image("images/mana.png", "mana");
        mana.setWidth("30px");
        mana.setHeight("30px");
        Text p2Manna = new Text("" + getP2Mana());
        p2Mana.add(mana, p2Manna);
        p2Mana.setAlignItems(Alignment.CENTER);

        p2Stats.add(p2Hp, p2Shield, p2Mana);

        Image cardBack = new Image("images/cardback.png", "back of card");
        cardBack.setHeight("150px");

        HorizontalLayout p2Profile = new HorizontalLayout();

        H2 p2Name = new H2(getP2Username());
        Image p2Pfp = new Image("images/mdefault.png", "pfp"); //Change to getP2Pfp();
        p2Pfp.setHeight("100px");
        
        p2Profile.setAlignItems(Alignment.CENTER);
        p2Profile.add(p2Name, p2Pfp);
        p2Profile.setJustifyContentMode(JustifyContentMode.CENTER);


        p2.add(p2Stats, cardBack, p2Profile);
        p2.setWidthFull();
        p2.setJustifyContentMode(JustifyContentMode.AROUND);


        Image p2Instrument = new Image("images/" + gameArena.p2.getInstrumentName() +  ".png", gameArena.p2.getInstrumentName()); //replace with getP2Instrument();
        p2Instrument.setHeight("120px");
        empty.add(p2Instrument);
        empty.setAlignItems(Alignment.CENTER);
        empty.setJustifyContentMode(JustifyContentMode.START);
        empty.setWidthFull();

// ---------------- Creating Player 2 HERE ---------------- //

        Image p1Instrument = new Image("images/" + gameArena.p1.getInstrumentName() +  ".png", gameArena.p1.getInstrumentName()); //replace with getP1Instrument();
        p1Instrument.setHeight("120px");
        empty2.add(p1Instrument);
        empty2.setAlignItems(Alignment.CENTER);
        empty2.setJustifyContentMode(JustifyContentMode.END);
        empty2.setWidthFull();


        HorizontalLayout p1Profile = new HorizontalLayout();
        H2 p1Name = new H2(getP1Username());
        Image p1Pfp = new Image("images/default.jpg", "pfp"); //Change to getP1Pfp();
        p1Pfp.setHeight("100px");
        p1Profile.setAlignItems(Alignment.CENTER);
        p1Profile.add(p1Pfp, p1Name);
        p1Profile.setJustifyContentMode(JustifyContentMode.CENTER);



        VerticalLayout p1Stats = new VerticalLayout();
        p1Stats.setWidth("150px");

        HorizontalLayout p1Hp = new HorizontalLayout();
        Image hp2 = new Image("images/blood2.png", "hp");
        hp2.setHeight("30px");
        hp2.setWidth("30px");
        Text p1Health = new Text("" + getP1Health());
        p1Hp.add(hp2, p1Health);
        p1Hp.setAlignItems(Alignment.CENTER);

        HorizontalLayout p1Shield = new HorizontalLayout();
        Image shield2 = new Image("images/shield2.png", "shiled");
        shield2.setWidth("30px");
        shield2.setHeight("30px");
        Text p1Shieldd = new Text("" + getP1Shield());
        p1Shield.add(shield2, p1Shieldd);
        p1Shield.setAlignItems(Alignment.CENTER);

        HorizontalLayout p1Mana = new HorizontalLayout();
        Image mana2 = new Image("images/mana2.png", "mana");
        mana2.setWidth("30px");
        mana2.setHeight("30px");
        Text p1Manna = new Text("" + getP1Mana());
        p1Mana.add(mana2, p1Manna);
        p1Mana.setAlignItems(Alignment.CENTER);

        p1Stats.add(p1Hp, p1Shield, p1Mana);

        HorizontalLayout p1Cards = new HorizontalLayout();

// ---------------- TURN OF PLAYER 1 HERE ---------------- //
      
// ---------------- We can choose any card but we go to the card HERE ---------------- //
        successfulCardPlay = false;
        
        //card 1
        Image card1 = new Image("images/" + player1.getPlayerHand().getThisHand().get(0).getId() + ".png", "card_1"); //replace with p1GetCard1();
        card1.setHeight("150px");
        Button card1But = new Button(card1);
        card1But.addClickListener(e -> {
            gameArena.p1CardChoice = 0;
            // playP1Turn();
            successfulCardPlay = gameArena.playP1();
            if (successfulCardPlay) 
            {
                UI.getCurrent().navigate(ArenaP1Played.class);
            }
            else 
            {
                Notification notEnoughMana = Notification.show("Not enough mana!");
                notEnoughMana.addThemeVariants(NotificationVariant.LUMO_ERROR);
            }
        });

        //card 2
        Image card2 = new Image("images/" + player1.getPlayerHand().getThisHand().get(1).getId() + ".png", "card_2"); // replace with p1GetCard2();
        card2.setHeight("150px");
        Button card2But = new Button(card2);
        card2But.addClickListener(e -> {
            gameArena.p1CardChoice = 1;
            successfulCardPlay = gameArena.playP1();
            if (successfulCardPlay) 
            {
                UI.getCurrent().navigate(ArenaP1Played.class);
            }
            else 
            {
                Notification notEnoughMana = Notification.show("Not enough mana!");
                notEnoughMana.addThemeVariants(NotificationVariant.LUMO_ERROR);
            }
        });

        //card 3
        Image card3 = new Image("images/" + player1.getPlayerHand().getThisHand().get(2).getId() + ".png", "card_3"); // replace with p1GetCard3();
        card3.setHeight("150px");
        Button card3But = new Button(card3);
        card3But.addClickListener(e -> {
            gameArena.p1CardChoice = 2;
            successfulCardPlay = gameArena.playP1();
            if (successfulCardPlay) 
            {
                UI.getCurrent().navigate(ArenaP1Played.class);
            }
            else 
            {
                Notification notEnoughMana = Notification.show("Not enough mana!");
                notEnoughMana.addThemeVariants(NotificationVariant.LUMO_ERROR);
            }
        });

        //card4
        Image card4 = new Image("images/" + player1.getPlayerHand().getThisHand().get(3).getId() + ".png", "card_4");// replace with p1GetCard4();
        card4.setHeight("150px");
        Button card4But = new Button(card4);
        card4But.addClickListener(e -> {
            gameArena.p1CardChoice = 3;
            successfulCardPlay = gameArena.playP1();
            if (successfulCardPlay) 
            {
                UI.getCurrent().navigate(ArenaP1Played.class);
            }
            else 
            {
                Notification notEnoughMana = Notification.show("Not enough mana!");
                notEnoughMana.addThemeVariants(NotificationVariant.LUMO_ERROR);
            }
        });
        p1Cards.add(card1But, card2But, card3But, card4But);
        p1Cards.setAlignItems(Alignment.END);



        p1.add(p1Profile, p1Cards, p1Stats);
        p1.setWidthFull();
        p1.setJustifyContentMode(JustifyContentMode.AROUND);
        p1.setAlignSelf(Alignment.CENTER, p1Cards);

        add(p2, empty, empty2, p1);
        setJustifyContentMode(JustifyContentMode.EVENLY);
    }
        {
    // public class ArenaP1Played extends VerticalLayout {
    
    //     //For now I'll put PIANO for player1
    //     //                 DRUM for player2
    //     Player player1 = new Player("piano");
    //     Player player2 = new Player("drum");
    
    //     //now I make the gameArena which will stay constant
    //     // I'll pass it to the next arena too
    //     Arena gameArena = new Arena(player1, player2);
        
    
    //     public ArenaP1Played() {
    
    // // ---------------- BACKGROUND HERE ---------------- //
    
    //         if (getBgColor().equals("red")) {addClassName("arenaP1TurnRed");}
    //         else if (getBgColor().equals("green")) {addClassName("arenaP1TurnGreen");}
    //         else if (getBgColor().equals("orange")) {addClassName("arenaP1TurnOrange");} 
    //         else {addClassName("arenaP1TurnPink");}
    
    //         UI.getCurrent().getElement().getThemeList().add(Lumo.DARK);
    //         setSizeFull();
    
    // // ---------------- Making player 2 HERE ---------------- //
    //         HorizontalLayout p2 = new HorizontalLayout();
    //         HorizontalLayout empty = new HorizontalLayout();
    //         HorizontalLayout empty2 = new HorizontalLayout();
    //         HorizontalLayout p1 = new HorizontalLayout();
    
    //         VerticalLayout p2Stats = new VerticalLayout();
    //         p2Stats.setWidth("150px");
    
    //         HorizontalLayout p2Hp = new HorizontalLayout();
    //         Image hp = new Image("images/blood.png", "hp");
    //         hp.setWidth("30px");
    //         hp.setHeight("30px");
    //         Text p2Health = new Text("" + getP2Health());
    //         p2Hp.add(hp, p2Health);
    //         p2Hp.setAlignItems(Alignment.CENTER);
    
    //         HorizontalLayout p2Shield = new HorizontalLayout();
    //         Image shield = new Image("images/shield.png", "shield");
    //         shield.setWidth("30px");
    //         shield.setHeight("30px");
    //         Text p2Shieldd = new Text("" + getP2Shield());
    //         p2Shield.add(shield, p2Shieldd);
    //         p2Shield.setAlignItems(Alignment.CENTER);
    
    //         HorizontalLayout p2Mana = new HorizontalLayout();
    //         Image mana = new Image("images/mana.png", "mana");
    //         mana.setWidth("30px");
    //         mana.setHeight("30px");
    //         Text p2Manna = new Text("" + getP2Mana());
    //         p2Mana.add(mana, p2Manna);
    //         p2Mana.setAlignItems(Alignment.CENTER);
    
    //         p2Stats.add(p2Hp, p2Shield, p2Mana);
    
    // // ---------------- Making player 2 cards HERE ---------------- //
    //         Image cardBack = new Image("images/cardback.png", "back of card");
    //         cardBack.setHeight("150px");
    
    //         HorizontalLayout p2Profile = new HorizontalLayout();
    
    //         H2 p2Name = new H2(getP2Username());
    //         Image p2Pfp = new Image("images/default.jpg", "pfp"); //Change to getP2Pfp();
    //         p2Pfp.setHeight("100px");
            
    //         p2Profile.setAlignItems(Alignment.CENTER);
    //         p2Profile.add(p2Name, p2Pfp);
    //         p2Profile.setJustifyContentMode(JustifyContentMode.CENTER);
    
    
    //         p2.add(p2Stats, cardBack, p2Profile);
    //         p2.setWidthFull();
    //         p2.setJustifyContentMode(JustifyContentMode.AROUND);
    
    
    //         Image p2Instrument = new Image("images/" + gameArena.p2.getInstrumentName() +  ".png", gameArena.p2.getInstrumentName()); //replace with getP2Instrument();
    //         p2Instrument.setHeight("120px");
    
    // // ---------------- NEXT TURN OF PLAYER 2 HERE ---------------- //
    //         //THIS is the NEXT TURN
    //         // so for the first time, we will go pass this/
    //         Button nextTurn = new Button("End Turn");
    //         nextTurn.addClickListener(e -> {
    //             if (gameArena.isGameOver()) 
    //                 UI.getCurrent().navigate(ArenaGameOver.class);
    //             else
    //                 UI.getCurrent().navigate(ArenaP2Turn.class);
    //         });
    //         nextTurn.addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_CONTRAST, ButtonVariant.LUMO_PRIMARY);
    //         HorizontalLayout p2Turn = new HorizontalLayout();
    //         p2Turn.add(p2Instrument, nextTurn);
    //         p2Turn.setAlignItems(Alignment.CENTER);
    //         p2Turn.setWidth("950px");
    //         p2Turn.setJustifyContentMode(JustifyContentMode.AROUND);
    //         empty.add(p2Turn);
    //         empty.setAlignItems(Alignment.CENTER);
    //         empty.setJustifyContentMode(JustifyContentMode.START);
    //         empty.setWidthFull();
    
    // // ---------------- Making player 1 HERE ---------------- //
    //         Image p1Instrument = new Image("images/" + gameArena.p1.getInstrumentName() +  ".png", gameArena.p1.getInstrumentName()); //replace with getP1Instrument();
    //         p1Instrument.setHeight("120px");
    
    //         Image p1PlayedCard = new Image("images/card4.png", "played card"); //replace with getP1PlayedCard();
    //         p1PlayedCard.setHeight("120px");
    
    //         HorizontalLayout played = new HorizontalLayout();
    //         played.setWidth("800px");
    //         played.add(p1PlayedCard, p1Instrument);
    //         played.setJustifyContentMode(JustifyContentMode.AROUND);
    
    //         empty2.add(played);
    //         empty2.setAlignItems(Alignment.CENTER);
    //         empty2.setJustifyContentMode(JustifyContentMode.END);
    //         empty2.setWidthFull();
    
    //         HorizontalLayout p1Profile = new HorizontalLayout();
    //         H2 p1Name = new H2(getP1Username());
    //         Image p1Pfp = new Image("images/default.jpg", "pfp"); //Change to getP1Pfp();
    //         p1Pfp.setHeight("100px");
    //         p1Profile.setAlignItems(Alignment.CENTER);
    //         p1Profile.add(p1Pfp, p1Name);
    //         p1Profile.setJustifyContentMode(JustifyContentMode.CENTER);
    
    
    
    //         VerticalLayout p1Stats = new VerticalLayout();
    //         p1Stats.setWidth("150px");
    
    //         HorizontalLayout p1Hp = new HorizontalLayout();
    //         Image hp2 = new Image("images/blood2.png", "hp");
    //         hp2.setHeight("30px");
    //         hp2.setWidth("30px");
    //         Text p1Health = new Text("" + getP1Health());
    //         p1Hp.add(hp2, p1Health);
    //         p1Hp.setAlignItems(Alignment.CENTER);
    
    //         HorizontalLayout p1Shield = new HorizontalLayout();
    //         Image shield2 = new Image("images/shield2.png", "shiled");
    //         shield2.setWidth("30px");
    //         shield2.setHeight("30px");
    //         Text p1Shieldd = new Text("" + getP1Shield());
    //         p1Shield.add(shield2, p1Shieldd);
    //         p1Shield.setAlignItems(Alignment.CENTER);
    
    //         HorizontalLayout p1Mana = new HorizontalLayout();
    //         Image mana2 = new Image("images/mana2.png", "mana");
    //         mana2.setWidth("30px");
    //         mana2.setHeight("30px");
    //         Text p1Manna = new Text("" + getP1Mana());
    //         p1Mana.add(mana2, p1Manna);
    //         p1Mana.setAlignItems(Alignment.CENTER);
    
    //         p1Stats.add(p1Hp, p1Shield, p1Mana);
    
    
    
    
    //         HorizontalLayout p1Cards = new HorizontalLayout();
    //         Image card1 = new Image("images/card.png", "card"); //replace with p1GetUnplayedCard1();
    //         card1.setHeight("150px");
    //         Button card1But = new Button(card1);
    //         Image card2 = new Image("images/card2.png", "card"); // replace with p1GetUnplayedCard2();
    //         card2.setHeight("150px");
    //         Button card2But = new Button(card2);
    //         Image card3 = new Image("images/card3.png", "card"); // replace with p1GetUnplayedCard3();
    //         card3.setHeight("150px");
    //         Button card3But = new Button(card3);
    //         p1Cards.add(card1But, card2But, card3But);
    //         p1Cards.setAlignItems(Alignment.END);
    
    
    
    //         p1.add(p1Profile, p1Cards, p1Stats);
    //         p1.setWidthFull();
    //         p1.setJustifyContentMode(JustifyContentMode.AROUND);
    //         p1.setAlignSelf(Alignment.CENTER, p1Cards);
    
    //         add(p2, empty, empty2, p1);
    //         setJustifyContentMode(JustifyContentMode.EVENLY);
    //     }
    
    //     private Image p1GetUnplayedCard3() {
    //         return null;
    //     }
    
    //     private Image p1GetUnplayedCard2() {
    //         return null;
    //     }
    
    //     private Image p1GetUnplayedCard1() {
    //         return null;
    //     }
    
    //     private Image getP1PlayedCard() {
    //         return null;
    //     }
    
    //     private Image getP1Pfp() {
    //         return null;
    //     }
    
    //     private Image getP1Instrument() {
    //         return null;
    //     }
    
    //     private Image getP2Instrument() {
    //         return null;
    //     }
    
    //     private Image getP2Pfp() {
    //         return null;
    //     }
    
    //     private int getP1Mana() {
    //         return 0;
    //     }
    
    //     private int getP1Shield() {
    //         return 0;
    //     }
    
    //     private int getP1Health() {
    //         return 0;
    //     }
    
    //     private String getP1Username() {
    //         return "Player 1";
    //     }
    
    //     private String getP2Username() {
    //         return "Player 2";
    //     }
    
    //     private int getP2Mana() {
    //         return 0;
    //     }
    
    //     private int getP2Shield() {
    //         return 0;
    //     }
    
    //     private int getP2Health() {
    //         return 0;
    //     }
    
    //     private String getBgColor() {
    //         return "red";
    //     }
    // }    

    // // // // // // // private Object ArenaP1Played(Player player1, Player player2, Arena gameArena) {
    // // // // // // //     ArenaP1Played arenaP1Played1 = new ArenaP1Played( player1, player2, gameArena);
    // // // // // // //     return arenaP1Played1;
    // // // // // // // }
        }

    private void playP1Turn() {
    }

    private Image p1GetCard4() {
        return null;
    }
    
    private Image p1GetCard3() {
        return null;
    }
    
    private Image p1GetCard2() {
        return null;
    }
    
    private Image p1GetCard1() {
        return null;
    }

    private int getP1Mana() {
        return player1.getMana();
    }

    private int getP1Shield() {
        return player1.getShield();
    }

    private int getP1Health() {
        return player1.getHealth();
    }

    private String getP1Username() {
        return "Player 1";
    }

    private Image getP1Pfp() {
        return null;
    }

    private Image getP1Instrument() {
        return null;
    }

    private Image getP2Instrument() {
        return null;
    }

    private String getBgColor() {
        return bgForTheGame.bgColor;
    }

    private int getP2Mana() {
        return player2.getMana();
    }

    private int getP2Shield() {
        return player2.getShield();
    }

    private int getP2Health() {
        return player2.getHealth();
    }

    private String getP2Username() {
        return "Player 2";
    }

    private Image getP2Pfp() {
        return null;
    }
}
