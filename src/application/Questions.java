package application;

import java.util.ArrayList;

// This class manages a collection of questions.
public class Questions {
    private static ArrayList<Question> questionList = new ArrayList<>();

    // Adds a new question to the list.
    public void addQuestion(String title, String body) {
        questionList.add(new Question(title, body));
    }

    // Returns all stored questions.
    public ArrayList<Question> getAllQuestions() {
        return questionList;
    }

    // Removes a question from the list.
    public void removeQuestion(Question question) {
        questionList.remove(question);
    }

    // Updates an existing question with a new title and body.
    public void updateQuestion(Question oldQuestion, String newTitle, String newBody) {
        oldQuestion.setTitle(newTitle);
        oldQuestion.setBody(newBody);
    }
}