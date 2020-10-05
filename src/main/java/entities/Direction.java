package entities;

public class Direction extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7063184170999721077L;
	String direction;

	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Direction [direction=" + direction + "]";
	}
	
}
