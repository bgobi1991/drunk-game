package com.card.drunk.game.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.drunk.game.utils.CardsDeck;
import com.card.drunk.game.utils.PlayerPosition;

@Service
public class CardService {

  private PlayerPosition playerPosition;
  private CardsDeck cardsDeck;

  @Autowired
  public CardService(PlayerPosition playerPosition, CardsDeck cardsDeck) {
    this.playerPosition = playerPosition;
    this.cardsDeck = cardsDeck;
  }

  public void displayPlayerPosition() {

    for (Map.Entry<Integer, List<Integer>> entry : playerPosition.playerPositionMap.entrySet()) {
      List<String> cards = new ArrayList<>();
      for (int card : entry.getValue()) {
        switch (card) {
          case 14:
            cards.add("A");
            break;
          case 13:
            cards.add("K");
            break;
          case 12:
            cards.add("Q");
            break;
          case 11:
            cards.add("J");
            break;
          default:
            cards.add(String.valueOf(card));
            break;
        }
      }
      System.out.println("Player: " + entry.getKey() + ", | Cards: " + cards);
    }
  }

  public List<Integer> getCardFromStack(int number) {
    List<Integer> selectedCard = new ArrayList<>();

    if (totalCardCount() < number) return selectedCard;

    for (int i = 0; i < number; ++i) {
      int card = (int) Math.floor((Math.random() * 13) + 2);

      if (checkCardExist(card)) {
        switch (card) {
          case 14:
            deleteCard("a");
            break;
          case 13:
            deleteCard("k");
            break;
          case 12:
            deleteCard("q");
            break;
          case 11:
            deleteCard("j");
            break;
          default:
            deleteCard(String.valueOf(card));
            break;
        }
        selectedCard.add(card);
      } else if (number < 10) {
        ++number;
      } else {

        for (Map.Entry<String, Integer> entry : cardsDeck.cards.entrySet()) {
          if (entry.getValue() > 0) {
            deleteCard(entry.getKey());
            switch (entry.getKey()) {
              case "a":
                card = 14;
                break;
              case "k":
                card = 13;
                break;
              case "q":
                card = 12;
                break;
              case "j":
                card = 11;
                break;
              default:
                card = Integer.parseInt(entry.getKey());
                break;
            }
            selectedCard.add(card);
            break;
          }
        }
      }
    }
    
    return selectedCard;
  }

  public void deleteCard(String card) {
    cardsDeck.cards.put(card, cardsDeck.cards.get(card) - 1);
  }

  public int totalCardCount() {
    int count = 0;
    for (Map.Entry<String, Integer> entry : cardsDeck.cards.entrySet()) {
      count += entry.getValue();
    }
    return count;
  }

  public boolean checkCardExist(int card) {

    boolean state = false;

    switch (card) {
      case 14:
        if (cardsDeck.cards.get("a") > 0) {
          state = true;
        } else {
          state = false;
        }
        break;
      case 13:
        if (cardsDeck.cards.get("k") > 0) {
          state = true;
        } else {
          state = false;
        }
        break;
      case 12:
        if (cardsDeck.cards.get("q") > 0) {
          state = true;
        } else {
          state = false;
        }
        break;
      case 11:
        if (cardsDeck.cards.get("j") > 0) {
          state = true;
        } else {
          state = false;
        }
        break;
      default:
        if (cardsDeck.cards.get(String.valueOf(card)) > 0) {
          state = true;
        } else {
          state = false;
        }
        break;
    }

    return state;
  }
}
