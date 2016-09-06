package com.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Sprite spr;
	private World world;
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.update();
		world = new World();
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		world.update(Gdx.graphics.getDeltaTime());
		batch.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		world.render(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		float cameraWidth = Constants.CAMERA_VIEW * width/height;
		camera.viewportWidth = cameraWidth;
		camera.viewportHeight = Constants.CAMERA_VIEW ;
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();
        world.screen.resize(cameraWidth);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
