package com.game;

import com.badlogic.gdx.math.Vector2;

public class Collisions {
	
	public static Vector2 handleBorderCollison(Entity entity, GameScreen screen){
		//left border
		Vector2 response = new Vector2();
		boolean collision = false;
		if(entity.sprite.getX() < screen.border_lenght){
			response.x = screen.border_lenght - entity.sprite.getX();
			collision = true;
		}
		//right border
		if(entity.sprite.getX() + entity.sprite.getWidth() > screen.getX() - screen.scorePanel.getLenght()){
			response.x = screen.getX() - screen.scorePanel.getLenght() -(entity.sprite.getX() + entity.sprite.getWidth());
			collision = true;
		}
		
		//top border
		if(entity.sprite.getY() + entity.sprite.getHeight() > screen.getY() - screen.border_lenght){
			response.y = screen.getY() - screen.border_lenght - (entity.sprite.getY() + entity.sprite.getHeight());
			collision = true;
		}
		
		//bottom border
		if(entity.sprite.getY() < screen.border_lenght){
			response.y = screen.border_lenght - entity.sprite.getY();
			collision = true;
		}
		if (collision){
			return response;
		}
		return null;
	
	}

}
