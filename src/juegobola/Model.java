
package juegobola;

import java.util.Observable;
public class Model extends Observable{
       
   public Racketa racketa;
   public Bola bola;
   public Rectangulo rectangulo;
   public MarcoRedondo marco;
 

    public MarcoRedondo getMarco() {
        return marco;
    }

    public void setMarco(MarcoRedondo marco) {
        this.marco = marco;
    }
   
   public Model(){
       //this.bola=new Bola(323,360,20,20,20,"black");
       marco= new MarcoRedondo();
       this.bola=new Bola(marco.x+marco.getRadio(),marco.y+marco.getRadio(),20,20,20,"black");
       this.racketa=new Racketa(500,400,15,0,"red",20,120);
       this.rectangulo= new Rectangulo(20,50,601,600);
       
   }
    public void start(){
        final int delay= 20;
        Runnable code = null;
       code = new Runnable(){@Override public void run(){
           while(true){
           step();
           setChanged();
           notifyObservers();
           try {
            Thread.sleep(delay);
                    }
            catch(InterruptedException ex) {
 
                }
                   
                   
          }
           }
       };
       Thread thread = new Thread(code);
       thread.start();
    }
                 
    public Racketa getRacketa() {
        return racketa;
    }
public void move(int flecha){
    switch(flecha){
        case ARR: racketa.setDeltaY(-15);break;
        case ABJ: racketa.setDeltaY(15);break;
        case IZQ: racketa.setDeltaX(-15);break;
        case DER: racketa.setDeltaX(15);break;
    }
}
public void stopVertical(){
    racketa.setDeltaY(0);
}
public void stopHorizontal(){
     racketa.setDeltaX(0);
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
    racketa.move(this);
    bola.move(this);
    this.setChanged();
    this.notifyObservers();
}

   @Override
   public void addObserver(java.util.Observer O){
    super.addObserver(O);
    setChanged();
    notifyObservers();
}

   static final int  ARR=2;
   static final int DER= 3;
   static final int ABJ=-2;
   static final int IZQ=-3;


    public int getARR() {
        return ARR;
    }

    public int getDER() {
        return DER;
    }

    public int getABJ() {
        return ABJ;
    }

    public int getIZQ() {
        return IZQ;
    }
 

}

