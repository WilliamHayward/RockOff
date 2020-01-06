package com.willhaycode.rockoff.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
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
		/*Gdx.app.log("Lipwig", "Launching Lipwig Connection");
		try {
			this.host = new Host("ws://localhost:8080");
			Gdx.app.log("Lipwig", "Connection Launched");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }
    
    /**
     * Label text;
LabelStyle textStyle;
BitmapFont font = new BitmapFont();
//font.setUseIntegerPositions(false);(Optional)

textStyle = new LabelStyle();
textStyle.font = font;

text = new Label("Gamever",textStyle);
text.setBounds(0,.2f,Room.WIDTH,2);
text.setFontScale(1f,1f);
     */

    private void buildScreen() {
        switch (this.screen) {
            case CONNECTING:
                Texture txtreLogo = new Texture(Gdx.files.internal("Rock-Off-Logo.png"));
                Image logo = new Image(txtreLogo, 0, 0);
                logo.setWidth(this.getWidth(), true);
                this.addActor(logo);
                
                Label lblConnecting = new Label("Connecting to Lipwig...", this.getWidth() / 2, 25);
                this.addActor(lblConnecting);
            break;
            case LOBBY:

            break;
        }
    }
}