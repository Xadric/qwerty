package Game_2048;

import com.cs.engine.cell.Color;
import com.cs.engine.cell.Game;
import com.cs.engine.cell.Key;

public class Game_2048 extends Game {
    private static final int SIZE = 4;
    private int[][] gameField;
    private int score;

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
        score=0;
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

    @Override
    public void onKeyPress(Key key) {
        switch (key){
            case UP :
                moveUp();
                drawScreen();
                break;
            case DOWN:
                moveDown();
                drawScreen();
                break;
            case LEFT:
                moveLeft();
                drawScreen();
                break;
            case RIGHT:
                moveRight();
                drawScreen();
                break;
            default:drawScreen();

        }

    }

    private void moveRight() {
        boolean move = false;
        for (int i = 0; i < SIZE ; i++) {
            boolean m = mergeRow(i,2);
            boolean c = compressRow(i,2);
            if(c || m)move=true;
        }
        if (move)createNewNumer();
    }


    private void moveLeft() {
        boolean move = false;
        for (int i = 0; i < SIZE; i++) {
            boolean m = mergeRow(i,1);
            boolean c = compressRow(i,1);
            if(c || m)move=true;
        }
        if (move) createNewNumer();
    }



    private void moveDown() {
        boolean move = false;
        for (int i = 0; i < SIZE; i++) {
            boolean m = mergeCol(i,2);
            boolean c = compressCol(i,2);
            if(c || m)move=true;
        }
       if (move)createNewNumer();
    }

    private void moveUp() {
        boolean move = false;
        for (int i = 0; i < SIZE; i++) {
            boolean m = mergeCol(i,1);
            boolean c = compressCol(i,1);
            if(c || m)move=true;
        }
        if (move)createNewNumer();
    }

    private boolean mergeCol(int i, int k) {
        boolean f=false;
        if (k==1)
            for (int j = 0; j < SIZE - 1; j++) {
                if (gameField[i][j]==gameField[i][j+1] && gameField[i][j]!=0){
                    gameField[i][j]=gameField[i][j]+gameField[i][j+1];
                    gameField[i][j+1]=0;
                    score+=gameField[i][j];
                    setScore(score);
                    f=true;
                }
            }
        else
            for (int j = 1; j < SIZE; j++) {
                if (gameField[i][j] == gameField[i][j- 1] && gameField[i][j] != 0) {
                    gameField[i][j] = gameField[i][j] + gameField[i][j - 1];
                    gameField[i][j - 1] = 0;
                    score += gameField[i][j];
                    setScore(score);
                    f = true;
                }
            }

        return f;
    }

    private boolean compressCol(int i, int k) {
        boolean f=false;
        if (k==1)
            for (int j = 1; j < SIZE; j++) {
                if(gameField[i][j]!=0){
                    int t = j;
                    f=true;
                    while (t!=0&&gameField[i][t-1]==0){
                        gameField[i][t-1]=gameField[i][t];
                        gameField[i][t]=0;
                        t--;
                    }
                }
            }
        else{
            for (int j = 0; j < SIZE-1; j++) {
                if(gameField[i][j]!=0){
                    int t = j;
                    f=true;
                    while (t!=SIZE-1&&gameField[i][t+1]==0){
                        gameField[i][t+1]=gameField[i][t];
                        gameField[i][t]=0;
                        t++;
                    }
                }
            }
        }
        return f;
    }

    private boolean compressRow(int j, int k) {
        boolean f=false;
        if (k==1)
        for (int i = 1; i < SIZE; i++) {
            if(gameField[i][j]!=0){
                int t = i;
                f=true;
                while (t!=0&&gameField[t-1][j]==0){
                    gameField[t-1][j]=gameField[t][j];
                    gameField[t][j]=0;
                    t--;
                }
            }
        }
        else{
            for (int i = 0; i < SIZE-1; i++) {
                if(gameField[i][j]!=0){
                    int t = i;
                    f=true;
                    while (t!=SIZE-1&&gameField[t+1][j]==0){
                        gameField[t+1][j]=gameField[t][j];
                        gameField[t][j]=0;
                        t++;
                    }
                }
            }
        }
        return f;
    }

    private boolean mergeRow(int j, int k) {
        boolean f=false;
        if (k==1)
        for (int i = 0; i < SIZE - 1; i++) {
            if (gameField[i][j]==gameField[i+1][j] && gameField[i][j]!=0){
                gameField[i][j]=gameField[i][j]+gameField[i+1][j];
                gameField[i+1][j]=0;
                score+=gameField[i][j];
                setScore(score);
                f=true;
            }
        }
        else
            for (int i = 1; i < SIZE; i++) {
                if (gameField[i][j] == gameField[i - 1][j] && gameField[i][j] != 0) {
                    gameField[i][j] = gameField[i][j] + gameField[i - 1][j];
                    gameField[i - 1][j] = 0;
                    score += gameField[i][j];
                    setScore(score);
                    f = true;
                }
            }

        return f;
    }

}
