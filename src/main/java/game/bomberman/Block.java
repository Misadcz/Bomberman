package game.bomberman;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;

public class Block implements DrawableSimulable, Collisionable {

    private Point2D position;
    private Point2D size;
    private World world;

    public Block(World world, Point2D position, Point2D size) {
        super();
        this.world = world;
        this.position = position;
        this.size = size;
    }


    public void simulate(double timeSte, Scene scene ) {

    }

    public void draw(GraphicsContext gc,Scene scene) {
        Point2D canvasPosition = world.getCanvasPoint(position);
        gc.drawImage(Constants.BLOCK_IMAGE, canvasPosition.getX(), canvasPosition.getY(), 50, 50);

    }
    @Override
    public Point2D getPosition()
    {
        return new Point2D(position.getX(), position.getY());
    }



    public Rectangle2D getBoundingBox() {
        return new Rectangle2D(position.getX(), position.getY(), 50, 50);
    }

    @Override
    public int hitBy(Point2D block)
    {return 0;}

    @Override
    public boolean can_move(Collisionable thisCollinsable,Collisionable thatCollinsable, Scene scene) {
        return false;
    }
}
