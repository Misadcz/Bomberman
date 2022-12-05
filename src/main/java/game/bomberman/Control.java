package game.bomberman;


import javafx.scene.Scene;

public class Control {
    public boolean left;
    public boolean right;
    public boolean up;
    public boolean down;
    public boolean move;
    public boolean bomb;

    Control()
    {
        left=false;
        right=false;
        up=false;
        down=false;
    }


    public void handle(Scene scene) {

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {

                case KP_UP, UP : up = true;
                break;
                case KP_DOWN, DOWN : down = true;
                    break;
                case KP_LEFT, LEFT : left = true;
                    break;
                case KP_RIGHT, RIGHT : right = true;
                    break;
                case SPACE : bomb = true;
                break;
            }
            if (up || down || left || right) {
                move = true;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case KP_UP, UP -> up = false;
                case KP_DOWN, DOWN -> down = false;
                case KP_LEFT, LEFT -> left = false;
                case KP_RIGHT, RIGHT -> right = false;
                case SPACE -> bomb = false;
            }
            if (!up && !down && !left && !right) {
                move = false;
            }
        });


    }
}