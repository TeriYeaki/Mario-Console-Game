package game.actors.enemies;

import engine.actions.Action;
import engine.actions.ActionList;
import engine.actions.DoNothingAction;
import engine.actors.Actor;
import engine.displays.Display;
import engine.positions.GameMap;
import game.Status;
import game.actions.Behaviour;
import game.actions.battleActions.AttackAction;
import game.actions.battleActions.AttackBehaviour;
import game.actions.idleActions.WanderBehaviour;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class EnemyActor extends Actor {
    protected boolean angered;
    protected final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public EnemyActor(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.ANGERED_BY_ATTACK);
        angered = false;
        this.behaviours.put(10, new WanderBehaviour());
    }

    /**
     * At the moment, we only make it can be attacked by Player.
     * You can do something else with this method.
     * @param otherActor the Actor that might perform an action.
     * @param direction String representing the direction of the other Actor
     * @param map current GameMap
     * @return list of actions
     * @see Status#HOSTILE_TO_ENEMY
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this,direction));
        }
        return actions;
    }

    /**
     * Figure out what to do next.
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Action actionListAction : actions) {
            if (actionListAction instanceof AttackAction) {
                anger(((AttackAction) actionListAction).getTarget());
                return actionListAction;
            }
        }

        for(Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    public void anger(Actor attacker){
        if(!angered){
            angered = true;
            behaviours.put(100, new AttackBehaviour(attacker));
        }
    }
}
