import static org.junit.jupiter.api.Assertions.assertTrue;

class DiceTest {
    Dice dice = new Dice();

    @org.junit.jupiter.api.Test
    void dTwenty() {
        int value = dice.dTwenty();
        assertTrue(value >= 1 && value <= 20);
    }

    @org.junit.jupiter.api.Test
    void dTwelve() {
        int value = dice.dTwelve();
        assertTrue(value >= 1 && value <= 12);
    }

    @org.junit.jupiter.api.Test
    void dTen() {
        int value = dice.dTen();
        assertTrue(value >= 1 && value <= 10);
    }

    @org.junit.jupiter.api.Test
    void dEight() {
        int value = dice.dEight();
        assertTrue(value >= 1 && value <= 8);
    }

    @org.junit.jupiter.api.Test
    void dSix() {
        int value = dice.dSix();
        assertTrue(value >= 1 && value <= 6);
    }

    @org.junit.jupiter.api.Test
    void dFour() {
        int value = dice.dFour();
        assertTrue(value >= 1 && value <= 4);
    }

    @org.junit.jupiter.api.Test
    void dOneHundred() {
        int value = dice.dOneHundred();
        assertTrue(value >= 1 && value <= 100);
    }
}