package com.toyrobot.components;

import static org.junit.Assert.*;

import org.junit.Test;

import com.toyrobot.common.Direction;
import com.toyrobot.common.Position;

public class BoardTest {

	@Test
	public void testValidPosition() {
		Board board = new Board(5, 5);
		assertTrue(board.isValidPosition(new Position(0, 0, Direction.NORTH)));
		assertTrue(board.isValidPosition(new Position(1, 0, Direction.EAST)));
		assertTrue(board.isValidPosition(new Position(0, 5, Direction.SOUTH)));
		assertTrue(board.isValidPosition(new Position(5, 0, Direction.WEST)));
	}
	
	@Test
	public void testInValidPosition() {
		Board board = new Board(5, 5);
		assertFalse(board.isValidPosition(new Position(10, 0, Direction.NORTH)));
		assertFalse(board.isValidPosition(new Position(10, 10, Direction.SOUTH)));
		assertFalse(board.isValidPosition(new Position(-1, 0, Direction.NORTH)));
		assertFalse(board.isValidPosition(new Position(0, -1, Direction.WEST)));
		assertFalse(board.isValidPosition(new Position(5, -10, Direction.EAST)));		
	}
	
	@Test
	public void testNullPosition() {
		Board board = new Board(5, 5);
		assertFalse(board.isValidPosition(null));		
	}

}
