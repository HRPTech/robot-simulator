package com.toyrobot.common;

public class Position {

	private final int x;
	private final int y;
	private Direction direction;

	public Position(int x, int y, Direction direction) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public final int getX() {
		return x;
	}

	public final int getY() {
		return y;
	}

	public final Direction getDirection() {
		return direction;
	}
	
	public Position move(){
		return new Position(x+direction.getX(), y+ direction.getY(), this.direction);
	}
	
	public Position moveRight(){
		switch(this.direction){
		case NORTH:
			direction = Direction.EAST;
			break;
		case EAST:
			direction = Direction.SOUTH;
			break;
		case SOUTH:
			direction = Direction.WEST;
			break;
		case WEST:
			direction = Direction.NORTH;
			break;
		}
		return this;
	}
	
	public Position moveLeft(){
		switch(this.direction){
		case NORTH:
			direction = Direction.WEST;
			break;
		case EAST:
			direction = Direction.NORTH;
			break;
		case SOUTH:
			direction = Direction.EAST;
			break;
		case WEST:
			direction = Direction.SOUTH;
			break;
		}
		return this;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + ", direction=" + direction + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (direction != other.direction)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}		
}
