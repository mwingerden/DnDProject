public class CharacterTurn {
    Character character;
    int initiative;
    int hp;

    public CharacterTurn(Character character, int initiative) {
        this.character = character;
        this.initiative = initiative;
        this.hp = character.calHitPoints();
    }

    public Character getCharacter() {
        return character;
    }

    public int getInitiative() {
        return initiative;
    }

    @Override
    public String toString() {
        return "Initiative: " + this.initiative + ", Name: " + this.character.getName() + ", HP: " + this.hp + "\n";
    }
}
