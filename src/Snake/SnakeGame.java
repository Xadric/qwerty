package Snake;

import com.cs.engine.cell.Color;
import com.cs.engine.cell.Game;
import com.cs.engine.cell.Key;

public class SnakeGame extends Game {

    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    public static final int GOAL = 15;
    public int turnDelay;
    public int score;
    private Apple apple;
    private Snake snake;

    private boolean isTurnDelayDone = true;


    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        turnDelay = 500;
        score = 0;

        setScore(score);
        apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        drawScene();
        setTurnTimer(turnDelay);


    }

    private void drawScene() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellColor(i, j, Color.SEAGREEN);
                setCellValue(i, j, "");
            }
        }
        if (apple.isAlive) {
            apple.draw(this);
        } else {
            do {
                apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
                apple.draw(this);
                score++;
                setScore(score);
            } while (snake.checkCollision(apple));
        }
    }

    @Override
    public void onTurn(int step) {
        super.onTurn(step);
        if (score== GOAL){
            showMessageDialog(Color.YELLOW, "YOU WIN!!!", Color.RED, 35);
        }else {
            if (snake.isAlive) {
                snake.move(apple);
                if (score % 5 == 0 && score != 0 && turnDelay != 20 && !isTurnDelayDone) {
                    turnDelay -= 20;
                    isTurnDelayDone = true;
                } else if (score % 5 != 0 && isTurnDelayDone) {
                    isTurnDelayDone = false;
                }


                setTurnTimer(turnDelay);
                drawScene();
                snake.draw(this);
            } else {
                showMessageDialog(Color.YELLOW, "Fail", Color.RED, 35);
            }
        }
    }


    @Override
    public void onKeyPress(Key key) {
        if (key == Key.UP) {
            if (snake.direction != Direction.DOWN) snake.setDirection(Direction.UP);
            else snake.isAlive = false;
        } else if (key == Key.DOWN) {
            if (snake.direction != Direction.UP) snake.setDirection(Direction.DOWN);
            else snake.isAlive = false;
        } else if (key == Key.LEFT) {
            if (snake.direction != Direction.RIGHT) snake.setDirection(Direction.LEFT);
            else snake.isAlive = false;
        } else if (key == Key.RIGHT) {
            if (snake.direction != Direction.LEFT) snake.setDirection(Direction.RIGHT);
            else snake.isAlive = false;
        } else if (key == Key.SPACE) {
            createGame();
        }
    }
}
