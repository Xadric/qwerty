package MinesWeeper;

import com.cs.engine.cell.Color;
import com.cs.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesWeeper extends Game {

    private static final int SIDE = 10;
    private int countClosedTiles = SIDE * SIDE;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags = 0;
    private boolean isGameStoped = false;
    List<GameObject> list = new ArrayList<>();

    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();

    }

    private void createGame() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                setCellValueEx(j, i, Color.LIGHTGRAY, "");
                gameField[i][j] = new GameObject(j, i, getRandomNumber(10) == 0);
                if (gameField[i][j].isMine) {
                    countMinesOnField++;
                    list = getNighbours(gameField[1][1], 1, 1);
                }

            }
        }
        countMineNeighbours();
        countFlags = countMinesOnField;
        setScore(countMinesOnField);


    }

    private void countMineNeighbours() {
        List<GameObject> list = new ArrayList();
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (!gameField[i][j].isMine) {
                    list = getNighbours(gameField[i][j], i, j);
                    for (GameObject o : list) {
                        if (o.isMine) {
                            gameField[i][j].countMineNeighbours++;
                        }
                    }
                }
            }
        }
    }

    private List<GameObject> getNighbours(GameObject gameObject, int x, int y) {

        List<GameObject> listIn = new ArrayList<>();
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (!(i == x && j == y) && i >= 0 && j >= 0 && i < SIDE && j < SIDE) {
                    listIn.add(gameField[i][j]);
                }
            }

        }

        return listIn;
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        openTile(x, y);
    }


    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);



    }

    private void markTile(int x, int y) {
        if (!gameField[x][y].isOpen && !isGameStoped) {
            if (gameField[x][y].isFlag) {
                countFlags++;
                gameField[x][y].isFlag = false;
                setCellValueEx(x, y, Color.LIGHTGRAY, "");
            } else if (countFlags > 0) {
                countFlags--;
                gameField[x][y].isFlag = true;
                setCellValueEx(x, y, Color.ORANGE, FLAG);
            }
            setScore(countFlags);

        }
    }

    private void openTile(int x, int y) {
        if (!gameField[x][y].isOpen && !isGameStoped && !gameField[x][y].isFlag) {
            gameField[x][y].isOpen = true;
            countClosedTiles--;
            if (gameField[x][y].isMine) {
                setCellValueEx(x, y, Color.FIREBRICK, MINE);
                gameOver();
            } else {
                if (gameField[x][y].countMineNeighbours != 0) {
                    setCellValueEx(x, y, Color.BLUE, String.valueOf(gameField[x][y].countMineNeighbours));
                } else {
                    for (int i = x - 1; i <= x + 1; i++) {
                        for (int j = y - 1; j <= y + 1; j++) {
                            if (!(i == x && j == y) && i >= 0 && j >= 0 && i < SIDE && j < SIDE) {
                                setCellValueEx(x, y, Color.AQUA, String.valueOf(gameField[x][y].countMineNeighbours));
                                openTile(i, j);
                            }
                        }

                    }
                }
                if (countClosedTiles==countMinesOnField-1){
                    win();
                }
            }
        }
    }

    private void win() {
        isGameStoped = true;
        showMessageDialog(Color.DARKBLUE, "YOU WIN!!!", Color.RED, 40);

        restart();
    }

    private void gameOver() {
        isGameStoped = true;
        showMessageDialog(Color.DARKBLUE, "Game over", Color.RED, 40);

        restart();
    }

    private void restart() {
        gameField = new GameObject[SIDE][SIDE];
        countMinesOnField = 0;
        countFlags = 0;
        isGameStoped = false;
        List<GameObject> list = new ArrayList<>();


        createGame();
    }
}
