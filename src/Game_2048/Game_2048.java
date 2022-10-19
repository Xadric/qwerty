package Game_2048;

import com.cs.engine.cell.Color;
import com.cs.engine.cell.Game;

public class Game_2048 extends Game {
    private static final int SIZE = 4;
    private int[][] gameField;

    public void initialize() {
        setScreenSize(SIZE, SIZE);
        CreateGame();
        /*
        int k=2;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gameField[i][j]=k;
                k*=2;
            }
        }*/

        drawScreen();
    }

    private void drawScreen() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (gameField[i][j] == 0) {
                    setCellValueEx(i, j, Color.LIGHTGRAY, "");
                } else {
                    setCellColoredNumber(i, j, gameField[i][j]);
                }
            }
        }
    }

    private void setCellColoredNumber(int x, int y, int cellValue) {
        setCellValueEx(x, y, getColorByValue(cellValue), "" + cellValue);
    }

    private Color getColorByValue(int cellValue) {
        Color color = switch (cellValue) {
            case 2 -> Color.RED;
            case 4 -> Color.ORANGE;
            case 8 -> Color.YELLOW;
            case 16 -> Color.GREEN;
            case 32 -> Color.AQUA;
            case 64 -> Color.BLUE;
            case 128 -> Color.PURPLE;
            case 256 -> Color.DARKRED;
            case 512 -> Color.DARKORANGE;
            case 1024 -> Color.GOLD;
            case 2048 -> Color.DARKGREEN;
            default -> Color.LIGHTGRAY;
        };
        return color;
    }

    private void CreateGame() {
        gameField = new int[SIZE][SIZE];
        createNewNumer();
        createNewNumer();
    }

    private void createNewNumer() {
        int x = getRandomNumber(SIZE);
        int y = getRandomNumber(SIZE);
        while (gameField[x][y] !=0) {
            x = getRandomNumber(SIZE);
            y = getRandomNumber(SIZE);
        }
        if (getRandomNumber(10)==1) {
            gameField[x][y] = 4;
        }else gameField[x][y] = 2;
    }
}
