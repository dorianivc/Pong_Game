package juegobola;

public final class Bola extends Actor {
    private int radio=0;
    
    /**
     *
     */
    @Override
     public void move(){
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

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public Bola(int X, int Y, int deltax, int deltay, int Radio, String Col) {
        super(X,Y,deltax,deltay, Col);
        setRadio(Radio);
    }
     
    
}
