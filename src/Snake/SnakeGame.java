package Snake;

import com.cs.engine.cell.Color;
import com.cs.engine.cell.Game;

public class SnakeGame extends Game {

    public static final int WIDTH=15;
    public static final int HEIGHT=15;
    private Apple apple;
    private Snake snake;



    public void initialize() {
        setScreenSize(WIDTH,HEIGHT);
        createGame();
    }

    private void createGame() {
        apple = new Apple(getRandomNumber(WIDTH),getRandomNumber(HEIGHT));
        snake = new Snake(WIDTH/2,HEIGHT/2);
        drawScene();

    }

    private void drawScene() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellColor(i,j, Color.SEAGREEN);
                setCellValue(i,j,"");
            }
        }
        apple.draw(this);
        snake.draw(this);
        System.out.println(snake.direction);
        snake.setDirection(Direction.UP);
        System.out.println(snake.direction);
    }
}
