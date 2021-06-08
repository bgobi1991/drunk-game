package com.card.drunk.game.mock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockData {

  public Map<Integer, List<Integer>> trialWinnerMock() {

    Map<Integer, List<Integer>> playerList = new HashMap<>();

    playerList.put(1, Arrays.asList(7, 10, 14));
    playerList.put(2, Arrays.asList(11, 14, 2));
    playerList.put(3, Arrays.asList(14, 8, 12));
    playerList.put(4, Arrays.asList(12, 12, 12));

    return playerList;
  }

  public Map<Integer, List<Integer>> sequenceWinnerMock() {

    Map<Integer, List<Integer>> playerList = new HashMap<>();

    playerList.put(1, Arrays.asList(7, 10, 14));
    playerList.put(2, Arrays.asList(11, 14, 2));
    playerList.put(3, Arrays.asList(14, 8, 12));
    playerList.put(4, Arrays.asList(4, 5, 6));

    return playerList;
  }

  public Map<Integer, List<Integer>> pairWinnerMock() {

    Map<Integer, List<Integer>> playerList = new HashMap<>();

    playerList.put(1, Arrays.asList(10, 10, 14));
    playerList.put(2, Arrays.asList(11, 14, 2));
    playerList.put(3, Arrays.asList(14, 8, 12));
    playerList.put(4, Arrays.asList(4, 5, 6));

    return playerList;
  }

  public Map<Integer, List<Integer>> topCardWinnerMock() {

    Map<Integer, List<Integer>> playerList = new HashMap<>();

    playerList.put(1, Arrays.asList(7, 12, 2));
    playerList.put(2, Arrays.asList(6, 4, 12));
    playerList.put(3, Arrays.asList(4, 8, 6));
    playerList.put(4, Arrays.asList(5, 14, 6));

    return playerList;
  }
}
