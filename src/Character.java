public abstract class Character implements SavingThrows, SkillCheck{
    String charName;
    String charClass;
    String charRace;
    String charAlignment;
    int charArmorClass;
    int charHitPoints;
    int charTempHitPoints;
    int charSpeed;
    int charStrength;
    int charDexterity;
    int charConstitution;
    int charIntelligence;
    int charWisdom;
    int charCharisma;

    public Character(String charName, String charClass, String charRace, String charAlignment, int charArmorClass,
                 int charHitPoints, int charSpeed, int charStrength, int charDexterity, int charConstitution,
                 int charIntelligence, int charWisdom, int charCharisma) {
        this.charName = charName;
        this.charClass = charClass;
        this.charRace = charRace;
        this.charAlignment = charAlignment;
        this.charArmorClass = charArmorClass;
        this.charHitPoints = charHitPoints;
        this.charTempHitPoints = 0;
        this.charSpeed = charSpeed;
        this.charStrength = charStrength;
        this.charDexterity = charDexterity;
        this.charConstitution = charConstitution;
        this.charIntelligence = charIntelligence;
        this.charWisdom = charWisdom;
        this.charCharisma = charCharisma;
    }

    int StrengthBonus(){
        return (charStrength - 10) / 2;
    }

    int DexterityBonus(){
        return (charDexterity - 10) / 2;
    }

    int ConstitutionBonus(){
        return (charConstitution - 10) / 2;
    }

    int IntelligenceBonus(){
        return (charIntelligence - 10) / 2;
    }

    int WisdomBonus(){
        return (charWisdom - 10) / 2;
    }

    int CharismaBonus(){
        return (charCharisma - 10) / 2;
    }@Override
    public int SavingThrowStrength() {
        return StrengthBonus();
    }

    @Override
    public int SavingThrowDexterity() {
        return DexterityBonus();
    }

    @Override
    public int SavingThrowConstitution() {
        return ConstitutionBonus();
    }

    @Override
    public int SavingThrowIntelligence() {
        return IntelligenceBonus();
    }

    @Override
    public int SavingThrowWisdom() {
        return WisdomBonus();
    }

    @Override
    public int SavingThrowCharisma() {
        return CharismaBonus();
    }

    @Override
    public int SkillCheckAcrobatics() {
        return DexterityBonus();
    }

    @Override
    public int SkillCheckAnimalHandling() {
        return WisdomBonus();
    }

    @Override
    public int SkillCheckArcana() {
        return IntelligenceBonus();
    }

    @Override
    public int SkillCheckAthletics() {
        return StrengthBonus();
    }

    @Override
    public int SkillCheckDeception() {
        return CharismaBonus();
    }

    @Override
    public int SkillCheckHistory() {
        return IntelligenceBonus();
    }

    @Override
    public int SkillCheckInsight() {
        return WisdomBonus();
    }

    @Override
    public int SkillCheckIntimidation() {
        return CharismaBonus();
    }

    @Override
    public int SkillCheckInvestigation() {
        return IntelligenceBonus();
    }

    @Override
    public int SkillCheckMedicine() {
        return WisdomBonus();
    }

    @Override
    public int SkillCheckNature() {
        return IntelligenceBonus();
    }

    @Override
    public int SkillCheckPerception() {
        return WisdomBonus();
    }

    @Override
    public int SkillCheckPerformance() {
        return CharismaBonus();
    }

    @Override
    public int SkillCheckPersuasion() {
        return CharismaBonus();
    }

    @Override
    public int SkillCheckReligion() {
        return IntelligenceBonus();
    }

    @Override
    public int SkillCheckSleightOfHand() {
        return DexterityBonus();
    }

    @Override
    public int SkillCheckStealth() {
        return DexterityBonus();
    }

    @Override
    public int SkillCheckSurvival() {
        return WisdomBonus();
    }
}
