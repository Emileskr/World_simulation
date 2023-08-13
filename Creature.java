package worldSimulation;

public abstract class Creature {

	private  int dexterity = 1; // can I do this? if default dexterity of Creature class is 1??
	private Cell current = null;
	
	/**
	 * moves the creature to the new cell
	 * @param newCell - the cell the creature is moving to
	 */
	public final void moveTo(Cell newCell) { 
		current.removeCreature(this);
		current = newCell;
		current.addCreature(this);
		
	}
	/**
	 * 
	 * @return the current cell the creature is living on
	 */
	public final Cell getCurrentCell() {
		return current;
	}
	public abstract void move();
	
	public abstract void act();
	
	/**
	 * 
	 * @return the dexterity of this creature
	 */
	public int getDexterity() {
		return dexterity;
	}
	/**
	 * makes the creature die. Removes it from the current cell
	 */
	public final void die() {
		current.removeCreature(this);
		current = null; // is this ok? where should I remove the cell?
	}
	/**
	 * checks if the creature is still alive
	 * @return true if alive
	 */
	public final boolean isAlive() {
		if (current == null) {
			return false;
		} else {
			return true;
		}
	}
}
