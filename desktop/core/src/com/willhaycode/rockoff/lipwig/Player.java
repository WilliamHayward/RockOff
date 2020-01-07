package com.willhaycode.rockoff.lipwig;

public class Player {
    private Host host;
    private String id;
    private String name;
    public Player(Host host, String id, String name) {
        this.host = host;
        this.id = id;
        this.name = name;
    }

    public void send(Message message) {
        this.host.send(message);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}