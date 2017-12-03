package com.exedo.ld;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
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
		manager.load("tv.png", Texture.class);
		manager.load("burger.png", Texture.class);
		manager.load("bitcoin.png", Texture.class);
		manager.load("battery.png", Texture.class);
		manager.load("phone.png", Texture.class);
		manager.load("cooldown.png", Texture.class);
		manager.load("buy.wav", Sound.class);
		manager.load("bgm.wav", Music.class);
		manager.load("lavalamp.atlas", TextureAtlas.class);
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