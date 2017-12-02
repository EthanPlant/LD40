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
    private NumberFormat nf;

    private Label moneyLabel;
    float counter;

    public Hud(SpriteBatch sb) {
        money = 0;
        nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);


        port = new FitViewport(LudumDare.V_WIDTH, LudumDare.V_HEIGHT);
        stage = new Stage(port, sb);

        Table table = new Table();
        table.top().right();
        table.padTop(75).padRight(150);
        table.setFillParent(true);

        moneyLabel = new Label(nf.format(money), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        table.add(moneyLabel);
        stage.addActor(table);
    }

    public Stage getStage() {return stage; }

    public void buy(float value) {
        money -= value;
        moneyLabel.setText(nf.format(money));
    }

    public void income(float delta) {
        counter += delta;
        if(counter >= 5) {
            money += 50;
            moneyLabel.setText(nf.format(money));
            counter = 0;
        }
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
