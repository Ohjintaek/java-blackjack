package blackjackgame.domain;

public class Card {
    private final Symbol symbol;
    private final CardValue cardValue;

    public Card(final Symbol symbol, final CardValue cardValue) {
        this.symbol = symbol;
        this.cardValue = cardValue;
    }

    public int getScore() {
        return cardValue.getScore();
    }

    public CardValue getValue() {
        return cardValue;
    }

    public String getCardValue() {
        return cardValue.getValue();
    }
}
