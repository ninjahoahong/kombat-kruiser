package com.ninjahoahong.kombatkruiser;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.ninjahoahong.kombatkruiser.screens.MainMenuScreen;
import com.ninjahoahong.kombatkruiser.screens.SplashScreen;

public class KombatKruiser extends Game {
    public SpriteBatch batch;
    private static long MINIMUM_DURATION_MILLIS = 2000L;

    public KombatKruiser() {
        super();
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new SplashScreen());
        final long startTime = System.currentTimeMillis();
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                long duration = System.currentTimeMillis() - startTime;
                KombatKruiser theGame = KombatKruiser.this;
                if (duration > MINIMUM_DURATION_MILLIS) {
                    theGame.setScreen(new MainMenuScreen(KombatKruiser.this));
                } else {
                    Timer.schedule(
                            new Timer.Task() {
                                @Override
                                public void run() {
                                    theGame.setScreen(
                                            new MainMenuScreen(KombatKruiser.this));
                                }
                            },
                            (float) (MINIMUM_DURATION_MILLIS - duration) / 1000f);

                }
            }
        });
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
