package game.bomberman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application  {

    private HelloController controller;


    @Override
    public void start(Stage primaryStage) throws Exception{


            Parent root = FXMLLoader.load(this.getClass().getResource("second-view.fxml"));
            primaryStage.setScene(new Scene(root,750,500));
            primaryStage.resizableProperty().set(false);
            primaryStage.setTitle("Bomberman");

            primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}