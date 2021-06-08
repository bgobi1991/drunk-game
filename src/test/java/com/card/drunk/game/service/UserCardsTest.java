package com.card.drunk.game.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.card.drunk.game.mock.MockData;
import com.card.drunk.game.utils.PlayerPosition;

@SpringBootTest
public class UserCardsTest extends MockData {

  UserCards userCards;
  private PlayerPosition playerPosition;
  @Mock CardService cardService;

  @BeforeEach
  public void setUp() {
    userCards = new UserCards(playerPosition, cardService);
  }

  @Test
  public void allocateCardsTest() {

    cardService.getCardFromStack(3);
    verify(cardService, times(1)).getCardFromStack(3);
  }
}
