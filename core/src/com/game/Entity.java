package com.game;

import com.badlogic.gdx.math.Vector2;

public abstract class Entity extends Object {
	public float velocity;
	public Vector2 lastPosition;
	
	public Entity(){
		velocity = 20;
		lastPosition = new Vector2();
	}
	
	public abstract void update(float deltaTime, GameScreen screen);
	
	public void setPosition(float x, float y){
		lastPosition.set(sprite.getX(), sprite.getY());
		sprite.setPosition(x, y);
	}
	
	public void translate(float x , float y){
		lastPosition.set(sprite.getX(), sprite.getY());
		sprite.translate(x, y);
	}
}
