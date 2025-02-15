package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// This class handles displaying a question's details and allowing users to answer.
public class QuestionDetailPage {
    private Question question;

    public QuestionDetailPage(Question question) {
        this.question = question;
    }

    public void show(Stage primaryStage) {
        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Label titleLabel = new Label(question.getTitle());
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label bodyLabel = new Label(question.getBody());
        bodyLabel.setStyle("-fx-font-size: 14px;");

        // Answer input field.
        TextArea answerInput = new TextArea();
        answerInput.setPromptText("Write your answer...");
        answerInput.setWrapText(true);

        Button submitAnswerButton = new Button("Submit Answer");
        submitAnswerButton.setOnAction(e -> {
            String answerText = answerInput.getText().trim();
            if (!answerText.isEmpty()) {
                question.addAnswer(answerText);
                show(primaryStage); // Refresh the page to display the new answer.
            }
        });

        // Display all answers.
        VBox answersBox = new VBox(5);
        for (String answer : question.getAnswers()) {
            Label answerLabel = new Label(answer);
            answerLabel.setStyle("-fx-background-color: #e0e0e0; -fx-padding: 5; -fx-border-radius: 5;");
            answersBox.getChildren().add(answerLabel);
        }

        Button backButton = new Button("Back to Questions");
        backButton.setOnAction(e -> new QuestionListPage().show(primaryStage));

        layout.getChildren().addAll(titleLabel, bodyLabel, answerInput, submitAnswerButton, new Label("Answers:"), answersBox, backButton);
        Scene scene = new Scene(layout, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Question Details");
    }
}