package com.exedo.ld.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.exedo.ld.LudumDare;


public class Bitcoin extends ClickableObject {

    public Bitcoin(float x, float y, LudumDare game) {
        super(x, y, game);
        setRegion(game.getManager().get("bitcoin.png", Texture.class));
        cooldown = 100;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(clickable)
            setRegion(game.getManager().get("bitcoin.png", Texture.class));
    }
}
