package com.willhaycode.rockoff;

import java.net.URISyntaxException;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.willhaycode.rockoff.lipwig.Lipwig;

public class RockOff extends ApplicationAdapter {

	@Override
	public void create() {
		Gdx.app.log("Lipwig", "Launching Lipwig Connection");
		try {
			Lipwig lw = new Lipwig("ws://localhost:8080");
			lw.connect();
			Gdx.app.log("Lipwig", "Connection Launched");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void render () {
	}
	
	@Override
	public void dispose () {
	}
}
