package application;

import java.util.ArrayList;

public class Questions {
    private static ArrayList<Question> questionList = new ArrayList<>();

    public void addQuestion(String title, String body) {
        questionList.add(new Question(title, body));
    }

    public ArrayList<Question> getAllQuestions() {
        return questionList;
    }

    public void removeQuestion(Question question) {
        questionList.remove(question);
    }

    public void updateQuestion(Question oldQuestion, String newTitle, String newBody) {
        oldQuestion.setTitle(newTitle);
        oldQuestion.setBody(newBody);
    }
}