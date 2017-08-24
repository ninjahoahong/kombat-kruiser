package com.ninjahoahong.kombatkruiser.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.ninjahoahong.kombatkruiser.KombatKruiser;


public class MainMenuScreen extends BaseScreen {

    private Texture backgroundTexture;
    private Image backgroundImage;
    private Button playButton;
    private Button optionButton;
    private Button creditsButton;
    private Button exitButton;
    private Label gameTitle;
    private static final int FRAME_COLS = 6, FRAME_ROWS = 5;
    private Animation<TextureRegion> wheelAnimation;
    Texture wheelSheet;
    // A variable for tracking elapsed time for the animation
    float stateTime;

    public MainMenuScreen(KombatKruiser theGame) {
        super(theGame);
        wheelSheet =
                new Texture(Gdx.files.internal("running-sprite-sheet.png"));
        TextureRegion[][] tmp = TextureRegion.split(
                wheelSheet,
                wheelSheet.getWidth() / FRAME_COLS,
                wheelSheet.getHeight() / FRAME_ROWS);
        TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                TextureRegion region = tmp[i][j];
                region.flip(false, true);
                walkFrames[index++] = region;
            }
        }

        wheelAnimation = new Animation<TextureRegion>(0.025f, walkFrames);
        stateTime = 0f;
    }

    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchBackKey(true);

        backgroundTexture = new Texture(Gdx.files.internal("bg-white.png"));
        backgroundImage = new Image(backgroundTexture);
        stage.addActor(backgroundImage);

        // fonts and styles
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;
        TextButton.TextButtonStyle textButtonStyle =
                new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.fontColor = Color.RED;
        textButtonStyle.overFontColor = Color.BLACK;

        Group gameBackGround = new Group();
        gameBackGround.setBounds(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gameBackGround.setColor(Color.WHITE);
        stage.addActor(gameBackGround);

        gameTitle = new Label("Kombat Kruiser", labelStyle);
        gameTitle.setWidth(200);
        gameTitle.setFontScale(2);
        gameTitle.setPosition(
                GAME_WIDTH / 2 - 100,
                350);
        stage.addActor(gameTitle);

        playButton = addTextButtonToHorizontalCenter(
                textButtonStyle,
                "Play",
                400);
        playButton.addListener(new InputListener() {
            public boolean touchDown(
                    InputEvent event, float x, float y, int pointer,
                    int button) {
                Gdx.app.log("button pressed", "play button");
                return true;
            }

            public void touchUp(
                    InputEvent event, float x, float y, int pointer,
                    int button) {
                Gdx.app.log("button released", "play button");
                theGame.setScreen(new GameScreen(theGame));
                stage.dispose();
            }
        });
        stage.addActor(playButton);

        optionButton = addTextButtonToHorizontalCenter(
                textButtonStyle,
                "Options",
                450);
        stage.addActor(optionButton);

        creditsButton = addTextButtonToHorizontalCenter(
                textButtonStyle,
                "Credits",
                500);
        stage.addActor(creditsButton);

        exitButton = addTextButtonToHorizontalCenter(
                textButtonStyle,
                "Exit",
                550);
        exitButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(
                    InputEvent event, float x, float y, int pointer,
                    int button) {
                return true;
            }

            @Override
            public void touchUp(
                    InputEvent event, float x, float y, int pointer,
                    int button) {
                Gdx.app.exit();
            }
        });
        stage.addActor(exitButton);
    }

    private TextButton addTextButtonToHorizontalCenter(
            TextButton.TextButtonStyle style,
            String name,
            float y) {
        TextButton textButton = new TextButton(name, style);
        textButton.setWidth(200);
        textButton.setHeight(50);
        textButton.getLabel().setFontScale(3);
        textButton.setPosition(GAME_WIDTH / 2 - 100, y);
        return textButton;
    }

    @Override public void render(float delta) {
        super.render(delta);
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame =
                wheelAnimation.getKeyFrame(stateTime, true);
        batch.begin();
        batch.draw(currentFrame, GAME_WIDTH / 2 - 20, 650);
        batch.end();
    }

    @Override public void dispose() {
        super.dispose();
        wheelSheet.dispose();
    }
}
