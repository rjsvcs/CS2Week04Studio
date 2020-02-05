package lecture;

public class Fighter extends CommonGoat {
    // no magic numbers! use constants.
    private static final int BASE_HP = 150;

    public Fighter(String name) {
        super(name, BASE_HP);
    }

    @Override
    public Attack attack() {
        int[] hits = new int[1];
        hits[0] = Goat.randomNumber(15, 35);
        return new Attack("Cleave", hits, Damage.PHYSICAL);
    }

    @Override
    public void attacked(Attack attack) {
        double modifier = 1.0;
        if(attack.getType() == Damage.PHYSICAL) {
            modifier = 0.75;
        } else if(attack.getType() == Damage.MAGICAL) {
            modifier = 1.25;
        }
        handleAttack(attack, modifier);
    }
}
