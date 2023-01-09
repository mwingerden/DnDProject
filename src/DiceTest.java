import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DiceTest {
    Dice dice = new Dice();

    @RepeatedTest(100)
    void dTwenty() {
        int value = dice.dTwenty("");
        assertTrue(value >= 1 && value <= 20);
    }

    @RepeatedTest(100)
    void dTwelve() {
        int value = dice.dTwelve("");
        assertTrue(value >= 1 && value <= 12);
    }

    @RepeatedTest(100)
    void dTen() {
        int value = dice.dTen("");
        assertTrue(value >= 1 && value <= 10);
    }

    @RepeatedTest(100)
    void dEight() {
        int value = dice.dEight("");
        assertTrue(value >= 1 && value <= 8);
    }

    @RepeatedTest(100)
    void dSix() {
        int value = dice.dSix("");
        assertTrue(value >= 1 && value <= 6);
    }

    @RepeatedTest(100)
    void dFour() {
        int value = dice.dFour("");
        assertTrue(value >= 1 && value <= 4);
    }

    @RepeatedTest(100)
    void dOneHundred() {
        int value = dice.dOneHundred("");
        assertTrue(value >= 1 && value <= 100);
    }
}