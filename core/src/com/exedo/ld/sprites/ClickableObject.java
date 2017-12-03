package com.exedo.ld.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.exedo.ld.LudumDare;

public abstract class ClickableObject extends Sprite {

    public boolean clickable;
    private float cooldownTimer;
    protected int cooldown;
    protected LudumDare game;

    public ClickableObject(float x, float y, LudumDare game) {
        this.game = game;
        setBounds(0, 0, 192, 192);
        setPosition(x, y);
        clickable = true;
    }

    public void update(float delta) {
        if(!clickable) {
            cooldownTimer += delta;
            setRegion(game.getManager().get("cooldown.png", Texture.class));
            if(cooldownTimer >= cooldown) {
                Gdx.app.log("Cooldown", "" + cooldown);
                clickable = true;
                cooldownTimer = 0;
            }
        }
    }
}
