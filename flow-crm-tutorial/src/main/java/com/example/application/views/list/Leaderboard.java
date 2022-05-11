package com.example.application.views.list;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;

@Route(value = "leaderbaord")
@PageTitle("Leaderboard")
public class Leaderboard extends VerticalLayout { 
    Grid<User> grid = new Grid<>(User.class); 
    TextField filterText = new TextField();

    public Leaderboard() {
        setSizeFull();
       addClassName("menu");
       UI.getCurrent().getElement().getThemeList().add(Lumo.DARK);
        // addClassName("list-view");
        setSizeFull();
        configureGrid(); 
        add(getToolbar(), grid); 
    }

    private void configureGrid() {
        grid.addClassNames("user-grid");
        grid.setSizeFull();
        grid.setColumns("username", "gamesPlayed", "favInstrument"); 
        grid.getColumns().forEach(col -> col.setAutoWidth(true)); 
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY); 

        Button home = new Button("Main Menu");
        home.setWidth("150px");
        home.addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
        home.addClickListener(e -> UI.getCurrent().navigate(MainMenu.class));

        HorizontalLayout toolbar = new HorizontalLayout(filterText, home); 
        toolbar.addClassName("toolbar");
        return toolbar;
    }
}