import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharacterTest {
    Character npc = new Enemy("Matt Wingo", "civilian", "Human",
            "neutral", 10, 10, 30, 15, 12,
            13, 14, 9, 10);

    @Test
    void strengthBonus() {
        int value = npc.StrengthBonus();
        assertEquals(2, value);
    }

    @Test
    void dexterityBonus() {
        int value = npc.DexterityBonus();
        assertEquals(1, value);
    }

    @Test
    void constitutionBonus() {
        int value = npc.ConstitutionBonus();
        assertEquals(1, value);
    }

    @Test
    void intelligenceBonus() {
        int value = npc.IntelligenceBonus();
        assertEquals(2, value);
    }

    @Test
    void wisdomBonus() {
        int value = npc.WisdomBonus();
        assertEquals(-1, value);
    }

    @Test
    void charismaBonus() {
        int value = npc.CharismaBonus();
        assertEquals(0, value);
    }

    @Test
    void savingThrowStrength() {
        int value = npc.SavingThrowStrength();
        assertTrue(value >= 1 + npc.StrengthBonus() && value <= 20 + npc.StrengthBonus());
    }

    @Test
    void savingThrowDexterity() {
        int value = npc.SavingThrowDexterity();
        assertTrue(value >= 1 + npc.DexterityBonus() && value <= 20 + npc.DexterityBonus());
    }

    @Test
    void savingThrowConstitution() {
        int value = npc.SavingThrowConstitution();
        assertTrue(value >= 1 + npc.ConstitutionBonus() && value <= 20 + npc.ConstitutionBonus());
    }

    @Test
    void savingThrowIntelligence() {
        int value = npc.SavingThrowIntelligence();
        assertTrue(value >= 1 + npc.IntelligenceBonus() && value <= 20 + npc.IntelligenceBonus());
    }

    @Test
    void savingThrowWisdom() {
        int value = npc.SavingThrowWisdom();
        assertTrue(value >= 1 + npc.WisdomBonus() && value <= 20 + npc.WisdomBonus());
    }

    @Test
    void savingThrowCharisma() {
        int value = npc.SavingThrowCharisma();
        assertTrue(value >= 1 + npc.CharismaBonus() && value <= 20 + npc.CharismaBonus());
    }

    @Test
    void skillCheckAcrobatics() {
        int value = npc.SkillCheckAcrobatics();
        assertTrue(value >= 1 + npc.DexterityBonus() && value <= 20 + npc.DexterityBonus());
    }

    @Test
    void skillCheckAnimalHandling() {
        int value = npc.SkillCheckAnimalHandling();
        assertTrue(value >= 1 + npc.WisdomBonus() && value <= 20 + npc.WisdomBonus());
    }

    @Test
    void skillCheckArcana() {
        int value = npc.SkillCheckArcana();
        assertTrue(value >= 1 + npc.IntelligenceBonus() && value <= 20 + npc.IntelligenceBonus());
    }

    @Test
    void skillCheckAthletics() {
        int value = npc.SkillCheckAthletics();
        assertTrue(value >= 1 + npc.StrengthBonus() && value <= 20 + npc.StrengthBonus());
    }

    @Test
    void skillCheckDeception() {
        int value = npc.SkillCheckDeception();
        assertTrue(value >= 1 + npc.CharismaBonus() && value <= 20 + npc.CharismaBonus());
    }

    @Test
    void skillCheckHistory() {
        int value = npc.SkillCheckHistory();
        assertTrue(value >= 1 + npc.IntelligenceBonus() && value <= 20 + npc.IntelligenceBonus());
    }

    @Test
    void skillCheckInsight() {
        int value = npc.SkillCheckInsight();
        assertTrue(value >= 1 + npc.WisdomBonus() && value <= 20 + npc.WisdomBonus());
    }

    @Test
    void skillCheckIntimidation() {
        int value = npc.SkillCheckIntimidation();
        assertTrue(value >= 1 + npc.CharismaBonus() && value <= 20 + npc.CharismaBonus());
    }

    @Test
    void skillCheckInvestigation() {
        int value = npc.SkillCheckInvestigation();
        assertTrue(value >= 1 + npc.IntelligenceBonus() && value <= 20 + npc.IntelligenceBonus());
    }

    @Test
    void skillCheckMedicine() {
        int value = npc.SkillCheckMedicine();
        assertTrue(value >= 1 + npc.WisdomBonus() && value <= 20 + npc.WisdomBonus());
    }

    @Test
    void skillCheckNature() {
        int value = npc.SkillCheckNature();
        assertTrue(value >= 1 + npc.IntelligenceBonus() && value <= 20 + npc.IntelligenceBonus());
    }

    @Test
    void skillCheckPerception() {
        int value = npc.SkillCheckPerception();
        assertTrue(value >= 1 + npc.WisdomBonus() && value <= 20 + npc.WisdomBonus());
    }

    @Test
    void skillCheckPerformance() {
        int value = npc.SkillCheckPerformance();
        assertTrue(value >= 1 + npc.CharismaBonus() && value <= 20 + npc.CharismaBonus());
    }

    @Test
    void skillCheckPersuasion() {
        int value = npc.SkillCheckPersuasion();
        assertTrue(value >= 1 + npc.CharismaBonus() && value <= 20 + npc.CharismaBonus());
    }

    @Test
    void skillCheckReligion() {
        int value = npc.SkillCheckReligion();
        assertTrue(value >= 1 + npc.IntelligenceBonus() && value <= 20 + npc.IntelligenceBonus());
    }

    @Test
    void skillCheckSleightOfHand() {
        int value = npc.SkillCheckSleightOfHand();
        assertTrue(value >= 1 + npc.DexterityBonus() && value <= 20 + npc.DexterityBonus());
    }

    @Test
    void skillCheckStealth() {
        int value = npc.SkillCheckStealth();
        assertTrue(value >= 1 + npc.DexterityBonus() && value <= 20 + npc.DexterityBonus());
    }

    @Test
    void skillCheckSurvival() {
        int value = npc.SkillCheckSurvival();
        assertTrue(value >= 1 + npc.WisdomBonus() && value <= 20 + npc.WisdomBonus());
    }
}