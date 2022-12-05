module game.bomberman {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;


    opens game.bomberman to javafx.fxml;
    exports game.bomberman;
}