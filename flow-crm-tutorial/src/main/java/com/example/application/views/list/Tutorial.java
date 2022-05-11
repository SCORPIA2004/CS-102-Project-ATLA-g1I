package com.example.application.views.list;

import java.io.File;

import com.brownie.videojs.VideoJS;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("ATLA | How To Play")
@Route(value = "How To Play")

public class Tutorial extends VerticalLayout {

    public Tutorial() {
        addClassName("tutorial");
        setSizeFull();
        
        File video = new File("src/main/resources/META-INF/resources/images/video.mp4");
        File image = new File("src/main/resources/META-INF/resources/images/banner.png");

        VideoJS tutVid = new VideoJS(UI.getCurrent().getSession(), video, image);
        tutVid.setWidth("700px");

        Image home = new Image("images/home.png", "Home button");
        home.setWidth("30px");
        Button homeBut = new Button(home);
        homeBut.addClickListener(e -> UI.getCurrent().navigate(MainMenu.class));
        
        Image tut = new Image("images/tutorial.png", "How To Play");
        tut.setHeight("70px");

        //a.setWidthFull();
        
        //a.setJustifyContentMode(JustifyContentMode.END);
        //a.add(tut, homeBut);

        add(homeBut, tut, tutVid);  
        setAlignItems(Alignment.CENTER);
        setAlignSelf(Alignment.END, homeBut);   
    }
}

