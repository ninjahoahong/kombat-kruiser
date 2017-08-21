package com.ninjahoahong.kombatkruiser.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class SplashScreen implements Screen {
    private SpriteBatch batch;
    private Sprite splash;
    private OrthographicCamera camera;

    public SplashScreen(){
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(true);
    }

    @Override
    public void show() {
        Texture kombatKruiserText = new Texture(Gdx.files.internal("kombat-kruiser.png"));
        splash = new Sprite(kombatKruiserText);
        splash.setCenter(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
    }

    @Override
    public void render(float delta) {
        splash.setCenter(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        Gdx.gl.glClearColor(1, 1, 1, 1); // Color then opacity
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        splash.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        splash.setCenter(width / 2, height / 2);
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
        batch.dispose();
        splash.getTexture().dispose();
    }
}
