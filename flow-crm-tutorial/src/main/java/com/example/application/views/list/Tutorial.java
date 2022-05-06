package com.example.application.views.list;

import javax.validation.constraints.Size;

import com.vaadin.flow.component.Component;
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

@PageTitle("ATLA | How To Play")
@Route(value = "tutorial")

public class Tutorial extends VerticalLayout {

    public Tutorial() {
        Image img = new Image("src/main/resources/META-INF/resources/images/tutorial.png", "How To Play");
        
        
        add("Hello World!");
        
    }
}

