import java.util.Random;

public abstract class CommonGoat implements Goat {
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
}
