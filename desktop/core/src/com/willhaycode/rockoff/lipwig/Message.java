package com.willhaycode.rockoff.lipwig;

import java.util.ArrayList;

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
    
    
}
