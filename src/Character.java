public abstract class Character implements SavingThrows, SkillCheck {
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
    Dice dice;

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
        this.dice = new Dice();
    }

    int StrengthBonus() {
        float value = (float) (charStrength - 10) / 2;
        if (value <= -0.1) {
            return ((charStrength - 10) / 2) - 1;
        } else {
            return (charStrength - 10) / 2;
        }
    }

    int DexterityBonus() {
        float value = (float) (charDexterity - 10) / 2;
        if (value <= -0.1) {
            return ((charDexterity - 10) / 2) - 1;
        } else {
            return (charDexterity - 10) / 2;
        }
    }

    int ConstitutionBonus() {

        float value = (float) (charConstitution - 10) / 2;
        if (value <= -0.1) {
            return ((charConstitution - 10) / 2) - 1;
        } else {
            return (charConstitution - 10) / 2;
        }
    }

    int IntelligenceBonus() {
        float value = (float) (charIntelligence - 10) / 2;
        if (value <= -0.1) {
            return ((charIntelligence - 10) / 2) - 1;
        } else {
            return (charIntelligence - 10) / 2;
        }
    }

    int WisdomBonus() {
        float value = (float) (charWisdom - 10) / 2;
        if (value <= -0.1) {
            return ((charWisdom - 10) / 2) - 1;
        } else {
            return (charWisdom - 10) / 2;
        }
    }

    int CharismaBonus() {
        float value = (float) (charCharisma - 10) / 2;
        if (value <= -0.1) {
            return ((charCharisma - 10) / 2) - 1;
        } else {
            return (charCharisma - 10) / 2;
        }
    }

    @Override
    public int SavingThrowStrength() {
        return StrengthBonus() + dice.dTwenty();
    }

    @Override
    public int SavingThrowDexterity() {
        return DexterityBonus() + dice.dTwenty();
    }

    @Override
    public int SavingThrowConstitution() {
        return ConstitutionBonus() + dice.dTwenty();
    }

    @Override
    public int SavingThrowIntelligence() {
        return IntelligenceBonus() + dice.dTwenty();
    }

    @Override
    public int SavingThrowWisdom() {
        return WisdomBonus() + dice.dTwenty();
    }

    @Override
    public int SavingThrowCharisma() {
        return CharismaBonus() + dice.dTwenty();
    }

    @Override
    public int SkillCheckAcrobatics() {
        return DexterityBonus() + dice.dTwenty();
    }

    @Override
    public int SkillCheckAnimalHandling() {
        return WisdomBonus() + dice.dTwenty();
    }

    @Override
    public int SkillCheckArcana() {
        return IntelligenceBonus() + dice.dTwenty();
    }

    @Override
    public int SkillCheckAthletics() {
        return StrengthBonus() + dice.dTwenty();
    }

    @Override
    public int SkillCheckDeception() {
        return CharismaBonus() + dice.dTwenty();
    }

    @Override
    public int SkillCheckHistory() {
        return IntelligenceBonus() + dice.dTwenty();
    }

    @Override
    public int SkillCheckInsight() {
        return WisdomBonus() + dice.dTwenty();
    }

    @Override
    public int SkillCheckIntimidation() {
        return CharismaBonus() + dice.dTwenty();
    }

    @Override
    public int SkillCheckInvestigation() {
        return IntelligenceBonus() + dice.dTwenty();
    }

    @Override
    public int SkillCheckMedicine() {
        return WisdomBonus() + dice.dTwenty();
    }

    @Override
    public int SkillCheckNature() {
        return IntelligenceBonus() + dice.dTwenty();
    }

    @Override
    public int SkillCheckPerception() {
        return WisdomBonus() + dice.dTwenty();
    }

    @Override
    public int SkillCheckPerformance() {
        return CharismaBonus() + dice.dTwenty();
    }

    @Override
    public int SkillCheckPersuasion() {
        return CharismaBonus() + dice.dTwenty();
    }

    @Override
    public int SkillCheckReligion() {
        return IntelligenceBonus() + dice.dTwenty();
    }

    @Override
    public int SkillCheckSleightOfHand() {
        return DexterityBonus() + dice.dTwenty();
    }

    @Override
    public int SkillCheckStealth() {
        return DexterityBonus() + dice.dTwenty();
    }

    @Override
    public int SkillCheckSurvival() {
        return WisdomBonus() + dice.dTwenty();
    }
}
