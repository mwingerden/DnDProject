import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharacterTest {
    Character npc;

    @BeforeEach
    public void setUp() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        npc = mapper.readValue(new File("./enemies/thug.json"), Enemy.class);
    }

    @Test
    void strengthBonus() {
        int value = npc.statBonus("str");
        assertEquals(2, value);
    }

    @Test
    void dexterityBonus() {
        int value = npc.statBonus("dex");
        assertEquals(0, value);
    }

    @Test
    void constitutionBonus() {
        int value = npc.statBonus("con");
        assertEquals(2, value);
    }

    @Test
    void intelligenceBonus() {
        int value = npc.statBonus("int");
        assertEquals(0, value);
    }

    @Test
    void wisdomBonus() {
        int value = npc.statBonus("wis");
        assertEquals(0, value);
    }

    @Test
    void charismaBonus() {
        int value = npc.statBonus("cha");
        assertEquals(0, value);
    }

    @RepeatedTest(100)
    void savingThrowStrength() {
        int value = npc.savingThrow("str");
        assertTrue(value >= 1 + npc.statBonus("str") && value <= 20 + npc.statBonus("str"));
    }

    @RepeatedTest(100)
    void savingThrowDexterity() {
        int value = npc.savingThrow("dex");
        assertTrue(value >= 1 + npc.statBonus("dex") && value <= 20 + npc.statBonus("dex"));
    }

    @RepeatedTest(100)
    void savingThrowConstitution() {
        int value = npc.savingThrow("con");
        assertTrue(value >= 1 + npc.statBonus("con") && value <= 20 + npc.statBonus("con"));
    }

    @RepeatedTest(100)
    void savingThrowIntelligence() {
        int value = npc.savingThrow("int");
        assertTrue(value >= 1 + npc.statBonus("int") && value <= 20 + npc.statBonus("int"));
    }

    @RepeatedTest(100)
    void savingThrowWisdom() {
        int value = npc.savingThrow("wis");
        assertTrue(value >= 1 + npc.statBonus("wis") && value <= 20 + npc.statBonus("wis"));
    }

    @RepeatedTest(100)
    void savingThrowCharisma() {
        int value = npc.savingThrow("cha");
        assertTrue(value >= 1 + npc.statBonus("cha") && value <= 20 + npc.statBonus("cha"));
    }

    @RepeatedTest(100)
    void skillCheckAcrobatics() {
        int value = npc.skillCheck("Acrobatics");
        assertTrue(value >= 1 + npc.statBonus("dex") && value <= 20 + npc.statBonus("dex"));
    }

    @RepeatedTest(100)
    void skillCheckAnimalHandling() {
        int value = npc.skillCheck("Animal Handling");
        assertTrue(value >= 1 + npc.statBonus("wis") && value <= 20 + npc.statBonus("wis"));
    }

    @RepeatedTest(100)
    void skillCheckArcana() {
        int value = npc.skillCheck("Arcana");
        assertTrue(value >= 1 + npc.statBonus("int") && value <= 20 + npc.statBonus("int"));
    }

    @RepeatedTest(100)
    void skillCheckAthletics() {
        int value = npc.skillCheck("Athletics");
        assertTrue(value >= 1 + npc.statBonus("str") && value <= 20 + npc.statBonus("str"));
    }

    @RepeatedTest(100)
    void skillCheckDeception() {
        int value = npc.skillCheck("Deception");
        assertTrue(value >= 1 + npc.statBonus("cha") && value <= 20 + npc.statBonus("cha"));
    }

    @RepeatedTest(100)
    void skillCheckHistory() {
        int value = npc.skillCheck("History");
        assertTrue(value >= 1 + npc.statBonus("int") && value <= 20 + npc.statBonus("int"));
    }

    @RepeatedTest(100)
    void skillCheckInsight() {
        int value = npc.skillCheck("Insight");
        assertTrue(value >= 1 + npc.statBonus("wis") && value <= 20 + npc.statBonus("wis"));
    }

    @RepeatedTest(100)
    void skillCheckIntimidation() {
        int value = npc.skillCheck("Intimidation");
        assertTrue(value >= 1 + npc.statBonus("cha") && value <= 20 + npc.statBonus("cha"));
    }

    @RepeatedTest(100)
    void skillCheckInvestigation() {
        int value = npc.skillCheck("Investigation");
        assertTrue(value >= 1 + npc.statBonus("int") && value <= 20 + npc.statBonus("int"));
    }

    @RepeatedTest(100)
    void skillCheckMedicine() {
        int value = npc.skillCheck("Medicine");
        assertTrue(value >= 1 + npc.statBonus("wis") && value <= 20 + npc.statBonus("wis"));
    }

    @RepeatedTest(100)
    void skillCheckNature() {
        int value = npc.skillCheck("Nature");
        assertTrue(value >= 1 + npc.statBonus("int") && value <= 20 + npc.statBonus("int"));
    }

    @RepeatedTest(100)
    void skillCheckPerception() {
        int value = npc.skillCheck("Perception");
        assertTrue(value >= 1 + npc.statBonus("wis") && value <= 20 + npc.statBonus("wis"));
    }

    @RepeatedTest(100)
    void skillCheckPerformance() {
        int value = npc.skillCheck("Performance");
        assertTrue(value >= 1 + npc.statBonus("cha") && value <= 20 + npc.statBonus("cha"));
    }

    @RepeatedTest(100)
    void skillCheckPersuasion() {
        int value = npc.skillCheck("Persuasion");
        assertTrue(value >= 1 + npc.statBonus("cha") && value <= 20 + npc.statBonus("cha"));
    }

    @RepeatedTest(100)
    void skillCheckReligion() {
        int value = npc.skillCheck("Religion");
        assertTrue(value >= 1 + npc.statBonus("int") && value <= 20 + npc.statBonus("int"));
    }

    @RepeatedTest(100)
    void skillCheckSleightOfHand() {
        int value = npc.skillCheck("Sleight Of Hand");
        assertTrue(value >= 1 + npc.statBonus("dex") && value <= 20 + npc.statBonus("dex"));
    }

    @RepeatedTest(100)
    void skillCheckStealth() {
        int value = npc.skillCheck("Stealth");
        assertTrue(value >= 1 + npc.statBonus("dex") && value <= 20 + npc.statBonus("dex"));
    }

    @RepeatedTest(100)
    void skillCheckSurvival() {
        int value = npc.skillCheck("Survival");
        assertTrue(value >= 1 + npc.statBonus("wis") && value <= 20 + npc.statBonus("wis"));
    }
}