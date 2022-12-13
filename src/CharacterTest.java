import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharacterTest {
    Character npc = new Enemy("Matt Wingo", "civilian", "Human",
            "neutral", 10, 10, 30, 15, 12,
            13, 14, 9, 10);

    @Test
    void strengthBonus() {
        int value = npc.bonusStrength();
        assertEquals(2, value);
    }

    @Test
    void dexterityBonus() {
        int value = npc.bonusDexterity();
        assertEquals(1, value);
    }

    @Test
    void constitutionBonus() {
        int value = npc.bonusConstitution();
        assertEquals(1, value);
    }

    @Test
    void intelligenceBonus() {
        int value = npc.bonusIntelligence();
        assertEquals(2, value);
    }

    @Test
    void wisdomBonus() {
        int value = npc.bonusWisdom();
        assertEquals(-1, value);
    }

    @Test
    void charismaBonus() {
        int value = npc.bonusCharisma();
        assertEquals(0, value);
    }

    @Test
    void savingThrowStrength() {
        int value = npc.savingThrowStrength();
        assertTrue(value >= 1 + npc.bonusStrength() && value <= 20 + npc.bonusStrength());
    }

    @Test
    void savingThrowDexterity() {
        int value = npc.savingThrowDexterity();
        assertTrue(value >= 1 + npc.bonusDexterity() && value <= 20 + npc.bonusDexterity());
    }

    @Test
    void savingThrowConstitution() {
        int value = npc.savingThrowConstitution();
        assertTrue(value >= 1 + npc.bonusConstitution() && value <= 20 + npc.bonusConstitution());
    }

    @Test
    void savingThrowIntelligence() {
        int value = npc.savingThrowIntelligence();
        assertTrue(value >= 1 + npc.bonusIntelligence() && value <= 20 + npc.bonusIntelligence());
    }

    @Test
    void savingThrowWisdom() {
        int value = npc.savingThrowWisdom();
        assertTrue(value >= 1 + npc.bonusWisdom() && value <= 20 + npc.bonusWisdom());
    }

    @Test
    void savingThrowCharisma() {
        int value = npc.savingThrowCharisma();
        assertTrue(value >= 1 + npc.bonusCharisma() && value <= 20 + npc.bonusCharisma());
    }

    @Test
    void skillCheckAcrobatics() {
        int value = npc.skillCheckAcrobatics();
        assertTrue(value >= 1 + npc.bonusDexterity() && value <= 20 + npc.bonusDexterity());
    }

    @Test
    void skillCheckAnimalHandling() {
        int value = npc.skillCheckAnimalHandling();
        assertTrue(value >= 1 + npc.bonusWisdom() && value <= 20 + npc.bonusWisdom());
    }

    @Test
    void skillCheckArcana() {
        int value = npc.skillCheckArcana();
        assertTrue(value >= 1 + npc.bonusIntelligence() && value <= 20 + npc.bonusIntelligence());
    }

    @Test
    void skillCheckAthletics() {
        int value = npc.skillCheckAthletics();
        assertTrue(value >= 1 + npc.bonusStrength() && value <= 20 + npc.bonusStrength());
    }

    @Test
    void skillCheckDeception() {
        int value = npc.skillCheckDeception();
        assertTrue(value >= 1 + npc.bonusCharisma() && value <= 20 + npc.bonusCharisma());
    }

    @Test
    void skillCheckHistory() {
        int value = npc.skillCheckHistory();
        assertTrue(value >= 1 + npc.bonusIntelligence() && value <= 20 + npc.bonusIntelligence());
    }

    @Test
    void skillCheckInsight() {
        int value = npc.skillCheckInsight();
        assertTrue(value >= 1 + npc.bonusWisdom() && value <= 20 + npc.bonusWisdom());
    }

    @Test
    void skillCheckIntimidation() {
        int value = npc.skillCheckIntimidation();
        assertTrue(value >= 1 + npc.bonusCharisma() && value <= 20 + npc.bonusCharisma());
    }

    @Test
    void skillCheckInvestigation() {
        int value = npc.skillCheckInvestigation();
        assertTrue(value >= 1 + npc.bonusIntelligence() && value <= 20 + npc.bonusIntelligence());
    }

    @Test
    void skillCheckMedicine() {
        int value = npc.skillCheckMedicine();
        assertTrue(value >= 1 + npc.bonusWisdom() && value <= 20 + npc.bonusWisdom());
    }

    @Test
    void skillCheckNature() {
        int value = npc.skillCheckNature();
        assertTrue(value >= 1 + npc.bonusIntelligence() && value <= 20 + npc.bonusIntelligence());
    }

    @Test
    void skillCheckPerception() {
        int value = npc.skillCheckPerception();
        assertTrue(value >= 1 + npc.bonusWisdom() && value <= 20 + npc.bonusWisdom());
    }

    @Test
    void skillCheckPerformance() {
        int value = npc.skillCheckPerformance();
        assertTrue(value >= 1 + npc.bonusCharisma() && value <= 20 + npc.bonusCharisma());
    }

    @Test
    void skillCheckPersuasion() {
        int value = npc.skillCheckPersuasion();
        assertTrue(value >= 1 + npc.bonusCharisma() && value <= 20 + npc.bonusCharisma());
    }

    @Test
    void skillCheckReligion() {
        int value = npc.skillCheckReligion();
        assertTrue(value >= 1 + npc.bonusIntelligence() && value <= 20 + npc.bonusIntelligence());
    }

    @Test
    void skillCheckSleightOfHand() {
        int value = npc.skillCheckSleightOfHand();
        assertTrue(value >= 1 + npc.bonusDexterity() && value <= 20 + npc.bonusDexterity());
    }

    @Test
    void skillCheckStealth() {
        int value = npc.skillCheckStealth();
        assertTrue(value >= 1 + npc.bonusDexterity() && value <= 20 + npc.bonusDexterity());
    }

    @Test
    void skillCheckSurvival() {
        int value = npc.skillCheckSurvival();
        assertTrue(value >= 1 + npc.bonusWisdom() && value <= 20 + npc.bonusWisdom());
    }
}