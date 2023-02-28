package blackjackgame.domain;

public class CardMachine {
    Cards cards;

    public CardMachine(Cards cards) {
        this.cards = cards;
    }

    public void initPlayersCards(Guests guests, Dealer dealer) {
        dealer.addCard(cards.pickOne());
        dealer.addCard(cards.pickOne());

        for (Guest guest : guests.getGuests()) {
            guest.addCard(cards.pickOne());
            guest.addCard(cards.pickOne());
        }
    }
}
