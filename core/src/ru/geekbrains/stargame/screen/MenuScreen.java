package ru.geekbrains.stargame.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.geekbrains.stargame.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {


    private SpriteBatch batch;
    private Texture img;

    private static int x = 50;
    private static int y = 100;
    int ANDROID_WIDTH;
    int ANDROID_HEIGHT;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("test/beetle.jpg");
        ANDROID_WIDTH = Gdx.graphics.getWidth();
        ANDROID_HEIGHT = Gdx.graphics.getHeight();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, x, y, 60, 60);
        batch.end();
        //  game.setScreen(new GameScreen());
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        x = ANDROID_WIDTH - (ANDROID_WIDTH - screenX + 30);
        y = ANDROID_HEIGHT - screenY - 30;
        return false;

    }

    @Override
    public void dispose() {
        batch.dispose();
        super.dispose();
    }
}
