package worldSimulation;

import java.util.Collections;
import java.util.List;

public class Human extends Creature {

	private int wealth;
	private int dexterity = 2;
	
	/**
	 * constructor
	 * creates the human creature
	 */
	public Human () {
		wealth = 20;
	}
	
	/**
	 * makes human move if there is better neighbour cell than the current cell
	 */
	@Override
	public void move() {
		World myWorld = (getCurrentCell()).getWorld();
		List<Cell> neighbours = myWorld.getNeighbours(getCurrentCell());
		Collections.sort(neighbours);
		if ((getCurrentCell()).compareTo(neighbours.get(0)) > 0 ) {
			moveTo(neighbours.get(0));
		}
				
	}

	/**
	 * makes the human pick up wealth from the cell. 
	 * Human looses 2 wealth units when doing so
	 */
	@Override
	public void act() {
		wealth -= 2;
		int cellWealth = (getCurrentCell()).getWealth();
		if (cellWealth >=3) {
			wealth += 3;
			(getCurrentCell()).changeWealth(-3);
		} else {
			wealth += cellWealth;
			(getCurrentCell()).changeWealth(-cellWealth);
		}
		if (wealth < 1) {
			die();
		}
	}
	/**
	 * returns the dexterity of the human
	 */
	@Override
	public int getDexterity () {
		return dexterity;
	}

	/**
	 * 
	 * @return the wealth this human has
	 */
	public int getWealth() {
		return wealth;
	}

}
