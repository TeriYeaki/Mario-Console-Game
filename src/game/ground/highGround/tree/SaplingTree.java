package game.ground.highGround.tree;

import engine.items.Item;
import engine.positions.Location;
import game.items.Coin;

public class SaplingTree extends Tree {
    /**
     * Constructor.
     */
    public SaplingTree() {
        super('t');
        name = "Sapling Tree";
        nextStage = new MatureTree();
        jumpSuccessRate = 80;
        fallDamage = 20;
    }

    /**
     * This method is called every tick to simulate the growth of the sapling.
     * It increments the age of the sapling and grows it to the next stage if it is old enough.
     * It also has a 1 in 10 chance of increasing the value of the coins by 20 that the tree will drop when it is
     * cut down.
     *
     * @param location the location of the tree
     */
    @Override
    public void tick(Location location) {
        // 1 in 10 chance of increasing the value of the coins by 20
        if (rand.nextInt(100) < 10) {
            // If there is a valid location, spawn the coins a
            while (true) {
                Location dropLocation = super.getRandSurroundingLocation(location, true);
                if (dropLocation != null){
                    // If there are already coins at the location, increase the value of the coins by 20
                    for (Item item : dropLocation.getItems()) {
                        if (item instanceof Coin) {
                            ((Coin) item).addValue(20);
                            return;
                        }
                    }
                    // If there are no coins at the location, spawn a new coins
                    dropLocation.addItem(new Coin(20));
                    return;
                }
            }
        }
        // Normal growth
        super.tick(location);
    }
}
