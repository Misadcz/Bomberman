package game.bomberman;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;

import javax.swing.*;
import java.awt.event.KeyListener;


public class Hero extends JFrame implements DrawableSimulable, KeyListener, Collisionable {

    private Point2D position;
    private final double size = 45;
    private World world;
    Control control = new Control();


    public Hero(World world, Point2D position ) {
        super();
        this.world = world;
        this.position = position;
    }

    @Override
    public int hitBy(Point2D block) {
        return 0;
    }

    public Rectangle2D getBoundingBox() {
        return new Rectangle2D(position.getX(), position.getY(), size, size);
    }
    public Rectangle2D next_move_right() {
        return new Rectangle2D(position.getX()+5, position.getY(), size, size);
    }
    public Rectangle2D next_move_up() {
        return new Rectangle2D(position.getX(), position.getY()+5, size, size);
    }
    public Rectangle2D next_move_left() {
        return new Rectangle2D(position.getX()-5, position.getY(), size, size);
    }
    public Rectangle2D next_move_down() {
        return new Rectangle2D(position.getX(), position.getY()-5, size, size);
    }

    public void move_right() {position = new Point2D(position.getX() + 1,position.getY());}
    public void move_left()
    {
        position = new Point2D(position.getX() - 1, position.getY());
    }
    public void move_up()
    {
        position = new Point2D(position.getX(),position.getY() + 1);
    }
    public void move_down()
    {
        position = new Point2D(position.getX(),position.getY() - 1);
    }


    @Override
    public boolean can_move(Collisionable thisCollinsable,Collisionable thatCollinsable,Scene scene)
    {

        Rectangle2D block = new Rectangle2D (thatCollinsable.getPosition().getX(),thatCollinsable.getPosition().getY(),50,50);
        Rectangle2D hero = new Rectangle2D (thisCollinsable.getPosition().getX()+5,thisCollinsable.getPosition().getY(),50,50);
        if(hero.intersects(block))
            return true;
        return false;

    }

    @Override
    public void simulate(double deltaT, Scene scene ) {
        double timeDeltaS = deltaT;

        control.handle(scene);
        if(control.left == true)
        {
        move_left();}
        if(control.right == true)
        {
        move_right();}
        if(control.up == true)
        {
          move_up();}
        if(control.down == true)
        {
         move_down();}


    }


    public boolean canPlant() {
        if(control.bomb)
            return true;
        return false;
    }

    public void draw(GraphicsContext gc,Scene scene) {
        Point2D canvasPosition = world.getCanvasPoint(position);

        if(control.left == true)
        {
            gc.drawImage(Constants.HERO_IMAGE_LEFT, canvasPosition.getX(), canvasPosition.getY(), size, size);
        }
        else if(control.right == true)
        {
            gc.drawImage(Constants.HERO_IMAGE_RIGHT, canvasPosition.getX(), canvasPosition.getY(), size, size);
        }
        else if(control.up == true)
        {
            gc.drawImage(Constants.HERO_IMAGE_UP, canvasPosition.getX(), canvasPosition.getY(), size, size);
        }
        else if(control.down == true)
        {
            gc.drawImage(Constants.HERO_IMAGE_DOWN, canvasPosition.getX(), canvasPosition.getY(), size, size);
        }
        else
        {
            gc.drawImage(Constants.HERO_IMAGE_PASSIVE, canvasPosition.getX(), canvasPosition.getY(), size, size);
        }


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
