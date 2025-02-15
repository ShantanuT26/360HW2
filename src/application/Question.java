package application;

import java.util.ArrayList;

public class Question {
    private String title;
    private String body;
    private ArrayList<String> answers;

    public Question(String title, String body) {
        this.title = title;
        this.body = body;
        this.answers = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) { // Allows editing the title
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) { // Allows editing the body
        this.body = body;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void addAnswer(String answer) {
        answers.add(answer);
    }
}