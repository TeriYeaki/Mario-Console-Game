package game.ground.highGround.wall;

import engine.actors.Actor;
import game.ground.highGround.HighGround;

public class Wall extends HighGround {

	public Wall() {
		super('#');
		name = "Wall";
		jumpSuccessRate = 80;
		fallDamage = 20;
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
