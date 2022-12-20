public class CharacterTurn {
    private final Character character;
    private final int initiative;
    private final int hp;

    public CharacterTurn(Character character, int initiative) {
        this.character = character;
        this.initiative = initiative;
        this.hp = character.calHitPoints();
    }

    public int getInitiative() {
        return initiative;
    }

    @Override
    public String toString() {
        return "Initiative: " + this.initiative + ", Name: " + this.character.getName() + ", HP: " + this.hp + "\n";
    }
}
