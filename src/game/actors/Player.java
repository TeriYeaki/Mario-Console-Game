package game.actors;

import engine.actions.Action;
import engine.actions.ActionList;
import engine.actors.Actor;
import engine.displays.Display;
import engine.positions.GameMap;
import engine.displays.Menu;
import game.Status;

/**
 * Class representing the Player.
 */
public class Player extends Actor  {

	private final Menu menu = new Menu();
	private int coinWallet = 0;

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Status.CAN_JUMP);
		this.addCapability(Status.CAN_COLLECT_COINS);
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	@Override
	public char getDisplayChar(){
		return this.hasCapability(Status.TALL) ? Character.toUpperCase(super.getDisplayChar()): super.getDisplayChar();
	}

	/**
	 * Add coins to the player's inventory.
	 *
	 * @param value the number of coins to add
	 */
	public void addCoins(int value) {
		coinWallet += value;
	}

}
