package com.toyrobot.components;

import static org.junit.Assert.*;

import org.junit.Test;

import com.toyrobot.common.Direction;
import com.toyrobot.common.Position;

public class RobotTest {

	@Test
	public void testSetPosition() {
		Position position = new Position(0, 0, Direction.NORTH);
		Robot robot = new Robot();
		robot.setPosition(position);
		assertEquals(position, robot.getPosition());
	}

	@Test
	public void testMove() {
		Position position = new Position(0, 0, Direction.NORTH);
		Robot robot = new Robot();
		robot.setPosition(position);
		assertEquals(position, robot.getPosition());

		Position newPosition = new Position(1, 1, Direction.SOUTH);
		robot.move(newPosition);

		assertEquals(newPosition, robot.getPosition());
	}

	@Test
	public void testRotateLeft() {
		Position position = new Position(1, 1, Direction.NORTH);
		Robot robot = new Robot(position);
		assertEquals(position, robot.getPosition());

		robot.rotateLeft();
		assertEquals(new Position(1, 1, Direction.WEST), robot.getPosition());

		robot.rotateLeft();
		assertEquals(new Position(1, 1, Direction.SOUTH), robot.getPosition());

		robot.rotateLeft();
		assertEquals(new Position(1, 1, Direction.EAST), robot.getPosition());

		robot.rotateLeft();
		assertEquals(new Position(1, 1, Direction.NORTH), robot.getPosition());
	}

	@Test
	public void testRotateRight() {
		Position position = new Position(1, 1, Direction.NORTH);
		Robot robot = new Robot(position);
		assertEquals(position, robot.getPosition());

		robot.rotateRight();
		assertEquals(new Position(1, 1, Direction.EAST), robot.getPosition());

		robot.rotateRight();
		assertEquals(new Position(1, 1, Direction.SOUTH), robot.getPosition());

		robot.rotateRight();
		assertEquals(new Position(1, 1, Direction.WEST), robot.getPosition());

		robot.rotateRight();
		assertEquals(new Position(1, 1, Direction.NORTH), robot.getPosition());
	}

	@Test
	public void testRotateNullCheck() {
		Position position = new Position(1, 1, null);
		Robot robot = new Robot(position);
		assertEquals(position, robot.getPosition());

		robot.rotateRight();// has no effect
		assertEquals(position, robot.getPosition());

		robot.rotateLeft(); // has no effect
		assertEquals(position, robot.getPosition());

		robot.move(null); // has no effect
		assertEquals(position, robot.getPosition());
	}
}
