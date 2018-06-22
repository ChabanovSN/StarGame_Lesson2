package ru.geekbrains.stargame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture imgbk;
	int ANDROID_WIDTH;
	int ANDROID_HEIGHT;
	private static float red = 0f;
	private static float green = 0.5f;
	private static float blue = 0.8f;
	private static float step = 0.025f;
	private static int deltaWidth = 10;
	private static int deltaHeight = 10;

	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("test/logo.png");
		imgbk = new Texture("test/bk.png");
	}

	@Override
	public void render() {
		ANDROID_WIDTH = Gdx.graphics.getWidth();
		ANDROID_HEIGHT = Gdx.graphics.getHeight();
		changeColorBackgroundAndPosition();
		Gdx.gl.glClearColor(red, green, blue, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(imgbk, 15, 15, ANDROID_WIDTH - 30, ANDROID_HEIGHT - 30);
		batch.draw(img, deltaWidth, deltaHeight);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}

	private void changeColorBackgroundAndPosition() {
		if (red <= 1f) red += step;
		else red = 0.0f;
		if (green <= 1f) green += step;
		else green = 0.0f;
		if (blue <= 1f) blue += step;
		else blue = 0.0f;
		if (deltaWidth >= ANDROID_WIDTH - 200)deltaWidth = 10;
		else deltaWidth += 1;
		if (deltaHeight >= ANDROID_HEIGHT - 200)deltaHeight = 10;
		else deltaHeight += 1;

	}
}
