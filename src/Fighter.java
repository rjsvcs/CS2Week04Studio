public class Fighter implements Goat {
    private String name;
    private int maxHP;
    private int currentHP;

    public Fighter(String name) {
        this.name = name;
        maxHP = 150;
        currentHP = maxHP;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Attack attack() {
        int[] hits = new int[1];
        hits[0] = Goat.randomNumber(15, 35);
        return new Attack("Cleave", hits, DamageType.PHYSICAL);
    }

    @Override
    public void attacked(Attack attack) {
        double adjust = 1;
        if(attack.getType() == DamageType.PHYSICAL) {
            adjust = 0.75;
        } else if(attack.getType() == DamageType.MAGICAL) {
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
