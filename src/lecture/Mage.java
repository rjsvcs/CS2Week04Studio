package lecture;

public class Mage extends CommonGoat {
    // no magic numbers! use constants.
    private static final int BASE_HP = 100;
    private static final int MIN_ATTACK = 6;
    private static final int MAX_ATTACK = 12;
    private static final int MIN_HITS = 3;
    private static final int MAX_HITS = 5;

    public Mage(String name) {
        super(name, BASE_HP, MIN_ATTACK, MAX_ATTACK);
    }

    @Override
    public Attack attack() {
        int[] hits = new int[Goat.randomNumber(MIN_HITS, MAX_HITS)];
        for(int i=0; i<hits.length; i++) {
            hits[i] = Goat.randomNumber(getMinAttack(), getMaxAttack());
        }
        return new Attack("Magic Missiles", hits, Damage.MAGICAL);
    }

    @Override
    public void attacked(Attack attack) {
        double adjust = 1;
        if(attack.getType() == Damage.MAGICAL) {
            adjust = 0.75;
        } else if(attack.getType() == Damage.PHYSICAL) {
            adjust = 1.25;
        }

        for(int hit : attack.getHits()) {
            harm((int)(hit * adjust));
        }
    }
}
