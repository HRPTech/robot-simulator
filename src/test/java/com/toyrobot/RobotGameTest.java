package com.toyrobot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;

import com.toyrobot.common.Direction;
import com.toyrobot.common.Position;
import com.toyrobot.components.Board;
import com.toyrobot.components.Robot;
import com.toyrobot.exceptions.ToyException;

public class RobotGameTest {

	@Test
	public void evaluateAndTestValidPlaceCommand() {
		Robot robot = new Robot();
		Board board = new Board(5, 5);

		RobotGame game = new RobotGame(board, robot);

		game.evaluateAndExecute("PLACE 0,0,NORTH");

		Position position = robot.getPosition();
		assertEquals(0, position.getX());
		assertEquals(0, position.getY());
		assertEquals(Direction.NORTH, position.getDirection());
	}

	@Test
	public void evaluateAndTestInValidPlaceCommand() {
		Robot robot = new Robot();
		Board board = new Board(5, 5);

		RobotGame game = new RobotGame(board, robot);

		game.evaluateAndExecute("PLACE 7,7,NORTH");

		Position position = robot.getPosition();
		assertNull(position);
	}

	@Test
	public void evaluateAndTestMoveCommand() {
		Robot robot = new Robot();
		Board board = new Board(5, 5);

		RobotGame game = new RobotGame(board, robot);

		game.evaluateAndExecute("PLACE 0,0,NORTH");

		Position position = robot.getPosition();
		assertEquals(0, position.getX());
		assertEquals(0, position.getY());
		assertEquals(Direction.NORTH, position.getDirection());

		Optional<String> result = game.evaluateAndExecute("MOVE");
		assertFalse(result.isPresent());
		position = robot.getPosition();
		assertEquals(0, position.getX());
		assertEquals(1, position.getY());
		assertEquals(Direction.NORTH, position.getDirection());
	}

	@Test
	public void evaluateAndTestMoveInvalidCommand() {
		Robot robot = new Robot();
		Board board = new Board(5, 5);

		RobotGame game = new RobotGame(board, robot);

		game.evaluateAndExecute("PLACE 5,5,NORTH");

		Position position = robot.getPosition();
		assertEquals(5, position.getX());
		assertEquals(5, position.getY());
		assertEquals(Direction.NORTH, position.getDirection());

		Optional<String> result = game.evaluateAndExecute("MOVE");
		assertFalse(result.isPresent());
		position = robot.getPosition();
		// nothing happens as its already at the edge of the board
		assertEquals(5, position.getX());
		assertEquals(5, position.getY());
		assertEquals(Direction.NORTH, position.getDirection());

	}

	@Test
	public void evaluateAndTestLeftCommand() {
		Robot robot = new Robot();
		Board board = new Board(5, 5);

		RobotGame game = new RobotGame(board, robot);

		game.evaluateAndExecute("PLACE 0,0,NORTH");

		Position position = robot.getPosition();
		assertEquals(0, position.getX());
		assertEquals(0, position.getY());
		assertEquals(Direction.NORTH, position.getDirection());

		Optional<String> result = game.evaluateAndExecute("LEFT");
		assertFalse(result.isPresent());
		position = robot.getPosition();
		assertEquals(0, position.getX());
		assertEquals(0, position.getY());
		assertEquals(Direction.WEST, position.getDirection());

	}

	@Test
	public void evaluateAndTestRightCommand() {
		Robot robot = new Robot();
		Board board = new Board(5, 5);

		RobotGame game = new RobotGame(board, robot);

		game.evaluateAndExecute("PLACE 0,0,NORTH");

		Position position = robot.getPosition();
		assertEquals(0, position.getX());
		assertEquals(0, position.getY());
		assertEquals(Direction.NORTH, position.getDirection());

		Optional<String> result = game.evaluateAndExecute("RIGHT");
		assertFalse(result.isPresent());
		position = robot.getPosition();
		assertEquals(0, position.getX());
		assertEquals(0, position.getY());
		assertEquals(Direction.EAST, position.getDirection());

	}

	@Test
	public void evaluateAndTestReportCommand() {
		Robot robot = new Robot();
		Board board = new Board(5, 5);

		RobotGame game = new RobotGame(board, robot);

		game.evaluateAndExecute("PLACE 0,0,NORTH");

		Position position = robot.getPosition();
		assertEquals(0, position.getX());
		assertEquals(0, position.getY());
		assertEquals(Direction.NORTH, position.getDirection());

		Optional<String> result = game.evaluateAndExecute("REPORT");
		assertTrue(result.isPresent());

		assertEquals("Output:0,0,NORTH", result.get());
	}

	@Test
	public void evaluateAndTestReportWithNoPosition() {
		Robot robot = new Robot();
		Board board = new Board(5, 5);

		RobotGame game = new RobotGame(board, robot);

		Optional<String> result = game.evaluateAndExecute("REPORT");
		assertFalse(result.isPresent());
	}

	@Test(expected=ToyException.class)
	public void evaluateAndTestReportWithInvalidCommand() {
		Robot robot = new Robot();
		Board board = new Board(5, 5);

		RobotGame game = new RobotGame(board, robot);

		game.evaluateAndExecute("TEST");
	}
	
	@Test(expected=ToyException.class)
	public void evaluateAndTestPlaceWithInvalidCommand() {
		Robot robot = new Robot();
		Board board = new Board(5, 5);

		RobotGame game = new RobotGame(board, robot);

		game.evaluateAndExecute("PLACE X,Y,F");
	}
}
