package MinesWeeperTest;

import com.cs.engine.cell.Color;
import com.cs.engine.cell.Game;

import java.util.concurrent.TimeUnit;


public class MinesWeeper extends Game {

    private static final int SIDE=10;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
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
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <=y+1; j++) {
                if ( !(i==x && j==y) && i>=0 && j>=0 && i<SIDE && j<SIDE && gameField[i][j].isMine){
                    gameField[x][y].minesInRadius++;
                }
            }

        }

    }





    public void onMouseLeftClick(int x, int y) {
        if (gameField[x][y].isMine){
            setCellColor(x,y,Color.DARKRED);
            setCellValue(x,y,MINE);
//            try {
//                TimeUnit.SECONDS.wait(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            createGame();
        }else {
            setCellValueEx(x,y,Color.BLUE, String.valueOf(gameField[x][y].minesInRadius),Color.RED);

        }
    }


    public void onMouseRightClick(int x, int y) {
       setCellValueEx(x,y,Color.ORANGE,FLAG);
    }
}
