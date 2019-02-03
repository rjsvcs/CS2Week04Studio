import java.util.Random;

public interface Goat {
    public static final Random RNG = new Random();

    public static int randomNumber(int min, int max) {
        int bound = max - min + 1;
        int random = RNG.nextInt(bound);
        return random + min;
    }

    String getName();

    Attack randomAttack();

    void takeDamage(Attack attack);

    void heal(int amount);
}
