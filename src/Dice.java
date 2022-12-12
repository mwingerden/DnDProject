public class Dice {
    public Dice() {
    }

    private int getRandomNumber(int max) {
        return (int) ((Math.random() * (max - 1)) + 1);
    }

    int dTwenty() {
        return getRandomNumber(20);
    }

    int dTwelve() {
        return getRandomNumber(12);
    }

    int dTen() {
        return getRandomNumber(10);
    }

    int dEight() {
        return getRandomNumber(8);
    }

    int dSix() {
        return getRandomNumber(6);
    }

    int dFour() {
        return getRandomNumber(4);
    }

    int dOneHundred() {
        return getRandomNumber(100);
    }
}
