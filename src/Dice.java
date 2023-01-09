public class Dice {
    private int getRandomNumber(int max) {
        return (int) ((Math.random() * (max - 1)) + 1);
    }

    int dTwenty(String option) {
        int firstRoll;
        int secondRoll;
        firstRoll = getRandomNumber(20);
        secondRoll = getRandomNumber(20);
        if(option.equalsIgnoreCase("advantage")) {
            return Math.max(firstRoll, secondRoll);
        }
        else if(option.equalsIgnoreCase("disadvantage")) {
            return Math.min(firstRoll, secondRoll);
        }
        return firstRoll;
    }

    int dTwelve(String option) {
        int firstRoll;
        int secondRoll;
        firstRoll = getRandomNumber(12);
        secondRoll = getRandomNumber(12);
        if(option.equalsIgnoreCase("advantage")) {
            return Math.max(firstRoll, secondRoll);
        }
        else if(option.equalsIgnoreCase("disadvantage")) {
            return Math.min(firstRoll, secondRoll);
        }
        return firstRoll;
    }

    int dTen(String option) {
        int firstRoll;
        int secondRoll;
        firstRoll = getRandomNumber(10);
        secondRoll = getRandomNumber(10);
        if(option.equalsIgnoreCase("advantage")) {
            return Math.max(firstRoll, secondRoll);
        }
        else if(option.equalsIgnoreCase("disadvantage")) {
            return Math.min(firstRoll, secondRoll);
        }
        return firstRoll;
    }

    int dEight(String option) {
        int firstRoll;
        int secondRoll;
        firstRoll = getRandomNumber(8);
        secondRoll = getRandomNumber(8);
        if(option.equalsIgnoreCase("advantage")) {
            return Math.max(firstRoll, secondRoll);
        }
        else if(option.equalsIgnoreCase("disadvantage")) {
            return Math.min(firstRoll, secondRoll);
        }
        return firstRoll;
    }

    int dSix(String option) {
        int firstRoll;
        int secondRoll;
        firstRoll = getRandomNumber(6);
        secondRoll = getRandomNumber(6);
        if(option.equalsIgnoreCase("advantage")) {
            return Math.max(firstRoll, secondRoll);
        }
        else if(option.equalsIgnoreCase("disadvantage")) {
            return Math.min(firstRoll, secondRoll);
        }
        return firstRoll;
    }

    int dFour(String option) {
        int firstRoll;
        int secondRoll;
        firstRoll = getRandomNumber(4);
        secondRoll = getRandomNumber(4);
        if(option.equalsIgnoreCase("advantage")) {
            return Math.max(firstRoll, secondRoll);
        }
        else if(option.equalsIgnoreCase("disadvantage")) {
            return Math.min(firstRoll, secondRoll);
        }
        return firstRoll;
    }

    int dOneHundred(String option) {
        int firstRoll;
        int secondRoll;
        firstRoll = getRandomNumber(100);
        secondRoll = getRandomNumber(100);
        if(option.equalsIgnoreCase("advantage")) {
            return Math.max(firstRoll, secondRoll);
        }
        else if(option.equalsIgnoreCase("disadvantage")) {
            return Math.min(firstRoll, secondRoll);
        }
        return firstRoll;
    }
}
