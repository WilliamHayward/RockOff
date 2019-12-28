package com.willhaycode.rockoff;

import java.net.URISyntaxException;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.willhaycode.rockoff.lipwig.Host;

public class RockOff extends ApplicationAdapter {

	@Override
	public void create() {
		Gdx.app.log("Lipwig", "Launching Lipwig Connection");
		try {
			Host host = new Host("ws://localhost:8080");
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
