package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// This class manages the main question list page, displaying all questions.
public class QuestionListPage {
    private Questions questions = new Questions();

    public void show(Stage primaryStage) {
        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Label titleLabel = new Label("List of Questions:");
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        layout.getChildren().add(titleLabel);

        for (Question question : questions.getAllQuestions()) {
            HBox questionRow = new HBox(10);
            questionRow.setAlignment(Pos.CENTER);

            // Button to view question details.
            Button questionButton = new Button(question.getTitle());
            questionButton.setOnAction(e -> new QuestionDetailPage(question).show(primaryStage));

            // Button to edit the selected question.
            Button editButton = new Button("Edit");
            editButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
            editButton.setOnAction(e -> new EditQuestionPage(question, this).show(primaryStage));

            // Button to delete the question.
            Button deleteButton = new Button("X");
            deleteButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
            deleteButton.setOnAction(e -> {
                questions.removeQuestion(question);
                show(primaryStage); // Refresh the list
            });

            questionRow.getChildren().addAll(questionButton, editButton, deleteButton);
            layout.getChildren().add(questionRow);
        }

        // Button to navigate to the "Ask a Question" page.
        Button askQuestionBtn = new Button("Ask a Question");
        askQuestionBtn.setOnAction(e -> new PostQuestionPage(this).show(primaryStage));

        // Button to return to the home page.
        Button backButton = new Button("Back to Home");
        backButton.setOnAction(e -> new UserHomePage(new databasePart1.DatabaseHelper()).show(primaryStage));

        layout.getChildren().addAll(askQuestionBtn, backButton);
        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Question List");
    }
}
