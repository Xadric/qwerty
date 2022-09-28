package X_O_Game;

import com.cs.engine.cell.Color;
import com.cs.engine.cell.Game ;

public class X_O_Game extends Game {
    public boolean f=true;
    public int xScore;
    public int yScore;

    public void initialize() {
        setScreenSize(3,5);
        Fill();
    }

    public void onMouseLeftClick(int x, int y) {
        if (f){
            XButton(x,y);
            f=false;
        }else {OButton(x,y); f=true;}
    }

    public void XButton(int x, int y) {
        setCellValueEx(x,y,Color.RED,"X",Color.BLACK);
        if (x==0 && getCellColor(x+1, y)==Color.RED && getCellColor(x+2, y)==Color.RED){

                Fill();
            Win('X');


        }else if (x==1 && getCellColor(x-1, y)==Color.RED && getCellColor(x+1, y)==Color.RED){
                Fill();
            Win('X');


        }else if (x==2 && getCellColor(x-2, y)==Color.RED && getCellColor(x-1, y)==Color.RED){
                Fill();
            Win('X');

        }


        else if (y==0 && getCellColor(x, y+1)==Color.RED && getCellColor(x, y+2)==Color.RED){
                Fill();
            Win('X');

        }else if (y==1 && getCellColor(x, y-1)==Color.RED && getCellColor(x, y+1)==Color.RED){
                Fill();
            Win('X');

        }else if (y==2 && getCellColor(x, y-2)==Color.RED && getCellColor(x, y-1)==Color.RED){
                Fill();
            Win('X');

        }

        else if (getCellColor(0, 0)==Color.RED && getCellColor(1, 1)==Color.RED && getCellColor(2, 2)==Color.RED){
            Fill();
            Win('X');

        }else if (getCellColor(2, 0)==Color.RED && getCellColor(1, 1)==Color.RED && getCellColor(0, 2)==Color.RED){
            Fill();
            Win('X');

        }

    }
    public void OButton(int x, int y) {
        setCellValueEx(x,y,Color.BLUE,"O",Color.BLACK);
        if (x==0 && getCellColor(x+1, y)==Color.BLUE && getCellColor(x+2, y)==Color.BLUE){
                Fill();
            Win('O');

        }else if (x==1 && getCellColor(x-1, y)==Color.BLUE && getCellColor(x+1, y)==Color.BLUE){
                Fill();
            Win('O');

        }else if (x==2 && getCellColor(x-2, y)==Color.BLUE && getCellColor(x-1, y)==Color.BLUE){
                Fill();
            Win('O');

        }

        else if (y==0 && getCellColor(x, y+1)==Color.BLUE && getCellColor(x, y+2)==Color.BLUE){
            Fill();
            Win('O');

        }else if (y==1 && getCellColor(x, y-1)==Color.BLUE && getCellColor(x, y+1)==Color.BLUE){
            Fill();
            Win('O');

        }else if (y==2 && getCellColor(x, y-2)==Color.BLUE && getCellColor(x, y-1)==Color.BLUE){
            Fill();
            Win('O');

        }

        else if (getCellColor(0, 0)==Color.BLUE && getCellColor(1, 1)==Color.BLUE && getCellColor(2, 2)==Color.BLUE){
            Fill();
            Win('O');
        }else if (getCellColor(2, 0)==Color.BLUE && getCellColor(1, 1)==Color.BLUE && getCellColor(0, 2)==Color.BLUE){
            Fill();
            Win('O');

        }

    }

    public void Win(char c){
        if (c=='X'){
            setCellValueEx(0,3,Color.RED,"X",Color.AQUA);
            setCellValueEx(1,3,Color.RED,"",Color.AQUA);
            setCellValueEx(2,3,Color.RED,"WON",Color.AQUA);
            xScore=xScore+1;
            setCellValueEx(0,4,Color.YELLOW, String.valueOf(xScore),Color.FIREBRICK);
            setCellValueEx(1,4,Color.YELLOW,"",Color.FIREBRICK);
            setCellValueEx(2,4,Color.YELLOW, String.valueOf(yScore),Color.FIREBRICK);
        }else{
            setCellValueEx(0,3,Color.BLUE,"O",Color.AQUA);
            setCellValueEx(1,3,Color.BLUE,"",Color.AQUA);
            setCellValueEx(2,3,Color.BLUE,"WON",Color.AQUA);
            yScore=yScore+1;
            setCellValueEx(0,4,Color.YELLOW, String.valueOf(xScore),Color.FIREBRICK);
            setCellValueEx(1,4,Color.YELLOW,"",Color.FIREBRICK);
            setCellValueEx(2,4,Color.YELLOW, String.valueOf(yScore),Color.FIREBRICK);
        }
    }
    public void Fill(){
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

