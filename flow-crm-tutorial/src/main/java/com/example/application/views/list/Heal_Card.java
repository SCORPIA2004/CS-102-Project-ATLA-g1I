package com.example.application.views.list;

public class Heal_Card extends Card
{
    public int healAmount;
    // private Instrument instrument;
    private int id;
    private int mana;
    private char typeOfCard;                          // A(Attack); S(Shield); H(Heal)
    private String soundName;

    // manna
    // Instrument type
    // 
    public Heal_Card(/*Instrument i,*/ int i, char t, int m, int amount)
    {
        super(i);
        this.id = i;
        // this.instrument = i;
        this.typeOfCard = t;
        this.mana = m;
        this.healAmount = amount;
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

    public int getHealAmount()
    {
        return healAmount;
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
        return getId() + " | Heal | Amount: " + getHealAmount() + " | Manna: " + getMana();
    }

}
