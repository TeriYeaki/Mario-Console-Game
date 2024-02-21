package game.actions.movementActions;

import engine.actions.Action;
import engine.actions.MoveActorAction;
import engine.actors.Actor;
import engine.positions.GameMap;
import engine.positions.Location;
import game.Status;
import game.ground.highGround.HighGround;

import java.util.Random;

public class JumpAction extends MoveActorAction {

    private final int jumpSuccessChance;
    private final int fallDamage;
    private final Random random = new Random();
    public JumpAction(Location targetLocation, String direction, int jumpSuccessChance,int fallDamage) {
        super(targetLocation, direction);
        this.jumpSuccessChance = jumpSuccessChance;
        this.fallDamage = fallDamage;
    }

    /**
     * Allow the Actor to jump on top of high ground.
     * Overrides Action.execute()
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of the Action suitable for the menu
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        // Check if actor can jump on top of the ground
        if (!(actor.hasCapability(Status.CAN_JUMP))) {
            return actor + " cannot jump on top of " + moveToLocation.getGround().toString() + ".";
        }
        // if the jump is successful, execute the move action or if actor has Super Mushroom Effect, jumpSuccessChance is 100%
        if (random.nextInt(100) < jumpSuccessChance || actor.hasCapability(Status.SUPER_MUSHROOM_EFFECT)) {
            return super.execute(actor, map);
        // if the jump fails, the actor takes fall damage
        } else {
            actor.hurt(fallDamage);
            return this.failDescription(actor);
        }
    }

    /**
     * Returns a description of jump action to display in the menu.
     *
     * @param actor The actor performing the action.
     * @return a String description of the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " jumps " + direction + " on top of " + ((HighGround) moveToLocation.getGround()).getName() + ".";
    }

    public String failDescription(Actor actor) {
        return actor + " fails to jump and takes " + fallDamage + " damage.";
    }

    /**
     * Returns the key used in the menu to trigger this Action.
     * Using the direction to assign the same hotkey as the movement direction hotkey.
     *
     * @return The key we use for this Action in the menu, or null to have it assigned for you.
     */
    @Override
    public String hotkey() {
        // Use direction to assign hotkey
        return switch (direction) {
            case "North" -> "8";
            case "North-East" -> "9";
            case "East" -> "6";
            case "South-East" -> "3";
            case "South" -> "2";
            case "South-West" -> "1";
            case "West" -> "4";
            case "North-West" -> "7";
            default -> null;
        };

    }
}
