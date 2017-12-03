package com.exedo.ld.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.exedo.ld.LudumDare;

public class TitleScreen implements Screen {

    private LudumDare game;

    private OrthographicCamera cam;
    private Viewport port;

    public TitleScreen(LudumDare game) {
        this.game = game;

        cam = new OrthographicCamera();
        port = new FitViewport(LudumDare.V_WIDTH, LudumDare.V_HEIGHT, cam);
        cam.position.set(port.getWorldWidth() / 2, port.getWorldHeight() / 2, 0);
        game.getManager().get("titlescreen.ogg", Music.class).setLooping(true);
        game.getManager().get("titlescreen.ogg", Music.class).setVolume(0.25f);
        game.getManager().get("titlescreen.ogg", Music.class).play();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            game.setScreen(new GameScreen(game));
            game.getManager().get("titlescreen.ogg", Music.class).stop();
            dispose();
        } else {
            Gdx.gl.glClearColor(0.5f, 0.35f, 0.05f, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            game.getBatch().setProjectionMatrix(cam.combined);
            game.getBatch().begin();
            game.getBatch().draw(game.getManager().get("titlescreen.png", Texture.class), 0, 0);
            game.getBatch().end();
        }
    }

    @Override
    public void resize(int width, int height) {
        port.update(width, height);
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
        game.getManager().unload("titlescreen.png");
        game.getManager().unload("titlescreen.ogg");
    }
}
