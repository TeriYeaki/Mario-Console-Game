package game.items;

import engine.actors.Actor;
import engine.items.DropItemAction;
import engine.items.Item;
import engine.items.PickUpItemAction;
import game.actions.interactionActions.PickUpCoinsAction;

public class Coin extends Item {
    /**
     * Constructor.
     */
    private int value = 0;
    public Coin(int value) {
        super("$"+value+" Coin", '$', true);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addValue(int value) {
        this.value += value;
    }

    /**
     * Create and return an action to pick this Item up.
     * If this Item is not portable, returns null.
     *
     * @return a new PickUpItemAction if this Item is portable, null otherwise.
     */
    @Override
    public PickUpItemAction getPickUpAction(Actor actor) {
        return new PickUpCoinsAction(this);
    }

    /**
     * Create and return an action to drop this Item.
     * If this Item is not portable, returns null.
     * @return a new DropItemAction if this Item is portable, null otherwise.
     */
    @Override
    public DropItemAction getDropAction(Actor actor) {
        return null;
    }





}
