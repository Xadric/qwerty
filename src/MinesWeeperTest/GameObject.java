package MinesWeeperTest;

public class GameObject {
    public int x;
    public int y;
    public int minesInRadius;
    public boolean isMine;



    public GameObject(int x, int y, boolean isMine,int minesInRadius) {
        this.x = x;
        this.y = y;
        this.isMine = isMine;
        this.minesInRadius = minesInRadius;
    }
}
