package com.exedo.ld.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.exedo.ld.LudumDare;

public class Battery extends ClickableObject {

    public Battery(float x, float y, LudumDare game) {
        super(x, y, game);
        setRegion(game.getManager().get("battery.png", Texture.class));
        cooldown = 10;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(clickable)
            setRegion(game.getManager().get("battery.png", Texture.class));
    }
}
