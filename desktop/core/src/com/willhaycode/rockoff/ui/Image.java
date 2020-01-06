package com.willhaycode.rockoff.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Image extends Actor {
    private Texture texture;
    private float x;
    private float y;
    private float width;
    private float height;
    public Image(Texture texture, float x, float y) {
        super();
        this.texture = texture;
        this.x = x;
        this.y = y;

        this.width = texture.getWidth();
        this.height = texture.getHeight();
    }

	@Override
	public void draw(Batch batch, float parentAlpha) {
        SpriteBatch spriteBatch = (SpriteBatch) batch;
        spriteBatch.draw(texture, x, y, width, height);
    }
    
    public void setWidth(float width, boolean proportional) {
        if (proportional) {
            float difference = this.width / width;
            this.height /= difference;
        }
        this.width = width;
    }
}