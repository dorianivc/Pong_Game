
package juegobola;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Controlador {
    Model modelo;
    Vista vista;
    public Controlador(Model m, Vista vi){
        modelo=m;
        vista=vi;
        vista.setControl(this);
        vista.setModelo(m);
    }
    Integer getPuntaje(){
        return modelo.puntaje;
    }
    public void move(int flecha){
       modelo.move(flecha);
    }
    public void stopVertical(){
        modelo.stopVertical();
    }
    public void stopHorizontal(){
        modelo.stopHorizontal();
    }

    void settings(int totalBolas, int parseInt) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    if(totalBolas>0&&totalBolas<=100){   
    if(totalBolas>modelo.bolas){
       int diferencia=totalBolas-modelo.bolas;
         for(int j=0;j<diferencia;j++){
            modelo.agregarBolas();
            vista.repaint();
     }
    }else{
        int diferencia=(totalBolas-modelo.bolas)*-1;
         for(int j=0;j<diferencia;j++){
            modelo.eliminarBolas();
            vista.repaint();
     }
    }
    for(int i=0;i<modelo.bolas;i++){
        modelo.bola.get(i).setDeltaX(parseInt);
           modelo.bola.get(i).setDeltaY(parseInt);
    }
    }
        
    }
    Integer getBolas(){
    return modelo.bolas;
}
    Integer getDiferencial(){
        return -1*modelo.bola.get(0).deltaX;
    }
    void pause() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void activate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
