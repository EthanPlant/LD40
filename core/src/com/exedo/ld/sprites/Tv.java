package com.exedo.ld.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.exedo.ld.LudumDare;

public class Tv extends ClickableObject {

    public Tv(float x, float y, LudumDare game, int cooldown) {
        super(x, y, game, cooldown);
        setRegion(game.getManager().get("tv.png", Texture.class));
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(clickable)
            setRegion(game.getManager().get("tv.png", Texture.class));
    }
}
