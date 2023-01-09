import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private final String name;
    private final String size;
    private final String type;
    private final String tag;
    private final String alignment;
    private final int hitDice;
    private int health;
    private final String armorName;
    private final int shieldBonus;
    private final int natArmorBonus;

    private final String otherArmorDesc;
    private final int speed;
    private final int burrowSpeed;
    private final int climbSpeed;
    private final int flySpeed;
    private final boolean hover;
    private final int swimSpeed;
    private final boolean customHP;
    private final boolean customSpeed;
    private final String hpText;
    private final String speedDesc;
    private final int strPoints;
    private final int dexPoints;
    private final int conPoints;
    private final int intPoints;
    private final int wisPoints;
    private final int chaPoints;
    private final int blindsight;
    private final boolean blind;
    private final int darkvision;
    private final int tremorsense;
    private final int truesight;
    private final int telepathy;
    private final String cr;
    private final String customCr;
    private final int customProf;
    private final boolean isLegendary;
    private final String legendariesDescription;
    private final boolean isLair;
    private final String lairDescription;
    private final String lairDescriptionEnd;
    private final boolean isMythic;
    private final String mythicDescription;
    private final boolean isRegional;
    private final String regionalDescription;
    private final String regionalDescriptionEnd;
    private final String[] properties;
    private final Abilities[] abilities;
    private final Actions[] actions;
    private final String[] bonusActions;
    private final String[] reactions;
    private final LegendaryAction[] legendaries;
    private final String[] mythics;
    private final String[] lairs;
    private final String[] regionals;
    private final SThrows[] sthrows;
    private final Skills[] skills;
    private final DamageTypes[] damagetypes;
    private final String[] specialdamage;
    private final String[] conditions;
    private final Languages[] languages;
    private final String understandsBut;
    private final String shortName;
    private final String pluralName;
    private final boolean doubleColumns;
    private final int separationPoint;
    private final String[] damage;
    private final Dice dice;

    private final ChallengeCharacterBonus cb;

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
        this.cb = new ChallengeCharacterBonus();
        calHitPoints();
    }

    int statBonus(String check) {
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

    int rollInitiative() {
        return dice.dTwenty() + statBonus("dex");
    }

    void calHitPoints() {
        double hpSize = 0;
        if(size == null) {
            health = 0;
            return;
        }
        else if(size.compareToIgnoreCase("tiny") == 0) {
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
        health = (int)Math.round((hitDice * hpSize) + (statBonus("con") * hitDice)) - 1;
    }

    int savingThrow(String check, String option) {
        int firstRoll;
        int secondRoll;
        int order;
        firstRoll = dice.dTwenty();;
        secondRoll = dice.dTwenty();

        if(firstRoll == 20) {
            System.out.println("Natural 20!");
            return firstRoll;
        }
        else if(secondRoll == 20 && (option.equalsIgnoreCase("advantage") || option.equalsIgnoreCase("disadvantage"))) {
            System.out.println("Natural 20!");
            return secondRoll;
        }

        if(check.equalsIgnoreCase("str") || check.equalsIgnoreCase("strength")) {
            firstRoll += statBonus(check);
            secondRoll += statBonus(check);
            order = 0;
        }
        else if(check.equalsIgnoreCase("dex") || check.equalsIgnoreCase("dexterity")) {
            firstRoll += statBonus(check);
            secondRoll += statBonus(check);
            order = 1;
        }
        else if(check.equalsIgnoreCase("con") || check.equalsIgnoreCase("constitution")) {
            firstRoll += statBonus(check);
            secondRoll += statBonus(check);
            order = 2;
        }
        else if(check.equalsIgnoreCase("int") || check.equalsIgnoreCase("intelligence")) {
            firstRoll += statBonus(check);
            secondRoll += statBonus(check);
            order = 3;
        }
        else if(check.equalsIgnoreCase("wis") || check.equalsIgnoreCase("wisdom")) {
            firstRoll += statBonus(check);
            secondRoll += statBonus(check);
            order = 4;
        }
        else if(check.equalsIgnoreCase("cha") || check.equalsIgnoreCase("charisma")) {
            firstRoll += statBonus(check);
            secondRoll += statBonus(check);
            order = 5;
        }
        else {
            return 0;
        }

        for(SThrows sThrow : sthrows) {
            if(sThrow.getOrder() == order) {
                firstRoll += cb.crBonus(cr);
                secondRoll += cb.crBonus(cr);
            }
        }

        if(option.equalsIgnoreCase("advantage")) {
            return Math.max(firstRoll, secondRoll);
        }
        else if(option.equalsIgnoreCase("disadvantage")) {
            return Math.min(firstRoll, secondRoll);
        }
        return firstRoll;
    }

    int skillCheck(String check, String option) {
        int firstRoll;
        int secondRoll;
        firstRoll = dice.dTwenty();;
        secondRoll = dice.dTwenty();

        if(firstRoll == 20) {
            System.out.println("Natural 20!(First Roll)");
            return firstRoll;
        }
        else if(secondRoll == 20 && (option.equalsIgnoreCase("advantage") || option.equalsIgnoreCase("disadvantage"))) {
            System.out.println("Natural 20!(Second Roll)");
            return secondRoll;
        }

        for(Skills skill : skills) {
            if(skill.getName().equalsIgnoreCase(check)) {
                if(skill.getNote() != null) {
                    firstRoll += cb.crBonus(cr) * 2;
                    secondRoll += cb.crBonus(cr) * 2;
                }
                else {
                    firstRoll += cb.crBonus(cr);
                    secondRoll += cb.crBonus(cr);
                }
            }
        }

        if(check.equalsIgnoreCase("acrobatics")) {
            firstRoll += statBonus("dex");
            secondRoll += statBonus("dex");
        }
        else if(check.equalsIgnoreCase("animal handling")) {
            firstRoll += statBonus("wis");
            secondRoll += statBonus("wis");
        }
        else if(check.equalsIgnoreCase("arcana")) {
            firstRoll += statBonus("int");
            secondRoll += statBonus("int");
        }
        else if(check.equalsIgnoreCase("athletics")) {
            firstRoll += statBonus("str");
            secondRoll += statBonus("str");
        }
        else if(check.equalsIgnoreCase("deception")) {
            firstRoll += statBonus("cha");
            secondRoll += statBonus("cha");
        }
        else if(check.equalsIgnoreCase("history")) {
            firstRoll += statBonus("int");
            secondRoll += statBonus("int");
        }
        else if(check.equalsIgnoreCase("insight")) {
            firstRoll += statBonus("wis");
            secondRoll += statBonus("wis");
        }
        else if(check.equalsIgnoreCase("intimidation")) {
            firstRoll += statBonus("cha");
            secondRoll += statBonus("cha");
        }
        else if(check.equalsIgnoreCase("investigation")) {
            firstRoll += statBonus("int");
            secondRoll += statBonus("int");
        }
        else if(check.equalsIgnoreCase("medicine")) {
            firstRoll += statBonus("wis");
            secondRoll += statBonus("wis");
        }
        else if(check.equalsIgnoreCase("nature")) {
            firstRoll += statBonus("int");
            secondRoll += statBonus("int");
        }
        else if(check.equalsIgnoreCase("perception")) {
            firstRoll += statBonus("wis");
            secondRoll += statBonus("wis");
        }
        else if(check.equalsIgnoreCase("performance")) {
            firstRoll += statBonus("cha");
            secondRoll += statBonus("cha");
        }
        else if(check.equalsIgnoreCase("persuasion")) {
            firstRoll += statBonus("cha");
            secondRoll += statBonus("cha");
        }
        else if(check.equalsIgnoreCase("religion")) {
            firstRoll += statBonus("int");
            secondRoll += statBonus("int");
        }
        else if(check.equalsIgnoreCase("sleight of hand")) {
            firstRoll += statBonus("dex") ;
            secondRoll += statBonus("dex");
        }
        else if(check.equalsIgnoreCase("stealth")) {
            firstRoll += statBonus("dex");
            secondRoll += statBonus("dex");
        }
        else if(check.equalsIgnoreCase("survival")) {
            firstRoll += statBonus("wis");
            secondRoll += statBonus("wis");
        }
        else {
            firstRoll = 0;
            secondRoll = 0;
        }

        if(option.equalsIgnoreCase("advantage")) {
            return Math.max(firstRoll, secondRoll);
        }
        else if(option.equalsIgnoreCase("disadvantage")) {
            return Math.min(firstRoll, secondRoll);
        }
        return firstRoll;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(name).append("\n");
        str.append(size).append(" ").append(type).append("(").append(tag).append(")").append(", ").append(alignment).append("\n");
        str.append("Armor Class ").append(otherArmorDesc).append("\n");
        str.append("Hit Points ").append(health).append("\n");
        str.append("Speed ").append(speedDesc);
        str.append("STR:").append(strPoints).append("(+").append(statBonus("str")).append(")").append(" DEX:")
                .append(dexPoints).append("(+").append(statBonus("dex")).append(")").append(" CON:")
                .append(conPoints).append("(+").append(statBonus("con")).append(")").append(" INT:")
                .append(intPoints).append("(+").append(statBonus("int")).append(")").append(" WIS:")
                .append(wisPoints).append("(+").append(statBonus("wis")).append(")").append(" CHA:")
                .append(chaPoints).append("(+").append(statBonus("cha")).append(")\n");
        str.append("_Saving Throws_: ");
        for(SThrows sThrow : sthrows) {
            str.append(sThrow.getName()).append(" ").append("+").append(statBonus(sThrow.getName()) + cb.crBonus(cr)).append(", ");
        }

        str.append("\n_Skills_: ");
        for(Skills skill : skills) {
            str.append(skill.getName()).append(" ");
            if(skill.getNote() == null) {
                str.append("+").append(statBonus(skill.getStat()) + cb.crBonus(cr)).append(", ");
            }
            else {
                str.append("+").append(statBonus(skill.getStat()) + cb.crBonus(cr) * 2).append(", ");
            }
        }

        str.append("\n_Damage Types_: ");
        for(DamageTypes damageTypes: damagetypes) {
            str.append(damageTypes.getName()).append(damageTypes.getNote()).append(" ");
        }

        str.append("_Sense_: " + "blindsight").append(blindsight).append(" ft.,").append("darkvision").append(darkvision).append(" ft., ");
        boolean check = false;
        for(Skills skill : skills) {
            if(skill.getName().equalsIgnoreCase("perception")) {
                str.append("passive Perception ").append(10 + (statBonus("wis") + cb.crBonus(cr) * 2));
                check = true;
            }
        }

        if(!check) {
            str.append("passive Perception ").append(10 + statBonus("wis"));
        }

        str.append("\n_Languages_: ");
        for(Languages languages : languages) {
            str.append(languages.getName()).append(", ");
        }

        str.append("\n_Challenge_: ").append(customCr).append("\n");

        str.append("\n_Abilities_: \n");
        for(Abilities abilities : abilities) {
            str.append("_").append(abilities.getName()).append("_. ").append(abilities.getDesc()).append("\n");
        }

        str.append("\n_Actions_: \n");
        for(Actions actions: actions) {
            str.append("_").append(actions.getName()).append("_. ").append(actions.getDesc()).append("\n");
        }

        str.append("\n_Legendary Actions_: \n");
        for(LegendaryAction legendaryAction: legendaries) {
            str.append("_").append(legendaryAction.getName()).append("_. ").append(legendaryAction.getDesc()).append("\n");
        }

        return str.toString();
    }

    String getName() {
        return name;
    }

    int getHealth() {
        return this.health;
    }

    void setHealth(int health) {
        this.health = health;
    }

    public String getOtherArmorDesc() {
        return otherArmorDesc;
    }
}
