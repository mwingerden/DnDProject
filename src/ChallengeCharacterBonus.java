public class ChallengeCharacterBonus {

    private double parse(String ratio) {
        if (ratio.contains("/")) {
            String[] rat = ratio.split("/");
            return Double.parseDouble(rat[0]) / Double.parseDouble(rat[1]);
        } else {
            return Double.parseDouble(ratio);
        }
    }
    int crBonus(String challengeRating) {
        double cr = parse(challengeRating);
        if (cr <= 4) {
            return 2;
        }
        else if (cr >= 5 && cr <= 8) {
            return 3;
        }
        else if (cr >= 9 && cr <= 12) {
            return 4;
        }
        else if (cr >= 13 && cr <= 16) {
            return 5;
        }
        else if (cr >= 17 && cr <= 20) {
            return 6;
        }
        else if (cr >= 21 && cr <= 24) {
            return 7;
        }
        else if (cr >= 25 && cr <= 28) {
            return 8;
        }
        else if (cr >= 29) {
            return 9;
        }
        else {
            return 0;
        }
    }


}
