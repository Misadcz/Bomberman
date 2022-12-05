package game.bomberman;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Random;

public class World {

    private GameListener gameListener = new EmptyGameListener();


    private int lives = 3;
    private int timers = 200;
    private int score = 0;

    private double width;
    private int wait_to_explode =0;
    private int limit = 1;
    private int bombCount;
    private int tick = 500;
    int posX = -200;
    int posY = 50;
    private int explosion = 1;

    private double height;

    private DrawableSimulable player;
    private DrawableSimulable []blocks;
    private DrawableSimulable []balloons;
    private DrawableSimulable []explosions;
    private GraphicsContext gcc;

    private DrawableSimulable []bombs;
    private DrawableSimulable door;

    private int brick_count=0;
    private int block_count=0;
    private int ticking = 500;


    public World(double width, double height) {

        super();
        this.width = width;
        this.height = height;
        bombs = new DrawableSimulable[100];
        blocks = new DrawableSimulable[200];
        balloons = new DrawableSimulable[100];
        explosions = new DrawableSimulable[100];


        for (int i = 0; i < 8; i++) {
            posX += 100;
            posY = 25;
            for (int j = 0; j < 5; j++) {
                posY += 100;
                blocks[j + i * 5] = new Block(this, new Point2D(posX, posY), new Point2D(50, 50));
                block_count++;
            }
        }



        posX = 0;
        posY = 25;
        for (int j = 0; j < 16; j++) {
            blocks[j + block_count] = new Block(this, new Point2D(posX, posY), new Point2D(50, 50));
            posX += 50;
        }
        block_count += 16;
        posY = 75;
        posX = 0;
        for (int j = 0; j < 12; j++) {
            blocks[j + block_count] = new Block(this, new Point2D(posX, posY), new Point2D(50, 50));
            posY += 50;
        }
        block_count += 12;
        posX = 50;
        posY = 625;
        for (int j = 0; j < 14; j++) {
            blocks[j + block_count] = new Block(this, new Point2D(posX, posY), new Point2D(50, 50));
            posX += 50;
        }
        block_count += 14;
        posY = 75;
        posX = 750;
        for (int j = 0; j < 12; j++) {
            blocks[j + block_count] = new Block(this, new Point2D(posX, posY), new Point2D(50, 50));
            posY += 50;
        }

        block_count += 12;
        posX = 700;
        posY = 575;
        Random rand = new Random();
        int rand_bricks = rand.nextInt(14) + 1;
        for (int i = 0; i < rand_bricks; i++) {
            posY = 575;
            int rand_x = rand.nextInt(14) + 1;
            blocks[i + block_count] = new Brick(this, new Point2D(rand_x * 50, posY));

        }
        block_count += rand_bricks;
        rand_bricks = rand.nextInt(14) + 1;
        for (int i = 0; i < rand_bricks; i++) {
            posY = 475;
            int rand_x = rand.nextInt(144) + 1;
            blocks[i + block_count] = new Brick(this, new Point2D(rand_x * 50, posY));

        }
        block_count += rand_bricks;
        rand_bricks = rand.nextInt(14) + 1;
        for (int i = 0; i < rand_bricks; i++) {
            posY = 375;
            int rand_x = rand.nextInt(14) + 1;
            blocks[i + block_count] = new Brick(this, new Point2D(rand_x * 50, posY));

        }
        block_count += rand_bricks;

        rand_bricks = rand.nextInt(14) + 1;
        for (int i = 0; i < rand_bricks; i++) {
            posY = 275;
            int rand_x = rand.nextInt(14) + 1;
            blocks[i + block_count] = new Brick(this, new Point2D(rand_x * 50, posY));

        }
        block_count += rand_bricks;

        rand_bricks = rand.nextInt(14) + 1;
        for (int i = 0; i < rand_bricks; i++) {
            posY = 175;
            int rand_x = rand.nextInt(14) + 1;
            blocks[i + block_count] = new Brick(this, new Point2D(rand_x * 50, posY));

        }
        block_count += rand_bricks;

        rand_bricks = rand.nextInt(14) + 1;
        for (int i = 0; i < rand_bricks; i++) {
            posY = 75;
            int rand_x = rand.nextInt(14) + 1;
            blocks[i + block_count] = new Brick(this, new Point2D(rand_x * 50, posY));

        }
        block_count += rand_bricks;

        int rand_balloon = rand.nextInt(3) + 4;
        for (int i = 0; i < rand_balloon; i++) {
            posY = 75;
            int rand_x = rand.nextInt(15) + 1;
            int rand_y = rand.nextInt(11) + 1;
            balloons[i] = new Balloon(this, new Point2D(rand_x * 50, rand_y * 50 + 25), new Point2D(50, 50));
            Point2D tester = new Point2D(rand_x * 50,rand_y * 50 + 25);
            for(DrawableSimulable bl : blocks)
            {
                if(bl!=null)
                if(bl.getPosition().equals(tester))
                {  i--;
                    break;
                }
            }


        }

        int can_spawn=0;

        do {

            int rand_x = rand.nextInt(15) + 1;
            int rand_y = rand.nextInt(11) + 1;
            Point2D tester = new Point2D(rand_x * 50, rand_y * 50 + 25);
            player = new Hero(this,tester);
            can_spawn = 1;
            for (int i = 0; i < 100; i++) {
                if(blocks[i]!= null)
                {
                if (player.getPosition().equals(blocks[i].getPosition())) {
                    can_spawn = 0;

                }
            }}
        }while(can_spawn == 0);

        // count++;
        int random_door = rand.nextInt(10);
        int door_counter = 0;

    int block_counter = 0;
        for (DrawableSimulable block : blocks) {
            if (block instanceof Brick)
            {
                door_counter++;
                if(door_counter==random_door)
                    door = new Door(this, new Point2D(blocks[random_door+block_counter].getPosition().getX(), blocks[random_door+block_counter].getPosition().getY()));
            }
            else
            {
                block_counter++;
            }
        }
        if(door==null)
            door = new Door(this, new Point2D(blocks[0].getPosition().getX(), blocks[0].getPosition().getY()));





    }

