package worldSimulation;

import java.util.ArrayList;
import java.util.List;

/**
 * world for living creatures
 * @author Emile
 *
 */
public class World {

	private final int width;
	private final int height;
	private Cell [][] myWorld;
	
	/**
	 * constructor
	 * @param w width of the world
	 * @param h height of the world
	 */
	public World(int w, int h) {
		width = w;
		height = h;
		myWorld = new Cell [height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				myWorld [i][j] = new Cell (this, j, i);
			}
		}
		
	}
	/**
	 * 
	 * @return width of the world
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * height of the world
	 * @return
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * gets the Cell of given coordinates
	 * @param x x coordinate
	 * @param y y coordinate
	 * @return the Cell object with these coordinates
	 */
	public Cell getCell(int x, int y) {
		if (x < 0 || x > width || y < 0 || y > height ) {
			throw new IllegalArgumentException ("Index out of bounds");
		}
		return myWorld[y][x];
	}
	/**
	 * gets the list of the neighbours of this cell
	 * @param c the given cell
	 * @return the list of neighbours
	 */
	public List<Cell> getNeighbours(Cell c) {
		int x = c.getX();
		int y = c.getY();
		List<Cell> neighbours = new ArrayList <Cell>();
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				int x2 = (x + j + width) % width;
				int y2 = (y + i + width) % width;
				if (width > 1 || height > 1) {
					if (!(x2 == x && y2 == y)) {
						neighbours.add(myWorld[y2][x2]);
					}
				} else {
					neighbours.add(myWorld[y2][x2]);
				}
			}
		}
		return neighbours;
		
	}
	/**
	 * 
	 * @return all the creatures living in this world
	 */
	public List<Creature> getCreatures() {
		List<Creature> inhabitants = new ArrayList<Creature>();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				inhabitants.addAll((myWorld[j][i]).getCreatures());
			}
		}
		return inhabitants;
	}
}
