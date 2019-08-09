package juegobola;

public final class Bola extends Actor {
    private int radio=0;
    
    /**
     *
     */
    @Override
     public void move(Model m){//para configurar el rebote tengo que parase un model por parametro y utilizar los datos de la raqueta
       //rebote con la raqueta
      if(y+radio==m.racketa.getY()+ m.racketa.getHeight()){
          if(x+radio>=m.racketa.getX()-(m.racketa.getWeight()/2)&& x+radio<=m.racketa.getX()+m.racketa.getWeight()){
              System.out.println("Rebota");
             
              deltaY=deltaY*-1;
          }
      }  
       if((deltaX+x)>(m.rectangulo.getW()-radio+ m.rectangulo.x)){
           deltaX=(deltaX*-1);
       }else if( (deltaX+x)<radio+m.rectangulo.x){
           deltaX=(deltaX*-1);
       }else {
           x=x+deltaX;
       }
       
        if((deltaY+y)>m.rectangulo.getH()-radio+m.rectangulo.y){
           deltaY=(deltaY*-1);
       }else if( (deltaY+y)<radio+m.rectangulo.y){
           deltaY=(deltaY*-1);
       }else {
           y=y+deltaY;
            
       }
            
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
