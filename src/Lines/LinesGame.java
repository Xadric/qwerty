package Lines;

import com.cs.engine.cell.Color;
import com.cs.engine.cell.Game;
import com.cs.engine.cell.Key;

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
            if (checkRoad(chaingingGameObject.x,chaingingGameObject.y,x,y)){
                gameField[x][y].ballColor = gameField[chaingingGameObject.x][chaingingGameObject.y].ballColor;
                gameField[chaingingGameObject.x][chaingingGameObject.y].ballColor = Color.NONE;
                chaingingGameObject.unMark();
                createBalls();
                drawScreen();
            }
        } else if (gameField[x][y].ballColor != Color.NONE) {
            chaingingGameObject.chainge(x, y, true);
            drawScreen();
            setCellValueEx(x, y, Color.BLACK, "\u26AB", gameField[x][y].ballColor, 75);

        }
        checkLine(x, y);


    }

    private boolean checkRoad(int x, int y, int x1, int y1) {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j <SIDE; j++) {
                gameField[i][j].isChecked =false;
            }
        }
        System.out.println("gygu");
        if (hasRoad(x, y, x1, y1)) {
            System.out.println("yes");
            return true;
        }else {
            System.out.println("no");
            return false;
        }
    }

    private boolean hasRoad(int x0, int y0, int x1, int y1) {
        boolean f = true;
        System.out.println(" "+x0+" "+y0+" "+x1+" "+y1);
        gameField[x0][y0].isChecked =true;
        if (x0==x1 && y0==y1){
            return true;
        } else{
            f=false;
            if (x0+1<SIDE && gameField[x0 + 1][y0].ballColor == Color.NONE && !gameField[x0+1][y0].isChecked)
                if (hasRoad(x0 + 1, y0, x1, y1))  f=true;

            if (y0+1<SIDE && gameField[x0][y0+ 1].ballColor == Color.NONE && !gameField[x0][y0+1].isChecked)
                if (hasRoad(x0, y0 + 1, x1, y1))  f=true;

            if (x0-1>=0 &&gameField[x0 - 1][y0].ballColor == Color.NONE && !gameField[x0-1][y0].isChecked)
                if (hasRoad(x0 - 1, y0, x1, y1))  f=true;

            if (y0-1>=0 && gameField[x0][y0- 1].ballColor == Color.NONE && !gameField[x0][y0-1].isChecked)
                if (hasRoad(x0, y0 - 1, x1, y1))  f=true;
        }

        return f;
    }

    private void checkLine(int x, int y) {
        int sum;
        for (int i = 0; i < SIDE - 4; i++) {
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
            for (int j = 0; j < SIDE - 4; j++) {
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

    @Override
    public void onKeyPress(Key key) {
        if (key==Key.SPACE)createGame();
    }
}
