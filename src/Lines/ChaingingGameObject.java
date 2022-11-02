package Lines;

public class ChaingingGameObject {
    public int x;
    public int y;
    public boolean isMarked=false;

    public void chainge(int x, int y, boolean isMarked) {
        this.x = x;
        this.y = y;
        this.isMarked = isMarked;
    }

    public void unMark() {
        isMarked = false;
    }
}
