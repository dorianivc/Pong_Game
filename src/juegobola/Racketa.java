
package juegobola;


public class Racketa extends Actor {
    private int height=0;
    private int weight=0;
    
    public void move(){
        if(x<=2){
            deltaX=30;
        }
        if(x>=510){
            deltaX=(deltaX*-1);
        }
        x=x+deltaX;
        y=y+deltaY;
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
