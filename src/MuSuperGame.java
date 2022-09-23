import com.cs.engine.cell.Color;
import com.cs.engine.cell.Game;

public class MuSuperGame extends Game {

    public void initialize() {
        setScreenSize(3,4);
        Fill();

    }

    private void Fill() {
        setCellValueEx(0,0, Color.GREEN,"",Color.ORANGE);
        setCellValueEx(1,1, Color.GREEN,"",Color.ORANGE);
        setCellValueEx(1,0, Color.GREEN,"",Color.ORANGE);
        setCellValueEx(0,1, Color.GREEN,"",Color.ORANGE);
        setCellValueEx(2,0, Color.GREEN,"",Color.ORANGE);
        setCellValueEx(2,1, Color.GREEN,"",Color.ORANGE);
        setCellValueEx(2,2, Color.GREEN,"",Color.ORANGE);
        setCellValueEx(0,2, Color.GREEN,"",Color.ORANGE);
        setCellValueEx(1,2, Color.GREEN,"",Color.ORANGE);
    }
}
