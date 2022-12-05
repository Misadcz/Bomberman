package game.bomberman;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.util.Random;


public class Balloon extends JFrame implements DrawableSimulable, KeyListener, Collisionable {

    private Point2D position;
    private final double size = 45;
    private World world;
    int direction=0;
    private Point2D speed;

    public Balloon(World world, Point2D position, Point2D speed) {
        super();
        this.world = world;
        this.position = position;
        this.speed = speed;
        Random rand = new Random();
        direction = rand.nextInt(4);


        //    this.setLayout(null);
        //     this.addKeyListener(this);
        //    this.setVisible(true);
    }

    public void change_to_left()
    {
        direction = 0;
    }
    public void change_to_right()
    {
        direction = 1;
    }
    public void change_to_up()
    {
        direction = 2;
    }
    public void change_to_down()
    {
        direction = 3;
    }



    @Override
    public void simulate(double timeDelta, Scene scene ) {

        double timeDeltaS = timeDelta;

        if(direction == 0)
            position = new Point2D(position.getX()-1,position.getY());
        if(direction == 1)
            position = new Point2D(position.getX()+1,position.getY());
        if(direction == 2)
            position = new Point2D(position.getX(),position.getY()+1);
        if(direction == 3)
            position = new Point2D(position.getX(),position.getY()-1);

    }

    @Override
    public int hitBy(Point2D block)
    {return 0;}


    @Override
    public boolean can_move(Collisionable thisCollinsable,Collisionable thatCollinsable, Scene scene) {
        return false;
    }

    public Rectangle2D getBoundingBox() {
        return new Rectangle2D(position.getX(), position.getY(), size, size);
    }

    public void draw(GraphicsContext gc,Scene scene) {
        Point2D canvasPosition = world.getCanvasPoint(position);
        gc.drawImage(Constants.BALLOON_IMAGE, canvasPosition.getX(), canvasPosition.getY(), size, size);

    }


    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {

    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {

    }

    @Override
    public boolean intersects(Collisionable other) {
        return Collisionable.super.intersects(other);
    }
    @Override
    public Point2D getPosition()
    {
        return new Point2D(position.getX(), position.getY());
    }




}
