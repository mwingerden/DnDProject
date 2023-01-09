public class CharacterTurn {
    private final Character character;
    private final int initiative;
    private int hp;

    private String condition;

    public CharacterTurn(Character Character, int initiative) {
        this.character = Character;
        this.initiative = initiative;
        this.hp = Character.getHealth();
        this.condition = "";
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Initiative: " + this.initiative + ", Name: " + this.character.getName());
        result.append(", AC: ").append(character.getOtherArmorDesc());
        if(hp > 0) {
            result.append(", HP: ").append(this.hp);
        }
        if(!condition.isEmpty()) {
            result.append(", Condition: ").append(condition).append("\n");
        }
        else {
            result.append("\n");
        }
        return result.toString();
    }


}
