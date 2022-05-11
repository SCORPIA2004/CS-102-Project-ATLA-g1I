package com.example.application.views.list;

import javax.validation.constraints.Size;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;

@PageTitle("ATLA | Main Menu")
@Route(value = "")
public class MainMenu extends Horizontal implements RouterLayout {

    public MainMenu() {
        addClassName("menu");
        setSizeFull();

        Image img = new Image("images/atla.png", "Atla");

        Button login = new Button("Login");
        login.setWidth("150px");
        login.addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
        login.addClickListener(e -> UI.getCurrent().navigate(LoginView.class));

        Button play = new Button("Play");
        play.addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
        play.setWidth("150px");
        play.addClickListener(e -> UI.getCurrent().navigate(Lobby.class));
        
        Button tutorial = new Button("How to Play");
        tutorial.setWidth("150px");
        tutorial.addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
        tutorial.addClickListener(e -> UI.getCurrent().navigate(Tutorial.class));
        
        Button leaderboard = new Button("Leaderboard");
        leaderboard.addClickListener(e -> UI.getCurrent().navigate(Leaderboard.class));
        leaderboard.setWidth("150px");
        leaderboard.addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);

        Image avatar = new Image("images/avatar.png", "Profile");
        avatar.setWidth("35px");
        
        Button avatarButton = new Button(avatar);
        avatarButton.addThemeVariants(ButtonVariant.LUMO_ICON);
        avatar.addClickListener(e -> UI.getCurrent().navigate(UserProfile.class));

        VerticalLayout a = new VerticalLayout();
        a.setSizeFull();
        a.add(img, login, play, tutorial, leaderboard);
        a.setAlignItems(Alignment.CENTER);
        a.setJustifyContentMode(JustifyContentMode.CENTER);

        add(avatarButton, a);
        setAlignSelf(Alignment.END, avatarButton);
        setSpacing(false);
    }
}
