package MinesWeeperTest;

import com.cs.engine.cell.Color;
import com.cs.engine.cell.Game;



public class MinesWeeper extends Game {

    private static final int SIDE=10;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;

    public void initialize() {
        setScreenSize(SIDE,SIDE);
        createGame();

    }

    private void createGame() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                setCellValueEx(j,i, Color.LIGHTGRAY,"");
                gameField[i][j]=new GameObject(j,i,getRandomNumber(10)==0,0);
                if (gameField[i][j].isMine){
                    countMinesOnField++;

                }

            }
        }
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                getNighbours(i,j);

                if (gameField[i][j].isMine){
                    setCellColor(i,j,Color.SILVER);
                }
            }
        }
        System.out.println(countMinesOnField);


    }

    private void getNighbours(int x ,int y) {
        getNighbour(x,y,        x-1,y+1);
        getNighbour(x,y,        x,y+1);
        getNighbour(x,y,        x+1,y+1);
        getNighbour(x,y,        x+1,y);
        getNighbour(x,y,        x+1,y-1);
        getNighbour(x,y,        x,y-1);
        getNighbour(x,y,        x-1,y-1);
        getNighbour(x,y,        x-1,y);
    }

    private void getNighbour(int x, int y,int xThatChecks, int yThatChecks){
        if (xThatChecks>=0 && yThatChecks>=0 &&xThatChecks<SIDE && yThatChecks<SIDE && gameField[xThatChecks][yThatChecks].isMine){
            gameField[x][y].minesInRadius++;
        }
    }



    public void onMouseLeftClick(int x, int y) {
        if (gameField[x][y].isMine){
            setCellColor(x,y,Color.DARKRED);
            createGame();
        }else {
            setCellValueEx(x,y,Color.BLUE, String.valueOf(gameField[x][y].minesInRadius),Color.RED);

        }
    }


    public void onMouseRightClick(int x, int y) {
       setCellColor(x,y,Color.ORANGE);
    }
}
