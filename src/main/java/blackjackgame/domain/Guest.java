package blackjackgame.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Guest {
    Name name;
    List<Card> cards;

    public Guest(Name name) {
        this.name = name;
        cards = new ArrayList<>();
    }

    public int getScore() {
        int totalScore = 0;
        boolean hasAce = false;
        for (Card card : cards) {
            hasAce |= (card.getCardValue().equals(CardValue.ACE));
            totalScore += card.getScore();
        }
        if (hasAce && totalScore <= 11) {
            totalScore += 10;
        }
        return totalScore;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public String getName() {
        return name.getName();
    }

    public List<Card> getCards() {
        return List.copyOf(cards);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Guest guest = (Guest)o;
        return Objects.equals(name, guest.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
