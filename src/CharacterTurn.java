public class CharacterTurn {
    private final Character Character;
    private final int initiative;
    private int hp;

    public CharacterTurn(Character Character, int initiative) {
        this.Character = Character;
        this.initiative = initiative;
        this.hp = Character.getHealth();
    }

    public int getInitiative() {
        return initiative;
    }

    public Character getCharacter() {
        return Character;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
        Character.setHealth(hp);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Initiative: " + this.initiative + ", Name: " + this.Character.getName());
        if(hp > 0) {
            result.append(", HP: ").append(this.hp).append("\n");
        }
        else {
            result.append("\n");
        }
        return result.toString();
    }


}
