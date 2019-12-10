package com.toyrobot.common;

public enum Direction {

	NORTH(0,1), EAST(1,0), SOUTH(0,-1), WEST(-1,0);
	
	private final int x;
	private final int y;
	
	private Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public final int getX() {
		return x;
	}
	
	public final int getY() {
		return y;
	}	
}
