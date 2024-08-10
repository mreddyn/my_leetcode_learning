package com.company.servicenow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum Suit {
    CLUBS,
    SPADES,
    DIAMONDS,
    HEARTS
}

enum Rank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

public class CardsGame {
    private final List<Card> cards;

    class Card {
        private final Suit suit;
        private final Rank rank;

        public Card(Suit suit, Rank rank) {
            this.rank = rank;
            this.suit = suit;
        }

        public Suit getSuit() {
            return suit;
        }

        public Rank getRank() {
            return rank;
        }

        @Override
        public String toString() {
            return rank + " of " + suit;
        }
    }

    public CardsGame() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.remove(cards.size() - 1);
    }

    public int cardsRemaining() {
        return cards.size();
    }

    public static void main(String[] args) {
        CardsGame cardsGame = new CardsGame();
        cardsGame.shuffle();
        for (int i = 0; i < 5; i++) {
            Card card = cardsGame.drawCard();
            System.out.println(card);
        }
    }
}
