package game.ground.highGround.tree;

import engine.positions.Location;
import game.actors.enemies.Goomba;

public class SproutTree extends Tree {

    /**
     * Constructor.
     *
     */
    public SproutTree() {
        super('+');
        name = "Sprout Tree";
        nextStage = new SaplingTree();
        jumpSuccessRate = 90;
        fallDamage = 10;
    }

    /**
     * This method is called every tick to simulate the growth of the sprout.
     * It increments the age of the sprout and grows it to the next stage if it is old enough.
     * It also has a 1 in 10 chance of spawning a Goomba at the location of the sprout.
     *
     * @param location the location of the tree
     */
    @Override
    public void tick(Location location) {
        // 1 in 10 chance of spawning a Goomba
        if (rand.nextInt(100) < 10 && !location.containsAnActor()) {
            // Spawn Goomba at the location of the tree
            location.addActor(new Goomba());
            return;
        }
        // Normal growth
        super.tick(location);
    }
}
