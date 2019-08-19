package juegobola;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
public final class Bola extends Actor {
    private int radio=0;
    
    public boolean colision(Model m){
        int X= (this.x)-max( m.racketa.x,min(this.x, m.racketa.x+ m.racketa.getWeight()));
        int Y=(this.y)-max( m.racketa.y,min(this.y, m.racketa.y+ m.racketa.getHeight()));
        if((X*X+Y*Y)<(radio*radio)){
            System.out.println("Valor X "+ X);
            System.out.println("Valor Y "+ Y);
        }
        return (X*X+Y*Y)<(radio*radio);
    }
    public boolean colisionCC(Model m){
        int ax=this.x;
        int bx=323;
        int ay=this.y;
        int by=360;
        int r1=radio;
        int r2=m.marco.getRadio();
        double distancia;
        distancia = Math.sqrt((ax-bx)*(ax-bx) + (ay-by)*(ay-by));
       // System.out.println("Distancia: "+ distancia);
        //System.out.println("Suma de Radios: "+ (r1 + r2));
        return ( (distancia+2*radio) >= (r1 + r2));
       }
    @Override
     public void move(Model m){//para configurar el rebote tengo que parase un model por parametro y utilizar los datos de la raqueta
       //rebote con la raqueta
        //System.out.println("Valor X Racketa"+ m.racketa.x);
        //System.out.println("Valor Y Racketa "+ m.racketa.y);
       if(colision(m)){
           //deltaX=deltaX*-1;
            deltaY=deltaY*-1;
       }
       if(colisionCC(m)){
          // System.out.println("COlision CC");
           deltaY=deltaY*-1;
           deltaX=deltaX*-1;
          /* setDeltaX(0);
           setDeltaY(0);
           System.out.println("Valor X Bola= "+ x);
           System.out.println("Valor Y Bola= "+ y);
           System.out.println("Valor X Marco= "+ m.marco.x);
           System.out.println("Valor Y Marco= "+ m.marco.y);*/
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
