package ru.geekbrains.stargame.game;

import com.badlogic.gdx.Game;

import ru.geekbrains.stargame.screen.MenuScreen;

public class Start2Dgame extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
