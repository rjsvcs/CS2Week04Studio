package lecture;

public abstract class CommonGoat implements Goat {
    private String name;
    private int maxHP;
    private int currentHP;
    private int minAttack;
    private int maxAttack;

    public CommonGoat(String name, int maxHP, int minAttack, int maxAttack) {
        this.name = name;
        this.maxHP = maxHP;
        this.maxAttack = maxAttack;
        this.minAttack = minAttack;

        currentHP = maxHP;
    }

    @Override
    public String getName() {
        return name;
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

    @Override
    public void attacked(Attack attack) {
        for(int hit : attack.getHits()) {
            harm(hit);
        }
    }

    protected void harm(int amount) {
        currentHP -= amount;
        currentHP = currentHP >= 0 ? currentHP : 0;
    }

    protected int getMaxAttack() {
        return maxAttack;
    }

    protected int getMinAttack() {
        return minAttack;
    }
}
