package com.willhaycode.rockoff.core;

import java.net.URISyntaxException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.willhaycode.rockoff.lipwig.Host;
import com.willhaycode.rockoff.ui.Screen;

public class RockOffStage extends Stage {
    private Game game;

    public RockOffStage(ScreenViewport screenViewport) {
        super(screenViewport);
        this.game = new Game(this);
    }
}