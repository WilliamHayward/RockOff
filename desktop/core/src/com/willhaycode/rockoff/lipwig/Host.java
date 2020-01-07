package com.willhaycode.rockoff.lipwig;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.willhaycode.rockoff.core.Game;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class Host extends WebSocketClient {
    private String id = "";
    private Player vip = null;
    private Game game;
    private ArrayList<Player> players = new ArrayList<>();
    public Host(Game game, String server) throws URISyntaxException {
        super(new URI(server));
        this.game = game;
        this.connect();
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        Gdx.app.log("Lipwig", "Connection Opened");
        Message create = new Message("create", new ArrayList<String>(), new ArrayList<String>());
        this.send(create);
    }

    public void send(Message message) {
        String strMessage = message.toString();
        Gdx.app.log("Message Sent", strMessage);
        this.send(strMessage);
    }

    @Override
    public void onMessage(String message) {
        Gdx.app.log("Message Received", message);

        Message received = new Message(message);
        this.handle(received);
    }

    private void handle(Message message) {
        String event = message.getEvent();
        ArrayList<String> data = message.getData();
        String sender = message.getSender();
        Gdx.app.log("Event", event);

        switch (event) {
            case "created":
                Gdx.app.log("Created", "Now");
                String code = data.get(0);
                this.id = code;
                this.game.startLobby(code);
                Gdx.app.log("Room Code", code);
            break;
            case "joined":
                String id = data.get(0);
                String name = data.get(1);
                Player player = new Player(this, id, name);
                if (vip == null) {
                    vip = player;
                }
                this.players.add(player);
            break;
            case "start":
                if (vip.getId().equals(sender)) {
                    Gdx.app.log("Start", "VIP");
                } else {
                    Gdx.app.log("Start", "NOT the VIP");
                }
            break;
        }
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onError(Exception ex) {
        // TODO Auto-generated method stub

    }
}