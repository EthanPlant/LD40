package com.exedo.ld.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.exedo.ld.LudumDare;

public class Battery extends ClickableObject {

    public Battery(float x, float y, LudumDare game, int cooldown) {
        super(x, y, game, cooldown);
        setRegion(game.getManager().get("battery.png", Texture.class));
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(clickable)
            setRegion(game.getManager().get("battery.png", Texture.class));
    }
}
