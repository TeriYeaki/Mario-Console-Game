package game.ground.highGround.tree;

import engine.positions.Ground;
import engine.positions.Location;
import game.ground.LowGround.Dirt;
import game.ground.highGround.HighGround;

import java.util.ArrayList;
import java.util.Random;

public abstract class Tree extends HighGround {

    /**
     * Constructor.
     *
     */
    protected int age; // age of the tree
    protected Ground nextStage; // the next stage of the tree
    protected Random rand; // random number generator

    /**
     * Constructor.
     *
     * @param displayChar the character to display
     */
    public Tree(char displayChar) {
        super(displayChar);
        age = 0;
        rand = new Random();

    }


    /**
     * This method is called every tick to simulate the growth of the tree.
     * It increments the age of the tree and grows it to the next stage if it is old enough.
     *
     * @param location the location of the tree
     */
    @Override
    public void tick(Location location) {
        age++;
        growToNextStage(location);
    }

    public void growToNextStage(Location location) {
        if (age > 10 && nextStage != null) {
            location.setGround(nextStage);
        }
    }

    /**
     * This method returns a random valid location around the tree.
     * It returns null if there are no valid locations.
     *
     * @param location the location of the tree
     * @return a random location around the tree to spawn a sprout
     */
    protected Location getRandSurroundingLocation(Location location, boolean includeTreeLocation) {
        // Create an array list to store all valid locations
        ArrayList<Location> validLocations = new ArrayList<>();
        // Iterate through all locations around the tree
        for (int x = location.x() - 1; x <= location.x() + 1; x++) {
            for (int y = location.y() - 1; y <= location.y() + 1; y++) {
                // ignore the current location of the tree itself if specified
                if (!includeTreeLocation && x == location.x() && y == location.y()) {
                    continue;
                }
                Location potentialLocation = location.map().at(x, y);
                // Check if the potential location is within the map and is dirt
                if (location.map().getXRange().contains(x) && location.map().getYRange().contains(y) &&
                        potentialLocation.getGround() instanceof Dirt) {
                    validLocations.add(potentialLocation);
                }
            }
        }
        // Return null if there are no valid locations
        if (validLocations.isEmpty()) {
            return null;
        }
        // Return a random valid location
        return validLocations.get(rand.nextInt(validLocations.size()));
    }
}
