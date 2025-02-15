package application;

import java.util.ArrayList;

public class Answer {
    private static ArrayList<String> answers = new ArrayList<>();

    public static void addAnswer(String answer) {
        answers.add(answer);
    }

    public static ArrayList<String> getAllAnswers() {
        return answers;
    }
}