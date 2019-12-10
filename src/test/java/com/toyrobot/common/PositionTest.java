package com.toyrobot.common;

import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTest {

		
	@Test
	public void setDirectionTest(){
		Position position = new Position(0,0,Direction.NORTH);
		assertEquals(Direction.NORTH, position.getDirection());
		position.setDirection(Direction.EAST);
		assertEquals(Direction.EAST, position.getDirection());
	}
	
	@Test
	public void moveTest(){
		Position position = new Position(0,0,Direction.NORTH);
		assertEquals(Direction.NORTH, position.getDirection());
		position = position.move();	
		assertEquals(Direction.NORTH, position.getDirection());
		assertEquals(0,position.getX());
		assertEquals(1,position.getY());
	}
	
	@Test
	public void moveRightTest(){
		Position position = new Position(3,3,Direction.NORTH);
		assertEquals(Direction.NORTH, position.getDirection());
		position = position.moveRight();
		position = position.move();	
		assertEquals(Direction.EAST, position.getDirection());
		assertEquals(4,position.getX());
		assertEquals(3,position.getY());
		
		position = position.moveRight();
		position = position.move();	
		assertEquals(Direction.SOUTH, position.getDirection());
		assertEquals(4,position.getX());
		assertEquals(2,position.getY());
		
		position = position.moveRight();
		position = position.move();	
		assertEquals(Direction.WEST, position.getDirection());
		assertEquals(3,position.getX());
		assertEquals(2,position.getY());
		
		position = position.moveRight();
		position = position.move();	
		assertEquals(Direction.NORTH, position.getDirection());
		assertEquals(3,position.getX());
		assertEquals(3,position.getY());
				
	}
	
	@Test
	public void moveLeftTest(){
		Position position = new Position(3,3,Direction.NORTH);
		assertEquals(Direction.NORTH, position.getDirection());
		position = position.moveLeft();
		position = position.move();	
		assertEquals(Direction.WEST, position.getDirection());
		assertEquals(2,position.getX());
		assertEquals(3,position.getY());
		
		position = position.moveLeft();
		position = position.move();	
		assertEquals(Direction.SOUTH, position.getDirection());
		assertEquals(2,position.getX());
		assertEquals(2,position.getY());
		
		position = position.moveLeft();
		position = position.move();	
		assertEquals(Direction.EAST, position.getDirection());
		assertEquals(3,position.getX());
		assertEquals(2,position.getY());
		
		position = position.moveLeft();
		position = position.move();	
		assertEquals(Direction.NORTH, position.getDirection());
		assertEquals(3,position.getX());
		assertEquals(3,position.getY());
				
	}
}
