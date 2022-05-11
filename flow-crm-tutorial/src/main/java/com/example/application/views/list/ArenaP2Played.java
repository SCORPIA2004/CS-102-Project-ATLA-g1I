package com.example.application.views.list;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;

@PageTitle("ATLA")
@Route(value = "ArenaP2Played")

public class ArenaP2Played extends VerticalLayout implements GameObject {
    
    public ArenaP2Played() {
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

        HorizontalLayout p2Cards = new HorizontalLayout();
        Image card1 = new Image("images/card.png", "card"); //replace with p2GetUnplayedCard1();
        card1.setHeight("150px");
        Button card1But = new Button(card1);
        Image card2 = new Image("images/card2.png", "card"); // replace with p2GetUnplayedCard2();
        card2.setHeight("150px");
        Button card2But = new Button(card2);
        Image card3 = new Image("images/card3.png", "card"); // replace with p2GetUnplayedCard3();
        card3.setHeight("150px");
        Button card3But = new Button(card3);
        p2Cards.add(card1But, card2But, card3But);

        p2Cards.setAlignItems(Alignment.END);

        p2.add(p2Stats, p2Cards, p2Profile);

        p2.setWidthFull();
        p2.setJustifyContentMode(JustifyContentMode.AROUND);
        p2.setAlignSelf(Alignment.CENTER, p2Cards);


        Image p2Instrument = new Image("images/" + gameArena.p2.getInstrumentName() +  ".png", gameArena.p2.getInstrumentName()); //replace with getP2Instrument();
        p2Instrument.setHeight("120px");
        Button nextTurn = new Button("End Turn");
        nextTurn.addClickListener(e -> {
            if (gameArena.isGameOver()) {
                UI.getCurrent().navigate(ArenaGameOver.class);
            }             
            else
            {
                gameArena.p2.setMana(getP2Mana() + 1);
                UI.getCurrent().navigate(ArenaP1Turn.class);
            }

        });

        Image p1PlayedCard = new Image("images/card4.png", "played card"); //replace with getP1PlayedCard();
        p1PlayedCard.setHeight("120px");
        nextTurn.addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_CONTRAST, ButtonVariant.LUMO_PRIMARY);

        HorizontalLayout p2Turn = new HorizontalLayout();
        p2Turn.add(p2Instrument, p1PlayedCard);

        p2Turn.setAlignItems(Alignment.CENTER);
        p2Turn.setWidth("950px");
        p2Turn.setJustifyContentMode(JustifyContentMode.AROUND);
        empty.add(p2Turn);

        empty.setAlignItems(Alignment.CENTER);
        empty.setJustifyContentMode(JustifyContentMode.START);
        empty.setWidthFull();


        Image p1Instrument = new Image("images/" + gameArena.p1.getInstrumentName() +  ".png", gameArena.p1.getInstrumentName()); //replace with getP1Instrument();
        p1Instrument.setHeight("120px");

        HorizontalLayout played = new HorizontalLayout();
        played.setWidth("800px");
        played.add(nextTurn, p1Instrument);

        played.setJustifyContentMode(JustifyContentMode.AROUND);

        empty2.add(played);

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




        p1.add(p1Profile, cardBack, p1Stats);

        p1.setWidthFull();
        p1.setJustifyContentMode(JustifyContentMode.AROUND);

        add(p2, empty, empty2, p1);

        setJustifyContentMode(JustifyContentMode.EVENLY);
    }

    private String getP2Username() {
        return "Player 2";
    }

    private boolean isGameOver() {
        return true;
    }

    private Image p2GetUnplayedCard3() {
        return null;
    }

    private Image p2GetUnplayedCard2() {
        return null;
    }

    private Image p2GetUnplayedCard1() {
        return null;
    }

    private Image getP2PlayedCard() {
        return null;
    }

    private Image getP2Pfp() {
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

    private int getP2Mana() {
        return player2.getMana();
    }

    private int getP2Shield() {
        return player2.getShield();
    }

    private int getP2Health() {
        return player2.getHealth();
    }

    private String getBgColor() {
        return bgForTheGame.bgColor;
    }
}
