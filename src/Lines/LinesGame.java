package Lines;

import com.cs.engine.cell.Color;
import com.cs.engine.cell.Game;

public class LinesGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private ChaingingGameObject chaingingGameObject = new ChaingingGameObject();

    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                setCellValueEx(j, i, Color.LIGHTGRAY, "");
                gameField[i][j] = new GameObject(Color.NONE);


            }
        }
        createBalls();
        drawScreen();
    }

    private void createBalls() {
        createNewBall();
        createNewBall();
        createNewBall();
    }

    private void createNewBall() {
        int x = getRandomNumber(SIDE);
        int y = getRandomNumber(SIDE);
        while (gameField[x][y].ballColor != Color.NONE) {
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        }

        int randomNumber = getRandomNumber(4);
        if (randomNumber == 0) {
            gameField[x][y].ballColor = Color.RED;
        } else if (randomNumber == 1) {
            gameField[x][y].ballColor = Color.YELLOW;
        } else if (randomNumber == 2) {
            gameField[x][y].ballColor = Color.GREEN;
        } else if (randomNumber == 3) {
            gameField[x][y].ballColor = Color.BLUE;
        } else if (randomNumber == 4) {
            gameField[x][y].ballColor = Color.FUCHSIA;
        }
    }

    private void drawScreen() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[i][j].ballColor == Color.NONE) {
                    setCellValueEx(i, j, Color.LIGHTGRAY, "");
                } else {
                    setCellValueEx(i, j, Color.LIGHTGRAY, "\u26AB", gameField[i][j].ballColor, 75);
                }
            }
        }
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        super.onMouseLeftClick(x, y);

        if (gameField[x][y].ballColor == Color.NONE && chaingingGameObject.isMarked) {
            gameField[x][y].ballColor = gameField[chaingingGameObject.x][chaingingGameObject.y].ballColor;
            gameField[chaingingGameObject.x][chaingingGameObject.y].ballColor = Color.NONE;
            chaingingGameObject.unMark();
            createBalls();
            drawScreen();
        } else if (gameField[x][y].ballColor != Color.NONE) {
            chaingingGameObject.chainge(x, y, true);
            drawScreen();
            setCellValueEx(x, y, Color.BLACK, "\u26AB", gameField[x][y].ballColor, 75);

        }
        checkLine(x, y);


    }

    private void checkLine(int x, int y) {
        int sum;
        for (int i = 0; i < SIDE - 5; i++) {
            for (int j = 0; j < SIDE; j++) {
                sum = 0;
                for (int k = 0; k < 5; k++) {
                    if (gameField[i + k][j].ballColor == gameField[i][j].ballColor && gameField[i][j].ballColor != Color.NONE) {
                        sum++;
                    }
                }
                if (sum >= 5) {
                    System.out.println("utfou " + sum + " " + i + " " + j);
                    for (int k = 0; k < sum; k++){
                        gameField[i + k][j].ballColor=Color.NONE;

                    }
                    drawScreen();
                }
            }
        }

        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE - 5; j++) {
                sum = 0;
                for (int k = 0; k < 5; k++) {
                    if (gameField[i][j + k].ballColor == gameField[i][j].ballColor && gameField[i][j].ballColor != Color.NONE) {
                        sum++;
                    }
                }
                if (sum >= 5) {
                    for (int k = 0; k < sum; k++){
                        gameField[i][j + k].ballColor=Color.NONE;

                    }
                    drawScreen();
                }
            }

        }
        for (int i = 0; i < SIDE-5; i++) {
            for (int j = 0; j < SIDE - 5; j++) {
                sum = 0;
                for (int k = 0; k < 5; k++) {
                    if (gameField[i+k][j + k].ballColor == gameField[i][j].ballColor && gameField[i][j].ballColor != Color.NONE) {
                        sum++;
                    }
                }
                if (sum >= 5) {
                    for (int k = 0; k < sum; k++){
                        gameField[i+k][j + k].ballColor=Color.NONE;

                    }
                    drawScreen();
                }
            }
        }


    }


}
