package com.thoughtworks.games;

import com.thoughtworks.exception.WrongInputException;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class GameAnswer {
    private Set<Integer> gameAnswer;

    public GameAnswer(Set<Integer> gameAnswer) {
        this.gameAnswer = gameAnswer;
    }

    public String compareWithGameAnswer(String inputAnswer) {
        Set<Integer> inputAnswerSet = new LinkedHashSet<>();
        for (char c : inputAnswer.toCharArray()) {
            inputAnswerSet.add(c - '0');
        }
        try {
            if (hasTrueFormatOfInputAnswer(inputAnswer, inputAnswerSet)) {
                int countOfCorrectPosAndNum = countOfCorrectPosAndNum(inputAnswerSet);
                int countOfCorrectNum = countOfCorrectNumWrongPos(inputAnswerSet);
                if (countOfCorrectPosAndNum == this.gameAnswer.size()) {
                    return "";
                }
                return countOfCorrectPosAndNum + "A" + countOfCorrectNum + "B";
            } else {
                throw new WrongInputException("Wrong input");
            }
        } catch (WrongInputException e) {
            return "Wrong input";
        }

    }

    private boolean hasTrueFormatOfInputAnswer(String inputAnswer, Set<Integer> inputAnswerSet) {
        boolean isTrueFormat = false;
        if (inputAnswer.length() == this.gameAnswer.size() && inputAnswerSet.size() == this.gameAnswer.size()) {
            isTrueFormat = true;
        }
        return isTrueFormat;
    }

    private int countOfCorrectPosAndNum(Set<Integer> inputAnswerSet) {
        int countOfCorrectPosAndNum = 0;
        Iterator<Integer> iteratorOfGameAnswer = this.gameAnswer.iterator();
        Iterator<Integer> iteratorOfInputAnswer = inputAnswerSet.iterator();
        while (iteratorOfGameAnswer.hasNext() && iteratorOfInputAnswer.hasNext()) {
            if (iteratorOfGameAnswer.next().equals(iteratorOfInputAnswer.next())) {
                countOfCorrectPosAndNum++;
            }
        }
        return countOfCorrectPosAndNum;
    }

    private int countOfCorrectNumWrongPos(Set<Integer> inputAnswerSet) {
        int countOfCorrectNumWrongPos = 0;
        Integer[] gameAnswerArray = this.gameAnswer.toArray(new Integer[0]);
        Integer[] inputAnswerArray = inputAnswerSet.toArray(new Integer[0]);
        for (int i = 0; i < gameAnswerArray.length; i++) {
            for (int j = 0; j < inputAnswerArray.length; j++) {
                if (gameAnswerArray[i].equals(inputAnswerArray[j]) && i != j) {
                    countOfCorrectNumWrongPos++;
                }
            }
        }
        return countOfCorrectNumWrongPos;
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();
        for (Integer integer : this.gameAnswer) {
            answer.append(integer);
        }
        return answer.toString();
    }
}
