package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwentyOneGame {
    private List<Card> deck;
    private List<Card> playerHand;
    private List<Card> computerHand;
    private boolean gameOver;
    private int balance;

    public TwentyOneGame() {
        deck = new ArrayList<>();
        playerHand = new ArrayList<>();
        computerHand = new ArrayList<>();
        gameOver = false;
        balance = 100; // Starting balance

        initializeDeck();
        shuffleDeck();
        dealInitialCards();
    }

    private void initializeDeck() {
        Collections.addAll(deck, Card.values());
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    private void dealInitialCards() {
        playerHand.add(drawCard());
        computerHand.add(drawCard());
        playerHand.add(drawCard());
        computerHand.add(drawCard());
    }

    public int getPlayerScore() {
        return calculateScore(playerHand);
    }

    public int getComputerScore() {
        return calculateScore(computerHand);
    }

    private int calculateScore(List<Card> hand) {
        int score = 0;
        int numberOfAces = 0;

        for (Card card : hand) {
            score += card.getValue();
            if (card == Card.ACE) {
                numberOfAces++;
            }
        }

        while (score > 21 && numberOfAces > 0) {
            score -= 10;
            numberOfAces--;
        }

        return score;
    }


    public void playerHit() {
        if (!gameOver) {
            playerHand.add(drawCard());
            if (getPlayerScore() > 21) {
                gameOver = true;
                balance -= 10; // Penalty for busting
            }
        }
    }

    public void computerPlay() {
        while (getComputerScore() < 17) {
            computerHand.add(drawCard());
        }
        gameOver = true;
    }

    private Card drawCard() {
        if (deck.isEmpty()) {
            shuffleDeck();
        }
        return deck.remove(0);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public List<Card> getComputerHand() {
        return computerHand;
    }

    public int getBalance() {
        return balance;
    }

    public void updateBalance(int amount) {
        balance += amount;
    }

    public void setDeck(List<Card> customDeck) {
        deck = new ArrayList<>(customDeck);
        shuffleDeck();
    }





}
