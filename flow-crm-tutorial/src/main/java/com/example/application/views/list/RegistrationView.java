package com.example.application.views.list;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("register")
public class RegistrationView extends VerticalLayout {

   public RegistrationView() {
    setSizeFull();
    addClassName("menu");
    UI.getCurrent().getElement().getThemeList().add(Lumo.DARK);
       RegistrationForm registrationForm = new RegistrationForm();
       // Center the RegistrationForm
       setHorizontalComponentAlignment(Alignment.CENTER, registrationForm);

       add(registrationForm);

   }
}