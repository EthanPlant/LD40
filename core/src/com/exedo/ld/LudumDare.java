package com.exedo.ld;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.exedo.ld.screens.GameScreen;

public class LudumDare extends Game {
	public static final int V_WIDTH = 1280;
	public static final int V_HEIGHT = 720;

	private SpriteBatch batch;
	private AssetManager manager;

	@Override
	public void create() {
		batch = new SpriteBatch();
		manager = new AssetManager();
		loadAssets();
		setScreen(new GameScreen(this));
	}

	public void loadAssets() {
		manager.load("lavalamp.png", Texture.class);
		manager.load("layout.png", Texture.class);
		manager.finishLoading();
	}

	@Override
	public void render() {
		super.render();
	}

	public SpriteBatch getBatch() {return batch; }
	public AssetManager getManager() {return manager; }

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
	}
}