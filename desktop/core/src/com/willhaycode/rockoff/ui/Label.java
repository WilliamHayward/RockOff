package com.willhaycode.rockoff.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Label extends Actor {
    private String text;
    private float x;
    private float y;
    private BitmapFont font;
    private float width;
    public Label(String text, float x, float y) {
        super();
        this.text = text;
        this.x = x;
        this.y = y;
        this.font = new BitmapFont();

        this.width = new GlyphLayout(font, text).width;

        this.x -= this.width / 2;
    }

	@Override
	public void draw(Batch batch, float parentAlpha) {
		font.draw(batch, text, x, y);
	}
}