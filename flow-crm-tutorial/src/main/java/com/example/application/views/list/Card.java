package com.example.application.views.list;

import java.awt.Image;

public abstract class Card{
    // variables

    Instrument instrument;
    private boolean visibility;
    private Image cardImage;
    private int id;

    public abstract char getType();
    //constructor
    public Card(int id)
    {
        setId(id);
    }

    public String getId()
    {
        return "" + id;
    }

    public abstract int getMana();

    public abstract String toString();

    //methods

    // public int getId(){
    //     return this.id;
    // }

    // public int getMana(){
    //     return this.mana;
    // }

    public boolean isVisible(){
        return this.visibility;
    }
  
    public void setId(int id){
        this.id = id;
    }

    public void setVisibility(boolean visibility){
        this.visibility = visibility;
    }

    public void setInstrument(Instrument instr){
        this.instrument = instr;
    }

    public void setCardImage(Image img){
        this.cardImage = img;
    }

}