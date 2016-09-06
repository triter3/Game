package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.sun.corba.se.impl.orbutil.closure.Constant;

public class GameScreen {
	public ScorePanel scorePanel;
	private TextureRegion texture;
	private float cameraWidth;
	private final Vector2 gamePanel;
	public final float border_lenght = 5;

	public GameScreen(){
		loadBorders();
		gamePanel = new Vector2(260,190);
		scorePanel = new ScorePanel();
	}
	
	public void loadBorders(){
		Pixmap pixmap = new Pixmap(64, 64, Format.RGBA8888);
		pixmap.setColor(0.5f, 0.5f, 0.5f, 1);			
		pixmap.fillRectangle(0, 0, 64, 64);
		texture = new TextureRegion(new Texture(pixmap));	
		pixmap.dispose();
	}
	
	public void render(SpriteBatch batch){
		//borders
		batch.draw(texture, 0, 0 , border_lenght, Constants.CAMERA_VIEW);
		batch.draw(texture, 0, 0, cameraWidth - scorePanel.getLenght(), border_lenght);
		batch.draw(texture, 0, Constants.CAMERA_VIEW - border_lenght, cameraWidth - scorePanel.getLenght(), border_lenght);
		
		//panel
		batch.draw(texture, cameraWidth - scorePanel.getLenght(),0 , scorePanel.getLenght(), Constants.CAMERA_VIEW);
		
		scorePanel.render(batch, this);
	}
	
	public void resize(float cameraWidth){
		this.cameraWidth = cameraWidth;
		scorePanel.resize(this);
	}
	
	public float getX(){
		return cameraWidth;
	}
	public float getY(){
		return Constants.CAMERA_VIEW;
	}
	
	public Vector2 getGamePanel_len(){
		return gamePanel;
	}
}
