package com.exedo.ld.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.exedo.ld.LudumDare;

public abstract class ClickableObject extends Sprite {

    public boolean clickable;
    private float cooldownTimer;
    protected int cooldown;
    protected LudumDare game;
    private TextureAtlas atlas;
    private Animation<TextureRegion> cooldownAnim;
    protected float cooldownAnimTime;

    public ClickableObject(float x, float y, LudumDare game, int cooldown) {
        this.game = game;
        setBounds(0, 0, 192, 192);
        setPosition(x, y);
        clickable = true;
        this.cooldown = cooldown;

        atlas = game.getManager().get("cooldown.atlas", TextureAtlas.class);
        Array<TextureRegion> frames = new Array<TextureRegion>();
        for(int i = 0; i < 8; i++) {
            frames.add(new TextureRegion(atlas.findRegion("cooldown"), i * 32, 0, 32, 32));
        }
        cooldownAnim = new Animation<TextureRegion>( (1 / 8f) * cooldown, frames);
        frames.clear();
    }

    public void update(float delta) {
        if(!clickable) {
            cooldownAnimTime += delta;
            cooldownTimer += delta;
            setRegion(cooldownAnim.getKeyFrame(cooldownAnimTime));
            if(cooldownTimer >= cooldown) {
                Gdx.app.log("Cooldown", "" + cooldown);
                clickable = true;
                cooldownTimer = 0;
                cooldownAnimTime = 0;
            }
        }
    }
}
