package com.toyrobot.components;

import com.toyrobot.common.Position;

public class Board {
	private final int rows;
	private final int columns;

	public Board(int rows, int columns) {
		super();
		this.rows = rows;
		this.columns = columns;
	}

	public boolean isValidPosition(Position position) {
		if (position == null) {
			return false;
		}
		return !(position.getX() > this.columns || position.getX() < 0 || position.getY() > this.rows
				|| position.getY() < 0);
	}
}
