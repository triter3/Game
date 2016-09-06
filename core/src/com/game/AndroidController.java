package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class AndroidController extends Object {
	
	private Vector2 initPosition;
	private Vector2 refPos;
	private boolean isPressed = false;
	private Vector2 direction;
	
	public AndroidController(){
		initPosition = new Vector2();
		direction = new Vector2();
		loadTextures();
	}
	
	private void loadTextures(){
		Pixmap pixmap = new Pixmap( 65, 65, Format.RGBA8888 );
		pixmap.setColor(0.956f, 0.956f, 0.956f, 1);
		pixmap.fillCircle(32, 32, 32);
		pixmap.setColor(0.878f, 0.878f, 0.878f, 1);
		pixmap.fillCircle(32, 32, (int)(32*0.8));
		sprite.setTexture(new Texture(pixmap));
		sprite.setRegion(0, 0, 65, 65);
		pixmap.dispose();
	}
	
	public void resize(GameScreen screen){
		float lenght = screen.scorePanel.getLenght() - 40;
		if(lenght < 0)lenght = 0;
		sprite.setSize(lenght, lenght);
		initPosition.x = screen.getX() - screen.scorePanel.getLenght()/2;
		initPosition.y = screen.getY()/4;
	}
	
	public void update(GameScreen screen){
		direction.set(0, 0);
		float pos_x = Gdx.input.getX() * screen.getX() / Gdx.graphics.getWidth();
		float pos_y = (Gdx.graphics.getHeight() - Gdx.input.getY()) * screen.getY() / Gdx.graphics.getHeight();
		if(!isPressed && Gdx.input.isTouched()){
			if(pos_x > sprite.getX() + sprite.getWidth()/4 && pos_y > + sprite.getHeight()/4 &&
			pos_x < sprite.getX() + 3*sprite.getWidth()/4 && pos_y < sprite.getY() + 3*sprite.getHeight()/4){
				isPressed = true;
				System.out.println("clicked");
			}
		}
		if(!Gdx.input.isTouched())isPressed = false;
		if(isPressed){
			sprite.setPosition(pos_x - sprite.getWidth()/2, pos_y - sprite.getHeight()/2);
			direction.x = (pos_x - initPosition.x) / sprite.getWidth();
			direction.y = (pos_y - initPosition.y) / sprite.getHeight();
			
			if((Math.abs(pos_x - initPosition.x) > 20)){
				if(pos_x - initPosition.x < 0){
					sprite.setX(-1*20 + initPosition.x - sprite.getWidth()/2);
					direction.x = -1;
				}
				if(pos_x - initPosition.x > 0){
					sprite.setX(20 + initPosition.x - sprite.getWidth()/2);
					direction.x = 1;
				}
			}   
			
			if((Math.abs(pos_y - initPosition.y) > 20)){
				if(pos_y - initPosition.y < 0){
					sprite.setY(-1*20 + initPosition.y - sprite.getHeight()/2);
					direction.y = -1;
				}
				if(pos_y - initPosition.y > 0){
					sprite.setY(20 + initPosition.y - sprite.getHeight()/2);
					direction.y = 1;
				}
			}
		}
		else{
			sprite.setPosition(initPosition.x - sprite.getWidth()/2,initPosition.y- sprite.getHeight()/2);			
		}
	}
	
	public void render(SpriteBatch batch){
		sprite.draw(batch);
		
	}
	
	public Vector2 getDirection(){
		return direction;
	}
}