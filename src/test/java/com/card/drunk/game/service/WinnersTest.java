package com.card.drunk.game.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.card.drunk.game.mock.MockData;

@SpringBootTest
public class WinnersTest extends MockData {

  Winners winners;
  @Mock UserCards userCards;

  @BeforeEach
  public void setUp() {
    winners = new Winners(userCards);
  }

  @Test
  public void trialWinnerTest() {

    Map<Integer, List<Integer>> playerList = trialWinnerMock();

    List<Integer> winnerList = winners.trialWinner(playerList);

    assertEquals(winnerList.get(0), 4);
  }

  @Test
  public void sequenceWinnerTest() {

    Map<Integer, List<Integer>> playerList = sequenceWinnerMock();

    List<Integer> winnerList = winners.sequenceWinner(playerList);

    assertEquals(winnerList.get(0), 4);
  }

  @Test
  public void pairWinnerTest() {

    Map<Integer, List<Integer>> playerList = pairWinnerMock();

    List<Integer> winnerList = winners.pairWinner(playerList);

    assertEquals(winnerList.get(0), 1);
  }

  @Test
  public void topCardWinnerTest() {

    Map<Integer, List<Integer>> playerList = pairWinnerMock();

    List<Integer> winnerList = winners.topCardWinner(playerList);

    assertEquals(winnerList.get(0), 1);
  }
}
