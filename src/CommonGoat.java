import java.util.Random;

public class CommonGoat implements Goat {
    private String name;
    private int maxHP;
    private int currentHP;
    private int maxAttack;
    private int minAttack;
    private DamageType type;

    public CommonGoat(String name, int maxHP, int maxAttack, int minAttack,
                      DamageType type) {
        this.name = name;
        this.maxHP = maxHP;
        this.maxAttack = maxAttack;
        this.minAttack = minAttack;
        this.type = type;

        currentHP = maxHP;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Attack attack() {
        return null;
    }

    @Override
    public void attacked(Attack attack) {

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

    protected int getMaxAttack() {
        return maxAttack;
    }

    protected int getMinAttack() {
        return minAttack;
    }

    protected DamageType getType() {
        return type;
    }
}
