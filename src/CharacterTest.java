import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharacterTest {
    Character character;

    @BeforeEach
    public void setUp() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        character = mapper.readValue(new File("./enemies/thug.json"), Enemy.class);
    }

    @Test
    void strengthBonus() {
        int value = character.statBonus("str");
        assertEquals(2, value);
    }

    @Test
    void dexterityBonus() {
        int value = character.statBonus("dex");
        assertEquals(0, value);
    }

    @Test
    void constitutionBonus() {
        int value = character.statBonus("con");
        assertEquals(2, value);
    }

    @Test
    void intelligenceBonus() {
        int value = character.statBonus("int");
        assertEquals(0, value);
    }

    @Test
    void wisdomBonus() {
        int value = character.statBonus("wis");
        assertEquals(0, value);
    }

    @Test
    void charismaBonus() {
        int value = character.statBonus("cha");
        assertEquals(0, value);
    }

    @RepeatedTest(100)
    void savingThrowStrength() {
        int value = character.savingThrow("str", "");
        assertTrue(value >= 1 + character.statBonus("str") && value <= 20 + character.statBonus("str"));
    }

    @RepeatedTest(100)
    void savingThrowDexterity() {
        int value = character.savingThrow("dex", "");
        assertTrue(value >= 1 + character.statBonus("dex") && value <= 20 + character.statBonus("dex"));
    }

    @RepeatedTest(100)
    void savingThrowConstitution() {
        int value = character.savingThrow("con", "");
        assertTrue(value >= 1 + character.statBonus("con") && value <= 20 + character.statBonus("con"));
    }

    @RepeatedTest(100)
    void savingThrowIntelligence() {
        int value = character.savingThrow("int", "");
        assertTrue(value >= 1 + character.statBonus("int") && value <= 20 + character.statBonus("int"));
    }

    @RepeatedTest(100)
    void savingThrowWisdom() {
        int value = character.savingThrow("wis", "");
        assertTrue(value >= 1 + character.statBonus("wis") && value <= 20 + character.statBonus("wis"));
    }

    @RepeatedTest(100)
    void savingThrowCharisma() {
        int value = character.savingThrow("cha", "");
        assertTrue(value >= 1 + character.statBonus("cha") && value <= 20 + character.statBonus("cha"));
    }

    @RepeatedTest(100)
    void skillCheckAcrobatics() {
        int value = character.skillCheck("Acrobatics", "");
        assertTrue(value >= 1 + character.statBonus("dex") && value <= 20 + character.statBonus("dex"));
    }

    @RepeatedTest(100)
    void skillCheckAnimalHandling() {
        int value = character.skillCheck("Animal Handling", "");
        assertTrue(value >= 1 + character.statBonus("wis") && value <= 20 + character.statBonus("wis"));
    }

    @RepeatedTest(100)
    void skillCheckArcana() {
        int value = character.skillCheck("Arcana", "");
        assertTrue(value >= 1 + character.statBonus("int") && value <= 20 + character.statBonus("int"));
    }

    @RepeatedTest(100)
    void skillCheckAthletics() {
        int value = character.skillCheck("Athletics", "");
        assertTrue(value >= 1 + character.statBonus("str") && value <= 20 + character.statBonus("str"));
    }

    @RepeatedTest(100)
    void skillCheckDeception() {
        int value = character.skillCheck("Deception", "");
        assertTrue(value >= 1 + character.statBonus("cha") && value <= 20 + character.statBonus("cha"));
    }

    @RepeatedTest(100)
    void skillCheckHistory() {
        int value = character.skillCheck("History", "");
        assertTrue(value >= 1 + character.statBonus("int") && value <= 20 + character.statBonus("int"));
    }

    @RepeatedTest(100)
    void skillCheckInsight() {
        int value = character.skillCheck("Insight", "");
        assertTrue(value >= 1 + character.statBonus("wis") && value <= 20 + character.statBonus("wis"));
    }

    @RepeatedTest(100)
    void skillCheckIntimidation() {
        int value = character.skillCheck("Intimidation", "");
        ChallengeCharacterBonus cb = new ChallengeCharacterBonus();
        assertTrue(value >= 1 + character.statBonus("cha") + cb.crBonus("1/2") && value <= 20 + character.statBonus("cha") + cb.crBonus("1/2"));
    }

    @RepeatedTest(100)
    void skillCheckInvestigation() {
        int value = character.skillCheck("Investigation", "");
        assertTrue(value >= 1 + character.statBonus("int") && value <= 20 + character.statBonus("int"));
    }

    @RepeatedTest(100)
    void skillCheckMedicine() {
        int value = character.skillCheck("Medicine", "");
        assertTrue(value >= 1 + character.statBonus("wis") && value <= 20 + character.statBonus("wis"));
    }

    @RepeatedTest(100)
    void skillCheckNature() {
        int value = character.skillCheck("Nature", "");
        assertTrue(value >= 1 + character.statBonus("int") && value <= 20 + character.statBonus("int"));
    }

    @RepeatedTest(100)
    void skillCheckPerception() {
        int value = character.skillCheck("Perception", "");
        assertTrue(value >= 1 + character.statBonus("wis") && value <= 20 + character.statBonus("wis"));
    }

    @RepeatedTest(100)
    void skillCheckPerformance() {
        int value = character.skillCheck("Performance", "");
        assertTrue(value >= 1 + character.statBonus("cha") && value <= 20 + character.statBonus("cha"));
    }

    @RepeatedTest(100)
    void skillCheckPersuasion() {
        int value = character.skillCheck("Persuasion", "");
        assertTrue(value >= 1 + character.statBonus("cha") && value <= 20 + character.statBonus("cha"));
    }

    @RepeatedTest(100)
    void skillCheckReligion() {
        int value = character.skillCheck("Religion", "");
        assertTrue(value >= 1 + character.statBonus("int") && value <= 20 + character.statBonus("int"));
    }

    @RepeatedTest(100)
    void skillCheckSleightOfHand() {
        int value = character.skillCheck("Sleight Of Hand", "");
        assertTrue(value >= 1 + character.statBonus("dex") && value <= 20 + character.statBonus("dex"));
    }

    @RepeatedTest(100)
    void skillCheckStealth() {
        int value = character.skillCheck("Stealth", "");
        assertTrue(value >= 1 + character.statBonus("dex") && value <= 20 + character.statBonus("dex"));
    }

    @RepeatedTest(100)
    void skillCheckSurvival() {
        int value = character.skillCheck("Survival", "");
        assertTrue(value >= 1 + character.statBonus("wis") && value <= 20 + character.statBonus("wis"));
    }
}