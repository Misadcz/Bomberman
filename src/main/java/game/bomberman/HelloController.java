package game.bomberman;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

public class HelloController {
    AnimationTimer animationTimer;
    @FXML
    Control control = new Control();

    @FXML
    private Label lives;

    @FXML
    private Label timers;
    @FXML
    private Label score;


    @FXML  Canvas canvas = new Canvas(800,700);
World world;

    public HelloController() {
    }
    public void startGame(Scene scene, FXMLLoader loader) {
        this.world = new World(canvas.getWidth(), canvas.getHeight());

        this.world.setGameListener(new GameListenerImpl());

        animationTimer = new AnimationTimer() {
            private Long previous;

            @Override
            public void handle(long now) {

                if (previous == null) {
                    previous = now;
                } else {
                   // scene.setOnKeyPressed( e -> keyPressed(e) );

                    drawScene((now - previous)/1e9,scene);
                    previous = now;
                }
            }
        };

        animationTimer.start();
    }
    private void drawScene(double deltaT,Scene scene) {


        world.draw(canvas,scene);
        world.simulate(deltaT,scene);
    }

    private void lifehit() {
        world.lifehit();
    }





    public void stopGame() {
        animationTimer.stop();
    }


    private class GameListenerImpl implements GameListener {

        @Override
        public void stateChanged(int lives, int timers,int score) {
           HelloController.this.lives.setText("" + lives);
            HelloController.this.timers.setText("" + timers);
            HelloController.this.score.setText("" + score);
        }

        @Override
        public void gameOver() {
            stopGame();
        }

    }






}