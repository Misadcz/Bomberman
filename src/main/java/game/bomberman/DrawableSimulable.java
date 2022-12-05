package game.bomberman;

import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;

public interface DrawableSimulable {
    void draw(GraphicsContext gc,Scene scene);
    void simulate(double deltaT, Scene scene);
    Point2D getPosition();

}
