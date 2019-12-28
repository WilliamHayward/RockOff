package com.willhaycode.rockoff.lipwig;

import java.net.URI;
import java.net.URISyntaxException;

import com.badlogic.gdx.Gdx;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Lipwig extends WebSocketClient {
    public Lipwig(String server) throws URISyntaxException {
        super(new URI(server));
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        Gdx.app.log("Lipwig", "Connection Opened");
        // TODO Auto-generated method stub
        JSONObject message = new JSONObject();
        message.put("event", "create");
        message.put("data", new JSONArray());
        message.put("sender", "");
        message.put("recipient", new JSONArray());
        this.send(message.toJSONString());

    }

    @Override
    public void onMessage(String message) {
        Gdx.app.log("Message", message);
        JSONParser messageParser = new JSONParser();
        try {
            JSONObject messageJSON = (JSONObject) messageParser.parse(message);
            Gdx.app.log("Event", messageJSON.get((Object) "event").toString());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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