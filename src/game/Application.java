package game;

import java.util.Arrays;
import java.util.List;

import engine.actors.Actor;
import engine.displays.Display;
import engine.positions.FancyGroundFactory;
import engine.positions.GameMap;
import engine.positions.World;
import game.actors.Player;
import game.ground.LowGround.Dirt;
import game.ground.LowGround.Floor;
import game.ground.highGround.tree.MatureTree;
import game.ground.highGround.tree.SaplingTree;
import game.ground.highGround.tree.SproutTree;
import game.ground.highGround.wall.Wall;


/**
 * The main class for the Mario World game.
 *
 */
public class Application {

	public static void main(String[] args) {
		// Create a new world
		World world = new World(new Display());

		// Create a new ground factory and add all the different types of ground
		FancyGroundFactory groundFactory =
				new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new SproutTree(), new SaplingTree(), new MatureTree());

		// Create a base map
		List<String> map = Arrays.asList(
			"..........................................##..........+.........................",
			"............+............+..................#...................................",
			"............................................#...................................",
			".............................................##......................+..........",
			"...............................................#................................",
			"................................................#...............................",
			".................+................................#.............................",
			".................................................##.............................",
			"................................................##..............................",
			".........+..............................+#____####.................+............",
			".......................................+#_____###++.............................",
			".......................................+#______###..............................",
			"........................................+#_____###..............................",
			"........................+........................##.............+...............",
			"...................................................#............................",
			"....................................................#...........................",
			"...................+.................................#..........................",
			"......................................................#.........................",
			".......................................................##.......................");

		//Add legend for the map
		//String legend = "Legend: $ coin, +sprout, t sapling, T tree,  g Goomba, K Koopa, m Mario, O Toad, #wall, . dirt, _ floor, ^ super mushroom.";

		// Create a new game map and add it to the world
		GameMap gameMap = new GameMap(groundFactory, map);
		world.addGameMap(gameMap);

		// Add the player to the map
		Actor mario = new Player("Mario", 'm', 100);
		world.addPlayer(mario, gameMap.at(42, 10));

		// Start the game world
		world.run();

	}
}
