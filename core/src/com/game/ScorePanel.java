package com.game;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScorePanel {
	
	Sprite bar;
	private float panel_lenght;
	public AndroidController androidContr = null;
	
	public ScorePanel(){
		loadTextures();
		if(Gdx.app.getType() == ApplicationType.Android){
			androidContr = new AndroidController();
		}
	}
	
	public void loadTextures(){
		Pixmap pixmap = new Pixmap(64, 64 , Format.RGBA8888);
		pixmap.setColor(1,1,1,1);
		pixmap.fillRectangle(0, 0, 64, 64);
		bar.setTexture(new Texture(pixmap));
		bar.setRegion(0,0,64,64);
		pixmap.dispose();
	}
	
	public void resize(GameScreen screen){
		panel_lenght = screen.getX()- screen.getGamePanel_len().x - screen.border_lenght;
		bar.setSize(panel_lenght, 5);
		bar.setPosition(screen.getX() - panel_lenght, screen.getY()/2 - bar.getHeight());
		if(androidContr != null){
			androidContr.resize(screen);
		}		
	}
	
	public void render(SpriteBatch batch, GameScreen screen){
		if(androidContr != null)androidContr.render(batch);
		bar.draw(batch);
	}
	
	public void setLenght(float lenght){
		panel_lenght = lenght;
	}
	
	public float getLenght(){	
		return panel_lenght;
	}

}
