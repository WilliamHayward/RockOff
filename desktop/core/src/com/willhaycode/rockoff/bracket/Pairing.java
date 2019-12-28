package com.willhaycode.rockoff.bracket;

import com.willhaycode.rockoff.lipwig.Bot;
import com.willhaycode.rockoff.lipwig.Player;

public class Pairing {
    private Player player1;
    private Player player2;
    private Player winner = null;

    public Pairing(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Pairing(Pairing pairing1, Pairing pairing2) {
        this.player1 = pairing1.getWinner();
        this.player2 = pairing2.getWinner();
    }

    public Pairing(Player player) {
        this.player1 = player;
        this.player2 = new Bot();
    }
    public Pairing(Pairing pairing) {
        this.player1 = pairing.getWinner();
        this.player2 = new Bot();
    }

    public Player getWinner() {
        return this.winner;
    }
}