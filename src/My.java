import com.cs.engine.cell.Color;
import com.cs.engine.cell.Game ;

public class My extends Game {
    public boolean f=true;

    public void initialize() {
        setScreenSize(3,4);
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
                setCellValueEx(0,3,Color.RED,"X",Color.AQUA);
                setCellValueEx(1,3,Color.RED,"",Color.AQUA);
                setCellValueEx(2,3,Color.RED,"WON",Color.AQUA);


        }else if (x==1 && getCellColor(x-1, y)==Color.RED && getCellColor(x+1, y)==Color.RED){
                Fill();
                setCellValueEx(0,3,Color.RED,"X",Color.AQUA);
                setCellValueEx(1,3,Color.RED,"",Color.AQUA);
                setCellValueEx(2,3,Color.RED,"WON",Color.AQUA);


        }else if (x==2 && getCellColor(x-2, y)==Color.RED && getCellColor(x-1, y)==Color.RED){
                Fill();
                setCellValueEx(0,3,Color.RED,"X",Color.AQUA);
                setCellValueEx(1,3,Color.RED,"",Color.AQUA);
                setCellValueEx(2,3,Color.RED,"WON",Color.AQUA);

        }


        else if (y==0 && getCellColor(x, y+1)==Color.RED && getCellColor(x, y+2)==Color.RED){
                Fill();
                setCellValueEx(0,3,Color.RED,"X",Color.AQUA);
                setCellValueEx(1,3,Color.RED,"",Color.AQUA);
                setCellValueEx(2,3,Color.RED,"WON",Color.AQUA);

        }else if (y==1 && getCellColor(x, y-1)==Color.RED && getCellColor(x, y+1)==Color.RED){
                Fill();
                setCellValueEx(0,3,Color.RED,"X",Color.AQUA);
                setCellValueEx(1,3,Color.RED,"",Color.AQUA);
                setCellValueEx(2,3,Color.RED,"WON",Color.AQUA);

        }else if (y==2 && getCellColor(x, y-2)==Color.RED && getCellColor(x, y-1)==Color.RED){
                Fill();
                setCellValueEx(0,3,Color.RED,"X",Color.AQUA);
                setCellValueEx(1,3,Color.RED,"",Color.AQUA);
                setCellValueEx(2,3,Color.RED,"WON",Color.AQUA);

        }

        else if (getCellColor(0, 0)==Color.RED && getCellColor(1, 1)==Color.RED && getCellColor(2, 2)==Color.RED){
            Fill();
            setCellValueEx(0,3,Color.RED,"X",Color.AQUA);
            setCellValueEx(1,3,Color.RED,"",Color.AQUA);
            setCellValueEx(2,3,Color.RED,"WON",Color.AQUA);

        }else if (getCellColor(2, 0)==Color.RED && getCellColor(1, 1)==Color.RED && getCellColor(0, 2)==Color.RED){
            Fill();
            setCellValueEx(0,3,Color.RED,"X",Color.AQUA);
            setCellValueEx(1,3,Color.RED,"",Color.AQUA);
            setCellValueEx(2,3,Color.RED,"WON",Color.AQUA);

        }

    }
    public void OButton(int x, int y) {
        setCellValueEx(x,y,Color.BLUE,"O",Color.BLACK);
        if (x==0 && getCellColor(x+1, y)==Color.BLUE && getCellColor(x+2, y)==Color.BLUE){
                Fill();
                setCellValueEx(0,3,Color.BLUE,"O",Color.AQUA);
                setCellValueEx(1,3,Color.BLUE,"",Color.AQUA);
                setCellValueEx(2,3,Color.BLUE,"WON",Color.AQUA);

        }else if (x==1 && getCellColor(x-1, y)==Color.BLUE && getCellColor(x+1, y)==Color.BLUE){
                Fill();
                setCellValueEx(0,3,Color.BLUE,"O",Color.AQUA);
                setCellValueEx(1,3,Color.BLUE,"",Color.AQUA);
                setCellValueEx(2,3,Color.BLUE,"WON",Color.AQUA);

        }else if (x==2 && getCellColor(x-2, y)==Color.BLUE && getCellColor(x-1, y)==Color.BLUE){
                Fill();
                setCellValueEx(0,3,Color.BLUE,"O",Color.AQUA);
                setCellValueEx(1,3,Color.BLUE,"",Color.AQUA);
                setCellValueEx(2,3,Color.BLUE,"WON",Color.AQUA);

        }

        else if (y==0 && getCellColor(x, y+1)==Color.BLUE && getCellColor(x, y+2)==Color.BLUE){
            Fill();
            setCellValueEx(0,3,Color.BLUE,"O",Color.AQUA);
            setCellValueEx(1,3,Color.BLUE,"",Color.AQUA);
            setCellValueEx(2,3,Color.BLUE,"WON",Color.AQUA);

        }else if (y==1 && getCellColor(x, y-1)==Color.BLUE && getCellColor(x, y+1)==Color.BLUE){
            Fill();
            setCellValueEx(0,3,Color.BLUE,"O",Color.AQUA);
            setCellValueEx(1,3,Color.BLUE,"",Color.AQUA);
            setCellValueEx(2,3,Color.BLUE,"WON",Color.AQUA);

        }else if (y==2 && getCellColor(x, y-2)==Color.BLUE && getCellColor(x, y-1)==Color.BLUE){
            Fill();
            setCellValueEx(0,3,Color.BLUE,"O",Color.AQUA);
            setCellValueEx(1,3,Color.BLUE,"",Color.AQUA);
            setCellValueEx(2,3,Color.BLUE,"WON",Color.AQUA);

        }

        else if (getCellColor(0, 0)==Color.BLUE && getCellColor(1, 1)==Color.BLUE && getCellColor(2, 2)==Color.BLUE){
            Fill();
            setCellValueEx(0,3,Color.BLUE,"O",Color.AQUA);
            setCellValueEx(1,3,Color.BLUE,"",Color.AQUA);
            setCellValueEx(2,3,Color.BLUE,"WON",Color.AQUA);

        }else if (getCellColor(2, 0)==Color.BLUE && getCellColor(1, 1)==Color.BLUE && getCellColor(0, 2)==Color.BLUE){
            Fill();
            setCellValueEx(0,3,Color.BLUE,"O",Color.AQUA);
            setCellValueEx(1,3,Color.BLUE,"",Color.AQUA);
            setCellValueEx(2,3,Color.BLUE,"WON",Color.AQUA);

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

