package juegobola;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public final class Bola extends Actor {
    private int radio=0;
    public Clip colision;
    static String son;
    private static String sonido ;
    private Clip uh;
    
    
    
        public double angulo(int x1, int x2,int y1,int y2){
      return Math.toDegrees( Math.atan(y2-y1/x2-x1));
  }
    public boolean colision(Model m){
        int X= (this.x)-max( m.racketa.x,min(this.x, m.racketa.x+ m.racketa.getWeight()));
        int Y=(this.y)-max( m.racketa.y,min(this.y, m.racketa.y+ m.racketa.getHeight()));
        if((X*X+Y*Y)<(radio*radio)){
            
        }
        return (X*X+Y*Y)<(radio*radio);
    }
    void puntaje(Model m){
        for(int veces=0;veces<m.bola.size();veces++){
         if((m.bola.get(veces).y>=m.lineas[0].x2&&m.bola.get(veces).y<m.lineas[1].x2)||(m.bola.get(veces).y>=m.lineas[6].x2&&m.bola.get(veces).y<=m.lineas[7].x2)){
            if(m.bola.get(veces).x>=m.lineas[8].x1&&m.bola.get(veces).x<=m.lineas[9].x1){
               
                m.puntaje--;
        }
        }else
        for(int i=0;i<7;i++){
            if(m.bola.get(veces).y>=m.lineas[i].x2&&m.bola.get(veces).y<m.lineas[i+1].x2){
           
                if (!esPar(i)){
                  
                     m.puntaje--;
                }else{
                    
                      m.puntaje++;
                }
            }
        }
        }
        
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
       
        return ( (distancia+2*radio) >= (r1 + r2));
       }
    @Override
     public void move(Model m){//para configurar el rebote tengo que parase un model por parametro y utilizar los datos de la raqueta
       //rebote con la raqueta
    double puntoCentroX=m.marco.x+m.marco.getRadio();
    double puntoCentroY= m.marco.y+m.marco.getRadio();
    
       if(colision(m)){
           //deltaX=deltaX*-1;
            deltaY=deltaY*-1;
       }
       if(colisionCC(m)){
          uh.setFramePosition(0);
          uh.start();
          uh.setFramePosition(0);
          puntaje(m);
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
        x=x+deltaX;
        y=y+deltaY;
    
       /*if((deltaX+x)>(m.rectangulo.getW()-radio+ m.rectangulo.x)){
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
            
       }*/
      
            
     }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public Bola(int X, int Y, int deltax, int deltay, int Radio, String Col) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(X,Y,deltax,deltay, Col);
        setRadio(Radio);
        sonido="media/pop.wav";
       uh=this.loadSound(sonido);
        
        
        
    
    }
    
    Clip loadSound(String Path) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
       
        try{
           File file= new File(Path);
          AudioInputStream audioInputStream=AudioSystem.getAudioInputStream(file);
           AudioFormat soundFormat= audioInputStream.getFormat();
           int soundSize=(int)(soundFormat.getFrameSize()*audioInputStream.getFrameLength());
           byte[] soundData= new byte[soundSize];
           DataLine.Info soundInfo= new DataLine.Info(Clip.class, soundFormat, soundSize);
           audioInputStream.read(soundData,0,soundSize);
           Clip clip=(Clip)AudioSystem.getLine(soundInfo);
           clip.open(soundFormat,soundData,0 ,soundSize);
           return clip;
           
           
            
        }catch(IOException | LineUnavailableException | UnsupportedAudioFileException e){
            return null;
        }
    }
    private boolean esPar(int i) {
        return i%2==0;
    }
     
    
}
