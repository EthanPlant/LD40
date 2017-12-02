package com.exedo.ld.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.exedo.ld.Hud;
import com.exedo.ld.LudumDare;

import static com.badlogic.gdx.Gdx.input;

public class GameScreen implements Screen {

    private final String LOG = this.getClass().getSimpleName();

    private LudumDare game;
    private OrthographicCamera cam;
    private Viewport port;

    private Hud hud;
    private Rectangle rect;

    public GameScreen(LudumDare game) {
        this.game = game;

        cam = new OrthographicCamera();
        port = new FitViewport(LudumDare.V_WIDTH, LudumDare.V_HEIGHT, cam);
        cam.position.set(port.getWorldWidth() / 2, port.getWorldHeight() / 2, 0);
        rect = new Rectangle(70, 350, 196, 196);

        hud = new Hud(game.getBatch());
    }

    @Override
    public void show() {

    }

    public void handleInput() {
        if(input.justTouched()) {
            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            cam.unproject(touchPos);
            if(rect.contains(touchPos.x, touchPos.y)) {
                hud.buy(50.0f);
            }
        }
    }

    @Override
    public void render(float delta) {
        handleInput();

        cam.update();

        hud.income(delta);

        Gdx.gl.glClearColor(0.5f, 0.35f, 0.05f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().setProjectionMatrix(cam.combined);

        game.getBatch().begin();
        game.getBatch().draw(game.getManager().get("layout.png", Texture.class), 0, 0);
        game.getBatch().draw(game.getManager().get("lavalamp.png", Texture.class), 70, 350);
        game.getBatch().end();

        game.getBatch().setProjectionMatrix(hud.getStage().getCamera().combined);
        hud.getStage().draw();
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
        game.getManager().unload("layout.png");
    }
}
