public class Thief extends CommonGoat {
    // no magic numbers! use constants.
    private static final int BASE_HP = 125;
    private static final int MIN_ATTACK = 10;
    private static final int MAX_ATTACK = 20;
    private static final int MIN_HITS = 1;
    private static final int MAX_HITS = 3;

    public Thief(String name) {
        super(name, BASE_HP, MIN_ATTACK, MAX_ATTACK);
    }

    @Override
    public Attack attack() {
        int[] hits = new int[Goat.randomNumber(MIN_HITS, MAX_HITS)];
        for(int i=0; i<hits.length; i++) {
            int hit = Goat.randomNumber(getMinAttack(), getMaxAttack());
            int crit = Goat.randomNumber(1, 100);
            hits[i] = crit > 75 ? hit * 2 : hit;
        }
        return new Attack("Stabbity-Stab", hits, Damage.PHYSICAL);
    }
}
