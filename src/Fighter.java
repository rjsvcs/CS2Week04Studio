public class Fighter extends CommonGoat {
    // no magic numbers! use constants.
    private static final int BASE_HP = 150;
    private static final int MIN_ATTACK = 15;
    private static final int MAX_ATTACK = 35;

    public Fighter(String name) {
        super(name, BASE_HP, MIN_ATTACK, MAX_ATTACK);
    }

    @Override
    public Attack attack() {
        int[] hits = new int[1];
        hits[0] = Goat.randomNumber(getMinAttack(), getMaxAttack());
        return new Attack("Cleave", hits, Damage.PHYSICAL);
    }

    @Override
    public void attacked(Attack attack) {
        double adjust = 1;
        if(attack.getType() == Damage.PHYSICAL) {
            adjust = 0.75;
        } else if(attack.getType() == Damage.MAGICAL) {
            adjust = 1.25;
        }

        for(int hit : attack.getHits()) {
            harm((int)(hit * adjust));
        }
    }
}
