package com.exedo.ld.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.exedo.ld.LudumDare;

public class Tv extends ClickableObject {

    public Tv(float x, float y, LudumDare game) {
        super(x, y, game);
        setRegion(game.getManager().get("tv.png", Texture.class));
        cooldown = 60;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(clickable)
            setRegion(game.getManager().get("tv.png", Texture.class));
    }
}
