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
        if(x<=22){
            deltaX=radio+2;
        }
        if(y<=22){
            deltaY=radio+2;
        }
        
        if((y+deltaY)>=380){
            int dif=380-y;
            y=y+dif;
        }else if((y+deltaY)<=21){
            y=radio+2;
        }else {
            y=y+deltaY;
        }
        
        x=x+deltaX;
        
         
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
