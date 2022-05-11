package com.example.application.views.list;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Receiver;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;

@PageTitle("ATLA | User Profile")
@Route(value = "UserProfile")

public class UserProfile extends VerticalLayout {

    public UserProfile() {
        addClassName("profile");
        setSizeFull();

        UI.getCurrent().getElement().getThemeList().add(Lumo.DARK);
        
        HorizontalLayout a = new HorizontalLayout();

        Image home = new Image("images/home.png", "Home button");
        home.setWidth("30px");
        Button homeBut = new Button(home);
        homeBut.addClickListener(e -> UI.getCurrent().navigate(MainMenu.class));

        Image p1 = new Image("images/player1.png", "Player 1");
        p1.setHeight("70px");
        
        Image right = new Image("images/right.png", "next player");
        right.setWidth("30px");
        Button rightBut = new Button(right);
        rightBut.addClickListener(e -> UI.getCurrent().navigate(UserProfile2.class));

        a.add(homeBut, p1, rightBut);
        a.setJustifyContentMode(JustifyContentMode.BETWEEN);
        a.setSizeFull();

        VerticalLayout left = new VerticalLayout();
        VerticalLayout mid = new VerticalLayout();
        VerticalLayout rigt = new VerticalLayout();

        H2 gamesPlayed = new H2("Games Played: 5" /*+ getGamesPlayed()*/);
        gamesPlayed.getElement().setProperty("color", "white");
        H2 gamesWon = new H2("Games Won: 3" /*+ getGamesWon()*/);
        gamesWon.getElement().setProperty("color", "white");
        H2 masteryLevel = new H2("Mastery Level: 1" /*+ getMasteryLvl()*/);
        masteryLevel.getElement().setProperty("color", "white");
        H2 favInstrument = new H2("Favourite Instrument: Piano" /*+ getFavInstrument()*/);
        favInstrument.getElement().setProperty("color", "white");
        H2 rank = new H2("Rank: 2" /*+ getRank()*/);
        rank.getElement().setProperty("color", "white");

        Image pfp = new Image("images/default.jpg", "profile picture"); //Change to pfp = getPfp();
        pfp.setWidth("300px");
        Button changePfp = new Button("Change Picture");
        changePfp.addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
        
        Receiver receive = new Receiver() {

            @Override
            public OutputStream receiveUpload(String arg0, String arg1) {
                File file;
                
                FileOutputStream hi = null;
                try {
                    file = new File("/tmp/uploads/" + arg0);
                    hi = new FileOutputStream(file);
                } catch (final java.io.FileNotFoundException e) {
                    new Notification("Couldn't open the file");
                    return null;
                }
                
                setPfp(file);
                return hi;

            }
            
        };
        
        Upload uploadPfp = new Upload(receive);

        left.add(gamesPlayed, gamesWon, masteryLevel);
        left.setAlignItems(Alignment.START);
        mid.add(favInstrument, rank);
        mid.setAlignItems(Alignment.START);
        rigt.add(pfp, uploadPfp);
        rigt.setAlignItems(Alignment.CENTER);

        HorizontalLayout b = new HorizontalLayout();
        b.setSizeFull();
        b.add(left, mid, rigt);
        add(a, b);
    }

    protected void setPfp(File file) {
    }

    private Image getPfp() {
        return null;
    }

    private int getRank() {
        return 0;
    }

    private String getFavInstrument() {
        return null;
    }

    private String getMasteryLvl() {
        return null;
    }

    private int getGamesWon() {
        return 0;
    }

    private int getGamesPlayed() {
        return 0;
    }
}

