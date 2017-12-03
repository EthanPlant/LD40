package com.exedo.ld.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.exedo.ld.LudumDare;

public class Phone extends ClickableObject {

    public Phone(float x, float y, LudumDare game) {
        super(x, y, game);
        setRegion(game.getManager().get("phone.png", Texture.class));
        cooldown = 90;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(clickable)
            setRegion(game.getManager().get("phone.png", Texture.class));
    }
}