    public void draw(Canvas canvas,Scene scene) {

     GraphicsContext gc = canvas.getGraphicsContext2D();
        gcc = gc;
        door.draw(gc,scene);
     gc.setFill(Color.GREEN);
     gc.fillRect(0,0,1000,800);



        for(int i = 0 ; i < 200 ; i++) {

            if (blocks[i] != null)
            {
                blocks[i].draw(gc,scene);
            }
        }
        for(int i = 0 ; i < 100 ; i++) {
            if (balloons[i] != null) {
                balloons[i].draw(gc, scene);
            }
        }
        player.draw(gc,scene);

        for(int i = 0 ; i < 100 ; i++) {
            if (bombs[i] != null) {
                bombs[i].draw(gc, scene);
            }
        }

        for(int i = 0 ; i < 100 ; i++) {
            if (explosions[i] != null) {
                explosions[i].draw(gc, scene);
            }
        }


    }


    public void simulate(double deltaT, Scene scene ) {
        Point2D temp;
        door.simulate(deltaT,scene);
        for (int i = 0; i < 100; i++) {
            if (bombs[i] != null) {
                bombs[i].simulate(deltaT, scene);
            }
        }

        player.simulate(deltaT, scene);
        for (int i = 0; i < 200; i++) {
            if (blocks[i] != null) {
                blocks[i].simulate(deltaT, scene);


                Rectangle2D block_temp = new Rectangle2D(blocks[i].getPosition().getX(), blocks[i].getPosition().getY(), 45, 45);


                Rectangle2D hero = new Rectangle2D(player.getPosition().getX() + 5, player.getPosition().getY(), 45, 45);

                if (hero.intersects(block_temp)) {
                    ((Hero) player).move_left();
                }
                hero = new Rectangle2D(player.getPosition().getX() - 5, player.getPosition().getY(), 45, 45);
                if (hero.intersects(block_temp)) {
                    ((Hero) player).move_right();
                }

                hero = new Rectangle2D(player.getPosition().getX(), player.getPosition().getY() + 5, 45, 45);
                if (hero.intersects(block_temp)) {
                    ((Hero) player).move_down();
                }

                hero = new Rectangle2D(player.getPosition().getX(), player.getPosition().getY() - 5, 45, 45);
                if (hero.intersects(block_temp)) {
                    ((Hero) player).move_up();
                }


                boolean result = ((Hero) player).canPlant();
                if (result == true && tick > 500 && bombCount < limit) {
                    //System.out.println("PLANTUJU");
                    bombs[0] = new Bomb(this, new Point2D(player.getPosition().getX()+5 - ((player.getPosition().getX()) % 50), player.getPosition().getY() - (player.getPosition().getY() % 50) + 25));

                    bombCount++;
                    tick = 0;
                    wait_to_explode = 0;
                    explosion = 1;
                }


            }
        }

        tick++;


        if (explosion == 1)
            wait_to_explode++;
        if (explosion == -1)
            wait_to_explode++;


        if (wait_to_explode >= 200) {
            for (int i = 0; i < 100; i++) {
                if (bombs[i] != null) {

                    explosions[0] = new Explosion(this, new Point2D(bombs[i].getPosition().getX() - (bombs[i].getPosition().getX() % 50), bombs[i].getPosition().getY() - (bombs[i].getPosition().getY() % 50) + 25));
                    explosions[ 1] = new Explosion(this, new Point2D(bombs[i].getPosition().getX() - (bombs[i].getPosition().getX() % 50) + 50, bombs[i].getPosition().getY() - (bombs[i].getPosition().getY() % 50) + 25));
                    explosions[ 2] = new Explosion(this, new Point2D(bombs[i].getPosition().getX() - (bombs[i].getPosition().getX() % 50) - 50, bombs[i].getPosition().getY() - (bombs[i].getPosition().getY() % 50) + 25));
                    explosions[ 3] = new Explosion(this, new Point2D(bombs[i].getPosition().getX() - (bombs[i].getPosition().getX() % 50), bombs[i].getPosition().getY() - (bombs[i].getPosition().getY() % 50) + 75));
                    explosions[ 4] = new Explosion(this, new Point2D(bombs[i].getPosition().getX() - (bombs[i].getPosition().getX() % 50), bombs[i].getPosition().getY() - (bombs[i].getPosition().getY() % 50) - 25));
                    bombs[i] = null;
                    explosion = -1;
                    wait_to_explode = 0;
                }
            }

        }

    int blocked[]= {0,0,0,0,0};
        if (explosion == -1 && wait_to_explode > 200) {
            for (int i = 0; i < 200; i++) {
                        if (blocks[i] != null && blocks[i] instanceof Brick) {
                            Point2D br_pos = blocks[i].getPosition();
                           Rectangle2D temp_brick = new Rectangle2D(br_pos.getX(), br_pos.getY(), 50, 50);
                           //1
                           if(explosions[0]!= null)
                           {
                               Point2D ex_pos = explosions[0].getPosition();
                               Rectangle2D explos = new Rectangle2D(ex_pos.getX(), ex_pos.getY(), 50, 50);


                            if (temp_brick.intersects(explos)&& blocked[0] != 1) {
                                blocks[i] = null;
                                blocked[0] = 1;
                                explosions[0] = null;
                            }
                           }
//2
                            if(explosions[1]!= null)
                            {
                                Point2D ex_pos = explosions[1].getPosition();
                                Rectangle2D explos = new Rectangle2D(ex_pos.getX(), ex_pos.getY(), 50, 50);


                                if (temp_brick.intersects(explos)&& blocked[1] != 1) {
                                    blocks[i] = null;
                                    blocked[1] = 1;
                                    explosions[1] = null;
                                }
                            }
//3
                            if(explosions[2]!= null)
                            {
                                Point2D ex_pos = explosions[2].getPosition();
                                Rectangle2D explos = new Rectangle2D(ex_pos.getX(), ex_pos.getY(), 50, 50);


                                if (temp_brick.intersects(explos)&& blocked[2] != 1) {
                                    blocks[i] = null;
                                    blocked[2] = 1;
                                    explosions[2] = null;
                                }
                            }
//4
                            if(explosions[3]!= null)
                            {
                                Point2D ex_pos = explosions[3].getPosition();
                                Rectangle2D explos = new Rectangle2D(ex_pos.getX(), ex_pos.getY(), 50, 50);


                                if (temp_brick.intersects(explos)&& blocked[3] != 1) {
                                    blocks[i] = null;
                                    blocked[3] = 1;
                                    explosions[3] = null;
                                }
                            }
                            //5
                            if(explosions[4]!= null)
                            {
                                Point2D ex_pos = explosions[4].getPosition();
                                Rectangle2D explos = new Rectangle2D(ex_pos.getX(), ex_pos.getY(), 50, 50);


                                if (temp_brick.intersects(explos)&& blocked[4] != 1) {
                                    blocks[i] = null;
                                    blocked[4] = 1;
                                    explosions[4] = null;
                                }
                            }



                        }

            }
            for(int i = 0 ; i < 5 ; i++)
            {
                if(explosions[i]!= null)
                {explosions[i] = null;}
            }
            explosion = 0;
            wait_to_explode = 0;
            bombCount = 0;
        }




            for (int i = 0; i < 200; i++) {
                if (blocks[i] != null) {
                    {



                        for (int j = 0; j < 20; j++) {
                            if (balloons[j] != null) {


                                Rectangle2D block_temp = new Rectangle2D(blocks[i].getPosition().getX(), blocks[i].getPosition().getY(), 45, 45);
                                Rectangle2D balloon = new Rectangle2D(balloons[j].getPosition().getX() + 5, balloons[j].getPosition().getY(), 45, 45);

                                if (block_temp.intersects(balloon)) {
                                   // ((Balloon) balloons[j]).change_to_down();
                                   ((Balloon) balloons[j]).change_to_left();
                                }
                                balloon = new Rectangle2D(balloons[j].getPosition().getX() - 5, balloons[j].getPosition().getY(), 45, 45);
                                if (block_temp.intersects(balloon)) {

                                    //    ((Balloon) balloons[j]).change_to_up();
                                    ((Balloon) balloons[j]).change_to_right();
                                }

                                balloon = new Rectangle2D(balloons[j].getPosition().getX(), balloons[j].getPosition().getY() + 5, 45, 45);
                                if (block_temp.intersects(balloon)) {
                                   //     ((Balloon) balloons[j]).change_to_right();
                                    ((Balloon) balloons[j]).change_to_down();
                                }

                                balloon = new Rectangle2D(balloons[j].getPosition().getX(), balloons[j].getPosition().getY() - 5, 45, 45);
                                if (block_temp.intersects(balloon)) {
                                      //  ((Balloon) balloons[j]).change_to_left();
                                        ((Balloon) balloons[j]).change_to_up();
                                }


                            }
                        }
                    }
                }

        }


            for(int i = 0 ; i < 100 ; i++)
                if(balloons[i]!=null)
                {
                    balloons[i].simulate(deltaT,scene);
                }


        if(ticking > 150)
        {lifehit();ticking = 0;}
    ticking ++;

        int exists = 0;
        int balls_count=0;

        for(DrawableSimulable ball : balloons)
        {
            balls_count++;
        }

        for(int i= 0 ; i < balls_count ; i++)
        {
            if(balloons[i] !=null)
            {
                exists = 1;

            }
        }
        if(exists == 0)
       {
           if(door!= null && player != null) {
               Rectangle2D door_temp = new Rectangle2D(door.getPosition().getX(), door.getPosition().getY(), 45, 45);

                Rectangle2D hero = new Rectangle2D(player.getPosition().getX(), player.getPosition().getY(), 45, 45);

                if (hero.intersects(door_temp)) {
                    won_layer();
                    gameListener.gameOver();
                }
           }
        }



        for(int i = 0 ; i < 100 ; i++)
        {
            if(balloons[i] != null)
            {
               for(int j = 0 ; j < 10 ; j++)
               {
                   if(explosions[j]!= null)
                   {
                       if(balloons[i] != null)
                       {
                       Rectangle2D baloon_temp = new Rectangle2D(balloons[i].getPosition().getX(), balloons[i].getPosition().getY(), 45, 45);

                       Rectangle2D explo = new Rectangle2D(explosions[j].getPosition().getX(), explosions[j].getPosition().getY(), 45, 45);

                       if (explo.intersects(baloon_temp)) {
                           balloons[i] = null;
                           score+=100;
                       }
                   }}
               }

            }
        }







    }



