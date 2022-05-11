package com.example.application.views.list;

import java.io.File;
import javax.validation.constraints.Size;
import com.brownie.videojs.VideoJS;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.charts.model.Background;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.map.configuration.source.Source;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.theme.lumo.Lumo;

import org.atmosphere.interceptor.AtmosphereResourceStateRecovery.B;
import org.springframework.core.io.FileUrlResource;

@PageTitle("ATLA | Game Lobby")
@Route(value = "Lobby")

public class Lobby extends VerticalLayout implements GameObject{

    private int volume;

    public Lobby() {
        volume = 100;
        addClassName("lobby");
        setSizeFull();
        UI.getCurrent().getElement().getThemeList().add(Lumo.DARK);
        
        Image home = new Image("images/home.png", "Home button");
        home.setWidth("30px");
        Button homeBut = new Button(home);
        homeBut.addClickListener(e -> UI.getCurrent().navigate(MainMenu.class));

        Image lobby = new Image("images/lobby.png", "Lobby");
        lobby.setHeight("70px");
        
        VerticalLayout a = new VerticalLayout();
        a.add(homeBut, lobby);
        a.setAlignItems(Alignment.CENTER);
        a.setAlignSelf(Alignment.END, homeBut);

        VerticalLayout left = new VerticalLayout();
        VerticalLayout right = new VerticalLayout();

        H2 bg = new H2("Background:");
        
        HorizontalLayout buttons = new HorizontalLayout();
        Image red = new Image("images/red.png", "red");
        red.setHeight("50px");
        Button redBut = new Button(red);
        redBut.addClickListener(e -> {
            setBg("red");
            Notification changed = Notification.show("Background set to red!");
            changed.addThemeVariants(NotificationVariant.LUMO_ERROR);
        });
        Image green = new Image("images/green.png", "green");
        green.setHeight("50px");
        Button greenBut = new Button(green);
        greenBut.addClickListener(e -> {
            setBg("green");
            Notification changed = Notification.show("Background set to green!");
            changed.addThemeVariants(NotificationVariant.LUMO_ERROR);
        });
        Image orange = new Image("images/orange.png", "orange");
        orange.setHeight("50px");
        Button orangeBut = new Button(orange);
        orangeBut.addClickListener(e -> {
            setBg("orange");
            Notification changed = Notification.show("Background set to orange!");
            changed.addThemeVariants(NotificationVariant.LUMO_ERROR);
        });
        Image pink = new Image("images/pink.png", "pink");
        pink.setHeight("50px");
        Button pinkBut = new Button(pink);
        pinkBut.addClickListener(e -> {
            setBg("pink");
            Notification changed = Notification.show("Background set to pink!");
            changed.addThemeVariants(NotificationVariant.LUMO_ERROR);
        });

        buttons.add(redBut, greenBut, orangeBut, pinkBut);

        HorizontalLayout mute = new HorizontalLayout();
        H2 muteTxt = new H2("Background Music");
        Checkbox muted = new Checkbox();
        muted.addValueChangeListener(e -> {
            if (getVolume() == 0) {
                unMute();
            } else {
                mute();
            }
        });

        mute.add(muteTxt, muted);
        mute.setAlignSelf(Alignment.CENTER, muted);
        mute.setAlignSelf(Alignment.CENTER, muteTxt);

// ---------------- VOLUME CONTROL HERE ---------------- //
        HorizontalLayout volume = new HorizontalLayout();
        H2 vol = new H2("Volume: ");
        Image plus = new Image("images/plus.png", "plus");
        plus.setHeight("50px");
        Button plusBut = new Button(plus);
        plusBut.addClickListener(e -> {
            incrementVolume();
            Notification newVol = Notification.show("Volume: " + getVolume());
            newVol.addThemeVariants(NotificationVariant.LUMO_ERROR);
        });
        Image minus = new Image("images/minus.png", "minus");
        minus.setHeight("50px");
        Button minusBut = new Button(minus);
        minusBut.addClickListener(e -> {
            decrementVolume();
            Notification newVol = Notification.show("Volume: " + getVolume());
            newVol.addThemeVariants(NotificationVariant.LUMO_ERROR);
        });

        volume.add(vol, minusBut, plusBut);
        volume.setAlignItems(Alignment.END);

        left.add(bg, buttons, mute, volume);

        left.setJustifyContentMode(JustifyContentMode.BETWEEN);
        right.setAlignItems(Alignment.CENTER);
        right.setJustifyContentMode(JustifyContentMode.CENTER);


// ---------------- START GAME HERE ---------------- //
        Button start = new Button("Start");
        start.addThemeVariants(ButtonVariant.LUMO_ERROR, ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_PRIMARY);
        start.setWidth("200px");

        //STARTS WITH P1's turn --> go to ArenaP1Played class    
        start.addClickListener(e ->
        {
            initialisedAllPlayerStats();
            UI.getCurrent().navigate(ArenaP1Turn.class);
        }
        );

        H2 p1 = new H2(getP1());
        H2 p2 = new H2(getP2());

        right.add(start, p1, p2);

        HorizontalLayout b = new HorizontalLayout();
        b.add(left, right);
        b.setSizeFull();

        add(a, b);

    }

    private void initialisedAllPlayerStats() 
    {
        player1.health = initialHealth;
        player1.shield = initialShield;
        player1.mana = initialMana;
        player2.health = initialHealth;
        player2.shield = initialShield;
        player2.mana = initialMana;
    }

    private String getP2() {
        return "Player 2";
    }

    private String getP1() {
        return "Player 1";
    }

    private void setVolume(int e) {
        volume = e;
    }

    private void incrementVolume()
    {
        if(volume < 100)
            volume = volume + 5;
    }

    private void decrementVolume()
    {
        if(volume > 0)
            volume = volume - 5;
    }

    private void mute() {
       volume = 0; 
    }

    private void unMute() {
        volume = 100;
    }

    private int getVolume() {
        return volume;
    }

    private void setBg(String bg) {
        bgForTheGame.setBgColor(bg);
    }
}

