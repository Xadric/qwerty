package Snake;

import com.cs.engine.cell.Color;
import com.cs.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    List<GameObject> snakeParts;
    private static final String HEAD_SING="\uD83D\uDC7E";
    private static final String BODY_SING="\u26AB";
    public boolean isAlive=true;
    public Direction direction=Direction.LEFT;


    public Snake(int x, int y) {
       snakeParts=new ArrayList<>();
       snakeParts.add(new GameObject(x,y));
       snakeParts.add(new GameObject(x+1,y));
       snakeParts.add(new GameObject(x+2,y));
    }

    public void draw(Game game){
        game.setCellValueEx(snakeParts.get(0).x,snakeParts.get(0).y, Color.NONE,HEAD_SING,Color.YELLOW,75);
        for (int i = 1; i < snakeParts.size(); i++) {
            game.setCellValueEx(snakeParts.get(i).x,snakeParts.get(i).y, Color.NONE,BODY_SING,Color.YELLOW,75);

        }
    }

    public void setDirection(Direction direction){
        switch (this.direction){
            case LEFT :
            case RIGHT:if(snakeParts.get(0).x==snakeParts.get(1).x) return;
            break;

            case UP:
            case DOWN:if(snakeParts.get(0).y==snakeParts.get(1).y) return;
                break;
        }
        this.direction=direction;
    }
}
