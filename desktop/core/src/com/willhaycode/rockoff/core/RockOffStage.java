package com.willhaycode.rockoff.core;

import java.net.URISyntaxException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.willhaycode.rockoff.lipwig.Host;
import com.willhaycode.rockoff.ui.Image;
import com.willhaycode.rockoff.ui.Label;

public class RockOffStage extends Stage {
    private Host host;
    private Screen screen;

    public RockOffStage(ScreenViewport screenViewport) {
        super(screenViewport);
        this.screen = Screen.CONNECTING;
        this.buildScreen();
    }

    private void buildScreen() {
        switch (this.screen) {
            case CONNECTING:
                Texture txtreLogo = new Texture(Gdx.files.internal("Rock-Off-Logo.png"));
                Image logo = new Image(txtreLogo, 0, 0);
                logo.setWidth(this.getWidth(), true);
                this.addActor(logo);

                Label lblConnecting = new Label("Connecting to Lipwig...", this.getWidth() / 2, 25);
                this.addActor(lblConnecting);

                try {
                    this.host = new Host("ws://localhost:8080");
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            break;
            case LOBBY:

            break;
        }
    }
}