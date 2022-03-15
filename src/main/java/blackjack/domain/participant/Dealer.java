package blackjack.domain.participant;

public class Dealer extends Participant {

    private static final String DEALER_NAME = "딜러";
    private static final int MIN_SCORE_STANDARD = 16;

    public Dealer() {
        super(DEALER_NAME);
    }

    public boolean checkUnderScoreStandard() {
        return holdingCards.cardSum() <= MIN_SCORE_STANDARD;
    }

    public ParticipantDto getDealerInfoWithoutHiddenCard() {
        return ParticipantDto.of(name, holdingCards.getCardsWithOutHiddenCard());
    }

    public ParticipantDto getDealerInfoWithScore() {
        return ParticipantDto.of(name, holdingCards.getAllCards(), holdingCards.cardSum());
    }
}
