package com.toyrobot;

import java.util.Optional;

import com.toyrobot.common.Command;
import com.toyrobot.common.Direction;
import com.toyrobot.common.Position;
import com.toyrobot.components.Board;
import com.toyrobot.components.Robot;
import com.toyrobot.exceptions.ToyException;

public class RobotGame {

	private Board board;
	private Robot robot;

	public RobotGame(Board board, Robot robot) {
		super();
		this.board = board;
		this.robot = robot;
	}

	private Command parseCommand(String command) {
		try {
			return Command.valueOf(command);
		} catch (IllegalArgumentException exception) {
			throw new ToyException("Invalid Command: " + command);
		}
	}

	private int parsePosition(String position) {
		try {
			return Integer.parseInt(position);
		} catch (IllegalArgumentException exception) {
			throw new ToyException("Cannot parse to integer: " + position);
		}
	}

	public Optional<String> evaluateAndExecute(String input) {
		String[] args = input.split(" ");

		Command command = parseCommand(args[0]);

		switch (command) {
		case PLACE:
			if (args.length > 1) {
				String[] params = args[1].split(",");
				if (params.length == 3) {
					int x = parsePosition(params[0]);
					int y = parsePosition(params[1]);
					Direction direction = Direction.valueOf(params[2]);

					Position position = new Position(x, y, direction);
					if (board.isValidPosition(position)) {
						robot.setPosition(position);
					}
				}
			}
			break;
		case MOVE:
			Position newPosition = robot.getPosition().move();
			if (board.isValidPosition(newPosition)) {
				robot.move(newPosition);
			}
			break;
		case LEFT:
			robot.rotateLeft();
			break;
		case RIGHT:
			robot.rotateRight();
			break;
		case REPORT:
			return report();
		default:
			throw new ToyException("Command: " + command + " not supported.");
		}
		return Optional.empty();
	}

	private Optional<String> report() {
		if (robot.getPosition() == null) {
			return Optional.empty();
		}
		return Optional.of("Output:" + robot.getPosition().getX() + "," + robot.getPosition().getY() + ","
				+ robot.getPosition().getDirection().name());
	}

}
