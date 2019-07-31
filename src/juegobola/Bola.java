package juegobola;

public class Bola {
     int x=0;
     int y=0;
     int deltaX=0;
     int radio=2;
     int deltaY=0;

     public void move(Rectangulo b){
        if(x>=590){
            deltaX=(deltaX*-1);
        }
        if(y>=380){
            deltaY=(deltaY*-1);
        }
        if(x<=20){
            deltaX=10;
        }
        if(y<=20){
            deltaY=10;
        }
         x=x+deltaX;
         y=y+deltaY;
     }
     
     
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }

    public Bola(int X, int Y, int deltax, int deltay, int Radio) {
        x=X;
        y=Y;
        deltaX=deltax;
        deltaY=deltay;
        radio=Radio;
    }
     
    
}
