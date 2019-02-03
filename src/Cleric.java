public class Cleric extends CommonGoat {
    // no magic numbers! use constants.
    private static final int BASE_HP = 150;
    private static final int MIN_ATTACK = 15;
    private static final int MAX_ATTACK = 35;

    public Cleric(String name) {
        super(name, BASE_HP, MIN_ATTACK, MAX_ATTACK);
    }

    @Override
    public Attack attack() {
        int[] hits = new int[1];
        hits[0] = Goat.randomNumber(getMinAttack(), getMaxAttack());
        return new Attack("Bell, Book & Candle", hits, DamageType.HOLY);
    }
}
