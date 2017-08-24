package com.ninjahoahong.kombatkruiser.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ninjahoahong.kombatkruiser.KombatKruiser;

class GameScreen extends BaseScreen {

    private static final int FRAME_COLS = 6, FRAME_ROWS = 5;
    private Animation<TextureRegion> walkAnimation;
    Texture walkSheet;
    // A variable for tracking elapsed time for the animation
    float stateTime;

    public GameScreen(KombatKruiser theGame) {
        super(theGame);
        walkSheet = new Texture(Gdx.files.internal("running-sprite-sheet.png"));
        TextureRegion[][] tmp = TextureRegion.split(walkSheet,
                                                    walkSheet.getWidth() / FRAME_COLS,
                                                    walkSheet.getHeight() / FRAME_ROWS);
        TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                TextureRegion region = tmp[i][j];
                region.flip(false, true);
                walkFrames[index++] = region;
            }
        }

        walkAnimation = new Animation<TextureRegion>(0.025f, walkFrames);
        stateTime = 0f;
    }

    @Override public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        batch.begin();
        batch.draw(currentFrame, 50, 50);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        walkSheet.dispose();
    }
}
