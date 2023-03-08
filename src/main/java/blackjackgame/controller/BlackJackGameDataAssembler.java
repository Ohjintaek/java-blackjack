package blackjackgame.controller;

import blackjackgame.domain.Card;
import blackjackgame.domain.GameOutcome;
import blackjackgame.domain.Guest;
import blackjackgame.dto.CardDto;
import blackjackgame.dto.DealerResultDto;
import blackjackgame.dto.GuestResultDto;

import java.util.*;

public class BlackJackGameDataAssembler {
    public static List<CardDto> transformCards(List<Card> cards) {
        List<CardDto> playerCards = new ArrayList<>();
        for (final Card card : cards) {
            playerCards.add(new CardDto(card.getSymbol(), card.getValue()));
        }
        return playerCards;
    }

    public static List<GuestResultDto> transformGuestsResult(Map<Guest, GameOutcome> guestsResult) {
        List<GuestResultDto> guestResults = new ArrayList<>();
        for (final Guest guest : guestsResult.keySet()) {
            guestResults.add(new GuestResultDto(guest.getName(), guestsResult.get(guest).getOutcome()));
        }
        return guestResults;
    }

    public static List<DealerResultDto> transformDealerResult(Map<GameOutcome, Integer> dealerResult) {
        List<DealerResultDto> dealerResults = new ArrayList<>();
        for (final GameOutcome gameOutcome : dealerResult.keySet()) {
            dealerResults.add(new DealerResultDto(gameOutcome.getOutcome(), dealerResult.get(gameOutcome)));
        }
        return dealerResults;
    }
}
