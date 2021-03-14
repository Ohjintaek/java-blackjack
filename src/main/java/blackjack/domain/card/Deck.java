package blackjack.domain.card;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Deck {

    private final Deque<Card> cards;

    public Deck() {
        cards = CardCache.cache;
    }

    public Deck(Cards cards) {
        this.cards = new ArrayDeque<>(cards.getCards());
    }

    public Card draw() {
        return cards.pop();
    }

    private static class CardCache {

        static final Deque<Card> cache;

        static {
            cache = create();
        }

        private static Deque<Card> create() {
            List<Card> cards = new ArrayList<>();
            for (Type type : Type.values()) {
                makeCard(type, cards);
            }
            Collections.shuffle(cards);
            return new ArrayDeque<>(cards);
        }

        private static void makeCard(Type type, List<Card> cards) {
            Arrays.stream(Denomination.values())
                .filter(denomination -> denomination != Denomination.ACE_ELEVEN)
                .map(denomination -> new Card(type, denomination))
                .forEach(cards::add);
        }

    }

}