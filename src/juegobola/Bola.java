package juegobola;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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
    static String son;
    private static String sonido ;
    private int radio=0;
    public Clip colision;
    private Clip uh;
    public Bola(int X, int Y, int deltax, int deltay, int Radio, String Col) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(X,Y,deltax,deltay, Col);
        setRadio(Radio);
        sonido="media/pop.wav";
        uh=this.loadSound(sonido);        
    }    
        public double angulo(int x1, int x2,int y1,int y2){
      return Math.toDegrees( Math.atan(y2-y1/x2-x1));
  }
    public boolean colision(Model m) throws IOException{
        String parametros="raquetaX="+m.racketa.x+"&"+"raquetaY="+m.racketa.y+"&"+"raquetaH="+m.racketa.getHeight()+"&"+"raquetaW="+m.racketa.getWeight()+"&"+"puntoX="+this.x+"&"+"puntoY="+this.y+"&"+"radio="+this.radio;
        String APICALL=this.HttpRequestColisiconRaqueta(parametros);
        //System.out.println("Racket + "+ APICALL );
        if(Integer.parseInt(APICALL)==0){
            return false;
        }else if(Integer.parseInt(APICALL)==1){
            return true;
        }
        return false;
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
    public String HttpRequestColisiconRaqueta(String parameters) throws MalformedURLException, IOException{
         String LINK="http://localhost:7071/api/ColisiconRacketa";
         String append=parameters;
         LINK= LINK+"?"+append;
         //System.out.println(LINK);
         String inputLine="empty";
         try {
           URL API = new URL(LINK);
        URLConnection yc = API.openConnection();
             try (BufferedReader in = new BufferedReader(
                     new InputStreamReader(
                             yc.getInputStream()))) {
                 while ((inputLine = in.readLine()) != null){
                     //System.out.println(inputLine);
                     return inputLine;
                 }
                 in.close();
             }
    }catch(Exception ex){
             System.out.println(ex.getMessage());
    }
        return inputLine;
         
     }
    public String HttpRequestColisiconCC(String parameters) throws MalformedURLException, IOException{
         String LINK="http://localhost:7071/api/ColisicionCC";
         String append=parameters;
         LINK= LINK+"?"+append;
         //System.out.println(LINK);
         String inputLine="empty";
         try {
           URL API = new URL(LINK);
        URLConnection yc = API.openConnection();
             try (BufferedReader in = new BufferedReader(
                     new InputStreamReader(
                             yc.getInputStream()))) {
                 while ((inputLine = in.readLine()) != null){
                     //System.out.println(inputLine);
                     return inputLine;
                 }
                 in.close();
             }
    }catch(Exception ex){
             System.out.println(ex.getMessage());
    }
        return inputLine;
         
     }
    public boolean colisionCC(Model m) throws IOException{
        Integer ax=this.x;
        Integer bx=323;
        Integer ay=this.y;
        Integer by=360;
        Integer r1=radio;
        Integer r2=m.marco.getRadio();
        String parametros="ax="+ax+"&"+"bx="+bx+"&"+"ay="+ay+"&"+"by="+by+"&"+"r1="+r1+"&"+"r2="+r2;
        //System.out.println(parametros);
        String colisionAPICall=this.HttpRequestColisiconCC(parametros);
       // System.out.println("API CALL Circle-Circle + "+ colisionAPICall);
        if(Integer.parseInt(colisionAPICall)==1){
            return true;
        }else if(Integer.parseInt(colisionAPICall)==0){
            return false;
        }
        return false;
    }
    @Override
     public void move(Model m){//para configurar el rebote tengo que parase un model por parametro y utilizar los datos de la raqueta
       //rebote con la raqueta
    double puntoCentroX=m.marco.x+m.marco.getRadio();
    double puntoCentroY= m.marco.y+m.marco.getRadio();
        try {
            if(colision(m)){
                //deltaX=deltaX*-1;
                deltaY=deltaY*-1;
            }} catch (IOException ex) {
            Logger.getLogger(Bola.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(colisionCC(m)){
                uh.setFramePosition(0);
                uh.start();
                uh.setFramePosition(0);
                puntaje(m);
                deltaY=deltaY*-1;
                deltaX=deltaX*-1;
            }} catch (IOException ex) {
            Logger.getLogger(Bola.class.getName()).log(Level.SEVERE, null, ex);
        }
        x=x+deltaX;
        y=y+deltaY;            
     }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
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
