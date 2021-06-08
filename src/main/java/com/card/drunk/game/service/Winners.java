package com.card.drunk.game.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Winners {

  private UserCards userCards;

  @Autowired
  public Winners(UserCards userCards) {
    this.userCards = userCards;
  }

  public List<Integer> trialWinner(Map<Integer, List<Integer>> playerPosition) {
    List<Integer> winners = new ArrayList<>();
    for (Map.Entry<Integer, List<Integer>> entry : playerPosition.entrySet()) {

      boolean allEqual = entry.getValue().stream().distinct().limit(2).count() <= 1;

      if (allEqual) {
        winners.add(entry.getKey());
      }
    }

    if (winners.size() == 1) {
      System.out.println("Trial Winner | Player " + winners.get(0));
    } else {
      System.out.println("Trial Winner: " + (winners.size() == 0 ? "Failed" : "Tie"));
      sequenceWinner(playerPosition);
    }

    return winners;
  }

  public List<Integer> sequenceWinner(Map<Integer, List<Integer>> playerPosition) {

    List<Integer> winners = new ArrayList<>();

    for (Map.Entry<Integer, List<Integer>> entry : playerPosition.entrySet()) {

      List<Integer> listValues = entry.getValue();
      int firstValue = Collections.min(listValues);
      List<Integer> secondList =
          listValues.stream().filter(value -> value == firstValue + 1).collect(Collectors.toList());
      int secondValue = secondList.isEmpty() ? 0 : secondList.get(0);
      List<Integer> thirdList =
          listValues
              .stream()
              .filter(value -> value == secondValue + 1)
              .collect(Collectors.toList());

      int thirdValue = thirdList.isEmpty() ? 0 : secondList.get(0);
      if (firstValue != 0 && secondValue != 0 && thirdValue != 0) {
        winners.add(entry.getKey());
      }
    }
    if (winners.size() == 1) {
      System.out.println("Sequence Winner | Player " + winners.get(0));
    } else {
      System.out.println("Sequence Winner: " + (winners.size() == 0 ? "Failed" : "Tie"));
      pairWinner(playerPosition);
    }
    return winners;
  }

  public List<Integer> pairWinner(Map<Integer, List<Integer>> playerPosition) {

    List<Integer> winners = new ArrayList<>();

    for (Map.Entry<Integer, List<Integer>> entry : playerPosition.entrySet()) {
      List<Integer> listValues = entry.getValue();
      if (listValues.get(0) == listValues.get(1)
          || listValues.get(0) == listValues.get(2)
          || listValues.get(1) == listValues.get(2)) {
        winners.add(entry.getKey());
      }
    }
    if (winners.size() == 1) {
      System.out.println("Pair Winner | Player " + winners.get(0));
    } else {
      System.out.println("Pair Winner: " + (winners.size() == 0 ? "Failed" : "Tie"));
      topCardWinner(playerPosition);
    }
    return winners;
  }

  public List<Integer> topCardWinner(Map<Integer, List<Integer>> playerPosition) {

    List<Integer> winners = new ArrayList<>();
    int largestCard = 1;

    for (Map.Entry<Integer, List<Integer>> entry : playerPosition.entrySet()) {

      List<Integer> listValues = entry.getValue();

      for (int card : listValues) {
        if (card > largestCard) {
          largestCard = card;
        }
      }
    }
    for (Map.Entry<Integer, List<Integer>> entry : playerPosition.entrySet()) {
      List<Integer> listValues = entry.getValue();
      for (int card : listValues) {
        if (card == largestCard) {
          if (!winners.contains(entry.getKey())) {
            winners.add(entry.getKey());
          }
        }
      }
    }
    if (winners.size() == 1) {
      System.out.println("Top card Winner | User " + winners.get(0));
    } else {
      System.out.println("Top card Winner: " + (winners.size() == 0 ? "Failed" : "Tie"));
      tieWinner(winners, playerPosition);
    }
    return winners;
  }

  public void tieWinner(List<Integer> winners, Map<Integer, List<Integer>> playerPosition) {

    List<Integer> winnersList = new ArrayList<>();
    int largestCard = 1;

    for (int card : winners) {
      userCards.allocateCards(card, 1);
    }
    for (int card : winners) {
      if (playerPosition.get(card).get(0) > largestCard) {
        largestCard = playerPosition.get(card).get(0);
      }
    }

    for (int winner : winners) {
      if (playerPosition.get(winner).get(0) == largestCard) {
        if (!winners.contains(playerPosition.get(winner).get(0))) {
          winnersList.add(winner);
        }
      }
    }

    if (winnersList.size() == 1) {
      System.out.println("Top card Winner | Player " + winnersList.get(0));
    } else {
      tieWinner(winners, playerPosition);
    }
  }
}
