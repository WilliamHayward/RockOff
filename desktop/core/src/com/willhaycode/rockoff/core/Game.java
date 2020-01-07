package com.willhaycode.rockoff.core;

import java.net.URISyntaxException;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.willhaycode.rockoff.lipwig.Host;
import com.willhaycode.rockoff.ui.Screen;

public class Game {
    private Host host = null;
    private Stage stage;
    private Screen screen = null;
    private HashMap<Screen, Group> screens;
    private LabelStyle lblStyle = new LabelStyle(new BitmapFont(), Color.WHITE);
    public Game(Stage stage) {
        this.stage = stage;

        initScreens();

        try {
            this.host = new Host(this, "ws://localhost:8080");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        if (this.host == null) {
            Gdx.app.log("Error", "Something went wrong connecting to Lipwig");
            Gdx.app.exit();
        }
    }

    private void initScreens() {
        screens = new HashMap<>();
        Group screen = this.buildConnecting();
        screens.put(Screen.CONNECTING, screen);

        showScreen(Screen.CONNECTING);
    }

    private void showScreen(Screen screen) {
        Group currentScreen;
        if (this.screen != null) {
            currentScreen = this.screens.get(this.screen);
            currentScreen.remove();
        }
        this.screen = screen;
        currentScreen = this.screens.get(this.screen);
        this.stage.addActor(currentScreen);
    }

    public void startLobby(String code) {
        Group lobby = this.buildLobby(code);
        screens.put(Screen.LOBBY, lobby);

        this.showScreen(Screen.LOBBY);
    }

    public Host getHost() {
        return this.host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public Stage getStage() {
        return this.stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Group buildConnecting() {
        Group group = new Group();

        float screenWidth = this.stage.getWidth();
        Texture txtreLogo = new Texture(Gdx.files.internal("Rock-Off-Logo.png"));
        Image logo = new Image(txtreLogo);
        float difference = logo.getWidth() / screenWidth;
        float newHeight = logo.getHeight() / difference;
        logo.setSize(screenWidth, newHeight);
        group.addActor(logo);

        Label lblConnecting = new Label("Connecting to Lipwig...", lblStyle);
        float lblWidth = lblConnecting.getWidth();
        lblConnecting.setPosition(screenWidth / 2 - lblWidth / 2, 25);
        group.addActor(lblConnecting);

        return group;
    }

    public Group buildLobby(String code) {
        Group group = new Group();

        float screenWidth = this.stage.getWidth();
        float screenHeight = this.stage.getHeight();
        String strJoin = "Go to Lipwig and enter code ".concat(code).concat(" to join");

        Label lblCode = new Label(strJoin, lblStyle);
        float lblWidth = lblCode.getWidth();
        float lblHeight = lblCode.getHeight();
        lblCode.setPosition(screenWidth / 2 - lblWidth / 2, screenHeight - lblHeight);
        group.addActor(lblCode);

        return group;
    }

}