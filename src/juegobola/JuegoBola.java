package juegobola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.net.*;
import java.io.*;


public class JuegoBola {

     
     
      
       public static void main(String[] args) throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException {    
     
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
