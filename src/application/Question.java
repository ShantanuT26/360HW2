package application;

import java.util.ArrayList;

// This class represents a question with a title, body, and a list of answers.
public class Question {
    private String title;
    private String body;
    private ArrayList<String> answers;

    // Constructor to initialize a question with a title and body.
    public Question(String title, String body) {
        this.title = title;
        this.body = body;
        this.answers = new ArrayList<>(); // Initializes an empty answer list.
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) { // Updates the title of the question.
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) { // Updates the body text of the question.
        this.body = body;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void addAnswer(String answer) { // Adds a new answer to the list.
        answers.add(answer);
    }
}