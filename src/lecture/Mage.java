package lecture;

public class Mage extends CommonGoat {

    public Mage(String name) {
        super(name, 100);
    }

    @Override
    public Attack attack() {
        int[] hits = new int[Goat.randomNumber(3, 5)];
        for(int i=0; i<hits.length; i++) {
            hits[i] = Goat.randomNumber(6, 12);
        }
        return new Attack("Magic Missiles", hits, Damage.MAGICAL);
    }

    @Override
    public void attacked(Attack attack) {
        double modifier = 1.0;
        if(attack.getType() == Damage.MAGICAL) {
            modifier = 0.75;
        } else if(attack.getType() == Damage.PHYSICAL) {
            modifier = 1.25;
        }
        handleAttack(attack, modifier);
    }
}
