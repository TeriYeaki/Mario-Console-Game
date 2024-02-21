package game.actions.battleActions;

import engine.actions.Action;
import engine.actions.ActionList;
import engine.actors.Actor;
import engine.items.Item;
import engine.positions.GameMap;
import engine.weapons.Weapon;

import java.util.Random;

public class GoombaAttackAction extends AttackAction{
    private final Random random = new Random();
    /**
     * Constructor.
     *
     * @param target    the Actor to attack
     * @param direction the direction of incoming attack
     */
    public GoombaAttackAction(Actor target, String direction) {
        super(target, direction);
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        int damage = 10;
        if (random.nextInt(100) <= 50) {
            target.hurt(damage);
            return actor + " kicks " + target + " for "+ damage +" damage";
        } else {
            return actor + " kicks and misses " + target;
        }
    }
}
