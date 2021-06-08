package com.card.drunk.game.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.drunk.game.utils.PlayerPosition;

@Service
public class PlayCards {

  private CardService cardService;
  private PlayerPosition playerPosition;
  private UserCards userCards;
  private Winners winners;

  @Autowired
  public PlayCards(
      CardService cardService,
      PlayerPosition playerPosition,
      UserCards userCards,
      Winners winners) {
    this.cardService = cardService;
    this.playerPosition = playerPosition;
    this.userCards = userCards;
    this.winners = winners;
  }

  public void distributeCard(boolean stateValue) {

    for (Map.Entry<Integer, List<Integer>> entry : playerPosition.playerPositionMap.entrySet()) {
      if (stateValue) userCards.allocateCards(entry.getKey(), 3);
    }

    cardService.displayPlayerPosition();

    winners.trialWinner(playerPosition.playerPositionMap);
  }
}
