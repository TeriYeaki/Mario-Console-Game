package game.ground.highGround;

import engine.actions.ActionList;
import engine.actors.Actor;
import engine.positions.Ground;
import engine.positions.Location;
import game.Status;
import game.actions.movementActions.JumpAction;

public abstract class HighGround extends Ground {
    protected int jumpSuccessRate;
    protected int fallDamage;

    protected String name;
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public HighGround(char displayChar) {
        super(displayChar);
    }

    /**
     * Returns an empty Action list.
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a new, empty collection of Actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actionList = new ActionList();
        if (actor.hasCapability(Status.CAN_JUMP) && !location.containsAnActor()){
            actionList.add(new JumpAction(location, direction, jumpSuccessRate, fallDamage));
        }
        return actionList;
    }

    /**
     * Override this to implement impassable terrain, or terrain that is only passable if conditions are met.
     *
     * @param actor the Actor to check
     * @return true
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    /**
     * Override this to implement terrain that blocks thrown objects but not movement, or vice versa
     * @return true
     */
    @Override
    public boolean blocksThrownObjects() {
        return true;
    }

    /**
     * Returns the name of the ground
     * @return the name of the ground
     */
    public String getName() {
    	return name;
    }

}
