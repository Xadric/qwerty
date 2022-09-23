import com.cs.engine.cell.Color;
import com.cs.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesWeeper extends Game {

    private static final int SIDE=10;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
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
                    list = getNighbours(gameField[1][1]);
                }

            }
        }
        System.out.println(countMinesOnField);


    }

    private List<GameObject> getNighbours(GameObject gameObject) {
        int x = gameObject.x;
        int y = gameObject.y;
        List<GameObject> listIn=new ArrayList<>();
        listIn.add(gameField[x-1][y+1]); //todo get neighbours
        return listIn;
    }
}
