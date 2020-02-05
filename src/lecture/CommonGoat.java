package lecture;

public abstract class CommonGoat implements Goat {
    private String name;
    private int maxHitPoints;
    private int currentHitPoints;

    public CommonGoat(String name, int maxHitPoints) {
        this.name = name;
        this.maxHitPoints = maxHitPoints;

        currentHitPoints = maxHitPoints;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void heal(int amount) {
        currentHitPoints += amount;
        currentHitPoints = Math.min(currentHitPoints, maxHitPoints);
    }

    @Override
    public boolean isConscious() {
        return currentHitPoints > 0;
    }

    protected void handleAttack(Attack attack, double modifier) {
        for(int hit : attack.getHits()) {
            currentHitPoints -= (hit * modifier);
        }
        currentHitPoints = Math.max(currentHitPoints, 0);
    }
}
