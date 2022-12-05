package game.bomberman;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;

public class Door implements DrawableSimulable,Collisionable{


    private Point2D position;
    private World world;
    public Door(World world, Point2D position ) {
        super();
        this.world = world;
        this.position = position;
    }


    @Override
    public void draw(GraphicsContext gc,Scene scene) {
        Point2D canvasPosition = world.getCanvasPoint(position);
        gc.drawImage(Constants.DOORS_IMAGE, canvasPosition.getX(), canvasPosition.getY(), 45, 45);

    }
    @Override
    public void simulate(double deltaT, Scene scene ) {

    }

    @Override
    public Rectangle2D getBoundingBox() {
        return null;
    }

    @Override
    public Point2D getPosition() {
        return position;
    }

    @Override
    public int hitBy(Point2D block) {
        return 0;
    }

    @Override
    public boolean can_move(Collisionable thisCollinsable, Collisionable thatCollinsable, Scene scene) {
        return false;
    }

}
