package com.exedo.ld.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.exedo.ld.LudumDare;


public class EndScreen implements Screen {

    private LudumDare game;
    private BitmapFont font;

    private OrthographicCamera cam;
    private Viewport port;

    public EndScreen(LudumDare game) {
        this.game = game;
        font = new BitmapFont();

        cam = new OrthographicCamera();
        port = new FitViewport(LudumDare.V_WIDTH, LudumDare.V_HEIGHT, cam);
        cam.position.set(port.getWorldWidth() / 2, port.getWorldHeight() / 2, 0);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().setProjectionMatrix(cam.combined);
        game.getBatch().begin();
        font.draw(game.getBatch(), "I'll make game over text later.", 100, 100);
        game.getBatch().end();
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

    }
}
