package com.willhaycode.rockoff.lipwig;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class Host extends WebSocketClient {
    private String id = "";
    private Json json = new Json();
    public Host(String server) throws URISyntaxException {
        super(new URI(server));
        this.connect();
        json.setOutputType(JsonWriter.OutputType.json);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        Gdx.app.log("Lipwig", "Connection Opened");
        Message create = new Message("create", new ArrayList<String>(), new ArrayList<String>());
        this.send(create);
       //this.send("create", new JSONArray(), new JSONArray());
    }

    public void send(Message message) {
        String msgText = json.toJson(message);
        Gdx.app.log("Message Sent", msgText);
        this.send(msgText);
    }

    //public void send(String event, ArrayList data, ArrayList recipient) {
        //TODO: Move this to LibGDX JSON utility
        /*JSONObject message = new JSONObject();
        message.put("event", event);
        message.put("data", data);
        message.put("sender", this.id);
        message.put("recipient", recipient);
        this.send(message.toJSONString());*/
    //}

    @Override
    public void onMessage(String message) {
        Gdx.app.log("Message Received", message);
        //String thisClass = "class:com.willhaycode.rockoff.lipwig.Message,";
        //String javaMessage = message.substring(0, 1) + thisClass + message.substring(1, message.length());
        //dx.app.log("Java Message", javaMessage);
        //Gdx.app.log("???", "1");
        JsonReader reader = new JsonReader();
        JsonValue jsonMessage = reader.parse(message);
        String event = jsonMessage.getString("event");
        ArrayList<String> data = new ArrayList<>(Arrays.asList((jsonMessage.get("data").asStringArray())));
        String sender = jsonMessage.getString("sender");
        ArrayList<String> recipient = new ArrayList<>(Arrays.asList((jsonMessage.get("recipient").asStringArray())));
        Message received = new Message(event, data, sender, recipient);
        this.handle(received);
        //Message received = json.fromJson(Message.class, message);
        //Gdx.app.log("???", "2");
        //this.handle(received);

        //Gdx.app.log("???", "3");
        /*try {
            JSONObject messageJSON = (JSONObject) parser.parse(message);
            String event = messageJSON.get((Object) "event").toString();
            JSONArray data = (JSONArray) messageJSON.get((Object) "data");
            String sender = messageJSON.get((Object) "sender").toString();
            JSONArray recipient = (JSONArray) messageJSON.get((Object) "recipient");
            handle(event, data, sender, recipient);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }

    private void handle(Message message) {
        Gdx.app.log("???", "This should be reached");
        String event = message.getEvent();
        ArrayList<String> data = message.getData();
        String sender = message.getSender();
        ArrayList<String> recipient = message.getRecipient();
        Gdx.app.log("Event", event);

        switch (event) {
            case "created":
                Gdx.app.log("Created", "Now");
                
                String code = data.get(0).toString();
                this.id = code;
                Gdx.app.log("Code!", code);
            break;
        }
    }

    private void handle(String event, ArrayList<String> data, String sender, ArrayList<String> recipient) {
        Gdx.app.log("Event", event);

        switch (event) {
            case "created":
                Gdx.app.log("Created", "Now");
                
                String code = data.get(0).toString();
                this.id = code;
                Gdx.app.log("Code!", code);
            break;
        }

        /**
        if (event.equals("created")) {
            Gdx.app.log("Created", "Now");
            
            String code = data.get(0).toString();
            this.id = code;
            Gdx.app.log("Code!", code);
        } else if (event.equals("Hello")) {
            int count = Integer.parseInt(data.get(0).toString());
            Gdx.app.log("Count", String.valueOf(count));
            JSONArray newData = new JSONArray();
            newData.add(count + 1);

            JSONArray newRecipient = new JSONArray();
            newRecipient.add(sender);
            //this.send("Hello", newData, newRecipient);
        } */
        return;
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