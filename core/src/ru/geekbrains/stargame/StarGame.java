package ru.geekbrains.stargame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class StarGame extends ApplicationAdapter {
	private SpriteBatch batch;
private 	Texture img;

	int ANDROID_WIDTH;
	int ANDROID_HEIGHT;

	private static float deltaWidth = 3f;
	private static float deltaHeight = 2.5f;
   Vector2 pos;
   Vector2 v;
	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("test/logo.png");
		ANDROID_WIDTH = Gdx.graphics.getWidth();
		ANDROID_HEIGHT = Gdx.graphics.getHeight();
		pos = new Vector2(0,0);
		//v = new Vector2(deltaWidth,deltaHeight);
	}

	@Override
	public void render() {

		changeColorBackgroundAndPosition();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, pos.x, pos.y);
		batch.end();
		pos.add(deltaWidth,deltaHeight);
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}

	private void changeColorBackgroundAndPosition() {

		if (pos.x > ANDROID_WIDTH - img.getWidth())deltaWidth = -3f;
		 if (pos.x <  0)deltaWidth =3f;
		if (pos.y > ANDROID_HEIGHT - img.getHeight())deltaHeight =-2.5f ;
		 if(pos.y <  0) deltaHeight =2.5f;

	}
}
