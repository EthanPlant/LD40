package com.exedo.ld;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.text.NumberFormat;

public class Hud implements Disposable {

    private Stage stage;
    private Viewport port;

    private float money;
    private NumberFormat moneyFormat;

    private int minutes = 3;
    private int seconds;
    private NumberFormat timeFormat;

    private Label moneyLabel;
    private Label timeLabel;
    float counter;
    float timer;

    public Hud(SpriteBatch sb, LudumDare game) {
        money = 50000.00f;
        moneyFormat = NumberFormat.getInstance();
        moneyFormat.setMaximumFractionDigits(2);
        moneyFormat.setMinimumFractionDigits(2);
        timeFormat = NumberFormat.getNumberInstance();
        timeFormat.setMinimumIntegerDigits(2);


        port = new FitViewport(LudumDare.V_WIDTH, LudumDare.V_HEIGHT);
        stage = new Stage(port, sb);

        Table table = new Table();
        table.top().left();
        table.padTop(109);
        table.padLeft(155);
        table.setFillParent(true);

        moneyLabel = new Label("$" + moneyFormat.format(money), new Label.LabelStyle(game.getManager().get("ui.fnt", BitmapFont.class), new Color(0.17f, 0.45f, 0.16f, 1)));
        timeLabel = new Label(timeFormat.format(minutes) + ":" + timeFormat.format(seconds), new Label.LabelStyle(game.getManager().get("ui.fnt", BitmapFont.class), new Color(0.17f, 0.45f, 0.16f, 1)));
        table.add(timeLabel).spaceRight(780).width(100);
        table.add(moneyLabel);
        stage.addActor(table);
    }

    public Stage getStage() {return stage; }

    public void buy(float value) {
        money -= value;
        moneyLabel.setText("$" + moneyFormat.format(money));
    }

    public void income(float delta) {
        counter += delta;
        if(counter >= 5) {
            money += 50;
            moneyLabel.setText("$" + moneyFormat.format(money));
            counter = 0;
        }
    }

    public void time(float delta) {
        timer += delta;
        if(timer >= 1) {
            if(seconds == 0) {
                seconds = 59;
                minutes--;
            } else {
                seconds--;
            }

            timeLabel.setText(timeFormat.format(minutes) + ":" + timeFormat.format(seconds));
            timer = 0;
        }
    }

    public int getMinutes() {return minutes; }
    public int getSeconds() {return seconds; }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
