/**
 * Represents an attack in a game of Goats vs. Trolls
 */
public class Attack {
    private String name;
    private int[] hits;
    private Damage type;

    public Attack(String name, int[] hits, Damage type) {
        this.name = name;
        this.hits = hits;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int[] getHits() {
        return hits;
    }

    public Damage getType() {
        return type;
    }
}