    public void setGameListener(GameListener gameListenerImpl) {
        this.gameListener = gameListenerImpl;

    }




    public Point2D getCanvasPoint(Point2D worldPoint) {
        return new Point2D(worldPoint.getX(), height - worldPoint.getY());
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void lifehit()  {
        int last_life = lives;

        for(DrawableSimulable ball : balloons)
        {
            if(ball != null)
            {
                Rectangle2D ball_temp = new Rectangle2D(ball.getPosition().getX(), ball.getPosition().getY(), 45, 45);

                Rectangle2D hero = new Rectangle2D(player.getPosition().getX(), player.getPosition().getY(), 45, 45);

                if (hero.intersects(ball_temp)) {

                    lives--;

                }



            }
        }
        for(int i = 0 ; i < 10 ; i++)
        {
            if(explosions[i] != null)
            {
                Rectangle2D explo_temp = new Rectangle2D(explosions[i].getPosition().getX(), explosions[i].getPosition().getY(), 45, 45);
                Rectangle2D hero = new Rectangle2D(player.getPosition().getX(), player.getPosition().getY(), 45, 45);

                if (hero.intersects(explo_temp)) {

                    lives--;

                }
            }
        }

        timers -=1;

        if(timers < 0)
        { gameOver_layer();}
            gameListener.stateChanged(lives,timers,score);


        if(lives < 1)
        {
            gameOver_layer();

        }
    }

    private void gameOver_layer() {
        gcc.setFill(Color.BLACK);
        gcc.fillRect(0,0,800,700);
        gcc.setStroke(Color.WHITE);
        gcc.setFont(Font.font("verdana"));
        gcc.strokeText("GAME OVER",350,300);
        gameListener.gameOver();
    }


    private void won_layer()
    {
        gcc.setFill(Color.GOLD);
        gcc.fillRect(0,0,800,700);
        gcc.setStroke(Color.ORANGE);
        gcc.setFont(Font.font("verdana"));
        gcc.strokeText("WON",350,300);
        gameListener.gameOver();
    }



}
