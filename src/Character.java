import java.util.ArrayList;
import java.util.List;

public abstract class Character {
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

    public int statBonus(String check) {
        int stat = -1;
        List<Integer> stats = new ArrayList<>();
        stats.add(strPoints);
        stats.add(dexPoints);
        stats.add(conPoints);
        stats.add(intPoints);
        stats.add(wisPoints);
        stats.add(chaPoints);
        if(check.equalsIgnoreCase("str") || check.equalsIgnoreCase("strength")) {
            stat = 0;
        }
        else if(check.equalsIgnoreCase("dex") || check.equalsIgnoreCase("dexterity")) {
            stat = 1;
        }
        else if(check.equalsIgnoreCase("con") || check.equalsIgnoreCase("constitution")) {
            stat = 2;
        }
        else if(check.equalsIgnoreCase("int") || check.equalsIgnoreCase("intelligence")) {
            stat = 3;
        }
        else if(check.equalsIgnoreCase("wis") || check.equalsIgnoreCase("wisdom")) {
            stat = 4;
        }
        else if(check.equalsIgnoreCase("cha") || check.equalsIgnoreCase("charisma")) {
            stat = 5;
        }
        else {
            return stat;
        }

        float value = (float) (stats.get(stat) - 10) / 2;
        if (value <= -0.1) {
            return ((stats.get(stat) - 10) / 2) - 1;
        } else {
            return (stats.get(stat) - 10) / 2;
        }
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
        return (int)Math.round((hitDice * hpSize) + (statBonus("con") * hitDice)) - 1;
    }

    public int savingThrow(String check) {
        int roll = 0;
        roll += dice.dTwenty();
        if(check.equalsIgnoreCase("str") || check.equalsIgnoreCase("strength")) {
            roll += statBonus("str");
        }
        else if(check.equalsIgnoreCase("dex") || check.equalsIgnoreCase("dexterity")) {
            roll +=  statBonus("dex");
        }
        else if(check.equalsIgnoreCase("con") || check.equalsIgnoreCase("constitution")) {
            roll +=  statBonus("con");
        }
        else if(check.equalsIgnoreCase("int") || check.equalsIgnoreCase("intelligence")) {
            roll +=  statBonus("int");
        }
        else if(check.equalsIgnoreCase("wis") || check.equalsIgnoreCase("wisdom")) {
            roll +=  statBonus("wis");
        }
        else if(check.equalsIgnoreCase("cha") || check.equalsIgnoreCase("charisma")) {
            roll +=  statBonus("cha");
        }
        else {
            roll = 0;
        }
        return roll;
    }

    public int skillCheck(String check) {
        int roll = 0;
        roll += dice.dTwenty();
        if(check.equalsIgnoreCase("acrobatics")) {
            roll += statBonus("dex");
        }
        else if(check.equalsIgnoreCase("animal handling")) {
            roll += statBonus("wis");
        }
        else if(check.equalsIgnoreCase("arcana")) {
            roll += statBonus("int");
        }
        else if(check.equalsIgnoreCase("athletics")) {
            roll += statBonus("str");
        }
        else if(check.equalsIgnoreCase("deception")) {
            roll += statBonus("cha");
        }
        else if(check.equalsIgnoreCase("history")) {
            roll += statBonus("int");
        }
        else if(check.equalsIgnoreCase("insight")) {
            roll += statBonus("wis");
        }
        else if(check.equalsIgnoreCase("intimidation")) {
            roll += statBonus("cha");
        }
        else if(check.equalsIgnoreCase("investigation")) {
            roll += statBonus("int");
        }
        else if(check.equalsIgnoreCase("medicine")) {
            roll += statBonus("wis");
        }
        else if(check.equalsIgnoreCase("nature")) {
            roll += statBonus("int");
        }
        else if(check.equalsIgnoreCase("perception")) {
            roll += statBonus("wis");
        }
        else if(check.equalsIgnoreCase("performance")) {
            roll += statBonus("cha");
        }
        else if(check.equalsIgnoreCase("persuasion")) {
            roll += statBonus("cha");
        }
        else if(check.equalsIgnoreCase("religion")) {
            roll += statBonus("int");
        }
        else if(check.equalsIgnoreCase("sleight of hand")) {
            roll += statBonus("dex") ;
        }
        else if(check.equalsIgnoreCase("stealth")) {
            roll += statBonus("dex");
        }
        else if(check.equalsIgnoreCase("survival")) {
            roll += statBonus("wis");
        }
        else {
            roll = 0;
        }
        return roll;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(name).append("\n");
        str.append(size).append(" ").append(type).append("(").append(tag).append(")").append(", ").append(alignment).append("\n");
        str.append("Armor Class ").append(otherArmorDesc).append("\n");
        str.append("Hit Points ").append(calHitPoints()).append("\n");
        str.append("Speed ").append(speed).append("ft.\n");
        str.append("STR:").append(strPoints).append("(+").append(statBonus("str")).append(")").append(" DEX:")
                .append(dexPoints).append("(+").append(statBonus("dex")).append(")").append(" CON:")
                .append(conPoints).append("(+").append(statBonus("con")).append(")").append(" INT:")
                .append(intPoints).append("(+").append(statBonus("int")).append(")").append(" WIS:")
                .append(wisPoints).append("(+").append(statBonus("wis")).append(")").append(" CHA:")
                .append(chaPoints).append("(+").append(statBonus("cha")).append(")\n");

        return str.toString();
    }
}
