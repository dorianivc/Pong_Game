
package juegobola;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class Model extends Observable{
    static final int  ARR=2;
    static final int DER= 3;
    static final int ABJ=-2;
    static final int IZQ=-3;
   public ArrayList<Bola> bola;    
   public Racketa racketa;
   public Rectangulo rectangulo;
   public MarcoRedondo marco;
   public Linea[] lineas;
   public ArrayList<Linea> zonas;
   public int puntaje;
   public Integer bolas=1;
   public Model() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
       //this.bola=new Bola(323,360,20,20,20,"black");
       bola= new ArrayList<>();
       marco= new MarcoRedondo();
       lineas= new Linea[10];
       zonas= new ArrayList<>();
       puntaje=0;
       this.bola.add(new Bola(marco.x+marco.getRadio(),marco.y+marco.getRadio(),20,20,20,"black"));
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
       
       int ejeX11= ejeX1;
       ejeX11= ejeX11-45;
       int ejeX12=45;
       zonas.add( new Linea(ejeX11, ejeY5, ejeX11, ejeY6));
       zonas.add( new Linea(ejeX12, ejeY5, ejeX12, ejeY6));
       zonas.add( new Linea(ejeX1, ejeY5, ejeX1,ejeY));
       zonas.add( new Linea(ejeX12-25, ejeY5, ejeX12-25,ejeY));
       zonas.add( new Linea(ejeX1,ejeY, ejeX1, ejeY2));
       zonas.add( new Linea(ejeX12-25,ejeY, ejeX12-25, ejeY2));
      
       zonas.add( new Linea(ejeX1-40, ejeY2, ejeX1-40, ejeY3));
       zonas.add( new Linea(ejeX12, ejeY2, ejeX12, ejeY3));
       
       
       zonas.add( new Linea(ejeX1-55, ejeY3, ejeX1-55, ejeY4));
       zonas.add( new Linea(ejeX12+55, ejeY3, ejeX12+55, ejeY4));
       
       zonas.add( new Linea(270, 60, 375, 60));
       int ejeY22= 650;
       zonas.add( new Linea(270, ejeY4+45, 375, ejeY4+45));
       
       
       
   }

    public MarcoRedondo getMarco() {
        return marco;
    }

    public void setMarco(MarcoRedondo marco) {
        this.marco = marco;
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

    public ArrayList<Bola> getBola() {
        return bola;
    }

    public void setBola(ArrayList<Bola> bola) {
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
    for(int i=0;i<bola.size();i++){
         bola.get(i).move(this);
    }
   
    this.setChanged();
    this.notifyObservers();
}
void agregarBolas() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
    int i= (int) (Math.random() * 150) + 1;
    bola.add(new Bola(marco.x+marco.getRadio()+i,marco.y+marco.getRadio()+i,20,20,20,"black"));
    this.bolas++;
}
void eliminarBolas(){
    if(bola.size()>=1){
        bola.remove((bola.size()-1));
    }
    this.bolas--;
}

   @Override
   public void addObserver(java.util.Observer O){
    super.addObserver(O);
    setChanged();
    notifyObservers();
}



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

