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
    public Attack randomAttack() {
        int[] hits = new int[randomNumber(3, 5)];
        for(int i=0; i<hits.length; i++) {
            hits[i] = randomNumber(minAttack, maxAttack);
        }
        return new Attack("Magic Missiles", hits, type);
    }

    @Override
    public void takeDamage(Attack attack) {

    }

    @Override
    public void heal(int amount) {

    }

    private int randomNumber(int min, int max) {
        int bound = max - min + 1;
        int random = RNG.nextInt(bound);
        return random + min;
    }
}
