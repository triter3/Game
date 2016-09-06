package com.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Object {
	public Sprite sprite;
	public Object(){
		sprite = new Sprite();
	}	
	public abstract void render(SpriteBatch batch);
	
}
