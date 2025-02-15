package application;

import databasePart1.DatabaseHelper;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserHomePage {
    private final DatabaseHelper databaseHelper;

    public UserHomePage(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void show(Stage primaryStage) {
        VBox layout = new VBox();
        layout.setStyle("-fx-alignment: center; -fx-padding: 20;");

        Label userLabel = new Label("Hello, User!");
        userLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Button viewQuestions = new Button("View Questions");
        viewQuestions.setOnAction(e -> new QuestionListPage().show(primaryStage));

        Button returnHome = new Button("Return Home");
        returnHome.setOnAction(a -> new SetupLoginSelectionPage(databaseHelper).show(primaryStage));

        layout.getChildren().addAll(userLabel, viewQuestions, returnHome);
        Scene userScene = new Scene(layout, 800, 400);
        primaryStage.setScene(userScene);
        primaryStage.setTitle("User Page");
    }
}