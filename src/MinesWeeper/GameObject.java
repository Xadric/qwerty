package MinesWeeper;

public class GameObject {
    public int x;
    public int y;
    public int countMineNeighbours;
    public boolean isMine;
    public boolean isFlag;
    public boolean isOpen;

    public GameObject(int x, int y, boolean isMine) {
        this.x = x;
        this.y = y;
        this.isMine = isMine;
        this.isOpen = false;
    }
}
