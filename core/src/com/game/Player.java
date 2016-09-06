package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import sun.font.Script;

public class Player extends Entity{
	OrthographicCamera camera;
	public Player(GameScreen screen){
		sprite.setTexture(new Texture("entities.png"));
		sprite.setRegion(0, 0, 21, 21);
		sprite.setSize(25, 25);
		init(screen);
	}
	
	public void init(GameScreen screen){
		sprite.setPosition(screen.getGamePanel_len().x / 2 + screen.border_lenght - sprite.getWidth() / 2 ,
				screen.getGamePanel_len().y / 2 + screen.border_lenght - sprite.getHeight() / 2);
		velocity = 45; 
		camera = new OrthographicCamera();
	}

	@Override
	public void update(float deltaTime, GameScreen screen) {
		
		//moviment
		Vector2 shift = new Vector2();
		switch(Gdx.app.getType()){	
		case Android:
			screen.scorePanel.androidContr.update(screen);
			shift = screen.scorePanel.androidContr.getDirection();
			shift.x *= velocity * deltaTime;
			shift.y *= velocity * deltaTime;
			break;
		default:
			shift = getShift_keyboard(deltaTime);
			break;
		}
		translate(shift.x, shift.y);
		
		//comprovació dels limits del mapa
		Entity entity = this;
		Vector2 response = Collisions.handleBorderCollison(entity, screen);
		if(response != null){
			sprite.translate(response.x, response.y);
		}
		
	}
	
	
	@Override
	public void render(SpriteBatch batch) {
		sprite.draw(batch);
	}
	
	public Vector2 getShift_keyboard(float deltaTime){
		Vector2 shift = new Vector2(0,0);
		//x
		if(Gdx.input.isKeyPressed(Keys.D)) shift.x += velocity * deltaTime;
		if(Gdx.input.isKeyPressed(Keys.A)) shift.x -= velocity * deltaTime;
		//y
		if(Gdx.input.isKeyPressed(Keys.W)) shift.y += velocity * deltaTime;
		if(Gdx.input.isKeyPressed(Keys.S)) shift.y -= velocity * deltaTime;
		return shift;
	}
	
	

} 
