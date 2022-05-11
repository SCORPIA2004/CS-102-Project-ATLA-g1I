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
@Route(value = "GameOver")

public class ArenaGameOver extends VerticalLayout implements GameObject{

    public ArenaGameOver() {
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


        Button over = new Button("Game Over! " + getWinner() + " wins. Press to go Home!");
        over.addClickListener(e -> UI.getCurrent().navigate(MainMenu.class));
        over.addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_CONTRAST, ButtonVariant.LUMO_PRIMARY);
        over.setHeight("100px");


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




        Image cardBack2 = new Image("images/cardback2.png", "cards turned over");
        cardBack2.setHeight("150px");



        p1.add(p1Profile, cardBack2, p1Stats);
        p1.setWidthFull();
        p1.setJustifyContentMode(JustifyContentMode.AROUND);
        p1.setAlignSelf(Alignment.CENTER, cardBack2);

        add(p2, over, p1);
        setAlignSelf(Alignment.CENTER, over);
        setJustifyContentMode(JustifyContentMode.AROUND);
    }

    private String getWinner() {
        if(gameArena.p1.getHealth() > 0)
            return "Player 1";
        else
            return "Player 2";
    }

    private int getP1Mana() {
        return 0;
    }

    private int getP1Shield() {
        return 0;
    }

    private int getP1Health() {
        return 0;
    }

    private String getP1Username() {
        return "Player 1";
    }

    private Image getP1Pfp() {
        return null;
    }

    private String getBgColor() {
        return bgForTheGame.bgColor;
    }

    private int getP2Mana() {
        return 0;
    }

    private int getP2Shield() {
        return 0;
    }

    private String getP2Username() {
        return "Player 2";
    }

    private int getP2Health() {
        return 0;
    }

    private Image getP2Pfp() {
        return null;
    }
}