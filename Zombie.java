package worldSimulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zombie extends Creature {

	private Random rd;
	
	/**
	 * constructor
	 * creates a zombie creature
	 * @param seed - random seed for zombie to use while moving and killing humans
	 */
	public Zombie(long seed) {
		rd = new Random(seed);
	}
	/**
	 * makes zombie move
	 * zombie moves only if there are no more humans in this cell
	 * zombie moves to random neighbour cell
	 */
	@Override
	public void move() {
		if (humanList().size() < 1) {
			World myWorld = (getCurrentCell()).getWorld();
			List<Cell> neighbours = myWorld.getNeighbours(getCurrentCell());
			int movingCell = rd.nextInt(8);
			moveTo(neighbours.get(movingCell));
		}
		
	}

	/**
	 * makes zombie kill a human, if there are any in this cell
	 * chooses human randomly
	 * if there are no more humans, does nothing
	 */
	@Override
	public void act() {
		List<Human> humans = humanList();
		if (humans.size() > 0) {
			int k = rd.nextInt(humans.size());
			Human chosen = humans.get(k);
			getCurrentCell().changeWealth(chosen.getWealth());
			chosen.die();
		}
		
	}
	/**
	 * makes a list of humans living on this cell
	 * @return the list of humans
	 */
	private List<Human> humanList(){
		List<Creature> creatures = getCurrentCell().getCreatures();
		List<Human> humans = new ArrayList<Human>();
		for (Creature c : creatures) {
			if (c instanceof Human) {
				humans.add((Human) c);
			}
		}
		return humans;
	}

}
