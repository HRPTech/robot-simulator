package com.toyrobot.components;

import com.toyrobot.common.Position;

public class Robot {

	private Position position;

	public Robot(Position position) {
		super();
		this.position = position;
	}

	public Robot() {
		super();
	}
	
	public void setPosition(Position position)
	{
		move(position);
	}
	
	public void move(Position newPosition){
		if (newPosition != null){
			this.position=newPosition;
		}
	}

	public final Position getPosition() {
		return position;
	}
	
	public void rotateLeft(){
		if (getPosition().getDirection() != null){
			this.position = getPosition().moveLeft();
		}
	}
	
	public void rotateRight(){
		if (getPosition().getDirection() != null){
			this.position = getPosition().moveRight();
		}
	}
}
