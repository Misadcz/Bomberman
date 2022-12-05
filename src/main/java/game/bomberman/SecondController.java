package game.bomberman;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class SecondController {

    HelloController controller;
    @FXML
    Button btn;

    public void handleBtn() throws Exception
    {

        Parent rooty = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage window =(Stage) btn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("hello-view.fxml"));
        BorderPane root = loader.load();
        Scene scene = new Scene(root);
        window.setScene(scene);

        controller = loader.getController();
        controller.startGame(scene,loader);

    }
}
