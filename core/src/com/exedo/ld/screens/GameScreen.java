package com.exedo.ld.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.exedo.ld.Hud;
import com.exedo.ld.LudumDare;
import com.exedo.ld.sprites.Battery;
import com.exedo.ld.sprites.Bitcoin;
import com.exedo.ld.sprites.Burger;
import com.exedo.ld.sprites.LavaLamp;
import com.exedo.ld.sprites.Phone;
import com.exedo.ld.sprites.Tv;

import static com.badlogic.gdx.Gdx.input;

public class GameScreen implements Screen {

    private final String LOG = this.getClass().getSimpleName();

    private LudumDare game;
    private OrthographicCamera cam;
    private Viewport port;

    private Hud hud;

    private LavaLamp lavaLamp;
    private Tv tv;
    private Burger burger;
    private Bitcoin coin;
    private Battery battery;
    private Phone phone;

    private Sound buy;
    private Music bgm;

    public GameScreen(LudumDare game) {
        this.game = game;

        cam = new OrthographicCamera();
        port = new FitViewport(LudumDare.V_WIDTH, LudumDare.V_HEIGHT, cam);
        cam.position.set(port.getWorldWidth() / 2, port.getWorldHeight() / 2, 0);

        hud = new Hud(game.getBatch());

        lavaLamp = new LavaLamp(115, 390, game);
        tv = new Tv(546, 390, game);
        burger = new Burger(938, 390, game);
        coin = new Bitcoin(115, 165, game);
        battery = new Battery(545, 165, game);
        phone = new Phone(938, 165, game);

        buy = game.getManager().get("buy.wav", Sound.class);
        bgm = game.getManager().get("bgm.wav", Music.class);
        bgm.setLooping(true);
        bgm.setVolume(0.25f);
        bgm.play();
    }

    @Override
    public void show() {

    }

    public void update(float delta) {
        handleInput(delta);

        cam.update();

        hud.income(delta);
        hud.time(delta);

        battery.update(delta);
        coin.update(delta);
        burger.update(delta);
        lavaLamp.update(delta);
        phone.update(delta);
        tv.update(delta);
    }

    public void handleInput(float delta) {
        if(input.justTouched()) {
            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            cam.unproject(touchPos);
            if(lavaLamp.getBoundingRectangle().contains(touchPos.x, touchPos.y) && lavaLamp.clickable) {
                hud.buy(50.0f);
                lavaLamp.clickable = false;
                buy.play();
            }
            if(tv.getBoundingRectangle().contains(touchPos.x, touchPos.y) && tv.clickable) {
                hud.buy(500.0f);
                tv.clickable = false;
                buy.play();
            }
            if(burger.getBoundingRectangle().contains(touchPos.x, touchPos.y) && burger.clickable) {
                hud.buy(5.0f);
                burger.clickable = false;
                buy.play();
            }
            if(coin.getBoundingRectangle().contains(touchPos.x, touchPos.y) && coin.clickable) {
                hud.buy(10000.0f);
                coin.clickable = false;
                buy.play();
            }
            if(battery.getBoundingRectangle().contains(touchPos.x, touchPos.y) && battery.clickable) {
                hud.buy(20.0f);
                battery.clickable = false;
                buy.play();
            }
            if(phone.getBoundingRectangle().contains(touchPos.x, touchPos.y) && phone.clickable) {
                hud.buy(999.99f);
                phone.clickable = false;
                buy.play();
            }
        }
    }

    @Override
    public void render(float delta) {
        if(hud.getMinutes() == 0 && hud.getSeconds() == 0) {
            game.setScreen(new EndScreen(game));
        }

        update(delta);

        Gdx.gl.glClearColor(0.5f, 0.35f, 0.05f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().setProjectionMatrix(cam.combined);

        game.getBatch().begin();
        game.getBatch().draw(game.getManager().get("layout.png", Texture.class), 0, 0);
        lavaLamp.draw(game.getBatch());
        tv.draw(game.getBatch());
        burger.draw(game.getBatch());
        coin.draw(game.getBatch());
        battery.draw(game.getBatch());
        phone.draw(game.getBatch());
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
