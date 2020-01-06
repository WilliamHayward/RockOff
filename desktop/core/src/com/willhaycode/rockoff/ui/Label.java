package com.willhaycode.rockoff.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Label extends Actor {
    private String text;
    private int x;
    private int y;
    public Label(String text, int x, int y) {
        super();
        this.text = text;
        this.x = x;
        this.y = y;
    }

	@Override
	public void draw(Batch batch, float parentAlpha) {
        BitmapFont font = new BitmapFont();
		font.draw(batch, text, x, y);
	}
}