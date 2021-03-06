package com.willhaycode.rockoff;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.willhaycode.rockoff.core.Game;

public class RockOff extends ApplicationAdapter {
	private Stage stage;
	
	@Override
	public void create() {
		Gdx.input.setInputProcessor(this.stage);
		Gdx.gl.glClearColor(0f/255f, 155f/255f, 119f/255f, 1);
		this.stage = new Stage(new ScreenViewport());

        Game game = new Game(stage);
	}
	public void resize (int width, int height) {
		stage.getViewport().update(width, height, true);
	}
	
	public void render () {
		float delta = Gdx.graphics.getDeltaTime();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
	}
	
	public void dispose () {
		stage.dispose();
	}
}
