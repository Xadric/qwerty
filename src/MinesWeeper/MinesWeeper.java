package MinesWeeper;

import com.cs.engine.cell.Color;
import com.cs.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesWeeper extends Game {

    private static final int SIDE=10;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags=0;
    List<GameObject> list= new ArrayList<>();

    public void initialize() {
        setScreenSize(SIDE,SIDE);
        createGame();

    }

    private void createGame() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                setCellValueEx(j,i, Color.LIGHTGRAY,"");
                gameField[i][j]=new GameObject(j,i,getRandomNumber(10)==0);
                if (gameField[i][j].isMine){
                    countMinesOnField++;
                    list = getNighbours(gameField[1][1],1,1);
                }

            }
        }
        countMineNeighbours();
        countFlags=countMinesOnField;
        System.out.println(countMinesOnField);


    }

    private void countMineNeighbours() {
        List<GameObject> list = new ArrayList();
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (!gameField[i][j].isMine){
                    list=getNighbours(gameField[i][j],i,j);
                    for (GameObject o : list) {
                        if (o.isMine){
                            gameField[i][j].countMineNeighbours++;
                        }
                    }
                }
            }
        }
    }

    private List<GameObject> getNighbours(GameObject gameObject, int x , int y) {

        List<GameObject> listIn=new ArrayList<>();
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <=y+1; j++) {
                if ( i!=x && j!=y && i>=0 && j>=0 && i<SIDE && j<SIDE ){
                    listIn.add(gameField[i][j]);
                }
            }

        }

        return listIn;
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
       openTitle(x,y);
    }



    @Override
    public void onMouseRightClick(int x, int y) {
            markTitle(x,y);


    }

    private void markTitle(int x, int y) {
        if (gameField[x][y].isFlag){
        countFlags++;
        gameField[x][y].isFlag=false;
        setCellValueEx(x, y, Color.LIGHTGRAY, "");
    }else
        if (countFlags > 0) {
            countFlags--;
            gameField[x][y].isFlag=true;
            setCellValueEx(x, y, Color.ORANGE, FLAG);
        }
        setScore(countFlags);

    }

    private void openTitle(int x, int y) {
        setCellValueEx(x,y,Color.YELLOW,MINE);
    }
}
