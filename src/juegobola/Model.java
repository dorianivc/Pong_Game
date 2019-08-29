
package juegobola;

import java.util.Observable;
public class Model extends Observable{
       
   public Racketa racketa;
   public Bola bola;
   public Rectangulo rectangulo;
   public MarcoRedondo marco;
   public Linea[] lineas;
   public int puntaje;

    public MarcoRedondo getMarco() {
        return marco;
    }

    public void setMarco(MarcoRedondo marco) {
        this.marco = marco;
    }
   
   public Model(){
       //this.bola=new Bola(323,360,20,20,20,"black");
       marco= new MarcoRedondo();
       lineas= new Linea[10];
       puntaje=0;
       this.bola=new Bola(marco.x+marco.getRadio(),marco.y+marco.getRadio(),20,20,20,"black");
       this.racketa=new Racketa(500,400,15,0,"red",20,120);
       this.rectangulo= new Rectangulo(20,50,601,600);
       int ejeY=320;
       int ejeX1=620;
       int ejeX2=20;
       int ejeY2=415;
       int ejeY3=ejeY2+95;
       int ejeY4=ejeY3+95;
       int ejeY5=320-95;
       int ejeY6=ejeY5-95;
       int ejeY7=ejeY6-80;
       lineas[0]=new Linea(ejeX1, ejeY7, ejeX2, ejeY7);
        lineas[1]=new Linea(ejeX1, ejeY6, ejeX2, ejeY6);
       lineas[2]= new Linea(ejeX1, ejeY5, ejeX2, ejeY5);
       lineas[3]= new Linea(ejeX1,ejeY, ejeX2, ejeY);
       lineas[4]=new Linea(ejeX1, ejeY2, ejeX2, ejeY2);
       lineas[5]=new Linea(ejeX1, ejeY3, ejeX2, ejeY3);
       lineas[6]=new Linea(ejeX1, ejeY4, ejeX2, ejeY4);
       lineas[7]= new Linea(ejeX1, ejeY4+45, ejeX2, ejeY4+45);
       lineas[8]=new Linea(270, 50, 270, 650);
       lineas[9]=new Linea(375, 50, 375, 650);
     
       
       
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

