package com.exedo.ld.sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.exedo.ld.LudumDare;

public class LavaLamp extends ClickableObject {

    private TextureAtlas atlas;
    private Animation<TextureRegion> animation;
    private float elapsedTime;

    public LavaLamp(float x, float y, LudumDare game) {
        super(x, y, game);

        atlas = game.getManager().get("lavalamp.atlas", TextureAtlas.class);
        Array<TextureRegion> frames = new Array<TextureRegion>();
        for(int i = 0; i < 4; i++) {
            frames.add(new TextureRegion(atlas.findRegion("lavalamp"), i * 32, 0, 32, 32));
        }
        animation = new Animation<TextureRegion>(1/7f, frames);
        frames.clear();
        cooldown = 15;
    }

    @Override
    public void update(float delta) {
        elapsedTime += delta;
        super.update(delta);
        if(clickable) {
            setPosition(this.getX(), this.getY());
            setRegion(animation.getKeyFrame(elapsedTime, true));
        }
    }
}
