package com.thoughtworks;

import com.thoughtworks.games.Game;
import com.thoughtworks.games.GameAnswer;
import com.thoughtworks.getanswer.GetAnswerFromFile;

public class App {

  public static void main(String[] args) {
    GetAnswerFromFile readAnswerFromFile = new GetAnswerFromFile();
    readAnswerFromFile.setGameAnswer(".\\src\\main\\resources\\answer.txt");
    GameAnswer gameAnswer = readAnswerFromFile.getGameAnswer();
    System.out.println("游戏开始，请输入4个数字：");
    new Game(6).begin(gameAnswer);
  }
}
