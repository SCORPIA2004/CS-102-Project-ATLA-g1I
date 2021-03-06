package com.example.application.views.list;

public class Shield_Card extends Card
{
    public int shieldAmount;
    // private Instrument instrument;
    private int id;
    private int mana;
    private char typeOfCard;                          // A(Attack); S(Shield); H(Heal)
    private String soundName;

    // manna
    // Instrument type
    // 
    public Shield_Card(/*Instrument i,*/ int i, char t, int m, int amount)
    {
        super(i);
        this.id = i;
        // this.instrument = i;
        this.typeOfCard = t;
        this.mana = m;
        this.shieldAmount = amount;
    }

    // public Intrument getInstrument()
    // {
    //     return this.instrument;
    // }

    public String getSoundName()
    {
        // "Instrument_TypeOfCard_id"
        String str = "" /*+ this.instrument.getName()*/ + "_" + this.typeOfCard + "_" + this.id;
        return str;
    }

    public int getShieldAmount()
    {
        return shieldAmount;
    }
    public char getType()
    {
        return typeOfCard;
    }

    @Override
    public int getMana()
    {
        return mana;
    }
    
    @Override
    public String toString() {
        return getId() + " | Shield | Amount: " + getShieldAmount() + " | Manna: " + getMana();
    }

}

