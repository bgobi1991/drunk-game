package com.card.drunk.game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.drunk.game.utils.PlayerPosition;

@Service
public class UserCards {

  private PlayerPosition playerPosition;
  private CardService cardService;

  @Autowired
  public UserCards(PlayerPosition playerPosition, CardService cardService) {
    this.playerPosition = playerPosition;
    this.cardService = cardService;
  }

  public void allocateCards(int user, int initNumber) {
    playerPosition.playerPositionMap.put(user, cardService.getCardFromStack(initNumber));
  }
}
