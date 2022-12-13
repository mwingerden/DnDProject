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

    int bonusStrength() {
        float value = (float) (charStrength - 10) / 2;
        if (value <= -0.1) {
            return ((charStrength - 10) / 2) - 1;
        } else {
            return (charStrength - 10) / 2;
        }
    }

    int bonusDexterity() {
        float value = (float) (charDexterity - 10) / 2;
        if (value <= -0.1) {
            return ((charDexterity - 10) / 2) - 1;
        } else {
            return (charDexterity - 10) / 2;
        }
    }

    int bonusConstitution() {

        float value = (float) (charConstitution - 10) / 2;
        if (value <= -0.1) {
            return ((charConstitution - 10) / 2) - 1;
        } else {
            return (charConstitution - 10) / 2;
        }
    }

    int bonusIntelligence() {
        float value = (float) (charIntelligence - 10) / 2;
        if (value <= -0.1) {
            return ((charIntelligence - 10) / 2) - 1;
        } else {
            return (charIntelligence - 10) / 2;
        }
    }

    int bonusWisdom() {
        float value = (float) (charWisdom - 10) / 2;
        if (value <= -0.1) {
            return ((charWisdom - 10) / 2) - 1;
        } else {
            return (charWisdom - 10) / 2;
        }
    }

    int bonusCharisma() {
        float value = (float) (charCharisma - 10) / 2;
        if (value <= -0.1) {
            return ((charCharisma - 10) / 2) - 1;
        } else {
            return (charCharisma - 10) / 2;
        }
    }

    @Override
    public int savingThrowStrength() {
        return bonusStrength() + dice.dTwenty();
    }

    @Override
    public int savingThrowDexterity() {
        return bonusDexterity() + dice.dTwenty();
    }

    @Override
    public int savingThrowConstitution() {
        return bonusConstitution() + dice.dTwenty();
    }

    @Override
    public int savingThrowIntelligence() {
        return bonusIntelligence() + dice.dTwenty();
    }

    @Override
    public int savingThrowWisdom() {
        return bonusWisdom() + dice.dTwenty();
    }

    @Override
    public int savingThrowCharisma() {
        return bonusCharisma() + dice.dTwenty();
    }

    @Override
    public int skillCheckAcrobatics() {
        return bonusDexterity() + dice.dTwenty();
    }

    @Override
    public int skillCheckAnimalHandling() {
        return bonusWisdom() + dice.dTwenty();
    }

    @Override
    public int skillCheckArcana() {
        return bonusIntelligence() + dice.dTwenty();
    }

    @Override
    public int skillCheckAthletics() {
        return bonusStrength() + dice.dTwenty();
    }

    @Override
    public int skillCheckDeception() {
        return bonusCharisma() + dice.dTwenty();
    }

    @Override
    public int skillCheckHistory() {
        return bonusIntelligence() + dice.dTwenty();
    }

    @Override
    public int skillCheckInsight() {
        return bonusWisdom() + dice.dTwenty();
    }

    @Override
    public int skillCheckIntimidation() {
        return bonusCharisma() + dice.dTwenty();
    }

    @Override
    public int skillCheckInvestigation() {
        return bonusIntelligence() + dice.dTwenty();
    }

    @Override
    public int skillCheckMedicine() {
        return bonusWisdom() + dice.dTwenty();
    }

    @Override
    public int skillCheckNature() {
        return bonusIntelligence() + dice.dTwenty();
    }

    @Override
    public int skillCheckPerception() {
        return bonusWisdom() + dice.dTwenty();
    }

    @Override
    public int skillCheckPerformance() {
        return bonusCharisma() + dice.dTwenty();
    }

    @Override
    public int skillCheckPersuasion() {
        return bonusCharisma() + dice.dTwenty();
    }

    @Override
    public int skillCheckReligion() {
        return bonusIntelligence() + dice.dTwenty();
    }

    @Override
    public int skillCheckSleightOfHand() {
        return bonusDexterity() + dice.dTwenty();
    }

    @Override
    public int skillCheckStealth() {
        return bonusDexterity() + dice.dTwenty();
    }

    @Override
    public int skillCheckSurvival() {
        return bonusWisdom() + dice.dTwenty();
    }
}
