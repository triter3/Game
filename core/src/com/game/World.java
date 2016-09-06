package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class World {
	private Player player;
	public GameScreen screen;
	
	public World(){
		screen = new GameScreen();
		player = new Player(screen);
		init();
	}
	
	public void init(){
		
	}
	
	public void update(float deltaTime){
		player.update(deltaTime, screen);
	}
	
	public void render(SpriteBatch batch){
		player.render(batch);
		screen.render(batch);
	}
}
