package com.exedo.ld.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.exedo.ld.LudumDare;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 960;
		config.height = 544;
		config.title = "Super Consumerism Sim 2k17 GOTY Edition";
		new LwjglApplication(new LudumDare(), config);
	}
}
