package Snake;

import com.cs.engine.cell.Color;
import com.cs.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    List<GameObject> snakeParts;
    private static final String HEAD_SING = "\uD83D\uDC7E";
    private static final String BODY_SING = "\u26AB";
    public boolean isAlive = true;
    public Direction direction = Direction.LEFT;


    public Snake(int x, int y) {
        snakeParts = new ArrayList<>();
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }

    public void draw(Game game) {
        Color snakeColor = Color.YELLOW;
        if (!isAlive) {
            snakeColor = Color.RED;
        }
        for (int i = 1; i < snakeParts.size(); i++) {
            game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SING, snakeColor, 75);

        }
        game.setCellValueEx(snakeParts.get(0).x, snakeParts.get(0).y, Color.NONE, HEAD_SING, snakeColor, 75);
    }

    public void move(Apple apple) {

        GameObject head = createNewHead();
        if (head.x < 0 || head.y < 0 || head.x > SnakeGame.WIDTH - 1 || head.y > SnakeGame.HEIGHT - 1) {
            isAlive = false;

        } else if (checkCollision(head)) {
            isAlive=false;
        } else if (head.x == apple.x && head.y == apple.y) {
            apple.isAlive = false;
            snakeParts.add(0, head);


        } else {
            snakeParts.add(0, head);
            snakeParts.remove(snakeParts.size() - 1);
        }
    }

    private GameObject createNewHead() {
        int headX = snakeParts.get(0).x;
        int headY = snakeParts.get(0).y;
        if (direction == Direction.LEFT) return new GameObject(headX - 1, headY);
        else if (direction == Direction.RIGHT) return new GameObject(headX + 1, headY);
        else if (direction == Direction.UP) return new GameObject(headX, headY - 1);
        else if (direction == Direction.DOWN) return new GameObject(headX, headY + 1);
        else return null;
    }

    public void setDirection(Direction direction) {
        switch (this.direction) {
            case LEFT:
            case RIGHT:
                if (snakeParts.get(0).x == snakeParts.get(1).x) return;
                break;

            case UP:
            case DOWN:
                if (snakeParts.get(0).y == snakeParts.get(1).y) return;
                break;
        }
        this.direction = direction;
    }

    public boolean checkCollision(GameObject gameObject) {
        for (GameObject snakePart : snakeParts) {
           if(snakePart.x==gameObject.x && snakePart.y==gameObject.y) {
               return true;
           }
        }
        return false;
    }
}
