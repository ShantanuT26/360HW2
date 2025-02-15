package application;

import java.util.ArrayList;

// This class represents a collection of answers.
public class Answer {
    private static ArrayList<String> answers = new ArrayList<>();

    // Adds a new answer to the list.
    public static void addAnswer(String answer) {
        answers.add(answer);
    }

    // Returns all stored answers.
    public static ArrayList<String> getAllAnswers() {
        return answers;
    }
}