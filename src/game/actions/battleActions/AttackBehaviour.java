package game.actions.battleActions;

import engine.actions.Action;
import engine.actions.MoveActorAction;
import engine.actors.Actor;
import engine.positions.Exit;
import engine.positions.GameMap;
import engine.positions.Location;
import game.actions.Behaviour;


public class AttackBehaviour implements Behaviour {
    protected Actor target;
    public AttackBehaviour(Actor target){
        this.target = target;
    }
    @Override
    public Action getAction(Actor actor, GameMap map) {
        // no action if both actor and target are not in the same map
        if (!map.contains(target) || !map.contains(actor)){
            return null;
        }

        Location here = map.locationOf(actor);
        Location there = map.locationOf(target);

        if (distance(here, there) <= 1){
            for (Exit exit : here.getExits()){
                // check if target is within range
                if (exit.getDestination() == there){
                    return new AttackAction(target, exit.getName());
                }
            }
        }

        for(Exit exit : here.getExits()){
            if (exit.getDestination().canActorEnter(actor)){
                return new MoveActorAction(exit.getDestination(), exit.getName());
            }
        }

        return null;
    }

    private int distance(Location here, Location there) {
        return Math.abs(here.x() - there.x()) + Math.abs(here.y() - there.y());
    }
}
