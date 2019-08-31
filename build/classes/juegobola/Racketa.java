
package juegobola;

import static java.lang.Integer.max;
import static java.lang.Integer.min;


public class Racketa extends Actor {
    private int height=0;
    private int weight=0;
    Racketa(int x, int y, int deltaX, int deltaY, String color, int height, int weight){
        super(x,y,deltaX,deltaY, color);
        this.height=height;
        this.weight=weight;
    }
    
    public boolean colisionDer(Model m){
        
        int X= (m.marco.x+m.marco.radio+m.racketa.getWeight())-max( m.racketa.x+(2*m.racketa.getWeight()),min(m.marco.x+m.marco.radio+2*m.racketa.getWeight(), m.racketa.x+ m.racketa.getWeight()));
        int Y=(m.marco.y+m.marco.radio+ m.racketa.getHeight())-max( m.racketa.y+(2*m.racketa.getHeight()),min(m.marco.y+m.marco.radio+2*m.racketa.getHeight(), m.racketa.y+m.racketa.getHeight()));
        
        return (X*X+Y*Y)>(m.marco.radio*m.marco.radio);
    }
    public boolean colisionIzq(Model m){
        
        int X= (m.marco.x+m.marco.radio+2*m.racketa.getWeight())-max( m.racketa.x+(2*m.racketa.getWeight()),min(m.marco.x+m.marco.radio-2*m.racketa.getWeight(), m.racketa.x));
        int Y=(m.marco.y+m.marco.radio+ 2*m.racketa.getHeight())-max( m.racketa.y+(2*m.racketa.getHeight()),min(m.marco.y+m.marco.radio-2*m.racketa.getHeight(), m.racketa.y));
        return (X*X+Y*Y)>(m.marco.radio*m.marco.radio);
    }
    
    @Override
    public void move(Model m){
         if(colisionDer(m)||colisionIzq(m)){
           this.deltaX=deltaX*-1;
           this.deltaY=deltaY*-1;
       }
        
       
       if(deltaX+x>m.rectangulo.getW()-weight+m.rectangulo.getX()){
            deltaX=(deltaX*-1);
            
        }else if(deltaX+x<m.rectangulo.getX()){
            deltaX=(deltaX*-1);
              
        }else{
            x=x+deltaX;
        }
       if((deltaY+y)>m.rectangulo.getH()-height+m.rectangulo.y){
           deltaY=(deltaY*-1);
       }else if( (deltaY+y)<height+m.rectangulo.y){
           deltaY=(deltaY*-1);
       }else {
           y=y+deltaY;
            
     
       }
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
