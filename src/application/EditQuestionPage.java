package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// This class handles editing an existing question.
public class EditQuestionPage {
    private Question question;
    private QuestionListPage questionListPage;

    public EditQuestionPage(Question question, QuestionListPage questionListPage) {
        this.question = question;
        this.questionListPage = questionListPage;
    }

    public void show(Stage primaryStage) {
        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Input field for updating the question title.
        TextField titleInput = new TextField(question.getTitle());
        titleInput.setPromptText("Edit question title...");

        // Input field for updating the question body.
        TextArea bodyInput = new TextArea(question.getBody());
        bodyInput.setPromptText("Edit your question...");
        bodyInput.setWrapText(true);

        // Button to save the updated question.
        Button updateButton = new Button("Update Question");
        updateButton.setOnAction(e -> {
            String newTitle = titleInput.getText().trim();
            String newBody = bodyInput.getText().trim();
            if (!newTitle.isEmpty() && !newBody.isEmpty()) {
                question.setTitle(newTitle);
                question.setBody(newBody);
                questionListPage.show(primaryStage); // Refresh the question list
            }
        });

        // Button to cancel and return to the question list.
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> questionListPage.show(primaryStage));

        layout.getChildren().addAll(titleInput, bodyInput, updateButton, cancelButton);
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Edit Question");
    }
}