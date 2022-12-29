public class CharacterTurn {
    private final Character character;
    private final int initiative;
    private int hp;

    public CharacterTurn(Character character, int initiative) {
        this.character = character;
        this.initiative = initiative;
        this.hp = character.getHealth();
    }

    public int getInitiative() {
        return initiative;
    }

    public Character getCharacter() {
        return character;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
        character.setHealth(hp);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Initiative: " + this.initiative + ", Name: " + this.character.getName());
        if(hp > 0) {
            result.append(", HP: ").append(this.hp).append("\n");
        }
        else {
            result.append("\n");
        }
        return result.toString();
    }


}
