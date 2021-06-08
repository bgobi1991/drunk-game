package com.card.drunk.game.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerPosition {

  public Map<Integer, List<Integer>> playerPositionMap = new HashMap<>();

  @Autowired
  public PlayerPosition() {
    List<Integer> states = new ArrayList<>();
    this.playerPositionMap.put(1, states);
    this.playerPositionMap.put(2, states);
    this.playerPositionMap.put(3, states);
    this.playerPositionMap.put(4, states);
  }
}
