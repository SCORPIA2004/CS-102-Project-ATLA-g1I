public class Shield_Card extends Card
{
    public int attackDmg;
    // private Instrument instrument;
    private int id;
    private int mana;
    private char typeOfCard;                          // A(Attack); S(Shield); H(Heal)
    private String soundName;

    // manna
    // Instrument type
    // 
    public Shield_Card(Instrument i, char t, int m, int dmg)
    {
        this.instrument = i;
        this.typeOfCard = t;
        this.mana = m;
        this.attackDmg = dmg;
    }

    public Intrument getInstrument()
    {
        return this.instrument;
    }

    public String getSoundName()
    {
        // "Instrument_TypeOfCard_id"
        String str = "" + this.instrument.getName() + "_" + this.typeOfCard + "_" + this.id;
        return str;
    }

    public void dealDamage()
    {
        
    }
}
