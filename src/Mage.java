public class Mage implements Goat {
    private String name;
    private int maxHP;
    private int currentHP;
    private int minAttack;
    private int maxAttack;
    private DamageType type;

    public Mage(String name) {
        this.name = name;
        maxHP = 100;
        currentHP = maxHP;
        minAttack = 6;
        maxAttack = 12;
        type = DamageType.MAGICAL;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Attack attack() {
        int[] hits = new int[Goat.randomNumber(3, 5)];
        for(int i=0; i<hits.length; i++) {
            hits[i] = Goat.randomNumber(minAttack, maxAttack);
        }
        return new Attack("Magic Missiles", hits, type);
    }

    @Override
    public void attacked(Attack attack) {
        double adjust = 1;
        if(attack.getType() == DamageType.MAGICAL) {
            adjust = 0.75;
        } else if(attack.getType() == DamageType.PHYSICAL) {
            adjust = 1.25;
        }

        for(int hit : attack.getHits()) {
            currentHP -= hit;
        }

        currentHP = currentHP >= 0 ? currentHP : 0;
    }

    @Override
    public void heal(int amount) {
        currentHP += amount;
        currentHP = currentHP <= maxHP ? currentHP : maxHP;
    }

    @Override
    public boolean isConscious() {
        return currentHP > 0;
    }
}
