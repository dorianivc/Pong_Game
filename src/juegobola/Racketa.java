
package juegobola;


public class Racketa extends Actor {
    private int height=0;
    private int weight=0;
    
    @Override
    public void move(Model m){
        if(deltaX+x>m.rectangulo.getW()-weight+m.rectangulo.getX()){
            deltaX=(deltaX*-1);
            
        }else if(deltaX+x<m.rectangulo.getX()){
            deltaX=(deltaX*-1);
              
        }else{
            x=x+deltaX;
        }
        y=deltaY+y;
        
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
