public class CharacterTurn {
    private final NPC NPC;
    private final int initiative;
    private int hp;

    public CharacterTurn(NPC NPC, int initiative) {
        this.NPC = NPC;
        this.initiative = initiative;
        this.hp = NPC.getHealth();
    }

    public int getInitiative() {
        return initiative;
    }

    public NPC getCharacter() {
        return NPC;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
        NPC.setHealth(hp);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Initiative: " + this.initiative + ", Name: " + this.NPC.getName());
        if(hp > 0) {
            result.append(", HP: ").append(this.hp).append("\n");
        }
        else {
            result.append("\n");
        }
        return result.toString();
    }


}
