package com.ninjahoahong.kombatkruiser.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ninjahoahong.kombatkruiser.KombatKruiser;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Kombat Kruiser";
		config.width = 720;
		config.height = 1280;
		new LwjglApplication(new KombatKruiser(), config);
	}
}
