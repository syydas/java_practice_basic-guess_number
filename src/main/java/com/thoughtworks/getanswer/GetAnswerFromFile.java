package com.thoughtworks.getanswer;

import com.thoughtworks.games.GameAnswer;
import com.thoughtworks.games.GenerateAnswer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GetAnswerFromFile implements GenerateAnswer {
    private GameAnswer gameAnswer;

    public GameAnswer getGameAnswer() {
        return gameAnswer;
    }

    public void setGameAnswer(String filePath) {
        Set<Integer> answer = new HashSet<>();
        try {
            InputStream input = new FileInputStream(filePath);
            int n;
            boolean isTrueFormat = true;
            while ((n = input.read()) != -1) {
                if (Character.isDigit((char) n)) {
                    if (!(answer.add(((char) n) - '0'))) {
                        isTrueFormat = false;
                    }
                }
            }
            if (isTrueFormat) {
                this.gameAnswer = new GameAnswer(answer);
            } else {
                this.gameAnswer = generateAnswerRandom(4);
            }
        } catch (IOException e) {
            System.out.println("文件不存在");
            this.gameAnswer = generateAnswerRandom(4);
        }

    }

    @Override
    public GameAnswer generateAnswerRandom(int answerLength) {
        Set<Integer> answer = new HashSet<>();
        while (answer.size() < answerLength) {
            Random random = new Random();
            answer.add(random.nextInt(10));
        }
        return new GameAnswer(answer);
    }
}
