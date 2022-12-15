public abstract class Character implements SavingThrows, SkillCheck {
    String name;
    String size;
    String type;
    String tag;
    String alignment;
    int hitDice;
    String armorName;
    int shieldBonus;
    int natArmorBonus;
    String otherArmorDesc;
    int speed;
    int burrowSpeed;
    int climbSpeed;
    int flySpeed;
    boolean hover;
    int swimSpeed;
    boolean customHP;
    boolean customSpeed;
    String hpText;
    String speedDesc;
    int strPoints;
    int dexPoints;
    int conPoints;
    int intPoints;
    int wisPoints;
    int chaPoints;
    int blindsight;
    boolean blind;
    int darkvision;
    int tremorsense;
    int truesight;
    int telepathy;
    String cr;
    String customCr;
    int customProf;
    boolean isLegendary;
    String legendariesDescription;
    boolean isLair;
    String lairDescription;
    String lairDescriptionEnd;
    boolean isMythic;
    String mythicDescription;
    boolean isRegional;
    String regionalDescription;
    String regionalDescriptionEnd;
    String[] properties;
    Abilities[] abilities;
    Actions[] actions;
    String[] bonusActions;
    String[] reactions;
    LegendaryAction[] legendaries;
    String[] mythics;
    String[] lairs;
    String[] regionals;
    SThrows[] sthrows;
    Skills[] skills;
    DamageTypes[] damagetypes;
    String[] specialdamage;
    String[] conditions;
    Languages[] languages;
    String understandsBut;
    String shortName;
    String pluralName;
    boolean doubleColumns;
    int separationPoint;
    String[] damage;
    Dice dice;

    public Character(String name, String size, String type, String tag, String alignment, int hitDice, String armorName,
                     int shieldBonus, int natArmorBonus, String otherArmorDesc, int speed, int burrowSpeed,
                     int climbSpeed, int flySpeed, boolean hover, int swimSpeed, boolean customHP, boolean customSpeed,
                     String hpText, String speedDesc, int strPoints, int dexPoints, int conPoints, int intPoints,
                     int wisPoints, int chaPoints, int blindsight, boolean blind, int darkvision, int tremorsense,
                     int truesight, int telepathy, String cr, String customCr, int customProf, boolean isLegendary,
                     String legendariesDescription, boolean isLair, String lairDescription, String lairDescriptionEnd,
                     boolean isMythic, String mythicDescription, boolean isRegional, String regionalDescription,
                     String regionalDescriptionEnd, String[] properties, Abilities[] abilities, Actions[] actions,
                     String[] bonusActions, String[] reactions, LegendaryAction[] legendaries, String[] mythics,
                     String[] lairs, String[] regionals, SThrows[] sthrows, Skills[] skills, DamageTypes[] damagetypes,
                     String[] specialdamage, String[] conditions, Languages[] languages, String understandsBut,
                     String shortName, String pluralName, boolean doubleColumns, int separationPoint, String[] damage) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.tag = tag;
        this.alignment = alignment;
        this.hitDice = hitDice;
        this.armorName = armorName;
        this.shieldBonus = shieldBonus;
        this.natArmorBonus = natArmorBonus;
        this.otherArmorDesc = otherArmorDesc;
        this.speed = speed;
        this.burrowSpeed = burrowSpeed;
        this.climbSpeed = climbSpeed;
        this.flySpeed = flySpeed;
        this.hover = hover;
        this.swimSpeed = swimSpeed;
        this.customHP = customHP;
        this.customSpeed = customSpeed;
        this.hpText = hpText;
        this.speedDesc = speedDesc;
        this.strPoints = strPoints;
        this.dexPoints = dexPoints;
        this.conPoints = conPoints;
        this.intPoints = intPoints;
        this.wisPoints = wisPoints;
        this.chaPoints = chaPoints;
        this.blindsight = blindsight;
        this.blind = blind;
        this.darkvision = darkvision;
        this.tremorsense = tremorsense;
        this.truesight = truesight;
        this.telepathy = telepathy;
        this.cr = cr;
        this.customCr = customCr;
        this.customProf = customProf;
        this.isLegendary = isLegendary;
        this.legendariesDescription = legendariesDescription;
        this.isLair = isLair;
        this.lairDescription = lairDescription;
        this.lairDescriptionEnd = lairDescriptionEnd;
        this.isMythic = isMythic;
        this.mythicDescription = mythicDescription;
        this.isRegional = isRegional;
        this.regionalDescription = regionalDescription;
        this.regionalDescriptionEnd = regionalDescriptionEnd;
        this.properties = properties;
        this.abilities = abilities;
        this.actions = actions;
        this.bonusActions = bonusActions;
        this.reactions = reactions;
        this.legendaries = legendaries;
        this.mythics = mythics;
        this.lairs = lairs;
        this.regionals = regionals;
        this.sthrows = sthrows;
        this.skills = skills;
        this.damagetypes = damagetypes;
        this.specialdamage = specialdamage;
        this.conditions = conditions;
        this.languages = languages;
        this.understandsBut = understandsBut;
        this.shortName = shortName;
        this.pluralName = pluralName;
        this.doubleColumns = doubleColumns;
        this.separationPoint = separationPoint;
        this.damage = damage;
        this.dice = new Dice();
    }

    int calHitPoints() {
        double hpSize = 0;
        if(size.compareToIgnoreCase("tiny") == 0) {
            hpSize = 2.5;
        } else if (size.compareToIgnoreCase("small") == 0) {
            hpSize = 3.5;
        }else if (size.compareToIgnoreCase("medium") == 0) {
            hpSize = 4.5;
        }else if (size.compareToIgnoreCase("large") == 0) {
            hpSize = 5.5;
        }else if (size.compareToIgnoreCase("huge") == 0) {
            hpSize = 6.5;
        }else if (size.compareToIgnoreCase("gargantuan") == 0) {
            hpSize = 10.5;
        }
        return (int)Math.round((hitDice * hpSize) + (bonusConstitution() * hitDice)) - 1;
    }

    int bonusStrength() {
        float value = (float) (strPoints - 10) / 2;
        if (value <= -0.1) {
            return ((strPoints - 10) / 2) - 1;
        } else {
            return (strPoints - 10) / 2;
        }
    }

    int bonusDexterity() {
        float value = (float) (dexPoints - 10) / 2;
        if (value <= -0.1) {
            return ((dexPoints - 10) / 2) - 1;
        } else {
            return (dexPoints - 10) / 2;
        }
    }

    int bonusConstitution() {

        float value = (float) (conPoints - 10) / 2;
        if (value <= -0.1) {
            return ((conPoints - 10) / 2) - 1;
        } else {
            return (conPoints - 10) / 2;
        }
    }

    int bonusIntelligence() {
        float value = (float) (intPoints - 10) / 2;
        if (value <= -0.1) {
            return ((intPoints - 10) / 2) - 1;
        } else {
            return (intPoints - 10) / 2;
        }
    }

    int bonusWisdom() {
        float value = (float) (wisPoints - 10) / 2;
        if (value <= -0.1) {
            return ((wisPoints - 10) / 2) - 1;
        } else {
            return (wisPoints - 10) / 2;
        }
    }

    int bonusCharisma() {
        float value = (float) (chaPoints - 10) / 2;
        if (value <= -0.1) {
            return ((chaPoints - 10) / 2) - 1;
        } else {
            return (chaPoints - 10) / 2;
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
