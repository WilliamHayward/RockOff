package com.willhaycode.rockoff.bracket;

import java.util.ArrayList;

import com.willhaycode.rockoff.lipwig.Bot;
import com.willhaycode.rockoff.lipwig.Player;

public class Bracket {
    public Bracket(ArrayList<Player> players) {
        int playerCount = players.size();
        ArrayList<Player> playersFull = new ArrayList<>(players);

        if (playerCount % 2 == 1) {
            playersFull.add(new Bot());
        }

        int round = 0;
        ArrayList<ArrayList<Pairing>> rounds = new ArrayList<>();
        int i = 0;
        rounds.add(new ArrayList<Pairing>());
        Player player1;
        Player player2;
        Pairing pairing;
        do {
            player1 = playersFull.get(i);
            i++;
            player2 = playersFull.get(i);
            i++;
            pairing = new Pairing(player1, player2);
            rounds.get(round).add(pairing);
        } while (i < playersFull.size());

    }
}