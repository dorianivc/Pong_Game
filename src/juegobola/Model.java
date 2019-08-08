
package juegobola;

import java.util.Observable;
public class Model extends Observable{
       
   public Racketa racketa;
   public Bola bola;
   public Rectangulo rectangulo;
   
   public Model(){
       this.bola=new Bola(20,50,20,20,20,"black");
       this.racketa=new Racketa(500,400,15,15,"red",10,100);
       this.rectangulo= new Rectangulo(20,50,610,400);
   }

    public Racketa getRacketa() {
        return racketa;
    }

    public void setRacketa(Racketa racketa) {
        this.racketa = racketa;
    }

    public Bola getBola() {
        return bola;
    }

    public void setBola(Bola bola) {
        this.bola = bola;
    }

    public Rectangulo getRectangulo() {
        return rectangulo;
    }

    public void setRectangulo(Rectangulo rectangulo) {
        this.rectangulo = rectangulo;
    }
   
public void step(){
    racketa.move();
    bola.move();
    this.setChanged();
    this.notifyObservers();
}

   @Override
   public void addObserver(java.util.Observer O){
    super.addObserver(O);
    setChanged();
    notifyObservers();
}


}

