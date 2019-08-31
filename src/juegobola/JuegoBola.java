package juegobola;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class JuegoBola {

     
     
      
       public static void main(String[] args) throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException {    
            
       /*    JTextField esferas= new JTextField("1");
        JTextField velocidad= new JTextField("2");
        Object[] message={
            "Esferas: ",esferas, "Velocidad: ", velocidad
        };
        int option=JOptionPane.showConfirmDialog(null, message, "settings",JOptionPane.OK_CANCEL_OPTION);
      */
           Model modelo= new Model();
           Vista vista= new Vista();
           Controlador control= new Controlador(modelo, vista);
           modelo.addObserver(vista);
           vista.setVisible(true);
           int veces=200;
           for(;;){
               
            Thread.sleep(90);
            modelo.step();
          
           }
          
    }
        
    
        
}
