package org.example.OOPChallenges.JavaFXGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class TextImageDisplay extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("Hello, JavaFX!");

        Image image = new Image(getClass().getResourceAsStream("/Factory_Design_Pattern.png"));
        if(image.isError()){
            System.out.println("Error loading image... " + image.getException());
        }
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(290);
        imageView.setPreserveRatio(true);

        VBox root = new VBox(10);
        root.getChildren().addAll(label, imageView);

        Scene scene = new Scene(root, 300, 300);
        stage.setTitle("Text and image display");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}

