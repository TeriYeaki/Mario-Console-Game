package game.actions.interactionActions;

import engine.actions.Action;
import engine.actors.Actor;
import engine.items.PickUpItemAction;
import engine.positions.GameMap;
import game.actors.Player;
import game.items.Coin;

public class PickUpCoinsAction extends PickUpItemAction {

    /**
     * Constructor.
     *
     * @param item the item to pick up
     */
    private final Coin coin;
    public PickUpCoinsAction(Coin coin) {
        super(coin);
        this.coin = coin;
    }

    /**
     * Add the item to the actor's inventory.
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a suitable description to display in the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.locationOf(actor).removeItem(coin);
        ((Player) actor).addCoins(coin.getValue());
        return menuDescription(actor);
    }
}
