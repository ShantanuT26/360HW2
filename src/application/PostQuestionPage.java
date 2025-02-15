package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PostQuestionPage {
    private QuestionListPage questionListPage;

    public PostQuestionPage(QuestionListPage questionListPage) {
        this.questionListPage = questionListPage;
    }

    public void show(Stage primaryStage) {
        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        TextField titleInput = new TextField();
        titleInput.setPromptText("Enter question title...");

        TextArea bodyInput = new TextArea();
        bodyInput.setPromptText("Enter your question...");
        bodyInput.setWrapText(true);

        Button postButton = new Button("Post Question");
        postButton.setOnAction(e -> {
            String title = titleInput.getText().trim();
            String body = bodyInput.getText().trim();
            if (!title.isEmpty() && !body.isEmpty()) {
                Questions questions = new Questions();
                questions.addQuestion(title, body);
                questionListPage.show(primaryStage);
            }
        });

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> questionListPage.show(primaryStage));

        layout.getChildren().addAll(titleInput, bodyInput, postButton, cancelButton);
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ask a Question");
    }
}