package com.toyrobot;

import java.util.Scanner;

import com.toyrobot.components.Board;
import com.toyrobot.components.Robot;

public class Main {
	public static void main(String[] args) {
		Board board = new Board(5, 5);
		Robot robot = new Robot();
		RobotGame game = new RobotGame(board, robot);
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			String command = "";
			System.out.println("Enter Command:");

			while ((command = scanner.nextLine()) != null) {
				game.evaluateAndExecute(command).ifPresent(System.out::println);
			}

		} finally {
			scanner.close();
		}
	}
}
