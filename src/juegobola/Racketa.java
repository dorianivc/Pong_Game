
package juegobola;


public class Racketa extends Actor {
    private int height=0;
    private int weight=0;
    
    public void move(){
        if(x<2){
            deltaX=(deltaX*-1);
        }
        if(x>=510){
            deltaX=(deltaX*-1);
        }
        if((x+deltaX)>510){
            int dif= (x+deltaX)-510;
            x=dif+x;
        }  else if((x+deltaX)<=2){
            int dif=2-(x+deltaX);
            int val=(x+deltaX)+dif;
            x=val;
            deltaX =(deltaX*-1);
        }
        else{
            x=(x+deltaX);
        }/*
        if(y>399){
            deltaY=deltaY*-1;
        }
        if((y+deltaY)>=399){
            int dif=(y+deltaY)-399;
            y=y+dif;
            deltaY=deltaY*-1;
        }else{
            y=y+deltaY;
        }*/
        
    }
    Racketa(int x, int y, int deltaX, int deltaY, String color, int height, int weight){
        super(x,y,deltaX,deltaY, color);
        this.height=height;
        this.weight=weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
