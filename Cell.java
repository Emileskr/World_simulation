package worldSimulation;

import java.util.ArrayList;
import java.util.List;

public class Cell implements Comparable<Cell>{

	public static final int MAX_WEALTH = 100;
	private int wealth;
	private int xcoord;
	private int ycoord;
	private World myWorld;
	private ArrayList<Creature> creatures;
	
	/**
	 * constructor
	 * @param w - world which contains this cell
	 * @param x - x coordinate of the cell
	 * @param y - y coordinate of the cell
	 */
	public Cell(World w, int x, int y) {
		wealth = 0;
		myWorld = w;
		xcoord = x;
		ycoord = y;
		creatures = new ArrayList<Creature>();
		
	}
	/**
	 * 
	 * @return the x coordinate of the cell
	 */
	public int getX() {
		return xcoord;
	}
	/**
	 * 
	 * @return the y coordinate of the cell
	 */
	public int getY() {
		return ycoord;
	}
	/**
	 * 
	 * @return the world which part this cell is of
	 */
	public World getWorld() {
		return myWorld;
	}
	/**
	 * adds creature to this cell
	 * @param c creature to add
	 */
	public void addCreature(Creature c) {
		creatures.add(c);
	}
	/**
	 * removes a creature from this cell
	 * @param c - the creature to remove;
	 */
	public void removeCreature(Creature c) {
		creatures.remove(c);
	}
	/**
	 * 
	 * @return the list of creatures living on this cell
	 */
	public List<Creature> getCreatures() {
		List<Creature> c = new ArrayList<Creature>(creatures);
		return c;
		
	}
	/**
	 * 
	 * @return the wealth of this cell
	 */
	public int getWealth() {
		return wealth;
	}
	/**
	 * changes the wealth of this cell
	 * @param amount - the amount the wealth has to change
	 */
	public void changeWealth(int amount) {
		if (wealth + amount < 0) {
			throw new IllegalArgumentException("amount is below minimum");
		}
		if (wealth + amount > MAX_WEALTH) {
			wealth = MAX_WEALTH;
		} else {
			wealth += amount;
		}
	}
	/**
	 * compares two cells
	 * @param o the cell to compare to
	 * @return the preferable cell: the less creatures is better; the more wealth is better;
	 */
	@Override
	public int compareTo(Cell o) {		
		
	 if (this.getCreatures().size()!=o.getCreatures().size())
		 return this.getCreatures().size()-o.getCreatures().size();
		else return o.getWealth()-this.getWealth();
	}
	
}
