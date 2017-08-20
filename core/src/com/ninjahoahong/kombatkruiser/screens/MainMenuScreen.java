package com.ninjahoahong.kombatkruiser.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.ninjahoahong.kombatkruiser.KombatKruiser;


public class MainMenuScreen extends AbstractScreen {

    private Stage stage;
    private Table table;
    private Button playButton;

    private float screenWidth = Gdx.graphics.getWidth();
    private float screenHeight = Gdx.graphics.getHeight();

    private OrthographicCamera camera;

    public MainMenuScreen(KombatKruiser theGame) {
        super(theGame);
        camera = new OrthographicCamera();
        camera.setToOrtho(true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        theGame.batch.setProjectionMatrix(camera.combined);
        stage.act();
        stage.draw();
        theGame.batch.begin();
        theGame.batch.end();
    }
    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {

        stage = new Stage();
        stage.clear();
        Gdx.input.setInputProcessor(stage);

        table = new Table();

        table.setHeight(screenHeight/4);
        table.setWidth(screenWidth/1.5f);
        table.setPosition(screenWidth/2 - table.getWidth()/2, screenHeight/3.5f);
        table.setOrigin(table.getWidth()/2, table.getHeight()/2);
        table.setTransform(true);
        table.rotateBy(-6);

        TextButton.TextButtonStyle playButtonStyle = new TextButton.TextButtonStyle();
        playButtonStyle.font = new BitmapFont();

        playButton = new TextButton("Play", playButtonStyle);

        playButton.setHeight(table.getHeight()/6);
        playButton.setWidth(table.getWidth());
        playButton.setPosition(table.getWidth()/2 - playButton.getWidth()/2, table.getHeight() - playButton.getHeight());

        playButton.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            public void touchUp(InputEvent event, float x, float y, int pointer, int button){
                theGame.setScreen(new GameScreen(theGame));
                stage.dispose();
            }
        });

        table.addActor(playButton);
        stage.addActor(table);
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
