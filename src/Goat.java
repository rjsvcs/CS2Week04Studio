import java.util.Random;

/**
 * The interface that defines behavior common to all Goat characters.
 */
public interface Goat {
    /**
     * Shared random number generator used to, well, generate random numbers.
     */
    public static final Random RNG = new Random();

    /**
     * Helper method that generates a random number in the specified range.
     * @param min The minimum value (inclusive).
     * @param max The maximum value (inclusive).
     * @return The randomly generated number.
     */
    public static int randomNumber(int min, int max) {
        int bound = max - min + 1;
        int random = RNG.nextInt(bound);
        return random + min;
    }

    /**
     * Returns the name of the {@link Goat}
     * @return The {@link Goat Goat's} name.
     */
    String getName();

    /**
     * Creates and returns an {@link Attack}.
     * @return An {@link Attack}
     */
    Attack attack();

    /**
     * Called when the {@link Goat} has been attacked by an enemy character.
     *
     * @param attack The enemy character's {@link Attack}.
     */
    void attacked(Attack attack);

    /**
     * Increases the {@link Goat Goat's} hit points by the specified amount.
     * The {@link Goat Goat's} hit points should not exceed the maximum.
     *
     * @param amount The amount by which the {@link Goat Goat's} hit points
     *               should be increased.
     */
    void heal(int amount);

    /**
     * Returns true if the {@link Goat} has at least 1 hit point remaining.
     *
     * @return True if the {@link Goat} has at least 1 hit point remaining,
     * false if the {@link Goat} has been knocked out.
     *
     */
    boolean isConscious();
}
