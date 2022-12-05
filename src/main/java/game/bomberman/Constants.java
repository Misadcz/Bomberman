package game.bomberman;

import javafx.scene.image.Image;

public final class Constants {
    private Constants() {}

    public static final Image HERO_IMAGE;
    public static final Image HERO_IMAGE_PASSIVE;
    public static final Image HERO_IMAGE_LEFT;
    public static final Image HERO_IMAGE_UP;
    public static final Image BRICK_IMAGE;
    public static final Image BLOCK_IMAGE;
    public static final Image BOMB_IMAGE;
    public static final Image EXPLOSION_IMAGE;
    public static final Image HERO_IMAGE_RIGHT;
    public static final Image HERO_IMAGE_DOWN;

    public static final Image BALLOON_IMAGE;
    public static final Image DOORS_IMAGE;
   // public static final Image DOORS_IMAGE;

    static{
        HERO_IMAGE = new Image(Constants.class.getResourceAsStream("hero.png"));
        HERO_IMAGE_PASSIVE = new Image(Constants.class.getResourceAsStream("hero-passive.png"));
        HERO_IMAGE_DOWN = new Image(Constants.class.getResourceAsStream("hero-down-gif.gif"));

        HERO_IMAGE_LEFT = new Image(Constants.class.getResourceAsStream("Hero-left-gif.gif"));
       // HERO_IMAGE_RIGHT = new Image(Constants.class.getResourceAsStream("Hero-right.png"));
        HERO_IMAGE_RIGHT = new Image(Constants.class.getResourceAsStream("Hero-right-gif.gif"));
        HERO_IMAGE_UP = new Image(Constants.class.getResourceAsStream("Hero-up-gif.gif"));
        BRICK_IMAGE = new Image(Constants.class.getResourceAsStream("brick.png"));
        BLOCK_IMAGE = new Image(Constants.class.getResourceAsStream("block.png"));
        BOMB_IMAGE = new Image(Constants.class.getResourceAsStream("bomb.png"));
        EXPLOSION_IMAGE = new Image(Constants.class.getResourceAsStream("explosion.png"));
        DOORS_IMAGE = new Image(Constants.class.getResourceAsStream("Door.jpg"));

        BALLOON_IMAGE = new Image(Constants.class.getResourceAsStream("balloon.png"));
    //    DOORS_IMAGE = new Image(Constants.class.getResourceAsStream("doors.png"));
    }
}
