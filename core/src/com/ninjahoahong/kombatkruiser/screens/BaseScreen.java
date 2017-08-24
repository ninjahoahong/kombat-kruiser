package com.ninjahoahong.kombatkruiser.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ninjahoahong.kombatkruiser.KombatKruiser;


public abstract class BaseScreen implements Screen {
    KombatKruiser theGame;
    OrthographicCamera camera;
    Stage stage;
    SpriteBatch batch;
    BitmapFont font;
    static final int GAME_HEIGHT = 1280;
    static final int GAME_WIDTH = 720;

    public BaseScreen(KombatKruiser theGame) {
        this.theGame = theGame;
        camera = new OrthographicCamera();
        camera.setToOrtho(true);
        font = new BitmapFont(true);
        Viewport viewport = new FitViewport(GAME_WIDTH, GAME_HEIGHT, camera);
        viewport.setScreenBounds(0, 0, GAME_WIDTH, GAME_HEIGHT);
        viewport.apply(true);
        stage = new Stage(viewport);
        batch = new SpriteBatch();
    }

    @Override
    public void show() {
        stage.clear();
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(camera.combined);
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        stage.act();
        stage.draw();
        batch.begin();
        batch.end();
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
        theGame.dispose();
        batch.dispose();
        font.dispose();
        stage.dispose();
    }
}
