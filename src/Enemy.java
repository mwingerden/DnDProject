import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Enemy extends Character {
    @JsonCreator
    public Enemy(@JsonProperty("name") String name,
                 @JsonProperty("size") String size,
                 @JsonProperty("type") String type,
                 @JsonProperty("tag") String tag,
                 @JsonProperty("alignment") String alignment,
                 @JsonProperty("hitDice") int hitDice,
                 @JsonProperty("armorName") String armorName,
                 @JsonProperty("shieldBonus") int shieldBonus,
                 @JsonProperty("natArmorBonus") int natArmorBonus,
                 @JsonProperty("otherArmorDesc") String otherArmorDesc,
                 @JsonProperty("speed") int speed,
                 @JsonProperty("burrowSpeed") int burrowSpeed,
                 @JsonProperty("climbSpeed") int climbSpeed,
                 @JsonProperty("flySpeed") int flySpeed,
                 @JsonProperty("hover") boolean hover,
                 @JsonProperty("swimSpeed") int swimSpeed,
                 @JsonProperty("customHP") boolean customHP,
                 @JsonProperty("customSpeed") boolean customSpeed,
                 @JsonProperty("hpText") String hpText,
                 @JsonProperty("speedDesc") String speedDesc,
                 @JsonProperty("strPoints") int strPoints,
                 @JsonProperty("dexPoints") int dexPoints,
                 @JsonProperty("conPoints") int conPoints,
                 @JsonProperty("intPoints") int intPoints,
                 @JsonProperty("wisPoints") int wisPoints,
                 @JsonProperty("chaPoints") int chaPoints,
                 @JsonProperty("blindsight") int blindsight,
                 @JsonProperty("blind") boolean blind,
                 @JsonProperty("darkvision") int darkvision,
                 @JsonProperty("tremorsense") int tremorsense,
                 @JsonProperty("truesight") int truesight,
                 @JsonProperty("telepathy") int telepathy,
                 @JsonProperty("cr") String cr,
                 @JsonProperty("customCr") String customCr,
                 @JsonProperty("customProf") int customProf,
                 @JsonProperty("isLegendary") boolean isLegendary,
                 @JsonProperty("legendariesDescription") String legendariesDescription,
                 @JsonProperty("isLair") boolean isLair,
                 @JsonProperty("lairDescription") String lairDescription,
                 @JsonProperty("lairDescriptionEnd") String lairDescriptionEnd,
                 @JsonProperty("isMythic") boolean isMythic,
                 @JsonProperty("mythicDescription") String mythicDescription,
                 @JsonProperty("isRegional") boolean isRegional,
                 @JsonProperty("regionalDescription") String regionalDescription,
                 @JsonProperty("regionalDescriptionEnd") String regionalDescriptionEnd,
                 @JsonProperty("properties") String[] properties,
                 @JsonProperty("abilities") Abilities[] abilities,
                 @JsonProperty("actions") Actions[] actions,
                 @JsonProperty("bonusActions") String[] bonusActions,
                 @JsonProperty("reactions") String[] reactions,
                 @JsonProperty("legendaries") LegendaryAction[] legendaries,
                 @JsonProperty("mythics") String[] mythics,
                 @JsonProperty("lairs") String[] lairs,
                 @JsonProperty("regionals") String[] regionals,
                 @JsonProperty("sthrows") SThrows[] sthrows,
                 @JsonProperty("skills") Skills[] skills,
                 @JsonProperty("damagetypes") DamageTypes[] damagetypes,
                 @JsonProperty("specialdamage") String[] specialdamage,
                 @JsonProperty("conditions") String[] conditions,
                 @JsonProperty("languages") Languages[] languages,
                 @JsonProperty("understandsBut") String understandsBut,
                 @JsonProperty("shortName") String shortName,
                 @JsonProperty("pluralName") String pluralName,
                 @JsonProperty("doubleColumns") boolean doubleColumns,
                 @JsonProperty("separationPoint") int separationPoint,
                 @JsonProperty("damage") String[] damage) {
        super(name, size, type, tag, alignment, hitDice, armorName, shieldBonus, natArmorBonus, otherArmorDesc, speed,
                burrowSpeed, climbSpeed, flySpeed, hover, swimSpeed, customHP, customSpeed, hpText, speedDesc,
                strPoints, dexPoints, conPoints, intPoints, wisPoints, chaPoints, blindsight, blind, darkvision,
                tremorsense, truesight, telepathy, cr, customCr, customProf, isLegendary, legendariesDescription,
                isLair, lairDescription, lairDescriptionEnd, isMythic, mythicDescription, isRegional,
                regionalDescription, regionalDescriptionEnd, properties, abilities, actions, bonusActions, reactions,
                legendaries, mythics, lairs, regionals, sthrows, skills, damagetypes, specialdamage, conditions,
                languages, understandsBut, shortName, pluralName, doubleColumns, separationPoint, damage);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(name).append("\n");
        str.append(size).append(" ").append(type).append("(").append(tag).append(")").append(", ").append(alignment).append("\n");
        str.append("Armor Class ").append(otherArmorDesc).append("\n");
        str.append("Hit Points ").append(calHitPoints()).append("\n");
        str.append("Speed ").append(speed).append("ft.\n");
        str.append("STR:").append(strPoints).append("(+").append(bonusStrength()).append(")").append(" DEX:").append(dexPoints).append("(+").append(bonusDexterity()).append(")").append(" CON:").append(conPoints).append("(+").append(bonusConstitution()).append(")").append(" INT:").append(intPoints).append("(+").append(bonusIntelligence()).append(")").append(" WIS:").append(wisPoints).append("(+").append(bonusWisdom()).append(")").append(" CHA:").append(chaPoints).append("(+").append(bonusCharisma()).append(")\n");

        return str.toString();
    }
}
