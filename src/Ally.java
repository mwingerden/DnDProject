public class Ally extends Character {
    int charLevel;
    String charBackground;

    public Ally(String charName, String charClass, String charRace, String charAlignment, int charArmorClass,
                int charHitPoints, int charSpeed, int charStrength, int charDexterity, int charConstitution,
                int charIntelligence, int charWisdom, int charCharisma, int charLevel, String charBackground) {
        super(charName, charClass, charRace, charAlignment, charArmorClass, charHitPoints, charSpeed, charStrength,
                charDexterity, charConstitution, charIntelligence, charWisdom, charCharisma);
        this.charLevel = charLevel;
        this.charBackground = charBackground;
    }
}
