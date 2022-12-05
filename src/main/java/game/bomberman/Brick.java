package game.bomberman;

import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;

public class Brick implements DrawableSimulable {

    private Point2D position;
    private Point2D size;
    private World world;

    public Brick(World world, Point2D position) {
        super();
        this.world = world;
        this.position = position;
    }


    public void simulate(double timeStep, Scene scene ) {

    }


    @Override
    public Point2D getPosition()
    {
        return new Point2D(position.getX(), position.getY());
    }

    public void draw(GraphicsContext gc,Scene scene) {
        Point2D canvasPosition = world.getCanvasPoint(position);
        gc.drawImage(Constants.BRICK_IMAGE, canvasPosition.getX(), canvasPosition.getY(), 50, 50);

    }



}
