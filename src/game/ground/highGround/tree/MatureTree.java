package game.ground.highGround.tree;

import engine.positions.Location;
import game.actors.enemies.Koopa;
import game.ground.LowGround.Dirt;

public class MatureTree extends Tree {
    /**
     * Constructor.
     */
    public MatureTree() {
        super('T');
        name = "Mature Tree";
        nextStage = null;
        jumpSuccessRate = 70;
        fallDamage = 30;
    }

    /**
     * This method is called every tick to simulate the growth of the tree.
     * It increments the age of the tree and grows it to the next stage if it is old enough.
     * It also has a 15% chance of spawning a Koopa at the location of the tree.
     * It also spawns a sprout every 5 ticks if there is a valid location to spawn it.
     *
     * @param location the location of the tree
     */
    @Override
    public void tick(Location location) {
        // 15% chance of spawning a Koopa
        if (rand.nextInt(100) < 15 && !location.containsAnActor()) {
            location.addActor(new Koopa());
            return;
        }
        // Every 5 ticks, spawn a sprout if there is a valid location
        if (age % 5 == 0){
            // Keep trying to spawn a sprout at a valid location without an actor
            while (true) {
                Location sproutLocation = super.getRandSurroundingLocation(location, false);
                // if no valid location stop trying to spawn a sprout
                if (sproutLocation == null ){
                    break;
                // if there is a valid location, spawn the sprout
                } else if (!sproutLocation.containsAnActor()) {
                    sproutLocation.setGround(new SproutTree());
                    break;
                }
            }
        }
        // 20% chance to wither and die (becoming dirt)
        if (rand.nextInt(100) < 20) {
            location.setGround(new Dirt());
            return;
        }
        // Normal growth
        super.tick(location);
    }
}

