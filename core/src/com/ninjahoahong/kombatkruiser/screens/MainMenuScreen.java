package com.ninjahoahong.kombatkruiser.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.ninjahoahong.kombatkruiser.KombatKruiser;


public class MainMenuScreen extends BaseScreen {

    private Button playButton;
    private Button optionButton;
    private Button creditsButton;
    private Label gameTitle;

    public MainMenuScreen(KombatKruiser theGame) {
        super(theGame);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(stage);

        // fonts and styles
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.fontColor = font.getColor();

        Group gameBackGround = new Group();
        gameBackGround.setBounds(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gameBackGround.setColor(Color.WHITE);
        stage.addActor(gameBackGround);

        gameTitle = new Label("Kombat Kruiser", labelStyle);
        gameTitle.setPosition(
                GAME_WIDTH/2 - gameTitle.getWidth()/2,
                150);
        stage.addActor(gameTitle);

        playButton = addTextButtonToHorizontalCenter(
                textButtonStyle,
                "Play",
                200);
        playButton.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("button pressed", "play button");
                return true;
            }
            public void touchUp(InputEvent event, float x, float y, int pointer, int button){
                Gdx.app.log("button released", "play button");
                theGame.setScreen(new GameScreen(theGame));
                stage.dispose();
            }
        });
        stage.addActor(playButton);

        optionButton = addTextButtonToHorizontalCenter(
                textButtonStyle,
                "Options",
                250);
        stage.addActor(optionButton);

        creditsButton = addTextButtonToHorizontalCenter(
                textButtonStyle,
                "Credits",
                300);
        stage.addActor(creditsButton);

    }

    private TextButton addTextButtonToHorizontalCenter(
            TextButton.TextButtonStyle style,
            String name,
            float y) {
        TextButton textButton = new TextButton(name, style);
        textButton.setWidth(200);
        textButton.setHeight(50);
        textButton.setPosition(GAME_WIDTH/2 - textButton.getWidth()/2, y);
        return textButton;
    }
}
