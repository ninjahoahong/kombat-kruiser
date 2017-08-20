package com.ninjahoahong.kombatkruiser.screens;

import com.badlogic.gdx.Screen;
import com.ninjahoahong.kombatkruiser.KombatKruiser;


public abstract class AbstractScreen implements Screen {
    protected KombatKruiser theGame;

    public AbstractScreen(KombatKruiser theGame) {
        this.theGame = theGame;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
