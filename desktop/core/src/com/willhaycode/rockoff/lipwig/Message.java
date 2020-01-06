package com.willhaycode.rockoff.lipwig;

import java.util.ArrayList;
import java.util.Arrays;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter;
public class Message {
    private String event;
    private ArrayList<String> data;
    private String sender;
    private ArrayList<String> recipient;

    public Message(String event, ArrayList<String> data, String sender, ArrayList<String> recipient) {
        this.event = event;
        this.data = data;
        this.sender = sender;
        this.recipient = recipient;
    }

    public Message(String event, ArrayList<String> data, ArrayList<String> recipient) {
        this(event, data, "", recipient);
    }

    public Message(String message) {
        JsonReader reader = new JsonReader();
        JsonValue jsonMessage = reader.parse(message);
        this.event = jsonMessage.getString("event");
        this.data = new ArrayList<>(Arrays.asList((jsonMessage.get("data").asStringArray())));
        this.sender = jsonMessage.getString("sender");
        this.recipient = new ArrayList<>(Arrays.asList((jsonMessage.get("recipient").asStringArray())));
    }

	public String getEvent() {
        return this.event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public ArrayList<String> getData() {
        return this.data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public ArrayList<String> getRecipient() {
        return this.recipient;
    }

    public void setRecipient(ArrayList<String> recipient) {
        this.recipient = recipient;
    }
    
    @Override
    public String toString() {
        Json json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);
        return json.toJson(this);
    }
}
