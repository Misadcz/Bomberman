package game.bomberman;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;

public interface Collisionable {
    Rectangle2D getBoundingBox();
    Point2D getPosition();


    default boolean intersects(Collisionable other) {
        return getBoundingBox().intersects(other.getBoundingBox());
    }

    int hitBy(Point2D block);

    boolean can_move(Collisionable thisCollinsable,Collisionable thatCollinsable, Scene scene);
}
